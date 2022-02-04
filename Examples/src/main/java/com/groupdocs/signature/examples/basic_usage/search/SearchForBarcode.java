package com.groupdocs.signature.examples.basic_usage.search;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;

import java.nio.file.Paths;
import java.util.List;

public class SearchForBarcode {
    /**
     * Search document for Bar-Code signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;
        String fileName = Paths.get(filePath).getFileName().toString();
        try {
            Signature signature = new Signature(filePath);
            BarcodeSearchOptions options = new BarcodeSearchOptions();
            options.setAllPages(true); // this value is set by default

            // search for signatures in document
            List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class, options);
            System.out.print("\nSource document ['"+fileName+"'] contains following signatures. ");
            for (BarcodeSignature barcodeSignature : signatures)
            {
                System.out.print("Barcode signature found at page "+barcodeSignature.getPageNumber()+" with type "+barcodeSignature.getEncodeType()+" and text "+ barcodeSignature.getText());
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}