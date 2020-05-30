package com.groupdocs.signature.examples.basic_usage.search.metadata;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.metadata.PdfMetadataSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;

public class SearchPdfForMetadata {
    /**
     * Search document for metadata signature
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SearchPdfForMetadata : Search Pdf document for metadata signature(s)\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED_METADATA;
        Signature signature = new Signature(filePath);
        {
            // search for signatures in document
            List<PdfMetadataSignature> signatures = signature.search(PdfMetadataSignature.class, SignatureType.Metadata);
            System.out.print("\nSource document ['"+filePath+"'] contains following signatures.");
            for(PdfMetadataSignature mdSignature : signatures)
            {
                System.out.print("\t["+mdSignature.getTagPrefix()+" : "+mdSignature.getName()+"] = "+mdSignature.getValue());
            }
        }
    }
}