package com.groupdocs.signature.examples.basic_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignWithMultipleOptions {
    /**
     * Sign document with barcode signature
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SignWithMultipleOptions : Sign document with barcode signature.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithMultiple//"+ fileName).getPath();

        try {
            Signature signature = new Signature(filePath);
            // setup options with text of signature
            // define several signature options of different types and settings
            TextSignOptions textOptions = new TextSignOptions("This is test message");
            textOptions.setVerticalAlignment(VerticalAlignment.Top);
            textOptions.setHorizontalAlignment(HorizontalAlignment.Left);

            BarcodeSignOptions barcodeOptions = new BarcodeSignOptions("123456");
            barcodeOptions.setEncodeType(BarcodeTypes.Code128);
            barcodeOptions.setLeft(100);
            barcodeOptions.setTop(100);

            QrCodeSignOptions qrcodeOptions = new QrCodeSignOptions("JohnSmith");
            qrcodeOptions.setEncodeType(QrCodeTypes.QR);
            qrcodeOptions.setLeft(100);
            qrcodeOptions.setTop(200);

            DigitalSignOptions digitalOptions = new DigitalSignOptions(Constants.CertificatePfx);
            digitalOptions.setImageFilePath(Constants.ImageHandwrite);
            digitalOptions.setVerticalAlignment(VerticalAlignment.Center);
            digitalOptions.setHorizontalAlignment(HorizontalAlignment.Center);
            digitalOptions.setPassword("1234567890");


            // define list of signature options
            List<SignOptions> listOptions = new ArrayList<SignOptions>();

            listOptions.add(textOptions);
            listOptions.add(barcodeOptions);
            listOptions.add(qrcodeOptions);
            listOptions.add(digitalOptions);

            // sign document to file
            signature.sign(outputFilePath, listOptions);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}