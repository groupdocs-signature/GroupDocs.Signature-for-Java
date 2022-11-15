package com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_standard_objects;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.extensions.serialization.WiFi;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import java.util.List;

/**
 * <p>
 * Following example shows searching document for QR-Code signature with applying specific options.
 * Please be aware that this example works only on licensed product due to limitation with QR-code processing
 * </p>
 */
public class SearchForQRCodeWiFiObject
{
    /**
     * <p>
     * Search document for QR-Code signature with WiFi data object.
     * Please be aware that this example works only on licensed product due to limitation with QR-code processing
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchForQRCodeWiFiObject : Search document for QR-Code signature with WiFi data object.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_QRCODE_WIFI_OBJECT;

        // instantiating the signature object
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // search document
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, SignatureType.QrCode);
            //foreach to while statements conversion
            for (QrCodeSignature qrSignature : signatures)
            {
                WiFi wifi = qrSignature.getData(WiFi.class);
                if (wifi != null)
                {
                    System.out.print("Found WiFi signature: SSID: "+wifi.getSSID()+" Encryption "+wifi.getEncryption()+", Password: "+ wifi.getPassword());
                }
                else
                {
                  System.out.print("WiFi object was not found. QRCode {qrSignature.EncodeType.TypeName} with text {qrSignature.Text}");
                }
            }


        }
        catch(RuntimeException e)
        {
            System.out.print("\nThis example requires license to properly run. " +
                          "\nVisit the GroupDocs site to obtain either a temporary or permanent license. "+
                          "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. "+
                          "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}
