package com.groupdocs.signature.examples.quick_start;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class HelloWorld {

    /**
     * Basic example of GroupDocs.Signature usage
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "HelloWorld//"+ fileName).getPath();

        // Sign document with text signature.
        try {
            Signature signature = new Signature(filePath);
            TextSignOptions textSignOptions = new TextSignOptions("John Smith");
            signature.sign(outputFilePath, textSignOptions);


            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}