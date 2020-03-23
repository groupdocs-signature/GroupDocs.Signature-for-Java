package com.groupdocs.signature.examples.advanced_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.ImageSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.search.ImageSearchOptions;

import java.nio.file.Paths;
import java.util.List;

public class SearchForImageAdvanced {
    /**
     * <p>
     * Search document for Image signature
     * </p>
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET;
        String fileName = Paths.get(filePath).getFileName().toString();
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            PagesSetup pS = new  PagesSetup();
            pS.setFirstPage(true);
            pS.setLastPage(true);
            pS.setOddPages(false);
            pS.setEvenPages(false);
            // setup search options
            ImageSearchOptions searchOptions = new ImageSearchOptions();
            searchOptions.setAllPages(false);
            searchOptions.setPageNumber(1);
            searchOptions.setPagesSetup(pS);

            // search document
            List<ImageSignature> signatures = signature.search(ImageSignature.class,searchOptions);
            System.out.print("\nSource document ['" + fileName + "'] contains following image signature(s).");
            // output signatures
            //foreach to while statements conversion
            try
            {
                for (ImageSignature sign : signatures)
                {

                    System.out.print("Found Image signature at page "+sign.getPageNumber()+" and size "+sign.getSize()+".");
                    System.out.print("Location at "+sign.getLeft()+"-"+sign.getTop()+". Size is "+sign.getWidth()+"x"+sign.getHeight()+".");
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