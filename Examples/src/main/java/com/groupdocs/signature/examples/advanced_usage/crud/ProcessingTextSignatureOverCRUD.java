package com.groupdocs.signature.examples.advanced_usage.crud;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.*;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.TextSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.TextSearchOptions;
import com.groupdocs.signature.options.sign.TextSignOptions;
import com.groupdocs.signature.options.verify.TextVerifyOptions;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessingTextSignatureOverCRUD {
    /**
    * Following example shows how to process Text Signature over all signature life-cycle.
    * First document is being signed with Text Signature, then verified for it, searched for same, updating and finally deleting this signature.
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # ProcessingTextSignatureOverCRUD : Process Text Signature over all signature life-cycle\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "ProcessingTextSignatureOverCRUD\\"+ fileName).getPath();
        List<String> signatureIds = new ArrayList<String>();
        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 1. Sign document with Text Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        String textLabel = "John Smith";
        Signature signature = new Signature(filePath);
        {
            TextSignOptions signOptions = new TextSignOptions(textLabel);
            signOptions.setVerticalAlignment(VerticalAlignment.Top);
            signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
            signOptions.setWidth(100);
            signOptions.setHeight(40);
            signOptions.setMargin(new Padding(20));
            // set barcode color and Font
            signOptions.setForeColor(Color.RED);
            SignatureFont signatureFont = new SignatureFont();
            signatureFont.setSize(12);
            signatureFont.setFamilyName("Comic Sans MS");
            signOptions.setFont(signatureFont);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, signOptions);
            System.out.print("\nDocument " + filePath + " was signed with following signatures:");
            for (BaseSignature temp : signResult.getSucceeded())
            {
                // collect newly created signature' Id
                signatureIds.add(temp.getSignatureId());
                System.out.print("Signature : "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 2. Verify document for Text Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        Signature signature2 = new Signature(outputFilePath);
        {
            TextVerifyOptions verifyOptions = new TextVerifyOptions();

                // specify if all pages should be verified
                verifyOptions.setAllPages(false);
                verifyOptions.setPageNumber(1);
                // specify verification text pattern
                verifyOptions.setMatchType(TextMatchType.Exact);
                // specify text pattern
                verifyOptions.setText(textLabel);

            // verify document signatures
            VerificationResult verifyResult = signature2.verify(verifyOptions);
            if (verifyResult.isValid())
            {
                System.out.print("\nDocument was verified successfully!");
            }
            else
            {
                System.out.print("\nDocument failed verification process.");
            }
            // -----------------------------------------------------------------------------------------------------------------------------
            // STEP 3. Search document for Text Signature
            // -----------------------------------------------------------------------------------------------------------------------------
            TextSearchOptions searchOptions = new TextSearchOptions();
                // specify special pages to search on
            searchOptions.setAllPages(true);
                // specify text match type
            searchOptions.setMatchType(TextMatchType.Exact);
                // specify text pattern to search
            searchOptions.setText(textLabel);

            // search for text signatures in document
            List<TextSignature> signatures = signature.search(TextSignature.class,searchOptions);
            System.out.print("\nSource document contains following text signature(s).");
            // enumerate all signature for output
            for (TextSignature textSignature : signatures)
            {
                if (textSignature != null)
                {
                    System.out.print("Found Text signature at page "+textSignature.getPageNumber()+" with type ["+textSignature.getSignatureImplementation()+"] and text '"+textSignature.getText()+"'.");
                    System.out.print("Location at "+textSignature.getLeft()+"-"+textSignature.getTop()+". Size is "+textSignature.getWidth()+"x"+textSignature.getHeight()+".");
                }
            }
            // -----------------------------------------------------------------------------------------------------------------------------
            // STEP 4. Update document Text Signature after searching it
            // -----------------------------------------------------------------------------------------------------------------------------

            List<BaseSignature> signaturesToUpdate = new ArrayList<BaseSignature>();
            for (TextSignature textSignature : signatures)
            {
                // change Text property
                textSignature.setText("John Walkman");
                // change position
                textSignature.setLeft(textSignature.getLeft() + 100);
                textSignature.setTop(textSignature.getTop() + 100);
                // change size. Please note not all documents support changing signature size
                textSignature.setWidth(200);
                textSignature.setHeight(50);
                signaturesToUpdate.add(textSignature);
            }

            UpdateResult updateResult = signature2.update(new ByteArrayOutputStream(), signaturesToUpdate);
            if (updateResult.getSucceeded().size() == signatures.size())
            {
                System.out.print("\nAll signatures were successfully updated!");
            }
            else
            {
                System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
                System.out.print("Not updated signatures : "+updateResult.getFailed().size());
            }
            System.out.print("List of updated signatures:");
            for (BaseSignature temp : updateResult.getSucceeded())
            {
                System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
            // -----------------------------------------------------------------------------------------------------------------------------
            // STEP 5. Update document Text Signature on saved SignatureId
            // create list of Text Signature by known SignatureId
            // -----------------------------------------------------------------------------------------------------------------------------
            signaturesToUpdate.clear();
            for ( String item : signatureIds)
            {
                TextSignature temp = new TextSignature(item);
                temp.setWidth(150);
                temp.setHeight(30);
                temp.setLeft(100);
                temp.setTop(100);
                temp.setText("Mr.John Smith");

                signaturesToUpdate.add(temp);
            }
            // update all found signatures
            updateResult = signature2.update(new ByteArrayOutputStream(), signaturesToUpdate);
            if (updateResult.getSucceeded().size() == signatures.size())
            {
                System.out.print("\nAll signatures were successfully updated!");
            }
            else
            {
                System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
                System.out.print("Not updated signatures : "+updateResult.getFailed().size());
            }
            System.out.print("List of updated signatures:");
            for (BaseSignature temp : updateResult.getSucceeded())
            {
                System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
            // -----------------------------------------------------------------------------------------------------------------------------
            // STEP 6. Delete document Text Signature by id
            // create list of Text Signature by known SignatureId
            signaturesToUpdate.clear();
            for (String item : signatureIds)
            {
                TextSignature temp = new TextSignature(item);
                signaturesToUpdate.add(temp);
            }
            // delete all signatures
            DeleteResult deleteResult = signature2.delete(new ByteArrayOutputStream(), signaturesToUpdate);
            if (deleteResult.getSucceeded().size() == signaturesToUpdate.size())
            {
                System.out.print("\nAll signatures were successfully deleted!");
            }
            else
            {
                System.out.print("Successfully deleted signatures : "+deleteResult.getSucceeded().size());
                System.out.print("Not deleted signatures : "+deleteResult.getFailed().size());
            }
            System.out.print("List of deleted signatures:");
            for (BaseSignature temp : deleteResult.getSucceeded())
            {
                System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
    }
}