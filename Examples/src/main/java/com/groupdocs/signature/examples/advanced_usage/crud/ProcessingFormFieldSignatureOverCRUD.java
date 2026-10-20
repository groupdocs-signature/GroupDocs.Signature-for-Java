package com.groupdocs.signature.examples.advanced_usage.crud;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.formfield.FormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.TextFormFieldSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.FormFieldSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessingFormFieldSignatureOverCRUD
{
    /**
     * Following example shows how to process Form-field Signature over all signature life-cycle.
     * First document is being signed with Form-field Signature and then searched for it.
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # ProcessingFormFieldSignatureOverCRUD : Process Form-field Signature over all signature life-cycle\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "ProcessingFormFieldSignatureOverCRUD\\" + fileName).getPath();
        List<String> signatureIds = new ArrayList<String>();
        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 1. Sign document with Form-field Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // instantiate text form field signature
            FormFieldSignature textSignature = new TextFormFieldSignature("FieldText", "Value1");
            // instantiate options based on text form field signature
            FormFieldSignOptions signOptions = new FormFieldSignOptions(textSignature);
            signOptions.setTop(150);
            signOptions.setLeft(50);
            signOptions.setHeight(50);
            signOptions.setWidth(200);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, signOptions);
            System.out.print("\nDocument " + filePath + " was signed with following signatures:");
            for (BaseSignature temp : signResult.getSucceeded())
            {
                // collect newly created signature' Id
                signatureIds.add(temp.getSignatureId());
                System.out.print("\nSignature : " + temp.getSignatureType() + " Id:" + temp.getSignatureId());
            }
        }
        finally { if (signature != null) (signature).dispose(); }

        // -----------------------------------------------------------------------------------------------------------------------------
        // STEP 2. Search document for Form-field Signature
        // -----------------------------------------------------------------------------------------------------------------------------
        final Signature signedDocument = new Signature(outputFilePath);
        try /*JAVA: was using*/
        {
            // search for signatures in document
            List<FormFieldSignature> signatures = signedDocument.search(FormFieldSignature.class, SignatureType.FormField);
            System.out.print("\nSource document ['" + filePath + "'] contains following signatures.");
            for (FormFieldSignature formFieldSignature : signatures)
            {
                System.out.print("\nFormField signature found. Name : " + formFieldSignature.getName() + ". Value: " + formFieldSignature.getValue());
            }
        }
        finally { if (signedDocument != null) (signedDocument).dispose(); }
    }
}
