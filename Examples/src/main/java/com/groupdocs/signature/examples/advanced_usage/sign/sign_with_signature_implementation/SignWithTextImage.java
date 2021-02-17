package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_signature_implementation;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Background;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.RadialGradientBrush;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class SignWithTextImage {
    /**
     * Sign document with text signature applying Image implementation type
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithTextImage : Sign document with text signature applying Image implementation type\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithTextImage\\" + fileName).getPath();

        Signature signature = new Signature(filePath);
        {
            TextSignOptions options = new TextSignOptions("John Smith");
            {
                // set alternative signature implementation on document page
                options.setSignatureImplementation(TextSignatureImplementation.Image);
                // set alignment
                options.setVerticalAlignment(VerticalAlignment.Top);
                options.setHorizontalAlignment(HorizontalAlignment.Right);
                // set margin with 20 pixels for all sides
                options.setMargin(new Padding(20));
                // add special background as an image text implementation advantage
                Background background= new Background();
                background.setColor(Color.GREEN);
                background.setTransparency(0.5);
                background.setBrush(new RadialGradientBrush(Color.GREEN, Color.DARK_GRAY));

                options.setBackground(background);

            };
            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with " + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath + ".");
        }
    }
}