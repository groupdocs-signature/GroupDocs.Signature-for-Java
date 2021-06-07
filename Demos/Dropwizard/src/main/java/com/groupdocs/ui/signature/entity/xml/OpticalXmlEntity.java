package com.groupdocs.ui.signature.entity.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * OpticalXmlEntity
 *
 * @author Aspose Pty Ltd
 */
@XmlRootElement(name="OpticalXmlEntity", namespace="OpticalXmlEntity")
@XmlAccessorType(XmlAccessType.FIELD)
public class OpticalXmlEntity extends XmlEntityWithImage {
    private Boolean temp = Boolean.FALSE;

    public Boolean getTemp() {
        return temp;
    }

    public void setTemp(Boolean temp) {
        this.temp = temp;
    }
}
