package com.groupdocs.signature.examples.basic_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;
import com.groupdocs.signature.options.search.DigitalSearchOptions;

import java.util.List;

public class SearchForDigital {
    /**
     * Search document for digital signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET_SIGNED;

        try {
            Signature signature = new Signature(filePath);
            DigitalSearchOptions options = new DigitalSearchOptions();

            // search for signatures in document
            List<DigitalSignature> signatures = signature.search(DigitalSignature.class, options);
            System.out.print("\nSource document contains following signatures.");
            for (DigitalSignature digitalSignature : signatures)
            {
                System.out.print("Digital signature found from "+digitalSignature.getSignTime()+" with validation flag "+digitalSignature.isValid()+". Certificate SN "+ digitalSignature.getCertificate().getType());
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}