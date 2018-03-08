package com.groupdocs.signature.examples;

import java.awt.Color;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.ExtendedDashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.MeasureType;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.SignatureOptionsCollection;
import com.groupdocs.signature.options.appearances.ImageAppearance;
import com.groupdocs.signature.options.imagesignature.CellsSignImageOptions;
import com.groupdocs.signature.options.imagesignature.ImagesSignImageOptions;
import com.groupdocs.signature.options.imagesignature.PdfSignImageOptions;
import com.groupdocs.signature.options.imagesignature.SlidesSignImageOptions;
import com.groupdocs.signature.options.imagesignature.WordsSignImageOptions;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.saveoptions.CellsSaveOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;

public class ImageSignature {
	
	public static void signCellDocWithImage(String fileName) throws Exception {
		//ExStart:signCellDocWithImage
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		CellsSignImageOptions signOptions = new CellsSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		// image position
		signOptions.setRowNumber(10);
		signOptions.setColumnNumber(10);
		signOptions.setSignAllPages(true);
		signOptions.setDocumentPageNumber(1);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.xlsx");
		// sign document
		String signedPath = handler.<String> sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signCellDocWithImage
	}
	
	public static void signCellDocWithImageSpecifyMargins(String fileName) throws Exception{
	//ExStart:signCellDocWithImageSpecifyMargins
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		CellsSignImageOptions signOptions = new CellsSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		// specify horizontal alignment
		signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
		// specify vertical alignment
		signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
		// specify Margin
		signOptions.setMargin(new Padding(10));
		// specify separate left margin value
		signOptions.getMargin().setLeft(20);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.xlsx");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
	//ExEnd:signCellDocWithImageSpecifyMargins
	}
	
	public static void signPdfDocWithImage(String fileName) throws Exception{
		//ExStart:signPdfDocWithImage
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		PdfSignImageOptions signOptions = new PdfSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
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
		//ExEnd:signPdfDocWithImage
	}
	
	public static void signPdfDocWithImageSpecifyMargins(String fileName) throws Exception{
		//ExStart:signPdfDocWithImageSpecifyMargins
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
		// specify Margin
		signOptions.setMargin(new Padding(10));
		// specify separate left margin value
		signOptions.getMargin().setLeft(20);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPdfDocWithImageSpecifyMargins
	}
	
	public static void signPdfDocWithImageSpecifyIntents(String fileName) throws Exception{
		//ExStart:signPdfDocWithImageSpecifyIntents
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		PdfSignImageOptions signOptions = new PdfSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		// specify Size
		signOptions.setHeight(25);
		signOptions.setWidth(25);
		signOptions.setSizeMeasureType(MeasureType.Percents);
		// specify Margin
		signOptions.setMargin(new Padding(10));
		signOptions.setMarginMeasureType(MeasureType.Percents);
		// specify Intents
		signOptions.setTop(50);
		signOptions.setLeft(20);
		signOptions.setLocationMeasureType(MeasureType.Percents);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pdf");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPdfDocWithImageSpecifyIntents
	}

	public static void signSlideDocWithImage(String fileName) throws Exception{
		//ExStart:signSlideDocWithImage
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		SlidesSignImageOptions signOptions = new SlidesSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		signOptions.setLeft(10);
		signOptions.setTop(10);
		signOptions.setWidth(100);
		signOptions.setHeight(100);
		signOptions.setDocumentPageNumber(1);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pptx");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signSlideDocWithImage
	}

	public static void signSlideDocWithImageWithSpecifyMargins(String fileName) throws Exception{
		//ExStart:signSlideDocWithImageWithSpecifyMargins
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		SlidesSignImageOptions signOptions = new SlidesSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		// specify horizontal alignment
		signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
		// specify vertical alignment
		signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
		// specify Margin
		signOptions.setMargin(new Padding(10));
		// specify separate left margin value
		signOptions.getMargin().setLeft(20);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pptx");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signSlideDocWithImageWithSpecifyMargins
	}

	public static void signSlideDocWithImageSpecifyIntents(String fileName) throws Exception{
		//ExStart:signSlideDocWithImageSpecifyIntents
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		SlidesSignImageOptions signOptions = new SlidesSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		// specify Size
		signOptions.setHeight(25);
		signOptions.setWidth(25);
		signOptions.setSizeMeasureType(MeasureType.Percents);
		// specify Margin
		signOptions.setMargin(new Padding(10));
		signOptions.setMarginMeasureType(MeasureType.Percents);
		// specify Intents
		signOptions.setTop(50);
		signOptions.setLeft(20);
		signOptions.setLocationMeasureType(MeasureType.Percents);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.pptx");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signSlideDocWithImageSpecifyIntents
	}

	public static void signWordDocWithImage(String fileName) throws Exception{
		//ExStart:signWordDocWithImage
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		WordsSignImageOptions signOptions = new WordsSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
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
		//ExEnd:signWordDocWithImage
	}

	public static void signWordDocWithImageSpecifyMargins(String fileName) throws Exception{
		//ExStart:signWordDocWithImageSpecifyMargins
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options with relative path - image file stores in config.ImagesPath folder
		WordsSignImageOptions signOptions = new WordsSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		// specify horizontal alignment
		signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
		// specify vertical alignment
		signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
		// specify Margin
		signOptions.setMargin(new Padding(10));
		// specify separate left margin value
		signOptions.getMargin().setLeft(20);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.docx");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
	}

	public static void signWordDocWithImageSpecifyIntents(String fileName) throws Exception{
		//ExStart:signWordDocWithImageSpecifyIntents
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		WordsSignImageOptions signOptions = new WordsSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		// specify Size
		signOptions.setHeight(25);
		signOptions.setWidth(25);
		signOptions.setSizeMeasureType(MeasureType.Percents);
		// specify Margin
		signOptions.setMargin(new Padding(10));
		signOptions.setMarginMeasureType(MeasureType.Percents);
		// specify Intents
		signOptions.setTop(50);
		signOptions.setLeft(20);
		signOptions.setLocationMeasureType(MeasureType.Percents);
		final SaveOptions saveOptions = new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output.docx");
		// sign document
		String signedPath = handler.<String>sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signWordDocWithImageSpecifyIntents
	}
	
	public static void extendedOptionInImageSignature(String fileName) throws Exception{
		//ExStart:extendedOptionInImageSignature
		SignatureConfig signConfig = CommonUtilities.getConfiguration();     
        // instantiating the conversion handler
	    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
	    //setup size and position
        PdfSignImageOptions signOptions = new PdfSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
        signOptions.setLeft(100);
        signOptions.setTop(100);
        signOptions.setWidth(200);
        signOptions.setHeight(200);
        // setup rotation
        signOptions.setRotationAngle(48);
        //setup additional image appearance
        ImageAppearance imageAppearance = new ImageAppearance();
        imageAppearance.setBrightness(1.2f);
        imageAppearance.setGrayscale(true);
        imageAppearance.setBorderDashStyle(ExtendedDashStyle.Dot);
        imageAppearance.setBorderColor(Color.ORANGE);
        imageAppearance.setBorderWeight(5);
        signOptions.setAppearance(imageAppearance);
	    final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
	    String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
	    System.out.println("Signed file path is: " + signedPath);
	    //ExEnd:extendedOptionInImageSignature
	}
	
	public static void signArbitraryPagesOfDocumentWithImageSignature(String fileName) throws Exception{
		//ExStart:signArbitraryPagesOfDocumentWithImageSignature
		SignatureConfig signConfig = CommonUtilities.getConfiguration();     
        // instantiating the conversion handler
	    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
	    //setup size and position
        PdfSignImageOptions signOptions = new PdfSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
        // setup image size
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        // setup pages to sign
        signOptions.getPagesSetup().setFirstPage(true);
        signOptions.getPagesSetup().setEvenPages(true);
        signOptions.getPagesSetup().getPageNumbers().add(7);
        signOptions.getPagesSetup().getPageNumbers().add(9);
        signOptions.getPagesSetup().setLastPage(true);
        // specify load options
        LoadOptions loadOptions = new LoadOptions();
        // specify save options
        final CellsSaveOptions saveOptions = new CellsSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        // sign document
        String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, loadOptions, saveOptions);
	    System.out.println("Signed file path is: " + signedPath);
	    //ExEnd:signArbitraryPagesOfDocumentWithImageSignature
	}
	
	public static void signImageDocWithImage(String fileName) throws Exception {
		//ExStart:signImageDocWithImage
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		ImagesSignImageOptions signOptions = new ImagesSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		  
		// setup save options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signImageDocWithImage
	}
	
	public static void signImageDocWithMarginsAndAlignment(String fileName) throws Exception {
		//ExStart:signImageDocWithMarginsAndAlignment
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup image signature options
		ImagesSignImageOptions signOptions = new ImagesSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		  
		// specify horizontal alignment
		signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
		  // specify vertical alignment
		signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
		  // specify Margin
		signOptions.setMargin(new Padding(10));
		  // specify separate left margin value
		signOptions.getMargin().setLeft(20);
		  
		  // setup save options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signImageDocWithMarginsAndAlignment
	}
	
	public static void signImageDocWithSpecifiedAdjustmentSizeAndMargins(String fileName) throws Exception {
		//ExStart:signImageDocWithSpecifiedAdjustmentSizeAndMargins
		// setup Signature configuration
		SignatureConfig signConfig = CommonUtilities.getConfiguration();
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		SignatureOptionsCollection collection = new SignatureOptionsCollection();
		//Percents
		// setup image signature options
		ImagesSignImageOptions signOptionsPercents = new ImagesSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		 // specify Size
		signOptionsPercents.setHeight(25);
		signOptionsPercents.setWidth(25);
		  // specify size in percents of page size
		signOptionsPercents.setSizeMeasureType(MeasureType.Percents);
		  // specify Margin
		signOptionsPercents.setMargin(new Padding(10));
		  // specify margin in percents of page size
		signOptionsPercents.setMarginMeasureType(MeasureType.Percents);
		  // specify Intents
		signOptionsPercents.setTop(50);
		signOptionsPercents.setLeft(20);
		  // specify intents in percents of page size
		signOptionsPercents.setLocationMeasureType(MeasureType.Percents);
		collection.add(signOptionsPercents);
		  
		  //Millimeters
		  // setup image signature options
		ImagesSignImageOptions signOptionsMillimeters = new ImagesSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
		  // specify Size
		signOptionsMillimeters.setHeight(50);
		signOptionsMillimeters.setWidth(50);
		  // specify size in millimeters
		signOptionsMillimeters.setSizeMeasureType(MeasureType.Millimeters);
		  // specify Margin
		signOptionsMillimeters.setHorizontalAlignment(HorizontalAlignment.Right);
		signOptionsMillimeters.setVerticalAlignment(VerticalAlignment.Bottom);
		signOptionsMillimeters.setMargin(new Padding(20));
		  // specify margin in millimeters
		signOptionsMillimeters.setMarginMeasureType(MeasureType.Millimeters);
		collection.add(signOptionsMillimeters);
		  
		  // setup save options
		SaveOptions saveOptions =new SaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), collection, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signImageDocWithSpecifiedAdjustmentSizeAndMargins
	}
	
	public static void signImageWithExtendedOptionInImageSignature(String fileName) throws Exception{
		//ExStart:signImageWithExtendedOptionInImageSignature
		SignatureConfig signConfig = CommonUtilities.getConfiguration();     
        // instantiating the conversion handler
	    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
	    //setup size and position
	    ImagesSignImageOptions signOptions = new ImagesSignImageOptions(CommonUtilities.getImagesPath("sign.png"));
        signOptions.setLeft(100);
        signOptions.setTop(100);
        signOptions.setWidth(200);
        signOptions.setHeight(200);
          // setup rotation
        signOptions.setRotationAngle(48);
          // setup opacity
        signOptions.setOpacity(0.88);
          //setup additional image appearance
        ImageAppearance imageAppearance = new ImageAppearance();
        imageAppearance.setBrightness(1.2f);
        imageAppearance.setGrayscale(true);
        imageAppearance.setBorderDashStyle(ExtendedDashStyle.Dot);
        imageAppearance.setBorderColor(Color.ORANGE);
        imageAppearance.setBorderWeight(5);
        signOptions.setAppearance(imageAppearance);
        
    	// setup save options
	    SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("signed_output");
        
        // sign document
	    String signedPath = handler.sign(CommonUtilities.getStoragePath(fileName), signOptions, saveOptions);
	    System.out.println("Signed file path is: " + signedPath);
	    //ExEnd:signImageWithExtendedOptionInImageSignature
	}

}
