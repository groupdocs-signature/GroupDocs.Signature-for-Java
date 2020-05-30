package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.XAdESType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithXAdESTypes {
    /**
     * Sign document with XML Advanced Electronic Signatures (XAdES)
     */
   
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithXAdESTypes : Sign document with XML Advanced Electronic Signatures (XAdES)\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET;
        String fileName = Paths.get(filePath).getFileName().toString();
        String certificatePath = Constants.CertificatePfx;
        String outputFilePath = new File(Constants.OutputPath, "SignWithXAdESTypes\\" + fileName).getPath();

        Signature signature = new Signature(filePath);
        {
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);
            {
                // set XAdES type
                options.setXAdESType(XAdESType.XAdES);
                // certificate password
                options.setPassword("1234567890");
                // digital certificate details
                options.setReason("Sign");
                options.setContact("JohnSmith");
                options.setLocation("Office1");
            };



                SignResult signResult = signature.sign(outputFilePath, options);
                System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath);

                System.out.print("\nList of newly created signatures:");
                int number = 1;
                for (BaseSignature temp : signResult.getSucceeded())
                {
                    System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
                }



        }
    }
}