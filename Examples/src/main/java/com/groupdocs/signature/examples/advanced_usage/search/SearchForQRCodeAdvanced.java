package com.groupdocs.signature.examples.advanced_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;

import java.util.List;


public class SearchForQRCodeAdvanced {
    /**
     * Search document for QR-Code signature with applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        try {
            Signature signature = new Signature(filePath);
            QrCodeSearchOptions options = new QrCodeSearchOptions();
            options.setAllPages(true); // this value is set by default
            // single page number
            options.setPageNumber(1);
            // setup extended search in pages setup
            PagesSetup pagesSetup  = new PagesSetup() ;
            pagesSetup.setFirstPage(true);
            pagesSetup.setLastPage(true);
            pagesSetup.setOddPages(false);
            pagesSetup.setEvenPages(false);
            options.setPagesSetup(pagesSetup);

            // specify special barcode type to search
            options.setEncodeType(QrCodeTypes.QR);
            // specify text match type
            options.setMatchType(TextMatchType.Exact);
            // specify text pattern to search
            options.setText("12345678");

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