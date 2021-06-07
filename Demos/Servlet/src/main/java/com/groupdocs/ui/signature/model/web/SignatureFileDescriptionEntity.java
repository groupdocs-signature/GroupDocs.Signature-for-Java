package com.groupdocs.ui.signature.model.web;

import com.groupdocs.ui.model.response.FileDescriptionEntity;

/**
 * SignatureFileDescriptionEntity
 *
 * @author Aspose Pty Ltd
 */
public class SignatureFileDescriptionEntity extends FileDescriptionEntity {
    private String image;

    /**
     * Get incoded image Base64 string
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set incoded image Base64 string
     */
    public void setImage(String image) {
        this.image = image;
    }
}
