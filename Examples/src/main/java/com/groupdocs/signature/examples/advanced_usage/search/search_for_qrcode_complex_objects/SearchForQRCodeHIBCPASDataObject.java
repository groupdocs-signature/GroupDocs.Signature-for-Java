package com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_complex_objects;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.extensions.hibcpas.HIBCPASData;
import com.groupdocs.signature.domain.extensions.hibcpas.HIBCPASRecord;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;


import java.util.List;

public class SearchForQRCodeHIBCPASDataObject {
    /**
    * Search document for QR-Code signature with HIBC PAS data object.
    * Please be aware that this example works only on licensed product due to limitation with QR-code processing
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchForQRCodeHIBCPASDataObject : Search document for QR-Code signature with HIBC PAS data object.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_QRCODE_HIBCPASDATA_OBJECT;

        // instantiating the signature object
        Signature signature = new Signature(filePath);
        {
            // search document
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class,SignatureType.QrCode);
            try
            {
                QrCodeSignature qrSignature = signatures.get(0);
                if (qrSignature != null)
                {
                    System.out.print("Found QRCode signature: "+qrSignature.getEncodeType().getTypeName()+" with text "+ qrSignature.getText());
                    HIBCPASData data = qrSignature.getData(HIBCPASData.class);
                    if (data != null)
                    {
                        System.out.print("Found QR-Code HIBC PAS data : "+data.getDataLocation());
                        for(HIBCPASRecord record : data.getRecords())
                        {
                            System.out.print("\t #: "+record.getDataType()+" : "+record.getData());
                        }
                    }
                    else
                    {
                        System.out.print("HIBCPASData object was not found. QRCode "+qrSignature.getEncodeType().getTypeName()+" with text "+qrSignature.getText());
                    }
                }
            }
            catch(Exception e)
            {
                System.out.print("\nThis example requires license to properly run. " +
                        "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                        "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                        "\nLearn how to request temporary license at https://purchase.groupdocs.com/temporary-license");
            }
        }
    }
}
