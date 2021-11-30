package com.groupdocs.signature.examples.advanced_usage.update;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.UpdateResult;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.ImageSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.ImageSearchOptions;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UpdateImageAfterSearch {

    /**
     * Update Image signature in the document.
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # UpdateBarcodeAfterSearch : Update Barcode signature from the document\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        // copy source file since Update method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "UpdateImageAfterSearch\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        // initialize Signature instance
        Signature signature = new Signature(filePath);
        ImageSearchOptions options = new ImageSearchOptions();
        // search for image signatures in document
        List<ImageSignature> signatures = signature.search(ImageSignature.class,options);
        List<BaseSignature> bs = new ArrayList<BaseSignature>();
        // adjust signature properties
        for (ImageSignature temp : signatures)
        {
            // apply some condition to adjust signature properties
            temp.setLeft(temp.getLeft() + 100);
            temp.setTop(temp.getTop() + 100);
            if (temp.getSize() > 10000)
            {
                temp.setSignature(false);
            }
            bs.add(temp);
        }
            // update all found signatures
        UpdateResult updateResult = signature.update(outputFilePath, bs);
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
