package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Background;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignatureFont;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.LinearGradientBrush;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class SignWithQRCodeAdvanced {
    /**
    * Sign document with QR-Code signature applying specific options
    */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeAdvanced\\"+ fileName).getPath();

        try {
            Signature signature = new Signature(filePath);
            // create QRCode option with predefined QRCode text
            QrCodeSignOptions signOptions = new QrCodeSignOptions("12345678");

            // setup QRCode encoding type
            signOptions.setEncodeType(QrCodeTypes.QR);
            // set signature position
            signOptions.setLeft(100);
            signOptions.setTop(100);

            // set signature alignment

            // when VerticalAlignment is set the Top coordinate will be ignored.
            // Use Margin properties Top, Bottom to provide vertical offset
            signOptions.setVerticalAlignment(VerticalAlignment.Top);

            // when HorizontalAlignment is set the Left coordinate will be ignored.
            // Use Margin properties Left, Right to provide horizontal offset
            signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
            Padding padding = new Padding();
            padding.setRight(20);
            padding.setTop(20);
            signOptions.setMargin(padding);

            // adjust signature appearance

            // setup signature border
            Border border = new Border();
            border.setColor(Color.GREEN);
            border.setDashStyle(DashStyle.DashLongDashDot);
            border.setWeight(2);
            border.setTransparency(0.5);
            border.setVisible(true);
            signOptions.setBorder(border);

            // set text color and Font
            signOptions.setForeColor(Color.RED);
            SignatureFont font = new SignatureFont();
            font.setSize(12);
            font.setFamilyName("Comic Sans MS");
            signOptions.setFont(font);

            // setup background
            Background background = new Background();
            background.setColor(Color.GREEN);
            background.setTransparency(0.5);
            background.setBrush(new LinearGradientBrush(Color.GREEN, Color.DARK_GRAY, 0));
            signOptions.setBackground(background);

            // sign document to file
            signature.sign(outputFilePath, signOptions);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}