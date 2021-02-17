package com.groupdocs.signature.examples.advanced_usage.sign;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignWithResultAnalysis {
    /**
     * <p>
     * Sign document with qr-code signature
     * </p>
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCode\\"+ fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // create QRCode option with predefined QRCode text
            QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
            options.setEncodeType(QrCodeTypes.QR);
            options.setHorizontalAlignment(HorizontalAlignment.Right);
            options.setVerticalAlignment(VerticalAlignment.Bottom);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, options);
            if (signResult.getFailed().size() == 0)
            {
                System.out.print("\nAll signatures were successfully created!");
            }
            else
            {
                System.out.print("Successfully created signatures : "+signResult.getSucceeded().size());
                System.out.print("Failed signatures : "+signResult.getFailed().size());
            }
            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature temp : signResult.getSucceeded())
            {
                System.out.print("Signature #"+ +number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
        System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }
}