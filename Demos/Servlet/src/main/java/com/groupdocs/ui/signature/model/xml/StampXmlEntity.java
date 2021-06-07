package com.groupdocs.ui.signature.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * StampXmlEntity
 *
 * @author Aspose Pty Ltd
 */
@XmlRootElement(name="StampXmlEntity", namespace="StampXmlEntity")
@XmlAccessorType(XmlAccessType.FIELD)
public class StampXmlEntity extends XmlEntity {
    private String textExpansion;
    private String font;
    private String textColor = "rgb(0,0,0)";
    private String strokeColor = "rgb(0,0,0)";
    private String backgroundColor = "rgb(0,0,0)";
    private int radius;
    private int fontSize;
    private int textRepeat;

    public String getTextExpansion() {
        return textExpansion;
    }

    public void setTextExpansion(String textExpansion) {
        this.textExpansion = textExpansion;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getTextRepeat() {
        return textRepeat;
    }

    public void setTextRepeat(int textRepeat) {
        this.textRepeat = textRepeat;
    }
}
