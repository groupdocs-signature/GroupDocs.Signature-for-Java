package com.groupdocs.ui.signature.util.directory;

import static com.groupdocs.ui.signature.util.directory.PathConstants.DATA_PREVIEW_FOLDER;
import static com.groupdocs.ui.signature.util.directory.PathConstants.DATA_XML_FOLDER;
import static com.groupdocs.ui.signature.util.SignatureType.*;

public enum SignatureDirectory {

    BARCODE_DATA_DIRECTORY("/BarCodes"),
    CERTIFICATE_DATA_DIRECTORY("/Certificates"),
    IMAGE_DATA_DIRECTORY("/Image"),
    IMAGE_UPLOADED_DATA_DIRECTORY("/Image/Uploaded"),
    QRCODE_DATA_DIRECTORY("/ArCodes"),
    STAMP_DATA_DIRECTORY("/Stamps"),
    TEXT_DATA_DIRECTORY("/Text");


    private String path;

    SignatureDirectory(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getPreviewPath() {
        return path + DATA_PREVIEW_FOLDER;
    }

    public String getXMLPath() {
        return path + DATA_XML_FOLDER;
    }

    public static String getPathFromSignatureType(String signatureType) {
        switch (signatureType) {
            case DIGITAL:
                return CERTIFICATE_DATA_DIRECTORY.getPath();
            case IMAGE:
                return IMAGE_UPLOADED_DATA_DIRECTORY.getPath();
            case HAND:
                return IMAGE_DATA_DIRECTORY.getPath();
            case STAMP:
                return STAMP_DATA_DIRECTORY.getPath();
            case TEXT:
                return TEXT_DATA_DIRECTORY.getPath();
            case QR_CODE:
                return QRCODE_DATA_DIRECTORY.getPath();
            case BAR_CODE:
                return BARCODE_DATA_DIRECTORY.getPath();
            default:
                return null;
        }
    }
}
