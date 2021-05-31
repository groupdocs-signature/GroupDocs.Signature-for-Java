package com.groupdocs.signature.examples.advanced_usage.delete;

import com.amazonaws.util.IOUtils;
import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteBySignatureTypes {
    /**
     * Delete signatures of the certain types
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # DeleteBySignatureTypes : Delete signatures of the certain types \n");

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
            // compose the list of signature types to delete
            List<Integer> signedTypes = new ArrayList<Integer>();
            signedTypes.add(SignatureType.Text);
            signedTypes.add(SignatureType.Image);
            signedTypes.add(SignatureType.Barcode);
            signedTypes.add(SignatureType.QrCode);
            signedTypes.add(SignatureType.Digital);

            // deleting QR-Code signatures from the document by signature types
            DeleteResult result = signature.deleteByTypes(outputFilePath,signedTypes);
            if (result.getSucceeded().size() > 0)
            {
                System.out.print("Following signatures were removed:");
                int number = 1;
                for(BaseSignature temp : result.getSucceeded())
                {
                    System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+". Created: "+temp.getCreatedOn());
                }
            }
            else
            {
                System.out.print("No one signature was deleted.");
            }
        }
    }
}

