package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_standard_objects;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.serialization.SMS;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithQRCodeSMSObject {
    /**
     * <p>
     * Sign document with QR-Code containing standard Event object.
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithQRCodeSMSObject : Sign document with QR-Code containing standard QR-Code SMS object\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;

        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeSMS\\QRCodeSMSObject.pdf").getPath();

        Signature signature = new Signature(filePath);
        {
            // create Event object
            SMS sms = new SMS();
            {
                sms.setNumber("0800 048 0408");
                sms.setMessage("Document approval automatic SMS message");
            };
            // create options
            QrCodeSignOptions options = new QrCodeSignOptions();
            {
                options.setEncodeType(QrCodeTypes.QR);
                    // setup Data property to SMS instance
                options.setData(sms);
                    // set right bottom corner
                options.setHorizontalAlignment(HorizontalAlignment.Left);
                options.setVerticalAlignment(VerticalAlignment.Center);
                options.setWidth(100);
                options.setHeight(100);
                options.setMargin(new Padding(10));
            };

            // sign document to file
            signature.sign(outputFilePath, options);
        }

        System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }
}