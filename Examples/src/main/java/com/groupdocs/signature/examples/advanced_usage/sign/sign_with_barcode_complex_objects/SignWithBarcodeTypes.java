package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_barcode_complex_objects;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.documentpreview.FileType;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignWithBarcodeTypes
{
    /**
     * <p>
     * Sign document with complex Barcode type signatures: GS1 Composite Bar and HIBC LIC barcodes
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithBarcodeTypes : Sign document with complex Barcode type signatures\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputPath = new File(Constants.OutputPath, "SignWithBarcodeTypes").getPath();
        String outputFilePath = new File(outputPath, fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // setup options with GS1CompositeBar: "|" separates the linear and the 2D component
            BarcodeSignOptions bc_GS1CompositeBar = new BarcodeSignOptions("(01)03212345678906|(21)A1B2C3D4E5F6G7H8", BarcodeTypes.GS1CompositeBar);
            bc_GS1CompositeBar.setTop(100);
            bc_GS1CompositeBar.setReturnContent(true);
            bc_GS1CompositeBar.setReturnContentType(FileType.PNG);

            // setup options with HIBCCode39LIC
            BarcodeSignOptions bc_HIBCLICCode39 = new BarcodeSignOptions("+A99912345/$$52001510X3", BarcodeTypes.HIBCCode39LIC);
            bc_HIBCLICCode39.setTop(300);
            bc_HIBCLICCode39.setReturnContent(true);
            bc_HIBCLICCode39.setReturnContentType(FileType.PNG);

            // setup options with HIBCCode128LIC
            BarcodeSignOptions bc_HIBCLICCode128 = new BarcodeSignOptions("+A99912345/$$52001510X3", BarcodeTypes.HIBCCode128LIC);
            bc_HIBCLICCode128.setTop(500);
            bc_HIBCLICCode128.setReturnContent(true);
            bc_HIBCLICCode128.setReturnContentType(FileType.PNG);

            List<SignOptions> listOptions = new ArrayList<SignOptions>();
            listOptions.add(bc_GS1CompositeBar);
            listOptions.add(bc_HIBCLICCode39);
            listOptions.add(bc_HIBCLICCode128);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, listOptions);
            System.out.print("\nSource document signed successfully with " + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath + ".");

            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature o : signResult.getSucceeded())
            {
                BarcodeSignature barcodeSignature = (BarcodeSignature) o;
                System.out.print("\nSignature #" + number + ": Type: " + barcodeSignature.getSignatureType() + " Id:" + barcodeSignature.getSignatureId()
                        + ", Location: " + barcodeSignature.getLeft() + "x" + barcodeSignature.getTop() + ". Size: " + barcodeSignature.getWidth() + "x" + barcodeSignature.getHeight());
                String outputImagePath = new File(outputPath, "image" + number + barcodeSignature.getFormat().getExtension()).getPath();
                final FileOutputStream fs = new FileOutputStream(outputImagePath);
                try /*JAVA: was using*/
                {
                    fs.write(barcodeSignature.getContent(), 0, barcodeSignature.getContent().length);
                }
                finally { if (fs != null) (fs).close(); }
                number++;
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
