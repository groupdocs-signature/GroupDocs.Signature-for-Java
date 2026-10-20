package com.groupdocs.signature.examples.advanced_usage.verify;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.ImageSaveFileFormat;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.ImageSaveOptions;
import com.groupdocs.signature.options.sign.ImageDigitalSignOptions;
import com.groupdocs.signature.options.verify.ImageDigitalVerifyOptions;

import java.io.File;
import java.nio.file.Paths;

public class VerifyImageWithDigital
{
    /**
     * <p>
     * Verify digital signature on image
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # VerifyImageWithDigital : Verify digital signature on image\n");

        // First, sign an image to have a signed file for verification
        String inputFile = Constants.SAMPLE_IMAGE;
        String fileName = Paths.get(inputFile).getFileName().toString();
        String signedFile = new File(Constants.OutputPath, "SignImageWithDigital\\signed_" + fileName).getPath();
        String password = "MySecurePassword123";

        // Ensure the signed file exists by signing it first if it doesn't exist
        if (!new File(signedFile).exists())
        {
            Constants.checkDir(signedFile);
            final Signature signature = new Signature(inputFile);
            try /*JAVA: was using*/
            {
                ImageDigitalSignOptions signOptions = new ImageDigitalSignOptions();
                signOptions.setPassword(password);
                ImageSaveOptions saveOptions = new ImageSaveOptions();
                saveOptions.setFileFormat(ImageSaveFileFormat.Png);
                signature.sign(signedFile, signOptions, saveOptions);
            }
            finally { if (signature != null) (signature).dispose(); }
        }

        try
        {
            // Load the signed image
            final Signature signature = new Signature(signedFile);
            try /*JAVA: was using*/
            {
                // Create verify options with the same password used for signing
                ImageDigitalVerifyOptions verifyOptions = new ImageDigitalVerifyOptions();
                verifyOptions.setPassword(password);
                // Optional: set detection threshold (0-100%)
                verifyOptions.setDetectionThresholdPercent(75);

                // Verify the signature
                VerificationResult verifyResult = signature.verify(verifyOptions);

                // Check results
                if (verifyResult.isValid())
                {
                    System.out.print("\nDigital signature is valid!");
                    System.out.print("\nVerified signatures: " + verifyResult.getSucceeded().size());
                    for (BaseSignature sig : verifyResult.getSucceeded())
                    {
                        if (sig instanceof DigitalSignature)
                        {
                            DigitalSignature digitalSig = (DigitalSignature) sig;
                            System.out.print("\n  Signature ID: " + digitalSig.getSignatureId());
                            System.out.print("\n  Sign Time: " + digitalSig.getSignTime());
                            System.out.print("\n  Is Valid: " + digitalSig.isValid());
                        }
                    }
                }
                else
                {
                    System.out.print("\nDigital signature is invalid or not found.");
                    if (verifyResult.getFailed() != null && verifyResult.getFailed().size() > 0)
                    {
                        System.out.print("\n  Failed verifications: " + verifyResult.getFailed().size());
                        for (BaseSignature failure : verifyResult.getFailed())
                        {
                            System.out.print("\n    - " + failure);
                        }
                    }
                }
            }
            finally { if (signature != null) (signature).dispose(); }
        }
        catch (IllegalArgumentException ex)
        {
            System.out.print("\nPassword validation error: " + ex.getMessage());
        }
        catch (Exception ex)
        {
            System.out.print("\nAn error occurred: " + ex.getMessage());
        }
    }
}
