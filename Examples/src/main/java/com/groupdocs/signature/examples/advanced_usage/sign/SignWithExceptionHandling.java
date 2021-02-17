package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithExceptionHandling {

    /**
     * Sign document with text signature applying specific options
     */
    public static void run() throws Exception
    {

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "SignWithExceptionsHandling//"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);
            {
                DigitalSignOptions options = new DigitalSignOptions();
                options.setCertificateFilePath(Constants.CertificatePfx);
                options.setImageFilePath(Constants.ImageHandwrite);
                // skip password specification
                //Password = "123456780"


                // sign document to file
                signature.sign(outputFilePath, options);
            }
        }
        catch (GroupDocsSignatureException ex)
        {
            System.out.print("GroupDocs Signature Exception: " + ex.getMessage());
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }
}
