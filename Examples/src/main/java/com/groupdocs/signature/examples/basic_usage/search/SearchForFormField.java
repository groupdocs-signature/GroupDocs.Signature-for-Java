package com.groupdocs.signature.examples.basic_usage.search;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.formfield.FormFieldSignature;
import com.groupdocs.signature.domain.signatures.metadata.MetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.FormFieldSearchOptions;
import com.groupdocs.signature.options.search.MetadataSearchOptions;

import java.util.List;

public class SearchForFormField {
    /**
     * Search document for form-field signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED_FORMFIELD;

        try {
            Signature signature = new Signature(filePath);
            FormFieldSearchOptions options = new FormFieldSearchOptions();

            // search for signatures in document
            List<FormFieldSignature> signatures = signature.search(FormFieldSignature.class, options);
            System.out.print("\nSource document contains following signatures.");
            for (FormFieldSignature formFieldSignature : signatures)
            {
                System.out.print("FormField signature found. Name : "+formFieldSignature.getName()+". Value: " +formFieldSignature.getValue());
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}