package com.groupdocs.ui.signature.model;

import static com.groupdocs.ui.signature.util.PathConstants.DATA_PREVIEW_FOLDER;
import static com.groupdocs.ui.signature.util.PathConstants.DATA_XML_FOLDER;

public enum SignatureDirectory {

    BARCODE_DATA_DIRECTORY("/BarCodes"),
    CERTIFICATE_DATA_DIRECTORY("/Certificates"),
    IMAGE_DATA_DIRECTORY("/Image"),
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
            case "digital":  return CERTIFICATE_DATA_DIRECTORY.getPath();
            case "image": return IMAGE_DATA_DIRECTORY.getPath();
            case "stamp": return STAMP_DATA_DIRECTORY.getPath();
            case "text": return TEXT_DATA_DIRECTORY.getPath();
            default:  return null;
        }
    }
}
