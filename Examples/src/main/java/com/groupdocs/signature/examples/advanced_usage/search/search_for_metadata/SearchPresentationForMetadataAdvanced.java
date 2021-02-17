package com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.metadata.PresentationMetadataSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;

public class SearchPresentationForMetadataAdvanced {
    /**
    * Search document for metadata signature
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchPresentationForMetadataAdvanced : Search Presentation document for metadata signature(s)\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PRESENTATION_SIGNED_METADATA;
        Signature signature = new Signature(filePath);
        {
            // search for signatures in document
            List<PresentationMetadataSignature> signatures = signature.search(PresentationMetadataSignature.class, SignatureType.Metadata);
            // try to get each Presentation signature with proper data type added in Basic usage example SignPresentationWithMetadata
            // See example SignPresentationWithMetadata with added various data type values to signatures
            try
            {
                for(PresentationMetadataSignature mdSign : signatures){
                    switch (mdSign.getName()){
                        case "Author":
                            System.out.print("\t["+mdSign.getName()+"] as String = "+mdSign.toString());
                            continue;
                        case "CreatedOn":
                            System.out.print("\t["+mdSign.getName()+"] as String = "+mdSign.toDateTime());
                            continue;
                        case "DocumentId":
                            System.out.print("\t["+mdSign.getName()+"] as Integer = "+mdSign.toInteger());
                            continue;
                        case "SignatureId":
                            System.out.print("\t["+mdSign.getName()+"] as Double = "+mdSign.toDouble());
                            continue;
                        case "Amount":
                            System.out.print("\t["+mdSign.getName()+"] as Decimal = "+mdSign.toDouble());
                            continue;
                        case "Total":
                            System.out.print("\t["+mdSign.getName()+"] as Float = "+mdSign.toSingle());
                            continue;
                    }
                }
            }
            catch (Exception ex)
            {
                System.out.print("Error obtaining signature: "+ex.getMessage());
            }
        }
    }
}
