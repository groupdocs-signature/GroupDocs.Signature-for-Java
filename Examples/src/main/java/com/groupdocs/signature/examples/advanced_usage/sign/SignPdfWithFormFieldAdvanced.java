package com.groupdocs.signature.examples.advanced_usage.sign;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.formfield.CheckboxFormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.DigitalFormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.FormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.TextFormFieldSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.FormFieldSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignPdfWithFormFieldAdvanced {
    /** 
      * Sign pdf document with form-field signature
      */ 
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignPdfWithFormFieldAdvanced-"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);

            List<SignOptions> listOptions = new ArrayList<SignOptions>();

            // instantiate text form field signature
            FormFieldSignature textSignature = new TextFormFieldSignature("tbData1", "Value-1");
            // instantiate options based on text form field signature
            FormFieldSignOptions optionsTextFF = new FormFieldSignOptions(textSignature);
            optionsTextFF.setHorizontalAlignment(HorizontalAlignment.Left);
            optionsTextFF.setVerticalAlignment(VerticalAlignment.Top);
            optionsTextFF.setMargin(new Padding(10, 20, 0, 0));
            optionsTextFF.setHeight(10);
            optionsTextFF.setWidth(100);

            // instantiate text form field signature
            CheckboxFormFieldSignature chbSignature = new CheckboxFormFieldSignature("chbData1", true);
            // instantiate options based on text form field signature
            FormFieldSignOptions optionsTextCHB = new FormFieldSignOptions(chbSignature) ;
            optionsTextCHB.setHorizontalAlignment(HorizontalAlignment.Center);
            optionsTextCHB.setVerticalAlignment(VerticalAlignment.Top);
            optionsTextCHB.setMargin(new Padding(0, 0, 0, 0));
            optionsTextCHB.setHeight(10);
            optionsTextCHB.setWidth(100);

            // instantiate text form field signature
            DigitalFormFieldSignature digSignature = new DigitalFormFieldSignature("dgData1");
            // instantiate options based on text form field signature
            FormFieldSignOptions optionsTextDIG = new FormFieldSignOptions(digSignature);
            optionsTextDIG.setHorizontalAlignment(HorizontalAlignment.Right);
            optionsTextDIG.setVerticalAlignment(VerticalAlignment.Top);
            optionsTextDIG.setMargin(new Padding(0, 50, 0, 0));
            optionsTextDIG.setHeight(10);
            optionsTextDIG.setWidth(100);

            listOptions.add(optionsTextFF);
            listOptions.add(optionsTextCHB);
            listOptions.add(optionsTextDIG);

            // sign document to file
            signature.sign(outputFilePath, listOptions);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

}