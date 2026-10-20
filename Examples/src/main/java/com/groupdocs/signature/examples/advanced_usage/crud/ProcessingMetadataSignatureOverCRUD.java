package com.groupdocs.signature.examples.advanced_usage.crud;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.metadata.PdfMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.MetadataSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessingMetadataSignatureOverCRUD
{
    /**
     * Following example shows how to process Metadata Signature over all signature life-cycle.
     * First document is being signed with Metadata Signatures and then searched for them.
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # ProcessingMetadataSignatureOverCRUD : Process Metadata Signature over all signature life-cycle\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "ProcessingMetadataSignatureOverCRUD\\" + fileName).getPath();
        List<String> signatureIds = new ArrayList<String>();
        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 1. Sign document with Metadata Signature(s)
        // -----------------------------------------------------------------------------------------------------------------------------
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // create Metadata option with predefined Metadata text
            MetadataSignOptions signOptions = new MetadataSignOptions();
            signOptions
                    .add(new PdfMetadataSignature("Author", "Mr.Scherlock Holmes")) // String value
                    .add(new PdfMetadataSignature("CreatedOn", new Date()))         // Date values
                    .add(new PdfMetadataSignature("DocumentId", 123456))            // Integer value
                    .add(new PdfMetadataSignature("SignatureId", 123.456D))         // Double value
                    .add(new PdfMetadataSignature("Amount", 123.456D))              // Decimal value (Java has no decimal type)
                    .add(new PdfMetadataSignature("Total", 123.456F));              // Float value

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, signOptions);
            System.out.print("\nDocument " + filePath + " was signed with following signatures:");
            for (BaseSignature temp : signResult.getSucceeded())
            {
                // collect newly created signature' Id
                signatureIds.add(temp.getSignatureId());
                System.out.print("\nSignature : " + temp.getSignatureType() + " Id:" + temp.getSignatureId());
            }
        }
        finally { if (signature != null) (signature).dispose(); }

        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 2. Search document for Metadata Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        final Signature signedDocument = new Signature(outputFilePath);
        try /*JAVA: was using*/
        {
            List<PdfMetadataSignature> signatures = signedDocument.search(PdfMetadataSignature.class, SignatureType.Metadata);
            System.out.print("\nSource document ['" + filePath + "'] contains following signatures.");
            for (PdfMetadataSignature mdSignature : signatures)
            {
                System.out.print("\n\t[" + mdSignature.getTagPrefix() + " : " + mdSignature.getName() + "] = " + mdSignature.getValue() + " (" + mdSignature.getType() + ")");
            }
        }
        finally { if (signedDocument != null) (signedDocument).dispose(); }
    }
}
