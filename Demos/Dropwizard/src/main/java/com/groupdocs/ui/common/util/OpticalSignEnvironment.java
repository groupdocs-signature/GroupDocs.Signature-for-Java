package com.groupdocs.ui.common.util;

import java.util.Locale;

/**
 * OS-specific optical-code document signing strategy (SIGNATUREJAVA-2903).
 */
public final class OpticalSignEnvironment {

    private OpticalSignEnvironment() {
    }

    public static boolean usePreviewImageForOpticalSign() {
        return !isWindows();
    }

    private static boolean isWindows() {
        return System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win");
    }
}
