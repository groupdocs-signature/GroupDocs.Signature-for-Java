package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_signature_implementation;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.FormTextFieldType;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.SignOptions;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignWithTextFormField {
    /**
     * Sign document with text signature with updating existing Form Field document component
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithTextFormField : Sign document with text signature with updating existing Form Field document component\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithTextFormField\\" + fileName).getPath();

        Signature signature = new Signature(filePath);
        {
            TextSignOptions ffOptions1 = new TextSignOptions("Document is approved");
            {
                // set alternative signature implementation on document page
                ffOptions1.setSignatureImplementation(TextSignatureImplementation.FormField);
                ffOptions1.setFormTextFieldType(FormTextFieldType.PlainText);
            };

            TextSignOptions ffOptions2 = new TextSignOptions("John Smith");
            {
                // set alternative signature implementation on document page
                ffOptions2.setSignatureImplementation(TextSignatureImplementation.FormField);
                ffOptions2.setFormTextFieldType(FormTextFieldType.RichText);
                ffOptions2.setFormTextFieldTitle("UserSignatureFullName");
            };

            List<SignOptions> listOptions = new ArrayList<SignOptions>();
            listOptions.add(ffOptions1);
            listOptions.add(ffOptions2);
            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, listOptions);
            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath+".");
        }
    }
}