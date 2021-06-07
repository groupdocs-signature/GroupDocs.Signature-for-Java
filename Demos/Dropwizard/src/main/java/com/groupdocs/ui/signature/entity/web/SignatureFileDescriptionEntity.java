package com.groupdocs.ui.signature.entity.web;

import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;

/**
 * SignatureFileDescriptionEntity
 *
 * @author Aspose Pty Ltd
 */
public class SignatureFileDescriptionEntity extends FileDescriptionEntity {
    private String image;
    private String text;
    private String fontColor;

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get encoded image Base64 string
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set encoded image Base64 string
     */
    public void setImage(String image) {
        this.image = image;
    }
}
