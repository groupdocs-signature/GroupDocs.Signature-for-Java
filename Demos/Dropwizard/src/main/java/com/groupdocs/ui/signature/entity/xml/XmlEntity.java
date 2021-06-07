package com.groupdocs.ui.signature.entity.xml;

/**
 * XmlEntity
 *
 * @author Aspose Pty Ltd
 */
public abstract class XmlEntity {
    private String imageGuid;
    private String text;
    private int width;
    private int height;

    public String getImageGuid() {
        return imageGuid;
    }

    public void setImageGuid(String imageGuid) {
        this.imageGuid = imageGuid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
