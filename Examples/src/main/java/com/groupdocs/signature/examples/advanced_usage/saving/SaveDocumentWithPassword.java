package com.groupdocs.signature.examples.advanced_usage.saving;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.saveoptions.SaveOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SaveDocumentWithPassword {

    /**
     * Sign document with qr-code signature
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SaveSignedWithPassword\\" + fileName).getPath();

        try {
            Signature signature = new Signature(filePath);
            // create QRCode option with predefined QRCode text
            QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
            signOptions.setEncodeType(QrCodeTypes.QR);
            signOptions.setLeft(100);
            signOptions.setTop(100);

            SaveOptions saveOptions = new SaveOptions();
            saveOptions.setPassword("1234567890");
            saveOptions.setUseOriginalPassword(false);

            // sign document to file
            signature.sign(outputFilePath, signOptions, saveOptions);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}