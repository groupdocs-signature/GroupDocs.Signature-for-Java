package com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_complex_objects;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.extensions.hibclic.HIBCLICCombinedData;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;

/**
 * <p>
 * Following example shows searching document for QR-Code signature with specific complex data type HIBC LIC Combined data.
 * Please be aware that this example works only on licensed product due to limitation with QR-code processing
 * </p>
 */
public class SearchForQRCodeHIBCLICCombinedDataObject
{
    /**
     * <p>
     * Search document for QR-Code signature with HIBC LIC Combined data object.
     * Please be aware that this example works only on licensed product due to limitation with QR-code processing
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchForQRCodeHIBCLICCombinedObject : Search document for QR-Code signature with HIBCLICCombined data object.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_QRCODE_HIBCLICCOMBINED_OBJECT;

        // instantiating the signature object
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // search document
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, SignatureType.QrCode);
            try
            {

              for (QrCodeSignature qrSignature : signatures)
              {
                System.out.print("Found QRCode signature: "+qrSignature.getEncodeType().getTypeName()+" with text "+ qrSignature.getText());

                HIBCLICCombinedData combinedData = qrSignature.getData(HIBCLICCombinedData.class);
                if (combinedData != null)
                {
                    System.out.print("Found HIBC LIC Combined data QR-Code: {combinedData.PrimaryData.ProductOrCatalogNumber}");
                }
                else
                {
                    System.out.print("HIBCLICCombined object was not found. QRCode {qrSignature.EncodeType.TypeName} with text {qrSignature.Text}");
                }
              }

            }
            catch(RuntimeException e)
            {
                System.out.print("\nThis example requires license to properly run. " +
                              "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                              "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                              "\nLearn how to request temporary license at https://purchase.groupdocs.com/temporary-license");
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
