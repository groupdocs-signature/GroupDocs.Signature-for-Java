package com.groupdocs.signature.examples.quick_start;


import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.licensing.License;

import java.io.File;
import java.io.FileInputStream;

public class SetLicenseFromStream {
    /**
     * This example demonstrates how to set license from stream.
     */
    public static void run() throws Exception
    {
        File file = new File(Constants.LicensePath);
        if (file.exists())
        {
            FileInputStream stream = new FileInputStream(file);
            License license = new License();
            license.setLicense(stream);

            System.out.print("License set successfully.");
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