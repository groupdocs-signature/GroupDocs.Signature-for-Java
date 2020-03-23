package com.groupdocs.signature.examples.advanced_usage.delete;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteBarcodeAfterSearch {

    /**
     * Delete Barcode signature from the document.
     */
    public static void run() throws Exception
    {

            System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
            System.out.print("[Example Advanced Usage] # DeleteBarcodeAfterSearch : Delete Barcode signature from the document");

            // The path to the documents directory.
            String filePath = Constants.SAMPLE_DOCX_BARCODE_SIGNED;
            // copy source file since Update method works with same Document
            String fileName = Paths.get(filePath).getFileName().toString();
            String outputFilePath = new File(Constants.OutputPath, "DeleteBarcodeAfterSearch\\"+ fileName).getPath();
            Constants.checkDir(outputFilePath);
            IOUtils.copy(new FileInputStream(filePath), new FileOutputStream(outputFilePath, true));
            // initialize Signature instance
            Signature signature = new Signature(outputFilePath);
            BarcodeSearchOptions options = new BarcodeSearchOptions();

            List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class, options);
            List<BaseSignature> signaturesToDelete = new ArrayList<BaseSignature>();
            // collect signatures to delete
            for (BarcodeSignature temp : signatures)
            {
                if (temp.getText().contains("John"))
                {
                    signaturesToDelete.add(temp);
                }
            }
            // delete signatures
            DeleteResult deleteResult = signature.delete(outputFilePath,signaturesToDelete);
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
            for(BaseSignature temp : deleteResult.getSucceeded())
            {
                System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
}