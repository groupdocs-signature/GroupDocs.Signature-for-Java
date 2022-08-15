package com.groupdocs.signature.examples.advanced_usage.delete;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteByListIds {
    /**
    * Delete signatures from the document by known list of the signature Identifiers
    * The list of signatures Ids could be obtained by GetDocumentInfo or as result from the Sign method.
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # DeleteByListIds : Delete signatures from the document by known list of the signature Identifiers\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        // copy source file since Delete method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "DeleteByListIds\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);

        // initialize Signature instance
        Signature signature = new Signature(filePath);
        {
            // read from some data source signature Id value
            List<String> signatureIdList = new ArrayList<String>();
            signatureIdList.add("ff988ab1-7403-4c8d-8db7-f2a56b9f8530");
            signatureIdList.add("07f83369-318b-41ad-a843-732417b912c2");
            signatureIdList.add("e3ad0ec7-9abf-426d-b9aa-b3328f3f1470");
            signatureIdList.add("eff64a14-dad9-47b0-88e5-2ee4e3604e71");

            // delete required signatures
            DeleteResult deleteResult = signature.delete(signatureIdList);
            if ( deleteResult.getSucceeded().size() == signatureIdList.size())
            {
                System.out.print("All signatures were successfully deleted!");
            }
            else
            {
                System.out.print("Successfully deleted signatures : {deleteResult.Succeeded.Count}");
                System.out.print("Not deleted signatures : {deleteResult.Failed.Count}");
            }
            System.out.print("List of deleted signatures:");
            for(BaseSignature temp : deleteResult.getSucceeded())
            {
                System.out.print("Signature# Id:{temp.SignatureId}, Location: {temp.Left}x{temp.Top}. Size: {temp.Width}x{temp.Height}");
            }
        }
    }
}

