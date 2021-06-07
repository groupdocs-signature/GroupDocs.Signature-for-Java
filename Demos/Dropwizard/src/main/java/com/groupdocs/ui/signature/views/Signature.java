package com.groupdocs.ui.signature.views;

import com.groupdocs.ui.common.config.GlobalConfiguration;
import io.dropwizard.views.View;

import java.nio.charset.Charset;

/**
 * Signature
 *
 * @author Aspose Pty Ltd
 */

public class Signature extends View {
    private GlobalConfiguration globalConfiguration;

    /**
     * Constructor
     * @param globalConfiguration total configuration
     * @param charset charset
     */
    public Signature(GlobalConfiguration globalConfiguration, String charset){
        super("signature.ftl", Charset.forName(charset));
        this.globalConfiguration = globalConfiguration;
    }

    /**
     * Get total config
     * @return total config
     */
    public GlobalConfiguration getGlobalConfiguration() {
        return globalConfiguration;
    }

    /**
     * Set total config
     * @param globalConfiguration total config
     */
    public void setGlobalConfiguration(GlobalConfiguration globalConfiguration) {
        this.globalConfiguration = globalConfiguration;
    }

}
