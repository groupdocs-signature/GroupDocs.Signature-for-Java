package com.groupdocs.signature.examples.basic_usage.search.metadata;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.metadata.SpreadsheetMetadataSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;

public class SearchSpreadsheetForMetadata {
    /**
     * Search document for metadata signature
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SearchSpreadsheetForMetadata : Search Spreadsheet document for metadata signature(s)\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET_SIGNED_METADATA;
        Signature signature = new Signature(filePath);
        {
            // search for signatures in document
            List<SpreadsheetMetadataSignature> signatures = signature.search(SpreadsheetMetadataSignature.class, SignatureType.Metadata);
            System.out.print("\nSource document ['"+filePath+"'] contains following signatures.");
            for (SpreadsheetMetadataSignature mdSignature : signatures)
            {
                System.out.print("\t["+mdSignature.getName()+"] = "+mdSignature.getValue());
            }
        }
    }
}