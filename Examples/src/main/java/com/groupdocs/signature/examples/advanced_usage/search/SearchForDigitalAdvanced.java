package com.groupdocs.signature.examples.advanced_usage.search;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.DigitalSearchOptions;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.List;

public class SearchForDigitalAdvanced {
    /**
     * Search document for digital signature with applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        try {
            Signature signature = new Signature(filePath);
            DigitalSearchOptions options = new DigitalSearchOptions();
            // specify special search criteria
            options.setComments("Test comment");
            // certificate issues criteria
            options.setIssuerName("John");
            // digital certificate subject
            options.setSubjectName("Test");
            // specify date range period of signature
            options.setSignDateTimeFrom(DateUtils.addMonths(new Date(), -1));
            options.setSignDateTimeTo(new Date());

            // search for signatures in document
            List<DigitalSignature> signatures = signature.search(DigitalSignature.class, options);
            System.out.print("\nSource document contains following signatures.");
            for (DigitalSignature digitalSignature : signatures)
            {
                System.out.print("Digital signature found from "+digitalSignature.getSignTime()+" with validation flag "+digitalSignature.isValid()+". Certificate SN "+ digitalSignature.getCertificate().getType());
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}