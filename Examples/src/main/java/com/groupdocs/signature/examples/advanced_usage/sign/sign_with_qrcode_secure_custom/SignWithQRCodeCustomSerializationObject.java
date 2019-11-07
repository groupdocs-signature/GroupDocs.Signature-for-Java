package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_secure_custom;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.serialization.FormatAttribute;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.examples.advanced_usage.custom_encryption.CustomXOREncryption;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;

public class SignWithQRCodeCustomSerializationObject {

    /**
     * Creates class that implements IDataSerializer interface
     * It cam support common serialization like JSon or custom data format
     */
    public static class DocumentSignatureData {
        public String getID() {
            return ID;
        }

        public void setID(String value) {
            ID = value;
        }

        @FormatAttribute(propertyName = "SignID")
        public String ID;


        public final String getAuthor() {
            return Author;
        }

        public final void setAuthor(String value) {
            Author = value;
        }

        @FormatAttribute(propertyName = "SAuth")
        public String Author;
        //JAVA-added public wrapper for internalized property accessor

        public final java.util.Date getSigned() {
            return Signed;
        }

        public final void setSigned(java.util.Date value) {
            Signed = value;
        }

        @FormatAttribute(propertyName = "SDate", propertyFormat = "yyyy-MM-dd")
        public java.util.Date Signed = new java.util.Date();


        public final java.math.BigDecimal getDataFactor() {
            return DataFactor;
        }

        public final void setDataFactor(java.math.BigDecimal value) {
            DataFactor = value;
        }

        @FormatAttribute(propertyName = "SDFact", propertyFormat = "N2")
        public java.math.BigDecimal DataFactor = new java.math.BigDecimal(0.01);
    }

    /**
     * Sign document with QR-Code signature applying specific options
     */
    public static void run() {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;

        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeSecureCustom\\QRCodeCustomSerializationObject.pdf").getPath();

        try {
            Signature signature = new Signature(filePath);
            // create custom data encryption
            IDataEncryption encryption = new CustomXOREncryption();

            // create custom object
            DocumentSignatureData documentSignature = new DocumentSignatureData();
            documentSignature.setID(java.util.UUID.randomUUID().toString());
            documentSignature.setAuthor(System.getenv("USERNAME"));
            documentSignature.setSigned(new java.util.Date());
            documentSignature.setDataFactor(new java.math.BigDecimal("11.22"));

            // setup QR-Code options
            QrCodeSignOptions options = new QrCodeSignOptions();
            // set custom object to serialize to QR Code
            options.setData(documentSignature);
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