package com.groupdocs.signature.examples.basic_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.ImageSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithImage {
    /**
     * Sign pdf document with form-field signature
     */
    public static void run() throws Exception {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;
        String fileName = Paths.get(filePath).getFileName().toString();
        String imagePath = Constants.ImageHandwrite;

        String outputFilePath = new File(Constants.OutputPath, "SignWithImage//" + fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            ImageSignOptions options = new ImageSignOptions(imagePath) ;
            // set signature position
            options.setLeft(100);
            options.setTop(100);
            options.setPageNumber(1);
            options.setAllPages(true);

            // sign document to file
            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}