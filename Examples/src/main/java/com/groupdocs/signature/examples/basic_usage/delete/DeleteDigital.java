package com.groupdocs.signature.examples.basic_usage.delete;

import com.amazonaws.util.IOUtils;
import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

public class DeleteDigital {
    /**
     * Delete Digital signature from the document.
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # DeleteDigital : Delete Digital signature from the document");
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED_DIGITAL;
        String fileName = Paths.get(filePath).getFileName().toString();
        // copy source file since Delete method works with same Document
        String outputFilePath = new File(Constants.OutputPath, "DeleteDigital\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        Signature signature = new Signature(filePath);
        {
            // search for electronic Digital signatures in the document
            List<DigitalSignature> signatures = signature.search(DigitalSignature.class, SignatureType.Digital);
            if (signatures.size() > 0)
            {
                DigitalSignature digitalSignature = signatures.get(0);
                boolean result = signature.delete(outputFilePath,digitalSignature);
                if (result)
                {
                            System.out.print("Digital signature #"+digitalSignature.getThumbprint()+" from the "+digitalSignature.getSignTime()+" was deleted from document ['"+fileName+"'].");
                }
                else
                {
                    System.out.print("Signature was not deleted from the document! Signature# "+digitalSignature.getThumbprint()+" was not found!");
                }
            }
        }
    }
}
