package com.groupdocs.ui.signature.service;

import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.SignatureOptionsCollection;
import com.groupdocs.signature.options.saveoptions.SaveOptions;
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

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.xml.bind.JAXBException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import static com.groupdocs.ui.signature.SignatureType.QR_CODE;
import static com.groupdocs.ui.signature.service.SignatureHandlerFactory.createStreamHandler;
import static com.groupdocs.ui.signature.service.SignatureHandlerFactory.getFullDataPathStr;
import static com.groupdocs.ui.util.Utils.getBufferedImage;
import static com.groupdocs.ui.util.Utils.getFileWithUniqueName;
import static com.groupdocs.ui.util.directory.SignatureDirectory.*;

@Service
public class SaveSignatureServiceImpl implements SaveSignatureService {
    private static final Logger logger = LoggerFactory.getLogger(SaveSignatureServiceImpl.class);

    public static final String PNG = "png";
    public static final String XML = "xml";

    private SignatureHandler signatureHandler;
    @Autowired
    private SignatureConfiguration signatureConfiguration;

    @PostConstruct
    public void init() {
        signatureHandler = SignatureHandlerFactory.createHandler(signatureConfiguration.getFilesDirectory(), signatureConfiguration.getDataDirectory());
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
        SignatureDataEntity signatureDataEntity = getSignatureDataEntity(270, 200);

        // initiate signature options collection
        SignatureOptionsCollection collection = new SignatureOptionsCollection();

        Signer signer = QR_CODE.equals(saveOpticalCodeRequest.getSignatureType()) ?
                new QrCodeSigner(signatureData, signatureDataEntity) :
                new BarCodeSigner(signatureData, signatureDataEntity);

        collection.add(signer.signImage());

        SignatureDirectory dataDirectory = QR_CODE.equals(saveOpticalCodeRequest.getSignatureType()) ? QRCODE_DATA_DIRECTORY : BARCODE_DATA_DIRECTORY;
        String encodedImage = createAndSaveOpticalCode(signatureData, dataDirectory, collection);
        signatureData.setEncodedImage(encodedImage);
        signatureData.setWidth(signatureDataEntity.getImageWidth());
        signatureData.setHeight(signatureDataEntity.getImageHeight());
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
    private String createAndSaveOpticalCode(OpticalXmlEntity signatureData, SignatureDirectory dataDirectory, SignatureOptionsCollection collection) {
        // get preview path
        String previewPath = getFullDataPathStr(signatureConfiguration.getDataDirectory(), dataDirectory.getPreviewPath());
        // get xml file path
        String xmlPath = getFullDataPathStr(signatureConfiguration.getDataDirectory(), dataDirectory.getXMLPath());
        try {
            if (signatureData.getTemp()) {
                BufferedImage bufImage = getBufferedImage(200, 200);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(bufImage, PNG, os);
                InputStream is = new ByteArrayInputStream(os.toByteArray());
                return signWithImageToStream(collection, is);
            } else {
                File file = writeImageFile(signatureData.getImageGuid(), previewPath, 200, 200);
                String fileName = FilenameUtils.removeExtension(file.getName());
                // Save data to xml file
                new XMLReaderWriter<OpticalXmlEntity>().write(String.format("%s%s%s.xml", xmlPath, File.separator, fileName), signatureData);
                return signWithImageToFile(previewPath, signatureData, collection, file.toPath().toString());
            }
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
     * Write image to file
     *
     * @param imageGuid      image file guid if it exists
     * @param previewPath    path to file
     * @return
     */
    private File writeImageFile(String imageGuid, String previewPath, int width, int height) {
        File file = getFileWithUniqueName(previewPath, imageGuid, PNG);
        try {
            BufferedImage bufImage = getBufferedImage(width, height);
            // save BufferedImage to file
            ImageIO.write(bufImage, PNG, file);
        } catch (Exception ex) {
            logger.error("Exception occurred while saving signatures image", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
        return file;
    }

    /**
     * Sign image with signature data for saving in stream
     *
     * @param collection  signature options
     * @param inputStream stream with image, for temporally sign
     * @return encoded image
     */
    private String signWithImageToStream(SignatureOptionsCollection collection, InputStream inputStream) {
        try {
            final SaveOptions saveOptions = new SaveOptions();
            saveOptions.setOutputType(OutputType.Stream);
            // sign generated image with signature
            SignatureHandler<OutputStream> imgSignatureHandler = createStreamHandler();
            ByteArrayOutputStream bos = (ByteArrayOutputStream) imgSignatureHandler.sign(inputStream, collection, saveOptions);
            byte[] bytes = bos.toByteArray();
            // encode ByteArray into String
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception ex) {
            logger.error("Exception occurred while saving optical code signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Sign image with signature data for saving in local storage
     *
     * @param previewPath   local storage path
     * @param signatureData signature
     * @param collection    signature options
     * @param path          path to file
     * @return encoded image
     */
    private String signWithImageToFile(String previewPath, XmlEntityWithImage signatureData, SignatureOptionsCollection collection, String path) {
        try {
            // set signing save options
            final SaveOptions saveOptions = new SaveOptions();
            saveOptions.setOutputType(OutputType.String);
            saveOptions.setOutputFileName(FilenameUtils.getName(path));
            saveOptions.setOverwriteExistingFiles(true);
            // set temporary signed documents path to image previews folder
            signatureHandler.getSignatureConfig().setOutputPath(previewPath);
            // sign generated image with signature
            signatureHandler.sign(path, collection, saveOptions);
            // set data for response
            signatureData.setImageGuid(path);
            // get signature preview as Base64 String
            byte[] bytes = signatureHandler.getPageImage(path, 1, "", null, 100);
            // encode ByteArray into String
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception ex) {
            logger.error("Exception occurred while saving optical code signature", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
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
        signatureDataEntity.setLeft(0);
        signatureDataEntity.setTop(0);
        return signatureDataEntity;
    }
}
