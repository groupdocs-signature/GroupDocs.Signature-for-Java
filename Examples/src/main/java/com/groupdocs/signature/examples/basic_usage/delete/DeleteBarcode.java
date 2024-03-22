package com.groupdocs.signature.examples.basic_usage.delete;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

public class DeleteBarcode {
    /**
     * <p>
     * Delete Barcode signature from the document
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # DeleteBarcode : Delete Barcode signature from the document.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;
        String fileName = Paths.get(filePath).getFileName().toString();
        // copy source file since Delete method works with same Document
        String outputFilePath = new File(Constants.OutputPath, "DeleteBarcode\\" + fileName).getPath();
        Constants.checkDir(outputFilePath);
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            BarcodeSearchOptions options = new BarcodeSearchOptions();

            // search for Barcode signatures in document
            List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class,options);
            if (signatures.size() > 0)
            {
                BarcodeSignature barcodeSignature = signatures.get(0);
                boolean result = signature.delete(outputFilePath,barcodeSignature);
                if (result)
                {
                    System.out.print("\nSignature with Barcode "+barcodeSignature.getText()+" and encode type "+barcodeSignature.getEncodeType().getTypeName()+" was deleted from the document ["+fileName+"].");
                }
                else
                {
                    System.out.print("\nSignature was not updated in the document! Signature with Barcode "+barcodeSignature.getText()+" and encode type "+barcodeSignature.getEncodeType().getTypeName()+" was not found!");
                }
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}