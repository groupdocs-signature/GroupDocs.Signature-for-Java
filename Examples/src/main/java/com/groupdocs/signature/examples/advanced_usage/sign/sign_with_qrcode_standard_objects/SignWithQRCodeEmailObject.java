package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_standard_objects;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.serialization.Email;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;


public class SignWithQRCodeEmailObject {
    /**
     * Sign document with QR-Code containing standard Email object
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithQRCodeEmail : Sign document with QR-Code containing standard Email object\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;


        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeEmail\\QRCodeEmailObject.pdf").getPath();

        Signature signature = new Signature(filePath);
        {
            // create Email object
            Email email = new Email();
            email.setAddress("sherlock@holmes.com");
            email.setSubject("Very important e-mail");
            email.setBody("Hello, Watson. Reach me ASAP!");


            // create options
            // create options
            QrCodeSignOptions options = new QrCodeSignOptions();
            options.setEncodeType(QrCodeTypes.QR);
            // setup Data property to Address instance
            options.setData(email);
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
