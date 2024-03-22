package com.groupdocs.signature.examples.basic_usage.sign.metadata;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.metadata.PdfMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.MetadataSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.Date;

public class SignPdfWithMetadata {
    /**
     * Sign pdf document with metadata signature
     */
    public static void run() throws Exception{
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SignPdfWithMetadata : Sign pdf document with metadata signature.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignPdfWithMetadata\\" + fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            // create Metadata option with predefined Metadata text
            MetadataSignOptions options = new MetadataSignOptions();

            // Create few Pdf Metadata signatures
            PdfMetadataSignature[] signatures = new PdfMetadataSignature[]
                    {
                            new PdfMetadataSignature("Author", "Mr.Scherlock Holmes"),
                            new PdfMetadataSignature("DateCreated", new Date()),
                            new PdfMetadataSignature("DocumentId", 123456),
                            new PdfMetadataSignature("SignatureId", 123.456)//decimal value
                    };
            options.getSignatures().addRange(signatures);

            // sign document to file
            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}