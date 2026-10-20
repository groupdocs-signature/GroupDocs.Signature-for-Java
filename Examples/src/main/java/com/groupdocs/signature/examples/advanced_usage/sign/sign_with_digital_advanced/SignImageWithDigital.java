package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.ImageSaveFileFormat;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.ImageSaveOptions;
import com.groupdocs.signature.options.sign.ImageDigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignImageWithDigital
{
    /**
     * <p>
     * Sign image with digital signature
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignImageWithDigital : Sign image with digital signature\n");

        // The path to the documents directory.
        String inputFile = Constants.SAMPLE_IMAGE;
        String fileName = Paths.get(inputFile).getFileName().toString();
        String outputFile = new File(Constants.OutputPath, "SignImageWithDigital\\signed_" + fileName).getPath();
        String password = "MySecurePassword123";

        Constants.checkDir(outputFile);

        final Signature signature = new Signature(inputFile);
        try /*JAVA: was using*/
        {
            ImageDigitalSignOptions signOptions = new ImageDigitalSignOptions();
            signOptions.setPassword(password);

            ImageSaveOptions saveOptions = new ImageSaveOptions();
            saveOptions.setFileFormat(ImageSaveFileFormat.Png);

            // Sign with SaveOptions
            SignResult signResult = signature.sign(outputFile, signOptions, saveOptions);

            // Check results
            if (signResult.getSucceeded() != null && signResult.getSucceeded().size() > 0)
            {
                System.out.print("\nImage signed successfully!");
                System.out.print("\nSignatures added: " + signResult.getSucceeded().size());
                System.out.print("\nFile saved at " + outputFile + ".");
            }
            else
            {
                System.out.print("\nSigning failed.");
                if (signResult.getFailed() != null && signResult.getFailed().size() > 0)
                {
                    System.out.print("\nFailed: " + signResult.getFailed().size());
                }
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
