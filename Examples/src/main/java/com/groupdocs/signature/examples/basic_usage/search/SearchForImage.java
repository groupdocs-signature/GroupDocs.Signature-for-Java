package com.groupdocs.signature.examples.basic_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.ImageSignature;
import com.groupdocs.signature.examples.Constants;

import java.nio.file.Paths;
import java.util.List;

public class SearchForImage {
    /**
     * <p>
     * Search document for Image signature
     * </p>
     */
    public static void run()
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SearchForImage : Search document for Image signature.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        String fileName = Paths.get(filePath).getFileName().toString();
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // search document
            List<ImageSignature> signatures = signature.search(ImageSignature.class, SignatureType.Image);
            System.out.print("\nSource document ['"+fileName+"'] contains following image signature(s).");
            // output signatures
            try
            {
                for (ImageSignature imageSignature : signatures)
                {
                    System.out.print("Image signature found at page "+imageSignature.getPageNumber()+" with size "+imageSignature.getSize()+". Created "+imageSignature.getCreatedOn()+", modified "+imageSignature.getModifiedOn());
                }
            }
            catch (Exception ex)
            {
                System.out.print("System Exception: " + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }
}