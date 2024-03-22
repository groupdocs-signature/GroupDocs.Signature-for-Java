package com.groupdocs.signature.examples.basic_usage.update;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

public class UpdateQRCode {
    /**
     * <p>
     * Delete QR-Code signature from the document
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # UpdateQRCode : Delete QR-Code signature from the document.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;
        // copy source file since Update method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "UpdateQRCode//"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        // initialize Signature instance
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            QrCodeSearchOptions options = new QrCodeSearchOptions();
            // search for QRCode signatures in document
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, options);
            if (signatures.size() > 0)
            {
                QrCodeSignature qrCodeSignature = signatures.get(0);
                qrCodeSignature.setLeft(10);
                qrCodeSignature.setTop(10);
                boolean result = signature.update(outputFilePath,qrCodeSignature);
                if (result)
                {
                    System.out.print("\nSignature with QR-Code '"+qrCodeSignature.getText()+"' and encode type '"+qrCodeSignature.getEncodeType().getTypeName()+"' was deleted from document ['"+fileName+"'].");
                }
                else
                {
                    System.out.print("\nSignature was not deleted from the document! Signature with Barcode '"+qrCodeSignature.getText()+"' and encode type '"+qrCodeSignature.getEncodeType().getTypeName()+"' was not found!");
                }
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}