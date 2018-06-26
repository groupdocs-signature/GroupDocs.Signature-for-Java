package com.groupdocs.signature.examples;

import java.awt.Color;
import java.awt.Rectangle;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.enums.CellsTextShapeType;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.ExtendedDashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.ImagesSaveFileFormat;
import com.groupdocs.signature.domain.enums.ImagesTextSignatureImplementation;
import com.groupdocs.signature.domain.enums.PdfSaveFileFormat;
import com.groupdocs.signature.domain.enums.PdfTextAnnotationBorderEffect;
import com.groupdocs.signature.domain.enums.PdfTextAnnotationBorderStyle;
import com.groupdocs.signature.domain.enums.PdfTextSignatureImplementation;
import com.groupdocs.signature.domain.enums.PdfTextStickerIcon;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.Brush;
import com.groupdocs.signature.domain.extensions.LinearGradientBrush;
import com.groupdocs.signature.domain.extensions.RadialGradientBrush;
import com.groupdocs.signature.domain.extensions.SolidBrush;
import com.groupdocs.signature.domain.extensions.TextShadow;
import com.groupdocs.signature.domain.extensions.TextureBrush;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.handler.events.ProcessCompleteEventArgs;
import com.groupdocs.signature.handler.events.ProcessCompleteEventHandler;
import com.groupdocs.signature.handler.events.ProcessProgressEventArgs;
import com.groupdocs.signature.handler.events.ProcessProgressEventHandler;
import com.groupdocs.signature.handler.events.ProcessStartEventArgs;
import com.groupdocs.signature.handler.events.ProcessStartEventHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.SignOptions;
import com.groupdocs.signature.options.SignatureOptionsCollection;
import com.groupdocs.signature.options.appearances.PdfTextAnnotationAppearance;
import com.groupdocs.signature.options.appearances.PdfTextStickerAppearance;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.saveoptions.PdfSaveOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.BitmapCompression;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.BmpSaveOptions;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.ImagesSaveOptions;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.JpegCompressionColorMode;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.JpegCompressionMode;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.JpegSaveOptions;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.TiffFormat;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.TiffSaveOptions;
import com.groupdocs.signature.options.textsignature.CellsSignTextOptions;
import com.groupdocs.signature.options.textsignature.ImagesSignTextOptions;
import com.groupdocs.signature.options.textsignature.PdfSignTextOptions;
import com.groupdocs.signature.options.textsignature.SlidesSignTextOptions;
import com.groupdocs.signature.options.textsignature.WordsSignTextOptions;
import com.groupdocs.signature.options.textverification.CellsVerifyTextOptions;
import com.groupdocs.signature.options.textverification.PDFVerifyTextOptions;
import com.groupdocs.signature.options.textverification.SlidesVerifyTextOptions;
import com.groupdocs.signature.options.textverification.WordsVerifyTextOptions;
import com.groupdocs.signature.options.verifyextensions.PdfTextAnnotationVerifyExtensions;
import com.groupdocs.signature.options.verifyextensions.PdfTextStickerVerifyExtensions;

public class TextSignature {

	public static void signCellDocWithText(String fileName) throws Exception {
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

	public static void signPdfDocWithText(String fileName) throws Exception {
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

	public static void textSignatureAsAnnotation(String fileName) throws Exception{
		//ExStart:textSignatureAsAnnotation
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
		signOptions.setLeft(100);
		signOptions.setTop(100);
		signOptions.setHeight(200);
		signOptions.setWidth(200);
		// setup colors settings
		signOptions.setBackgroundColor(Color.GRAY);
		// setup text color
		signOptions.setForeColor(Color.RED);
		// setup Font options
		signOptions.getFont().setBold(true);
		signOptions.getFont().setItalic(true);
		signOptions.getFont().setUnderline(true);
		signOptions.getFont().setFontFamily("Arial");
		signOptions.getFont().setFontSize(15);
		//type of implementation
		signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Annotation);
		// specify extended appearance options
		PdfTextAnnotationAppearance appearance = new PdfTextAnnotationAppearance();
		appearance.setBorderColor(Color.BLUE);
		appearance.setBorderEffect(PdfTextAnnotationBorderEffect.Cloudy);
		appearance.setBorderEffectIntensity(2);
		appearance.setBorderStyle(PdfTextAnnotationBorderStyle.Dashed);
		appearance.setHCornerRadius(10);
		appearance.setBorderWidth(5);
		appearance.setContents(signOptions.getText() + " content description");
		appearance.setSubject("Appearance Subject");
		appearance.setTitle("MrJohn Signature");
		signOptions.setAppearance(appearance);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions,
				saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:textSignatureAsAnnotation
	}
	
	public static void signSlideDocWithText(String fileName) throws Exception {
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

	public static void signWordDocWithText(String fileName) throws Exception {
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
	
	public static void validatePdfTextSignatures(String fileName) throws Exception{
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
	
	
	public static void verifyCellWithTextSignature(String fileName) throws Throwable{
		//ExStart:verifyCellWithTextSignature
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup digital verification options
        CellsVerifyTextOptions verifyOptions = new CellsVerifyTextOptions("John Smith");
        verifyOptions.getPagesSetup().setLastPage(true);
        //verify document
        VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptions);
        System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:verifyCellWithTextSignature
	}
	
	public static void verifyPDFWithTextSignatureAnnotation(String fileName) throws Throwable{
		//ExStart:verifyPDFWithTextSignatureAnnotation
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup digital verification options
		PDFVerifyTextOptions verifyOptions = new PDFVerifyTextOptions();
		// specify verification type
        verifyOptions.setSignatureImplementation(PdfTextSignatureImplementation.Annotation);
		// verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
		// verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
		//If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("John Smith_1");
		// create Verify Extensions
        PdfTextAnnotationVerifyExtensions extensions = new PdfTextAnnotationVerifyExtensions();
		//If verify option is set, then appropriate property of Annotation must be equals
        extensions.setContents("John Smith_1");
        extensions.setSubject("John Smith_2");
        extensions.setTitle("John Smith_3");
		// set extensions to verification options
        verifyOptions.setExtensions(extensions);
        //verify document
        VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptions);
        System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:verifyPDFWithTextSignatureAnnotation
	}
	
	public static void verifyPDFWithTextSignatureSticker(String fileName) throws Throwable{
		//ExStart:verifyPDFWithTextSignatureSticker
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup digital verification options
		PDFVerifyTextOptions verifyOptions = new PDFVerifyTextOptions();
		// specify verification type
        verifyOptions.setSignatureImplementation(PdfTextSignatureImplementation.Sticker);
        // verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
        // verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
        //If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("Contents");
        // create Verify Extensions
        PdfTextStickerVerifyExtensions extensions = new PdfTextStickerVerifyExtensions();
        //If verify option is set, then appropriate property of Sticker must be equals
        extensions.setContents("Contents");
        extensions.setSubject("Subject");
        extensions.setTitle("Title");
        extensions.setIcon(PdfTextStickerIcon.Cross);
		// set extensions to verification options
        verifyOptions.setExtensions(extensions);
        //verify document
        VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptions);
        System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:verifyPDFWithTextSignatureSticker
	}
	
	public static void verifySlidesWithTextSignature(String fileName) throws Throwable{
		//ExStart:verifySlidesWithTextSignature
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup digital verification options
        SlidesVerifyTextOptions verifyOptions = new SlidesVerifyTextOptions("John Smith");
        verifyOptions.getPagesSetup().setFirstPage(true);
        //verify document
        VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptions);
        System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:verifySlidesWithTextSignature
	}
	
	public static void verifyWordWithTextSignature(String fileName) throws Throwable{
		//ExStart:verifyWordWithTextSignature
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup digital verification options
        WordsVerifyTextOptions verifyOptions = new WordsVerifyTextOptions("John Smith");
        verifyOptions.getPagesSetup().setFirstPage(true);
        //verify document
        VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptions);
        System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:verifyWordWithTextSignature
	}
	
	public static void signPDFWithFontAndColorOptions(String fileName) throws Throwable{
		//ExStart:signPDFWithFontAndColorOptions
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup digital verification options
		PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
		// setup colors settings
		signOptions.setBackgroundColor(Color.GRAY);
		// setup text color
		signOptions.setForeColor(Color.RED);
		// setup Font options
		signOptions.getFont().setBold(true);
		signOptions.getFont().setItalic(true);
		signOptions.getFont().setUnderline(true);
		signOptions.getFont().setFontFamily("Arial");
		signOptions.getFont().setFontSize(15);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
        String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPDFWithFontAndColorOptions
	}
	
	public static void signPDFWithDifferentOutputFileType(String fileName) throws Throwable{
		//ExStart:signPDFWithDifferentOutputFileType
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
		final PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.epub");
		//
		saveOptions.setFileFormat(PdfSaveFileFormat.Epub);
		// sign document
        String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPDFWithDifferentOutputFileType
	}
	
	public static void addOpacityOptionsToTextSignatureAppearance(String fileName) throws Throwable{
		//ExStart:addOpacityOptionsToTextSignatureAppearance
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
		// setup colors settings
		signOptions.setBackgroundColor(Color.BLUE);
		// setup text color
		signOptions.setForeColor(Color.YELLOW);
		// setup opacity options
		signOptions.setOpacity(0.35);
		// setup Font options
		signOptions.getFont().setBold(true);
		signOptions.getFont().setFontFamily("Arial");
		signOptions.getFont().setFontSize(36);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:addOpacityOptionsToTextSignatureAppearance
	}
	
	public static void signPdfDocumentWithTextSignatureAsImage(String fileName) throws Throwable{
		//ExStart:signPdfDocumentWithTextSignatureAsImage
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
		// setup colors settings
		signOptions.setBackgroundColor(Color.GRAY);
		// setup text color
		signOptions.setForeColor(Color.RED);
		// setup Font options
		signOptions.getFont().setBold(true);
		signOptions.getFont().setItalic(true);
		signOptions.getFont().setUnderline(true);
		signOptions.getFont().setFontFamily("Arial");
		signOptions.getFont().setFontSize(15);
		//type of implementation
		signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Image);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPdfDocumentWithTextSignatureAsImage
	}
	
	public static void signPdfWithTextSignatureAsSticker(String fileName) throws Exception {
		//ExStart:signPdfWithTextSignatureAsSticker
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup signature options
        PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
        signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
        signOptions.setMargin(new Padding(10));
        signOptions.setBackgroundColor(Color.RED);
        signOptions.setOpacity(0.5);
        //type of implementation
        signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Sticker);
        // an appearance customizes more specific options
        PdfTextStickerAppearance appearance = new PdfTextStickerAppearance();
        signOptions.setAppearance(appearance);
        // text content of an sticker
        appearance.setTitle("Title");
        appearance.setSubject("Subject");
        appearance.setContents("Contents");
        // is sticker opened by default
        appearance.setOpened(false);
        // an icon of a sticker on a page
        appearance.setIcon(PdfTextStickerIcon.Star);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        // sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions,
				saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPdfWithTextSignatureAsSticker
	}
	
	public static void usingDefaultAppearanceSignPdfWithTextSignatureSticker(String fileName) throws Exception {
		//ExStart:usingDefaultAppearanceSignPdfWithTextSignatureSticker
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		//If custom appearance is not set there will be used DefaultAppearance
		//User can change any parameter of DefaultAppearance
		// text content of an sticker
        PdfTextStickerAppearance.getDefaultAppearance().setTitle("Title");
        PdfTextStickerAppearance.getDefaultAppearance().setSubject("Subject");
        PdfTextStickerAppearance.getDefaultAppearance().setContents("Contents");
		// is sticker opened by default
        PdfTextStickerAppearance.getDefaultAppearance().setOpened(false);
		// an icon of a sticker on a page
        PdfTextStickerAppearance.getDefaultAppearance().setIcon(PdfTextStickerIcon.Key);
        SignatureOptionsCollection collection = new SignatureOptionsCollection();
        
		//All signatures will have default appearance
		// first signature options
        PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
        signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Sticker);
        signOptions.setTop(100);
        collection.add(signOptions);
		 
		// second signature options
        signOptions = new PdfSignTextOptions("Andrew Conan");
        signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Sticker);
        signOptions.setTop(200);
        collection.add(signOptions);
		 
		// third signature options
        signOptions = new PdfSignTextOptions("Andrew Conan");
        signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Sticker);
        signOptions.setTop(300);
        collection.add(signOptions);
		final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), collection,saveOptions);
		//Reset default appearance to avoid it influence on subsequent signatures
        PdfTextStickerAppearance.resetDefaultAppearance();
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:usingDefaultAppearanceSignPdfWithTextSignatureSticker
	}
	
	public static void addTransperanceAndRotationToTextSignatureAppearance(String fileName) throws Throwable{
		//ExStart:addTransperanceAndRotationToTextSignatureAppearance
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup appearance options
		SlidesSignTextOptions signOptions = new SlidesSignTextOptions("John Smith");
		signOptions.setLeft(100);
		signOptions.setTop(100);
		signOptions.setWidth(200);
		signOptions.setHeight(200);
		signOptions.setForeColor(Color.ORANGE);
		signOptions.setBackgroundColor(Color.BLUE);
		signOptions.setBorderColor(Color.ORANGE);
		signOptions.setBorderWeight(5);
		// setup rotation
		signOptions.setRotationAngle(48);
		// setup transparency
		signOptions.setBackgroundTransparency(0.4);
		signOptions.setBorderTransparency(0.8);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:addTransperanceAndRotationToTextSignatureAppearance
	}
	
	public static void signPasswordProtectedDocWithTextSignature(String fileName) throws Exception{
		//ExStart:signPasswordProtectedDocWithTextSignature
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		String password_1 = "1234567890";
        String password_2 = "0987654321";
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
        SignOptions signOptions = new CellsSignTextOptions("John Smith");
        // specify load options
        LoadOptions loadOptions = new LoadOptions();
        // specify save options
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
 
        //Sign document and save it without password
        //Set signed document name
        saveOptions.setOutputFileName("signed_output_WithoutPassword");
        String signedDocumentWithoutPassword = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, loadOptions, saveOptions);
 
        //Sign document and save it with new password
        //Set signed document name
        saveOptions.setOutputFileName("signed_output_NewPassword");
        //Add password to save options
        saveOptions.setPassword(password_1);
        //Sign document with new password
        String signedDocumentWithPassword = handler.sign(signedDocumentWithoutPassword, signOptions, loadOptions, saveOptions);
 
        //Sign document and save it with original password
        //Set signed document name
        saveOptions.setOutputFileName("signed_output_OriginalPassword");
        //Add password to load options to have ability to open document
        loadOptions.setPassword(password_1);
        //Set saveOptions to use password from loadOptions
        saveOptions.setUseOriginalPassword(true);
        saveOptions.setPassword("");
        //Sign document with original password
        String signedDocumentWithOriginalPassword = handler.sign(signedDocumentWithPassword, signOptions, loadOptions, saveOptions);
 
        //Sign document and save it with another password
        //Set signed document name
        saveOptions.setOutputFileName("signed_output_AnotherPassword");
        //Add password to load options to have ability to open document
        loadOptions.setPassword(password_1);
        //Set saveOptions to use another password
        saveOptions.setUseOriginalPassword(false);
        saveOptions.setPassword(password_2);
        //Sign document with another password
        String signedDocumentWithAnotherPassword = handler.sign(signedDocumentWithOriginalPassword, signOptions, loadOptions, saveOptions);
 
        //Sign document and save it without password
        //Set signed document name
        saveOptions.setOutputFileName("signed_output_RemovedPassword");
        //Add password to load options to have ability to open document
        loadOptions.setPassword(password_2);
        //Set saveOptions with empty password
        saveOptions.setUseOriginalPassword(false);
        saveOptions.setPassword("");
        //Sign document with removed password
        String signedDocumentWithRemovedPassword = handler.sign(signedDocumentWithAnotherPassword, signOptions, loadOptions, saveOptions);
		//ExEnd:signPasswordProtectedDocWithTextSignature
	}
	
	public static void signImageDocWithText(String fileName) throws Exception {
		//ExStart:signImageDocWithText
		//setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores
		// in config.ImagesPath folder
		ImagesSignTextOptions signOptions = new ImagesSignTextOptions("John Smith");
		signOptions.setLeft(10);
		signOptions.setTop(10);
		signOptions.setWidth(100);
		signOptions.setHeight(100);
		signOptions.setDocumentPageNumber(1);
		  // setup background settings
		signOptions.setBackgroundColor(Color.BLUE);
		signOptions.setBackgroundTransparency(0.5);
		  // setup border settings
		signOptions.setBorderColor(Color.BLACK);
		signOptions.setBorderDashStyle(ExtendedDashStyle.LongDash);
		signOptions.setBorderWeight(1.2);
		signOptions.setBorderTransparency(0.5);
		  // setup text color
		signOptions.setForeColor(Color.RED);
		  // setup Font options
		signOptions.getFont().setBold(true);
		signOptions.getFont().setItalic(true);
		signOptions.getFont().setUnderline(true);
		signOptions.getFont().setFontFamily("Arial");
		signOptions.getFont().setFontSize(15);
		  // type of implementation
		signOptions.setSignatureImplementation(ImagesTextSignatureImplementation.TextAsImage);
		  
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.<String> sign(CommonUtilities.getStoragePath(fileName), signOptions,
				saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signImageDocWithText
	}
	
	public static void signImageWithDifferentOutputFileType(String fileName) throws Throwable{
		//ExStart:signImageWithDifferentOutputFileType
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup text signature options
		SignOptions signOptions = new ImagesSignTextOptions("John Smith");
		//Webp
		ImagesSaveOptions optionsWebp = new ImagesSaveOptions();
		optionsWebp.setOutputType(OutputType.String);
		optionsWebp.setFileFormat(ImagesSaveFileFormat.Webp);
		optionsWebp.setOutputFileName("signed_output_Webp");
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, optionsWebp);
		  
		  // save to Jpeg format with specific options
		JpegSaveOptions saveOptionsJpeg = new JpegSaveOptions();
		saveOptionsJpeg.setOutputType(OutputType.String);
		saveOptionsJpeg.setColorType(JpegCompressionColorMode.Cmyk);
		saveOptionsJpeg.setCompressionType(JpegCompressionMode.Progressive);
		saveOptionsJpeg.setOutputFileName("signed_output_Jpeg");
		signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptionsJpeg);
		  
		  // save to Bmp format with specific options
		BmpSaveOptions saveOptionsBmp = new BmpSaveOptions();
		saveOptionsBmp.setOutputType(OutputType.String);
		saveOptionsBmp.setCompression(BitmapCompression.Rgb);
		saveOptionsBmp.setHorizontalResolution(120);
		saveOptionsBmp.setVerticalResolution(120);
		saveOptionsBmp.setOutputFileName("signed_output_Bmp");
		signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptionsBmp);
		  
		  // save to Tiff format with specific options
		TiffSaveOptions saveOptionsTiff = new TiffSaveOptions();
		saveOptionsTiff.setOutputType(OutputType.String);
		saveOptionsTiff.setExpectedTiffFormat(TiffFormat.TiffCcitRle);
		saveOptionsTiff.setOutputFileName("signed_output_Tiff");
		// sign document
        signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptionsTiff);
        System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signImageWithDifferentOutputFileType
	}
	
	public static void addTransperanceAndRotationToTextSignatureInImageDoc(String fileName) throws Throwable{
		//ExStart:addTransperanceAndRotationToTextSignatureInImageDoc
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup appearance options
		ImagesSignTextOptions signOptions = new ImagesSignTextOptions("John Smith");
		  
		signOptions.setLeft(100);
		signOptions.setTop(100);
		signOptions.setWidth(200);
		signOptions.setHeight(200);
		signOptions.setForeColor(Color.ORANGE);
		signOptions.setBackgroundColor(Color.BLUE);
		// setup rotation
		signOptions.setRotationAngle(90);
		// setup transparency
		signOptions.setBackgroundTransparency(0.4);
		  
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:addTransperanceAndRotationToTextSignatureInImageDoc
	}
	
	public static void signImageDocsWithTextSignatureAsWatermark(String fileName) throws Throwable{
		//ExStart:signImageDocsWithTextSignatureAsWatermark
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup appearance options
		ImagesSignTextOptions signOptions = new ImagesSignTextOptions("John Smith");
		  
		signOptions.getFont().setFontSize(64);
		signOptions.getFont().setBold(true);
		signOptions.getFont().setItalic(true);
		signOptions.getFont().setUnderline(true);
		signOptions.setOpacity(0.7);
		signOptions.setForeColor(Color.BLUE);
		  
		  // type of implementation
		signOptions.setSignatureImplementation(ImagesTextSignatureImplementation.Watermark);
		  
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signImageDocsWithTextSignatureAsWatermark
	}
	
	public static void signDocumentWithSignatureProcessEvents(String fileName) throws Throwable{
		//ExStart:signDocumentWithSignatureProcessEvents
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup signature option
		PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
		// text rectangle size
		signOptions.setHeight(100);
		signOptions.setWidth(100);
		signOptions.setSignAllPages(true);
		//
		SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("Process_Events");
		//
		handler.SignatureStarted.add(new ProcessStartEventHandler() {
		    public void invoke(Object sender, ProcessStartEventArgs args) {
		        System.out.println("Signature process of "+args.getGuid()+" started at "+ args.getStarted().toString());
		    }
		});
		  
		//
		handler.SignatureProgress.add(new ProcessProgressEventHandler(){
		    public void invoke(Object sender, ProcessProgressEventArgs args) {
		        System.out.println("Singing of "+args.getGuid()+" progress: "+args.getProgress()+" %. Since start process spent "+args.getTicks()+" mlsec" );
		    }
		  
		});
		handler.SignatureCompleted.add(new ProcessCompleteEventHandler() {
		    public void invoke(Object sender, ProcessCompleteEventArgs args) {
		        System.out.println("Singing of "+args.getGuid()+" completed at "+args.getCompleted().toString()+". Process took "+args.getTicks()+" mlsec" );
		    }
		});
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signDocumentWithSignatureProcessEvents
	}
	
	public static void verifyDocumentWithVerificationProcessEvents(String fileName) throws Throwable{
		//ExStart:verifyDocumentWithVerificationProcessEvents
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup signature option
		PDFVerifyTextOptions verifyOptions = new PDFVerifyTextOptions("John Smith");
		// text rectangle size
		verifyOptions.setVerifyAllPages(true);
		//
		handler.VerificationStarted.add(new ProcessStartEventHandler() {
			public void invoke(Object sender, ProcessStartEventArgs args) {
		        System.out.println("Verification process of "+args.getGuid()+" started at "+ args.getStarted().toString());
		    }
		});
		handler.VerificationProgress.add(new ProcessProgressEventHandler() {
			 public void invoke(Object sender, ProcessProgressEventArgs args) {
			        System.out.println("Verification of "+args.getGuid()+" progress: "+args.getProgress()+" %. Since start process spent "+args.getTicks()+" mlsec");
			    }
		});
		handler.VerificationCompleted.add(new ProcessCompleteEventHandler() {
			public void invoke(Object sender, ProcessCompleteEventArgs args) {
		        System.out.println("Verification of "+args.getGuid()+" completed at "+args.getCompleted().toString()+". Process took "+args.getTicks()+" mlsec");
		    }
		});
		// verify document
		VerificationResult result = handler.verify(fileName, verifyOptions);
		System.out.println("Verification result is: " + result.isValid());
		//ExEnd:verifyDocumentWithVerificationProcessEvents
	}
	
	public static void signCellDocumentWithTextSignatureAppearence(String fileName) throws Throwable{
		//ExStart:signCellDocumentWithTextSignatureAppearence
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup appearance options
		CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
		  
		// setup background settings
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setColumnNumber(2);
		signOptions.setRowNumber(3);
		signOptions.setWidth(300);
		signOptions.setHeight(100);
		  
		// setup background settings
		signOptions.setBackgroundColor(Color.YELLOW);
		signOptions.setBackgroundTransparency(0.5);
		  
		//setup border settings
		signOptions.setBorderColor(Color.ORANGE);
		signOptions.setBorderWeight(1.2);
		signOptions.setBorderTransparency(0.5);
		signOptions.setBorderDashStyle(DashStyle.DashLongDashDot);
		signOptions.setBorderVisiblity(true);
		signOptions.setBorderWeight(2);
		  
		// setup text color
		signOptions.setForeColor(Color.BLUE);
		// setup Font options
		signOptions.getFont().setBold(true);
		signOptions.getFont().setItalic(true);
		signOptions.getFont().setUnderline(true);
		signOptions.getFont().setStrikeout(true);
		signOptions.getFont().setFontFamily("Arial");
		signOptions.getFont().setFontSize(25);
		  
		//setup type of signature shape (could appears differently for various document types)
		//This feature is supported starting from version 17.11
		signOptions.setShapeType(CellsTextShapeType.UpRibbon);
		  
		// setup save options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signCellDocumentWithTextSignatureAppearence
	}
	
	public static void signSlideDocumentWithTextShadowExtension(String fileName) throws Throwable{
		//ExStart:signSlideDocumentWithTextShadowExtension
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// set up text signature options
		SlidesSignTextOptions signOptions = new SlidesSignTextOptions("John Smith");
		signOptions.setWidth(300);
		signOptions.setHeight(300);
		signOptions.getFont().setFontSize(48);
		  
		// set up shadow options for text
		TextShadow shadow = new TextShadow();
		shadow.setColor(Color.ORANGE);
		shadow.setAngle(135);
		shadow.setBlur(5);
		shadow.setDistance(4);
		shadow.setTransparency(0.2);
		  
		//add text shadow to signature extensions
		signOptions.getExtensions().add(shadow);
		  
		// specify save options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signSlideDocumentWithTextShadowExtension
	}
	
	public static void setupSolidBrushForSignatureBackground(String fileName) throws Throwable{
		//ExStart:setupSolidBrushForSignatureBackground
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// set up options with text of signature
		PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
		signOptions.setWidth(100);
		signOptions.setHeight(100);
		  
		// set up brush for signature background
		Brush userBrushStyle = new SolidBrush(Color.ORANGE);
		  
		signOptions.setBackgroundBrushStyle(userBrushStyle);
		  
		// specify save options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setupSolidBrushForSignatureBackground
	}
	
	public static void setupLinearGrdiantBrushForSignatureBackground(String fileName) throws Throwable{
		//ExStart:setupLinearGrdiantBrushForSignatureBackground
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");		   
	    // text rectangle size
		signOptions.setHeight(100);
		signOptions.setWidth(100);		   
	    //brush for signature background
		Rectangle rectBrush = new Rectangle(0, 0, signOptions.getWidth(), signOptions.getHeight());		   
		   
	    //This feature is available from version 18.4
		LinearGradientBrush linearGradientBrush = new LinearGradientBrush();
		linearGradientBrush.setStartColor(Color.BLUE);
		linearGradientBrush.setEndColor(Color.ORANGE);
		linearGradientBrush.setAngle(75);		   
		Brush userBrushStyle = linearGradientBrush;
		   
		signOptions.setBackgroundBrushStyle(userBrushStyle);
		   
	    // specify save options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setupLinearGrdiantBrushForSignatureBackground
	}
	
	public static void setupRadialGrdiantBrushForSignatureBackground(String fileName) throws Throwable{
		//ExStart:setupRadialGrdiantBrushForSignatureBackground
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// set up options with text of signature
		PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
		signOptions.setWidth(100);
		signOptions.setHeight(100);
		signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Image);		  
		// set up brush for signature background
		RadialGradientBrush userBrushStyle = new RadialGradientBrush(Color.ORANGE, Color.RED);		  
		signOptions.setBackgroundBrushStyle(userBrushStyle);		  
		// specify save options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setupRadialGrdiantBrushForSignatureBackground
	}
	
	public static void setupTextureBrushForSignatureBackground(String fileName) throws Throwable{
		//ExStart:setupTextureBrushForSignatureBackground
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// set up options with text of signature
		CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
		signOptions.setWidth(100);
		signOptions.setHeight(100);		  
		  
		TextureBrush userBrushStyle = new TextureBrush(CommonUtilities.getImagesPath("sign.PNG"));
		  
		signOptions.setBackgroundBrushStyle(userBrushStyle);
		  
		// specify save options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setupTextureBrushForSignatureBackground
	}
}
