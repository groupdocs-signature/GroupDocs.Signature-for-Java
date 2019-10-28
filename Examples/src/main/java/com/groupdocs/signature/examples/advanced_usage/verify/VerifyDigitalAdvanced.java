package com.groupdocs.signature.examples.advanced_usage.verify;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.verify.DigitalVerifyOptions;

import java.util.Date;

public class VerifyDigitalAdvanced {
    /**
     * Verify document with digital signature with applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;
        String certificate = Constants.CertificateCer;
        try {
            Signature signature = new Signature(filePath);
            DigitalVerifyOptions options = new DigitalVerifyOptions(certificate);
                options.setComments("Test1");
                options.setSignDateTimeFrom(new Date(2019, 5, 1));

            // verify document signatures

            VerificationResult result = signature.verify(options);
            if (result.isValid())
            {
                System.out.print("\nDocument was verified successfully!");
            }
            else
            {
                System.out.print("\nDocument failed verification process.");
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }
}