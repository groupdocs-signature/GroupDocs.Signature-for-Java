package com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.metadata.WordProcessingMetadataSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;

public class SearchWordProcessingForMetadataAdvanced {
    /**
    * Search document for metadata signature
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchWordProcessingForMetadataAdvanced : Search Word Processing document for metadata signature(s)\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDSPROCESSING_SIGNED_METADATA;
        Signature signature = new Signature(filePath);
        {
            // search for signatures in document
            List<WordProcessingMetadataSignature> signatures = signature.search(WordProcessingMetadataSignature.class, SignatureType.Metadata);
            // try to get each WordProcessing signature with proper data type added in Basic usage example SignWordProcessingWithMetadata
            // See example SignWordProcessingWithMetadata with added various data type values to signatures
            try
            {
                for(WordProcessingMetadataSignature mdSign : signatures){
                    switch (mdSign.getName()){
                        case "Author":
                            System.out.print("\t["+mdSign.getName()+"] as String = "+mdSign.toString());
                        case "CreatedOn":
                            System.out.print("\t["+mdSign.getName()+"] as String = "+mdSign.toDateTime());
                        case "DocumentId":
                            System.out.print("\t["+mdSign.getName()+"] as Integer = "+mdSign.toInteger());
                        case "SignatureId":
                            System.out.print("\t["+mdSign.getName()+"] as Double = "+mdSign.toDouble());
                        case "Amount":
                            System.out.print("\t["+mdSign.getName()+"] as Decimal = "+mdSign.toDouble());
                        case "Total":
                            System.out.print("\t["+mdSign.getName()+"] as Float = "+mdSign.toDouble());
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
