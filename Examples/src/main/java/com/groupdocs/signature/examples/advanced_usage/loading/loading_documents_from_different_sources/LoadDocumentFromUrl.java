package com.groupdocs.signature.examples.advanced_usage.loading.loading_documents_from_different_sources;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class LoadDocumentFromUrl {
    public static void run() throws Exception
    {
        String outputFilePath = new File(Constants.OutputPath, "SignedWithTextFromUrl\\sample.pdf").getPath();

        try {
            String url = "https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET/blob/master/Examples/Resources/SampleFiles/sample.pdf?raw=true";

            InputStream stream = new URL(url).openStream();
            Signature signature = new Signature(stream);

            TextSignOptions options = new TextSignOptions("John Smith");

            // set signature position
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