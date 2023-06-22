package com.groupdocs.signature.examples.advanced_usage.sign.signarchives;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.DocumentResultSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;


import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignTARArchiveDocuments
{
    /**
     * <p>
     * Sign TAR Documents with varios signature options
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignTARArchiveDocuments : Sign TAR archive document with various signature options\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_TAR;
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "SignTARArchiveDocuments//" + fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // create list of signature options
            BarcodeSignOptions bcOptions1 = new BarcodeSignOptions("12345678", BarcodeTypes.Code128);
            bcOptions1.setLeft(100);
            bcOptions1.setTop(100);
            QrCodeSignOptions qrOptions2 = new QrCodeSignOptions("12345678", QrCodeTypes.QR);
            qrOptions2.setLeft(400);
            qrOptions2.setTop(400);
            List<SignOptions> listOptions = new ArrayList<SignOptions>();
            listOptions.add(bcOptions1);
            listOptions.add(qrOptions2);
            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, listOptions);

            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" documents(s).\nFile saved at "+outputFilePath+".");

            System.out.print("\nList of successfully signed documents:");
            int number = 1;
            for (BaseSignature o : signResult.getSucceeded())
            {
                DocumentResultSignature document = (DocumentResultSignature)o;
                System.out.print("Document #"+number++ +": "+document.getFileName()+". Processed: "+document.getProcessingTime()+", mls");
            }
            if (signResult.getFailed().size() > 0)
            {
                System.out.print("\nList of failed documents:");
                number = 1;
                for (BaseSignature o : signResult.getFailed())
                {
                    DocumentResultSignature document = (DocumentResultSignature)o;
                    System.out.print("Document #"+number++ +": "+document.getFileName()+". Processed: "+document.getProcessingTime()+", mls");
                }
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
