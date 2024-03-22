package com.groupdocs.signature.examples.advanced_usage.verify;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.verify.QrCodeVerifyOptions;

public class VerifyQRCodeAdvanced {
    /**
     * Verify document with QR-Code signature with applying specific options
     */
    public static void run()
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # VerifyQRCodeAdvanced : Verify document with QR-Code signature with applying specific options.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        try {
            Signature signature = new Signature(filePath);
            // create QRCode option with predefined QRCode text
            QrCodeVerifyOptions options = new QrCodeVerifyOptions();

            // specify if all pages shoudl be verified
            options.setAllPages(false);
            PagesSetup pagesSetup = new PagesSetup();
            pagesSetup.setFirstPage(true);
            options.setPagesSetup(pagesSetup);
            // specify text pattern
            options.setText("John");
            // specify verification text pattern
            options.setMatchType(TextMatchType.Contains);

            // sign document to file
            VerificationResult result = signature.verify(options);
            if (result.isValid()) {
                System.out.print("\nDocument was verified successfully!");
            } else {
                System.out.print("\nDocument failed verification process.");
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}