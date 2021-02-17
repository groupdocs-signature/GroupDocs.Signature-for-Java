package com.groupdocs.signature.examples.advanced_usage.loading.loading_documents_from_different_sources;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class LoadDocumentFromLocalDisk {
    public static void run() throws Exception
    {
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithText\\"+ fileName).getPath();
        //
        try {
            Signature signature = new Signature(filePath);
            TextSignOptions options = new TextSignOptions("John Smith");

            // sign document to file
            signature.sign(outputFilePath, options);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }catch(Exception e){
        throw new GroupDocsSignatureException(e.getMessage());
    }
}

}