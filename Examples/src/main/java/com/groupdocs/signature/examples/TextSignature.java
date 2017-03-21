package com.groupdocs.signature.examples;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.CellsSignTextOptions;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.PDFVerifyTextOptions;
import com.groupdocs.signature.options.PdfSignTextOptions;
import com.groupdocs.signature.options.SaveOptions;
import com.groupdocs.signature.options.SlidesSignTextOptions;
import com.groupdocs.signature.options.WordsSignTextOptions;

public class TextSignature {

	public static void signCellDocWithText(String fileName) {
		//ExStart:signCellDocWithText
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
		// text position
		signOptions.setRowNumber(2);
		signOptions.setColumnNumber(2);
		//// text rectangle size
		signOptions.setHeight(100);
		signOptions.setWidth(100);
		//// if you need to sign all sheets set it to true
		signOptions.setSignAllPages(false);
		signOptions.setSheetNumber(1); // sign second sheet
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.xlsx");
		// sign document
		String signedPath = handler.<String> sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signCellDocWithText
	}

	public static void signPdfDocWithText(String fileName) {
		//ExStart:signPdfDocWithText
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);

		// setup image signature options
		PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
		signOptions.setLeft(15);
		signOptions.setTop(15);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
		String signedPath = handler.<String> sign(CommonUtilities.getStoragePath(fileName), signOptions,
				saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPdfDocWithText
	}

	public static void signSlideDocWithText(String fileName) {
		//ExStart:signSlideDocWithText
		//setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores
		// in config.ImagesPath folder
		SlidesSignTextOptions signOptions = new SlidesSignTextOptions("John Smith");
		signOptions.setLeft(10);
		signOptions.setTop(10);
		signOptions.setWidth(100);
		signOptions.setHeight(100);
		signOptions.setDocumentPageNumber(1);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pptx");
		// sign document
		String signedPath = handler.<String> sign(CommonUtilities.getStoragePath(fileName), signOptions,
				saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signSlideDocWithText
	}

	public static void signWordDocWithText(String fileName) {
		//ExStart:signWordDocWithText
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		WordsSignTextOptions signOptions = new WordsSignTextOptions("John Smith");
		signOptions.setLeft(10);
		signOptions.setTop(10);
		signOptions.setWidth(100);
		signOptions.setHeight(100);
		signOptions.setDocumentPageNumber(1);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.docx");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signWordDocWithText
	}
	
	public static void validatePdfTextSignatures(String fileName){
		//ExStart:validatePdfTextSignatures
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		String text = "John Smith, esquire";
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		PdfSignTextOptions signOptions = new PdfSignTextOptions(text);
		signOptions.setLeft(100);
		signOptions.setTop(100);
		signOptions.setDocumentPageNumber(1);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		// setup digital verification options
		PDFVerifyTextOptions verifyOptions = new PDFVerifyTextOptions(text);
		verifyOptions.setDocumentPageNumber(1);
		//verify document
		VerificationResult result = handler.verify(signedPath, verifyOptions);
		System.out.println("Verification result: " + result.isValid());
		//ExEnd:validatePdfTextSignatures
	}
}
