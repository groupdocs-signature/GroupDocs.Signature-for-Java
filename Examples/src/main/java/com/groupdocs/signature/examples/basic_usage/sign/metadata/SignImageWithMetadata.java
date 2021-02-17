package com.groupdocs.signature.examples.basic_usage.sign.metadata;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.metadata.ImageMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.MetadataSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.Date;

public class SignImageWithMetadata {
    /**
     * Sign image document with metadata signature
     */
    public static void run() throws Exception{
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_IMAGE_JPG;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignImageWithMetadata\\" + fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            // create Metadata option with predefined Metadata text
            MetadataSignOptions options = new MetadataSignOptions();

            // Specify different Metadata Signatures and add them to options signature collection
            int imgsMetadataId = 41996;

            // Create several Image Metadata signatures with different types
            ImageMetadataSignature[] signatures = new ImageMetadataSignature[]
                    {
                            new ImageMetadataSignature(imgsMetadataId++, 123456), // int
                            new ImageMetadataSignature(imgsMetadataId++, "Mr.Scherlock Holmes"), // string
                            new ImageMetadataSignature(imgsMetadataId++,new Date()), // date time
                            new ImageMetadataSignature(imgsMetadataId++, 123.456), //decimal value
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