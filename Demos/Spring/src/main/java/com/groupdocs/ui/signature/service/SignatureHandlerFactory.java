package com.groupdocs.ui.signature.service;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.ui.config.DefaultDirectories;
import org.springframework.util.StringUtils;

import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.groupdocs.ui.util.directory.PathConstants.DATA_FOLDER;
import static com.groupdocs.ui.util.directory.SignatureDirectory.*;

public class SignatureHandlerFactory {

    public static Signature instance;
    public static Signature streamInstance;

    /**
     * Create instance of SignatureHandler
     *
     * @param filesDirectory
     * @param dataDirectory
     * @return
     */
    public synchronized static Signature createHandler(String filesDirectory, String dataDirectory) {
        if (instance == null) {
            String directory = StringUtils.isEmpty(dataDirectory) ? filesDirectory + DATA_FOLDER : dataDirectory;
            // create directories
            createDirectories(directory);

            // create signature application configuration
            LoadOptions loadOptions = new LoadOptions();
            //loadOptions.setStoragePath(filesDirectory);
            //loadOptions.setCertificatesPath(getFullDataPathStr(directory, CERTIFICATE_DATA_DIRECTORY.getPath()));
            //loadOptions.setImagesPath(getFullDataPathStr(directory, IMAGE_DATA_DIRECTORY.getPath()));

            //instance = new Signature("",loadOptions);
        }
        return instance;
    }

    /**
     * Create instance of SignatureHandler for streams
     *
     * @return
     */
    public synchronized static Signature createStreamHandler() {
        if (streamInstance == null) {
            //Signature signature = new Signature(FileSystems.getDefault().getPath("").toAbsolutePath().toString());
            //config.setOutputPath(FileSystems.getDefault().getPath("").toAbsolutePath().toString());
            //Signature streamSignatureHandler = signature;
            //streamInstance = streamSignatureHandler;
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
