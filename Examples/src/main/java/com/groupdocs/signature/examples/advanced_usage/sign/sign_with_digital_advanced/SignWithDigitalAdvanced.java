package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
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
             Padding tmp0 = new  Padding();
            tmp0.setBottom(10);
            tmp0.setRight(10);
             Border tmp1 = new  Border();
            tmp1.setVisible(true);
            tmp1.setColor(Color.red);
            tmp1.setDashStyle(DashStyle.DashDot);
            tmp1.setWeight(2);
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);
            options.setPassword("1234567890");
            options.setReason("Approved");
            options.setContact("John Smith");
            options.setLocation("New York");
            options.setImageFilePath(imagePath);
            options.setAllPages(true);
            options.setWidth(160);
            options.setHeight(80);
            options.setVerticalAlignment(VerticalAlignment.Center);
            options.setHorizontalAlignment(HorizontalAlignment.Left);
            options.setMargin(tmp0);
            options.setBorder(tmp1);

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
