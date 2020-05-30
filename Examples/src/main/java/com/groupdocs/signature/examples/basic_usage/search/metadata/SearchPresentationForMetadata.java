package com.groupdocs.signature.examples.basic_usage.search.metadata;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.metadata.PresentationMetadataSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;

public class SearchPresentationForMetadata {
    /**
     * Search document for metadata signature
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SearchPresentationForMetadata : Search Presentation document for metadata signature(s)\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PRESENTATION_SIGNED_METADATA;
        Signature signature = new Signature(filePath);
        {
            // search for signatures in document
            List<PresentationMetadataSignature> signatures = signature.search(PresentationMetadataSignature.class, SignatureType.Metadata);
            System.out.print("\nSource document ['"+filePath+"'] contains following signatures.");
            for (PresentationMetadataSignature mdSignature : signatures)
            {
                System.out.print("\t["+mdSignature.getName()+"] = "+mdSignature.getValue());
            }
        }
    }
}