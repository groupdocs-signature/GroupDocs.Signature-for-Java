package com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_standard_objects;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.extensions.serialization.SMS;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;

import java.util.List;

public class SearchForQRCodeSMSObject {
    /**
     * <p>
     * Search document for QR-Code signature with SMS data object.
     * Please be aware that this example works only on licensed product due to limitation with QR-code processing
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchForQRCodeSMSObject : Search document for QR-Code signature with SMS data object.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_QRCODE_SMS_OBJECT;

        // instantiating the signature object
        Signature signature = new Signature(filePath);
        // search document
        List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, SignatureType.QrCode);
        try
        {
            for (QrCodeSignature qrSignature : signatures)
            {
                SMS sms = qrSignature.getData(SMS.class);
                if (sms != null)
                {
                    System.out.print("Found SMS signature for number: "+sms.getNumber()+" with Message: "+sms.getMessage());
                }
                else
                {
                    System.out.print("SMS object was not found. QRCode "+qrSignature.getEncodeType().getTypeName()+" with text "+qrSignature.getText());
                }
            }
        }
        catch(RuntimeException e)
        {
            System.out.print("\nThis example requires license to properly run. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}
