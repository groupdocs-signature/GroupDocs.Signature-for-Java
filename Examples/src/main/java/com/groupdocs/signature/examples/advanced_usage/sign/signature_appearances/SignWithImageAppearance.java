package com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.appearances.ImageAppearance;
import com.groupdocs.signature.options.sign.ImageSignOptions;

import java.awt.*;
import java.io.File;

public class SignWithImageAppearance {

    /**
     * Sign document with image signature applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;
        String imagePath = Constants.ImageHandwrite;

        String outputFilePath = new File(Constants.OutputPath, "SignWithAppearances\\DocxImageAppearance.docx").getPath();

        try {
            Signature signature = new Signature(filePath);
            ImageSignOptions options = new ImageSignOptions(imagePath);

                // set signature position
            options.setLeft(100);
            options.setTop(100);

                // set signature rectangle
            options.setWidth(100);
            options.setHeight(30);

                // set signature alignment
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);
            Padding padding = new Padding();
            padding.setBottom(20);
            padding.setRight(20);
            options.setMargin(padding);

                // setup image additional appearance as Brightness and Border
            ImageAppearance imageAppearance = new ImageAppearance();

            imageAppearance.setGrayscale(true);
            imageAppearance.setContrast(0.2f);
            imageAppearance.setGammaCorrection(0.3f);
            imageAppearance.setBrightness(0.9f);

            Border border = new Border();
            border.setColor(Color.GREEN);
            border.setDashStyle(DashStyle.DashLongDashDot);
            border.setTransparency(0.5);
            border.setVisible(true);
            border.setWeight(2);

            imageAppearance.setBorder(border);
            options.setAppearance(imageAppearance);

            // sign document to file
            signature.sign(outputFilePath, options);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}