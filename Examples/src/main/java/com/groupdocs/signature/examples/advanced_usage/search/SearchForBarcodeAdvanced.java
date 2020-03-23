package com.groupdocs.signature.examples.advanced_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;

import java.util.List;


public class SearchForBarcodeAdvanced {
    /**
     * Search document for Bar-Code signature with applying specific options
     */
    public static void run() {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        try {
            Signature signature = new Signature(filePath);
            BarcodeSearchOptions options = new BarcodeSearchOptions();
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
            options.setEncodeType(BarcodeTypes.Code39Standard);
            // specify text match type
            options.setMatchType(TextMatchType.Contains);
            // specify text pattern to search
            options.setText("12345678");

            // search for signatures in document
            List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class, options);

            System.out.print("\nSource document contains following signatures.");
            for (BarcodeSignature barcodeSignature : signatures) {
                System.out.print("Barcode signature found at page " + barcodeSignature.getPageNumber() + " with type " + barcodeSignature.getEncodeType() + " and text " + barcodeSignature.getText());
            }
        } catch (Exception ex) {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }
}