package com.groupdocs.signature.examples.basic_usage.delete;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;

import java.io.File;
import java.nio.file.Paths;

public class DeleteById {
    /**
    * Delete signature from the document by known Id
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # DeleteById : Delete signature from the document by known Id \n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        String fileName = Paths.get(filePath).getFileName().toString();
        // copy source file since Delete method works with same Document
        String outputFilePath = new File(Constants.OutputPath, "DeleteById\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);

        Signature signature = new Signature(filePath);
        {
            String id = "eff64a14-dad9-47b0-88e5-2ee4e3604e71";
            boolean result = signature.delete(id);
            if (result)
            {
                System.out.print("Signature with Id# '"+id+"' was deleted from document ['"+fileName+"'].");
            }
            else
            {
                System.out.print("Signature was not deleted from the document! Signature with id# '"+id+"' was not found!");
            }
        }
    }
}

