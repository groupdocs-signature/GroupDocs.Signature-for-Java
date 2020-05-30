package com.groupdocs.signature.examples.basic_usage.search.metadata;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.metadata.ImageMetadataSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;

public class SearchImageForMetadata {
    /**
     * Search document for metadata signature
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SearchImageForMetadata : Search Image document for metadata signature(s)\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_IMAGE_SIGNED_METADATA;
        Signature signature = new Signature(filePath);
        {
            // search for signatures in document
            List<ImageMetadataSignature> signatures = signature.search(ImageMetadataSignature.class, SignatureType.Metadata);
            System.out.print("\nSource document ['"+filePath+"'] contains following signatures.");
            for(ImageMetadataSignature mdSignature : signatures)
            {
                // display only added from example with 41996 + numbers
                if (mdSignature.getId() > 41995)
                {
                    System.out.print("\t["+mdSignature.getId()+"] = "+mdSignature.getValue());
                }
            }
        }
    }
}