package com.groupdocs.signature.examples.advanced_usage.search;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.signatures.metadata.MetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.search.CertificateSearchOptions;

import java.util.List;

public class SearchCertificateAdvanced
{
    /**
     * <p>
     * Verify digital certificates file
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchCertificateAdvanced : Search Digital Certificate for specifix text\n");

        // The path to certificate.
        String certificatePath = Constants.CertificatePfx;

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1234567890");

        final Signature signature = new Signature(certificatePath, loadOptions);
        try /*JAVA: was using*/
        {
            CertificateSearchOptions options = new CertificateSearchOptions();
            options.setText("AAD0D15C628A");
            options.setMatchType(TextMatchType.Contains);

            // search for certificate data
            List<MetadataSignature> result = signature.search(MetadataSignature.class, options);
            if (result.size()>0)
            {
                System.out.print("\nCertificate contains following search results");

                for (MetadataSignature temp : result)
                {
                  System.out.print("\t\t-"+temp.getName()+" - "+temp.getValue());
                }
            }
            else
            {
                System.out.print("\nCertificate failed search process.");
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
