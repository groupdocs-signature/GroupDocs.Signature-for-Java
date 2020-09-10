---
id: groupdocs-signature-for-java-20-9-release-notes
url: signature/java/groupdocs-signature-for-java-20-9-release-notes
title: GroupDocs.Signature for Java 20.9 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 20.9{{< /alert >}}

## Major Features

This release contains implemented features on ability to obtain Barcode and QR-code signatures image content when creating electronic signatures or searching for them, new enhancements on storing and retrieving signature metadata information, ability to process Presentation documents with electronic digital signatures such as sign document with certificates, verify and search Presentation files for digital signatures, ability to add native Word processing Watermark signature, obtain with document common information the list of electronic digital signatures in it, fixed few bugs and issues.  Below the list of most notable changes in release of GroupDocs.Signature for Java 20.9:

*	Full featured JSON serialization and de-serialization support was implemented. This feature allows to serialize into QR-code and metadata signatures any level of complexity classes with sub classes properties etc.
*	QR-code electronic signature was extended with image data content.
*	Barcode electronic signature was extended with image data content.
*	Signature information was updated with creation and modification dates of signature.
*	Fixed issues with creating digital sigantures on password protected PDF documents
*	Digital signatures are not valid for password protected PDF documents
*	Fixed few bugs with creating and searching QR-code electronic signatures
*	Added ability to sign Presentation documents with digital electronic signatures with certificate pfx files.
*	Implemented verification of Presentation document for valid digital signatures
*	Involved support of searching digital signatures with Presentation files
*	Improved and added few data conversion methods when working with Metadata signatures
*	Fixed few issues with result of SignResult data
*	Added XAdES identification when searching for digital signatures in the Spreadsheet documents
*	Fixed few bugs with saving open office document format types
*	Fixed bug with processing Spreadsheet files while digital signing
*	Added ability to add native Watermark signature for Word Processing documents.
*	Implemented AES encryption algorithm for Net Standard platform
*	Improved modification of Watermark object for Word processing document files
*	Introduced ability to obtain information about electronic digital signatures in the document over one method to retrieve all document information
*	Improved validation for various text implementation signatures
*	Added ability to rotate signature on the image document with free angle
*	Fixed few bugs with processing QR-code signatures
      
    

Full List of Issues Covering all Changes in this Release 

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-2788 | Involve full featured JSON serialization and de-serialization support	| Feature |
| SIGNATURENET-2611 | Extend QR-code Signature with image data content | Feature |
| SIGNATURENET-2610 | Extend Barcode Signature with image data content  | Feature |
| SIGNATURENET-2438 | Implement ability to store creation and update date for signatures | Feature |
| SIGNATURENET-2794 | Digital signatures are not valid for password protected PDF documents | Bug |
| SIGNATURENET-2793 | Incorrect Text signature appearance with right allignment for PDF documents | Bug |
| SIGNATURENET-2790 | QR-Code signatures without left and top margins on image are not recognized | Bug |
| SIGNATURENET-2787 | Exception occurs when creating QRCode signature with non latin char-set characters | Bug |
| SIGNATURENET-2808 | Implement support of verification for digital signatures for presentations document types | Feature |
| SIGNATURENET-2806 | Implement support of search for digital signatures for presentations document types | Feature |
| SIGNATURENET-2803 | Implement support of digital signing for presentations document types | Feature |
| SIGNATURENET-2724 | Implement Metadata values convertion across various types | Feature |
| SIGNATURENET-2837 | Implement property XAdES for Digital Signature | Improvement |
| SIGNATURENET-2811 | Set up additional properties for digital signatures in SignResult | Improvement |
| SIGNATURENET-2789 | Remove support of signing .PSD files | Improvement |
| SIGNATURENET-2560 | Implement support XAdES signatures for Spreadsheet documents for .Net Standard | Improvement |
| SIGNATURENET-2280 | Update using Transparency property of Text and Image Options | Improvement |
| SIGNATURENET-2836 | XAdES type is not defined when reading signed Spreadsheet documents with XAdES signatures | Bug |
| SIGNATURENET-2798 | Wrong page calculations for .ott document | Bug |
| SIGNATURENET-2797 | Exception when trying to sign Spreadsheet files with Pfx certificate | Bug |
| SIGNATURENET-2796 | Trial message is cut off for Image documents | Bug |
| SIGNATURENET-2881 | Implement native Watermark signature for Word Processing documents | Feature |
| SIGNATURENET-2879 | Implement AES encryption algorithm for Net Standard platform | Feature |
| SIGNATURENET-2878 | Implement modification of native Watermark sugantures for Word processing documents | Feature |
| SIGNATURENET-2637 | Implement ability to keep digital signature meta info layer for Document Info | Feature |
| SIGNATURENET-2443 | Improve Validation for unsupported text implementation scenarios | Improvement |
| SIGNATURENET-2315 | Update implementation of signature rotation for Image documents | Improvement |
| SIGNATURENET-2906 | Unexpected recognition of QR-code on some images | Bug |
| SIGNATURENET-2882 | Exception on Word Processing document with obtaining watermark properties. | Bug |
| SIGNATURENET-2837 | Document content is changed after saving for OTT files | Bug |



## Public API and Backward Incompatible Changes

#### Public class [BarcodeSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BarcodeSignature) was updated with new properties and ability to contain Barcode image content.

Public class [BarcodeSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BarcodeSignature) was updated with new properties.

*	new property [getFormat()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BarcodeSignature#getFormat()) of type [FileType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/FileType) was added to specify the original image data format;
*	new property byte[] [getContent()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BarcodeSignature#getContent()) was added to keep original Barcode image raw data content
Since 20.9 version there's ability to grab content of Barcode signatures. To enable this feature the property [getReturnContent()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions#getReturnContent()) of [BarcodeSearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions) must be set to true. Also there is ability to specify output image content format type over property [getReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions#getReturnContentType()).

**New properties of BarcodeSignature**

```java
/**
 * <p>
 * Contains Barcode Signature properties.
 * </p>
 */
public class BarcodeSignature extends BaseSignature
{  
   
	/**
	 * <p>
	 * Specifies the format of Barcode signature image.
	 * </p>
	 */ 
	 public final FileType getFormat()    

	/**
	 * <p>
	 * Specifies Barcode binary data image content of type {@code Format}({@link #getFormat}/{@link #setFormat(FileType)}).
	 * By default this property will not be set. 
	 * </p>
	 */ 
	 public final byte[] getContent()  
}
```

Following example demonstrates how to specify Barcode Search with various options to grab Barcode image content

**Search document for Barcode signature content**

```java
 // initialize Signature instance 
	Signature signature = new Signature(filePath);
	BarcodeSearchOptions options = new BarcodeSearchOptions();
	options.setAllPages(true); // this value is set by default
	// single page number
	options.setPageNumber(1);
	// setup extended search in pages setup
	PagesSetup pagesSetup  = new PagesSetup() ;
	pagesSetup.setFirstPage(true);
	pagesSetup.setLastPage(true);
	pagesSetup.setOddPages(false);
	pagesSetup.setEvenPages(false);
	options.setPagesSetup(pagesSetup);

	// specify special barcode type to search
	options.setEncodeType(BarcodeTypes.Code39Standard);
	// specify text match type
	options.setMatchType(TextMatchType.Contains);
	// specify text pattern to search
	options.setText("12345678");
	// set field for barcode images returning
	options.setReturnContent(true);

	// search for signatures in document
	List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class, options);

	System.out.print("\nSource document contains following signatures.");
	for (BarcodeSignature barcodeSignature : signatures) {
		System.out.print("Barcode signature found at page " + barcodeSignature.getPageNumber() + " with type " + barcodeSignature.getEncodeType() + " and text " + barcodeSignature.getText());
		System.out.print("Barcode signature size "+barcodeSignature.getContent().length+" and format " + barcodeSignature.getFormat().getExtension());
}
```

#### Public class [BaseSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BaseSignature) was updated with new properties to keep creation and modification dates.

Public class [BaseSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BaseSignature) was updated with new properties.

*	new property [setCreatedOn()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BaseSignature#setCreatedOn(java.util.Date)) of type Date was added to specify the date when signature was created;
*	new property [setModifiedOn()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BaseSignature#setModifiedOn(java.util.Date)) of type Date was added to specify the date when signature was updated
Since 20.9 version there's ability to grab content of Barcode signatures. To enable this feature the property [getReturnContent()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions#getReturnContent()) of [BarcodeSearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions) must be set to true. Also there is ability to specify output image content format type over property [getReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions#getReturnContentType()).

**New properties of BaseSignature**

```java
/**
 * <p>
 * Describes base class for signatures.
 * </p>
 */
public abstract class BaseSignature implements ICloneable
{   
    /**
     * <p>
     * Get or set the signature creation date.
     * </p>
     */ 
     public final Date getCreatedOn();
    /**
     * <p>
     * Get or set the signature creation date.
     * </p>
     */ 
     public final void setCreatedOn(Date value)  ;  

    /**
     * <p>
     * Get or set the signature modification date.
     * </p>
     */ 
     public final Date getModifiedOn();
    /**
     * <p>
     * Get or set the signature modification date.
     * </p>
     */ 
     public final void setModifiedOn(Date value);    
}


```

Following example demonstrates how to check signature dates of creation and modification


```java
 // initialize Signature instance
Signature signature = new Signature(filePath);
try 
{
    // setup search options
 ImageSearchOptions searchOptions = new ImageSearchOptions();
 searchOptions.setAllPages(true);

    // search document
 List<ImageSignature> signatures = signature.search(ImageSignature.class,searchOptions);
 System.out.print("\nSource document ['"+fileName+"'] contains following image signature(s).");
    // output signatures
    try
    {
        for (ImageSignature imageSignature : signatures)
        {
            System.out.print("Image signature found at page "+imageSignature.getPageNumber()+" with size "+imageSignature.getSize()+". Created "+imageSignature.getCreatedOn()+", modified "+imageSignature.getModifiedOn());
        }
    }
    catch (Exception ex)
    {
        System.out.print("System Exception: " + ex.getMessage());
    }
}
catch (Exception ex)
{
    System.out.print("System Exception: " + ex.getMessage());
}
```

#### Public class [QrCodeSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/QrCodeSignature) was updated with new properties and ability to contain QrCode image content.

Public class QrCodeSignature was updated with new properties.

*	new property [getFormat](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/QrCodeSignature#getFormat()) of type [FileType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/FileType) was added to specify the original image data format;
*	new property byte[] [getContent](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/QrCodeSignature#getContent()) was added to keep original QRCode image raw data content
Since 20.9 version there's ability to grab content of QRCode signatures. To enable this feature the property [getReturnContent()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/QrCodeSearchOptions#getReturnContent()) of [QrCodeSearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/QrCodeSearchOptions) must be set to true. Also there is ability to specify output image content format type over property [getReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/QrCodeSearchOptions#getReturnContentType()).

 **New properties of QrCodeSignature**
 
```java
/**
 * <p>
 * Contains QR-code signature properties.
 * </p>
 */
public class QrCodeSignature extends BaseSignature
{   

	/**
	 * <p>
	 * Specifies the format of QR-code signature image.
	 * </p>
	 */ 
	 public final FileType getFormat()

	/**
	 * <p>
	 * Specifies QR-code binary data image content of type {@code Format}({@link #getFormat}/{@link #setFormat(FileType)}).
	 * By default this property will not be set. 
	 * </p>
	 */ 
	 public final byte[] getContent()   
}
```

Following example demonstrates how to specify QRCode Search with various options to grab QRCode image content

**Search document for QrCode signature content**

```java
Signature signature = new Signature(filePath);
QrCodeSearchOptions options = new QrCodeSearchOptions();
	options.setAllPages(true); // this value is set by default
// single page number
options.setPageNumber(1);
// setup extended search in pages setup
PagesSetup pagesSetup  = new PagesSetup() ;
pagesSetup.setFirstPage(true);
pagesSetup.setLastPage(true);
pagesSetup.setOddPages(false);
pagesSetup.setEvenPages(false);

options.setPagesSetup(pagesSetup);

// specify special barcode type to search
options.setEncodeType(QrCodeTypes.QR);
// specify text match type
options.setMatchType(TextMatchType.Exact);
// specify text pattern to search
options.setText("12345678");
// set field for barcode images returning
options.setReturnContent(true);

// search for signatures in document
List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, options);
System.out.print("\nSource document contains following signatures.");
for (QrCodeSignature qrCodeSignature : signatures)
{
    System.out.print("QRCode signature found at page "+qrCodeSignature.getPageNumber() +" with type "+qrCodeSignature.getEncodeType() +" and text "+ qrCodeSignature.getText());
    System.out.print("QRCode signature size "+qrCodeSignature.getContent().length+" and format "+ qrCodeSignature.getFormat().getExtension());
}
```

#### Public class [BarcodeSearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions) was updated with new properties for getting Barcode image content.

Public class BarcodeSearchOptions was updated with new properties.

*	new property boolean [setReturnContent()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions#setReturnContent(boolean)) was added to specify if returned Barcode signatures objects should keep original or converted (if property [setReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions#setReturnContentType(com.groupdocs.signature.domain.documentpreview.FileType)) was specified) Barcode image raw data. By default this value is set to false. 
*	new property [setReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/BarcodeSearchOptions#setReturnContentType(com.groupdocs.signature.domain.documentpreview.FileType)) of [FileType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/FileType) type was added to specify non default returned Barcode image content type. By default this value is set to null that means original Barcode image format will be returned.

**New properties of BarcodeSearchOptions**

```java
/**
 * <p>
 * Represents abstract search Options for Barcode signatures.
 * </p>
 */
public class BarcodeSearchOptions extends SearchOptions
{
    

/**
 * <p>
 * Gets or sets flag to grab Barcode image content of signature on document page.
 * If this flag is set true, Barcode signature image content will keep raw image data by required format {@code ReturnContentType}({@link #getReturnContentType}/{@link #setReturnContentType(FileType)}).
 * By default this option is disabled.
 * </p>
 */
 
 public final boolean getReturnContent()
 
 public final void setReturnContent(boolean value)
   

/**
 * <p>
 * Specifies file type of returned image content of the Barcode signature when ReturnContent property is enabled.
 * By default it set to Null. That means to return Barcode image content in original format. 
 * This image format is specified at {@code BarcodeSignature.Format}({@link BarcodeSignature#getFormat}/{@link BarcodeSignature#setFormat(FileType)})
 * Possible supported values are: FileType.JPEG, FileType.PNG, FileType.BMP. 
 * If provided format is not supported than Barcode image content in .png format will be returned.
 * </p>
 */ 
 public final FileType getReturnContentType()    
 
 public final void setReturnContentType(FileType value)
}
```

Following example demonstrates how to specify Barcode Search with various options to grab Barcode image content

**Search document for Barcode signature content**

```java
Signature signature = new Signature(filePath);
BarcodeSearchOptions options = new BarcodeSearchOptions();
options.setAllPages(true); // this value is set by default
// single page number
options.setPageNumber(1);
        // setup extended search in pages setup
PagesSetup pagesSetup  = new PagesSetup() ;
pagesSetup.setFirstPage(true);
pagesSetup.setLastPage(true);
pagesSetup.setOddPages(false);
pagesSetup.setEvenPages(false);
options.setPagesSetup(pagesSetup);

// specify special barcode type to search
options.setEncodeType(BarcodeTypes.Code39Standard);
// specify text match type
options.setMatchType(TextMatchType.Contains);
// specify text pattern to search
options.setText("12345678");
// set field for barcode images returning
options.setReturnContent(true);

// search for signatures in document
List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class, options);

System.out.print("\nSource document contains following signatures.");
for (BarcodeSignature barcodeSignature : signatures) {
    System.out.print("Barcode signature found at page " + barcodeSignature.getPageNumber() + " with type " + barcodeSignature.getEncodeType() + " and text " + barcodeSignature.getText());
    System.out.print("Barcode signature size "+barcodeSignature.getContent().length+" and format " + barcodeSignature.getFormat().getExtension());
}
```

#### Public class [BarcodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/BarcodeSignOptions) was updated with new properties for getting Barcode image content.

Public class [BarcodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/BarcodeSignOptions) was updated with new properties.

*	new property boolean [setReturnContent()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/BarcodeSignOptions#setReturnContent(boolean)) was added to specify if returned Barcode signatures objects in [SignResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/SignResult) should keep original or converted (if property [setReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/BarcodeSignOptions#setReturnContentType(com.groupdocs.signature.domain.documentpreview.FileType)) was specified) Barcode image raw data. By default this value is set to false. 
*	new property [setReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/BarcodeSignOptions#setReturnContentType(com.groupdocs.signature.domain.documentpreview.FileType)) of [FileType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/FileType) type was added to specify non default returned Barcode image content type. By default this value is set to null that means original Barcode image format will be returned.

**New properties of BarcodeSignOptions**

```java
/**
 * <p>
 * Represents the Barcode signature options.
 * </p>
 */
public class BarcodeSignOptions extends TextSignOptions
{
    
/**
 * <p>
 * Gets or sets flag to get Barcode image content of a signature which was put on document page.
 * If this flag is set true, Barcode signature image content will keep raw image data by required format {@code ReturnContentType}({@link #getReturnContentType}/{@link #setReturnContentType(FileType)}).
 * By default this option is disabled.
 * </p>
 */ 
 public final boolean getReturnContent(){ return auto_ReturnContent; }
    
 public final void setReturnContent(boolean value)
  

/**
 * <p>
 * Specifies file type of returned image content of the Barcode signature when ReturnContent property is enabled.
 * By default it set to Null. That means to return Barcode image content in original format. 
 * This image format is specified at {@code BarcodeSignature.Format}({@link BarcodeSignature#getFormat}/{@link BarcodeSignature#setFormat(FileType)})
 * Possible supported values are: FileType.JPEG, FileType.PNG, FileType.BMP. 
 * If provided format is not supported than Barcode image content in .png format will be returned.
 * </p>
 */ 
 public final FileType getReturnContentType()
   
 public final void setReturnContentType(FileType value)
  
}


```

Following example demonstrates how to specify Barcode Sign with various options to get Barcode image content in SignResult

```java
Signature signature = new Signature(filePath);
// create barcode option with predefined barcode text
BarcodeSignOptions signOptions = new BarcodeSignOptions("12345678");

// setup Barcode encoding type
signOptions.setEncodeType(BarcodeTypes.Code128);
// set signature position
signOptions.setLeft(100);
signOptions.setTop(100);
// when VerticalAlignment is set the Top coordinate will be ignored.
// Use Margin properties Top, Bottom to provide vertical offset
signOptions.setVerticalAlignment(VerticalAlignment.Top);
// when HorizontalAlignment is set the Left coordinate will be ignored.
// Use Margin properties Left, Right to provide horizontal offset
signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setLeft(20);
padding.setTop(20);
signOptions.setMargin(padding);
// adjust signature appearance
// setup signature border
Border border = new Border();
border.setColor(Color.GREEN);
border.setDashStyle(DashStyle.DashLongDashDot);
border.setWeight(2);
border.setTransparency(0.5);
border.setVisible(true);
signOptions.setBorder(border);
// set text color and Font
signOptions.setForeColor(Color.RED);
SignatureFont font = new SignatureFont();
font.setSize(12);
font.setFamilyName("Comic Sans MS");
signOptions.setFont(font);
// specify position of text with barcode line
signOptions.setCodeTextAlignment(CodeTextAlignment.Above);
// setup background
Background background = new Background();
background.setColor(Color.GREEN);
background.setTransparency(0.5);
background.setBrush(new LinearGradientBrush(Color.GREEN, Color.DARK_GRAY, 0));
signOptions.setBackground(background);

// set field for barcode images returning
signOptions.setReturnContent(true);
// specify type of returned barcode images
signOptions.setReturnContentType(FileType.PNG);

// sign document to file

SignResult signResult = signature.sign(outputFilePath, signOptions);
// analyzing result
System.out.print("List of newly created signatures:");
int number = 1;
for(BaseSignature o : signResult.getSucceeded()) {
    BarcodeSignature barcodeSignature = (BarcodeSignature) o;
    System.out.print("Signature #" + number++ + ": Type: " + barcodeSignature.getSignatureType() + " Id:" + barcodeSignature.getSignatureId() +
            ",Location: " + barcodeSignature.getLeft() + "x" + barcodeSignature.getTop() + ". Size: " + barcodeSignature.getWidth() + "x" + barcodeSignature.getHeight());
    String outputImagePath = new File(Constants.OutputPath, "image" + number + barcodeSignature.getFormat().getExtension()).getPath();
    OutputStream os = new FileOutputStream(outputImagePath);
    // Starts writing the bytes in it
 os.write(barcodeSignature.getContent());
    // Close the file
 os.close();
    System.out.print("\nSource document signed successfully.\nFile saved at" + outputFilePath);
}


```

#### Public class [QrCodeSearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/QrCodeSearchOptions) was updated with new properties for getting Barcode image content.

Public class QrCodeSearchOptions was updated with new properties.

*	new property boolean [setReturnContent()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/QrCodeSearchOptions#setReturnContent(boolean)) was added to specify if returned QrCode signatures objects should keep original or converted (if property [setReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/QrCodeSearchOptions#setReturnContentType(com.groupdocs.signature.domain.documentpreview.FileType)) was specified)  QrCode image raw data. By default this value is set to false. 
*	new property [setReturnContentType()]() of [FileType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/FileType) type was added to specify non default returned QrCode image content type. By default this value is set to null that means original QrCode image format will be returned.

**New properties of QrCodeSearchOptions**

```java

/**
 * <p>
 * Represents abstract search Options for QR-Code signatures.
 * </p>
 */
public class QrCodeSearchOptions extends SearchOptions
{
   
/**
 * <p>
 * Gets or sets flag to grab QR-Code image content of signature on document page.
 * If this flag is set true, QR-Code signature image content will keep raw image data by required format {@code ReturnContentType}({@link #getReturnContentType}/{@link #setReturnContentType(FileType)}).
 * By default this option is disabled.
 * </p>
 */ 
 public final boolean getReturnContent()
    
 public final void setReturnContent(boolean value)
    

/**
 * <p>
 * Specifies file type of returned image content of the QR-Code signature when ReturnContent property is enabled.
 * By default it set to Null. That means to return QR-Code image content in original format. 
 * This image format is specified at {@code QrCodeSignature.Format}()
 * Possible supported values are: FileType.JPEG, FileType.PNG, FileType.BMP. 
 * If provided format is not supported than QR-Code image content in original .png will be returned.
 * </p>
 */ 
 public final FileType getReturnContentType()
    
 public final void setReturnContentType(FileType value)
   
}

```

 Following example demonstrates how to specify QrCode Search with various options to grab QrCode image content

**Search document for QrCode signature content**

```java
// initialize Signature instance

Signature signature = new Signature(filePath);
QrCodeSearchOptions options = new QrCodeSearchOptions();
options.setAllPages(true); // this value is set by default
// single page number
options.setPageNumber(1);
// setup extended search in pages setup
PagesSetup pagesSetup  = new PagesSetup() ;
pagesSetup.setFirstPage(true);
pagesSetup.setLastPage(true);
pagesSetup.setOddPages(false);
pagesSetup.setEvenPages(false);
options.setPagesSetup(pagesSetup);

// specify special barcode type to search
options.setEncodeType(QrCodeTypes.QR);
// specify text match type
options.setMatchType(TextMatchType.Exact);
// specify text pattern to search
options.setText("12345678");
// set field for barcode images returning
options.setReturnContent(true);

// search for signatures in document
List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, options);
System.out.print("\nSource document contains following signatures.");
for (QrCodeSignature qrCodeSignature : signatures)
{
    System.out.print("QRCode signature found at page "+qrCodeSignature.getPageNumber() +" with type "+qrCodeSignature.getEncodeType() +" and text "+ qrCodeSignature.getText());
    System.out.print("QRCode signature size "+qrCodeSignature.getContent().length+" and format "+ qrCodeSignature.getFormat().getExtension());
}

```

#### Public class [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions) was updated with new properties for getting Barcode image content.

Public class [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions) was updated with new properties.

*	new property boolean [setReturnContent()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions#setReturnContent(boolean)) was added to specify if returned QrCode signatures objects in SignResult should keep original or converted (if property [setReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions#setReturnContentType(com.groupdocs.signature.domain.documentpreview.FileType)) was specified) QrCode image raw data. By default this value is set to false. 
*	new property [setReturnContentType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions#setReturnContentType(com.groupdocs.signature.domain.documentpreview.FileType)) of [FileType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/FileType) type was added to specify non default returned QrCode image content type. By default this value is set to null that means original QrCode image format will be returned.

**New properties of QrCodeSignOptions**

```java
/**
 * <p>
 * Represents the QR-Code signature options.
 * </p>
 */
public class QrCodeSignOptions extends TextSignOptions
{   

/**
 * <p>
 * Gets or sets flag to get QR-Code image content of a signature which was put on document page.
 * If this flag is set true, QR-Code signature image content will keep raw image data by required format {@code ReturnContentType}({@link #getReturnContentType}/{@link #setReturnContentType(FileType)}).
 * By default this option is disabled.
 * </p>
 */ 
 public final boolean getReturnContent()
   
 public final void setReturnContent(boolean value)

/**
 * <p>
 * Specifies file type of returned image content of the QR-Code signature when ReturnContent property is enabled.
 * By default it set to Null. That means to return QR-Code image content in original format. 
 * This image format is specified at {@code QrCodeSignature.Format}({@link QrCodeSignature#getFormat}/{@link QrCodeSignature#setFormat(FileType)})
 * Possible supported values are: FileType.JPEG, FileType.PNG, FileType.BMP. 
 * If provided format is not supported than QR-Code image content in .png format will be returned.
 * </p>
 */
 
 public final FileType getReturnContentType()

 public final void setReturnContentType(FileType value)
}
```

Following example demonstrates how to specify QrCode Sign with various options to get QrCode image content in SignResult

**Sign document and get QrCode signature content**

```java
// initialize Signature instance

Signature signature = new Signature(filePath);
// create QRCode option with predefined QRCode text
QrCodeSignOptions signOptions = new QrCodeSignOptions("12345678");

// setup QRCode encoding type
signOptions.setEncodeType(QrCodeTypes.QR);
// set signature position
signOptions.setLeft(100);
signOptions.setTop(100);

// set signature alignment

// when VerticalAlignment is set the Top coordinate will be ignored.
// Use Margin properties Top, Bottom to provide vertical offset
signOptions.setVerticalAlignment(VerticalAlignment.Top);

// when HorizontalAlignment is set the Left coordinate will be ignored.
// Use Margin properties Left, Right to provide horizontal offset
signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setRight(20);
padding.setTop(20);
signOptions.setMargin(padding);

// adjust signature appearance

// setup signature border
Border border = new Border();
border.setColor(Color.GREEN);
border.setDashStyle(DashStyle.DashLongDashDot);
border.setWeight(2);
border.setTransparency(0.5);
border.setVisible(true);
signOptions.setBorder(border);

// set text color and Font
signOptions.setForeColor(Color.RED);
SignatureFont font = new SignatureFont();
font.setSize(12);
font.setFamilyName("Comic Sans MS");
signOptions.setFont(font);

// setup background
Background background = new Background();
background.setColor(Color.GREEN);
background.setTransparency(0.5);
background.setBrush(new LinearGradientBrush(Color.GREEN, Color.DARK_GRAY, 0));
signOptions.setBackground(background);

// set field for barcode images returning
signOptions.setReturnContent(true);
// specify type of returned barcode images
signOptions.setReturnContentType(FileType.PNG);

// sign document to file
SignResult signResult = signature.sign(outputFilePath, signOptions);
// analyzing result
System.out.print("List of newly created signatures:");
int number = 1;
for(BaseSignature o : signResult.getSucceeded())
{
    QrCodeSignature  qrSignature = (QrCodeSignature) o;
    System.out.print("Signature #"+ number++ +": Type: "+qrSignature.getSignatureType()+" Id:"+qrSignature.getSignatureId()+
            ",Location: "+qrSignature.getLeft()+"x"+qrSignature.getTop()+". Size: "+qrSignature.getWidth()+"x"+qrSignature.getHeight());

    String outputImagePath = new File(Constants.OutputPath, "image" + number + qrSignature.getFormat().getExtension()).getPath();
    OutputStream os = new FileOutputStream(outputImagePath);
    // Starts writing the bytes in it
 os.write(qrSignature.getContent());
    // Close the file
 os.close();
}
```

#### Public class  [DigitalSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/DigitalSignature) was updated with new properties and ability to set XAdES type. Supported only for Spreadsheets documents.

Public class DigitalSignature was updated with new property.

*	new property [setXAdESType()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/DigitalSignature#setXAdESType(int)) of type [XAdESType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/XAdESType) was added to specify alternative digital signature format XML Advanced Electronic Signature (see more details here [XAdES on Wiki](https://en.wikipedia.org/wiki/XAdES));

**New properties of DigitalSignature**

```java

/**
 * <p>
 * Contains Digital signature properties.
 * </p>
 */
public class DigitalSignature extends BaseSignature
{    

/**
 * <p>
 * XAdES type. Default value is None (XAdES is off).
 * At this moment XAdES signature type is supported only for Spreadsheet documents.
 * </p>
 */ 
 public final int getXAdESType()
    
 public final void setXAdESType(int value)
}
    

```

Following example demonstrates how to sign document with digital signature providing selected XAdES type.

**Sign document with Digital signature**

```java

Signature signature = new Signature("sample.xlsx");
{
    DigitalSignOptions options = new DigitalSignOptions("certificate.pfx");
    {
        // set XAdES type
        options.setXAdESType(XAdESType.XAdES);
        // certificate password
        options.setPassword("1234567890");
        // digital certificate details
        options.setReason("Sign");
        options.setContact("JohnSmith");
        options.setLocation("Office1");
    };

    SignResult signResult = signature.sign("signedXades.xlsx", options);
    System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath);

    System.out.print("\nList of newly created signatures:");
    int number = 1;
    for (BaseSignature temp : signResult.getSucceeded())
    {
        System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId());
    }
}
```

#### Public class [MetadataSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature) was updated with new conversion methods to retrieve its values with various data types.

Public class MetadataSignature was updated with new data conversion methods

*	new method [toSingle()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature#toSingle()) converts metadata signature value to float;
*	new method [toSingle(Locale provider)](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature#toSingle(java.util.Locale)) converts metadata signature value to float based provided format provider;
All inherited classes ([ImageMetadataSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.metadata/ImageMetadataSignature), [PdfMetadataSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.metadata/PdfMetadataSignature), [PresentationMetadataSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.metadata/PresentationMetadataSignature), [SpreadsheetMetadataSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.metadata/SpreadsheetMetadataSignature), [WordProcessingMetadataSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.metadata/WordProcessingMetadataSignature)) are extended with there methods.

**New methods of MetadataSignature**

```java

/**
 	* <p>
 	* Contains Metadata signature properties.
 	* </p>
 	*/
    public abstract class MetadataSignature extends BaseSignature
    {
        /**
 		* <p>
 		* Converts to float.
 		* </p>
 		* @return Returns the Metadata Signature value as float.
 		* <p><hr>Throws an exception if the Metadata value could not be converted.
 		* If original value is string based the default culture property info will be used from SignatureSettings properties {@code SignatureSettings.DefaultCulture}()
 		* </hr></p>
 		*/
		public float toSingle();

		/**
 		* <p>
 		* Converts to float.
 		* </p>
 		* @return Returns the Metadata Signature value as float.
 		* @param provider Format data provider to use with data conversion operations.
 		* <p><hr>Throws an exception if the Metadata value could not be converted</hr></p>
 		*/
		public  float toSingle(java.util.Locale provider);

 }

```

#### Public class [PdfDigitalSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/PdfDigitalSignature) property String [getAuthority()](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/PdfDigitalSignature#getAuthority()) was marked as deprecated and will be removed since 20.10 version.


**PdfDigitalSignature properties**

```java

/**
 * <p>
 * Contains Pdf Digital signature properties.
 * </p>
 */
public class PdfDigitalSignature extends DigitalSignature
{
    /**
     * <p>
     * The name of the person or authority signing the document.
     * </p>
     * <p style="color:red">This property is deprecated and will be removed in the future release (GroupDocs.Signature 20.10).</p>
     */    
    public final String getAuthority();
    /**
     * <p>
     * The name of the person or authority signing the document.
     * </p>
     * <p style="color:red">This property is deprecated and will be removed in the future release (GroupDocs.Signature 20.10).</p>
     */   
    public final void setAuthority(String value);
}  

```

#### Public class [TextSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions) was updated with new property for document specific signatures. Supported only for text watermarks for WordProcessing documents yet.

Public class [TextSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions) was updated with new property.

*	new property [setNative](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions#setNative(boolean)) of type boolean was added to specify document specific signatures implementations. Now it influences only text watermarks for WordProcessing, but it's application area could be widened soon.

**New properties of TextSignOptions**

```java


/**
 * <p>
 * Represents the Text signature options.
 * </p>
 */
public class TextSignOptions extends SignOptions
    {
       /**
 		* <p>
 		* Gets or sets the native attribute. If it is set document specific signatures could be used.
 		* Native text watermark for WordProcessing documents is different than regular, for example.
 		* </p>
 		*/		
		public final boolean getNative();
		

		/**
		 * <p>
 		* Gets or sets the native attribute. If it is set document specific signatures could be used.
 		* Native text watermark for WordProcessing documents is different than regular, for example.
 		* </p>
 		*/		
		public final void setNative(boolean value);
   }


```

Following example demonstrates how to sign document with document specific signatures implementation of text watermark.

**Sign WordProcessing document with native Watermark**

```java


 
Signature signature = new Signature("sample.docx");

TextSignOptions options = new TextSignOptions("John Smith Watermark");
{
    // set attribute of using document specific implementation
    options.setNative(true);
    //Watermark will be the same for each page
    options.setSignatureImplementation(TextSignatureImplementation.Watermark);

    // set text color and Font
    options.setForeColor(Color.red);

    SignatureFont signatureFont =  new SignatureFont ();
    signatureFont.setSize(72);
    signatureFont.setFamilyName("Comic Sans MS");
    options.setFont (signatureFont);
    // set rotation
    // If rotation angle is not 0 it will be converted to 315.
    options.setRotationAngle(45);

    // set transparency
    // If transparency is not 0 it will be converted to 50%.
    options.setTransparency(0.9);
};

SignResult signResult = signature.sign("output.docx", options);
System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at ");

System.out.print("\nList of newly created signatures:");
int number = 1;
for (BaseSignature temp : signResult.getSucceeded())
{
    System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId());
}

```
