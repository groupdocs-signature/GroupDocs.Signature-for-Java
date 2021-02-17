package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_signature_implementation;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithTextWatermark {
    /**
     * Sign document with text signature applying Watermark implementation type
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithTextWatermark : Sign document with text signature applying Watermark implementation type\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithTextWatermark\\" + fileName).getPath();

        Signature signature = new Signature(filePath);
        {
            TextSignOptions options = new TextSignOptions("John Smith");
            {
                // set alternative signature implementation on document page
                options.setSignatureImplementation(TextSignatureImplementation.Watermark);
                // set margin with 20 pixels for all sides
                options.setMargin(new Padding(20));
            };
            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with " + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath + ".");
        }
    }
}