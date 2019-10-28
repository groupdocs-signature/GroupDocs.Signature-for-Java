package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Background;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignatureFont;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.stamps.StampBackgroundCropType;
import com.groupdocs.signature.domain.stamps.StampLine;
import com.groupdocs.signature.domain.stamps.StampTextRepeatType;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.StampSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class SignWithStampAdvanced {
    /**
    * Sign document with Bar-Code signature applying specific options
    */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithBarcodeAdvanced\\" + fileName).getPath();

        try {
            Signature signature = new Signature(filePath);
            // setup options with text of signature
            StampSignOptions signOptions = new StampSignOptions();

            signOptions.setHeight(300);
            signOptions.setWidth(300);

            signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
            signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
            Padding padding = new Padding();
            padding.setRight(10);
            padding.setBottom(10);
            signOptions.setMargin(padding);
            Background background = new Background();
            background.setColor( Color.ORANGE);
            signOptions.setBackground(background);
            signOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea);
            signOptions.setImageFilePath(Constants.ImageStamp);
            signOptions.setBackgroundImageCropType(StampBackgroundCropType.InnerArea);
            signOptions.setAllPages(true);


            //add few outer round lines
            StampLine outerLine1 = new StampLine();
            outerLine1.setText("* European Union *");
            outerLine1.setTextRepeatType(StampTextRepeatType.FullTextRepeat);
            SignatureFont signatureFont1 = new SignatureFont();
            signatureFont1.setSize(12);
            signatureFont1.setFamilyName("Arial");
            outerLine1.setFont(signatureFont1);
            outerLine1.setHeight(30);
            outerLine1.setTextBottomIntent(6);
            outerLine1.setTextColor(Color.WHITE);
            outerLine1.setBackgroundColor(Color.BLUE);
            signOptions.getOuterLines().add(outerLine1);

            StampLine outerLine2 = new StampLine();
            outerLine2.setHeight(2);
            outerLine2.setBackgroundColor(Color.WHITE);
            signOptions.getOuterLines().add(outerLine2);

            StampLine outerLine3 = new StampLine();
            outerLine3.setText("* Entrepreneur *");
            outerLine3.setTextColor(Color.BLUE);
            outerLine3.setTextRepeatType(StampTextRepeatType.FullTextRepeat);
            SignatureFont signatureFont3 = new SignatureFont();
            signatureFont3.setSize(15);
            outerLine3.setFont(signatureFont3);
            outerLine3.setHeight(30);
            outerLine3.setTextBottomIntent(8);
            Border innerBorder3 = new Border();
            innerBorder3.setColor(Color.DARK_GRAY);
            innerBorder3.setDashStyle(DashStyle.Dot);
            outerLine3.setInnerBorder(innerBorder3);
            Border outerBorder3 = new Border();
            outerBorder3.setColor(Color.BLUE);
            outerLine3.setOuterBorder(outerBorder3);
            signOptions.getOuterLines().add(outerLine3);


            //Inner square lines
            StampLine innerLine1 = new StampLine();
            innerLine1.setText("John");
            innerLine1.setTextColor(Color.RED);
            SignatureFont signFont1 = new SignatureFont();
            signFont1.setSize(20);
            signFont1.setBold(true);
            innerLine1.setFont(signFont1);
            innerLine1.setHeight(40);
            signOptions.getInnerLines().add(innerLine1);

            StampLine innerLine2 = new StampLine();
            innerLine2.setText("Smith");
            innerLine2.setTextColor(Color.RED);
            SignatureFont signFont2 = new SignatureFont();
            signFont2.setSize(20);
            signFont2.setBold(true);
            innerLine2.setFont(signFont2);
            innerLine2.setHeight(40);
            signOptions.getInnerLines().add(innerLine2);

            StampLine innerLine3 = new StampLine();
            innerLine3.setText("SSN 1230242424");
            innerLine3.setTextColor(Color.MAGENTA);
            SignatureFont signFont3 = new SignatureFont();
            signFont3.setSize(12);
            signFont3.setBold(true);
            innerLine3.setFont(signFont3);
            innerLine3.setHeight(40);
            signOptions.getInnerLines().add(innerLine3);

            // sign document
            signature.sign(outputFilePath, signOptions);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}