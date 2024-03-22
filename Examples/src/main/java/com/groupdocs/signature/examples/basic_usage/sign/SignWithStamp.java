package com.groupdocs.signature.examples.basic_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignatureFont;
import com.groupdocs.signature.domain.stamps.StampLine;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.StampSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class SignWithStamp {
    /**
     * Sign document with stamp signature
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SignWithStamp : Sign document with stamp signature.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithStamp//"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            StampSignOptions options = new StampSignOptions();
            // set stamp signature position
            options.setLeft(100);
            options.setTop(100);

            // setup first external line of Stamp
            StampLine outerLine = new StampLine();
            outerLine.setText(" * European Union * European Union  * European Union  * European Union  * European Union  * ");
            outerLine.getFont().setSize(12);
            outerLine.setHeight(22);
            outerLine.setTextBottomIntent(6);
            outerLine.setTextColor(Color.WHITE);
            outerLine.setBackgroundColor(Color.BLUE);
            options.getOuterLines().add(outerLine);

            //Inner square lines - horizontal lines inside the rings
            StampLine innerLine = new StampLine();
            innerLine.setText("John");
            innerLine.setTextColor(Color.RED);
            SignatureFont signFont = new SignatureFont();
            signFont.setSize(20);
            signFont.setBold(true);
            innerLine.setFont(signFont);
            innerLine.setHeight(40);
            options.getInnerLines().add(innerLine);
            // sign document to file
            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}