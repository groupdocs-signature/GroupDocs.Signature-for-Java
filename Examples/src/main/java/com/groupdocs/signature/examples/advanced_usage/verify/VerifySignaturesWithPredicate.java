package com.groupdocs.signature.examples.advanced_usage.verify;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.verify.DigitalVerifyOptions;
import com.groupdocs.signature.options.verify.ImageDigitalVerifyOptions;
import com.groupdocs.signature.options.verify.TextVerifyOptions;
import com.groupdocs.signature.options.verify.VerifyOptions;

import java.util.ArrayList;
import java.util.List;

public class VerifySignaturesWithPredicate
{
    /**
     * <p>
     * Verify signatures with predicate function
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # VerifySignaturesWithPredicate : Verify signatures with predicate function\n");

        // The path to the documents directory.
        String signedFile = Constants.SAMPLE_PDF_SIGNED_DIGITAL;

        try
        {
            final Signature signature = new Signature(signedFile);
            try /*JAVA: was using*/
            {
                // Option 1: Verify all digital signatures and filter with predicate
                // Create verify options for digital signatures
                DigitalVerifyOptions verifyOptions = new DigitalVerifyOptions();

                // Verify and filter: only signatures on page 1
                List<BaseSignature> verifiedSignatures = signature.verify(
                        verifyOptions,
                        sig -> sig.getPageNumber() == 1
                );
                System.out.print("\nVerified " + verifiedSignatures.size() + " digital signatures on page 1");

                // Option 2: Verify image digital signatures with predicate
                // For images with digital steganography signatures
                ImageDigitalVerifyOptions imageVerifyOptions = new ImageDigitalVerifyOptions();
                imageVerifyOptions.setPassword("MySecurePassword123");
                imageVerifyOptions.setDetectionThresholdPercent(75);

                // Verify and filter: only valid signatures
                List<BaseSignature> validImageSignatures = signature.verify(
                        imageVerifyOptions,
                        sig -> sig instanceof DigitalSignature && ((DigitalSignature) sig).isValid()
                );
                System.out.print("\nVerified " + validImageSignatures.size() + " valid image digital signatures");

                // Option 3: Verify multiple signature types with complex predicate
                TextVerifyOptions textVerifyOptions = new TextVerifyOptions();
                textVerifyOptions.setText("Approved");
                List<VerifyOptions> verifyOptionsList = new ArrayList<VerifyOptions>();
                verifyOptionsList.add(new DigitalVerifyOptions());
                verifyOptionsList.add(textVerifyOptions);

                // Verify and filter: signatures on first 3 pages that are valid
                List<BaseSignature> filteredVerifiedSignatures = signature.verify(
                        verifyOptionsList,
                        sig -> sig.getPageNumber() >= 1 &&
                               sig.getPageNumber() <= 3 &&
                               (!(sig instanceof DigitalSignature) || ((DigitalSignature) sig).isValid())
                );
                System.out.print("\nVerified " + filteredVerifiedSignatures.size() + " signatures on pages 1-3");

                // Process verified results
                for (BaseSignature sig : filteredVerifiedSignatures)
                {
                    System.out.print("\n  Verified signature on page " + sig.getPageNumber());
                    System.out.print("\n    Type: " + sig.getSignatureType());
                    if (sig instanceof DigitalSignature)
                    {
                        DigitalSignature digitalSig = (DigitalSignature) sig;
                        System.out.print("\n    Is Valid: " + digitalSig.isValid());
                        System.out.print("\n    Sign Time: " + digitalSig.getSignTime());
                    }
                }
            }
            finally { if (signature != null) (signature).dispose(); }
        }
        catch (IllegalArgumentException ex)
        {
            System.out.print("\nValidation error: " + ex.getMessage());
        }
        catch (Exception ex)
        {
            System.out.print("\nAn error occurred: " + ex.getMessage());
        }
    }
}
