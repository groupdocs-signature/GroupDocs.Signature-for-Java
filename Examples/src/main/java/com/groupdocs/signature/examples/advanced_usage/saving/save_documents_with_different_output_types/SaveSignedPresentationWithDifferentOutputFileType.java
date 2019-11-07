package com.groupdocs.signature.examples.advanced_usage.saving.save_documents_with_different_output_types;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.PdfSaveFileFormat;
import com.groupdocs.signature.domain.enums.PresentationSaveFileFormat;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.saveoptions.PdfSaveOptions;
import com.groupdocs.signature.options.saveoptions.PresentationSaveOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;

public class SaveSignedPresentationWithDifferentOutputFileType {
    /**
     * Sign document with qr-code signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PRESENTATION;

        String outputFilePath = new File(Constants.OutputPath, "SaveSignedOutputType//SamplePPSX.tiff").getPath();

        try {
            Signature signature = new Signature(filePath);
            // create QRCode option with predefined QRCode text
            QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
            signOptions.setEncodeType(QrCodeTypes.QR);
            signOptions.setLeft(100);
            signOptions.setTop(100);

            PresentationSaveOptions saveOptions = new PresentationSaveOptions();
            saveOptions.setFileFormat(PresentationSaveFileFormat.Tiff);
            saveOptions.setOverwriteExistingFiles(true);
            // sign document to file
            signature.sign(outputFilePath, signOptions, saveOptions);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}