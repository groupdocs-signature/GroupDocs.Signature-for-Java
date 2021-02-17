package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.PdfDigitalSignature;
import com.groupdocs.signature.domain.structs.TimeStamp;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;

public class SignWithDigitalAdvancedPdfTimestamp
{
    /**
     * <p>
     * Sign document with digital signature applying PDF document-specific options
     * Please be aware that this example works only on licensed product due to limitation with Pdf processing
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithDigitalAdvancedPdfTimestamp : Sign document with digital signature applying PDF TimeStamp\n");

        // The path to the documents directory.            
        String filePath = Constants.SAMPLE_PDF;
        String certificatePath = Constants.CertificatePfx;

        String outputFilePath = new File(Constants.OutputPath, "SignWithDigitalAdvancedPdf\\digitallySignedTimeStamp.pdf").getPath();

        //Sign pdf document with digital signature and time stamp
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            PdfDigitalSignature pdfDigitalSignature = new PdfDigitalSignature();
            pdfDigitalSignature.setContactInfo("Contact");
            pdfDigitalSignature.setLocation("Location");
            pdfDigitalSignature.setReason("Reason");
            pdfDigitalSignature.setTimeStamp(new TimeStamp("https://freetsa.org/tsr", "", ""));

            //Create digital signing options
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);
            options.setPassword("1234567890");
            options.setSignature(pdfDigitalSignature);
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);

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
