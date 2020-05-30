package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_standard_objects;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.serialization.Event;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

public class SignWithQRCodeEventObject {
    /**
     * Sign document with QR-Code containing standard Event object.
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithQRCodeEventObject : Sign document with QR-Code containing standard QR-Code Event object\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeEvent\\QRCodeEventObject.pdf").getPath();

        Signature signature = new Signature(filePath);
        {
            // create Event object
            Event evnt = new Event();

            evnt.setTitle("GTM(9-00)");
            evnt.setDescription("General Team Meeting");
            evnt.setLocation("Conference-Room");
            Calendar c1 = Calendar.getInstance();
            c1.setTime(new Date());
            c1.add(Calendar.DATE, 1);
            c1.add(Calendar.HOUR, 9);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(new Date());
            c2.add(Calendar.DATE, 1);
            c2.add(Calendar.HOUR, 9);
            c2.add(Calendar.MINUTE, 30);
            evnt.setStartDate(c1.getTime());
            evnt.setEndDate(c2.getTime());

            // create options
            QrCodeSignOptions options = new QrCodeSignOptions();
            options.setEncodeType(QrCodeTypes.QR);
            // setup Data property to Event instance
            options.setData(evnt);
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
