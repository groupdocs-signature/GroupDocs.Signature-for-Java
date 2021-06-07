package com.groupdocs.ui.signature.entity.request;

/**
 * Object for request delete file with signature
 */
public class DeleteSignatureFileRequest {
    private String guid;
    private String signatureType;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(String signatureType) {
        this.signatureType = signatureType;
    }
}

