package com.groupdocs.signature.examples.advanced_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.TextSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.search.TextSearchOptions;

import java.util.Iterator;
import java.util.List;

public class SearchAndSkipExternalSignatures {
    /**
     * <p>
     * Search document for Text signature
     * </p>
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET;

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1234567890");
        final Signature signature = new Signature(filePath, loadOptions);
        try /*JAVA: was using*/
        {
            TextSearchOptions options = new TextSearchOptions();
            options.setSkipExternal(true);
            options.setAllPages(false);
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
            catch (Exception ex) {
                System.out.print("System Exception: " + ex.getMessage());
            }
        }
        catch (Exception ex) {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }
}