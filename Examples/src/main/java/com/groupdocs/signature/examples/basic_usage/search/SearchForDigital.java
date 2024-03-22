package com.groupdocs.signature.examples.basic_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.DigitalSearchOptions;

import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;

public class SearchForDigital {
    /**
     * Search document for digital signature
     */
    public static void run()
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SearchForDigital : Search document for digital signature.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        try {
            Signature signature = new Signature("filePath");
            DigitalSearchOptions options = new DigitalSearchOptions();

            // search for signatures in document
            List<DigitalSignature> signatures = signature.search(DigitalSignature.class, options);
            System.out.print("\nSource document contains following signatures.");
            for (DigitalSignature digitalSignature : signatures)
            {
                KeyStore certificate = digitalSignature.getCertificate();
                String serialNumber = "";
                if (certificate != null) {
                    Certificate x509 = certificate.getCertificate(digitalSignature.getCertificateName());
                    serialNumber = ((X509Certificate)x509).getSerialNumber().toString();
                }

                System.out.print("Digital signature found from "+digitalSignature.getSignTime()+" with validation flag "+digitalSignature.isValid() + ". Certificate SN "+serialNumber);
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}