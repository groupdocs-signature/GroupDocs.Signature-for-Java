package com.groupdocs.signature.examples;

import java.awt.Color;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.ExtendedDashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.digitalsignature.PdfSignDigitalOptions;
import com.groupdocs.signature.options.imagesignature.PdfSignImageOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;
import com.groupdocs.signature.options.textsignature.PdfSignTextOptions;
import com.groupdocs.signature.options.textsignature.WordsSignTextOptions;

/*import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.ExtendedDashStyle;
import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.domain.HorizontalAlignment;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.VerticalAlignment;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.PdfSignDigitalOptions;
import com.groupdocs.signature.options.PdfSignImageOptions;
import com.groupdocs.signature.options.PdfSignTextOptions;
import com.groupdocs.signature.options.SaveOptions;
import com.groupdocs.signature.options.WordsSignTextOptions;*/



public class OtherOperations {
	public static void setUpFontAndColorOptions(String fileName) throws Exception {
		//ExStart:setUpFontAndColorOptions
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
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setUpFontAndColorOptions
	}
	
	public static void setUpBackgroundAndBorderOptions(String fileName) throws Exception{
		//ExStart:setUpBackgroundAndBorderOptions
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		WordsSignTextOptions signOptions = new WordsSignTextOptions("John Smith");
		// setup background settings
		signOptions.setBackgroundColor(Color.GRAY);
		signOptions.setBackgroundTransparency(0.5);
		// setup border settings
		signOptions.setBorderColor(Color.BLACK);
		signOptions.setBorderDashStyle(ExtendedDashStyle.DashDot);
		signOptions.setBorderWeight(1.2);
		signOptions.setBorderTransparency(0.5);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setUpBackgroundAndBorderOptions
	}

	public static void setUpSignatureMargins(String fileName) throws Exception{
		//ExStart:setUpImageSignatureMargins
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		WordsSignTextOptions signOptions = new WordsSignTextOptions("John Smith");
		// setup Signature area Size
		signOptions.setLeft(100);
		signOptions.setTop(100);
		signOptions.setWidth(200);
		signOptions.setHeight(200);
		// setup Signature area Margins
		signOptions.setMargin(new Padding(10));
		// specify separate left margin value
		signOptions.getMargin().setLeft(20);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setUpImageSignatureMargins
	}

	public static void setUpImageSignatureArea(String fileName) throws Exception{
		//ExStart:setUpImageSignatureArea
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		PdfSignImageOptions signOptions = new PdfSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		// specify horizontal alignment to the right
		signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
		// specify vertical alignment
		signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:setUpImageSignatureArea
	}
	
	public static void alignSignatureOnDocPage(String fileName) throws Throwable{
		//ExStart:alignSignatureOnDocPage
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup digital signature options
		PdfSignDigitalOptions signOptions = new PdfSignDigitalOptions(new FileDescription(CommonUtilities.getCertificatePath("acer.pfx")), CommonUtilities.getImagesPath("sign.png"));
		signOptions.setPassword("1234567890");
		// image position to locate on right bottom corner with small margins
		signOptions.setHorizontalAlignment(HorizontalAlignment.Right); // only Margin.Right value will be used to shift the Signature rectangle
		signOptions.setVerticalAlignment(VerticalAlignment.Bottom); // only Margin.Bottom value will be used to shift the Signature rectangle
		signOptions.getMargin().setRight(10);
		signOptions.getMargin().setBottom(10);
		// Page Number
		signOptions.setDocumentPageNumber(1);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExStart:alignSignatureOnDocPage
	}

}
