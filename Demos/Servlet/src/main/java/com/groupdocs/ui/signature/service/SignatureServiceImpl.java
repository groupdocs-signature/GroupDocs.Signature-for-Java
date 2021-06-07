package com.groupdocs.ui.signature.service;

import com.google.common.collect.Lists;
import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.DocumentDescription;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.licensing.License;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.SignatureOptionsCollection;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;
import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.response.DocumentDescriptionEntity;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import com.groupdocs.ui.model.response.LoadedPageEntity;
import com.groupdocs.ui.signature.config.SignatureConfiguration;
import com.groupdocs.ui.signature.model.SignatureDirectory;
import com.groupdocs.ui.signature.model.request.*;
import com.groupdocs.ui.signature.model.web.SignatureDataEntity;
import com.groupdocs.ui.signature.model.web.SignatureFileDescriptionEntity;
import com.groupdocs.ui.signature.model.web.SignedDocumentEntity;
import com.groupdocs.ui.signature.model.xml.OpticalXmlEntity;
import com.groupdocs.ui.signature.model.xml.StampXmlEntity;
import com.groupdocs.ui.signature.model.xml.StampXmlEntityList;
import com.groupdocs.ui.signature.model.xml.TextXmlEntity;
import com.groupdocs.ui.signature.signer.*;
import com.groupdocs.ui.signature.util.XMLReaderWriter;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import static com.groupdocs.ui.signature.model.SignatureDirectory.*;
import static com.groupdocs.ui.signature.util.PathConstants.DATA_FOLDER;
import static com.groupdocs.ui.signature.util.PathConstants.OUTPUT_FOLDER;
import static com.groupdocs.ui.util.Utils.getFreeFileName;
import static com.groupdocs.ui.util.Utils.uploadFile;

public class SignatureServiceImpl implements SignatureService {

    private static final Logger logger = LoggerFactory.getLogger(SignatureServiceImpl.class);

    private static final List<String> supportedImageFormats = Arrays.asList("bmp", "jpeg", "jpg", "tiff", "tif", "png");

    private SignatureHandler signatureHandler;

    @Inject
    private SignatureLoader signatureLoader;

    @Inject
    private GlobalConfiguration globalConfiguration;

    @Inject
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

        // check if data directory is set, if not set new directory
        if (signatureConfiguration.getDataDirectory() == null || signatureConfiguration.getDataDirectory().isEmpty()) {
            signatureConfiguration.setDataDirectory(signatureConfiguration.getFilesDirectory() + DATA_FOLDER);
        }

        // create directories
        createDirectories();

        // create signature application configuration
        SignatureConfig config = new SignatureConfig();
        config.setStoragePath(signatureConfiguration.getFilesDirectory());
        config.setCertificatesPath(getFullDataPath(CERTIFICATE_DATA_DIRECTORY.getPath()));
        config.setImagesPath(getFullDataPath(IMAGE_DATA_DIRECTORY.getPath()));
        config.setOutputPath(getFullDataPath(OUTPUT_FOLDER));

        // initialize total instance for the Image mode
        signatureHandler = new SignatureHandler(config);
    }

    private void createDirectories() {
        new File(getFullDataPath(CERTIFICATE_DATA_DIRECTORY.getPath())).mkdirs();
        new File(getFullDataPath(IMAGE_DATA_DIRECTORY.getPath())).mkdirs();

        new File(getFullDataPath(STAMP_DATA_DIRECTORY.getXMLPath())).mkdirs();
        new File(getFullDataPath(STAMP_DATA_DIRECTORY.getPreviewPath())).mkdirs();

        new File(getFullDataPath(QRCODE_DATA_DIRECTORY.getXMLPath())).mkdirs();
        new File(getFullDataPath(QRCODE_DATA_DIRECTORY.getPreviewPath())).mkdirs();

        new File(getFullDataPath(BARCODE_DATA_DIRECTORY.getXMLPath())).mkdirs();
        new File(getFullDataPath(BARCODE_DATA_DIRECTORY.getPreviewPath())).mkdirs();

        new File(getFullDataPath(TEXT_DATA_DIRECTORY.getXMLPath())).mkdirs();
        new File(getFullDataPath(TEXT_DATA_DIRECTORY.getPreviewPath())).mkdirs();
    }

    private String getFullDataPath(String partPath) {
        return signatureConfiguration.getDataDirectory() + partPath;
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
                    getFullDataPath(signatureTypePath);
            // get all the files from a directory
            String relDirPath = fileTreeRequest.getPath();
            if (StringUtils.isEmpty(relDirPath)) {
                relDirPath = rootDirectory;
            } else {
                relDirPath = String.format("%s%s%s", rootDirectory, File.separator, relDirPath);
            }
            List<SignatureFileDescriptionEntity> fileList;
            switch (signatureType) {
                case "digital":
                    fileList = signatureLoader.loadFiles(relDirPath, signatureConfiguration.getDataDirectory());
                    break;
                case "image":
                    fileList = signatureLoader.loadImageSignatures(relDirPath, signatureConfiguration.getDataDirectory());
                    break;
                case "stamp":
                    fileList = signatureLoader.loadStampSignatures(relDirPath, signatureConfiguration.getDataDirectory());
                    break;
                case "text":
                    fileList = signatureLoader.loadStampSignatures(relDirPath, signatureConfiguration.getDataDirectory());
                    break;
                default:
                    fileList = signatureLoader.loadFiles(relDirPath, signatureConfiguration.getDataDirectory());
                    break;
            }
            return fileList;
        } catch (Exception ex) {
            logger.error("Exception occurred while getting file list", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentDescriptionEntity> getDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        try {
            // get document info container
            DocumentDescription documentDescription = signatureHandler.getDocumentDescription(loadDocumentRequest.getGuid(),
                    loadDocumentRequest.getPassword());
            List<DocumentDescriptionEntity> pagesDescription = new ArrayList<>();
            // get info about each document page
            for (int i = 1; i <= documentDescription.getPageCount(); i++) {
                //initiate custom Document description object
                DocumentDescriptionEntity description = new DocumentDescriptionEntity();
                // get current page size
                java.awt.Dimension pageSize = signatureHandler.getDocumentPageSize(loadDocumentRequest.getGuid(),
                        i,
                        loadDocumentRequest.getPassword(),
                        0.0,
                        0.0,
                        null);
                // set current page info for result
                description.setHeight(pageSize.getHeight());
                description.setWidth(pageSize.getWidth());
                description.setNumber(i);
                pagesDescription.add(description);
            }
            // return document description
            return pagesDescription;
        } catch (Exception ex) {
            logger.error("Exception occurred while loading document description", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoadedPageEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        try {
            LoadedPageEntity loadedPage = new LoadedPageEntity();
            // get page image
            byte[] bytes = signatureHandler.getPageImage(loadDocumentPageRequest.getGuid(),
                    loadDocumentPageRequest.getPage(),
                    loadDocumentPageRequest.getPassword(),
                    null,
                    100);
            // encode ByteArray into String
            String encodedImage = new String(Base64.getEncoder().encode(bytes));
            loadedPage.setPageImage(encodedImage);
            // return loaded page object
            return loadedPage;
        } catch (Exception ex) {
            logger.error("Exception occurred while loading document page", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignedDocumentEntity signDigital(SignDocumentRequest signDocumentRequest) {
        try {
            // get/set parameters
            String documentGuid = signDocumentRequest.getGuid();
            String password = signDocumentRequest.getPassword();
            List<SignatureDataEntity> signaturesData = signDocumentRequest.getSignaturesData();
            if (signaturesData == null || signaturesData.isEmpty()) {
                throw new IllegalArgumentException("Sign data is empty");
            }
            // get signed document name
            String signedFileName = new File(documentGuid).getName();
            // initiate signed document response
            SignedDocumentEntity signedDocument = new SignedDocumentEntity();

            final SaveOptions saveOptions = new SaveOptions();
            saveOptions.setOutputType(OutputType.String);
            saveOptions.setOutputFileName(signedFileName);

            LoadOptions loadOptions = new LoadOptions();
            if (!StringUtils.isEmpty(password)) {
                loadOptions.setPassword(password);
            }
            // initiate digital signer
            DigitalSigner signer = new DigitalSigner(signaturesData.get(0), password);
            // prepare signing options and sign document
            String documentType = signaturesData.get(0).getDocumentType();
            switch (documentType) {
                case "Portable Document Format":
                    // sign document
                    signedDocument.setGuid(signatureHandler.sign(documentGuid, signer.signPdf(), loadOptions, saveOptions).toString());
                    break;
                case "Microsoft Word":
                    // sign document
                    signedDocument.setGuid(signatureHandler.sign(documentGuid, signer.signWord(), loadOptions, saveOptions).toString());
                    break;
                case "Microsoft Excel":
                    // sign document
                    signedDocument.setGuid(signatureHandler.sign(documentGuid, signer.signCells(), loadOptions, saveOptions).toString());
                    break;
                default:
                    throw new IllegalStateException(String.format("File format %s is not supported.", documentType));
            }
            // return loaded page object
            return signedDocument;
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by digital signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignedDocumentEntity signImage(SignDocumentRequest signDocumentRequest) {
        try {
            // get/set parameters
            String documentGuid = signDocumentRequest.getGuid();
            String password = signDocumentRequest.getPassword();
            List<SignatureDataEntity> signaturesData = signDocumentRequest.getSignaturesData();
            if (signaturesData == null || signaturesData.isEmpty()) {
                throw new IllegalArgumentException("Sign data is empty");
            }
            SignatureOptionsCollection signsCollection = new SignatureOptionsCollection();
            // set signature password if required
            for (int i = 0; i < signaturesData.size(); i++) {
                SignatureDataEntity signatureDataEntity = signaturesData.get(i);
                if (signatureDataEntity.getDeleted()) {
                    continue;
                } else {
                    // check if document type is image
                    if (supportedImageFormats.contains(FilenameUtils.getExtension(documentGuid))) {
                        signatureDataEntity.setDocumentType("image");
                    }
                    // initiate image signer object
                    ImageSigner signer = new ImageSigner(signatureDataEntity);
                    // prepare signing options and sign document
                    addSignOptions(signatureDataEntity.getDocumentType(), signsCollection, signer);
                }
            }
            // return loaded page object
            return signDocument(documentGuid, password, signsCollection);
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by image signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignedDocumentEntity signStamp(SignDocumentRequest signDocumentRequest) {
        String xmlPath = getFullDataPath(STAMP_DATA_DIRECTORY.getXMLPath());
        try {
            // get/set parameters
            String documentGuid = signDocumentRequest.getGuid();
            String password = signDocumentRequest.getPassword();
            List<SignatureDataEntity> signaturesData = signDocumentRequest.getSignaturesData();
            if (signaturesData == null || signaturesData.isEmpty()) {
                throw new IllegalArgumentException("Sign data is empty");
            }
            SignatureOptionsCollection signsCollection = new SignatureOptionsCollection();
            // mimeType should now be something like "image/png" if the document is image
            if (supportedImageFormats.contains(FilenameUtils.getExtension(documentGuid))) {
                signaturesData.get(0).setDocumentType("image");
            }

            for (int i = 0; i < signaturesData.size(); i++) {
                SignatureDataEntity signatureDataEntity = signaturesData.get(i);
                if (signatureDataEntity.getDeleted()) {
                    continue;
                } else {
                    String xmlFileName = FilenameUtils.removeExtension(new File(signatureDataEntity.getSignatureGuid()).getName());
                    // Load xml data
                    String fileName = String.format("%s%s%s.xml", xmlPath, File.separator, xmlFileName);
                    StampXmlEntityList stampData;
                    stampData = new XMLReaderWriter<StampXmlEntityList>().read(fileName, StampXmlEntityList.class);
                    // since stamp ine are added stating from the most outer line we need to reverse the stamp data array
                    List<StampXmlEntity> reverse = Lists.reverse(stampData.getStampXmlEntityList());
                    // initiate stamp signer
                    StampSigner signer = new StampSigner(reverse, signatureDataEntity);
                    // prepare signing options and sign document
                    addSignOptions(signatureDataEntity.getDocumentType(), signsCollection, signer);
                }
            }
            // return loaded page object
            return signDocument(documentGuid, password, signsCollection);
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by stamp", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignedDocumentEntity signOptical(SignDocumentRequest signDocumentRequest) {
        try {
            // get/set parameters
            String documentGuid = signDocumentRequest.getGuid();
            String password = signDocumentRequest.getPassword();
            List<SignatureDataEntity> signaturesData = signDocumentRequest.getSignaturesData();

            if (signaturesData == null || signaturesData.isEmpty()) {
                throw new IllegalArgumentException("Sign data is empty");
            }

            String signatureType = signaturesData.get(0).getSignatureType();

            SignatureOptionsCollection signsCollection = new SignatureOptionsCollection();
            // get xml files root path
            String xmlPath = getFullDataPath((signatureType.equals("qrCode")) ?
                    QRCODE_DATA_DIRECTORY.getXMLPath() :
                    BARCODE_DATA_DIRECTORY.getXMLPath());
            // prepare signing options and sign document
            for (int i = 0; i < signaturesData.size(); i++) {
                SignatureDataEntity signatureDataEntity = signaturesData.get(i);
                if (!signatureDataEntity.getDeleted()) {
                    // get xml data of the QR-Code
                    String xmlFileName = FilenameUtils.removeExtension(new File(signatureDataEntity.getSignatureGuid()).getName());
                    // Load xml data
                    String fileName = String.format("%s%s%s.xml", xmlPath, File.separator, xmlFileName);
                    OpticalXmlEntity opticalCodeData = new XMLReaderWriter<OpticalXmlEntity>().read(fileName, OpticalXmlEntity.class);
                    // check if document type is image
                    if (supportedImageFormats.contains(FilenameUtils.getExtension(documentGuid))) {
                        signatureDataEntity.setDocumentType("image");
                    }
                    // initiate QRCode signer object
                    Signer signer = (signatureType.equals("qrCode")) ? new QrCodeSigner(opticalCodeData, signatureDataEntity) : new BarCodeSigner(opticalCodeData, signatureDataEntity);
                    // prepare signing options and sign document
                    addSignOptions(signatureDataEntity.getDocumentType(), signsCollection, signer);
                }
            }
            // return loaded page object
            return signDocument(documentGuid, password, signsCollection);
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by optical code", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignedDocumentEntity signText(SignDocumentRequest signDocumentRequest) {
        String xmlPath = getFullDataPath(TEXT_DATA_DIRECTORY.getXMLPath());
        try {
            // get/set parameters
            String documentGuid = signDocumentRequest.getGuid();
            String password = signDocumentRequest.getPassword();
            List<SignatureDataEntity> signaturesData = signDocumentRequest.getSignaturesData();

            if (signaturesData == null || signaturesData.isEmpty()) {
                throw new IllegalArgumentException("Sign data is empty");
            }

            SignatureOptionsCollection signsCollection = new SignatureOptionsCollection();
            // prepare signing options and sign document
            for (int i = 0; i < signaturesData.size(); i++) {
                SignatureDataEntity signatureDataEntity = signaturesData.get(i);
                if (!signatureDataEntity.getDeleted()) {
                    // get xml data of the Text signature
                    String xmlFileName = FilenameUtils.removeExtension(new File(signatureDataEntity.getSignatureGuid()).getName());
                    // Load xml data
                    String fileName = String.format("%s%s%s.xml", xmlPath, File.separator, xmlFileName);
                    TextXmlEntity textData = new XMLReaderWriter<TextXmlEntity>().read(fileName, TextXmlEntity.class);
                    // check if document type is image
                    if (supportedImageFormats.contains(FilenameUtils.getExtension(documentGuid))) {
                        signatureDataEntity.setDocumentType("image");
                    }
                    // initiate QRCode signer object
                    TextSigner signer = new TextSigner(textData, signatureDataEntity);
                    // prepare signing options and sign document
                    addSignOptions(signatureDataEntity.getDocumentType(), signsCollection, signer);
                }
            }
            // return loaded page object
            return signDocument(documentGuid, password, signsCollection);
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by text signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileDescriptionEntity saveStamp(SaveStampRequest saveStampRequest) {
        String previewPath = getFullDataPath(STAMP_DATA_DIRECTORY.getPreviewPath());
        String xmlPath = getFullDataPath(STAMP_DATA_DIRECTORY.getXMLPath());
        try {
            // get/set parameters
            String encodedImage = saveStampRequest.getImage().replace("data:image/png;base64,", "");
            List<StampXmlEntity> stampData = saveStampRequest.getStampData();

            FileDescriptionEntity savedImage = new FileDescriptionEntity();
            File file = getFile(previewPath, null);
            byte[] decodedImg = Base64.getDecoder().decode(encodedImage.getBytes(StandardCharsets.UTF_8));
            Files.write(file.toPath(), decodedImg);
            savedImage.setGuid(file.toPath().toString());
            // stamp data to xml file saving
            StampXmlEntityList stampXmlEntityList = new StampXmlEntityList();
            stampXmlEntityList.setStampXmlEntityList(stampData);
            String xmlFileName = FilenameUtils.removeExtension(file.getName());
            String fileName = String.format("%s%s%s.xml", xmlPath, File.separator, xmlFileName);
            new XMLReaderWriter<StampXmlEntityList>().write(fileName, stampXmlEntityList);
            // return loaded page object
            return savedImage;
        } catch (Exception ex) {
            logger.error("Exception occurred while saving stamp", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OpticalXmlEntity saveOpticalCode(SaveOpticalCodeRequest saveOpticalCodeRequest) {
        BufferedImage bufImage = null;
        try {
            OpticalXmlEntity opticalCodeData = saveOpticalCodeRequest.getProperties();
            String signatureType = saveOpticalCodeRequest.getSignatureType();
            // initiate signature data wrapper with default values
            SignatureDataEntity signaturesData = new SignatureDataEntity();
            signaturesData.setImageHeight(200);
            signaturesData.setImageWidth(200);
            signaturesData.setLeft(0);
            signaturesData.setTop(0);
            // initiate signer object
            String previewPath;
            String xmlPath;
            QrCodeSigner qrSigner;
            BarCodeSigner barCodeSigner;
            // initiate signature options collection
            SignatureOptionsCollection collection = new SignatureOptionsCollection();
            // check optical signature type
            if (signatureType.equals("qrCode")) {
                qrSigner = new QrCodeSigner(opticalCodeData, signaturesData);
                // get preview path
                previewPath = getFullDataPath(QRCODE_DATA_DIRECTORY.getPreviewPath());
                // get xml file path
                xmlPath = getFullDataPath(QRCODE_DATA_DIRECTORY.getXMLPath());
                // generate unique file names for preview image and xml file
                collection.add(qrSigner.signImage());
            } else {
                barCodeSigner = new BarCodeSigner(opticalCodeData, signaturesData);
                // get preview path
                previewPath = getFullDataPath(BARCODE_DATA_DIRECTORY.getPreviewPath());
                // get xml file path
                xmlPath = getFullDataPath(BARCODE_DATA_DIRECTORY.getXMLPath());
                // generate unique file names for preview image and xml file
                collection.add(barCodeSigner.signImage());
            }
            String imageGuid = opticalCodeData.getImageGuid();
            File file = getFile(previewPath, imageGuid);
            // generate empty image for future signing with Optical signature, such approach required to get QR-Code as image
            bufImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
            // Create a graphics contents on the buffered image
            Graphics2D g2d = bufImage.createGraphics();
            // Draw graphics
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, 200, 200);
            // Graphics context no longer needed so dispose it
            g2d.dispose();
            // save BufferedImage to file
            ImageIO.write(bufImage, "png", file);

            String fileName = FilenameUtils.removeExtension(file.getName());
            // Optical data to xml file saving
            new XMLReaderWriter<OpticalXmlEntity>().write(String.format("%s%s%s.xml", xmlPath, File.separator, fileName), opticalCodeData);
            // set signing save options
            final SaveOptions saveOptions = new SaveOptions();
            saveOptions.setOutputType(OutputType.String);
            saveOptions.setOutputFileName(file.getName());
            saveOptions.setOverwriteExistingFiles(true);
            // set temporary signed documents path to QR-Code/BarCode image previews folder
            signatureHandler.getSignatureConfig().setOutputPath(previewPath);
            // sign generated image with Optical signature
            signatureHandler.sign(file.toPath().toString(), collection, saveOptions);
            // set signed documents path back to correct path
            signatureHandler.getSignatureConfig().setOutputPath(getFullDataPath(OUTPUT_FOLDER));
            // set data for response
            opticalCodeData.setImageGuid(file.toPath().toString());
            opticalCodeData.setHeight(200);
            opticalCodeData.setWidth(200);
            // get signature preview as Base64 String
            byte[] bytes = signatureHandler.getPageImage(file.toPath().toString(), 1, "", null, 100);
            // encode ByteArray into String
            String encodedImage = new String(Base64.getEncoder().encode(bytes));
            opticalCodeData.setEncodedImage(encodedImage);
            // return loaded page object
            return opticalCodeData;
        } catch (Exception ex) {
            logger.error("Exception occurred while saving optical code signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        } finally {
            if (bufImage != null) {
                bufImage.flush();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TextXmlEntity saveText(SaveTextRequest saveTextRequest) {
        String previewPath = getFullDataPath(TEXT_DATA_DIRECTORY.getPreviewPath());
        String xmlPath = getFullDataPath(TEXT_DATA_DIRECTORY.getXMLPath());
        BufferedImage bufImage = null;
        try {
            TextXmlEntity textData = saveTextRequest.getProperties();
            // initiate signature data wrapper with default values
            SignatureDataEntity signaturesData = new SignatureDataEntity();
            signaturesData.setImageHeight(textData.getHeight());
            signaturesData.setImageWidth(textData.getWidth());
            signaturesData.setLeft(0);
            signaturesData.setTop(0);
            // initiate signer object
            TextSigner textSigner = new TextSigner(textData, signaturesData);
            // initiate signature options collection
            SignatureOptionsCollection collection = new SignatureOptionsCollection();
            // generate unique file names for preview image and xml file
            collection.add(textSigner.signImage());
            String imageGuid = textData.getImageGuid();
            File file = getFile(previewPath, imageGuid);
            // generate empty image for future signing with Text, such approach required to get Text as image
            bufImage = new BufferedImage(signaturesData.getImageWidth(), signaturesData.getImageHeight(), BufferedImage.TYPE_INT_ARGB);
            // Create a graphics contents on the buffered image
            Graphics2D g2d = bufImage.createGraphics();
            // Draw graphics
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, signaturesData.getImageWidth(), signaturesData.getImageHeight());
            // Graphics context no longer needed so dispose it
            g2d.dispose();
            // save BufferedImage to file
            ImageIO.write(bufImage, "png", file);
            String fileName = FilenameUtils.removeExtension(file.getName());
            // Save text data to an xml file
            new XMLReaderWriter<TextXmlEntity>().write(String.format("%s%s%s.xml", xmlPath, File.separator, fileName), textData);
            // set signing save options
            final SaveOptions saveOptions = new SaveOptions();
            saveOptions.setOutputType(OutputType.String);
            saveOptions.setOutputFileName(file.getName());
            saveOptions.setOverwriteExistingFiles(true);
            // set temporary signed documents path to Text/BarCode image previews folder
            signatureHandler.getSignatureConfig().setOutputPath(previewPath);
            // sign generated image with Text
            signatureHandler.sign(file.toPath().toString(), collection, saveOptions);
            // set signed documents path back to correct path
            signatureHandler.getSignatureConfig().setOutputPath(getFullDataPath(OUTPUT_FOLDER));
            // set Text data for response
            textData.setImageGuid(file.toPath().toString());
            // get Text preview as Base64 String
            byte[] bytes = signatureHandler.getPageImage(file.toPath().toString(), 1, "", null, 100);
            // encode ByteArray into String
            String encodedImage = new String(Base64.getEncoder().encode(bytes));
            textData.setEncodedImage(encodedImage);
            // return loaded page object
            return textData;
        } catch (Exception ex) {
            logger.error("Exception occurred while saving text signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        } finally {
            if (bufImage != null) {
                bufImage.flush();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileDescriptionEntity saveImage(SaveImageRequest saveImageRequest) {
        try {
            // get/set parameters
            String encodedImage = saveImageRequest.getImage().replace("data:image/png;base64,", "");
            FileDescriptionEntity savedImage = new FileDescriptionEntity();
            String imageName = "drawn signature.png";
            String dataDirectoryPath = getFullDataPath(IMAGE_DATA_DIRECTORY.getPath());
            String imagePath = String.format("%s%s%s", dataDirectoryPath, File.separator, imageName);
            File file = new File(imagePath);
            if (file.exists()) {
                imageName = getFreeFileName(dataDirectoryPath, imageName).toPath().getFileName().toString();
                imagePath = String.format("%s%s%s", dataDirectoryPath, File.separator, imageName);
                file = new File(imagePath);
            }
            byte[] decodedImg = Base64.getDecoder().decode(encodedImage.getBytes(StandardCharsets.UTF_8));
            Files.write(file.toPath(), decodedImg);
            savedImage.setGuid(imagePath);
            // return loaded page object
            return savedImage;
        } catch (Exception ex) {
            logger.error("Exception occurred while saving image signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignatureFileDescriptionEntity uploadDocument(Part content, String url, Boolean rewrite, String signatureType) {
        // get signatures storage path
        String pathFromSignatureType = signatureType == null ? "" : SignatureDirectory.getPathFromSignatureType(signatureType);
        String documentStoragePath = StringUtils.isEmpty(pathFromSignatureType) ?
                signatureConfiguration.getFilesDirectory() :
                getFullDataPath(pathFromSignatureType);
        // save the file
        String filePath = uploadFile(documentStoragePath, content, url, rewrite);
        // create response data
        SignatureFileDescriptionEntity uploadedDocument = new SignatureFileDescriptionEntity();
        uploadedDocument.setGuid(filePath);
        if ("image".equals(signatureType)) {
            // get page image
            try {
                byte[] bytes = Files.readAllBytes(new File(uploadedDocument.getGuid()).toPath());
                // encode ByteArray into String
                String encodedImage = new String(Base64.getEncoder().encode(bytes));
                uploadedDocument.setImage(encodedImage);
            } catch (IOException ex) {
                logger.error("Exception occurred read images in document", ex);
                throw new TotalGroupDocsException(ex.getMessage(), ex);
            }
        }
        return uploadedDocument;
    }

    /**
     * Create file in previewPath and name imageGuid
     * if the file is already exist, create new file with next number in name
     * examples, 001, 002, 003, etc
     *
     * @param previewPath path to file folder
     * @param imageGuid   file name
     * @return created file
     */
    private File getFile(String previewPath, String imageGuid) {
        File folder = new File(previewPath);
        File[] listOfFiles = folder.listFiles();
        if (!StringUtils.isEmpty(imageGuid)) {
            return new File(imageGuid);
        } else {
            for (int i = 0; i <= listOfFiles.length; i++) {
                int number = i + 1;
                // set file name, for example 001
                String fileName = String.format("%03d", number);
                File file = new File(String.format("%s%s%s.png", previewPath, File.separator, fileName));
                // check if file with such name already exists
                if (file.exists()) {
                    continue;
                } else {
                    return file;
                }
            }
            return new File(String.format("%s%s001.png", previewPath, File.separator));
        }
    }

    /**
     * Add current signature options to signs collection
     *
     * @param documentType
     * @param signsCollection
     * @param signer
     * @throws ParseException
     */
    private void addSignOptions(String documentType, SignatureOptionsCollection signsCollection, Signer signer) throws ParseException {
        switch (documentType) {
            case "Portable Document Format":
                signsCollection.add(signer.signPdf());
                break;
            case "Microsoft Word":
                signsCollection.add(signer.signWord());
                break;
            case "Microsoft PowerPoint":
                signsCollection.add(signer.signSlides());
                break;
            case "image":
                signsCollection.add(signer.signImage());
                break;
            case "Microsoft Excel":
                signsCollection.add(signer.signCells());
                break;
            default:
                throw new IllegalStateException(String.format("File format %s is not supported.", documentType));
        }
    }

    /**
     * Sign document
     *
     * @param documentGuid
     * @param password
     * @param signsCollection
     * @return signed document
     * @throws Exception
     */
    private SignedDocumentEntity signDocument(String documentGuid, String password, SignatureOptionsCollection signsCollection) throws Exception {
        // set save options
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName(new File(documentGuid).getName());

        // set password
        LoadOptions loadOptions = new LoadOptions();
        if (password != null && !password.isEmpty()) {
            loadOptions.setPassword(password);
        }

        // sign document
        SignedDocumentEntity signedDocument = new SignedDocumentEntity();
        signedDocument.setGuid(signatureHandler.sign(documentGuid, signsCollection, loadOptions, saveOptions).toString());
        return signedDocument;
    }
}
