package com.groupdocs.signature.examples.advanced_usage.crud;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.UpdateResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.ImageSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.ImageSearchOptions;
import com.groupdocs.signature.options.sign.ImageSignOptions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessingImageSignatureOverCRUD {

    /**
    * Following example shows how to process Image Signature over all signature life-cycle.
    * First document is being signed with Image Signature, then verified for it, searched for same, updating and finally deleting this signature.
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # ProcessingImageSignatureOverCRUD : Process Image Signature over all signature life-cycle\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "ProcessingImageSignatureOverCRUD\\"+ fileName).getPath();
        List<String> signatureIds = new ArrayList<String>();
        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 1. Sign document with Image Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        Signature signature = new Signature(filePath);
        {
            ImageSignOptions signOptions = new ImageSignOptions(Constants.ImageStamp);
            signOptions.setVerticalAlignment(VerticalAlignment.Top);
            signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
            signOptions.setWidth(100);
            signOptions.setHeight(40);
            signOptions.setMargin(new Padding(20));

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
        // STEP 2. Search document for Image Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        Signature signature2 = new Signature(outputFilePath);
        {
            ImageSearchOptions searchOptions = new ImageSearchOptions();
            // specify special pages to search on
            searchOptions.setAllPages(true);


            // search for image signatures in document
            List<ImageSignature> signatures = signature2.search(ImageSignature.class,searchOptions);
            System.out.print("\nSource document contains following Image signature(s).");
            // enumerate all signature for output
            for (ImageSignature imageSignature : signatures)
            {
                if (imageSignature != null)
                {
                    System.out.print("Found Image signature at page "+imageSignature.getPageNumber()+" and Image Size '"+imageSignature.getSize()+"'.");
                    System.out.print("Location at "+imageSignature.getLeft()+"-"+imageSignature.getTop()+". Size is "+imageSignature.getWidth()+"x"+imageSignature.getHeight()+".");
                }
            }
            // -----------------------------------------------------------------------------------------------------------------------------
            // STEP 3. Update document Image Signature after searching it
            // -----------------------------------------------------------------------------------------------------------------------------
            List<BaseSignature> signaturesToUpdate = new ArrayList<BaseSignature>();
            for (ImageSignature imageSignature : signatures)
            {
                // change position
                imageSignature.setLeft(imageSignature.getLeft() + 100);
                imageSignature.setTop(imageSignature.getTop() + 100);
                // change size. Please note not all documents support changing signature size
                imageSignature.setWidth(200);
                imageSignature.setHeight(50);
                signaturesToUpdate.add(imageSignature);
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
            // STEP 4. Update document Image Signature on saved SignatureId
            // create list of Image Signature by known SignatureId
            // -----------------------------------------------------------------------------------------------------------------------------
            signaturesToUpdate.clear();
            for ( String item : signatureIds)
            {
                ImageSignature temp = new ImageSignature(item);
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
            // STEP 5. Delete document Image Signature by id
            // create list of Image Signature by known SignatureId
            signaturesToUpdate.clear();
            for (String item : signatureIds)
            {
                ImageSignature temp = new ImageSignature(item);
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