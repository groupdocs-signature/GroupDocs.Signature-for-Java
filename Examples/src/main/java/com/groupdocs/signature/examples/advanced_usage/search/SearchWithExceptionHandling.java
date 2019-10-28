package com.groupdocs.signature.examples.advanced_usage.search;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.search.DigitalSearchOptions;

import java.util.List;

public class SearchWithExceptionHandling {
    /**
     * Search document with digital signature applying specific options
     */
    public static void run() {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_PWD_PDF;
        try {
            LoadOptions loadOptions = new LoadOptions();
            Signature signature = new Signature(filePath);
            // create QRCode option with predefined QRCode text
            DigitalSearchOptions options = new DigitalSearchOptions();

            // search signature document
            List<DigitalSignature> signatures = signature.search(DigitalSignature.class,options);
        } catch (GroupDocsSignatureException ex) {
            System.out.print("GroupDocs Signature Exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }
}
