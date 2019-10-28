package com.groupdocs.signature.examples.basic_usage.verify;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.verify.BarcodeVerifyOptions;
import com.groupdocs.signature.options.verify.DigitalVerifyOptions;

public class VerifyDigital {
    /**
     * Verify document with digital signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        try {
            Signature signature = new Signature(filePath);
            DigitalVerifyOptions options = new DigitalVerifyOptions(Constants.CertificatePfx);
            options.setComments("Test comment");
            options.setPassword("1234567890");

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