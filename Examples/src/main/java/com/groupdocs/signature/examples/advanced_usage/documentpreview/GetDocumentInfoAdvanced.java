package com.groupdocs.signature.examples.advanced_usage.documentpreview;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.PageInfo;
import com.groupdocs.signature.domain.documentpreview.IDocumentInfo;
import com.groupdocs.signature.domain.signatures.*;
import com.groupdocs.signature.domain.signatures.formfield.FormFieldSignature;
import com.groupdocs.signature.examples.Constants;

public class GetDocumentInfoAdvanced {
    /**
     * Get document form fields and signatures information
     */

    public static void run() throws Exception {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # GetDocumentInfoAdvanced : Get document form fields and signatures information\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            IDocumentInfo documentInfo = signature.getDocumentInfo();
            System.out.print("Document properties "+ filePath);
            System.out.print(" - format : "+documentInfo.getFileType().getFileFormat());
            System.out.print(" - extension : "+documentInfo.getFileType().getExtension());
            System.out.print(" - size : "+documentInfo.getSize());
            System.out.print(" - page count : "+documentInfo.getPageCount());
            for (PageInfo pageInfo : documentInfo.getPages())
            {
                System.out.print(" - page-"+pageInfo.getPageNumber()+" Width "+pageInfo.getWidth()+", Height "+pageInfo.getHeight());
            }
            // display document Form Field signatures information
            System.out.print("Document Form Fields information: count = "+documentInfo.getFormFields().size());
            for (FormFieldSignature formField : documentInfo.getFormFields())
            {
                System.out.print(" - type #"+formField.getType()+": Name: "+formField.getName()+" Value: "+formField.getValue());
            }
            // display document Text signatures information
            System.out.print("Document Text signatures : "+documentInfo.getTextSignatures().size());
            for (TextSignature textSignature : documentInfo.getTextSignatures())
            {
                System.out.print(" - #"+textSignature.getSignatureId()+": Text: "+textSignature.getText()+" Location: "+textSignature.getLeft()+"x"+textSignature.getTop()+". Size: "+textSignature.getWidth()+"x"+textSignature.getHeight());
            }
            // display document Image signatures information
            System.out.print("Document Image signatures : "+documentInfo.getImageSignatures().size());
            for (ImageSignature imageSignature : documentInfo.getImageSignatures())
            {
                System.out.print(" - #"+imageSignature.getSignatureId()+": Size: "+imageSignature.getSize()+" bytes, Format: "+imageSignature.getFormat());
            }
            // display document Digital signatures information
            System.out.print("Document Digital signatures : "+documentInfo.getDigitalSignatures().size());
            for (DigitalSignature digitalSignature : documentInfo.getDigitalSignatures())
            {
                System.out.print(" - #"+digitalSignature.getSignatureId());
            }
            // display document Barcode signatures information
            System.out.print("Document Barcode signatures : "+documentInfo.getBarcodeSignatures().size());
            for (BarcodeSignature barcodeSignature : documentInfo.getBarcodeSignatures())
            {
                System.out.print(" - #"+barcodeSignature.getSignatureId()+": Type: "+barcodeSignature.getEncodeType().getTypeName()+". Text: "+barcodeSignature.getText());
            }
            // display document QrCode signatures information
            System.out.print("Document QR-Code signatures : "+documentInfo.getQrCodeSignatures().size());
            for (QrCodeSignature qrCodeSignature : documentInfo.getQrCodeSignatures())
            {
                System.out.print(" - #"+qrCodeSignature.getSignatureId()+": Type: "+qrCodeSignature.getEncodeType().getTypeName()+". Text: "+qrCodeSignature.getText());
            }
            // display document Form Fields signatures information
            System.out.print("Document Form Fields signatures : "+documentInfo.getFormFieldSignatures().size());
            for (FormFieldSignature formFieldSignature : documentInfo.getFormFields())
            {
                System.out.print(" - #"+formFieldSignature.getSignatureId()+" Type "+formFieldSignature.getType()+": Name: "+formFieldSignature.getName()+" Value: "+formFieldSignature.getValue());
            }
        }
        finally {  }

    }
}