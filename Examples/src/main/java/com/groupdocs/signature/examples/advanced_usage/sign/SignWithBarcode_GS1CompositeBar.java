package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;
import java.io.File;
import java.nio.file.Paths;

public class SignWithBarcode_GS1CompositeBar
{
    /**
     * <p>
     * Sign document with Barcode signature applying specific options
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithBarcode_GS1CompositeBar : Sign document with GS1CompositeBar Barcode signature applying specific options\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputPath = new File(Constants.OutputPath, "SignWithBarcodeGS1CompositeBar\\"+ fileName).getPath();

        // instantiating the signature object
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // setup options with text of signature
            BarcodeSignOptions options = new BarcodeSignOptions("(01)03212345678906/(21)A1B2C3D4E5F6G7H8");
            // barcode type
            options.setEncodeType(BarcodeTypes.GS1CompositeBar);
            //Set signature position
            options.setTop(200);
            // if you need to sign all sheets set it to true
            options.setAllPages(true);

            // sign document
            SignResult signResult = signature.sign(outputPath, options);
            System.out.print("\nSource document signed successfully with GS1CompositeBar barcode.\nFile saved at {outputFilePath}.");

        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
