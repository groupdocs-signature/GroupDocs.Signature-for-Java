package com.groupdocs.signature.examples.advanced_usage.crud;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.DigitalSearchOptions;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessingDigitalSignatureOverCRUD
{
    /**
     * Following example shows how to process Digital Signature over all signature life-cycle.
     * First document is being signed with Digital Signature, then searched for it and finally deleting this signature.
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # ProcessingDigitalSignatureOverCRUD : Process Digital Signature over all signature life-cycle\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();
        String imagePath = Constants.ImageStamp;
        String certificatePath = Constants.CertificatePfx;

        String outputFilePath = new File(Constants.OutputPath, "ProcessingDigitalSignatureOverCRUD\\" + fileName).getPath();
        String deletedFilePath = new File(Constants.OutputPath, "ProcessingDigitalSignatureOverCRUD\\deleted_" + fileName).getPath();
        List<String> signatureIds = new ArrayList<String>();
        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 1. Sign document with Digital Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            DigitalSignOptions signOptions = new DigitalSignOptions(certificatePath);
            // certificate password
            signOptions.setPassword("1234567890");
            // digital certificate details
            signOptions.setReason("Approved");
            signOptions.setContact("John Smith");
            signOptions.setLocation("New York");
            // image as digital certificate appearance on document pages
            signOptions.setImageFilePath(imagePath);
            //
            signOptions.setWidth(160);
            signOptions.setHeight(80);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, signOptions);
            System.out.print("\nDocument " + filePath + " was signed with following signatures:");
            for (BaseSignature temp : signResult.getSucceeded())
            {
                // collect newly created signature' Id
                signatureIds.add(temp.getSignatureId());
                System.out.print("\nSignature : " + temp.getSignatureType() + " Id:" + temp.getSignatureId() + ", Location: " + temp.getLeft() + "x" + temp.getTop() + ". Size: " + temp.getWidth() + "x" + temp.getHeight());
            }
        }
        finally { if (signature != null) (signature).dispose(); }

        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 2. Search document for Digital Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        List<DigitalSignature> signatures;
        final Signature signedDocument = new Signature(outputFilePath);
        try /*JAVA: was using*/
        {
            DigitalSearchOptions searchOptions = new DigitalSearchOptions();
            // specify special pages to search on
            searchOptions.setAllPages(true);

            // search for Digital signatures in document
            signatures = signedDocument.search(DigitalSignature.class, searchOptions);
            System.out.print("\nSource document contains following Digital signature(s).");
            // enumerate all signature for output
            for (DigitalSignature digitalSignature : signatures)
            {
                if (digitalSignature != null)
                {
                    System.out.print("\nFound Digital signature #" + digitalSignature.getSignatureId() + " and '" + digitalSignature.getThumbprint() + "'.");
                }
            }

            // -----------------------------------------------------------------------------------------------------------------------------
            // STEP 3. Delete document Digital Signature by id
            // create list of Digital Signature by known SignatureId
            List<BaseSignature> signaturesToRemove = new ArrayList<BaseSignature>(signatures);
            // delete all signatures
            DeleteResult deleteResult = signedDocument.delete(deletedFilePath, signaturesToRemove);
            if (deleteResult.getSucceeded().size() == signatures.size())
            {
                System.out.print("\nAll signatures were successfully deleted!");
            }
            else
            {
                System.out.print("\nSuccessfully deleted signatures : " + deleteResult.getSucceeded().size());
                System.out.print("\nNot deleted signatures : " + deleteResult.getFailed().size());
            }
            System.out.print("\nList of deleted signatures:");
            for (BaseSignature temp : deleteResult.getSucceeded())
            {
                System.out.print("\nSignature# Id:" + temp.getSignatureId() + ", Location: " + temp.getLeft() + "x" + temp.getTop() + ". Size: " + temp.getWidth() + "x" + temp.getHeight());
            }
        }
        finally { if (signedDocument != null) (signedDocument).dispose(); }
    }
}
