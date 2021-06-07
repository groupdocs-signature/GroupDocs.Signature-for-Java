package com.groupdocs.ui.signature.entity.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;

/**
 * SignatureDataEntity
 *
 * @author Aspose Pty Ltd
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignatureDataEntity {
    private String reason;
    private String  contact;
    private String  address;
    private String  date;
    private String  signaturePassword;
    private String  signatureComment;
    private String documentType;
    private String signatureGuid;
    private String signatureType;
    private int pageNumber;
    private int left;
    private int top;
    private int imageWidth;
    private int imageHeight;
    private int angle;
    private int horizontalAlignment = HorizontalAlignment.None;
    private int verticalAlignment = VerticalAlignment.None;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSignaturePassword() {
        return signaturePassword;
    }

    public void setSignaturePassword(String signaturePassword) {
        this.signaturePassword = signaturePassword;
    }

    public String getSignatureComment() {
        return signatureComment;
    }

    public void setSignatureComment(String signatureComment) {
        this.signatureComment = signatureComment;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(String signatureType) {
        this.signatureType = signatureType;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getSignatureGuid() {
        return signatureGuid;
    }

    public void setSignatureGuid(String signatureGuid) {
        this.signatureGuid = signatureGuid;
    }

    public int getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(int horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    public int getVerticalAlignment() {
        return verticalAlignment;
    }

    public void setVerticalAlignment(int verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
    }
}
