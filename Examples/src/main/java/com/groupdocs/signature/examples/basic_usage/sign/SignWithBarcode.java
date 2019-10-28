package com.groupdocs.signature.examples.basic_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithBarcode {
    /**
     * Sign document with barcode signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignPdfWithFormField-"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            // create barcode option with predefined barcode text
            BarcodeSignOptions options = new BarcodeSignOptions("JohnSmith");

            // setup Barcode encoding type
            options.setEncodeType(BarcodeTypes.Code128);

            // set signature position
            options.setLeft(100);
            options.setTop(100);


            // sign document to file
            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}