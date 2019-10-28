package com.groupdocs.signature.examples.basic_usage.verify;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.verify.*;

import java.util.ArrayList;
import java.util.List;

public class VerifyWithMultipleOptions {
    /**
     * Verify document with Text signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        try {
            Signature signature = new Signature(filePath);
            TextVerifyOptions textVerifyOptions = new TextVerifyOptions();
            textVerifyOptions.setAllPages(true); // this value is set by default
            textVerifyOptions.setText("John");
            textVerifyOptions.setSignatureImplementation(TextSignatureImplementation.Stamp);
            textVerifyOptions.setMatchType(TextMatchType.Contains);

            BarcodeVerifyOptions barcVerifyOptions = new BarcodeVerifyOptions();
            barcVerifyOptions.setAllPages(true); // this value is set by default
            barcVerifyOptions.setText("John");
            barcVerifyOptions.setMatchType(TextMatchType.Contains);

            QrCodeVerifyOptions qrcdVerifyOptions = new QrCodeVerifyOptions();
            qrcdVerifyOptions.setAllPages(true); // this value is set by default
            qrcdVerifyOptions.setText("John");
            qrcdVerifyOptions.setMatchType(TextMatchType.Contains);

            DigitalVerifyOptions digtVerifyOptions = new DigitalVerifyOptions();
            digtVerifyOptions.setComments("Test comment"); // this value is set by default

            // verify document signatures
            List<VerifyOptions> listOptions = new ArrayList<VerifyOptions>();
            listOptions.add(textVerifyOptions);
            listOptions.add(barcVerifyOptions);
            listOptions.add(qrcdVerifyOptions);
            listOptions.add(digtVerifyOptions);

            // verify document signatures
            VerificationResult result = signature.verify(listOptions);
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