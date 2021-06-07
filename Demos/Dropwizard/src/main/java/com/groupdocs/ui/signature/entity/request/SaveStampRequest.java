package com.groupdocs.ui.signature.entity.request;


import com.groupdocs.ui.signature.entity.xml.StampXmlEntity;

import java.util.List;

public class SaveStampRequest {
    private String image;
    private List<StampXmlEntity> stampData;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<StampXmlEntity> getStampData() {
        return stampData;
    }

    public void setStampData(List<StampXmlEntity> stampData) {
        this.stampData = stampData;
    }
}
