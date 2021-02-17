package com.groupdocs.signature.examples.basic_usage.verify;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.verify.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VerifyWithMultipleOptions {
    /**
     * Verify document with Text signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;

        try {
            Signature signature = new Signature(filePath);
            TextVerifyOptions textVerifyOptions = new TextVerifyOptions();
            textVerifyOptions.setAllPages(true); // this value is set by default
            textVerifyOptions.setText("Text signature");
            textVerifyOptions.setSignatureImplementation(TextSignatureImplementation.Native);
            textVerifyOptions.setMatchType(TextMatchType.Contains);

            BarcodeVerifyOptions barcVerifyOptions = new BarcodeVerifyOptions();
            barcVerifyOptions.setAllPages(true); // this value is set by default
            barcVerifyOptions.setText("12345");
            barcVerifyOptions.setMatchType(TextMatchType.Contains);

            QrCodeVerifyOptions qrcdVerifyOptions = new QrCodeVerifyOptions();
            qrcdVerifyOptions.setAllPages(true); // this value is set by default
            qrcdVerifyOptions.setText("John");
            qrcdVerifyOptions.setMatchType(TextMatchType.Contains);

            DigitalVerifyOptions digtVerifyOptions = new DigitalVerifyOptions();
            digtVerifyOptions.setPassword("1234567890");

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