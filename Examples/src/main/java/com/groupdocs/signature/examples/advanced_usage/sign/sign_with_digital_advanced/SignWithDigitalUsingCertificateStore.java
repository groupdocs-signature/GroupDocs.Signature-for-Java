package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.domain.signatures.StoreName;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.security.Key;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

public class SignWithDigitalUsingCertificateStore {
    /**
    * Sign document with digital signatures got from one of certificate stores
    */
    public static void run() {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithDigitalUsingCertificateStore : Sign document with digital signatures got from one of certificate stores\n");

        //The document to be signed.
        String filePath = Constants.SAMPLE_PDF;

        List<DigitalSignature> signatures = new ArrayList<DigitalSignature>();
        try {
            //Get digital signatures from common storage
            //If such storage does not exist at your system an exception will be thrown
            List<DigitalSignature> signaturesMy =
                    DigitalSignature.loadDigitalSignatures(StoreName.My);
            signatures.addAll(signaturesMy);
        } catch (Exception e) {
            System.out.print("Something wrong with your certificates storage");
        }

        int signatureNumber = 0;
        //sign document with all signatures
        for (DigitalSignature digitalSignature : signatures) {
            signatureNumber++;
            String outputFilePath =
                    new File(Constants.OutputPath,  "SignWithDigitalUsingCertificateStore\\digitallySigned_"+signatureNumber+".pdf").getPath();
            try{
                Signature signature = new Signature(filePath);
                {
                    //Only certificates with private key are good for digital signing
                    KeyStore store = digitalSignature.getCertificate();
                    //Receive a certificate indicating alias(name) for signing.
                    KeyStore.Entry entry =  store.getEntry("profmoriarty", null);
                    if(entry != null) {
                        try {
                            DigitalSignOptions options = new DigitalSignOptions();
                            //options.setPassword(password);
                            options.setSignature(digitalSignature);
                            // digital certificate details
                            options.setReason("Approved");
                            options.setContact("John Smith");
                            options.setLocation("New York");


                            SignResult signResult = signature.sign(outputFilePath, options);
                            System.out.print("\nSource document signed successfully with " + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath + ".");

                        } catch (Exception ex) {
                            System.out.print("\nCertificate #" + signatureNumber + " is not suitable for signing. Perhaps it does not have exportable private key.");
                        }
                    }
                }
            }catch (Exception e){
                System.out.print(e.getMessage());
            }
        }
    }
}
