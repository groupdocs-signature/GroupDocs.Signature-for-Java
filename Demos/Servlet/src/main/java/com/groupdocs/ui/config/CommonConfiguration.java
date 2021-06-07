package com.groupdocs.ui.config;

import io.xlate.inject.Property;
import io.xlate.inject.PropertyResource;

import javax.inject.Inject;

/**
 * CommonConfiguration
 *
 * @author Aspose Pty Ltd
 */
public class CommonConfiguration {

    @Inject
    @Property(name = "common.pageSelector", resource = @PropertyResource("classpath:configuration.properties"))
    private boolean pageSelector;

    @Inject
    @Property(name = "common.download", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean download;

    @Inject
    @Property(name = "common.upload", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean upload;

    @Inject
    @Property(name = "common.print", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean print;

    @Inject
    @Property(name = "common.browse", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean browse;

    @Inject
    @Property(name = "common.rewrite", resource = @PropertyResource("classpath:configuration.properties"))
    private Boolean rewrite;

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

    @Override
    public String toString() {
        return "CommonConfiguration{" +
                "pageSelector=" + pageSelector +
                ", download=" + download +
                ", upload=" + upload +
                ", print=" + print +
                ", browse=" + browse +
                ", rewrite=" + rewrite +
                '}';
    }
}
