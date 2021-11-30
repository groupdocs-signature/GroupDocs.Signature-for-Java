package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.*;
import com.groupdocs.signature.domain.documentpreview.FileType;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.LinearGradientBrush;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public class SignWithQRCodeAdvanced {
    /**
    * Sign document with QR-Code signature applying specific options
    */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
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

            // set field for barcode images returning
            signOptions.setReturnContent(true);
            // specify type of returned barcode images
            signOptions.setReturnContentType(FileType.PNG);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, signOptions);
            // analyzing result
            System.out.print("List of newly created signatures:");
            int number = 1;
            for(BaseSignature o : signResult.getSucceeded())
            {
                QrCodeSignature qrSignature = (QrCodeSignature) o;
                System.out.print("Signature #"+ number++ +": Type: "+qrSignature.getSignatureType()+" Id:"+qrSignature.getSignatureId()+
                        ",Location: "+qrSignature.getLeft()+"x"+qrSignature.getTop()+". Size: "+qrSignature.getWidth()+"x"+qrSignature.getHeight());

                String outputImagePath = new File(Constants.OutputPath, "SignWithQRCodeAdvanced\\image" + number + qrSignature.getFormat().getExtension()).getPath();
                OutputStream os = new FileOutputStream(outputImagePath);
                // Starts writing the bytes in it
                os.write(qrSignature.getContent());
                // Close the file
                os.close();
            }

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}