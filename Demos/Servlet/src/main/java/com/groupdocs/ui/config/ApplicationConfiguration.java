package com.groupdocs.ui.config;

import io.xlate.inject.Property;
import io.xlate.inject.PropertyResource;

import javax.inject.Inject;

public class ApplicationConfiguration {

    @Inject
    @Property(name="application.licensePath", resource = @PropertyResource("classpath:configuration.properties"))
    private String licensePath;

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    @Override
    public String toString() {
        return "ApplicationConfiguration{" +
                "licensePath='" + licensePath + '\'' +
                '}';
    }
}
