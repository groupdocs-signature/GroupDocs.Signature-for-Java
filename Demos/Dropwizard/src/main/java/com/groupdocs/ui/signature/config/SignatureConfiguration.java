package com.groupdocs.ui.signature.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;

import static com.groupdocs.ui.common.config.DefaultDirectories.defaultSignatureDirectory;
import static com.groupdocs.ui.common.config.DefaultDirectories.relativePathToAbsolute;

/**
 * SignatureConfiguration
 *
 * @author Aspose Pty Ltd
 */
public class SignatureConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private String filesDirectory;

    @Valid
    @JsonProperty
    private String defaultDocument;

    @Valid
    @JsonProperty
    private int preloadPageCount;

    @Valid
    @JsonProperty
    private String dataDirectory;

    @Valid
    @JsonProperty
    private boolean  textSignature;

    @Valid
    @JsonProperty
    private boolean imageSignature;

    @Valid
    @JsonProperty
    private boolean digitalSignature;

    @Valid
    @JsonProperty
    private boolean qrCodeSignature;

    @Valid
    @JsonProperty
    private boolean barCodeSignature;

    @Valid
    @JsonProperty
    private boolean stampSignature;

    @Valid
    @JsonProperty
    private boolean handSignature;

    @Valid
    @JsonProperty
    private boolean  downloadOriginal;

    @Valid
    @JsonProperty
    private boolean downloadSigned;

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = StringUtils.isEmpty(filesDirectory) ? defaultSignatureDirectory() : relativePathToAbsolute(filesDirectory);
    }

    public String getDefaultDocument() {
        return defaultDocument;
    }

    public void setDefaultDocument(String defaultDocument) {
        this.defaultDocument = defaultDocument;
    }

    public int getPreloadPageCount() {
        return preloadPageCount;
    }

    public void setPreloadPageCount(int preloadPageCount) {
        this.preloadPageCount = preloadPageCount;
    }

    public String getDataDirectory() {
        return dataDirectory;
    }

    public void setDataDirectory(String dataDirectory) {
        this.dataDirectory = dataDirectory;
    }

    public boolean isTextSignature() {
        return textSignature;
    }

    public void setTextSignature(boolean textSignature) {
        this.textSignature = textSignature;
    }

    public boolean isImageSignature() {
        return imageSignature;
    }

    public void setImageSignature(boolean imageSignature) {
        this.imageSignature = imageSignature;
    }

    public boolean isDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(boolean digitalSignature) {
        this.digitalSignature = digitalSignature;
    }

    public boolean isQrCodeSignature() {
        return qrCodeSignature;
    }

    public void setQrCodeSignature(boolean qrCodeSignature) {
        this.qrCodeSignature = qrCodeSignature;
    }

    public boolean isBarCodeSignature() {
        return barCodeSignature;
    }

    public void setBarCodeSignature(boolean barCodeSignature) {
        this.barCodeSignature = barCodeSignature;
    }

    public boolean isStampSignature() {
        return stampSignature;
    }

    public void setStampSignature(boolean stampSignature) {
        this.stampSignature = stampSignature;
    }

    public boolean isHandSignature() {
        return handSignature;
    }

    public void setHandSignature(boolean handSignature) {
        this.handSignature = handSignature;
    }

    public boolean isDownloadOriginal() {
        return downloadOriginal;
    }

    public void setDownloadOriginal(boolean downloadOriginal) {
        this.downloadOriginal = downloadOriginal;
    }

    public boolean isDownloadSigned() {
        return downloadSigned;
    }

    public void setDownloadSigned(boolean downloadSigned) {
        this.downloadSigned = downloadSigned;
    }
}