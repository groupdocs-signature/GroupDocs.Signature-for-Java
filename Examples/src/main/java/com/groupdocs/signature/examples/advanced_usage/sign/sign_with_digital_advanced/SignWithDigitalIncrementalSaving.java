package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithDigitalIncrementalSaving
{
    /**
     * <p>
     * Sign document incrementally with digital certificates only: each signature is added to the result of the previous signing
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithDigitalIncrementalSaving : Sign document incrementally with digital certificates only\n");

        String[] certificates = new String[] { Constants.CertificatePfx, Constants.CertificatePfx };
        String[] passwords = new String[]
        {
            "1234567890",
            "1234567890"
        };

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();
        int iteration = 0;
        String outputFilePath = new File(Constants.OutputPath, "SignWithDigitalIncrementalSaving\\" + fileName).getPath();

        for (String certificate : certificates)
        {
            final Signature signature = new Signature(filePath);
            try /*JAVA: was using*/
            {
                DigitalSignOptions options = new DigitalSignOptions(certificate);
                // certificate password
                options.setPassword(passwords[iteration]);
                // digital certificate details
                options.setReason("Approved-" + iteration);
                options.setContact("John" + iteration + " Smith" + iteration);
                options.setLocation("Location-" + iteration);
                // no image
                options.setAllPages(true);
                options.setLeft(10 + 100 * (iteration - 1));
                options.setTop(10 + 100 * (iteration - 1));
                options.setWidth(160);
                options.setHeight(80);
                Padding margin = new Padding();
                margin.setBottom(10);
                margin.setRight(10);
                options.setMargin(margin);

                String outputPath = new File(outputFilePath, "result-" + iteration + ".pdf").getPath();
                SignResult signResult = signature.sign(outputPath, options);
                filePath = outputPath;
                System.out.print("\nSource document signed successfully " + (iteration++) + "-time with " + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputPath + ".");
            }
            finally { if (signature != null) (signature).dispose(); }
        }
    }
}
