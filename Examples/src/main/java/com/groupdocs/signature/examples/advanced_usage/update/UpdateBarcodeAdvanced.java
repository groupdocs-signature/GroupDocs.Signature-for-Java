package com.groupdocs.signature.examples.advanced_usage.update;

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

public class UpdateBarcodeAdvanced {
    /**
     * <p>
     * Update Barcode sigantre in previosuly signed document by known SignatureId
     * </p>
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX_BARCODE_SIGNED;
        // copy source file since Update method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "UpdateBarcode\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        IOUtils.copy(new FileInputStream(filePath), new FileOutputStream(outputFilePath, true));
        // initialize Signature instance
        final Signature signature = new Signature(filePath);

        try /*JAVA: was using*/
        {
            // read from some data source signature Id value
            String signatureId = "1a5fbc08-4b96-43d9-b650-578b16fbb877";
            BarcodeSignature barcodeSignature = new BarcodeSignature(signatureId);
            barcodeSignature.setLeft(100);
            barcodeSignature.setTop(100);
            barcodeSignature.setWidth(200);
            barcodeSignature.setHeight(200);
            barcodeSignature.setSignature(false);
            boolean result = signature.update(outputFilePath,barcodeSignature);
            if (result)
            {
                System.out.print("Signature with Barcode '"+barcodeSignature.getText()+"' and encode type '"+barcodeSignature.getEncodeType().getTypeName()+"' was updated.");
            }
            else
            {
                System.out.print("Signature was not updated in the document! It was not found!");
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}