package com.groupdocs.signature.examples;

import java.awt.Color;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.qrcodes.QRCodeTypes;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.SignatureOptionsCollection;
import com.groupdocs.signature.options.VerifyOptionsCollection;
import com.groupdocs.signature.options.barcodesignature.CellsBarcodeSignOptions;
import com.groupdocs.signature.options.barcodesignature.ImagesBarcodeSignOptions;
import com.groupdocs.signature.options.barcodesignature.PdfBarcodeSignOptions;
import com.groupdocs.signature.options.barcodesignature.SlidesBarcodeSignOptions;
import com.groupdocs.signature.options.barcodesignature.WordsBarcodeSignOptions;
import com.groupdocs.signature.options.barcodeverification.CellsVerifyBarcodeOptions;
import com.groupdocs.signature.options.barcodeverification.ImagesVerifyBarcodeOptions;
import com.groupdocs.signature.options.barcodeverification.PDFVerifyBarcodeOptions;
import com.groupdocs.signature.options.barcodeverification.SlidesVerifyBarcodeOptions;
import com.groupdocs.signature.options.barcodeverification.WordsVerifyBarcodeOptions;
import com.groupdocs.signature.options.qrcodesignature.CellsQRCodeSignOptions;
import com.groupdocs.signature.options.qrcodesignature.ImagesQRCodeSignOptions;
import com.groupdocs.signature.options.qrcodesignature.PdfQRCodeSignOptions;
import com.groupdocs.signature.options.qrcodesignature.SlidesQRCodeSignOptions;
import com.groupdocs.signature.options.qrcodesignature.WordsQRCodeSignOptions;
import com.groupdocs.signature.options.qrcodeverification.CellsVerifyQRCodeOptions;
import com.groupdocs.signature.options.qrcodeverification.ImagesVerifyQRCodeOptions;
import com.groupdocs.signature.options.qrcodeverification.PDFVerifyQRCodeOptions;
import com.groupdocs.signature.options.qrcodeverification.SlidesVerifyQRCodeOptions;
import com.groupdocs.signature.options.qrcodeverification.WordsVerifyQRCodeOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;

public class OpticalSignature {

	public static void signCellDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:signCellDocsWithOpticalSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		CellsBarcodeSignOptions signOptions = new CellsBarcodeSignOptions("12345678");
		
		// barcode type
		signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
		// if you need to sign all sheets set it to true
        signOptions.setSignAllPages(true);      
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        // sign document
        String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
        //System.out.println("Signed cells document with barcode" + signedPath);
		//ExEnd:signCellDocsWithOpticalSignature
	}
	
	public static void signPDFDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:signPDFDocsWithOpticalSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		PdfBarcodeSignOptions signOptions = new PdfBarcodeSignOptions("12345678");
		// text position
		signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
		signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
		// barcode type
		signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
		// if you need to sign all sheets set it to true
		signOptions.setSignAllPages(true);
		// set border (optionally)
		signOptions.setBorderVisiblity(true);
		signOptions.setBorderColor(Color.BLUE);
		signOptions.setBorderWeight(3);
		signOptions.setBorderDashStyle(DashStyle.RoundDot);
		// set opacity (optionally)
		signOptions.setOpacity(0.5);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
		//System.out.println("Signed pdf document with barcode" + signedPath);
		//ExEnd:signPDFDocsWithOpticalSignature
	}
	
	public static void signSlidesDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:signSlidesDocsWithOpticalSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		SlidesBarcodeSignOptions signOptions = new SlidesBarcodeSignOptions("12345678");
		// barcode type
		signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
		// if you need to sign all sheets set it to true
        signOptions.setSignAllPages(true);      
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        // sign document
        String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
        //System.out.println("Signed PowerPoint document with barcode" + signedPath);
		//ExEnd:signSlidesDocsWithOpticalSignature
	}
	
	public static void signWordsDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:signWordsDocWithOpticalSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		WordsBarcodeSignOptions signOptions = new WordsBarcodeSignOptions("12345678");
		// barcode type
		signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
		// if you need to sign all sheets set it to true
        signOptions.setSignAllPages(true);      
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        // sign document
        String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
        //System.out.println("Signed word document with barcode" + signedPath);
		//ExEnd:signWordsDocWithOpticalSignature
	}
	
	public static void signCellDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:signCellDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		CellsQRCodeSignOptions signOptions = new CellsQRCodeSignOptions("12345678");
		// barcode type
		signOptions.setEncodeType(QRCodeTypes.AZTEC);
		// if you need to sign all sheets set it to true
        signOptions.setSignAllPages(true);      
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        // sign document
        String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
        //System.out.println("Signed cells document with barcode" + signedPath);
		//ExEnd:signCellDocWithQRCodeSignature
	}
	
	public static void signPDFDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:signPDFDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions("12345678");
		// barcode type
		signOptions.setEncodeType(QRCodeTypes.AZTEC);
		// if you need to sign all sheets set it to true
		signOptions.setSignAllPages(true);		   
		// set border (optionally)
        signOptions.setBorderVisiblity(true);
        signOptions.setBorderColor(Color.BLUE);
        signOptions.setBorderWeight(3);
        signOptions.setBorderDashStyle(DashStyle.RoundDot);		   
		// set opacity (optionally)
        signOptions.setOpacity(0.5);  
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");		   
		// sign document
        String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
        //System.out.println("Signed pdf document with qrcode" + signedPath);
		//ExEnd:signPDFDocWithQRCodeSignature
	}
	
	public static void signSlidesDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:signSlidesDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		SlidesQRCodeSignOptions signOptions = new SlidesQRCodeSignOptions ("12345678");
		// barcode type
        signOptions.setEncodeType(QRCodeTypes.AZTEC);
        // if you need to sign all sheets set it to true
        signOptions.setSignAllPages(true);      
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        // sign document
        String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
        //System.out.println("Signed PowerPoint document with qrcode" + signedPath);
		//ExEnd:signSlidesDocWithQRCodeSignature
	}
	
	public static void signWordsDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:signWordsDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		WordsQRCodeSignOptions signOptions = new WordsQRCodeSignOptions ("12345678");
		// barcode type
        signOptions.setEncodeType(QRCodeTypes.AZTEC);
		// if you need to sign all sheets set it to true
        signOptions.setSignAllPages(true);      
	    final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
		// sign document
        String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
        //System.out.println("Signed word document with qrcode" + signedPath);
		//ExEnd:signWordsDocWithQRCodeSignature
	}
	
	public static void verifyCellDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:verifyCellDocWithBarcodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup verification options
        CellsVerifyBarcodeOptions verifyOptions = new CellsVerifyBarcodeOptions();
        // verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
        // verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
        // barcode type
        verifyOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
        //If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("12345678");
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification cells file with Barcode signature " + result.isValid());
		//ExEnd:verifyCellDocWithBarcodeSignature
	}
	
	public static void verifyPDFDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:verifyPDFDocWithBarcodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup verification options
        PDFVerifyBarcodeOptions verifyOptions = new PDFVerifyBarcodeOptions();
        // verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
        // verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
        // barcode type
        verifyOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
        //If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("12345678");
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification pdf file with Barcode signature " + result.isValid());
		//ExEnd:verifyPDFDocWithBarcodeSignature
	}
	
	public static void verifySlidesDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:verifySlidesDocWithBarcodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup verification options
        SlidesVerifyBarcodeOptions verifyOptions = new SlidesVerifyBarcodeOptions();
        // verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
        // verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
        // barcode type
        verifyOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
        //If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("12345678");
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification ppt file with Barcode signature " + result.isValid());
		//ExEnd:verifySlidesDocWithBarcodeSignature
	}
	
	public static void verifyWordsDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:verifyWordsDocWithBarcodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup verification options
        WordsVerifyBarcodeOptions verifyOptions = new WordsVerifyBarcodeOptions();
        // verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
        // verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
        // barcode type
        verifyOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
        //If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("12345678");
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification word file with Barcode signature " + result.isValid());
		//ExEnd:verifyWordsDocWithBarcodeSignature
	}
	
	public static void verifyCellDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:verifyCellDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup verification options
        CellsVerifyQRCodeOptions verifyOptions = new CellsVerifyQRCodeOptions();
        // verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
        // verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
        // barcode type
        verifyOptions.setEncodeType(QRCodeTypes.AZTEC);
        //If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("12345678");
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification cells file with Barcode signature " + result.isValid());
		//ExEnd:verifyCellDocWithQRCodeSignature
	}
	
	public static void verifyPDFDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:verifyPDFDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup verification options
        PDFVerifyQRCodeOptions verifyOptions = new PDFVerifyQRCodeOptions();
        // verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
        // verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
        // barcode type
        verifyOptions.setEncodeType(QRCodeTypes.AZTEC);
        //If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("12345678");
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification pdf file with Qrcode signature " + result.isValid());
		//ExEnd:verifyPDFDocWithQRCodeSignature
	}
	
	public static void verifySlidesDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:verifySlidesDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup verification options
        SlidesVerifyQRCodeOptions verifyOptions = new SlidesVerifyQRCodeOptions();
        // verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
        // verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
        // barcode type
        verifyOptions.setEncodeType(QRCodeTypes.AZTEC);
        //If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("12345678");
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification ppt file with Qrcode signature " + result.isValid());
		//ExEnd:verifySlidesDocWithQRCodeSignature
	}
	
	public static void verifyWordsDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:verifyWordsDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup verification options
        WordsVerifyQRCodeOptions verifyOptions = new WordsVerifyQRCodeOptions();
        // verify only page with specified number
        verifyOptions.setDocumentPageNumber(1);
        // verify all pages of a document if true
        verifyOptions.setVerifyAllPages(true);
        // barcode type
        verifyOptions.setEncodeType(QRCodeTypes.AZTEC);
        //If verify option Text is set, it will be searched in Title, Subject and Contents
        verifyOptions.setText("12345678");
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification word file with Qrcode signature " + result.isValid());
		//ExEnd:verifyWordsDocWithQRCodeSignature
	}
	
	public static void signImageDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:signImageDocWithBarcodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		SignatureOptionsCollection collection = new SignatureOptionsCollection();
		  
		  // barcode type Code39Standard
		ImagesBarcodeSignOptions signOptions = new ImagesBarcodeSignOptions("12345678");
		signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		collection.add(signOptions);
		  
		  // barcode type DutchKIX
		signOptions = new ImagesBarcodeSignOptions("12345678");
		signOptions.setEncodeType(BarcodeTypes.DUTCH_KIX);
		signOptions.setTop(300);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		collection.add(signOptions);
		  
		  // barcode type DatabarLimited
		signOptions = new ImagesBarcodeSignOptions("12345678");
		signOptions.setEncodeType(BarcodeTypes.DATABAR_LIMITED);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		signOptions.setTop(600);
		collection.add(signOptions);   
        
        SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        
        // sign document
        String signedPath = handler.<String>sign(fileName, collection, saveOptions);
		//ExEnd:signImageDocWithBarcodeSignature
	}
	
	public static void signImageDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:signImageDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		SignatureOptionsCollection collection = new SignatureOptionsCollection();
		  
		// QRCode type Aztec
		ImagesQRCodeSignOptions signOptions = new ImagesQRCodeSignOptions("12345678");
		signOptions.setEncodeType(QRCodeTypes.AZTEC);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		collection.add(signOptions);
		  
		//QRCode type DataMatrix
		signOptions = new ImagesQRCodeSignOptions("12345678");
		signOptions.setEncodeType(QRCodeTypes.DATA_MATRIX);
		signOptions.setTop(300);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		collection.add(signOptions);
		  
		//QRCode type QR
		signOptions = new ImagesQRCodeSignOptions("12345678");
		signOptions.setEncodeType(QRCodeTypes.QR);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		signOptions.setTop(600);
		collection.add(signOptions); 
        
        SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        
        // sign document
        String signedPath = handler.<String>sign(fileName, collection, saveOptions);
		//ExEnd:signImageDocWithQRCodeSignature
	}
	
	public static void verifyImageDocWithBarcodeSignature(String fileName) throws Throwable{
		//ExStart:verifyImageDocWithBarcodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		VerifyOptionsCollection collection = new VerifyOptionsCollection();
		  
		// setup verification options Code39Standard
		ImagesVerifyBarcodeOptions verifyOptions = new ImagesVerifyBarcodeOptions();
		verifyOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
		verifyOptions.setMatchType(TextMatchType.Exact);
		verifyOptions.setText("12345678");
		collection.add(verifyOptions);
		  
		//setup verification options DutchKIX
		verifyOptions = new ImagesVerifyBarcodeOptions();
		verifyOptions.setEncodeType(BarcodeTypes.DUTCH_KIX);
		verifyOptions.setMatchType(TextMatchType.StartsWith);
		verifyOptions.setText("1234");
		collection.add(verifyOptions);
		  
		//setup verification options DatabarLimited
		verifyOptions = new ImagesVerifyBarcodeOptions();
		verifyOptions.setEncodeType(BarcodeTypes.DATABAR_LIMITED);
		verifyOptions.setMatchType(TextMatchType.Contains);
		verifyOptions.setText("5678");
		collection.add(verifyOptions);
		
        //verify document
        VerificationResult result = handler.verify(fileName, collection);
        System.out.println("Verification word file with Barcode signature " + result.isValid());
		//ExEnd:verifyImageDocWithBarcodeSignature
	}
	
	public static void verifyImageDocWithQRCodeSignature(String fileName) throws Throwable{
		//ExStart:verifyImageDocWithQRCodeSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		VerifyOptionsCollection collection = new VerifyOptionsCollection();
		  
		  // setup verification options Aztec
		ImagesVerifyQRCodeOptions verifyOptions = new ImagesVerifyQRCodeOptions();
		verifyOptions.setEncodeType(QRCodeTypes.AZTEC);
		verifyOptions.setMatchType(TextMatchType.Exact);
		verifyOptions.setText("12345678");
		collection.add(verifyOptions);
		  
		  // setup verification options DataMatrix
		verifyOptions = new ImagesVerifyQRCodeOptions();
		verifyOptions.setEncodeType(QRCodeTypes.DATA_MATRIX);
		verifyOptions.setMatchType(TextMatchType.StartsWith);
		verifyOptions.setText("1234");
		collection.add(verifyOptions);
		  
		  // setup verification options QR
		verifyOptions = new ImagesVerifyQRCodeOptions();
		verifyOptions.setEncodeType(QRCodeTypes.QR);
		verifyOptions.setMatchType(TextMatchType.Contains);
		verifyOptions.setText("5678");
		collection.add(verifyOptions);
		
        //verify document
        VerificationResult result = handler.verify(fileName, collection);
        System.out.println("Verification word file with Qrcode signature " + result.isValid());
		//ExEnd:verifyImageDocWithQRCodeSignature
	}
	
}