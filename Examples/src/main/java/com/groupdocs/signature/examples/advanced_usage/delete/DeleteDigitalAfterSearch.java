package com.groupdocs.signature.examples.advanced_usage.delete;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteDigitalAfterSearch
{
    /**
     * <p>
     * Delete Digital signature from the PDF Document.
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # DeleteDigitalAfterSearch : Delete Digital Signature from the PDF Document\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED_DIGITAL;
        // copy source file since Delete method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "DeleteDigitalAfterSearch\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        IOUtils.copy(new FileInputStream(filePath), new FileOutputStream(outputFilePath, true));
        // initialize Signature instance
        final Signature signature = new Signature(outputFilePath);
        try /*JAVA: was using*/
        {
            List<DigitalSignature> signatures = signature.search(DigitalSignature.class, SignatureType.Digital);
            final List<BaseSignature> signaturesToDelete = new ArrayList<BaseSignature>() ;
            // collect signatures to delete
            signaturesToDelete.addAll(signatures);
            // delete signatures
            DeleteResult deleteResult = signature.delete(new ByteArrayOutputStream(), signaturesToDelete);
            if (deleteResult.getSucceeded().size() == signaturesToDelete.size())
            {
                System.out.print("All signatures were successfully deleted!");
            }
            else
            {
                System.out.print("Successfully deleted signatures : "+deleteResult.getSucceeded().size());
                System.out.print("Not deleted signatures : "+deleteResult.getFailed().size());
            }
            System.out.print("List of deleted signatures:");
            for (BaseSignature temp : deleteResult.getSucceeded())
            {
                System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
        catch (Exception e){ System.out.print(e.getMessage()); }
    }
}
