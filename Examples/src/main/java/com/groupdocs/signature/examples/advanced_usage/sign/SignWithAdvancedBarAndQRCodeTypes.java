package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.documentpreview.FileType;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignWithAdvancedBarAndQRCodeTypes
{
    /**
     * <p>
     * Sign document with advanced Barcodes and QR-Codes.
     * This example demonstrates how to use specific Barcodes and QR-Code formats.
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # GroupDocs.Signature.Examples.CSharp.AdvancedUsage : Sign document with advanced Barcodes and QR-Codes\n");

        // The path to the documents directory.
        String sourceFilePath = Constants.SAMPLE_PRESENTATION;
        String fileName = Paths.get(sourceFilePath).getFileName().toString();
        String destinFilePath = new File(Constants.OutputPath, "SignWithAdvancedBarAndQRCodeTypes\\"+ fileName).getPath();

        final Signature signature = new Signature(sourceFilePath);
        try /*JAVA: was using*/
        {

            // create GS1DotCode BarCode options
            BarcodeSignOptions GS1DotCodeOptions = new BarcodeSignOptions("(01)04912345123459(15)970331(30)128(10)ABC123", BarcodeTypes.GS1DotCode);
            GS1DotCodeOptions.setLeft(1);
            GS1DotCodeOptions.setTop(1);
            GS1DotCodeOptions.setHeight(150);
            GS1DotCodeOptions.setWidth(200);
            GS1DotCodeOptions.setReturnContent(true);
            GS1DotCodeOptions.setReturnContentType(FileType.PNG);

            List<SignOptions> listOptions = new ArrayList<SignOptions>();
            listOptions.add(GS1DotCodeOptions);

            // sign document to file with list of all specific QR-Codes
            SignResult signResult = signature.sign(destinFilePath, listOptions);

            System.out.print("\nSource document signed successfully.\nFile saved at "+  destinFilePath);

            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature item : signResult.getSucceeded())
            {
                if( item instanceof BarcodeSignature){
                    String barOutputImagePath = Constants.OutputPath + "SignWithAdvancedBarAndQRCodeTypes\\image"+number+((BarcodeSignature)item).getFormat().getExtension();
                    FileOutputStream output = new FileOutputStream(barOutputImagePath);

                    byte[] array = ((BarcodeSignature)item).getContent();
                    // Writes byte to the file
                    output.write(array);
                    output.close();
                    number++;
                    break;
                }else if (item instanceof QrCodeSignature){
                    String qrOutputImagePath = Constants.OutputPath + "SignWithAdvancedBarAndQRCodeTypes\\image"+number+((QrCodeSignature)item).getFormat().getExtension();
                    FileOutputStream output = new FileOutputStream(qrOutputImagePath);

                    byte[] array = ((QrCodeSignature)item).getContent();
                    // Writes byte to the file
                    output.write(array);
                    output.close();
                    number++;
                    break;
                } else {
                    break;
                }
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
