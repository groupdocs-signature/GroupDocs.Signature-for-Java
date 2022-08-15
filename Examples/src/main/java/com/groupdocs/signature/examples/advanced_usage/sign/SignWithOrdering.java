package com.groupdocs.signature.examples.advanced_usage.sign;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignWithOrdering {
    /// <summary>
    /// Sign document with Barcode signature applying specific options
    /// </summary>
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithOrdering : Sign document with ordering the signatures\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_IMAGE;
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputPath = new File(Constants.OutputPath, "SignWithOrdering\\"+ fileName).getPath();

        Signature signature = new Signature(filePath);
        {
            // create several signatures that intersect

            // # 1 create barcode option with predefined barcode text
            // this options will be on top
            BarcodeSignOptions options1 = new BarcodeSignOptions("12345678");
            {
                // setup Barcode encoding type
                options1.setEncodeType(BarcodeTypes.Code128);
                // set signature position
                options1.setLeft(100);
                options1.setTop(100);
                options1.setWidth(100);
                options1.setHeight(100);
                options1.setZOrder(2);
            };

            // # 2 create barcode option with predefined barcode text
            // this options will be bottom
            QrCodeSignOptions options2 = new QrCodeSignOptions("12345678");
            {
                // setup Barcode encoding type
                options2.setEncodeType(QrCodeTypes.QR);
                // set signature position
                options2.setLeft(150);
                options2.setTop(150);
                options2.setZOrder(1);
            };
            // sign document to file
            List<SignOptions> options = new ArrayList<SignOptions>();
            options.add(options1);
            options.add(options2);
            SignResult signResult = signature.sign(outputPath, options);
            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputPath);
        }
    }
}
