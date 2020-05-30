package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_form_fields_advanced;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.formfield.RadioButtonFormFieldSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.FormFieldSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SignPdfWithFormFieldAdvancedRadio {
    /**
     *  Sign pdf document with radio-button signatures applying specific options
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignPdfWithFormFieldAdvancedRadio : Sign pdf document with form-field signature applying specific options\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignPdfWithFormFieldAdvancedRadio\\" + fileName).getPath();

        try
        {
            Signature signature = new Signature(filePath);
            {
                // instantiate radio-button form field signature
                List<String> radioOptions = Arrays.asList("One", "Two", "Three");

                RadioButtonFormFieldSignature radioSignature = new RadioButtonFormFieldSignature("radioData1", radioOptions, "Two");

                // instantiate options based on text form field signature
                FormFieldSignOptions options = new FormFieldSignOptions(radioSignature);
                options.setHorizontalAlignment(HorizontalAlignment.Right);
                options.setVerticalAlignment(VerticalAlignment.Top);
                options.setMargin(new Padding(0, 0, 0, 0));
                options.setHeight(100);
                options.setWidth(300);


                // sign document to file
                SignResult signResult = signature.sign(outputFilePath, options);
                System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath+".");

                System.out.print("\nList of newly created signatures:");
                int number = 1;
                for (BaseSignature temp : signResult.getSucceeded())
                {
                    System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
                }
            }
        }
        catch(Exception e)
        {
            System.out.print("\nThis example requires license to properly run. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}
