package com.groupdocs.signature.examples.advanced_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.documentpreview.FileType;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;

import java.nio.file.Paths;
import java.util.List;

public class SearchForMultiLayerImagesAdvanced
{
    /**
     * <p>
     * Search multi-layer image document for signatures.
     * This example provided for formats like DICOM
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n-------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchForMultiLayerImagesAdvanced : Search multi-layer image document for signatures\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DICOM_SIGNED;
        String fileName = Paths.get(filePath).getFileName().toString();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // setup search options
            QrCodeSearchOptions searchOptions = new QrCodeSearchOptions();
            searchOptions.setReturnContent(true);
            searchOptions.setReturnContentType(FileType.PNG);
            // search multi-layer document
           List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, searchOptions);
            System.out.print("\nSource document ['"+fileName+"'] contains following QR-code signature(s).");
            // output signatures

           for (QrCodeSignature qrSignature : signatures)
           {
             // due to multi-layers each signature will contain the page number
             System.out.print("Found Qr-Code "+qrSignature.getText()+" signature at page "+qrSignature.getPageNumber()+" and id# "+qrSignature.getSignatureId()+".");
             System.out.print("Location at "+qrSignature.getLeft()+"-"+qrSignature.getTop()+". Size is "+qrSignature.getWidth()+"x"+qrSignature.getHeight()+".");
           }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
