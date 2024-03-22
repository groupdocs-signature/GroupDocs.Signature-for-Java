package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_images_advanced;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
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
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithImageAdvanced : Sign document with image signature applying specific options.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();
        String imagePath = Constants.ImageHandwrite;

        String outputFilePath = new File(Constants.OutputPath, "AdvancedSignWithImage\\" + fileName).getPath();
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
            padding.setRight(120);
            padding.setTop(120);
            options.setMargin(padding);

            // set rotation
            options.setRotationAngle(45);

            //setup signature border
            Border border = new Border();
            border.setColor(Color.GREEN);
            border.setDashStyle(DashStyle.DashLongDashDot);
            border.setWeight(5);
            border.setVisible(true);

            options.setBorder(border);


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
