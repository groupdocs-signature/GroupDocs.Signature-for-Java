package com.groupdocs.ui.signature.service;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.PageInfo;
import com.groupdocs.signature.domain.documentpreview.IDocumentInfo;
import com.groupdocs.signature.exception.IncorrectPasswordException;
import com.groupdocs.signature.internal.c.a.s.InvalidPasswordException;
import com.groupdocs.signature.licensing.License;
import com.groupdocs.signature.options.PageStreamFactory;
import com.groupdocs.signature.options.PreviewFormats;
import com.groupdocs.signature.options.PreviewOptions;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.response.LoadDocumentEntity;
import com.groupdocs.ui.model.response.PageDescriptionEntity;
import com.groupdocs.ui.signature.SignatureConfiguration;
import com.groupdocs.ui.signature.SignatureLoader;
import com.groupdocs.ui.signature.model.request.DeleteSignatureFileRequest;
import com.groupdocs.ui.signature.model.request.LoadSignatureImageRequest;
import com.groupdocs.ui.signature.model.request.SignatureFileTreeRequest;
import com.groupdocs.ui.signature.model.web.SignatureFileDescriptionEntity;
import com.groupdocs.ui.signature.model.web.SignaturePageEntity;
import com.groupdocs.ui.util.directory.SignatureDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.groupdocs.ui.signature.SignatureType.*;
import static com.groupdocs.ui.signature.service.SignatureHandlerFactory.getFullDataPathStr;
import static com.groupdocs.ui.util.Utils.*;
import static com.groupdocs.ui.util.directory.PathConstants.DATA_FOLDER;

@Service
public class SignatureServiceImpl implements SignatureService {

    private static final Logger logger = LoggerFactory.getLogger(SignatureServiceImpl.class);

    public static final String PNG = "png";

    private Signature signatureHandler;

    @Autowired
    private SignatureLoader signatureLoader;

    @Autowired
    private GlobalConfiguration globalConfiguration;

    @Autowired
    private SignatureConfiguration signatureConfiguration;

    /**
     * Initializing fields after creating configuration objects
     */
    @PostConstruct
    public void init() {
        // set GroupDocs license
        try {
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable exc) {
            logger.error("Can not verify Signature license!");
        }

        // check if the data directory is set, if not set a new directory
        String filesDirectory = signatureConfiguration.getFilesDirectory();
        if (StringUtils.isEmpty(signatureConfiguration.getDataDirectory())) {
            signatureConfiguration.setDataDirectory(filesDirectory + DATA_FOLDER);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignatureConfiguration getSignatureConfiguration() {
        return signatureConfiguration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SignatureFileDescriptionEntity> getFileList(SignatureFileTreeRequest fileTreeRequest) {
        // get file list from storage path
        try {
            String signatureType = fileTreeRequest.getSignatureType() == null ? "" : fileTreeRequest.getSignatureType();
            String signatureTypePath = SignatureDirectory.getPathFromSignatureType(signatureType);
            String rootDirectory = StringUtils.isEmpty(signatureTypePath) ?
                    signatureConfiguration.getFilesDirectory() :
                    getFullDataPathStr(signatureConfiguration.getDataDirectory(), signatureTypePath);
            // get all the files from a directory
            String relDirPath = fileTreeRequest.getPath();
            if (StringUtils.isEmpty(relDirPath)) {
                relDirPath = rootDirectory;
            } else {
                relDirPath = String.format("%s%s%s", rootDirectory, File.separator, relDirPath);
            }
            return getFilesList(signatureType, relDirPath);
        } catch (Exception ex) {
            logger.error("Exception occurred while getting file list", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private List<SignatureFileDescriptionEntity> getFilesList(String signatureType, String relDirPath) {
        List<SignatureFileDescriptionEntity> fileList;
        switch (signatureType) {
            case DIGITAL:
                fileList = signatureLoader.loadFiles(relDirPath, signatureConfiguration.getDataDirectory());
                break;
            case IMAGE:
            case HAND:
                fileList = signatureLoader.loadImageSignatures(relDirPath, signatureConfiguration.getDataDirectory());
                break;
            case TEXT:
                fileList = signatureLoader.loadTextSignatures(relDirPath, signatureConfiguration.getDataDirectory());
                break;
            case STAMP:
            case QR_CODE:
            case BAR_CODE:
                fileList = signatureLoader.loadSignatures(relDirPath, signatureConfiguration.getDataDirectory(), signatureType);
                break;
            default:
                fileList = signatureLoader.loadFiles(relDirPath, signatureConfiguration.getDataDirectory());
                break;
        }
        return fileList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoadDocumentEntity getDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        String documentGuid = loadDocumentRequest.getGuid();
        String password = loadDocumentRequest.getPassword();
        try {
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.setPassword(password);
            signatureHandler = new Signature(documentGuid,loadOptions);
            // get document info container
            IDocumentInfo documentDescription = signatureHandler.getDocumentInfo();
            List<PageDescriptionEntity> pagesDescription = new ArrayList<>();
            // get info about each document page
            boolean loadData = signatureConfiguration.getPreloadPageCount() == 0;

            for (PageInfo pageInfo : documentDescription.getPages()) {
                PageDescriptionEntity description = new PageDescriptionEntity();
                // set current page info for result
                description.setHeight(pageInfo.getHeight());
                description.setWidth(pageInfo.getWidth());
                description.setNumber(pageInfo.getPageNumber()+1);
                pagesDescription.add(description);
            }

            if (loadData) {
                PreviewOptions previewOptions = new PreviewOptions(new PageStreamFactory() {
                    @Override
                    public OutputStream createPageStream(int pageNumber) {
                        return new ByteArrayOutputStream();
                    }

                    @Override
                    public void closePageStream(int pageNumber, OutputStream pageStream) {
                        pagesDescription.get(pageNumber).setData(new String(Base64.getEncoder().encode(((ByteArrayOutputStream)pageStream).toByteArray())));
                    }
                });
                previewOptions.setPreviewFormat(PreviewFormats.PNG);
                signatureHandler.generatePreview(previewOptions);
            }

            LoadDocumentEntity loadDocumentEntity = new LoadDocumentEntity();
            loadDocumentEntity.setGuid(loadDocumentRequest.getGuid());
            loadDocumentEntity.setPages(pagesDescription);
            // return document description
            return loadDocumentEntity;
        } catch (IncorrectPasswordException | InvalidPasswordException | com.groupdocs.signature.internal.c.a.pd.exceptions.InvalidPasswordException ex) {
            throw new TotalGroupDocsException(getExceptionMessage(password), ex);
        } catch (Exception ex) {
            logger.error("Exception occurred while loading document description", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        try {
            String documentGuid = loadDocumentPageRequest.getGuid();
            int pageNumber = loadDocumentPageRequest.getPage();
            String password = loadDocumentPageRequest.getPassword();
            // get page data
            PageDescriptionEntity pageDescriptionEntity = getPageDescriptionEntity(documentGuid, password, pageNumber, true);
            // return loaded page object
            return pageDescriptionEntity;
        } catch (Exception ex) {
            logger.error("Exception occurred while loading document page", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private PageDescriptionEntity getPageDescriptionEntity(String documentGuid, String password, int i, boolean withImage) throws Exception {
        PageDescriptionEntity description = new PageDescriptionEntity();
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);
        signatureHandler = new Signature(documentGuid,loadOptions);

        IDocumentInfo docInfo = signatureHandler.getDocumentInfo();
        // get current page size
        description.setHeight(docInfo.getPages().get(i).getHeight());
        description.setWidth(docInfo.getPages().get(i).getWidth());
        description.setNumber(i);
        if (withImage) {
            loadImage(documentGuid, password, i, description);
        }
        return description;
    }

    private void loadImage(String documentGuid, String password, int i, PageDescriptionEntity description) throws Exception {
        //byte[] pageImage = signatureHandler.getPageImage(documentGuid, i, password, null, 100);
        byte[] pageImage = {};
        description.setData(new String(Base64.getEncoder().encode(pageImage)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignatureFileDescriptionEntity uploadDocument(MultipartFile content, String url, Boolean rewrite, String signatureType) {
        // get signatures storage path
        String pathFromSignatureType = signatureType == null ? "" : SignatureDirectory.getPathFromSignatureType(signatureType);
        String documentStoragePath = StringUtils.isEmpty(pathFromSignatureType) ?
                signatureConfiguration.getFilesDirectory() :
                getFullDataPathStr(signatureConfiguration.getDataDirectory(), pathFromSignatureType);
        // save the file
        String filePath = uploadFile(documentStoragePath, content, url, rewrite);
        // create response data
        SignatureFileDescriptionEntity uploadedDocument = new SignatureFileDescriptionEntity();
        uploadedDocument.setGuid(filePath);
        if (IMAGE.equals(signatureType)) {
            // get page image
            try {
                File file = new File(uploadedDocument.getGuid());
                // encode ByteArray into String
                String encodedImage = getStringFromStream(new FileInputStream(file));
                uploadedDocument.setImage(encodedImage);
            } catch (IOException ex) {
                logger.error("Exception occurred read images in document", ex);
                throw new TotalGroupDocsException(ex.getMessage(), ex);
            }
        }
        return uploadedDocument;
    }

    @Override
    public void deleteSignatureFile(DeleteSignatureFileRequest deleteSignatureFileRequest) {
        signatureLoader.deleteSignatureFile(deleteSignatureFileRequest);
    }

    @Override
    public List<String> getFonts() {
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();

        Font[] allFonts = ge.getAllFonts();

        List<String> response = new ArrayList<>(allFonts.length);

        for (Font font : allFonts) {
            response.add(font.getFontName());
        }

        return response;
    }

    @Override
    public SignaturePageEntity loadSignatureImage(LoadSignatureImageRequest loadSignatureImageRequest) {
        return signatureLoader.loadImage(loadSignatureImageRequest);
    }
}
