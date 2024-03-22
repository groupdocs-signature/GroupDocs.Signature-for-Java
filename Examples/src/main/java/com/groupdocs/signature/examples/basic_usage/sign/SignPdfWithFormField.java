package com.groupdocs.signature.examples.basic_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.formfield.FormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.TextFormFieldSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.FormFieldSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignPdfWithFormField {
    /**
     * Sign pdf document with form-field signature
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # SignPdfWithFormField : Sign pdf document with form-field signature.");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignPdfWithFormField//"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            // instantiate text form field signature
            FormFieldSignature textSignature = new TextFormFieldSignature("FieldText", "Value1");
            // instantiate options based on text form field signature
            FormFieldSignOptions options = new FormFieldSignOptions(textSignature);
            options.setHorizontalAlignment(HorizontalAlignment.Left);
            options.setVerticalAlignment(VerticalAlignment.Top);
            options.setMargin(new Padding(10, 20, 0, 0));
            options.setHeight(10);
            options.setWidth(100);

            // sign document to file
            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}