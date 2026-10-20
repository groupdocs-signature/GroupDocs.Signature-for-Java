package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.SignatureSettings;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.logging.ConsoleLogger;
import com.groupdocs.signature.logging.LogLevel;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithDigitalExpiredCertificate
{
    /**
     * <p>
     * Sign document with an expired certificate
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithDigitalExpiredCertificate : Sign document with an expired certificate\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();
        // This certificate expired in 2016. It has no password.
        String certificatePath = Constants.CertificateExpiredPfx;

        String outputFilePath = new File(Constants.OutputPath, "SignWithDigitalExpiredCertificate\\" + fileName).getPath();

        // Validators report a signature made with an expired or not-yet-valid certificate as not valid.
        // So, since version 26.9, sign throws GroupDocsSignatureException for such a certificate by default,
        // and nothing is signed or saved.
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);
            try
            {
                signature.sign(outputFilePath, options);
            }
            catch (GroupDocsSignatureException ex)
            {
                System.out.print("\nThe document was not signed: " + ex.getMessage());
            }
        }
        finally { if (signature != null) (signature).dispose(); }

        // To sign anyway, for example to test with an old certificate, set AllowExpired
        // (or AllowNotYetValid for a certificate whose validity period has not started yet).
        // The document is then signed, and a warning is written to the logger.
        SignatureSettings settings = new SignatureSettings(new ConsoleLogger());
        // log warnings and errors only
        settings.setLogLevel(LogLevel.Warning | LogLevel.Error);

        final Signature signature2 = new Signature(filePath, settings);
        try /*JAVA: was using*/
        {
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);
            options.setAllowExpired(true);
            // Page position
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);

            SignResult signResult = signature2.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with " + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath + ".");
        }
        finally { if (signature2 != null) (signature2).dispose(); }
    }
}
