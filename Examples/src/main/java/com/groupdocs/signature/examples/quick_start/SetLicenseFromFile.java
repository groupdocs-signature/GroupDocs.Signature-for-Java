package com.groupdocs.signature.examples.quick_start;


import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.licensing.License;

import java.io.File;
import java.nio.file.Files;

public class SetLicenseFromFile {
    /**
     * This example demonstrates how to set license from file.
     *
     * You can also use the additional overload to load a license from a stream, this is useful for instance when the
     * License is stored as an embedded resource.
     */
    public static void run()
    {
        File file = new File(Constants.LicensePath);
        if (file.exists())
        {
            License license = new License();
            license.setLicense(Constants.LicensePath);

            System.out.print("\nLicense set successfully.");
        }
        else
        {
            System.out.print("\nWe do not ship any license with this example. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}