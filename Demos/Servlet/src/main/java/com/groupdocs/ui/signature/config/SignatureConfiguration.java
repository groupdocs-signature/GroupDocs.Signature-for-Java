package com.groupdocs.ui.signature.config;

import com.groupdocs.ui.config.CommonConfiguration;
import io.xlate.inject.Property;
import io.xlate.inject.PropertyResource;

import javax.inject.Inject;

public class SignatureConfiguration extends CommonConfiguration {

    @Inject
    @Property(name = "signature.filesDirectory", resource = @PropertyResource("classpath:configuration.properties"))
    private String filesDirectory;

    @Inject
    @Property(name = "signature.outputDirectory", resource = @PropertyResource("classpath:configuration.properties"))
    private String outputDirectory;

    @Inject
    @Property(name = "signature.dataDirectory", resource = @PropertyResource("classpath:configuration.properties"))
    private String dataDirectory;

    @Inject
    @Property(name = "signature.textSignature", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean textSignature;

    @Inject
    @Property(name = "signature.imageSignature", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean imageSignature;

    @Inject
    @Property(name = "signature.digitalSignature", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean digitalSignature;

    @Inject
    @Property(name = "signature.qrCodeSignature", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean qrCodeSignature;

    @Inject
    @Property(name = "signature.barCodeSignature", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean barCodeSignature;

    @Inject
    @Property(name = "signature.stampSignature", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean stampSignature;

    @Inject
    @Property(name = "signature.downloadOriginal", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean  downloadOriginal;

    @Inject
    @Property(name = "signature.downloadSigned", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean downloadSigned;

    @Inject
    @Property(name = "signature.preloadPageCount", resource = @PropertyResource("classpath:configuration.properties"))
    private Integer preloadPageCount;

    @Inject
    @Property(name = "signature.defaultDocument", resource = @PropertyResource("classpath:configuration.properties"))
    private String defaultDocument;

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = filesDirectory;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public String getDataDirectory() {
        return dataDirectory;
    }

    public void setDataDirectory(String dataDirectory) {
        this.dataDirectory = dataDirectory;
    }

    public Boolean getTextSignature() {
        return textSignature;
    }

    public void setTextSignature(Boolean textSignature) {
        this.textSignature = textSignature;
    }

    public Boolean getImageSignature() {
        return imageSignature;
    }

    public void setImageSignature(Boolean imageSignature) {
        this.imageSignature = imageSignature;
    }

    public Boolean getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(Boolean digitalSignature) {
        this.digitalSignature = digitalSignature;
    }

    public Boolean getQrCodeSignature() {
        return qrCodeSignature;
    }

    public void setQrCodeSignature(Boolean qrCodeSignature) {
        this.qrCodeSignature = qrCodeSignature;
    }

    public Boolean getBarCodeSignature() {
        return barCodeSignature;
    }

    public void setBarCodeSignature(Boolean barCodeSignature) {
        this.barCodeSignature = barCodeSignature;
    }

    public Boolean getStampSignature() {
        return stampSignature;
    }

    public void setStampSignature(Boolean stampSignature) {
        this.stampSignature = stampSignature;
    }

    public Boolean getDownloadOriginal() {
        return downloadOriginal;
    }

    public void setDownloadOriginal(Boolean downloadOriginal) {
        this.downloadOriginal = downloadOriginal;
    }

    public Boolean getDownloadSigned() {
        return downloadSigned;
    }

    public void setDownloadSigned(Boolean downloadSigned) {
        this.downloadSigned = downloadSigned;
    }

    public Integer getPreloadPageCount() {
        return preloadPageCount;
    }

    public void setPreloadPageCount(Integer preloadPageCount) {
        this.preloadPageCount = preloadPageCount;
    }

    public String getDefaultDocument() {
        return defaultDocument;
    }

    public void setDefaultDocument(String defaultDocument) {
        this.defaultDocument = defaultDocument;
    }

    @Override
    public String toString() {
        return super.toString() +
                "SignatureConfiguration{" +
                "filesDirectory='" + filesDirectory + '\'' +
                ", outputDirectory='" + outputDirectory + '\'' +
                ", dataDirectory='" + dataDirectory + '\'' +
                ", textSignature=" + textSignature +
                ", imageSignature=" + imageSignature +
                ", digitalSignature=" + digitalSignature +
                ", qrCodeSignature=" + qrCodeSignature +
                ", barCodeSignature=" + barCodeSignature +
                ", stampSignature=" + stampSignature +
                ", downloadOriginal=" + downloadOriginal +
                ", downloadSigned=" + downloadSigned +
                ", preloadPageCount=" + preloadPageCount +
                ", defaultDocument='" + defaultDocument + '\'' +
                '}';
    }
}
