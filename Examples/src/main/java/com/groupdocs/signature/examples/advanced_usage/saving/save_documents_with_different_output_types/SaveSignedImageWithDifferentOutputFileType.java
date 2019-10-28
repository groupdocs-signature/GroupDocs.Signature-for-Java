package com.groupdocs.signature.examples.advanced_usage.saving.save_documents_with_different_output_types;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.ImagesSaveFileFormat;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.ImagesSaveOptions;

import java.io.File;

public class SaveSignedImageWithDifferentOutputFileType {

    /**
     * Sign document with qr-code signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_JPG;

        String outputFilePath = new File(Constants.OutputPath, "SaveSignedOutputType//SampleJPG.svg").getPath();

        try {
            Signature signature = new Signature(filePath);
            // create QRCode option with predefined QRCode text
            QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
            signOptions.setEncodeType(QrCodeTypes.QR);
            signOptions.setLeft(100);
            signOptions.setTop(100);

            ImagesSaveOptions saveOptions = new ImagesSaveOptions();
            saveOptions.setFileFormat(ImagesSaveFileFormat.Svg);
            saveOptions.setOverwriteExistingFiles(true);
            // sign document to file
            signature.sign(outputFilePath, signOptions, saveOptions);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}