package com.groupdocs.signature.examples.advanced_usage.update;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SearchResult;
import com.groupdocs.signature.domain.UpdateResult;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
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

public class UpdateMultipleAdvanced {
    /**
     * <p>
     * Update multiple signatures in the document over known Signature Id property
     * </p>
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        // copy source file since Update method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "UpdateMultipleAdvanced//"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        // initialize Signature instance
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
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
                System.out.print("\nTrying to update all signatures...");
                // mark all signatures as actual Signatures
                for (BaseSignature baseSignature : result.getSignatures())
                {
                    baseSignature.setSignature(true);
                }
                // update all found signatures
                UpdateResult updateResult = signature.update(outputFilePath,result.getSignatures());
                if (updateResult.getSucceeded().size() == result.getSignatures().size())
                {
                    System.out.print("\nAll signatures were successfully updated!");
                }
                else
                {
                    System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
                    System.out.print("Not updated signatures : "+updateResult.getFailed().size());
                }
                System.out.print("\nList of updated signatures:");
                int number = 1;
                for (BaseSignature temp : updateResult.getSucceeded())
                {
                    System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
                }
            }
            else
            {
                System.out.print("No one signature was found.");
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}