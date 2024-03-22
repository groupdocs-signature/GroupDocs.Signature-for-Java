package com.groupdocs.signature.examples.basic_usage.verify;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.verify.TextVerifyOptions;


public class VerifyText {
    /**
     * Verify document with QR-Code signature
     */
    public static void run()
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # VerifyText : Verify document with QR-Code signature.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;

        try {
            Signature signature = new Signature(filePath);
            TextVerifyOptions options = new TextVerifyOptions();
            options.setSignatureImplementation(TextSignatureImplementation.Native);
            options.setText("signature");
            options.setMatchType(TextMatchType.Contains);

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