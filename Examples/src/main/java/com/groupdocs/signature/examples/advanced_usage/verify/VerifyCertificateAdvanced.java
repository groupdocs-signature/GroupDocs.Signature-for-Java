package com.groupdocs.signature.examples.advanced_usage.verify;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.verify.CertificateVerifyOptions;


class VerifyCertificateAdvanced
{
    /**
     * <p>
     * Verify digital certificates file
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # VerifyCertificateAdvanced : Verify Digital Certificate\n");

        // The path to certificate.
        String certificatePath = Constants.CertificatePfx;

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1234567890");

        final Signature signature = new Signature(certificatePath, loadOptions);
        try /*JAVA: was using*/
        {
            CertificateVerifyOptions options = new CertificateVerifyOptions();
            options.setPerformChainValidation(false);
            options.setMatchType(TextMatchType.Exact);
            options.setSerialNumber("00AAD0D15C628A13C7");

            // verify certificate
            VerificationResult result = signature.verify(options);
            if (result.isValid())
            {
                System.out.print("\nCertificate was verified successfully!");
            }
            else
            {
                System.out.print("\nCertificate failed verification process.");
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
