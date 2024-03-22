package com.groupdocs.signature.examples.basic_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignatureFont;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class SignWithText {
    /**
     * Sign document with text signature
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SignWithText : Sign document with text signature.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithText//"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            TextSignOptions options = new TextSignOptions("John Smith");
            // set signature position
            options.setLeft(100);
            options.setTop(100);


            // set signature rectangle
            options.setWidth(100);
            options.setHeight(30);

            // set text color and Font
            options.setForeColor(Color.RED);
            SignatureFont signatureFont = new SignatureFont();
            signatureFont.setSize(12);
            signatureFont.setFamilyName("Comic Sans MS");
            options.setFont(signatureFont);

            // sign document to file
            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}