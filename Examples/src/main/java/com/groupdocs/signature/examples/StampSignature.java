package com.groupdocs.signature.examples;

import java.awt.Color;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.enums.ExtendedDashStyle;
import com.groupdocs.signature.domain.stamps.StampLine;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.saveoptions.SaveOptions;
import com.groupdocs.signature.options.stampsignature.CellsStampSignOptions;
import com.groupdocs.signature.options.stampsignature.PdfStampSignOptions;
import com.groupdocs.signature.options.stampsignature.SlidesStampSignOptions;
import com.groupdocs.signature.options.stampsignature.WordsStampSignOptions;

public class StampSignature {

	public static void signCellDocWithStampSignature(String fileName) throws Throwable{
		//ExStart:signCellDocWithStampSignature
		// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup options
		CellsStampSignOptions signOptions = new CellsStampSignOptions();
		signOptions.setHeight(120);
		signOptions.setWidth(300);
		 
	    //Inner square lines
		StampLine line0 = new StampLine();
		line0.setText("John");
		line0.setTextBottomIntent(0);
		line0.setTextColor(Color.PINK);
		line0.getOuterBorder().setColor(Color.BLUE);
		line0.getInnerBorder().setColor(Color.BLUE);
		line0.getInnerBorder().setStyle(ExtendedDashStyle.Dash);
		line0.getFont().setFontSize(20);
		line0.getFont().setBold(true);
		line0.setHeight(40);
		signOptions.getInnerLines().add(line0);
		 
		StampLine line1 = new StampLine();
		line1.setText("Smith");
		line1.setTextBottomIntent(0);
		line1.setTextColor(Color.PINK);
		line1.getInnerBorder().setColor(Color.BLUE);
		line1.getFont().setFontSize(20);
		line1.getFont().setBold(true);
		line1.setHeight(40);
		signOptions.getInnerLines().add(line1);
		 
	    // if you need to sign all sheets set it to true
		signOptions.setSignAllPages(true);
		 
		SaveOptions saveOptions =  new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		 
	    // sign document
		String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: "+signedPath);
		//ExEnd:signCellDocWithStampSignature
	}
	
	public static void signPDFDocWithStampSignature(String fileName) throws Throwable{
		//ExStart:signPDFDocWithStampSignature
		// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup options
		PdfStampSignOptions signOptions = new PdfStampSignOptions();
		signOptions.setHeight(300);
		signOptions.setWidth(300);
		 
	    //Outer round lines
		StampLine line0 = new StampLine();
		line0.setText(" * European Union * European Union  * European Union  * European Union  * European Union  * ");
		line0.getFont().setFontSize(12);
		line0.setHeight(22);
		line0.setTextBottomIntent(6);
		line0.setTextColor(Color.LIGHT_GRAY);
		line0.setBackgroundColor(Color.BLUE);
		signOptions.getOuterLines().add(line0);
		 
		StampLine line1 = new StampLine();
		line1.setHeight(2);
		line1.setBackgroundColor(Color.WHITE);
		signOptions.getOuterLines().add(line1);
		 
		StampLine line2 = new StampLine();
		line2.setText("* Entrepreneur * Entrepreneur ** Entrepreneur * Entrepreneur *");
		line2.setTextColor(Color.BLUE);
		line2.getFont().setFontSize(15);
		line2.setHeight(30);
		line2.setTextBottomIntent(8);
		line2.getInnerBorder().setColor(Color.BLUE);
		line2.getOuterBorder().setColor(Color.BLUE);
		line2.getInnerBorder().setStyle(ExtendedDashStyle.Dot);
		signOptions.getOuterLines().add(line2);
		 
	    //Inner square lines
		StampLine line3 = new StampLine();
		line3.setText("John");
		line3.setTextColor(Color.RED);
		line3.getFont().setFontSize(20);
		line3.getFont().setBold(true);
		line3.setHeight(40);
		signOptions.getInnerLines().add(line3);
		 
		StampLine line4 = new StampLine();
		line4.setText("Smith");
		line4.setTextColor(Color.PINK);
		line4.getFont().setFontSize(20);
		line4.getFont().setBold(true);
		line4.setHeight(40);
		signOptions.getInnerLines().add(line4);
		 
		StampLine line5 = new StampLine();
		line5.setText("SSN 1230242424");
		line5.setTextColor(Color.MAGENTA);
		line5.getFont().setFontSize(12);
		line5.getFont().setBold(true);
		line5.setHeight(40);
		signOptions.getInnerLines().add(line5);
		 
	    // if you need to sign all sheets set it to true
		signOptions.setSignAllPages(true);
		 
		SaveOptions saveOptions =  new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		 
	    // sign document
		String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: "+signedPath);
		//ExEnd:signPDFDocWithStampSignature
	}
	
	public static void signSlidesDocWithStampSignature(String fileName) throws Throwable{
		//ExStart:signSlidesDocWithStampSignature
		// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup options
		SlidesStampSignOptions signOptions = new SlidesStampSignOptions();
		signOptions.setHeight(200);
		signOptions.setWidth(400);
		 
	    //Outer round lines
		StampLine line0 = new StampLine();
		line0.setText(" * John * Smith  * John * Smith  * John * Smith  * John * Smith  * John * Smith * John * Smith *  John * Smith * ");
		line0.getFont().setFontSize(12);
		line0.setHeight(22);
		line0.setTextBottomIntent(6);
		line0.setTextColor(Color.LIGHT_GRAY);
		line0.setBackgroundColor(Color.BLUE);
		signOptions.getOuterLines().add(line0);
		 
	    //Inner square lines
		StampLine line1 = new StampLine();
		line1.setText("John Smith");
		line1.setTextColor(Color.MAGENTA);
		line1.getFont().setFontSize(24);
		line1.getFont().setBold(true);
		line1.setHeight(100);
		signOptions.getInnerLines().add(line1);
		 
	    // if you need to sign all sheets set it to true
		signOptions.setSignAllPages(true);
		signOptions.setOpacity(0.8);
		 
		SaveOptions saveOptions =  new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		 
	    // sign document
		String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: "+signedPath);
		//ExEnd:signSlidesDocWithStampSignature
	}
	
	public static void signWordsDocWithStampSignature(String fileName) throws Throwable{
		//ExStart:signWordsDocWithStampSignature
		// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup options
		WordsStampSignOptions signOptions = new WordsStampSignOptions();
		signOptions.setHeight(300);
		signOptions.setWidth(300);
		 
		signOptions.setImageGuid(CommonUtilities.getImagesPath("sign.PNG"));
		signOptions.setBackgroundColor(Color.CYAN);
		 
	    //Inner square lines
		StampLine line0 = new StampLine();
		line0.setText("John");
		line0.setTextColor(Color.PINK);
		line0.getFont().setFontSize(20);
		line0.getFont().setBold(true);
		line0.setHeight(40);
		signOptions.getInnerLines().add(line0);
		 
		StampLine line1 = new StampLine();
		line1.setText("Smith");
		line1.setTextColor(Color.MAGENTA);
		line1.getFont().setFontSize(20);
		line1.getFont().setBold(true);
		line1.setHeight(40);
		signOptions.getInnerLines().add(line1);
		 
	    // if you need to sign all sheets set it to true
		signOptions.setSignAllPages(true);
		 
		SaveOptions saveOptions =  new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		 
	    // sign document
		String signedPath = handler.<String>sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: "+signedPath);
		//ExEnd:signWordsDocWithStampSignature
	}
}