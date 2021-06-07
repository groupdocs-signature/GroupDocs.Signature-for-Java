package com.groupdocs.ui.signature.entity.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="StampXmlEntityList", namespace="StampXmlEntityList")
@XmlAccessorType(XmlAccessType.FIELD)
public class StampXmlEntityList {
    private List<StampXmlEntity> stampXmlEntityList;

    public List<StampXmlEntity> getStampXmlEntityList() {
        return stampXmlEntityList;
    }

    public void setStampXmlEntityList(List<StampXmlEntity> stampXmlEntityList) {
        this.stampXmlEntityList = stampXmlEntityList;
    }
}
