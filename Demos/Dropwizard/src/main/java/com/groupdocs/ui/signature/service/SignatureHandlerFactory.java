package com.groupdocs.ui.signature.service;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.ui.common.config.DefaultDirectories;
import org.apache.commons.lang3.StringUtils;

import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.groupdocs.ui.signature.util.directory.PathConstants.DATA_FOLDER;
import static com.groupdocs.ui.signature.util.directory.SignatureDirectory.*;

public class SignatureHandlerFactory {

    public static SignatureHandler instance;
    public static SignatureHandler streamInstance;

    /**
     * Create instance of SignatureHandler
     *
     * @param filesDirectory
     * @param dataDirectory
     * @return
     */
    public synchronized static SignatureHandler createHandler(String filesDirectory, String dataDirectory) {
        if (instance == null) {
            String directory = StringUtils.isEmpty(dataDirectory) ? filesDirectory + DATA_FOLDER : dataDirectory;
            // create directories
            createDirectories(directory);

            // create signature application configuration
            SignatureConfig config = new SignatureConfig();
            config.setStoragePath(filesDirectory);
            config.setCertificatesPath(getFullDataPathStr(directory, CERTIFICATE_DATA_DIRECTORY.getPath()));
            config.setImagesPath(getFullDataPathStr(directory, IMAGE_DATA_DIRECTORY.getPath()));

            instance = new SignatureHandler(config);
        }
        return instance;
    }

    /**
     * Create instance of SignatureHandler for streams
     *
     * @return
     */
    public synchronized static SignatureHandler createStreamHandler() {
        if (streamInstance == null) {
            SignatureConfig config = new SignatureConfig();
            config.setOutputPath(FileSystems.getDefault().getPath("").toAbsolutePath().toString());
            SignatureHandler<OutputStream> streamSignatureHandler = new SignatureHandler<>(config);
            streamInstance = streamSignatureHandler;
        }
        return streamInstance;
    }

    public static Path getFullDataPath(String dataDirectory, String partPath) {
        return Paths.get(String.format("%s%s", dataDirectory, partPath));
    }

    public static String getFullDataPathStr(String dataDirectory, String partPath) {
        return String.format("%s%s", dataDirectory, partPath);
    }

    public static void createDirectories(String dataDirectory) {
        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, CERTIFICATE_DATA_DIRECTORY.getPath()));
        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, IMAGE_DATA_DIRECTORY.getPath()));
        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, IMAGE_UPLOADED_DATA_DIRECTORY.getPath()));

        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, STAMP_DATA_DIRECTORY.getXMLPath()));
        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, STAMP_DATA_DIRECTORY.getPreviewPath()));

        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, QRCODE_DATA_DIRECTORY.getXMLPath()));
        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, QRCODE_DATA_DIRECTORY.getPreviewPath()));

        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, BARCODE_DATA_DIRECTORY.getXMLPath()));
        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, BARCODE_DATA_DIRECTORY.getPreviewPath()));

        DefaultDirectories.makeDirs(getFullDataPath(dataDirectory, TEXT_DATA_DIRECTORY.getXMLPath()));
    }
}
