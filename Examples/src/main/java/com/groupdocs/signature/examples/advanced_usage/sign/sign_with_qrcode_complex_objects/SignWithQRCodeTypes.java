package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_complex_objects;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.documentpreview.FileType;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SignWithQRCodeTypes
{
    /**
     * <p>
     * Sign document with various QR-Code types.
     * This example demonstrates how to pass specific text format for various QR-code types.
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithQRCodeTypes : Sign document with specific QR-Code types\n");

        // The path to the documents directory.
        String sourceFilePath = Constants.SAMPLE_PDF;
        String outputPath = Constants.OutputPath+ "SignWithQRCodeTypes\\";
        String destinFilePath = new File(Constants.OutputPath, "SignWithQRCodeTypes\\SignWithQRCodeTypes.pdf").getPath();

        final Signature signature = new Signature(sourceFilePath);
        try /*JAVA: was using*/
        {

            // create HIBC LIC QR-Code options
            QrCodeSignOptions hibcLic_QR = new QrCodeSignOptions("A123PROD30917/75#422011907#GP293", QrCodeTypes.HIBCLICQR);
            hibcLic_QR.setLeft(1);
            hibcLic_QR.setTop(1);
            hibcLic_QR.setReturnContent(true);
            hibcLic_QR.setReturnContentType(FileType.PNG);
            // create HIBC LIC Aztec Code options
            QrCodeSignOptions hibcLic_AZ = new QrCodeSignOptions("A123PROD30917/75#422011907#GP293", QrCodeTypes.HIBCLICAztec);
            hibcLic_AZ.setLeft(1);
            hibcLic_AZ.setTop(200);
            hibcLic_AZ.setReturnContent(true);
            hibcLic_AZ.setReturnContentType(FileType.PNG);
            // create HIBC LIC Aztec Code options
            QrCodeSignOptions hibcLic_DM = new QrCodeSignOptions("A123PROD30917/75#422011907#GP293", QrCodeTypes.HIBCLICDataMatrix);
            hibcLic_DM.setLeft(1);
            hibcLic_DM.setTop(400);
            hibcLic_DM.setReturnContent(true);
            hibcLic_DM.setReturnContentType(FileType.PNG);
            // create HIBC PAS QR-Code options
            QrCodeSignOptions hibcPas_QR = new QrCodeSignOptions("+/EAH783/Z34H159", QrCodeTypes.HIBCPASQR);
            hibcPas_QR.setLeft(400);
            hibcPas_QR.setTop(1);
            hibcPas_QR.setReturnContent(true);
            hibcPas_QR.setReturnContentType(FileType.PNG);
            // create HIBC PAS Aztec Code options
            QrCodeSignOptions  hibcPas_AZ = new QrCodeSignOptions("+/EAH783/Z34H159", QrCodeTypes.HIBCPASAztec);
            hibcPas_AZ.setLeft(400);
            hibcPas_AZ.setTop(200);
            hibcPas_AZ.setReturnContent(true);
            hibcPas_AZ.setReturnContentType(FileType.PNG);
            // create HIBC PAS Aztec Code options
            QrCodeSignOptions hibcPas_DM = new QrCodeSignOptions("+/EAH783/Z34H159", QrCodeTypes.HIBCPASDataMatrix);
            hibcPas_DM.setLeft(400);
            hibcPas_DM.setTop(400);
            hibcPas_DM.setReturnContent(true);
            hibcPas_DM.setReturnContentType(FileType.PNG);
            // compose list of options
            List<SignOptions> listOptions = new ArrayList<SignOptions>();
            listOptions.add(hibcLic_QR);
            listOptions.add(hibcLic_AZ);
            listOptions.add(hibcLic_DM);
            listOptions.add(hibcPas_QR);
            listOptions.add(hibcPas_AZ);
            listOptions.add(hibcPas_DM);
            // sign document to file with list of all specific QR-Codes
            SignResult signResult = signature.sign(destinFilePath, listOptions);

            System.out.print("\nSource document signed successfully.\nFile saved at " +  destinFilePath);

            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature o : signResult.getSucceeded())
            {
                QrCodeSignature qrSignature = (QrCodeSignature) o;
                String outputImagePath = Constants.OutputPath+ "image"+number+"."+qrSignature.getFormat().getExtension();

                final FileOutputStream fs = new FileOutputStream(outputImagePath);
                try /*JAVA: was using*/
                {
                    fs.write(qrSignature.getContent(), 0, qrSignature.getContent().length);
                }
                finally { if (fs != null) (fs).close(); }
                number++;
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
