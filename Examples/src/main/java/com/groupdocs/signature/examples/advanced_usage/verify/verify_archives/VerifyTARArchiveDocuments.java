package com.groupdocs.signature.examples.advanced_usage.verify.verify_archives;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.verify.BarcodeVerifyOptions;
import com.groupdocs.signature.options.verify.QrCodeVerifyOptions;
import com.groupdocs.signature.options.verify.VerifyOptions;

import java.util.ArrayList;
import java.util.List;

public class VerifyTARArchiveDocuments
{
    /**
     * <p>
     * Verify documents at the TAR archive documents with various options
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # VerifyTARArchiveDocuments : Verify signatures at document packed to TAR archive\n");

        // The path to the archive with signed documents
        String filePath = Constants.SAMPLE_SIGNED_TAR;

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // create list of verification options
            BarcodeVerifyOptions barOptions = new BarcodeVerifyOptions();
            barOptions.setText("12345");
            barOptions.setMatchType(TextMatchType.Contains);
            QrCodeVerifyOptions qrOptions = new QrCodeVerifyOptions();
            qrOptions.setText("12345");
            qrOptions.setMatchType(TextMatchType.Contains);
            List<VerifyOptions> listOptions = new ArrayList<VerifyOptions>();
            listOptions.add(barOptions);
            listOptions.add(qrOptions);

            // Verify documents at the archive
            VerificationResult result = signature.verify(listOptions);

            // check the result                
            if (result.isValid())
            {
                System.out.print("\nDocument was verified successfully!");
                System.out.print("\nList of Succeeded signatures:");
                for (BaseSignature temp : result.getSucceeded())
                {
                    System.out.print(" -#"+temp.getSignatureId()+"-"+temp.getSignatureType()+" at: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
                }
            }
            else
            {
                System.out.print("\nDocument failed verification process.");
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
