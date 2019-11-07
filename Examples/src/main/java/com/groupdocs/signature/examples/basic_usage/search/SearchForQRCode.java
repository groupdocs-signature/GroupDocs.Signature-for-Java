package com.groupdocs.signature.examples.basic_usage.search;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.DigitalSearchOptions;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;

import java.util.List;

public class SearchForQRCode {
    /**
     * Search document for QR_Code signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        try {
            Signature signature = new Signature(filePath);
            QrCodeSearchOptions options = new QrCodeSearchOptions();
            options.setAllPages(true); // this value is set by default

            // search for signatures in document
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, options);
            System.out.print("\nSource document contains following signatures.");
            for (QrCodeSignature qrCodeSignature : signatures)
            {
                System.out.print("QRCode signature found at page "+qrCodeSignature.getPageNumber() +" with type "+qrCodeSignature.getEncodeType() +" and text "+ qrCodeSignature.getText());
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}