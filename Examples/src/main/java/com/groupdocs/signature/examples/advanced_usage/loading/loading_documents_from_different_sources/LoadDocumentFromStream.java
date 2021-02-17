package com.groupdocs.signature.examples.advanced_usage.loading.loading_documents_from_different_sources;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class LoadDocumentFromStream {
    public static void run() throws Exception
    {
        String outputFilePath = new File(Constants.OutputPath, "SignFromStream\\signedSample.pdf").getPath();

        try {
            InputStream stream = new FileInputStream(Constants.SAMPLE_PDF);
            Signature signature = new Signature(stream);
            QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");

            options.setEncodeType(QrCodeTypes.QR);
            options.setLeft(100);
            options.setTop(100);

            // sign document to file
            signature.sign(outputFilePath, options);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}