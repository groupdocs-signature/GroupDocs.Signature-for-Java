package com.groupdocs.signature.examples.advanced_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.signatures.TextSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.search.TextSearchOptions;

import java.util.List;

public class SearchForTextAdvanced {
    /**
     * <p>
     * Search document for Text signature
     * </p>
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            PagesSetup page = new  PagesSetup();
            page.setFirstPage(true);
            page.setLastPage(true);
            page.setOddPages(false);
            page.setEvenPages(false);
            TextSearchOptions options = new TextSearchOptions();
            options.setAllPages(false);
            options.setPageNumber(1);
            options.setMatchType(TextMatchType.Exact);
            options.setText("John Smith");

            // search for text signatures in document
            List<TextSignature> signatures = signature.search(TextSignature.class,options);
            System.out.print("\nSource document contains following text signature(s).");
            // enumerate all signature for output
            //foreach to while statements conversion
            try
            {
                for (TextSignature sign : signatures)
                {

                    if (sign != null)
                    {
                        System.out.print("Found Text signature at page "+sign.getPageNumber()+" with type ["+sign.getSignatureImplementation()+"] and text '"+sign.getText()+"'.");
                        System.out.print("Location at "+sign.getLeft()+"-"+sign.getTop()+". Size is "+sign.getWidth()+"x"+sign.getHeight()+".");
                    }
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