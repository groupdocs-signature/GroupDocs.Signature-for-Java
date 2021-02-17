package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_secure_custom;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricAlgorithmType;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricEncryption;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;

public class SignWithQRCodeEncryptedText {
    /**
    * Sign document with QR-Code signature applying specific options
    */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeSecureCustom\\QRCodeEncryptedText.pdf").getPath();

        try {
            Signature signature = new Signature(filePath);
            // setup key and passphrase
            String key = "1234567890";
            String salt = "1234567890";
            // create data encryption
            IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);

            // setup QR-Code options
            QrCodeSignOptions options = new QrCodeSignOptions();
            // set custom object to serialize to QR Code
            options.setText("This is private text to be secured.");
            // QR-code type
            options.setEncodeType(QrCodeTypes.QR);
            // specify serialization encryption
            options.setDataEncryption(encryption);
            // locate and aligh signature
            options.setHeight(100);
            options.setWidth(100);
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);
            Padding padding = new Padding() ;
            padding.setRight(10);
            padding.setBottom(10);
            options.setMargin(padding);

            // sign document to file
            signature.sign(outputFilePath, options);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}