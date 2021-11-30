package com.groupdocs.signature.examples.advanced_usage.update;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.UpdateResult;
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

public class UpdateBarcodeAfterSearch {
    /**
    * Update Barcode signature from the document.
    * Update method supports changing Barcode location and size.
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # UpdateBarcodeAfterSearch : Update Barcode signature from the document\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        // copy source file since Update method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "UpdateBarcodeAfterSearch\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        // initialize Signature instance
        Signature signature = new Signature(filePath);
        BarcodeSearchOptions options = new BarcodeSearchOptions();

        List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class, options);
        List<BaseSignature> bS = new ArrayList<BaseSignature>();
        // adjust signature properties
        for (BarcodeSignature temp : signatures)
        {
            // apply some condition to adjust signature properties
            temp.setLeft(temp.getLeft() + 100);
            temp.setTop(temp.getTop() + 100);
            temp.setSignature(true);
            bS.add(temp);
        }
        // update all found signatures
        UpdateResult updateResult = signature.update(outputFilePath,bS);
        if (updateResult.getSucceeded().size() == signatures.size())
        {
            System.out.print("\nAll signatures were successfully updated!");
        }
        else
        {
            System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
            System.out.print("Not updated signatures : "+updateResult.getFailed().size());
        }
        System.out.print("List of updated signatures:");
        for (BaseSignature temp : updateResult.getSucceeded())
        {
            System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
        }

    }
}