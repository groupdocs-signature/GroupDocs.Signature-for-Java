package com.groupdocs.signature.examples.basic_usage.delete;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.SearchResult;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;
import com.groupdocs.signature.options.search.MetadataSearchOptions;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;
import com.groupdocs.signature.options.search.SearchOptions;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteMultiple {
    /**
     * <p>
     * Delete multiple signatures from the document
     * </p>
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX_BARCODE_SIGNED;
        String fileName = Paths.get(filePath).getFileName().toString();
        // copy source file since Delete method works with same Document
        String outputFilePath = new File(Constants.OutputPath, "DeleteMultiple//" + fileName).getPath();
        Constants.checkDir(outputFilePath);
        IOUtils.copy(new FileInputStream(filePath), new FileOutputStream(outputFilePath, true));
        // processing signatures
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // define few search options
            BarcodeSearchOptions barcodeOptions = new BarcodeSearchOptions();
            QrCodeSearchOptions qrCodeOptions = new QrCodeSearchOptions();
            MetadataSearchOptions metadataOptions = new MetadataSearchOptions();
            // add options to list
            List<SearchOptions> listOptions = new ArrayList<SearchOptions>();
            listOptions.add(barcodeOptions);
            listOptions.add(qrCodeOptions);
            //listOptions.add(metadataOptions);

            // search for signatures in document
            SearchResult result = signature.search(listOptions);
            if (result.getSignatures().size() > 0)
            {
                System.out.print("\nTrying to delete all signatures...");
                DeleteResult deleteResult = signature.delete(outputFilePath,result.getSignatures());
                if(deleteResult.getSucceeded().size() == result.getSignatures().size())
                {
                    System.out.print("\nAll signatures were successfully deleted!");
                }
                else
                {
                    System.out.print("Successfully deleted signatures : "+deleteResult.getSucceeded().size());
                    System.out.print("Not deleted signatures : "+deleteResult.getFailed().size());
                }
                System.out.print("\nList of deleted signatures:");
                int number = 1;
                for(BaseSignature temp : deleteResult.getSucceeded())
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