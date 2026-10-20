package com.groupdocs.signature.examples.advanced_usage.verify;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.verify.DigitalVerifyOptions;

public class VerifyPdfWithDigital
{
    /**
     * <p>
     * Verify PDF document digital signature by certificate subject, issuer and reason
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # VerifyPdfWithDigital : Verify PDF document digital signature by certificate subject, issuer and reason\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED_DIGITAL;

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // Verify checks every PDF digital signature cryptographically first (since version 26.9):
            // a document changed after signing is not valid, whatever criteria are set.
            // Then the criteria are matched. SubjectName and IssuerName match when the subject or issuer
            // of the signing certificate contains the value (case-sensitive).
            DigitalVerifyOptions options = new DigitalVerifyOptions();
            options.setSubjectName("ProfJamesMoriarty");
            options.setIssuerName("ProfMoriarty");
            options.setReason("Approved");

            VerificationResult result = signature.verify(options);
            if (result.isValid())
            {
                System.out.print("\nDocument was verified successfully: the signature is intact and matches the certificate and the reason.");
            }
            else
            {
                System.out.print("\nDocument failed verification process.");
            }

            // The same document does not pass when another signer is expected
            DigitalVerifyOptions otherSigner = new DigitalVerifyOptions();
            otherSigner.setSubjectName("John Smith");
            result = signature.verify(otherSigner);
            System.out.print(result.isValid()
                    ? "\nDocument is signed by John Smith."
                    : "\nDocument is not signed by John Smith.");
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
