package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HashAlgorithm;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithDigitalAdvancedPdfHashAlgorithm
{
    /**
     * <p>
     * Sign PDF document with digital signature using SHA-512
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithDigitalAdvancedPdfHashAlgorithm : Sign PDF document with digital signature using SHA-512\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();
        String certificatePath = Constants.CertificatePfx;

        String outputFilePath = new File(Constants.OutputPath, "SignWithDigitalAdvancedPdfHashAlgorithm\\" + fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);
            // certificate password
            options.setPassword("1234567890");
            // PDF digital signatures use SHA-256 by default since version 26.9.
            // Sha384 and Sha512 are also available. Sha1 is kept only for legacy validators.
            options.setHashAlgorithm(HashAlgorithm.Sha512);
            // digital certificate details
            options.setReason("Approved");
            options.setLocation("New York");
            // Page position
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);

            SignResult signResult = signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with " + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath + ".");
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
