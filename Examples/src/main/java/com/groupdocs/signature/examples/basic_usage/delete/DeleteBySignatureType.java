package com.groupdocs.signature.examples.basic_usage.delete;

import com.amazonaws.util.IOUtils;
import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;

public class DeleteBySignatureType {
    /**
     * Delete signatures of the certain type
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # DeleteBySignatureType : Delete signatures of the certain type \n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        String fileName = Paths.get(filePath).getFileName().toString();
        // copy source file since Delete method works with same Document
        String outputFilePath = new File(Constants.OutputPath, "DeleteByType\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        IOUtils.copy(new FileInputStream(filePath), new FileOutputStream(outputFilePath, true));
        // processing QR-Code signatures
        Signature signature = new Signature(outputFilePath);
        {
            // deleting QR-Code signatures from the document
            DeleteResult result = signature.delete(outputFilePath, SignatureType.QrCode);
            if (result.getSucceeded().size() > 0)
            {
                System.out.print("Following QR-Code signatures were deleted:");
                int number = 1;
                for (BaseSignature temp : result.getSucceeded())
                {
                    System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Text: "+((QrCodeSignature)temp).getText());
                }
            }
            else
            {
                System.out.print("No one QR-Code signature was deleted.");
            }
        }
    }
}
