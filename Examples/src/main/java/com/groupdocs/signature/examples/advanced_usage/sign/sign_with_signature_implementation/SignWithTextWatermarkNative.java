package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_signature_implementation;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.SignatureFont;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.TextSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class SignWithTextWatermarkNative
{
    /// <summary>
    /// Sign WordProcessing document with text watermark signature using document specific implementation.
    /// </summary>
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithTextWatermarkNative : Sign WordProcessing document with text watermark signature using document specific implementation\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithTextWatermarkNative\\"+ fileName).getPath();

        Signature signature = new Signature(filePath);
        {
            TextSignOptions options = new TextSignOptions("John Smith Watermark");
            {
                // set attribute of using document specific implementation
                options.setNative(true);
                //Watermark will be the same for each page
                options.setSignatureImplementation(TextSignatureImplementation.Watermark);

                // set text color and Font
                options.setForeColor(Color.red);

                SignatureFont signatureFont =  new SignatureFont ();
                signatureFont.setSize(72);
                signatureFont.setFamilyName("Comic Sans MS");
                options.setFont (signatureFont);
                        // set rotation
                // If rotation angle is not 0 it will be converted to 315.
                options.setRotationAngle(45);

                // set transparency
                // If transparency is not 0 it will be converted to 50%.
                options.setTransparency(0.9);
            };

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath);

            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature o : signResult.getSucceeded())
            {
                TextSignature temp = (TextSignature) o;
                System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", isNative: "+temp.getNative());
            }
        }
    }
}