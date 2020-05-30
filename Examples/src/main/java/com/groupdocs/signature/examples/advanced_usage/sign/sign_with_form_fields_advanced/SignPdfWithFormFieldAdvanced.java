package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_form_fields_advanced;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.formfield.CheckboxFormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.DigitalFormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.FormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.TextFormFieldSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.FormFieldSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignPdfWithFormFieldAdvanced {
    /**
     * Sign pdf document with form-field signature applying specific options
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignPdfWithFormFieldAdvanced : Sign pdf document with form-field signature applying specific options\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignPdfWithFormFieldAdvanced\\" + fileName).getPath();

        Signature signature = new Signature(filePath);
        {
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
            FormFieldSignOptions optionsTextCHB = new FormFieldSignOptions(chbSignature);
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
            optionsTextDIG.setVerticalAlignment(VerticalAlignment.Center);
            optionsTextDIG.setMargin(new Padding(0, 50, 0, 0));
            optionsTextDIG.setHeight(50);
            optionsTextDIG.setWidth(50);


            listOptions.add(optionsTextFF);
            listOptions.add(optionsTextCHB);
            listOptions.add(optionsTextDIG);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, listOptions);
            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath+".");

            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature temp : signResult.getSucceeded())
            {
                System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
    }
}