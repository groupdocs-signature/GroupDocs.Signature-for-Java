package com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.metadata.ImageMetadataSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;

public class SearchImageForMetadataAdvanced {
    /**
    * Search Image document for metadata signature advanced.
    * This example shows how to get various data type values from metadata signature
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchImageForMetadataAdvanced : Search Image document for metadata signature(s)\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_IMAGE_SIGNED_METADATA;
        Signature signature = new Signature(filePath);
        {
            // search for signatures in document
            List<ImageMetadataSignature> signatures = signature.search(ImageMetadataSignature.class, SignatureType.Metadata);
            // try to get each Image signature with proper data type added in Basic usage example SignImageWithMetadata
            // specify Id we started to sign
            int imgsMetadataId = 41997;
            ImageMetadataSignature mdSignature;
            // See example SignImageWithMetadata with added various data type values to signatures
            try
            {
                mdSignature = firstOrDefault(signatures, imgsMetadataId);
                System.out.print("\t["+mdSignature.getId()+"] as String = "+mdSignature.toString());

            }
            catch(Exception ex)
            {
                System.out.print("Error obtaining signature: "+ex.getMessage());
            }
        }
    }

    public static ImageMetadataSignature firstOrDefault(List<ImageMetadataSignature> signatures , int imgsMetadataId){
        ImageMetadataSignature imgSignature = null;
        for (ImageMetadataSignature signature :signatures ){
            if (signature.getId()== imgsMetadataId){
                imgSignature = signature;
                break;
            }
        }
        return imgSignature;
    }

}