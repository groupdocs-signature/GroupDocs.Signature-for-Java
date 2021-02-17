package com.groupdocs.signature.examples.advanced_usage.delete;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.DigitalSignature;
import com.groupdocs.signature.examples.Constants;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DeleteDigitalById
{
    /**
     * <p>
     * Delete Digital signature from the PDF Document by known SignatureId
     * SignatureId could be obtained by Search or Sign method
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # DeleteDigitalById : Delete Digital signature in the PDF Document by known SignatureId\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED_DIGITAL;
        // copy source file since Delete method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "DeleteDigitalById\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        IOUtils.copy(new FileInputStream(filePath), new FileOutputStream(outputFilePath, true));
        // initialize Signature instance
        final Signature signature = new Signature(outputFilePath);
        try /*JAVA: was using*/
        {
            String[] signatureIdList = new String[]
                    {
                            "a01e1940-997a-444b-89af-9309a2d559a5"
                    };
            DigitalSignature dsSignature = new DigitalSignature("a01e1940-997a-444b-89af-9309a2d559a5");
            List<BaseSignature> signatures = new ArrayList<BaseSignature>();
            for (String item : signatureIdList)
            {
                signatures.add(new DigitalSignature(item));
            }
            // delete required signatures
            boolean result = signature.delete(new ByteArrayOutputStream(),dsSignature);
            if (result)
            {
                System.out.print("All signatures were successfully deleted!");
            }
            else
            {
                System.out.print("Not digital signatures : "+dsSignature.getSignatureId());
            }
        }
        catch (Exception e){ System.out.print(e.getMessage()); }
    }
}

