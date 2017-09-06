package com.groupdocs.signature.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.VerifyOptions;
import com.groupdocs.signature.options.VerifyOptionsCollection;
import com.groupdocs.signature.options.digitalsignature.CellsSignDigitalOptions;
import com.groupdocs.signature.options.digitalsignature.PdfSignDigitalOptions;
import com.groupdocs.signature.options.digitalsignature.WordsSignDigitalOptions;
import com.groupdocs.signature.options.digitalverification.CellsVerifyDigitalOptions;
import com.groupdocs.signature.options.digitalverification.PDFVerifyDigitalOptions;
import com.groupdocs.signature.options.digitalverification.WordsVerifyDigitalOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;

public class DigitalSignature {

	public static void signCellDocsWithDigitalSignature(String fileName) throws Throwable{
		//ExStart:signCellDocsWithDigitalSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup digital signature options
		InputStream certificateStream = new FileInputStream(CommonUtilities.getCertificatePath("acer.pfx"));
		CellsSignDigitalOptions signOptions = new CellsSignDigitalOptions(certificateStream);
		signOptions.getSignature().setComments("Test comment");
		signOptions.getSignature().setSignTime(new Date(2017, 1, 25, 10, 41, 54));
		signOptions.setPassword("1234567890");
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.xlsx");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		//File stream must be closed after signing
		certificateStream.close();
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signCellDocsWithDigitalSignature
	}
	
	public static void signPdfDocsWithDigitalSignature(String fileName) throws Throwable{
		//ExStart:signPdfDocsWithDigitalSignature
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup digital signature options
		PdfSignDigitalOptions signOptions = new PdfSignDigitalOptions(new FileDescription(CommonUtilities.getCertificatePath("acer.pfx")), CommonUtilities.getImagesPath("sign.png"));
		signOptions.setReason("Test reason");
		signOptions.setContact("Test contact");
		signOptions.setLocation("Test location");
		//signOptions.setPassword("1234567890");
		// image position
		signOptions.setLeft(100);
		signOptions.setTop(100);
		signOptions.setWidth(100);
		signOptions.setHeight(100);
		signOptions.setDocumentPageNumber(1);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPdfDocsWithDigitalSignature
	}

	public static void signSlideDocsWithDigitalSignature(String fileName){
	//ExStart:signSlideDocsWithDigitalSignature
	//This feature will be added in future release
	//ExEnd:signSlideDocsWithDigitalSignature
	}

	public static void signWordDocsWithDigitalSignature(String fileName) throws Exception{
	//ExStart:signWordDocsWithDigitalSignature
	// setup Signature configuration
	SignatureConfig signConfig = CommonUtilities.getConfiguration();
	// instantiating the conversion handler
	SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
	// setup digital signature options
	WordsSignDigitalOptions signOptions = new WordsSignDigitalOptions(CommonUtilities.getCertificatePath("acer.pfx"));
	signOptions.getSignature().setComments("Test comment");
	signOptions.getSignature().setSignTime(new Date(2017, 1, 25, 10, 41, 54));
	//signOptions.setPassword("1234567890");
	final SaveOptions saveOptions = new SaveOptions();
	saveOptions.setOutputType(OutputType.String);
	saveOptions.setOutputFileName("signed_output.docx");
	// sign document
	String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
	System.out.println("Signed file path is: " + signedPath);
	//ExEnd:signWordDocsWithDigitalSignature
	}
	
	public static void signCellDocsWithCertificateContainer(String fileName) throws Exception{
	//ExStart:signCellDocsWithDigitalSignature
	// setup Signature configuration
	SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
	// instantiating the conversion handler
	SignatureHandler handler = new SignatureHandler(signConfig);
	// setup digital verification options
	CellsVerifyDigitalOptions verifyOptions = new CellsVerifyDigitalOptions(CommonUtilities.getCertificatePath("certificate.cer"));
	verifyOptions.setComments("Test1");
	verifyOptions.setSignDateTimeFrom(new Date(2017, 1, 26, 14, 55, 7));
	verifyOptions.setSignDateTimeTo(new Date(2017, 1, 26, 14, 55, 9));
	//verify document
	VerificationResult result = handler.verify(CommonUtilities.getStoragePath("pie chart.xlsx"), verifyOptions);
	System.out.println("Signed file verification result: " + result.isValid());
	//ExStart:signCellDocsWithDigitalSignature
	}
	
	public static void signCellDocsWithPfxCertificateContainer(String fileName) throws Exception{
		//ExStart:signCellDocsWithPfxCertificateContainer
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler handler = new SignatureHandler(signConfig);
		// setup digital verification options
		CellsVerifyDigitalOptions verifyOptions1 = new CellsVerifyDigitalOptions(CommonUtilities.getCertificatePath("acer.pfx"));
		//password is needed to open .pfx certificate
		verifyOptions1.setPassword("1234567890");
		CellsVerifyDigitalOptions verifyOptions2 = new CellsVerifyDigitalOptions(CommonUtilities.getCertificatePath("certificate.cer"));
		//VerifyOptionsCollection verifyOptionsCollection = new VerifyOptionsCollection(verifyOptions1, verifyOptions2);
		List<VerifyOptions> listOptions = new ArrayList<VerifyOptions>();
		listOptions.add(verifyOptions1);
		listOptions.add(verifyOptions2);
	    VerifyOptionsCollection verifyOptionsCollection =
	        new VerifyOptionsCollection(listOptions);
		//verify document
		VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptionsCollection);
		System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:signCellDocsWithPfxCertificateContainer
	}

	public static void signPdfDocsWithCertificateContainer(String fileName) throws Exception{
		//ExStart:signPdfDocsWithCertificateContainer
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler handler = new SignatureHandler(signConfig);
		// setup digital verification options
		PDFVerifyDigitalOptions verifyOptions = new PDFVerifyDigitalOptions(CommonUtilities.getCertificatePath("certificate.cer"));
		verifyOptions.setReason("Test reason");
		verifyOptions.setContact("Test contact");
		verifyOptions.setLocation("Test location");
		//verify document
		VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptions);
		System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:signPdfDocsWithCertificateContainer
	}

	public static void signPdfDocsWithPfxCertificateContainer(String fileName) throws Exception{
		//ExStart:signPdfDocsWithPfxCertificateContainer
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler handler = new SignatureHandler(signConfig);
		// setup digital verification options
		PDFVerifyDigitalOptions verifyOptions1 = new PDFVerifyDigitalOptions(CommonUtilities.getCertificatePath("acer.pfx"));
		//password is needed to open .pfx certificate
		verifyOptions1.setPassword("1234567890");
		PDFVerifyDigitalOptions verifyOptions2 = new PDFVerifyDigitalOptions(CommonUtilities.getCertificatePath("certificate.cer"));
		
		List<VerifyOptions> listOptions = new ArrayList<VerifyOptions>();
		listOptions.add(verifyOptions1);
		listOptions.add(verifyOptions2);
	    VerifyOptionsCollection verifyOptionsCollection =
	        new VerifyOptionsCollection(listOptions);
		//verify document
		VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptionsCollection);
		System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:signPdfDocsWithPfxCertificateContainer
	}

	public static void digitalVerificationOfSlideDoc(){
		//Feature will be available in new release of the API
	}

	public static void digitalVerificationOfWordDocWithCertificateContainer(String fileName) throws Exception{
		//ExStart:digitalVerificationOfWordDocWithCertificateContainer
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler handler = new SignatureHandler(signConfig);
		 
		VerifyOptionsCollection verifyOptionsCollection = new VerifyOptionsCollection();
		// setup digital verification options
		WordsVerifyDigitalOptions verifyOptions = new WordsVerifyDigitalOptions(CommonUtilities.getCertificatePath("certificate.cer"));
		verifyOptions.setComments("Test1");
		verifyOptions.setSignDateTimeFrom(new Date(2017, 1, 26, 14, 55, 57));
		verifyOptions.setSignDateTimeTo(new Date(2017, 1, 26, 14, 55, 59));
		
		//verify document
		VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptions);
		System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:digitalVerificationOfWordDocWithCertificateContainer
	}

	public static void digitalVerificationOfWordDocWithPfcCertificateContainer(String fileName) throws Exception{
		//ExStart:digitalVerificationOfWordDocWithPfcCertificateContainer
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler handler = new SignatureHandler(signConfig);
		// setup digital verification options
		WordsVerifyDigitalOptions verifyOptions1 = new WordsVerifyDigitalOptions(CommonUtilities.getCertificatePath("acer"));
		//password is needed to open .pfx certificate
		verifyOptions1.setPassword("1234567890");
		WordsVerifyDigitalOptions verifyOptions2 = new WordsVerifyDigitalOptions(CommonUtilities.getCertificatePath("certificate.cer"));
		
		List<VerifyOptions> listOptions = new ArrayList<VerifyOptions>();
		listOptions.add(verifyOptions1);
		listOptions.add(verifyOptions2);
	    VerifyOptionsCollection verifyOptionsCollection =
	        new VerifyOptionsCollection(listOptions);
		//verify document
		VerificationResult result = handler.verify(CommonUtilities.getStoragePath(fileName), verifyOptionsCollection);
		System.out.println("Signed file verification result: " + result.isValid());
		//ExEnd:digitalVerificationOfWordDocWithPfcCertificateContainer
	}
	
	
}