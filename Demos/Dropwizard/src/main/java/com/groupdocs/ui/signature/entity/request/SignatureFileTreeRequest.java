package com.groupdocs.ui.signature.entity.request;

public class SignatureFileTreeRequest {
    private String path;
    private String signatureType;

    public String getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(String signatureType) {
        this.signatureType = signatureType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
