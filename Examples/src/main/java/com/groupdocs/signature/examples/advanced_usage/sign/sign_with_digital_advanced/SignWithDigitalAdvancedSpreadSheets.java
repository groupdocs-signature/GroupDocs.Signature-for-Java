package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

public class SignWithDigitalAdvancedSpreadSheets
{
    /**
     * <p>
     * Sign SpreadSheets by using digital signature as a certificate container
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithDigitalAdvancedSpreadSheets : Sign SpreadSheets by using digital signature as a certificate container\n");

        // The path to the documents directory.            
        String filePath = Constants.SAMPLE_SPREADSHEET;
        String certificatePath = Constants.CertificatePfx;
        String password = "1234567890";
        String outputFilePath = new File(Constants.OutputPath, "SignWithDigitalAdvancedSpreadSheets\\digitalySigned.xlsx").getPath();

        //Certify pdf document with digital signature
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            DigitalSignature digitalSignature = new DigitalSignature();
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream(certificatePath), password.toCharArray());
            digitalSignature.setCertificate(ks);

            //Create digital signing options
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);
            options.setPassword(password);
            options.setSignature(digitalSignature);
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);

            SignResult signResult = signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath+".");

            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature temp : signResult.getSucceeded())
            {
                System.out.print("Signature #"+number+++": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
