package com.groupdocs.signature.examples.advanced_usage.crud;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.*;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;
import com.groupdocs.signature.options.verify.BarcodeVerifyOptions;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessingBarcodeSignatureOverCRUD {

    /**
    * Following example shows how to process Barcode Signature over all signature life-cycle.
    * First document is being signed with Barcode Signature, then verified for it, searched for same, updating and finally deleting this signature.
    * Please be aware that this example works only on licensed product due to limitation with Barcode processing
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # ProcessingBarcodeSignatureOverCRUD : Process Barcode Signature over all signature life-cycle\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "ProcessingBarcodeSignatureOverCRUD\\"+ fileName).getPath();
        List<String> signatureIds = new ArrayList<String>();
        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 1. Sign document with Barcode Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        String bcText = "John Smith";
        Signature signature = new Signature(filePath);
        {
            BarcodeSignOptions signOptions = new BarcodeSignOptions(bcText, BarcodeTypes.Code128);

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
            System.out.print("\nDocument "+filePath+" was signed with following signatures:");
            for (BaseSignature temp : signResult.getSucceeded())
            {
                // collect newly created signature' Id
                signatureIds.add(temp.getSignatureId());
                System.out.print("Signature : "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 2. Verify document for Barcode Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        Signature signature2 = new Signature(outputFilePath);
        {
            BarcodeVerifyOptions verifyOptions = new BarcodeVerifyOptions();

                // specify if all pages should be verified
            verifyOptions.setAllPages(false);
            verifyOptions.setPageNumber(1);
                // barcode type
            verifyOptions.setEncodeType(BarcodeTypes.Code128);
                //
            verifyOptions.setText(bcText);

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
            // STEP 3. Search document for Barcode Signature
            // -----------------------------------------------------------------------------------------------------------------------------
            BarcodeSearchOptions searchOptions = new BarcodeSearchOptions();

                // specify special pages to search on
            searchOptions.setAllPages(true);

            // search for barcode signatures in document
            List<BarcodeSignature> signatures = signature2.search(BarcodeSignature.class,searchOptions);
            System.out.print("\nSource document contains following Barcode signature(s).");
            // enumerate all signature for output
            for (BarcodeSignature bcSignature : signatures)
            {
                if (bcSignature != null)
                {
                    System.out.print("Found Barcode signature at page "+bcSignature.getPageNumber()+" with type ["+bcSignature.getEncodeType().getTypeName()+"] and Barcode Text '"+bcSignature.getText()+"'.");
                    System.out.print("Location at "+bcSignature.getLeft()+"-"+bcSignature.getTop()+". Size is "+bcSignature.getWidth()+"x"+bcSignature.getHeight()+".");
                }
            }
            // -----------------------------------------------------------------------------------------------------------------------------
            // STEP 4. Update document Barcode Signature after searching it
            // -----------------------------------------------------------------------------------------------------------------------------
            List<BaseSignature> signaturesToUpdate = new ArrayList<BaseSignature>();
            for (BarcodeSignature bcSignature : signatures)
            {
                // change position
                bcSignature.setLeft(bcSignature.getLeft() + 100);
                bcSignature.setTop(bcSignature.getTop() + 100);
                // change size. Please note not all documents support changing signature size
                bcSignature.setWidth(200);
                bcSignature.setHeight(50);
                signaturesToUpdate.add(bcSignature);
            }
            UpdateResult updateResult = signature2.update(new ByteArrayOutputStream(),signaturesToUpdate);
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
            // STEP 5. Update document Barcode Signature on saved SignatureId
            // create list of Barcode Signature by known SignatureId
            // -----------------------------------------------------------------------------------------------------------------------------
            signaturesToUpdate.clear();
            for ( String item : signatureIds)
            {
                BarcodeSignature temp = new BarcodeSignature(item);
                temp.setWidth(150);
                temp.setHeight(30);
                temp.setLeft(100);
                temp.setTop(100);

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
            // STEP 6. Delete document barcode Signature by id
            // create list of Barcode Signature by known SignatureId
            signaturesToUpdate.clear();
            for (String item : signatureIds)
            {
                BarcodeSignature temp = new BarcodeSignature(item);
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
