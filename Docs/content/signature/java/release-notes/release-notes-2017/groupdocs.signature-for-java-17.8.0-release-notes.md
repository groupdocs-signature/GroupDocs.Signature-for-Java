---
id: groupdocs-signature-for-java-17-8-0-release-notes
url: signature/java/groupdocs-signature-for-java-17-8-0-release-notes
title: GroupDocs.Signature for Java 17.8.0 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 17.8.0{{< /alert >}}

## Major Features

There are about 15 improvements, new features and fixes in this regular release. The most notable are:

*   Introduced Image file formats support for all existing Signature types. Since this version SignatureHandler class supports images as source documents for Signature or Verification features.
*   Implemented all existing standard properties support for Image Documents like positioning, alignment, applying Fonts, opacity, border options etc
*   Improved Stamp Signature with few additional abilities to specify different background options and setup color or image for these purposes.
*   Introduced Image Save Options with ability to convert output image document to most used image file formats like jpg, png, gif, tiff, svg etc.
*   Implemented verification of all existing Signature types (except Digital) for Image documents.
*   Improved signature process, update exception messages with localized strings
*   Optimized Input Data Handler usage for certificate and image resources
*   Improved Digital Signature for Open Office Words format files like odt or ott types

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-3000 | Implement QR-Code Signature Verification for Image Documents | New Feature |
| SIGNATURENET-2997 | Implement Barcode Signature Verification for Image Documents | New Feature |
| SIGNATURENET-2993 | Implement ability to save Image Documents in different formats | New Feature |
| SIGNATURENET-2990 | Implement Stamp Signature features for Image Documents | New Feature |
| SIGNATURENET-2987 | Implement QR-Code Signature features for Image Documents | New Feature |
| SIGNATURENET-2984 | Implement BarCode Signature features for Image Documents | New Feature |
| SIGNATURENET-2981 | Implement Image Signature features for Image Documents | New Feature |
| SIGNATURENET-2978 | Implement Text Signature features for Image Documents | New Feature |
| SIGNATURENET-2954 | Implement ability to repeat text for Stamp Signatures | New Feature |
| SIGNATURENET-2267 | Digital Signature for Open Document files format support | New Feature |
| SIGNATURENET-3021 | Implement ability to use Custom InputDataHandler for Certificates and Images resources | Improvement |
| SIGNATURENET-3013 | Add ability to crop background color by inner line for Stamp Signatures. | Improvement |
| SIGNATURENET-2959 | Add ability to crop background image by inner line for Stamp Signatures. | Improvement |
| SIGNATURENET-2943 | Implement Verification of Digital Signature Type for Pdf Documents | Improvement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 17.8.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Added scope of Options classes to support Image documents signature processing. New classes describes target properties for different Signature type of Image files - **ImagesSignTextOptions** - Text Signature properties, **ImagesSignImageOptions** - Image Signature, **ImagesBarcodeSignOptions** - keeps Barcode Options for Image files, **ImagesQRCodeSignOptions **\- QR-Code Signature options, **ImagesStampSignOptions** - Stamp Signature Options for Image files. See public API examples to work with Image files  
      
    
    **Sign Images document with Text Signature as image**
    
    ```java
     // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
     
      // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
      // setup text signature options
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
    saveOptions.setOutputFileName("Images_Text_AsImage");
     
      // sign document
    String signedPath = handler.<String>sign("test.png", signOptions, saveOptions);
    ```
    
    **Saving signed Images Documents with different output file type**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
     
      // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
      // setup text signature options
    SignOptions signOptions = new ImagesSignTextOptions("John Smith");
     
      //Webp
    ImagesSaveOptions optionsWebp = new ImagesSaveOptions();
    optionsWebp.setOutputType(OutputType.String);
    optionsWebp.setFileFormat(ImagesSaveFileFormat.Webp);
    optionsWebp.setOutputFileName("Images_WithDifferentOutputFileType_Webp");
    String signedPath = handler.<String>sign("test.png", signOptions, optionsWebp);
     
      // save to Jpeg format with specific options
    JpegSaveOptions saveOptionsJpeg = new JpegSaveOptions();
    saveOptionsJpeg.setOutputType(OutputType.String);
    saveOptionsJpeg.setColorType(JpegCompressionColorMode.Cmyk);
    saveOptionsJpeg.setCompressionType(JpegCompressionMode.Progressive);
    saveOptionsJpeg.setOutputFileName("Images_WithDifferentOutputFileType_Jpeg");
    signedPath = handler.<String>sign("test.png", signOptions, saveOptionsJpeg);
     
      // save to Bmp format with specific options
    BmpSaveOptions saveOptionsBmp = new BmpSaveOptions();
    saveOptionsBmp.setOutputType(OutputType.String);
    saveOptionsBmp.setCompression(BitmapCompression.Rgb);
    saveOptionsBmp.setHorizontalResolution(120);
    saveOptionsBmp.setVerticalResolution(120);
    saveOptionsBmp.setOutputFileName("Images_WithDifferentOutputFileType_Bmp");
    signedPath = handler.<String>sign("test.png", signOptions, saveOptionsBmp);
     
      // save to Tiff format with specific options
    TiffSaveOptions saveOptionsTiff = new TiffSaveOptions();
    saveOptionsTiff.setOutputType(OutputType.String);
    saveOptionsTiff.setExpectedTiffFormat(TiffFormat.TiffCcitRle);
    saveOptionsTiff.setOutputFileName("Images_WithDifferentOutputFileType_Tiff");
    signedPath = handler.<String>sign("test.png", signOptions, saveOptionsTiff);
    ```
    
    **Add Transparency and Rotation to Text Signature appearance**
    
    ```java
      // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
     
      // instantiating the conversion handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
      // setup text signature options
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
    saveOptions.setOutputFileName("Images_TextSignatureWatermark");
     
      // sign document
    String signedPath = handler.<String>sign("test.png", signOptions, saveOptions);
    ```
    
    **Signing Images Documents with Text Signature As Watermark**
    
    ```java
       // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
     
      // instantiating the conversion handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
      // setup text signature options
    ImagesSignTextOptions signOptions = new ImagesSignTextOptions("John Smith");
     
    signOptions.getFont().setFontSize(64);
    signOptions.getFont().setBold(true);
    signOptions.getFont().setItalic(true);
    signOptions.getFont().setUnderline(true);
    signOptions.setOpacity(0.7);
    signOptions.setForeColor(Color.getBlueViolet().getNativeObject());
     
      // type of implementation
    signOptions.setSignatureImplementation(ImagesTextSignatureImplementation.Watermark);
     
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("Images_TextSignatureWatermark");
     
      // sign document
    String signedPath = handler.<String>sign("test.png", signOptions, saveOptions);
    ```
    
    **Sign Images Documents examples**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
    signConfig.setImagesPath(IMAGES_PATH);
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     
    // setup image signature options
    ImagesSignImageOptions signOptions = new ImagesSignImageOptions("200x100.png");
     
    // setup save options
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("Images_ImageSignature");
    // sign document
    String signedPath = handler.<String>sign("test.png", signOptions, saveOptions);
    ```
    
    **Specify Margins and Alignment of Image Signature appearance on Document Page**
    
    ```java
      // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
    signConfig.setImagesPath(IMAGES_PATH);
      // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
      // setup image signature options
    ImagesSignImageOptions signOptions = new ImagesSignImageOptions("signature.jpg");
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
    saveOptions.setOutputFileName("Images_ImageSignature_MarginsAndAlignment");
     
      // sign document
    String signedPath = handler.<String>sign("test.png", signOptions, saveOptions);
    ```
    
    **Specify Adjustment Size, Margins and Intents of Image Signature**
    
    ```java
     // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
    signConfig.setImagesPath(IMAGES_PATH);
      // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     
    SignatureOptionsCollection collection = new SignatureOptionsCollection();
     
      //Percents
      // setup image signature options
    ImagesSignImageOptions signOptionsPercents = new ImagesSignImageOptions("signature.jpg");
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
    ImagesSignImageOptions signOptionsMillimeters = new ImagesSignImageOptions("signature.jpg");
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
    saveOptions.setOutputFileName("Images_ImageSignature_Adjustment");
     
      // sign document
    String signedPath = handler.<String>sign("test.png", collection, saveOptions);
    ```
    
    **Add Extended Options to Image Signature appearance**
    
    ```java
     // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
    signConfig.setImagesPath(IMAGES_PATH);
      // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
      //setup size and position
    ImagesSignImageOptions signOptions = new ImagesSignImageOptions("200x100.png");
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
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("Images_Image_Rotation_Opacity");
     
      // sign document
    String signedPath = handler.<String>sign("test.png", signOptions, saveOptions);
    ```
    
    **Signing Images Documents with Barcode Signature**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
      // instantiating the handler
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
     
    SaveOptions saveOptions=  new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("DocImages_BarCode");
     
      // sign document
    String signedPath = handler.<String>sign("test.png", collection, saveOptions);
    ```
    
    **Signing Images Documents with QR-code Signature**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
      // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     
    SignatureOptionsCollection collection = new SignatureOptionsCollection();
     
      // QRCode type Aztec
    ImagesQRCodeSignOptions signOptions = new ImagesQRCodeSignOptions("12345678");
    signOptions.setEncodeType(QRCodeTypes.AZTEC);
    signOptions.setHorizontalAlignment(HorizontalAlignment.None);
    signOptions.setVerticalAlignment(VerticalAlignment.None);
    collection.add(signOptions);
     
      // QRCode type DataMatrix
    signOptions = new ImagesQRCodeSignOptions("12345678");
    signOptions.setEncodeType(QRCodeTypes.DATA_MATRIX);
    signOptions.setTop(300);
    signOptions.setHorizontalAlignment(HorizontalAlignment.None);
    signOptions.setVerticalAlignment(VerticalAlignment.None);
    collection.add(signOptions);
     
      // QRCode type QR
    signOptions = new ImagesQRCodeSignOptions("12345678");
    signOptions.setEncodeType(QRCodeTypes.QR);
    signOptions.setHorizontalAlignment(HorizontalAlignment.None);
    signOptions.setVerticalAlignment(VerticalAlignment.None);
    signOptions.setTop(600);
    collection.add(signOptions);
     
    SaveOptions saveOptions =  new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("DocImages_QRCode");
     
      // sign document
    String signedPath = handler.<String>sign("test.png", collection, saveOptions);
    ```
    
    **Signing Images Documents with Stamp Signature.**
    
    ```java
     // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
      // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     
      // setup options
    ImagesStampSignOptions signOptions = new ImagesStampSignOptions();
    signOptions.setHeight(300);
    signOptions.setWidth(300);
     
    signOptions.setBackgroundColor(Color.ORANGE);
    signOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea); //This feature is supported starting from version 17.08
    signOptions.setImageGuid(CommonUtilities.imagePath +"300.png");
    signOptions.setBackgroundImageCropType(StampBackgroundCropType.InnerArea); //This feature is supported starting from version 17.08
     
      //Outer round lines
    StampLine line0 = new StampLine();
    line0.setText("* European Union *");
    line0.setTextRepeatType(StampTextRepeatType.FullTextRepeat); //This feature is supported starting from version 17.08
    line0.getFont().setFontSize(12);
    line0.setHeight(22);
    line0.setTextBottomIntent(6);
    line0.setTextColor(Color.GRAY);
    line0.setBackgroundColor(Color.BLUE);
    signOptions.getOuterLines().add(line0);
     
    StampLine line1 = new StampLine();
    line1.setHeight(2);
    line1.setBackgroundColor(Color.WHITE);
    signOptions.getOuterLines().add(line1);
     
    StampLine line2 = new StampLine();
    line2.setText("* Entrepreneur *");
    line2.setTextRepeatType(StampTextRepeatType.FullTextRepeat); //This feature is supported starting from version 17.08
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
    line4.setTextColor(Color.RED);
    line4.getFont().setFontSize(20);
    line4.getFont().setBold(true);
    line4.setHeight(40);
    signOptions.getInnerLines().add(line4);
     
    StampLine line5 = new StampLine();
    line5.setText("SSN 1230242424");
    line5.setTextColor(Color.RED);
    line5.getFont().setFontSize(12);
    line5.getFont().setBold(true);
    line5.setHeight(40);
    signOptions.getInnerLines().add(line5);
     
    SaveOptions saveOptions =  new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("DocImages_Stamp");
     
      // sign document
    String signedPath = handler.<String>sign("test.png", signOptions, saveOptions);
    ```
    
      
      
    
2.  For Verification purposes following Options classes were added to support verification of Image Files. **ImagesVerifyBarcodeOptions** - keeps options to verify Barcode Signature on Image files, **ImagesVerifyQRCodeOptions** - keeps options to verify QRcode Signature, Following examples demonstrates how to use Verification Options for Image Documents  
      
    
    **Verification Images Documents signed with Barcode Signature**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
      // instantiating the handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     
    VerifyOptionsCollection collection = new VerifyOptionsCollection();
     
      // setup verification options Code39Standard
    ImagesVerifyBarcodeOptions verifyOptions = new ImagesVerifyBarcodeOptions();
    verifyOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
    verifyOptions.setMatchType(TextMatchType.Exact);
    verifyOptions.setText("12345678");
    collection.add(verifyOptions);
     
      // setup verification options DutchKIX
    verifyOptions = new ImagesVerifyBarcodeOptions();
    verifyOptions.setEncodeType(BarcodeTypes.DUTCH_KIX);
    verifyOptions.setMatchType(TextMatchType.StartsWith);
    verifyOptions.setText("1234");
    collection.add(verifyOptions);
     
      // setup verification options DatabarLimited
    verifyOptions = new ImagesVerifyBarcodeOptions();
    verifyOptions.setEncodeType(BarcodeTypes.DATABAR_LIMITED);
    verifyOptions.setMatchType(TextMatchType.Contains);
    verifyOptions.setText("5678");
    collection.add(verifyOptions);
     
      //verify document
    VerificationResult result = handler.verify("SignedBarCode.png", collection);
    ```
    
    **Verification Images Documents signed with QR-code Signature**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(STORAGE_PATH);
    signConfig.setOutputPath(OUTPUT_PATH);
      // instantiating the signature handler
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
    VerificationResult result = handler.verify("SignedQRCode.png", collection);
    ```
    
      
      
    
3.  Added new enumeration type **StampBackgroundCropType** that specifies crop type of background layer on Stamp elements. **StampSignOptions** class was updated with two properties of this enumeration type **BackgroundColorCropType** to specify background color cropping on Stamp elements and **BackgroundImageCropType** to specify background image intersection with another elements.
4.  Added new enumeration type **StampTextRepeatType **to specify text repeating along Stamp line length.  **StampLine **class was updated with **StampTextRepeatType **property to setup Text repeat type.
5.  Implemented list of Save Image format types in enumeration **ImagesSaveFileFormat**, same as new Save Options classes were added to support different output image format types. Base class **ImagesSaveOptions** that contains save file format, following classes derive base ImagesSaveOptions class and keep properties for exact Image file format. **PngSaveOptions** - to save output image document in Png format, **JpegSaveOptions** - to save output in jpeg image format, **BmpSaveOptions** - supports bmp output file, **GifSaveOptions** keeps options for gif format,** TiffSaveOptions **keeps Tiff file format settings.
6.  Public classes TrialException, LicenseException and FileNotSupportedException were marked as Obsolete and will be removed in 4 releases. All Exceptions raised from library will have GroupDocsSigantureException type.
