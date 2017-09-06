package com.groupdocs.signature.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.enums.CellsSaveFileFormat;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.SignOptions;
import com.groupdocs.signature.options.SignatureOptionsCollection;
import com.groupdocs.signature.options.digitalsignature.PdfSignDigitalOptions;
import com.groupdocs.signature.options.imagesignature.PdfSignImageOptions;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.saveoptions.CellsSaveOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;
import com.groupdocs.signature.options.textsignature.CellsSignTextOptions;
import com.groupdocs.signature.options.textsignature.PdfSignTextOptions;

public class CommonOperations {

	public static void getSourceDocFromAbsolutePath(String fileName) throws Exception{
		//ExStarat:getSourceDocFromAbsolutePath
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the signature handler without Signature Config object
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		PdfSignImageOptions signOptions = new PdfSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document with image
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:getSourceDocFromAbsolutePath
	}
	public static void getSourceDocFromRelativePath(String fileName) throws Exception{
		//ExStart:getSourceDocFromRelativePath
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		SignOptions signOptions = new PdfSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:getSourceDocFromRelativePath
	}
	public static void getSourceDocFromUri() throws Exception{
		//ExStart:getSourceDocFromUri
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the signature handler without Signature Config object
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		SignOptions signOptions = new PdfSignImageOptions("http://groupdocs.com/images/banner/carousel2/conversion.png");
		// save options
		SaveOptions saveOptions = new SaveOptions(OutputType.String, "co_testGetSourceDocumentFromUri.pdf");
		// sign document with image
		String signedPath = handler.<String>sign("https://www.adobe.com/content/dam/Adobe/en/feature-details/acrobatpro/pdfs/combine-multiple-documents-into-one-pdf-file.pdf", signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:getSourceDocFromUri
	}
	public static void getSourceDocFromStream(String fileName) throws Throwable{
		//ExStart:getSourceDocFromStream
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the signature handler without Signature Config object
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		SignOptions signOptions = new PdfSignImageOptions("http://groupdocs.com/images/banner/carousel2/conversion.png");
		// save options
		SaveOptions saveOptions = new SaveOptions(OutputType.String, "signed_output.pdf");
		InputStream fileStream = new FileInputStream(CommonUtilities.getStoragePath(fileName));
		// sign document with image
		String signedPath = handler.<String>sign(fileStream, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:getSourceDocFromStream
	}
	public static void passwordProtectedDoc(String fileName) throws Exception{
		//ExStart:passwordProtectedDoc
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		SignOptions signOptions = new CellsSignTextOptions("John Smith");
		// specify load options
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("1234567890");
		// specify save options
		SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.xls");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, loadOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:passwordProtectedDoc
	}
	public static void signDocWithDifferentFileFormat(String fileName) throws Exception{
		//ExStart:signDocWithDifferentFileFormat
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		SignOptions signOptions = new CellsSignTextOptions("John Smith");
		// specify load options
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("1234567890");
		// specify save options
		CellsSaveOptions saveOptions = new CellsSaveOptions(OutputType.String);
		saveOptions.setOutputFileName("signed_output.ods");
		saveOptions.setFileFormat(CellsSaveFileFormat.ODS);
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, loadOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signDocWithDifferentFileFormat
	}
	public static void signDocWithDifferentFileName(String fileName) throws Exception{
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		SignOptions signOptions = new CellsSignTextOptions("John Smith");
		// specify load options
		LoadOptions loadOptions = new LoadOptions();
		// specify save options
		CellsSaveOptions saveOptions = new CellsSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.xls");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, loadOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
	}
	public static void setupDigitalSigantureOptions(String fileName) throws Throwable, Exception{
		//ExStart:setupDigitalSigantureOptions
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// define Signature Options Collection
		SignatureOptionsCollection collection = new SignatureOptionsCollection();
		// specify text option
		PdfSignTextOptions signTextOptions = new PdfSignTextOptions("Mr. John", 100, 100, 100, 100);
		// add to collection
		collection.add(signTextOptions);
		// specify image options
		PdfSignImageOptions signImageOptions = new PdfSignImageOptions("signature.jpg");
		signImageOptions.setLeft(200);
		signImageOptions.setTop(200);
		signImageOptions.setWidth(100);
		signImageOptions.setHeight(100);
		// add to collection
		collection.add(signImageOptions);
		// specify digital options
		PdfSignDigitalOptions signDigitalOptions = new PdfSignDigitalOptions(new FileInputStream(CommonUtilities.getCertificatePath("acer.pfx")));
		signDigitalOptions.setPassword("1234567890");
		signDigitalOptions.setVerticalAlignment(VerticalAlignment.Bottom);
		signDigitalOptions.setHorizontalAlignment(HorizontalAlignment.Center);
		// add to collection
		collection.add(signDigitalOptions);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("co_testSetupMultipleSignatureOptions.pdf");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), collection, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setupDigitalSigantureOptions
	}
	public static void imposePdfDigSignWithTextSignAboveUnderSignatureArea(String fileName) throws Throwable, Throwable{
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// define Signature Options Collection
		SignatureOptionsCollection collection = new SignatureOptionsCollection();
		// specify text option
		PdfSignTextOptions signTextOptionsFirst = new PdfSignTextOptions("Mr. John First");
		signTextOptionsFirst.setLeft(0);
		signTextOptionsFirst.setTop(0);
		// add to collection
		collection.add(signTextOptionsFirst);
		// specify digital options
		PdfSignDigitalOptions signDigitalOptions = new PdfSignDigitalOptions(new FileInputStream(CommonUtilities.getCertificatePath("acer.pfx")));
		signDigitalOptions.setPassword("1234567890");
		signDigitalOptions.setReason("Any reason");
		signDigitalOptions.setLocation("Some location");
		signDigitalOptions.setLeft(0);
		signDigitalOptions.setTop(35);
		signDigitalOptions.setWidth(350);
		// add to collection
		collection.add(signDigitalOptions);
		// specify text option
		PdfSignTextOptions signTextOptionsSecond = new PdfSignTextOptions("Mr. John Second");
		signTextOptionsSecond.setLeft(0);
		signTextOptionsSecond.setTop(100);
		// add to collection
		collection.add(signTextOptionsSecond);
		final SaveOptions saveOptions = new SaveOptions();
		// sign document
		String signedPath = handler.<String>sign(fileName, collection, saveOptions);
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		System.out.println("Signed file path is: " + signedPath);
	}
}
