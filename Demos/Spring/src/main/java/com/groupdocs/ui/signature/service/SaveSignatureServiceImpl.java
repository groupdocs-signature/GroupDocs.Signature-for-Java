package com.groupdocs.ui.signature.service;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.options.PageSignatureStreamFactory;
import com.groupdocs.signature.options.PreviewSignatureOptions;
import com.groupdocs.signature.options.preview.PreviewFormats;
import com.groupdocs.signature.options.sign.SignOptions;
import com.groupdocs.ui.config.DefaultDirectories;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import com.groupdocs.ui.signature.SignatureConfiguration;
import com.groupdocs.ui.signature.XMLReaderWriter;
import com.groupdocs.ui.signature.model.request.SaveImageRequest;
import com.groupdocs.ui.signature.model.request.SaveOpticalCodeRequest;
import com.groupdocs.ui.signature.model.request.SaveStampRequest;
import com.groupdocs.ui.signature.model.request.SaveTextRequest;
import com.groupdocs.ui.signature.model.web.SignatureDataEntity;
import com.groupdocs.ui.signature.model.xml.*;
import com.groupdocs.ui.signature.signer.BarCodeSigner;
import com.groupdocs.ui.signature.signer.QrCodeSigner;
import com.groupdocs.ui.signature.signer.Signer;
import com.groupdocs.ui.util.directory.SignatureDirectory;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import static com.groupdocs.ui.signature.SignatureType.QR_CODE;
import static com.groupdocs.ui.signature.service.SignatureHandlerFactory.getFullDataPathStr;
import static com.groupdocs.ui.util.Utils.getFileWithUniqueName;
import static com.groupdocs.ui.util.directory.PathConstants.DATA_FOLDER;
import static com.groupdocs.ui.util.directory.SignatureDirectory.*;

@Service
public class SaveSignatureServiceImpl implements SaveSignatureService {
    private static final Logger logger = LoggerFactory.getLogger(SaveSignatureServiceImpl.class);

    public static final String PNG = "png";
    public static final String XML = "xml";

    @Autowired
    private SignatureConfiguration signatureConfiguration;

    @PostConstruct
    public void init() {
        SignatureHandlerFactory.createHandler(signatureConfiguration.getFilesDirectory(), signatureConfiguration.getDataDirectory());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileDescriptionEntity saveStamp(SaveStampRequest saveStampRequest) {
        String previewPath = getFullDataPathStr(signatureConfiguration.getDataDirectory(), STAMP_DATA_DIRECTORY.getPreviewPath());
        String xmlPath = getFullDataPathStr(signatureConfiguration.getDataDirectory(), STAMP_DATA_DIRECTORY.getXMLPath());
        try {
            // get/set parameters
            String encodedImage = saveStampRequest.getImage().replace("data:image/png;base64,", "");
            List<StampXmlEntity> stampData = saveStampRequest.getStampData();

            File file = getFileWithUniqueName(previewPath, "", PNG);
            byte[] decodedImg = Base64.getDecoder().decode(encodedImage.getBytes(StandardCharsets.UTF_8));
            Files.write(file.toPath(), decodedImg);
            // stamp data to xml file saving
            StampXmlEntityList stampXmlEntityList = new StampXmlEntityList();
            stampXmlEntityList.setStampXmlEntityList(stampData);
            String xmlFileName = FilenameUtils.removeExtension(file.getName());
            String fileName = String.format("%s%s%s.xml", xmlPath, File.separator, xmlFileName);
            new XMLReaderWriter<StampXmlEntityList>().write(fileName, stampXmlEntityList);

            FileDescriptionEntity savedImage = new FileDescriptionEntity();
            savedImage.setGuid(file.toPath().toString());
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
        OpticalXmlEntity signatureData = saveOpticalCodeRequest.getProperties();
        // initiate signature data wrapper with default values
        SignatureDataEntity signatureDataEntity = getSignatureDataEntity(200, 200);

        Signer signer = QR_CODE.equals(saveOpticalCodeRequest.getSignatureType()) ?
                new QrCodeSigner(signatureData, signatureDataEntity) :
                new BarCodeSigner(signatureData, signatureDataEntity);

        SignOptions signOptions = signer.signImage();

        SignatureDirectory dataDirectory = QR_CODE.equals(saveOpticalCodeRequest.getSignatureType()) ? QRCODE_DATA_DIRECTORY : BARCODE_DATA_DIRECTORY;
        signatureData.setWidth(signatureDataEntity.getImageWidth());
        signatureData.setHeight(signatureDataEntity.getImageHeight());
        String encodedImage = createAndSaveOpticalCode(signatureData, dataDirectory, signOptions);
        signatureData.setEncodedImage(encodedImage);
        return signatureData;
    }

    /**
     * Create and save image with optical code
     *
     * @param signatureData
     * @param dataDirectory
     * @param collection
     * @return encoded image
     */
    private String createAndSaveOpticalCode(OpticalXmlEntity signatureData, SignatureDirectory dataDirectory,
                                            SignOptions signOptions) {
        String dataDir = resolveDataDirectory();
        String previewPath = getFullDataPathStr(dataDir, dataDirectory.getPreviewPath());
        String xmlPath = getFullDataPathStr(dataDir, dataDirectory.getXMLPath());
        try {
            byte[] imageBytes = generateSignaturePreviewBytes(signOptions);
            DefaultDirectories.makeDirs(Paths.get(previewPath));
            File file = getFileWithUniqueName(previewPath, signatureData.getImageGuid(), PNG);
            Files.write(file.toPath(), imageBytes);
            String fileName = FilenameUtils.removeExtension(file.getName());
            String xmlFilePath = String.format("%s%s%s.xml", xmlPath, File.separator, fileName);
            new XMLReaderWriter<OpticalXmlEntity>().write(xmlFilePath, signatureData);
            signatureData.setImageGuid(file.toPath().toString());
            String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
            if (signatureData.getTemp()) {
                Files.deleteIfExists(file.toPath());
                Files.deleteIfExists(Paths.get(xmlFilePath));
            }
            return encodedImage;
        } catch (Exception e) {
            logger.error("Exception occurred while saving optical code signature", e);
            throw new TotalGroupDocsException(e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TextXmlEntity saveText(SaveTextRequest saveTextRequest) {
        String xmlPath = getFullDataPathStr(signatureConfiguration.getDataDirectory(), TEXT_DATA_DIRECTORY.getXMLPath());
        TextXmlEntity signatureData = saveTextRequest.getProperties();
        try {
            File file = getFileWithUniqueName(xmlPath, signatureData.getImageGuid(), XML);
            // Save data to xml file
            String fileName = String.format("%s%s%s.xml", xmlPath, File.separator, FilenameUtils.removeExtension(file.getName()));
            new XMLReaderWriter<TextXmlEntity>().write(fileName, signatureData);
            signatureData.setImageGuid(fileName);
        } catch (JAXBException e) {
            logger.error("Exception occurred while saving text signature", e);
            throw new TotalGroupDocsException(e.getMessage(), e);
        }
        return signatureData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileDescriptionEntity saveImage(SaveImageRequest saveImageRequest) {
        try {
            String dataDirectoryPath = getFullDataPathStr(signatureConfiguration.getDataDirectory(), IMAGE_DATA_DIRECTORY.getPath());
            File file = getFileWithUniqueName(dataDirectoryPath, "", PNG);
            String encodedImage = saveImageRequest.getImage().replace("data:image/png;base64,", "");
            byte[] decodedImg = Base64.getDecoder().decode(encodedImage.getBytes(StandardCharsets.UTF_8));
            Files.write(file.toPath(), decodedImg);

            FileDescriptionEntity savedImage = new FileDescriptionEntity();
            savedImage.setGuid(file.getAbsolutePath());
            // return loaded page object
            return savedImage;
        } catch (Exception ex) {
            logger.error("Exception occurred while saving image signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Generate QR/Barcode preview using GroupDocs.Signature preview API (26.5+).
     */
    private byte[] generateSignaturePreviewBytes(SignOptions signOptions) {
        try {
            final byte[][] out = {new byte[0]};
            PreviewSignatureOptions previewOptions = new PreviewSignatureOptions(signOptions, new PageSignatureStreamFactory() {
                @Override
                public OutputStream createSignatureStream(PreviewSignatureOptions previewOptions) {
                    return new ByteArrayOutputStream();
                }

                @Override
                public void closeSignatureStream(PreviewSignatureOptions previewOptions, OutputStream pageStream) {
                    out[0] = ((ByteArrayOutputStream) pageStream).toByteArray();
                }
            });
            previewOptions.setPreviewFormat(PreviewFormats.PNG);
            Signature.generateSignaturePreview(previewOptions);
            if (out[0].length == 0) {
                throw new TotalGroupDocsException("Optical code preview image is empty");
            }
            return out[0];
        } catch (Exception ex) {
            logger.error("Exception occurred while saving optical code signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private String resolveDataDirectory() {
        if (StringUtils.isEmpty(signatureConfiguration.getDataDirectory())) {
            signatureConfiguration.setDataDirectory(
                    signatureConfiguration.getFilesDirectory() + DATA_FOLDER);
        }
        SignatureHandlerFactory.createDirectories(signatureConfiguration.getDataDirectory());
        return signatureConfiguration.getDataDirectory();
    }

    /**
     * Get filled signature data
     *
     * @param width
     * @param height
     * @return
     */
    private SignatureDataEntity getSignatureDataEntity(int width, int height) {
        SignatureDataEntity signatureDataEntity = new SignatureDataEntity();
        signatureDataEntity.setHorizontalAlignment(HorizontalAlignment.Center);
        signatureDataEntity.setVerticalAlignment(VerticalAlignment.Center);
        signatureDataEntity.setImageHeight(height);
        signatureDataEntity.setImageWidth(width);
        signatureDataEntity.setPageNumber(1);
        signatureDataEntity.setLeft(0);
        signatureDataEntity.setTop(0);
        return signatureDataEntity;
    }
}
