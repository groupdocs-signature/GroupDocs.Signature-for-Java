package com.groupdocs.signature.examples;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SearchResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.formfield.FormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.PdfCheckboxFormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.PdfDigitalFormFieldSignature;
import com.groupdocs.signature.domain.signatures.formfield.PdfTextFormFieldSignature;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.internal.c.a.ms.lang.Operators;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.SignatureOptionsCollection;
import com.groupdocs.signature.options.formfieldsearch.PdfSearchFormFieldOptions;
import com.groupdocs.signature.options.formfieldsignature.PdfFormFieldSignOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;

public class FormFieldSignatures {
	
	public static void signPDFWithFormFieldSignOptions(String fileName) throws Throwable{
		//ExStart:signPDFWithFormFieldSignOptions
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		//collection of signatures initialization
		SignatureOptionsCollection collection = new SignatureOptionsCollection();
		   
	    // 1. setup text form field signature options
	    // instantiate text form field signature
		FormFieldSignature textSignature = new PdfTextFormFieldSignature("FieldText","Value1");
	    // instantiate options based on text form field signature
		PdfFormFieldSignOptions textOptions = new PdfFormFieldSignOptions(textSignature);
		textOptions.setHorizontalAlignment(HorizontalAlignment.Left);
		textOptions.setVerticalAlignment(VerticalAlignment.Top);
		textOptions.setMargin(new Padding(10, 20, 0, 0));
		textOptions.setHeight(10);
		textOptions.setWidth(100);
		collection.add(textOptions);
		   
	    // 2. setup check-box form field signature options
	    // instantiate check-box form field signature
		FormFieldSignature checkboxSignature = new PdfCheckboxFormFieldSignature("FieldCheckbox", true);
	    // instantiate options based on check-box form field signature
		PdfFormFieldSignOptions checkboxOptions = new PdfFormFieldSignOptions(checkboxSignature);
		checkboxOptions.setHorizontalAlignment(HorizontalAlignment.Left);
		checkboxOptions.setVerticalAlignment(VerticalAlignment.Top);
		checkboxOptions.setMargin(new Padding(120, 20, 0, 0));
		checkboxOptions.setHeight(10);
		checkboxOptions.setWidth(10);
		collection.add(checkboxOptions);
		   
	    // 3. setup digital signature form field options
	    // instantiate digital signature form field
		FormFieldSignature digitalSignature = new PdfDigitalFormFieldSignature("FieldDigital");
		PagesSetup tmp1 = new  PagesSetup();
		tmp1.setLastPage(true);
		    // instantiate options based on digital signature form field
		PdfFormFieldSignOptions digitalOptions = new PdfFormFieldSignOptions(digitalSignature);
		digitalOptions.setPagesSetup(tmp1);
		digitalOptions.setHorizontalAlignment(HorizontalAlignment.Right);
		digitalOptions.setVerticalAlignment(VerticalAlignment.Bottom);
		digitalOptions.setMargin(new Padding(0, 0, 10, 10));
		digitalOptions.setHeight(20);
		digitalOptions.setWidth(100);
		collection.add(digitalOptions);
		 SaveOptions tmp0 = new  SaveOptions();
		tmp0.setOutputType(OutputType.String);
		tmp0.setOutputFileName("Pdf_FormFields");
		    // sign document
		String signedPath = handler.<String>sign(fileName, collection, tmp0);
		System.out.print("Signed file path is: "+  signedPath);
		//ExEnd:signPDFWithFormFieldSignOptions
	}
	
	public static void searchFormFieldSignatureInPDF(String fileName) throws Throwable{
        //ExStart:searchFormFieldSignatureInPDF

		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup search options
        PdfSearchFormFieldOptions searchOptions = new PdfSearchFormFieldOptions();
        searchOptions.setSearchAllPages(true);
        searchOptions.setName("Field");
        searchOptions.setValue("Value1");
        // search document
        SearchResult result = handler.search(fileName, searchOptions);
        // output signatures
        for (BaseSignature signature : result.getSignatures())
        {
        	FormFieldSignature formFieldSignature = Operators.as(signature, FormFieldSignature.class);
            if (formFieldSignature != null)
            {
                System.out.print("Pdf FormField: "+formFieldSignature.getName()+":"+formFieldSignature.getValue()+"  = "+formFieldSignature.toString() );
            }
        }
        //ExEnd:searchFormFieldSignatureInPDF
    }
}
