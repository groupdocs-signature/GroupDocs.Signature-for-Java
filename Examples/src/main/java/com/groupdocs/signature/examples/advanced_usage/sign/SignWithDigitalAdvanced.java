package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithDigitalAdvanced {

/**
 * Sign document with digital signature
 */
    public static void run()
    {
        // The path to the documents directory.            
        String filePath = Constants.SAMPLE_DOCX;
        String fileName = Paths.get(filePath).getFileName().toString();
        String imagePath = Constants.ImageHandwrite;
        String certificatePath = Constants.CertificatePfx;

        String outputFilePath = new File(Constants.OutputPath, "SignWithDigital-" + fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            DigitalSignOptions options = new DigitalSignOptions(certificatePath);

            // certifiate password
            options.setPassword("1234567890");
            // digital certificate details
            options.setReason("Sign");
            options.setContact("JohnSmith");
            options.setLocation("Office1");

            // image as digital certificate appearance on document pages
            options.setImageFilePath(imagePath);
            //
            options.setAllPages(true);
            options.setWidth(80);
            options.setHeight(60);
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);
            Padding padding = new Padding();
            padding.setBottom(10);
            padding.setRight(10);
            options.setMargin(padding);

            SignResult signResult = signature.sign(outputFilePath, options);
            // analyzing result
            System.out.print("List of newly created signatures:");
            int number = 1;
            for(BaseSignature temp : signResult.getSucceeded())
            {
                System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
                        ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }

    }
}
