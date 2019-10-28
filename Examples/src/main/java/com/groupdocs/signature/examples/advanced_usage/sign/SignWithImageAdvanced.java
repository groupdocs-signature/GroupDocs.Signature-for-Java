package com.groupdocs.signature.examples.advanced_usage.sign;


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
import java.nio.file.Paths;

public class SignWithImageAdvanced {
    /** 
     * Sign document with image signature applying specific options
     */ 
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;
        String fileName = Paths.get(filePath).getFileName().toString();
        String imagePath = Constants.ImageHandwrite;

        String outputFilePath = new File(Constants.OutputPath, "AdvancedSignWithImage-" + fileName).getPath();
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
            // when VerticalAlignment is set the Top coordinate will be ignored.
            // Use Margin properties Top, Bottom to provide vertical offset
            options.setVerticalAlignment(VerticalAlignment.Top);

            // when HorizontalAlignment is set the Left coordinate will be ignored.
            // Use Margin properties Left, Right to provide horizontal offset
            options.setHorizontalAlignment(HorizontalAlignment.Right);

            Padding padding = new Padding();
            padding.setRight(20);
            padding.setTop(20);
            options.setMargin(padding);

            // set rotation
            options.setRotationAngle(45);

            // setup image additional appearance as Brightness and Border
            ImageAppearance imageAppearance = new ImageAppearance();
            Border border = new Border();
            border.setColor(Color.GREEN);
            border.setDashStyle(DashStyle.DashLongDashDot);
            border.setWeight(2);
            border.setTransparency(0.5);
            border.setVisible(true);
            imageAppearance.setBorder(border);
            imageAppearance.setBrightness(0.9f);
            options.setAppearance(imageAppearance);

            // sign document to file
            signature.sign(outputFilePath, options);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}
