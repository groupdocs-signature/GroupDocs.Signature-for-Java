package com.groupdocs.signature.examples.advanced_usage.sign.singin_with_brushes;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Background;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.RadialGradientBrush;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.awt.*;
import java.io.File;

public class SignWithRadialGradientBrush {
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;


        String outputFilePath = new File(Constants.OutputPath, "SignWithBrushes\\SignedLinearRadialBrush.pdf").getPath();

        try {
            Signature signature = new Signature(filePath);
            TextSignOptions options = new TextSignOptions("John Smith");

            // adjust signature appearance brush

            // setup background
            Background background = new Background();
            background.setColor(Color.GREEN);
            background.setTransparency(0.5);
            background.setBrush(new RadialGradientBrush(Color.GREEN, Color.WHITE));
            options.setBackground(background);

            // locate signature
            options.setWidth(100);
            options.setHeight(80);
            options.setVerticalAlignment(VerticalAlignment.Center);
            options.setHorizontalAlignment(HorizontalAlignment.Center);
            Padding padding = new Padding();
            padding.setTop(20);
            padding.setRight(20);
            options.setMargin(padding);

            // set alternative signature implementation on document page
            options.setSignatureImplementation(TextSignatureImplementation.Image);

            // sign document to file
            signature.sign(outputFilePath, options);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}