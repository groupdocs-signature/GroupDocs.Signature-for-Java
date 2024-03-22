package com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_complex_objects;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.extensions.hibclic.HIBCLICPrimaryData;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;


import java.util.List;

public class SearchForQRCodeHIBCLICPrimaryDataObject {
    /**
    * Search document for QR-Code signature with HIBC LIC Primary data object.
    * Please be aware that this example works only on licensed product due to limitation with QR-code processing
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchForQRCodeHIBCLICPrimaryDataObject : Search document for QR-Code signature with HIBC LIC Primary data object.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_QRCODE_HIBCLICPRIMARY_OBJECT;

        // instantiating the signature object
        Signature signature = new Signature(filePath);

        // search document
        List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, SignatureType.QrCode);
        try
        {
            QrCodeSignature qrSignature = signatures.get(0);
            if (qrSignature != null)
            {
                System.out.print("Found QRCode signature: "+qrSignature.getEncodeType().getTypeName()+" with text "+ qrSignature.getText());
                HIBCLICPrimaryData primaryData = qrSignature.getData(HIBCLICPrimaryData.class);
                if (primaryData != null)
                {
                    System.out.print("Found QR-Code HIBC LIC Primary data : "+primaryData.getProductOrCatalogNumber()+" / "+primaryData.getLabelerIdentificationCode());
                }
                else
                {
                    System.out.print("HIBCLICPrimaryData object was not found. QRCode "+qrSignature.getEncodeType().getTypeName()+" with text "+qrSignature.getText());
                }
            }
        } catch (Exception e)
        {
            System.out.print("\nThis example requires license to properly run. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLearn how to request temporary license at https://purchase.groupdocs.com/temporary-license");
        }

    }
}
