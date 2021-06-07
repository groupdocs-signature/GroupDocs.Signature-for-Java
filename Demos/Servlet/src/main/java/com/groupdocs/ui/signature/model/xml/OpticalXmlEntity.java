package com.groupdocs.ui.signature.model.xml;

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
public class OpticalXmlEntity extends XmlEntity {
    private String borderColor = "rgb(0,0,0)";
    private String encodedImage;
    private int borderStyle;
    private int borderWidth;

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public int getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(int borderStyle) {
        this.borderStyle = borderStyle;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }
}
