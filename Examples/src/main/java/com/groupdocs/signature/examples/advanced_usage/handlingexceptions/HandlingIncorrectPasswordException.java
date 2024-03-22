package com.groupdocs.signature.examples.advanced_usage.handlingexceptions;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.exception.IncorrectPasswordException;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class HandlingIncorrectPasswordException {
    /**
     * <p>
     * Sign document with qr-code signature
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # HandlingIncorrectPasswordException : Sign document with qr-code signature.\n");

        // The path to the documents directory
        // This file is secured with password
        String filePath = Constants.SAMPLE_PDF_SIGNED_PWD;
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "\\HandlingExceptions" + fileName).getPath();
        // initialize LoadOptions with incorrect Password
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1");
        final Signature signature = new Signature(filePath, loadOptions);
        try /*JAVA: was using*/
        {
            try
            {
                QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
                options.setEncodeType(QrCodeTypes.QR);
                options.setLeft(100);
                options.setTop(100);
                // try to sign document to file, we expect for PasswordRequiredException
                signature.sign(outputFilePath, options);
                System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
            }
            catch (IncorrectPasswordException ex)
            {
                System.out.print("HandlingIncorrectPasswordException: " + ex.getMessage());
            }
            catch (GroupDocsSignatureException ex)
            {
                System.out.print("Common GroupDocsSignatureException: " + ex.getMessage());
            }
            catch (java.lang.RuntimeException ex)
            {
                System.out.print("Common Exception happens only at user code level: " + ex.getMessage());
            }
            finally
            {

            }
        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}