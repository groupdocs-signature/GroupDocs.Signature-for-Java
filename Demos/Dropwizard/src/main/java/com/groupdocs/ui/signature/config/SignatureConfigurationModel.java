package com.groupdocs.ui.signature.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.common.config.CommonConfiguration;

import javax.validation.Valid;

public class SignatureConfigurationModel {
    @Valid
    @JsonProperty
    private boolean pageSelector;

    @Valid
    @JsonProperty
    private boolean download;

    @Valid
    @JsonProperty
    private boolean upload;

    @Valid
    @JsonProperty
    private boolean print;

    @Valid
    @JsonProperty
    private boolean browse;

    @Valid
    @JsonProperty
    private boolean rewrite;

    @Valid
    @JsonProperty
    private boolean enableRightClick;

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
    private boolean textSignature;

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
    private boolean downloadOriginal;

    @Valid
    @JsonProperty
    private boolean downloadSigned;

    public boolean isPageSelector() {
        return pageSelector;
    }

    public void setPageSelector(boolean pageSelector) {
        this.pageSelector = pageSelector;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    public boolean isUpload() {
        return upload;
    }

    public void setUpload(boolean upload) {
        this.upload = upload;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public boolean isBrowse() {
        return browse;
    }

    public void setBrowse(boolean browse) {
        this.browse = browse;
    }

    public boolean isRewrite() {
        return rewrite;
    }

    public void setRewrite(boolean rewrite) {
        this.rewrite = rewrite;
    }

    public boolean isEnableRightClick() {
        return enableRightClick;
    }

    public void setEnableRightClick(boolean enableRightClick) {
        this.enableRightClick = enableRightClick;
    }

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = filesDirectory;
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

    public static SignatureConfigurationModel createSignatureConfiguration(SignatureConfiguration signature, CommonConfiguration commonConfiguration) {
        SignatureConfigurationModel config = new SignatureConfigurationModel();
        config.setPageSelector(commonConfiguration.isPageSelector());
        config.setDownload(commonConfiguration.isDownload());
        config.setUpload(commonConfiguration.isUpload());
        config.setPrint(commonConfiguration.isPrint());
        config.setBrowse(commonConfiguration.isBrowse());
        config.setRewrite(commonConfiguration.isRewrite());
        config.setEnableRightClick(commonConfiguration.isEnableRightClick());
        config.setFilesDirectory(signature.getFilesDirectory());
        config.setDefaultDocument(signature.getDefaultDocument());
        config.setDataDirectory(signature.getDataDirectory());
        config.setPreloadPageCount(signature.getPreloadPageCount());
        config.setBarCodeSignature(signature.isBarCodeSignature());
        config.setDigitalSignature(signature.isDigitalSignature());
        config.setHandSignature(signature.isHandSignature());
        config.setImageSignature(signature.isImageSignature());
        config.setTextSignature(signature.isTextSignature());
        config.setStampSignature(signature.isStampSignature());
        config.setQrCodeSignature(signature.isQrCodeSignature());
        config.setDownloadOriginal(signature.isDownloadOriginal());
        config.setDownloadSigned(signature.isDownloadSigned());
        return config;
    }
}
