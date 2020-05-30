package com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_standard_objects;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.extensions.serialization.Event;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;


public class SearchForQRCodeEventObject {
    /**
    * Search document for QR-Code signature with Event data object.
    * Please be aware that this example works only on licensed product due to limitation with QR-code processing
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchForQRCodeEventObject : Search document for QR-Code signature with Event data object.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_QRCODE_EVENT_OBJECT;

        // instantiating the signature object
        Signature signature = new Signature(filePath);
        {
            // search document
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, SignatureType.QrCode);
            try
            {
                for (QrCodeSignature qrSignature : signatures)
                {
                    Event evnt = qrSignature.getData(Event.class);
                    if (evnt != null)
                    {
                        System.out.print("Found Event signature: "+evnt.getTitle()+"/"+evnt.getDescription()+" at "+evnt.getLocation()+". Started @ "+evnt.getStartDate());
                    }
                    else
                    {
                        System.out.print("Event object was not found. QRCode "+qrSignature.getEncodeType().getTypeName()+" with text "+qrSignature.getText());
                    }
                }
            }
            catch (Exception e)
            {
                System.out.print("\nThis example requires license to properly run. " +
                        "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                        "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                        "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
            }
        }
    }
}
