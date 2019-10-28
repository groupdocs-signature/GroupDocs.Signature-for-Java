package com.groupdocs.signature.examples.basic_usage.search;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SearchResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;
import com.groupdocs.signature.options.search.MetadataSearchOptions;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;
import com.groupdocs.signature.options.search.SearchOptions;

import java.util.ArrayList;
import java.util.List;

public class SearchForMultiple {
    /**
     * Search document for Multiple signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET_SIGNED;

        try {
            Signature signature = new Signature(filePath);
            BarcodeSearchOptions barcodeOptions = new BarcodeSearchOptions();
            barcodeOptions.setAllPages(true);
            barcodeOptions.setEncodeType(BarcodeTypes.Code128);

            QrCodeSearchOptions qrCodeOptions = new QrCodeSearchOptions();
            qrCodeOptions.setAllPages(true);
            qrCodeOptions.setEncodeType(QrCodeTypes.QR);
            qrCodeOptions.setText("John");
            qrCodeOptions.setMatchType(TextMatchType.Contains);

            MetadataSearchOptions metadataOptions = new MetadataSearchOptions();
            metadataOptions.setAllPages(true);
            metadataOptions.setIncludeBuiltinProperties(true);

            // add options to list
            List<SearchOptions> listOptions = new ArrayList<SearchOptions>();
            listOptions.add(barcodeOptions);
            listOptions.add(qrCodeOptions);
            listOptions.add(metadataOptions);

            // search for signatures in document
            SearchResult result = signature.search(listOptions);
            if (result.getSignatures().size() > 0)
            {
                System.out.print("\nSource document contains following signatures.");
                for (BaseSignature resSignature : result.getSignatures())
                {
                    System.out.print("Signature found at page "+resSignature.getPageNumber()+" with type "+resSignature.getSignatureType());
                }
            }
            else
            {
                System.out.print("No one signature was found.");
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}