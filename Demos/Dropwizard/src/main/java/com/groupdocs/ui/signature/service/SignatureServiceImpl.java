package com.groupdocs.ui.signature.service;

import com.aspose.words.IncorrectPasswordException;
import com.groupdocs.signature.domain.DocumentDescription;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.internal.c.a.s.InvalidPasswordException;
import com.groupdocs.signature.licensing.License;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.signature.config.SignatureConfiguration;
import com.groupdocs.ui.signature.entity.request.DeleteSignatureFileRequest;
import com.groupdocs.ui.signature.entity.request.LoadSignatureImageRequest;
import com.groupdocs.ui.signature.entity.request.SignatureFileTreeRequest;
import com.groupdocs.ui.signature.entity.web.SignatureFileDescriptionEntity;
import com.groupdocs.ui.signature.entity.web.SignaturePageEntity;
import com.groupdocs.ui.signature.signatureloader.SignatureLoader;
import com.groupdocs.ui.signature.util.directory.SignatureDirectory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.groupdocs.ui.common.util.Utils.getExceptionMessage;
import static com.groupdocs.ui.signature.service.SignatureHandlerFactory.getFullDataPathStr;
import static com.groupdocs.ui.signature.util.SignatureType.*;
import static com.groupdocs.ui.signature.util.directory.PathConstants.DATA_FOLDER;

public class SignatureServiceImpl implements SignatureService {

    private static final Logger logger = LoggerFactory.getLogger(SignatureServiceImpl.class);

    private SignatureHandler signatureHandler;

    private GlobalConfiguration globalConfiguration;

    private SignatureConfiguration signatureConfiguration;

    private SignatureLoader signatureLoader = new SignatureLoader();

    /**
     * Initializing fields after creating configuration objects
     */
    public SignatureServiceImpl(GlobalConfiguration globalConfiguration) {
        this.globalConfiguration = globalConfiguration;
        this.signatureConfiguration = globalConfiguration.getSignature();
        // set GroupDocs license
        try {
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable exc) {
            logger.error("Can not verify Signature license!");
        }

        // check if data directory is set, if not set new directory
        String filesDirectory = signatureConfiguration.getFilesDirectory();
        if (StringUtils.isEmpty(signatureConfiguration.getDataDirectory())) {
            signatureConfiguration.setDataDirectory(filesDirectory + DATA_FOLDER);
        }
        signatureHandler = SignatureHandlerFactory.createHandler(filesDirectory, signatureConfiguration.getDataDirectory());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SignatureFileDescriptionEntity> getFileList(SignatureFileTreeRequest fileTreeRequest) {
        try {
            String signatureType = fileTreeRequest.getSignatureType() == null ? "" : fileTreeRequest.getSignatureType();
            // get file list from storage path
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
            return loadFiles(signatureType, relDirPath);
        } catch (Exception ex) {
            logger.error("Exception occurred while getting file list", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Load files
     *
     * @param signatureType
     * @param relDirPath
     * @return list of files descriptions
     */
    private List<SignatureFileDescriptionEntity> loadFiles(String signatureType, String relDirPath) {
        List<SignatureFileDescriptionEntity> fileList;
        switch (signatureType) {
            case DIGITAL:
                fileList = signatureLoader.loadFiles(relDirPath, signatureConfiguration.getDataDirectory(), signatureType);
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
                fileList = signatureLoader.loadFiles(relDirPath, signatureConfiguration.getDataDirectory(), signatureType);
                break;
        }
        return fileList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoadDocumentEntity getDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        // get/set parameters
        String documentGuid = loadDocumentRequest.getGuid();
        String password = loadDocumentRequest.getPassword();
        try {
            // get document info container
            DocumentDescription documentDescription = signatureHandler.getDocumentDescription(documentGuid, password);
            List<PageDescriptionEntity> pagesDescription = new ArrayList<>();
            // get info about each document page
            boolean loadData = globalConfiguration.getSignature().getPreloadPageCount() == 0;
            for (int i = 1; i <= documentDescription.getPageCount(); i++) {
                PageDescriptionEntity description = getPageDescriptionEntity(documentGuid, password, i, loadData);
                pagesDescription.add(description);
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
            // get/set parameters
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
        // get current page size
        Dimension pageSize = signatureHandler.getDocumentPageSize(documentGuid, i, password, (double) 0, (double) 0, null);
        // set current page info for result
        description.setHeight(pageSize.getHeight());
        description.setWidth(pageSize.getWidth());
        description.setNumber(i);
        if (withImage) {
            loadImage(documentGuid, password, i, description);
        }
        return description;
    }

    private void loadImage(String documentGuid, String password, int i, PageDescriptionEntity description) throws Exception {
        byte[] pageImage = signatureHandler.getPageImage(documentGuid, i, password, null, 100);
        description.setData(new String(Base64.getEncoder().encode(pageImage)));
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
