package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_complex_objects;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.extensions.mailmark2d.Mailmark2D;
import com.groupdocs.signature.domain.extensions.mailmark2d.Mailmark2DType;
import com.groupdocs.signature.domain.extensions.serialization.DataMatrixEncodeMode;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;

public class SignWithQRCodeMailmark2DObject
{
    /**
     * <p>
     * Sign document with QR-Code containing complex Mailmark2D object
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithQRCodeMailmark2DObject : Sign document with QR-Code containing HIBC LIC PrimaryData object\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeMailmark2D\\SignWithQRCodeMailmark2D.pdf").getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // create Mailmark2D data object
            Mailmark2D mailmark2D = new Mailmark2D();
            mailmark2D.setUPUCountryID("JGB ");
            mailmark2D.setInformationTypeID("0");
            mailmark2D.setClass("1");
            mailmark2D.setSupplyChainID(123);
            mailmark2D.setItemID(1234);
            mailmark2D.setDestinationPostCodeAndDPS("QWE1");
            mailmark2D.setRTSFlag("0");
            mailmark2D.setReturnToSenderPostCode("QWE2");
            mailmark2D.setDataMatrixType(Mailmark2DType.Type_7);
            mailmark2D.setCustomerContentEncodeMode(DataMatrixEncodeMode.C40);
            mailmark2D.setCustomerContent("CUSTOM");

            // create options
            QrCodeSignOptions options = new QrCodeSignOptions();
            options.setEncodeType(QrCodeTypes.QR);
            options.setLeft(100);
            options.setTop(100);
            options.setData(mailmark2D);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, options);
        }
        finally { if (signature != null) (signature).dispose(); }

        System.out.print("\nSource document signed successfully with Mailmark2D.\nFile saved at "+  outputFilePath);
    }
}
