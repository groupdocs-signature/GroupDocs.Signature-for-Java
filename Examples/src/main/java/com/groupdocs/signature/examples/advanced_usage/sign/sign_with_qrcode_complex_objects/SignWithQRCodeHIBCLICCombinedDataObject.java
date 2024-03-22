package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_complex_objects;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.hibclic.HIBCLICCombinedData;
import com.groupdocs.signature.domain.extensions.hibclic.HIBCLICDateFormat;
import com.groupdocs.signature.domain.extensions.hibclic.HIBCLICPrimaryData;
import com.groupdocs.signature.domain.extensions.hibclic.HIBCLICSecondaryAdditionalData;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.Date;

public class SignWithQRCodeHIBCLICCombinedDataObject
{
    /**
     * <p>
     * Sign document with QR-Code containing complex HIBCLICCombinedData object
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithQRCodeHIBCLICCombinedDataObject : Sign document with QR-Code containing HIBC LIC CombinedData object\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeHIBCLICCombinedData\\" + fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
             HIBCLICPrimaryData tmp0 = new  HIBCLICPrimaryData();
            tmp0.setProductOrCatalogNumber("12345");
            tmp0.setLabelerIdentificationCode("A999");
            tmp0.setUnitOfMeasureID(1);
             HIBCLICSecondaryAdditionalData tmp1 = new  HIBCLICSecondaryAdditionalData();
            tmp1.setExpiryDate(new Date());
            tmp1.setExpiryDateFormat(HIBCLICDateFormat.MMDDYY);
            tmp1.setQuantity(30);
            tmp1.setLotNumber("LOT123");
            tmp1.setSerialNumber("SERIAL123");
            tmp1.setDateOfManufacture(new Date());
            tmp1.setLinkCharacter('S');
            // create HIBC LIC Combined data object
            HIBCLICCombinedData combinedData = new HIBCLICCombinedData();
            combinedData.setPrimaryData(tmp0);
            combinedData.setSecondaryAdditionalData(tmp1);

            // create options
            QrCodeSignOptions options = new QrCodeSignOptions();
            options.setEncodeType(QrCodeTypes.HIBCLICQR);
            options.setData(combinedData);

            // sign document to file
            signature.sign(outputFilePath, options);
        }
        finally { if (signature != null) (signature).dispose(); }

        System.out.print("\nSource document signed successfully.\nFile saved at " +  outputFilePath);
    }
}
