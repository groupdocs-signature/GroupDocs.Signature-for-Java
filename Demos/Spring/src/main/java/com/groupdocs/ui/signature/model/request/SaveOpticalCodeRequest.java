package com.groupdocs.ui.signature.model.request;

import com.groupdocs.ui.signature.model.xml.OpticalXmlEntity;

public class SaveOpticalCodeRequest {
    private OpticalXmlEntity properties;
    private String signatureType;

    public OpticalXmlEntity getProperties() {
        return properties;
    }

    public void setProperties(OpticalXmlEntity properties) {
        this.properties = properties;
    }

    public String getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(String signatureType) {
        this.signatureType = signatureType;
    }
}
