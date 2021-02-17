package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.*;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.LinearGradientBrush;
import com.groupdocs.signature.domain.extensions.TextShadow;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class SignWithTextAdvanced {
    /**
     * Sign document with text signature applying specific options
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithTextAdvanced-"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            TextSignOptions options = new TextSignOptions("John Smith");

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
            padding.setBottom(20);
            padding.setRight(20);
            options.setMargin(padding);

            // adjust signature appearance

            // setup signature border
            Border border = new Border();
            border.setColor(Color.GREEN);
            border.setDashStyle(DashStyle.DashLongDashDot);
            border.setTransparency(0.5);
            border.setVisible(true);
            border.setWeight(2);
            options.setBorder(border);

            // set text color and Font
            options.setForeColor(Color.RED);
            SignatureFont signatureFont = new SignatureFont();
            signatureFont.setSize(12);
            signatureFont.setFamilyName("Comic Sans MS");
            options.setFont(signatureFont);

            // setup background
            Background background = new Background();
            background.setColor(Color.LIGHT_GRAY);
            background.setTransparency(0.5);
            background.setBrush(new LinearGradientBrush(Color.GREEN, Color.DARK_GRAY, 0));
            options.setBackground(background);

            // set rotation
            options.setRotationAngle(45);

            // set alternative signature implementation on document page
            options.setSignatureImplementation(TextSignatureImplementation.Image);



            // set up shadow options for text
            TextShadow shadow = new TextShadow();
            shadow.setColor(Color.ORANGE);
            shadow.setAngle(135);
            shadow.setBlur(5);
            shadow.setDistance(4);
            shadow.setTransparency(0.2);

            //add text shadow to signature extensions
            options.getExtensions().add(shadow);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, options);
            // analyzing result
            System.out.print("List of newly created signatures:");
            int number = 1;
            for(BaseSignature temp : signResult.getSucceeded())
            {
                System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
                        ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}