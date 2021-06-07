package com.groupdocs.ui.signature.service;

import com.google.common.collect.Lists;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.SignatureOptionsCollection;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.signature.config.SignatureConfiguration;
import com.groupdocs.ui.signature.entity.request.SignDocumentRequest;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;
import com.groupdocs.ui.signature.entity.web.SignedDocumentEntity;
import com.groupdocs.ui.signature.entity.xml.OpticalXmlEntity;
import com.groupdocs.ui.signature.entity.xml.StampXmlEntity;
import com.groupdocs.ui.signature.entity.xml.StampXmlEntityList;
import com.groupdocs.ui.signature.entity.xml.TextXmlEntity;
import com.groupdocs.ui.signature.signer.*;
import com.groupdocs.ui.signature.util.XMLReaderWriter;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import static com.groupdocs.ui.signature.service.SignatureHandlerFactory.createStreamHandler;
import static com.groupdocs.ui.signature.service.SignatureHandlerFactory.getFullDataPathStr;
import static com.groupdocs.ui.signature.util.SignatureType.QR_CODE;
import static com.groupdocs.ui.signature.util.directory.SignatureDirectory.*;

public class SignServiceImpl implements SignService {
    private static final Logger logger = LoggerFactory.getLogger(SignServiceImpl.class);

    private static final List<String> supportedImageFormats = Arrays.asList("bmp", "jpeg", "jpg", "tiff", "tif", "png");

    private SignatureHandler signatureHandler;
    private SignatureConfiguration signatureConfiguration;

    public SignServiceImpl(GlobalConfiguration globalConfiguration) {
        this.signatureConfiguration = globalConfiguration.getSignature();
        signatureHandler = SignatureHandlerFactory.createHandler(signatureConfiguration.getFilesDirectory(), signatureConfiguration.getDataDirectory());
    }

    @Override
    public SignedDocumentEntity sign(SignDocumentRequest signDocumentRequest) {
        String documentGuid = signDocumentRequest.getGuid();
        SignatureOptionsCollection signsCollection = buildSignOptions(signDocumentRequest);
        return signDocument(documentGuid, signDocumentRequest.getPassword(), signsCollection);
    }

    private SignatureOptionsCollection buildSignOptions(SignDocumentRequest signDocumentRequest) {
        String documentGuid = signDocumentRequest.getGuid();
        String documentType = getDocumentType(signDocumentRequest.getDocumentType(), documentGuid, FilenameUtils.getExtension(documentGuid));
        List<SignatureDataEntity> signaturesData = signDocumentRequest.getSignaturesData();
        SortedSignaturesData sortedSignaturesData = new SortedSignaturesData(signaturesData).sort();
        SignatureOptionsCollection signsCollection = new SignatureOptionsCollection();
        if (!sortedSignaturesData.digital.isEmpty()) {
            signDigital(signDocumentRequest.getPassword(), sortedSignaturesData.digital, documentType, signsCollection);
        }
        if (!sortedSignaturesData.images.isEmpty()) {
            signImage(documentType, sortedSignaturesData.images, signsCollection);
        }
        if (!sortedSignaturesData.texts.isEmpty()) {
            signText(documentType, sortedSignaturesData.texts, signsCollection);
        }
        if (!sortedSignaturesData.stamps.isEmpty()) {
            signStamp(documentType, sortedSignaturesData.stamps, signsCollection);
        }
        if (!sortedSignaturesData.codes.isEmpty()) {
            signOptical(documentType, sortedSignaturesData.codes, signsCollection);
        }
        return signsCollection;
    }

    @Override
    public InputStream signByStream(SignDocumentRequest signDocumentRequest) {
        String documentGuid = signDocumentRequest.getGuid();
        SignatureOptionsCollection signsCollection = buildSignOptions(signDocumentRequest);
        return signDocumentByStream(documentGuid, signDocumentRequest.getPassword(), signsCollection);
    }

    private InputStream signDocumentByStream(String documentGuid, String password, SignatureOptionsCollection signsCollection) {
        // set save options
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.Stream);

        // set password
        LoadOptions loadOptions = new LoadOptions();
        if (password != null && !password.isEmpty()) {
            loadOptions.setPassword(password);
        }

        SignatureHandler<OutputStream> streamSignatureHandler = createStreamHandler();

        try {
            ByteArrayOutputStream bos = (ByteArrayOutputStream) streamSignatureHandler.sign(new FileInputStream(documentGuid), signsCollection, loadOptions, saveOptions);
            return new ByteArrayInputStream(bos.toByteArray());
        } catch (Exception ex) {
            logger.error("Exception occurred while signing document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Sign document by digital signature
     *
     * @param digital
     * @param documentType
     * @param signsCollection
     */
    private void signDigital(String password, List<SignatureDataEntity> digital, String documentType, SignatureOptionsCollection signsCollection) {
        try {
            for (int i = 0; i < digital.size(); i++) {
                SignatureDataEntity signatureDataEntity = digital.get(i);
                // initiate digital signer
                DigitalSigner signer = new DigitalSigner(signatureDataEntity, password);
                switch (documentType) {
                    case "Portable Document Format":
                        signsCollection.add(signer.signPdf());
                        break;
                    case "Microsoft Word":
                        signsCollection.add(signer.signWord());
                        break;
                    case "Microsoft Excel":
                        signsCollection.add(signer.signCells());
                        break;
                    default:
                        throw new IllegalStateException(String.format("File format %s is not supported.", documentType));
                }
            }
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by digital signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Sign document with images
     *
     * @param documentType
     * @param images
     * @param signsCollection
     * @return
     */
    private void signImage(String documentType, List<SignatureDataEntity> images, SignatureOptionsCollection signsCollection) {
        try {
            for (int i = 0; i < images.size(); i++) {
                SignatureDataEntity signatureDataEntity = images.get(i);
                // initiate image signer object
                ImageSigner signer = new ImageSigner(signatureDataEntity);
                // prepare signing options and sign document
                addSignOptions(documentType, signsCollection, signer);
            }
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by image signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Sign document with stamps
     *
     * @param documentType
     * @param stamps
     * @param signsCollection
     * @return
     */
    private void signStamp(String documentType, List<SignatureDataEntity> stamps, SignatureOptionsCollection signsCollection) {
        String xmlPath = getFullDataPathStr(signatureConfiguration.getDataDirectory(), STAMP_DATA_DIRECTORY.getXMLPath());
        try {
            for (int i = 0; i < stamps.size(); i++) {
                SignatureDataEntity signatureDataEntity = stamps.get(i);
                String fileName = getXMLFileName(xmlPath, signatureDataEntity.getSignatureGuid());
                StampXmlEntityList stampData = new XMLReaderWriter<StampXmlEntityList>().read(fileName, StampXmlEntityList.class);
                // since stamp ine are added stating from the most outer line we need to reverse the stamp data array
                List<StampXmlEntity> reverse = Lists.reverse(stampData.getStampXmlEntityList());
                // initiate stamp signer
                StampSigner signer = new StampSigner(reverse, signatureDataEntity);
                // prepare signing options and sign document
                addSignOptions(documentType, signsCollection, signer);
            }
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by stamp", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Sign document with barcodes and/or qrcodes
     *
     * @param documentType
     * @param codes
     * @param signsCollection
     * @return
     */
    private void signOptical(String documentType, List<SignatureDataEntity> codes, SignatureOptionsCollection signsCollection) {
        try {
            // prepare signing options and sign document
            for (int i = 0; i < codes.size(); i++) {
                SignatureDataEntity signatureDataEntity = codes.get(i);
                // get xml files root path
                String signatureType = signatureDataEntity.getSignatureType();
                String xmlPath = getFullDataPathStr(signatureConfiguration.getDataDirectory(), (QR_CODE.equals(signatureType)) ?
                        QRCODE_DATA_DIRECTORY.getXMLPath() :
                        BARCODE_DATA_DIRECTORY.getXMLPath());
                // get xml data of the QR-Code
                String fileName = getXMLFileName(xmlPath, signatureDataEntity.getSignatureGuid());
                OpticalXmlEntity opticalCodeData = new XMLReaderWriter<OpticalXmlEntity>().read(fileName, OpticalXmlEntity.class);
                // initiate QRCode signer object
                Signer signer = (QR_CODE.equals(signatureType)) ? new QrCodeSigner(opticalCodeData, signatureDataEntity) : new BarCodeSigner(opticalCodeData, signatureDataEntity);
                // prepare signing options and sign document
                addSignOptions(documentType, signsCollection, signer);
            }
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by optical code", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Sign document with text signature
     *
     * @param documentType
     * @param texts
     * @param signsCollection
     * @return
     */
    private void signText(String documentType, List<SignatureDataEntity> texts, SignatureOptionsCollection signsCollection) {
        try {
            // prepare signing options and sign document
            for (int i = 0; i < texts.size(); i++) {
                SignatureDataEntity signatureDataEntity = texts.get(i);
                // get xml data of the signature
                TextXmlEntity textData = new XMLReaderWriter<TextXmlEntity>().read(signatureDataEntity.getSignatureGuid(), TextXmlEntity.class);
                // initiate QRCode signer object
                TextSigner signer = new TextSigner(textData, signatureDataEntity);
                // prepare signing options and sign document
                addSignOptions(documentType, signsCollection, signer);
            }
        } catch (Exception ex) {
            logger.error("Exception occurred while signing by text signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private String getXMLFileName(String xmlPath, String signatureGuid) {
        // get xml data of the signature
        String xmlFileName = FilenameUtils.removeExtension(new File(signatureGuid).getName());
        // Load xml data
        return String.format("%s%s%s.xml", xmlPath, File.separator, xmlFileName);
    }
    /**
     * Get fixed document type
     *
     * @param documentType
     * @param documentGuid
     * @param fileExtension
     * @return
     */
    private String getDocumentType(String documentType, String documentGuid, String fileExtension) {
        // mimeType should now be something like "image/png" if the document is image
        boolean isImage = supportedImageFormats.contains(fileExtension);
        return isImage ? "image" : documentType;
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
    private SignedDocumentEntity signDocument(String documentGuid, String password, SignatureOptionsCollection signsCollection) {
        // set save options
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName(FilenameUtils.getName(documentGuid));
        saveOptions.setOverwriteExistingFiles(true);

        // set password
        LoadOptions loadOptions = new LoadOptions();
        if (password != null && !password.isEmpty()) {
            loadOptions.setPassword(password);
        }

        // sign document
        SignedDocumentEntity signedDocument = new SignedDocumentEntity();
        try {
            signatureHandler.getSignatureConfig().setOutputPath(FilenameUtils.getFullPath(documentGuid));
            signedDocument.setGuid(signatureHandler.sign(documentGuid, signsCollection, loadOptions, saveOptions).toString());
        } catch (Exception ex) {
            logger.error("Exception occurred while signing document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
        return signedDocument;
    }
}
