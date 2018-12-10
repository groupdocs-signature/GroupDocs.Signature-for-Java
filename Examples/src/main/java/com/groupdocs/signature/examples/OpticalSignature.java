package com.groupdocs.signature.examples;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.SearchResult;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.MeasureType;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricAlgorithmType;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricEncryption;
import com.groupdocs.signature.domain.extensions.serialization.Address;
import com.groupdocs.signature.domain.extensions.serialization.Email;
import com.groupdocs.signature.domain.extensions.serialization.FormatAttribute;
import com.groupdocs.signature.domain.extensions.serialization.VCard;
import com.groupdocs.signature.domain.qrcodes.QRCodeTypes;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.barcode.BarcodeSignature;
import com.groupdocs.signature.domain.signatures.qrcode.PdfQRCodeSignature;
import com.groupdocs.signature.domain.signatures.qrcode.QRCodeSignature;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.handler.events.ProcessCompleteEventArgs;
import com.groupdocs.signature.handler.events.ProcessCompleteEventHandler;
import com.groupdocs.signature.handler.events.ProcessProgressEventArgs;
import com.groupdocs.signature.handler.events.ProcessProgressEventHandler;
import com.groupdocs.signature.handler.events.ProcessStartEventArgs;
import com.groupdocs.signature.handler.events.ProcessStartEventHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.SignatureOptionsCollection;
import com.groupdocs.signature.options.VerifyOptionsCollection;
import com.groupdocs.signature.options.barcodesearch.CellsSearchBarcodeOptions;
import com.groupdocs.signature.options.barcodesearch.ImagesSearchBarcodeOptions;
import com.groupdocs.signature.options.barcodesearch.PdfSearchBarcodeOptions;
import com.groupdocs.signature.options.barcodesearch.SlidesSearchBarcodeOptions;
import com.groupdocs.signature.options.barcodesearch.WordsSearchBarcodeOptions;
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
import com.groupdocs.signature.options.qrcodesearch.CellsSearchQRCodeOptions;
import com.groupdocs.signature.options.qrcodesearch.ImagesSearchQRCodeOptions;
import com.groupdocs.signature.options.qrcodesearch.PdfSearchQRCodeOptions;
import com.groupdocs.signature.options.qrcodesearch.SlidesSearchQRCodeOptions;
import com.groupdocs.signature.options.qrcodesearch.WordsSearchQRCodeOptions;
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
		signOptions.setEncodeType(BarcodeTypes.Code39Standard);
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
		signOptions.setEncodeType(BarcodeTypes.Code39Standard);
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
		signOptions.setEncodeType(BarcodeTypes.Code39Standard);
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
		signOptions.setEncodeType(BarcodeTypes.Code39Standard);
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
		signOptions.setEncodeType(QRCodeTypes.Aztec);
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
		signOptions.setEncodeType(QRCodeTypes.Aztec);
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
        signOptions.setEncodeType(QRCodeTypes.Aztec);
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
        signOptions.setEncodeType(QRCodeTypes.Aztec);
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
        verifyOptions.setEncodeType(BarcodeTypes.Code39Standard);
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
        verifyOptions.setEncodeType(BarcodeTypes.Code39Standard);
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
        verifyOptions.setEncodeType(BarcodeTypes.Code39Standard);
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
        verifyOptions.setEncodeType(BarcodeTypes.Code39Standard);
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
        verifyOptions.setEncodeType(QRCodeTypes.Aztec);
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
        verifyOptions.setEncodeType(QRCodeTypes.Aztec);
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
        verifyOptions.setEncodeType(QRCodeTypes.Aztec);
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
        verifyOptions.setEncodeType(QRCodeTypes.Aztec);
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
		signOptions.setEncodeType(BarcodeTypes.Code39Standard);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		collection.add(signOptions);
		  
		  // barcode type DutchKIX
		signOptions = new ImagesBarcodeSignOptions("12345678");
		signOptions.setEncodeType(BarcodeTypes.DutchKIX);
		signOptions.setTop(300);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		collection.add(signOptions);
		  
		  // barcode type DatabarLimited
		signOptions = new ImagesBarcodeSignOptions("12345678");
		signOptions.setEncodeType(BarcodeTypes.DatabarLimited);
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
		signOptions.setEncodeType(QRCodeTypes.Aztec);
		signOptions.setHorizontalAlignment(HorizontalAlignment.None);
		signOptions.setVerticalAlignment(VerticalAlignment.None);
		collection.add(signOptions);
		  
		//QRCode type DataMatrix
		signOptions = new ImagesQRCodeSignOptions("12345678");
		signOptions.setEncodeType(QRCodeTypes.DataMatrix);
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
		verifyOptions.setEncodeType(BarcodeTypes.Code39Standard);
		verifyOptions.setMatchType(TextMatchType.Exact);
		verifyOptions.setText("12345678");
		collection.add(verifyOptions);
		  
		//setup verification options DutchKIX
		verifyOptions = new ImagesVerifyBarcodeOptions();
		verifyOptions.setEncodeType(BarcodeTypes.DutchKIX);
		verifyOptions.setMatchType(TextMatchType.StartsWith);
		verifyOptions.setText("1234");
		collection.add(verifyOptions);
		  
		//setup verification options DatabarLimited
		verifyOptions = new ImagesVerifyBarcodeOptions();
		verifyOptions.setEncodeType(BarcodeTypes.DatabarLimited);
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
		verifyOptions.setEncodeType(QRCodeTypes.Aztec);
		verifyOptions.setMatchType(TextMatchType.Exact);
		verifyOptions.setText("12345678");
		collection.add(verifyOptions);
		  
		  // setup verification options DataMatrix
		verifyOptions = new ImagesVerifyQRCodeOptions();
		verifyOptions.setEncodeType(QRCodeTypes.DataMatrix );
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
	
	public static void searchBarCodeSignaturesInPDF(String fileName) throws Throwable{
		//ExStart:searchBarCodeSignaturesInPDF
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		PdfSearchBarcodeOptions searchOptions = new PdfSearchBarcodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify barcode type to search only special encode type
		searchOptions.setEncodeType(BarcodeTypes.Code39Standard);
		    // specify barcode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
		    BarcodeSignature bcSignature = (BarcodeSignature)signature;
		    if(bcSignature != null)
		    {
		    	System.out.println("Found Barcode signature:"+bcSignature.getEncodeType().getTypeName()+" with text "+bcSignature.getText());
		    }
		}
		//ExEnd:searchBarCodeSignaturesInPDF
	}
	
	public static void searchBarCodeSignaturesInCells(String fileName) throws Throwable{
		//ExStart:searchBarCodeSignaturesInCells
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		CellsSearchBarcodeOptions searchOptions = new CellsSearchBarcodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify barcode type to search only special encode type
		searchOptions.setEncodeType(BarcodeTypes.Code39Standard);
		    // specify barcode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
		    BarcodeSignature bcSignature = (BarcodeSignature)signature;
		    if(bcSignature != null)
		    {
		    	System.out.println("Found Barcode signature:"+bcSignature.getEncodeType().getTypeName()+" with text "+bcSignature.getText());
		    }
		}
		//ExEnd:searchBarCodeSignaturesInCells
	}
	
	public static void searchBarCodeSignaturesInImages(String fileName) throws Throwable{
		//ExStart:searchBarCodeSignaturesInImages
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		ImagesSearchBarcodeOptions searchOptions = new ImagesSearchBarcodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify barcode type to search only special encode type
		searchOptions.setEncodeType(BarcodeTypes.Code39Standard);
		    // specify barcode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
		    BarcodeSignature bcSignature = (BarcodeSignature)signature;
		    if(bcSignature != null)
		    {
		    	System.out.println("Found Barcode signature:"+bcSignature.getEncodeType().getTypeName()+" with text "+bcSignature.getText());
		    }
		}
		//ExEnd:searchBarCodeSignaturesInImages
	}
	
	public static void searchBarCodeSignaturesInSlides(String fileName) throws Throwable{
		//ExStart:searchBarCodeSignaturesInSlides
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		SlidesSearchBarcodeOptions searchOptions = new SlidesSearchBarcodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify barcode type to search only special encode type
		searchOptions.setEncodeType(BarcodeTypes.Code39Standard);
		    // specify barcode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
		    BarcodeSignature bcSignature = (BarcodeSignature)signature;
		    if(bcSignature != null)
		    {
		    	System.out.println("Found Barcode signature:"+bcSignature.getEncodeType().getTypeName()+" with text "+bcSignature.getText());
		    }
		}
		//ExEnd:searchBarCodeSignaturesInSlides
	}
	
	public static void searchBarCodeSignaturesInWords(String fileName) throws Throwable{
		//ExStart:searchBarCodeSignaturesInWords
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		WordsSearchBarcodeOptions searchOptions = new WordsSearchBarcodeOptions ();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify barcode type to search only special encode type
		searchOptions.setEncodeType(BarcodeTypes.Code39Standard);
		    // specify barcode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
		    BarcodeSignature bcSignature = (BarcodeSignature)signature;
		    if(bcSignature != null)
		    {
		    	System.out.println("Found Barcode signature:"+bcSignature.getEncodeType().getTypeName()+" with text "+bcSignature.getText());
		    }
		}
		//ExEnd:searchBarCodeSignaturesInWords
	}
	
	public static void searchQRCodeSignaturesInPDF(String fileName) throws Throwable{
		//ExStart:searchQRCodeSignaturesInPDF
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		PdfSearchQRCodeOptions searchOptions = new PdfSearchQRCodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify QRCode type to search only special encode type
		searchOptions.setEncodeType(QRCodeTypes.QR);
		    // specify QRCode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
			QRCodeSignature qcSignature = (QRCodeSignature)signature;
		    if(qcSignature != null)
		    {
		    	System.out.println("Found QRCode signature:"+qcSignature.getEncodeType().getTypeName()+" with text "+qcSignature.getText());
		    }
		}
		//ExEnd:searchQRCodeSignaturesInPDF
	}
	
	public static void searchQRCodeSignaturesInCells(String fileName) throws Throwable{
		//ExStart:searchQRCodeSignaturesInCells
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		CellsSearchQRCodeOptions searchOptions = new CellsSearchQRCodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify QRCode type to search only special encode type
		searchOptions.setEncodeType(QRCodeTypes.QR);
		    // specify QRCode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
			QRCodeSignature qcSignature = (QRCodeSignature)signature;
		    if(qcSignature != null)
		    {
		    	System.out.println("Found QRCode signature:"+qcSignature.getEncodeType().getTypeName()+" with text "+qcSignature.getText());
		    }
		}
		//ExEnd:searchQRCodeSignaturesInCells
	}
	
	public static void searchQRCodeSignaturesInImages(String fileName) throws Throwable{
		//ExStart:searchQRCodeSignaturesInImages
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		ImagesSearchQRCodeOptions searchOptions = new ImagesSearchQRCodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify QRCode type to search only special encode type
		searchOptions.setEncodeType(QRCodeTypes.QR);
		    // specify QRCode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
			QRCodeSignature qcSignature = (QRCodeSignature)signature;
		    if(qcSignature != null)
		    {
		    	System.out.println("Found QRCode signature:"+qcSignature.getEncodeType().getTypeName()+" with text "+qcSignature.getText());
		    }
		}
		//ExEnd:searchQRCodeSignaturesInImages
	}
	
	public static void searchQRCodeSignaturesInSlides(String fileName) throws Throwable{
		//ExStart:searchQRCodeSignaturesInSlides
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		SlidesSearchQRCodeOptions searchOptions = new SlidesSearchQRCodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify QRCode type to search only special encode type
		searchOptions.setEncodeType(QRCodeTypes.QR);
		    // specify QRCode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
			QRCodeSignature qcSignature = (QRCodeSignature)signature;
		    if(qcSignature != null)
		    {
		    	System.out.println("Found QRCode signature:"+qcSignature.getEncodeType().getTypeName()+" with text "+qcSignature.getText());
		    }
		}
		//ExEnd:searchQRCodeSignaturesInSlides
	}
	
	public static void searchQRCodeSignaturesInWords(String fileName) throws Throwable{
		//ExStart:searchQRCodeSignaturesInWords
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		WordsSearchQRCodeOptions searchOptions = new WordsSearchQRCodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		    // specify different pages to search
		searchOptions.getPagesSetup().setFirstPage(true);
		searchOptions.getPagesSetup().setLastPage(true);
		searchOptions.getPagesSetup().setOddPages(true);
		searchOptions.getPagesSetup().setEvenPages(true);
		    // specify QRCode type to search only special encode type
		searchOptions.setEncodeType(QRCodeTypes.QR);
		    // specify QRCode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.Contains);
		    // search document
		SearchResult result = handler.search(fileName, searchOptions);
		    // output signatures
		for(BaseSignature signature : result.getSignatures())
		{
			QRCodeSignature qcSignature = (QRCodeSignature)signature;
		    if(qcSignature != null)
		    {
		    	System.out.println("Found QRCode signature:"+qcSignature.getEncodeType().getTypeName()+" with text "+qcSignature.getText());
		    }
		}
		//ExEnd:searchQRCodeSignaturesInWords
	}
	
	public static void searchBarcodeSignatureWithProcessEvents(String fileName) throws Throwable{
		//ExStart:searchBarcodeSignatureWithProcessEvents
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		PdfSearchBarcodeOptions searchOptions = new PdfSearchBarcodeOptions();
		    // search only page with specified number
		searchOptions.setDocumentPageNumber(1);
		    // specify as true to search all pages of a document
		searchOptions.setSearchAllPages(true);
		    // specify barcode type to search only special encode type
		searchOptions.setEncodeType(BarcodeTypes.Code39Standard);
		    // specify barcode text to search
		searchOptions.setText("12345678");
		    // specify text math type
		searchOptions.setMatchType(TextMatchType.StartsWith);
		    
		handler.SearchStarted.add(new ProcessStartEventHandler() {
			public void invoke(Object sender, ProcessStartEventArgs args) {
		        System.out.println("Search started for "+args.getTotalSignatures()+"-page(s) in Document "+args.getGuid()+" started at " +String.valueOf(args.getStarted()));
		    }
		});		  
		handler.SearchProgress.add(new ProcessProgressEventHandler() {
			public void invoke(Object sender, ProcessProgressEventArgs args) {
		        System.out.println("Search "+args.getGuid()+" progress: "+args.getProgress()+" %. Processed  "+args.getProcessedSignatures()+" pages. Since start process spent "+args.getTicks()+" mlsec");
		    }
		});
		handler.SearchCompleted.add(new ProcessCompleteEventHandler() {
			public void invoke(Object sender, ProcessCompleteEventArgs args) {
		        System.out.println("Search "+args.getGuid()+" completed at "+String.valueOf(args.getCompleted())+". Processing of "+args.getTotalSignatures()+" pages took "+args.getTicks()+" mlsec");
		    }
		});		  
		    // search document
		SearchResult searchResult = handler.search(fileName, searchOptions);
		    // output signatures
		for (BaseSignature signature : searchResult.getSignatures())
		{
		    BarcodeSignature bcSignature = (BarcodeSignature)signature;
		    if (bcSignature != null)
		    {
		        System.out.println("Found Barcode signature: "+bcSignature.getEncodeType().getTypeName()+" with text " +bcSignature.getText() );
		    }
		}
		//ExEnd:searchBarcodeSignatureWithProcessEvents
	}
	
	public static void signDocumentWithCustomQRCodeData(String fileName) throws Throwable{
		//ExStart:signDocumentWithCustomQRCodeData
		// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		
		// setup custom object instance with required data
		DocumentSignature docSignature =new DocumentSignature();
		docSignature.setID(UUID.randomUUID().toString());
		docSignature.setAuthor("Mr.Sherlock");
		docSignature.setSigned(new java.util.Date());
		docSignature.setDataFactor(new java.math.BigDecimal("0.67"));
		
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup options
		PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions();
		// QR-code type
		signOptions.setEncodeType(QRCodeTypes.QR);		  
		// setup Data property with custom object
		signOptions.setData(docSignature);		    
		// save Options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = (String)handler.<String>sign(fileName, signOptions, saveOptions);
		//ExEnd:signDocumentWithCustomQRCodeData
	}
	
	public static void signDocumentWithEmbeddedVCardObjectToQRCode(String fileName) throws Throwable{
		//ExStart:signDocumentWithEmbeddedVCardObjectToQRCode
		// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
		// setup Signature configuration
				SignatureConfig signConfig = CommonUtilities.getConfiguration();
				
				// Setup VCard object
				VCard vcard =new VCard();
				vcard.setFirstName("Sherlock");
				vcard.setMidddleName("Jay");
				vcard.setLastName("Holmes");
				vcard.setInitials("Mr.");
				vcard.setCompany("Watson Inc.");
				vcard.setJobTitle("Detective");
				vcard.setHomePhone("0333 003 3577");
				vcard.setWorkPhone("0333 003 3512");
				vcard.setEmail("watson@sherlockholmes.com");
				vcard.setUrl("http://sherlockholmes.com/");
				vcard.setBirthDay(new Date(1854, 1, 6));
				    // Setup Address of Contant details
				vcard.setHomeAddress(new Address());
				vcard.getHomeAddress().setStreet("221B Baker Street");
				vcard.getHomeAddress().setCity("London");
				vcard.getHomeAddress().setState("NW");
				vcard.getHomeAddress().setZIP("NW16XE");
				vcard.getHomeAddress().setCountry("England");
				
				// instantiating the conversion handler
				SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
				
				// setup options
				PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions();
				// QR-code type
				signOptions.setEncodeType(QRCodeTypes.QR);		  
				// setup Data property with custom object
				signOptions.setData(vcard);		
				signOptions.setWidth(200);
				signOptions.setHeight(200);
				// save Options
				SaveOptions saveOptions =new SaveOptions();
				saveOptions.setOutputType(OutputType.String);
				saveOptions.setOutputFileName("signed_output");
				// sign document
				String signedPath = (String)handler.<String>sign(fileName, signOptions, saveOptions);
		//ExEnd:signDocumentWithEmbeddedVCardObjectToQRCode
	}
	
	public static void signDocumentWithEmbeddedEmailObjectToQRCode(String fileName) throws Throwable{
		//ExStart:signDocumentWithEmbeddedEmailObjectToQRCode
		// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
		// setup Signature configuration
				SignatureConfig signConfig = CommonUtilities.getConfiguration();
				
				// Setup Email object
				Email email =new Email();
				email.setAddress("watson@sherlockholmes.com");
				email.setSubject("Welcome email");
				email.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
				
				// instantiating the conversion handler
				SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
				
				// setup options
				PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions();
				// QR-code type
				signOptions.setEncodeType(QRCodeTypes.QR);	
				signOptions.setWidth(200);
				signOptions.setHeight(200);
				// setup Data property with custom object
				signOptions.setData(email);		    
				// save Options
				SaveOptions saveOptions =new SaveOptions();
				saveOptions.setOutputType(OutputType.String);
				saveOptions.setOutputFileName("signed_output");
				// sign document
				String signedPath = (String)handler.<String>sign(fileName, signOptions, saveOptions);
		//ExEnd:signDocumentWithEmbeddedEmailObjectToQRCode
	}
	
	public static void searchCustomObjectFromSignedPDF(String fileName) throws Throwable{
		//ExStart:searchCustomObjectFromSignedPDF
		// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup search options
		PdfSearchQRCodeOptions  searchOptions = new PdfSearchQRCodeOptions ();
		// specify as true to search all pages of a document
		searchOptions.setSearchAllPages(false);
		// search document
		SearchResult searchResult = handler.search(fileName, searchOptions);
		    // output signatures
		for (BaseSignature signature : searchResult.getSignatures())
		{
			PdfQRCodeSignature qrCodeSignature = (PdfQRCodeSignature)signature;
		    if (qrCodeSignature != null)
		    {
		        System.out.println("Found QRCode signature: " + qrCodeSignature.getEncodeType().getTypeName() + " with text " + qrCodeSignature.getText());
		  
		        DocumentSignature docSignature = qrCodeSignature.<DocumentSignature>getData(DocumentSignature.class);
		        if (docSignature != null)
		        {
		            System.out.println("Found DocumentSignature signature: #"+docSignature.getID()+". Author "+docSignature.getAuthor()+" from "+docSignature.getDataFactor()+". Factor: "+docSignature.getDataFactor());
		        }
		    }
		}
		//ExEnd:searchCustomObjectFromSignedPDF
	}
	
	public static void searchStandardVCardAndEmailObjectFromSignedPDF(String fileName) throws Throwable{
		//ExStart:searchStandardVCardAndEmailObjectFromSignedPDF
		// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
		// setup Signature configuration
				SignatureConfig signConfig = CommonUtilities.getConfiguration();
				// instantiating the conversion handler
				SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
				
				// setup search options
				PdfSearchQRCodeOptions  searchOptions = new PdfSearchQRCodeOptions ();
				// specify as true to search all pages of a document
				searchOptions.setSearchAllPages(false);
				// search document
				SearchResult searchResult = handler.search(fileName, searchOptions);
				    // output signatures
				for (BaseSignature signature : searchResult.getSignatures())
				{
					 PdfQRCodeSignature qrCodeSignature = (PdfQRCodeSignature)signature;
					    if (qrCodeSignature != null)
					    {
					        System.out.println("Found QRCode signature: "+qrCodeSignature.getEncodeType().getTypeName()+" with text " + qrCodeSignature.getText());
					  
					        VCard vcard = qrCodeSignature.<VCard>getData(VCard.class);
					        if (vcard != null)
					        {
					            System.out.println("Found VCard signature: "+vcard.getFirstName()+" "+vcard.getLastName()+" from "+vcard.getCompany()+". Email: " +vcard.getEmail());
					        }
					    }
				}
		//ExEnd:searchStandardVCardAndEmailObjectFromSignedPDF
	}
	
	public static void setBarcodeSignaturePositionOnCells(String fileName) throws Throwable{
		//ExStart:setBarcodeSignaturePositionOnCells
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// Specify Signature Options 
		CellsBarcodeSignOptions signOptions = new CellsBarcodeSignOptions("1234567");
		signOptions.setWidth(300);
		signOptions.setHeight(100);
		signOptions.setTop(15);
		signOptions.setLeft(22);
		// specify save options
		SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setBarcodeSignaturePositionOnCells
	}
	
	public static void setQRCodeSignaturePositionOnCells(String fileName) throws Throwable{
		//ExStart:setQRCodeSignaturePositionOnCells
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// Specify Signature Options 
		CellsQRCodeSignOptions signOptions = new CellsQRCodeSignOptions ("1234567");
		signOptions.setWidth(300);
		signOptions.setHeight(100);
		signOptions.setTop(15);
		signOptions.setLeft(22);
		// specify save options
		SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setQRCodeSignaturePositionOnCells
	}
	
	public static void verifyQRCodeInPDFWithoutEncodeType(String fileName) throws Throwable{
		//ExStart:verifyQRCodeInPDFWithoutEncodeType
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup verification options
		PDFVerifyQRCodeOptions verifyOptions = new PDFVerifyQRCodeOptions("12345678");
		// specify as true to verify all pages of a document
		verifyOptions.setVerifyAllPages(true); 
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification pdf file with Qrcode signature " + result.isValid());
		//ExEnd:verifyQRCodeInPDFWithoutEncodeType
	}
	
	public static void verifyEncryptedQRCodeInPDF(String fileName) throws Throwable{
		//ExStart:verifyEncryptedQRCodeInPDF
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup key and pasphrase
		String key = "1234567890";
		String salt = "1234567890";
		// create data encryption
		IDataEncryption encrypter = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
		// setup verification options
		PDFVerifyQRCodeOptions verifyOptions = new PDFVerifyQRCodeOptions("This is private text to be secured.");
		// specify as true to verify all pages of a document
		verifyOptions.setVerifyAllPages(true);
		// setup encrypter to retrieve original text
		verifyOptions.setDataEncryption(encrypter);
        //verify document
        VerificationResult result = handler.verify(fileName, verifyOptions);
        System.out.println("Verification pdf file with Qrcode signature " + result.isValid());
		//ExEnd:verifyEncryptedQRCodeInPDF
	}
	
	public static void exceptionHandlingWhileVerifyingQRCodeInPDF(String fileName) throws Throwable{
		//ExStart:exceptionHandlingWhileVerifyingQRCodeInPDF
		try{
			// setup Signature configuration
			SignatureConfig signConfig = CommonUtilities.getConfiguration();
			// instantiating the conversion handler
			SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
			// setup verification options
			PDFVerifyQRCodeOptions verifyOptions = new PDFVerifyQRCodeOptions("12345678");
			// specify as true to verify all pages of a document
			verifyOptions.setVerifyAllPages(true); 
	        //verify document
	        VerificationResult result = handler.verify(fileName, verifyOptions);
	        System.out.println("Verification pdf file with Qrcode signature " + result.isValid());
		}catch(GroupDocsSignatureException ex){
		    System.out.print("GroupDocs Signature Exception: " + ex.getMessage());
		}catch(Exception ex){
		    System.out.print("System Exception: " + ex.getMessage());
		}
		//ExEnd:exceptionHandlingWhileVerifyingQRCodeInPDF
	}
	
	public static void signCellsWithQRCodeMeasure(String fileName) throws Throwable{
		//ExStart:signCellsWithQRCodeMeasure
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		CellsQRCodeSignOptions signOptions = new CellsQRCodeSignOptions ("12345678");
	    // size
	    signOptions.setSizeMeasureType(MeasureType.Percents);
	    signOptions.setWidth(10);
	    signOptions.setHeight(10);	   
	    // position alignment
	    signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
	    signOptions.setVerticalAlignment(VerticalAlignment.Top);	   
	    // margin
	    signOptions.setMarginMeasureType(MeasureType.Percents);
	    signOptions.getMargin().setTop(25);
	     
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        // sign document
        String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
        System.out.println("Signed cells document with Qrcode" + signedPath);
		//ExEnd:signCellsWithQRCodeMeasure
	}
	
	public static void signCellsWithBarCodeMeasure(String fileName) throws Throwable{
		//ExStart:signCellsWithBarCodeMeasure
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		CellsBarcodeSignOptions signOptions = new CellsBarcodeSignOptions("12345678");		  
	     // size
	    signOptions.setSizeMeasureType(MeasureType.Percents);
	    signOptions.setWidth(10);
	    signOptions.setHeight(10);	  
	    // position alignment
	    signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
	    signOptions.setVerticalAlignment(VerticalAlignment.Top);	  
	    // margin
	    signOptions.setMarginMeasureType(MeasureType.Percents);
	    signOptions.getMargin().setTop(25);
	     
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        // sign document
        String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
        System.out.println("Signed cells document with barcode" + signedPath);
		//ExEnd:signCellsWithBarCodeMeasure
	}
}

