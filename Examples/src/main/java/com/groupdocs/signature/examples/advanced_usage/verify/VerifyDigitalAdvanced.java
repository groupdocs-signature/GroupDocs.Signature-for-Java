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
        String filePath = Constants.SAMPLE_PDF_SIGNED_DIGITAL;
        try {
            Signature signature = new Signature(filePath);
            DigitalVerifyOptions options = new DigitalVerifyOptions();
            options.setComments("Approved");

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