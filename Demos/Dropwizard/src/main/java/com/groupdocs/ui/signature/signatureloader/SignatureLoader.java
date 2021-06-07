package com.groupdocs.ui.signature.signatureloader;

import com.google.common.collect.Ordering;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.common.util.comparator.FileDateComparator;
import com.groupdocs.ui.common.util.comparator.FileNameComparator;
import com.groupdocs.ui.signature.entity.request.DeleteSignatureFileRequest;
import com.groupdocs.ui.signature.entity.request.LoadSignatureImageRequest;
import com.groupdocs.ui.signature.entity.web.SignatureFileDescriptionEntity;
import com.groupdocs.ui.signature.entity.web.SignaturePageEntity;
import com.groupdocs.ui.signature.entity.xml.OpticalXmlEntity;
import com.groupdocs.ui.signature.entity.xml.TextXmlEntity;
import com.groupdocs.ui.signature.util.XMLReaderWriter;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;

import static com.groupdocs.ui.signature.util.SignatureType.*;
import static com.groupdocs.ui.signature.util.directory.PathConstants.DATA_PREVIEW_FOLDER;
import static com.groupdocs.ui.signature.util.directory.PathConstants.DATA_XML_FOLDER;

/**
 * SignatureLoader
 * Loads signature files from the storage
 *
 * @author Aspose Pty Ltd
 */
public class SignatureLoader {

    /**
     * Constructor
     *
     */
    public SignatureLoader() {
    }

    /**
     * Load image signatures
     *
     * @return List<SignatureFileDescriptionEntity>
     */
    public List<SignatureFileDescriptionEntity> loadImageSignatures(String currentPath, String dataPath) {
        File directory = new File(currentPath);
        List<SignatureFileDescriptionEntity> fileList = new ArrayList<>();
        List<File> filesList = Arrays.asList(directory.listFiles());
        try {
            // sort list of files and folders
            filesList = Ordering.from(FileDateComparator.instance).compound(FileNameComparator.instance).sortedCopy(filesList);
            for (File file : filesList) {
                // check if current file/folder is hidden
                if (!file.isDirectory() && checkFile(dataPath, file)) {
                    SignatureFileDescriptionEntity fileDescription = getSignatureFileDescriptionEntity(file, true);
                    // add object to array list
                    fileList.add(fileDescription);
                }
            }
            return fileList;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Load digital signatures or documents for signing
     *
     * @return List<SignatureFileDescriptionEntity>
     */
    public List<SignatureFileDescriptionEntity> loadFiles(String currentPath, String dataPath, String signatureType) {
        File directory = new File(currentPath);
        List<File> filesList = Arrays.asList(directory.listFiles());
        try {
            return getResultFileList(dataPath, signatureType, filesList, false);
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private boolean checkFile(String path, File file) {
        return !file.isHidden() && !file.toPath().toString().equals(path);
    }

    /**
     * load text signatures
     *
     * @param currentPath
     * @param dataPath
     * @return
     */
    public List<SignatureFileDescriptionEntity> loadTextSignatures(String currentPath, String dataPath) {
        String xmlPath = currentPath + DATA_XML_FOLDER;
        try {
            List<File> filesList = Arrays.asList(new File(xmlPath).listFiles());
            return getResultFileList(dataPath, TEXT, filesList, false);
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Load stamp signatures
     *
     * @return List<SignatureFileDescriptionEntity>
     */
    public List<SignatureFileDescriptionEntity> loadSignatures(String currentPath, String dataPath, String signatureType) {
        String imagesPath = currentPath + DATA_PREVIEW_FOLDER;
        String xmlPath = currentPath + DATA_XML_FOLDER;
        File images = new File(imagesPath);
        try {
            if (images.listFiles() != null) {
                List<File> imageFiles = Arrays.asList(images.listFiles());
                List<File> xmlFiles = Arrays.asList(new File(xmlPath).listFiles());
                List<File> filesList = createFilesList(imageFiles, xmlFiles);
                return getResultFileList(dataPath, signatureType, filesList, true);
            }
            return Collections.EMPTY_LIST;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private List<File> createFilesList(List<File> imageFiles, List<File> xmlFiles) {
        List<File> filesList = new ArrayList<>();
        for (File image : imageFiles) {
            findXmlFile(xmlFiles, filesList, image);
        }
        return filesList;
    }

    private void findXmlFile(List<File> xmlFiles, List<File> filesList, File image) {
        for (File xmlFile : xmlFiles) {
            if (FilenameUtils.removeExtension(xmlFile.getName()).equals(FilenameUtils.removeExtension(image.getName()))) {
                filesList.add(image);
            }
        }
    }

    private List<SignatureFileDescriptionEntity> getResultFileList(String path, String signatureType, List<File> filesList, boolean withImage) throws IOException, JAXBException {
        List<SignatureFileDescriptionEntity> fileList = new ArrayList<>();
        // sort list of files and folders
        filesList = Ordering.from(FileDateComparator.instance).compound(FileNameComparator.instance).sortedCopy(filesList);
        for (File file : filesList) {
            // check if current file/folder is hidden
            if (checkFile(path, file)) {
                SignatureFileDescriptionEntity fileDescription = getSignatureFileDescriptionEntity(file, withImage);
                String fileName = file.getAbsolutePath().replace(DATA_PREVIEW_FOLDER, DATA_XML_FOLDER).replace(FilenameUtils.getExtension(file.getName()), "xml");
                fillProperties(fileDescription, fileName, signatureType);
                // add object to array list
                fileList.add(fileDescription);
            }
        }
        return fileList;
    }

    private void fillProperties(SignatureFileDescriptionEntity fileDescription, String fileName, String signatureType) throws JAXBException {
        if (QR_CODE.equals(signatureType) || BAR_CODE.equals(signatureType)) {
            OpticalXmlEntity opticalCodeData = new XMLReaderWriter<OpticalXmlEntity>().read(fileName, OpticalXmlEntity.class);
            fileDescription.setText(opticalCodeData.getText());
        } else if (TEXT.equals(signatureType)) {
            TextXmlEntity textXmlEntity = new XMLReaderWriter<TextXmlEntity>().read(fileName, TextXmlEntity.class);
            fileDescription.setText(textXmlEntity.getText());
            fileDescription.setFontColor(textXmlEntity.getFontColor());
        }
    }

    public void deleteSignatureFile(DeleteSignatureFileRequest deleteSignatureFileRequest) {
        String signatureType = deleteSignatureFileRequest.getSignatureType();
        if (IMAGE.equals(signatureType) ||
                DIGITAL.equals(signatureType)) {
            new File(deleteSignatureFileRequest.getGuid()).delete();
        } else {
            File file = new File(deleteSignatureFileRequest.getGuid());
            file.delete();
            String xmlFilePath = getXmlFilePath(file);
            new File(xmlFilePath).delete();
        }
    }

    private String getXmlFilePath(File file) {
        return file.getAbsolutePath().replace(DATA_PREVIEW_FOLDER, DATA_XML_FOLDER).replace(FilenameUtils.getExtension(file.getName()), "xml");
    }

    /**
     * Create file description
     *
     * @param file      file
     * @param withImage set image
     * @return signature file description
     * @throws IOException
     */
    private SignatureFileDescriptionEntity getSignatureFileDescriptionEntity(File file, boolean withImage) throws IOException {
        SignatureFileDescriptionEntity fileDescription = new SignatureFileDescriptionEntity();
        fileDescription.setGuid(file.getAbsolutePath());
        fileDescription.setName(file.getName());
        // set is directory true/false
        fileDescription.setDirectory(file.isDirectory());
        // set file size
        fileDescription.setSize(file.length());
        if (withImage) {
            // get image Base64 encoded String
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            fileDescription.setImage(getStringFromStream(fileInputStreamReader));
        }
        return fileDescription;
    }

    public SignaturePageEntity loadImage(LoadSignatureImageRequest loadSignatureImageRequest) {
        try {
            SignaturePageEntity loadedPage = new SignaturePageEntity();
            // get page image
            File file = new File(loadSignatureImageRequest.getGuid());
            byte[] bytes = Files.readAllBytes(file.toPath());
            // encode ByteArray into String
            String encodedImage = new String(Base64.getEncoder().encode(bytes));
            loadedPage.setData(encodedImage);
            if (TEXT.equals(loadSignatureImageRequest.getSignatureType())) {
                String fileName = getXmlFilePath(file);
                TextXmlEntity textXmlEntity = new XMLReaderWriter<TextXmlEntity>().read(fileName, TextXmlEntity.class);
                textXmlEntity.setImageGuid(loadSignatureImageRequest.getGuid());
                loadedPage.setProps(textXmlEntity);
            }
            // return loaded page object
            return loadedPage;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }


    /**
     * Read stream and convert to string
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public String getStringFromStream(InputStream inputStream) throws IOException {
        byte[] bytes = IOUtils.toByteArray(inputStream);
        // encode ByteArray into String
        return Base64.getEncoder().encodeToString(bytes);
    }
}
