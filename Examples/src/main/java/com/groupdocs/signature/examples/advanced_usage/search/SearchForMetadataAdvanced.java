package com.groupdocs.signature.examples.advanced_usage.search;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.signatures.metadata.MetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.MetadataSearchOptions;

import java.util.List;

public class SearchForMetadataAdvanced {
    /**
     * Search document for metadata signature with applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        try {
            Signature signature = new Signature(filePath);
            MetadataSearchOptions options = new MetadataSearchOptions();
            options.setName("Producer");
            options.setIncludeBuiltinProperties(true);
            options.setNameMatchType(TextMatchType.Contains);

            // search for signatures in document
            List<MetadataSignature> signatures = signature.search(MetadataSignature.class, options);
            System.out.print("\nSource document contains following signatures.");
            for (MetadataSignature metadataSignature : signatures)
            {
                System.out.print("Metadata signature found. Name : "+metadataSignature.getName()+". Value: "+ metadataSignature.getValue());
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}