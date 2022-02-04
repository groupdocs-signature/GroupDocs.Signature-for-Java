package com.groupdocs.signature.examples.basic_usage.update;

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

public class UpdateBarcode {
    /**
     * <p>
     * Update Barcode signature from the document
     * Update method supports changin Barcode location and size
     * </p>
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;
        // copy source file since Update method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "UpdateBarcode\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        // initialize Signature instance
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            BarcodeSearchOptions options = new BarcodeSearchOptions();

            List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class,options);
            if (signatures.size() > 0)
            {
                BarcodeSignature barcodeSignature = signatures.get(0);
                barcodeSignature.setLeft(100);
                barcodeSignature.setTop(100);
                boolean result = signature.update(outputFilePath,barcodeSignature);
                if (result)
                {
                    System.out.print("\nSignature with Barcode '"+barcodeSignature.getText()+"' and encode type '"+barcodeSignature.getEncodeType().getTypeName()+"' was updated in the document ['"+fileName+"'].");
                }
                else
                {
                    System.out.print("\nSignature was not updated in the document! Signature with Barcode"+barcodeSignature.getText()+"' and encode type '"+barcodeSignature.getEncodeType().getTypeName()+"' was not found!");
                }
            }

        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}