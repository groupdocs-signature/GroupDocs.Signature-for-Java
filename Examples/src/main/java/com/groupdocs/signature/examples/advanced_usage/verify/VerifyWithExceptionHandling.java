package com.groupdocs.signature.examples.advanced_usage.verify;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.verify.DigitalVerifyOptions;

import java.io.File;

public class VerifyWithExceptionHandling {
    /**
     * Verify document with digital signature applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;
        try {
            Signature signature = new Signature(filePath);
            // create QRCode option with predefined QRCode text
            DigitalVerifyOptions options = new DigitalVerifyOptions();
            options.setCertificateFilePath(Constants.CertificatePfx);
            // skip password specification
            //options.setPassword("1234567890");


            // sign document to file
            VerificationResult result = signature.verify(options);
        }catch(GroupDocsSignatureException ex){
            System.out.print("GroupDocs Signature Exception: " + ex.getMessage());
        }
        catch (Exception ex)
        {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }

}