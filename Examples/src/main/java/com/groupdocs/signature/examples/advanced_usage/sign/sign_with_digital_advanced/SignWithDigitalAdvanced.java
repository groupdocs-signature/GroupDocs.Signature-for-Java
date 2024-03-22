package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.extensions.signoptions.SpreadsheetPosition;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class SignWithDigitalAdvanced
{
    /**
     * <p>
     * Sign document with digital signature applying specific options
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithDigitalAdvanced : Sign document with digital signature applying specific options\n");

        // The path to the documents directory.            
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();
        String imagePath = Constants.ImageStamp;
        String certificatePath = Constants.CertificatePfx;

        String outputFilePath = new File(Constants.OutputPath, "SignWithDigitalAdvanced\\"+ fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);

            // optional: setup image file path
            options.setImageFilePath(imagePath);
            options.setLeft(100);
            options.setTop(100);
            options.setPageNumber(1);
            options.setPassword("1234567890");
            options.getExtensions().add(new SpreadsheetPosition(10,10));
            // sign document to file
            //signature.sign("E://signed.pdf", options);
            System.out.print(" Done ");

            SignResult signResult = signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath);

            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature temp : signResult.getSucceeded())
            {
                System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}
