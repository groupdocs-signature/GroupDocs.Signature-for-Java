package com.groupdocs.ui.signature.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TextXmlEntity
 *
 * @author Aspose Pty Ltd
 */
@XmlRootElement(name="TextXmlEntity", namespace="TextXmlEntity")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextXmlEntity extends XmlEntity {
    private String encodedImage;

    private String backgroundColor = "rgb(0,0,0)";
    private String fontColor = "rgb(0,0,0)";
    private String borderColor = "rgb(0,0,0)";
    private String font;
    private int borderStyle;
    private int fontSize;
    private int borderWidth;
    private Boolean bold;
    private Boolean italic;
    private Boolean underline;

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(int borderStyle) {
        this.borderStyle = borderStyle;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public Boolean getBold() {
        return bold;
    }

    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    public Boolean getItalic() {
        return italic;
    }

    public void setItalic(Boolean italic) {
        this.italic = italic;
    }

    public Boolean getUnderline() {
        return underline;
    }

    public void setUnderline(Boolean underline) {
        this.underline = underline;
    }
}
