package com.groupdocs.signature.examples.advanced_usage.delete;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.SearchResult;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;
import com.groupdocs.signature.options.search.SearchOptions;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteMultipleAdvanced {

    /**
     * Delete multiple signatures in the document.
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # DeleteMultipleAdvanced : Delete multiple signatures in the document\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "DeleteMultipleAdvanced\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        IOUtils.copy(new FileInputStream(filePath), new FileOutputStream(outputFilePath, true));
        // initialize Signature instance
        Signature signature = new Signature(outputFilePath);

        // define few search options
        BarcodeSearchOptions barcodeOptions = new BarcodeSearchOptions();
        QrCodeSearchOptions qrCodeOptions = new QrCodeSearchOptions();
        // add options to list
        List<SearchOptions> listOptions = new ArrayList<SearchOptions>();
        listOptions.add(barcodeOptions);
        listOptions.add(qrCodeOptions);

        // search for signatures in document
        SearchResult result = signature.search(listOptions);
        if (result.getSignatures().size() > 0)
        {
            System.out.print("Trying to delete signatures...");
            List<BaseSignature> signaturesToDelete = new ArrayList<BaseSignature>();
            // collect image signatures to delete
            for (BaseSignature temp : result.getSignatures())
            {
                signaturesToDelete.add(temp);
            }
            // delete signatures
            DeleteResult deleteResult = signature.delete(outputFilePath,signaturesToDelete);
            if (deleteResult.getSucceeded().size() == signaturesToDelete.size())
            {
                System.out.print("All signatures were successfully deleted!");
            }
            else
            {
                System.out.print("Successfully deleted signatures : " + deleteResult.getSucceeded().size());
                System.out.print("Not deleted signatures : " + deleteResult.getFailed().size());
            }
            System.out.print("List of deleted signatures:");
            for(BaseSignature temp : deleteResult.getSucceeded())
            {
                System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
        else
        {
            System.out.print("No one signature was found.");
        }
     }
}