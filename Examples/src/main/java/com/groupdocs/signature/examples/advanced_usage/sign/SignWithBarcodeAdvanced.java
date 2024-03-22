package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.*;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.documentpreview.FileType;
import com.groupdocs.signature.domain.enums.CodeTextAlignment;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.LinearGradientBrush;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public class SignWithBarcodeAdvanced {
    /**
     * Sign document with Bar-Code signature applying specific options
     */
    public static void run() throws Exception{
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithBarcodeAdvanced : Sign document with Bar-Code signature applying specific options.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithBarcodeAdvanced\\" + fileName).getPath();

        try {
            Signature signature = new Signature(filePath);
            // create barcode option with predefined barcode text
            BarcodeSignOptions signOptions = new BarcodeSignOptions("12345678");

            // setup Barcode encoding type
            signOptions.setEncodeType(BarcodeTypes.Code128);
            // set signature position
            signOptions.setLeft(100);
            signOptions.setTop(100);
            // when VerticalAlignment is set the Top coordinate will be ignored.
            // Use Margin properties Top, Bottom to provide vertical offset
            signOptions.setVerticalAlignment(VerticalAlignment.Top);
            // when HorizontalAlignment is set the Left coordinate will be ignored.
            // Use Margin properties Left, Right to provide horizontal offset
            signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
            Padding padding = new Padding();
            padding.setLeft(20);
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
            // specify position of text with barcode line
            signOptions.setCodeTextAlignment(CodeTextAlignment.Above);
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
            for(BaseSignature o : signResult.getSucceeded()) {
                BarcodeSignature barcodeSignature = (BarcodeSignature) o;
                System.out.print("Signature #" + number++ + ": Type: " + barcodeSignature.getSignatureType() + " Id:" + barcodeSignature.getSignatureId() +
                        ",Location: " + barcodeSignature.getLeft() + "x" + barcodeSignature.getTop() + ". Size: " + barcodeSignature.getWidth() + "x" + barcodeSignature.getHeight());

                String outputImagePath = new File(Constants.OutputPath, "SignWithBarcodeAdvanced\\image" + number + barcodeSignature.getFormat().getExtension()).getPath();
                OutputStream os = new FileOutputStream(outputImagePath);
                // Starts writing the bytes in it
                os.write(barcodeSignature.getContent());
                // Close the file
                os.close();

            }
            System.out.print("\nSource document signed successfully.\nFile saved at" + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}