package com.groupdocs.signature.examples.basic_usage.sign.metadata;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.metadata.PresentationMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.MetadataSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.Date;

public class SignPresentationWithMetadata {
    /**
     * Sign presentation document with metadata signature
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PRESENTATION;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignPresentationWithMetadata//"+ fileName).getPath();

        try {
            Signature signature = new Signature(filePath);
            // setup options with text of signature
            MetadataSignOptions options = new MetadataSignOptions();

            // Create few Presentation Metadata signatures
            PresentationMetadataSignature[] signatures = new PresentationMetadataSignature[]
                    {
                            new PresentationMetadataSignature("Author", "Mr.Scherlock Holmes"),
                            new PresentationMetadataSignature("DateCreated", new Date()),
                            new PresentationMetadataSignature("DocumentId", 123456),
                            new PresentationMetadataSignature("SignatureId", 123.456)
                    };
            options.getSignatures().addRange(signatures);

            // sign document to file
            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}