package com.groupdocs.signature.examples.advanced_usage.verify;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.FormTextFieldType;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.verify.QrCodeVerifyOptions;
import com.groupdocs.signature.options.verify.TextVerifyOptions;

public class VerifyTextAdvanced {
    /**
     * Verify document with Text signature with applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET_SIGNED;
        try {
            Signature signature = new Signature(filePath);
            // create QRCode option with predefined QRCode text
            TextVerifyOptions options = new TextVerifyOptions();

            // specify if all pages shoudl be verified
            options.setAllPages(false);
            PagesSetup pagesSetup = new PagesSetup();
            pagesSetup.setFirstPage(false);
            pagesSetup.setLastPage(true);
            pagesSetup.setOddPages(false);
            pagesSetup.setEvenPages(true);
            options.setPagesSetup(pagesSetup);
            // specify text pattern
            options.setText("John");
            // specify verification text pattern
            options.setMatchType(TextMatchType.Contains);
            // specify types of QR code to verify
            options.setSignatureImplementation(TextSignatureImplementation.Stamp);
            options.setFormTextFieldTitle("Sample");
            options.setFormTextFieldType(FormTextFieldType.RichText);

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