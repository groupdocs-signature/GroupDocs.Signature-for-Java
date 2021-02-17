package com.groupdocs.signature.examples.advanced_usage.crud;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.*;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.signature.options.verify.QrCodeVerifyOptions;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessingQrCodeSignatureOverCRUD {
    /**
    * Following example shows how to process QR-Code Signature over all signature life-cycle.
    * First document is being signed with QR-Code Signature, then verified for it, searched for same, updating and finally deleting this signature.
    * Please be aware that this example works only on licensed product due to limitation with QR-code processing
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # ProcessingQrCodeSignatureOverCRUD : Process QR-Code Signature over all signature life-cycle\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "ProcessingQRCodeSignatureOverCRUD\\"+ fileName).getPath();
        List<String> signatureIds = new ArrayList<String>();
        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 1. Sign document with QR-Code Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        String bcText = "John Smith";
        Signature signature = new Signature(filePath);
        {
            QrCodeSignOptions signOptions = new QrCodeSignOptions(bcText, QrCodeTypes.QR);
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
        // STEP 2. Verify document for QrCode Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        Signature signature2 = new Signature(outputFilePath);
        {
            QrCodeVerifyOptions verifyOptions = new QrCodeVerifyOptions();

            // specify if all pages should be verified
            verifyOptions.setAllPages(false);
            verifyOptions.setPageNumber(1);
            // barcode type
            verifyOptions.setEncodeType(QrCodeTypes.QR);
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
            // STEP 3. Search document for QrCode Signature
            // -----------------------------------------------------------------------------------------------------------------------------
            QrCodeSearchOptions searchOptions = new QrCodeSearchOptions();

                // specify special pages to search on
            searchOptions.setAllPages(true);

            // search for QrCode signatures in document
            List<QrCodeSignature> signatures = signature2.search(QrCodeSignature.class,searchOptions);
            System.out.print("\nSource document contains following QrCode signature(s).");
            // enumerate all signature for output
            for (QrCodeSignature qrSignature : signatures)
            {
                if (qrSignature != null)
                {
                    System.out.print("Found QrCode signature at page "+qrSignature.getPageNumber()+" with type ["+qrSignature.getEncodeType().getTypeName()+"] and QrCode Text '"+qrSignature.getText()+"'.");
                    System.out.print("Location at "+qrSignature.getLeft()+"-"+qrSignature.getTop()+". Size is "+qrSignature.getWidth()+"x"+qrSignature.getHeight()+".");
                }
            }
            // -----------------------------------------------------------------------------------------------------------------------------
            // STEP 4. Update document QrCode Signature after searching it
            // -----------------------------------------------------------------------------------------------------------------------------
            List<BaseSignature> signaturesToUpdate = new ArrayList<BaseSignature>();
            for (QrCodeSignature qrSignature : signatures)
            {
                // change position
                qrSignature.setLeft(qrSignature.getLeft() + 100);
                qrSignature.setTop(qrSignature.getTop() + 100);
                // change size. Please note not all documents support changing signature size
                qrSignature.setWidth(200);
                qrSignature.setHeight(50);
                signaturesToUpdate.add(qrSignature);
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
            // STEP 5. Update document QrCode Signature on saved SignatureId
            // create list of QrCode Signature by known SignatureId
            // -----------------------------------------------------------------------------------------------------------------------------
            signaturesToUpdate.clear();
            for ( String item : signatureIds)
            {
                QrCodeSignature temp = new QrCodeSignature(item);
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
            // STEP 6. Delete document QrCode Signature by id
            // create list of QrCode Signature by known SignatureId
            signaturesToUpdate.clear();
            for (String item : signatureIds)
            {
                QrCodeSignature temp = new QrCodeSignature(item);
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