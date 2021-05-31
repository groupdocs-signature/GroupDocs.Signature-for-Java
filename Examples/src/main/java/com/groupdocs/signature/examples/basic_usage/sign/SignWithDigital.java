package com.groupdocs.signature.examples.basic_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.SpreadsheetPosition;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithDigital {
    /**
     * Sign document with digital signature
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();
        String imagePath = Constants.ImageHandwrite;
        String certificatePath = Constants.CertificatePfx;

        String outputFilePath = new File(Constants.OutputPath, "SignWithDigital//"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            DigitalSignOptions options = new DigitalSignOptions(certificatePath);

                // optional: setup image file path
            options.setImageFilePath(imagePath);
            options.setLeft(100);
            options.setTop(100);
            options.setPageNumber(1);
            options.setPassword("1234567890");
            options.getExtensions().add(new SpreadsheetPosition(10,10));
            // sign document to file
            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}