package com.groupdocs.signature.examples.advanced_usage.loading;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class LoadPasswordProtectedDocument {
    /**
     * Sign document with qr-code signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_PWD_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "LoadPasswordProtected\\"+ fileName).getPath();
        LoadOptions loadOptions = new LoadOptions() ;
        loadOptions.setPassword("1234567890");

        try {
            Signature signature = new Signature(filePath, loadOptions);
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