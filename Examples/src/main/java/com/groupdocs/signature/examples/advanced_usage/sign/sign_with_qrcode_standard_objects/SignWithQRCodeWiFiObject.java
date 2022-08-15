package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_standard_objects;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.serialization.WiFi;
import com.groupdocs.signature.domain.extensions.serialization.WiFiEncryptionType;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithQRCodeWiFiObject {

    /**
     * <p>
     * Sign document with QR-Code containing standard WiFi object
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithQRCodeCryptoCurrencyObject : Sign document with QR-Code containing crypto currency object\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeWiFiObject\\" + fileName).getPath();

        Signature signature = new Signature(filePath);
        {
            // create WiFi object
            WiFi wifi  = new WiFi();
            {
                wifi.setSSID("GuestNetwork!");
                wifi.setEncryption(WiFiEncryptionType.WPAWPA2);
                wifi.setPassword("guest");
                wifi.setHidden(false);
            };
            // create options
            QrCodeSignOptions options = new QrCodeSignOptions();
            {
                options.setEncodeType(QrCodeTypes.QR);
                // setup Data property to MeCard instance
                options.setData(wifi);
                // set right bottom corner
                options.setHorizontalAlignment(HorizontalAlignment.Left);
                options.setVerticalAlignment(VerticalAlignment.Center);
                options.setWidth(100);
                options.setHeight(100);
                options.setMargin (new Padding(10));
            };

            // sign document to file
            signature.sign(outputFilePath, options);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }
    }
}
