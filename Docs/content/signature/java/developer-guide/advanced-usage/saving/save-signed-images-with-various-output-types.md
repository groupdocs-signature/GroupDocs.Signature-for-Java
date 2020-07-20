---
id: save-signed-images-with-various-output-types
url: signature/java/save-signed-images-with-various-output-types
title: Save signed images with various output types
weight: 2
description: "This article explains how to save images with various image format types."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class supports saving of Image signed documents with various image format types and extended options.

Following classes are inherited from base class [SaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/SaveOptions) and allows to specify additional output image format settings.
*   [BmpSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/BmpSaveOptions) class allows to save signed image document to **BMP** image format and setup additional options ( like compression, resolutions, bits per pixel etc);
*   [GifSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/GifSaveOptions) class allows to save signed image document to **GIF **image format and setup additional options ( like compression, resolutions etc);
*   [JpegSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/JpegSaveOptions) class allows to save signed image document to **JPEG** image format and setup additional options ( like compression, resolutions, quality etc);
*   [PngSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/PngSaveOptions) class allows to save signed image document to **PNG** image format and setup additional options ( like bit depth, color type, compression, filters etc);
*   [TiffSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/TiffSaveOptions) class allows to save signed image document to **TIFF** image format and setup additional options

Here are the steps to save signed Image document to special image output type with additional settings with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Instantiate required signature options.    
*   Instantiate the one of required class of image format save options ([BmpSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/BmpSaveOptions), [GifSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/GifSaveOptions), [JpegSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/JpegSaveOptions), [PngSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/PngSaveOptions)[, TiffSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/TiffSaveOptions)) object according to your requirements and specify its properties.
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass signatureoptions and [SaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/SaveOptions) object to it.
    

## Save signed image as BMP

```java
Signature signature = new Signature("sample.jpg");
QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
signOptions.setEncodeType(QrCodeTypes.QR);
signOptions.setLeft(100);
signOptions.setTop(100);
 
// create Bmp save options with advanced settings
BmpSaveOptions bmpSaveOptions = new BmpSaveOptions();
bmpSaveOptions.setAddMissingExtenstion(true);
bmpSaveOptions.setCompression(BitmapCompression.Rgb);
bmpSaveOptions.setHorizontalResolution(7);
bmpSaveOptions.setVerticalResolution(7);
bmpSaveOptions.setBitsPerPixel(16);
bmpSaveOptions.setOverwriteExistingFiles(true);
 
signature.sign("signedSample", signOptions, bmpSaveOptions );
```

## Save signed image as GIF

```java
Signature signature = new Signature("sample.jpg");
QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
signOptions.setEncodeType(QrCodeTypes.QR);
signOptions.setLeft(100);
signOptions.setTop(100);
 
// create Gif save options with advanced settings
GifSaveOptions gifSaveOptions = new GifSaveOptions();
gifSaveOptions.setBackgroundColorIndex((byte)2);
gifSaveOptions.setColorResolution((byte) 7);
gifSaveOptions.setDoPaletteCorrection(true);
gifSaveOptions.setTrailer(true);
gifSaveOptions.setInterlaced(false);
gifSaveOptions.setPaletteSorted(true);
gifSaveOptions.setPixelAspectRatio((byte) 24);
gifSaveOptions.setAddMissingExtenstion(true);
 
 
signature.sign("signedSample", signOptions, bmpSaveOptions );
```

## Save signed image as JPEG

```java
Signature signature = new Signature("sample.jpg");
QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
signOptions.setEncodeType(QrCodeTypes.QR);
signOptions.setLeft(100);
signOptions.setTop(100);
 
// create Jpeg save options with advanced settings
JpegSaveOptions jpegSaveOptions = new JpegSaveOptions();
jpegSaveOptions.setAddMissingExtenstion(true);
jpegSaveOptions.setBitsPerChannel((byte) 8);
jpegSaveOptions.setColorType(JpegCompressionColorMode.Rgb);
jpegSaveOptions.setComment("signed jpeg file");
jpegSaveOptions.setCompressionType(JpegCompressionMode.Lossless);
jpegSaveOptions.setQuality(100);
jpegSaveOptions.setSampleRoundingMode(JpegRoundingMode.Extrapolate);
 
 
signature.sign("signedSample", signOptions, jpegSaveOptions);
```

## Save signed image as PNG

```java
Signature signature = new Signature("sample.jpg");
QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
signOptions.setEncodeType(QrCodeTypes.QR);
signOptions.setLeft(100);
signOptions.setTop(100);
 
// create png save options with advanced settings
PngSaveOptions pngSaveOptions = new PngSaveOptions();
pngSaveOptions.setBitDepth((byte) 8);
pngSaveOptions.setColorType(PngColorType.Grayscale);
pngSaveOptions.setCompressionLevel(9);
pngSaveOptions.setFilterType(PngFilterType.Adaptive);
pngSaveOptions.setProgressive(true);
pngSaveOptions.setAddMissingExtenstion(true);
 
 
signature.sign("signedSample", signOptions, pngSaveOptions );
```

## Save signed image as TIFF

```java
Signature signature = new Signature("sample.jpg");
QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
signOptions.setEncodeType(QrCodeTypes.QR);
signOptions.setLeft(100);
signOptions.setTop(100);
 
/// create tiff save options with advanced settings
TiffSaveOptions tiffSaveOptions = new TiffSaveOptions();
tiffSaveOptions.setExpectedTiffFormat(TiffFormat.TiffNoCompressionBw);
tiffSaveOptions.setAddMissingExtenstion(true);
 
 
signature.sign("signedSample", signOptions, tiffSaveOptions  );
```

## More resources

### GitHub Examples 

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Signature for .NET examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET)    
*   [GroupDocs.Signature for Java examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java)    
*   [Document Signature for .NET MVC UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-MVC)    
*   [Document Signature for .NET App WebForms UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-WebForms)    
*   [Document Signature for Java App Dropwizard UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Dropwizard)   
*   [Document Signature for Java Spring UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Spring)
    

### Free Online App 

Along with full-featured .NET library we provide simple, but powerful free Apps.  
You are welcome to eSign PDF, Word, Excel, PowerPoint documents with free to use online **[GroupDocs Signature App](https://products.groupdocs.app/signature)**.
