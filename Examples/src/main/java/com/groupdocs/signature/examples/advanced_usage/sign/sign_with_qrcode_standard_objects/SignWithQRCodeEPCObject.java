package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_standard_objects;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.serialization.EPC;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithQRCodeEPCObject {
    /**
     * Sign document with QR-Code containing standard EPC/SEPA object.
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithQRCodeEPCObject : Sign document with QR-Code containing standard QR-Code EPC object\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeEPC\\QRCodeEPCObject.pdf").getPath();

        Signature signature = new Signature(filePath);
        {
            // create EPC object
            EPC epc = new EPC();
            epc.setName("Sherlock");
            epc.setBIC("MrSherlockH");
            epc.setIBAN("BE72000000001616");
            epc.setAmount(123456.78D);
            epc.setCode("SHRL");
            epc.setReference("Private service");
            epc.setInformation("Thanks for help");

            // create options
            QrCodeSignOptions options = new QrCodeSignOptions();
            options.setEncodeType(QrCodeTypes.QR);
            // setup Data property to EPC instance
            options.setData(epc);
            // set right bottom corner
            options.setHorizontalAlignment(HorizontalAlignment.Right);
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setMargin(new Padding(10));
            options.setWidth(100);
            options.setHeight(100);


            // sign document to file
            signature.sign(outputFilePath, options);
        }

        System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }
}
