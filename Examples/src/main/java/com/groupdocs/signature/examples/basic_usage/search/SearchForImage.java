package com.groupdocs.signature.examples.basic_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.ImageSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.ImageSearchOptions;

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
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET_SIGNED;
        String fileName = Paths.get(filePath).getFileName().toString();
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // setup search options
            ImageSearchOptions searchOptions = new ImageSearchOptions();
            searchOptions.setAllPages(true);

            // search document
            List<ImageSignature> signatures = signature.search(ImageSignature.class,searchOptions);
            System.out.print("\nSource document ['"+fileName+"'] contains following image signature(s).");
            // output signatures
            try
            {
                for (ImageSignature imageSignature : signatures)
                {
                    System.out.print("Found Image signature at page "+imageSignature.getPageNumber()+" and size "+imageSignature.getSize()+"}.");

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