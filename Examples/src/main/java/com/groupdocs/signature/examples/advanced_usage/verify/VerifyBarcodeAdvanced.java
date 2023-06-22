package com.groupdocs.signature.examples.advanced_usage.verify;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.verify.BarcodeVerifyOptions;

public class VerifyBarcodeAdvanced {
    /**
     * Verify document with Bar-Code signature with applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        try {
            Signature signature = new Signature(filePath);
            BarcodeVerifyOptions options = new BarcodeVerifyOptions();
            options.setAllPages(true); // this value is set by default
            options.setText("12345");
            options.setMatchType(TextMatchType.Contains);

            // verify document signatures
            VerificationResult result = signature.verify(options);
            if (result.isValid())
            {
                System.out.print("\nDocument was verified successfully!");
                System.out.print("\nList of Succeded sigantures:");
                for(BaseSignature temp : result.getSucceeded())
                {
                    System.out.print(" -#"+temp.getSignatureId()+"-"+temp.getSignatureType()+" at: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
                }
            }
            else
            {
                System.out.print("\nDocument failed verification process.");
            }
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}