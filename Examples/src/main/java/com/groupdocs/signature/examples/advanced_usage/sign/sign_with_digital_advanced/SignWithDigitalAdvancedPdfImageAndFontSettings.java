package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.appearances.PdfDigitalSignatureAppearance;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.awt.Color;
import java.io.File;
import java.nio.file.Paths;

public class SignWithDigitalAdvancedPdfImageAndFontSettings
{
    /**
     * <p>
     * Sign PDF document with digital signature applying special signature appearance settings, image and font settings.
     * The document is signed twice, the second signature is added to the already signed document.
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithDigitalAdvancedPdfImageAndFontSettings : Sign PDF document with digital signature applying special signature appearance settings, image and font settings\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();
        String imageFilePath = Constants.ImageHandwrite;
        String sourceFile = Constants.SAMPLE_PDF;
        String outputFile = new File(Constants.OutputPath, "SignWithDigitalAdvancedPdfImageAndFontSettings\\" + fileName).getPath();
        String outputFile1 = new File(Constants.OutputPath, "SignWithDigitalAdvancedPdfImageAndFontSettings\\1" + fileName).getPath();

        String[] certificatePaths = { Constants.CertificatePfx, Constants.CertificatePfx };
        int iteration = 0;
        for (String certificatePath : certificatePaths)
        {
            final Signature signature = new Signature(sourceFile);
            try /*JAVA: was using*/
            {
                DigitalSignOptions options = new DigitalSignOptions(certificatePath);
                // certificate password
                options.setPassword("1234567890");
                // digital certificate details
                options.setReason("Sign");
                options.setContact("JohnSmith" + iteration);
                options.setLocation("Office1" + iteration);
                options.setVisible(true);
                options.setLeft(400);
                options.setTop(20 + iteration * 70);
                options.setHeight(70);
                options.setWidth(200);
                // image as digital certificate appearance on document pages
                options.setImageFilePath(imageFilePath);

                PdfDigitalSignatureAppearance appearance = new PdfDigitalSignatureAppearance();
                // apply custom font color
                appearance.setForeground(new Color(128, 128, 128, 50));
                // apply custom font settings
                appearance.setFontFamilyName("TimesNewRoman");
                appearance.setFontSize(12);
                options.setAppearance(appearance);

                if (iteration == 1)
                {
                    outputFile = outputFile1;
                }
                SignResult signResult = signature.sign(outputFile, options);
                System.out.print("\nSource document signed successfully " + (iteration++) + "-time with "
                        + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputFile + ".");
            }
            finally { if (signature != null) (signature).dispose(); }
            sourceFile = outputFile;
        }
    }
}
