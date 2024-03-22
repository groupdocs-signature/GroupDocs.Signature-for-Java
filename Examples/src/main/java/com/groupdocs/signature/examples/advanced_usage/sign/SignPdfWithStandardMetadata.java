package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.metadata.MetadataSignature;
import com.groupdocs.signature.domain.signatures.metadata.PdfMetadataSignatures;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.MetadataSignOptions;
import org.apache.commons.lang3.time.DateUtils;

import java.io.File;
import java.nio.file.Paths;
import java.util.Date;

public class SignPdfWithStandardMetadata {
    /**
     * Sign pdf document with metadata signature
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignPdfWithStandardMetadata : Sign pdf document with metadata signature.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignPdfWithStandardMetadata//"+ fileName).getPath();

        try {
            Signature signature = new Signature(filePath);
            // setup options with text of signature
            MetadataSignOptions options = new MetadataSignOptions();

            // Using standard Pdf Metadata Signatures with new values
            MetadataSignature[] signatures = new MetadataSignature[]
                    {
                            PdfMetadataSignatures.getAuthor().deepClone("Mr.Scherlock Holmes"),
                            PdfMetadataSignatures.getCreateDate().deepClone(DateUtils.addDays(new Date(), -1)),
                            PdfMetadataSignatures.getMetadataDate().deepClone(DateUtils.addDays(new Date(), -2)),
                            PdfMetadataSignatures.getCreatorTool().deepClone("GD.Signature-Test"),
                            PdfMetadataSignatures.getModifyDate().deepClone(DateUtils.addDays(new Date(), -13)),
                            PdfMetadataSignatures.getProducer().deepClone("GroupDocs-Producer"),
                            PdfMetadataSignatures.getEntry().deepClone("Signature"),
                            PdfMetadataSignatures.getKeywords().deepClone("GroupDocs, Signature, Metadata, Creation Tool"),
                            PdfMetadataSignatures.getTitle().deepClone("Metadata Example"),
                            PdfMetadataSignatures.getSubject().deepClone("Metadata Test Example"),
                            PdfMetadataSignatures.getDescription().deepClone("Metadata Test example description"),
                            PdfMetadataSignatures.getCreator().deepClone("GroupDocs.Signature"),
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