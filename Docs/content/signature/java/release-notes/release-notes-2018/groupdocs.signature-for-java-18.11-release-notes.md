---
id: groupdocs-signature-for-java-18-11-release-notes
url: signature/java/groupdocs-signature-for-java-18-11-release-notes
title: GroupDocs.Signature for Java 18.11 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 18.11{{< /alert >}}

## Major Features

There are about 38 improvements, new features and fixes in this regular release. Most new features are related to cells positioning that was improved to support pixels locations,improvements of cells positioning, implementation of different measure types for Cells signature options,introduced Metadata Signature type implementation for signing and searching for Pdf Documents. Text Signature options were updated with ability to align text inside signature area. Verification process of QR-Code Signatures was adjusted to support encrypted text and optional encode types. Process events arguments were updated to support ability to cancel signature, verification or search workaround. Summary the most notable changes are:

*   Introduced ability to align Text for all supported Document file formats
*   Implemented ability to verify encrypted QR-Code Signatures for all file types
*   Verification process was improved to use Barcode and QR-Code type as optional not required value
*   Added ability to specify Barcode and QR-Code fore color
*   Fixed QR-Code rendering with various options values
*   Optimized verification processing for QR-Code Signatures
*   Introduced ability to search for Digital signatures of Words Documents with additional criteria
*   Implemented ability to cancel running process for Signature, Verification and Search routines, same as ability to check if process was cancelled
*   Updated positioning of Stamp text
*   Introduced support of all Measure type units for Cells documents, improved Cells document signatures positioning
*   Extended search process for Words Documents with extended properties for Digital Signatures
*   Fixed few issues with QR-Code Signature rendering
*   Introduced Metadata Signature singing features for Pdf Documents
*   Implemented Search for Metadata Signatures in Pdf Documents
*   Added standard Pdf Metadata Signatures that describe main document properties
*   Implemented Pdf save document format for Images
*   Introduced Match Type feature for Text Verification
*   Fixed few bugs with Pdf Digital signatures
*   Fixed few issues with QR-Code Signature rendering

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-3516 | Implement ability to set text alignment inside shapes for Words documents | New Feature |
| SIGNATURENET-3514 | Implement ability to set text alignment inside shapes for Slides documents | New Feature |
| SIGNATURENET-3512 | Implement ability to set text alignment inside shapes for PDF documents | New Feature |
| SIGNATURENET-3510 | Implement ability to set text alignment inside shapes for Images documents | New Feature |
| SIGNATURENET-3507 | Implement ability to verify encrypted Text of QR-Code Signatures | New Feature |
| SIGNATURENET-3486 | Implement ability to set text alignment inside shapes for Cells documents | New Feature |
| SIGNATURENET-3481 | Implement ability to set signature position in Cells with pixels | New Feature |
| SIGNATURENET-3524 | Implement ability to verify QR-Code Signatures without required QR-Code Encode type | Improvement |
| SIGNATURENET-3522 | Implement ability to verify Barcode Signatures without required Barcode Encode type | Improvement |
| SIGNATURENET-3480 | Implement global Exception handler to catch all unhandled exceptions | Improvement |
| SIGNATURENET-3468 | Implement setting color of QR-code code text with fore color value | Improvement |
| SIGNATURENET-3467 | Implement setting color of Bar-code code text with fore color value | Improvement |
| SIGNATURENET-3523 | Fix exception on QR-Code Signature Verification when options has no Encode Type specified | Bug |
| SIGNATURENET-3520 | Wrong text alignment in Text Signature shape for Words | Bug |
| SIGNATURENET-3466 | Wrong QRCode rendering for various settings | Bug |
| SIGNATURENET-3568 | Implement additional search criteria for Digital Signatures of Words Documents | New Feature |
| SIGNATURENET-3533 | Implement ability for cancellation of Search process | New Feature |
| SIGNATURENET-3530 | Implement ability for cancellation of Verification process | New Feature |
| SIGNATURENET-3527 | Implement ability for cancellation of Signing process | New Feature |
| SIGNATURENET-3526 | Implement text positioning for Stamp Signatures. | New Feature |
| SIGNATURENET-3483 | Implement support of Measure Type Units for Cells positioning | New Feature |
| SIGNATURENET-3463 | Implement additional search criteria for Digital Signatures of Cells Documents | New Feature |
| SIGNATURENET-3570 | Implement support of several Words Digital Search Options | Improvement |
| SIGNATURENET-3566 | Implement support of several Cells Digital Search Options | Improvement |
| SIGNATURENET-3480 | Implement global Exception handler to catch all unhandled exceptions | Improvement |
| SIGNATURENET-3578 | Wrong border appearance for PDF Text as Image signatures | Bug |
| SIGNATURENET-3563 | Fix QR-Code positioning when Signature area is more than generated QR-Code | Bug |
| SIGNATURENET-3562 | Fix freezing of Signature process on Image Documents for QR-Code Signature | Bug |
| SIGNATURENET-3652 | Implement standard Pdf Metadata Signatures | New Feature |
| SIGNATURENET-3650 | Add PDF save format for image documents | New Feature |
| SIGNATURENET-3647 | Implement Searching for Metadata Signature in PDF Documents | New Feature |
| SIGNATURENET-3643 | Implement Metadata Signature features for PDF Documents | New Feature |
| SIGNATURENET-3637 | Implement Metadata Signature entity and collection | New Feature |
| SIGNATURENET-3635 | Implement MatchType for text verification options | New Feature |
| SIGNATURENET-3632 | Incorrect signing image documents with .psd format | Bug |
| SIGNATURENET-3628 | The output PDF is incorrectly signed with Digital Certificates | Bug |
| SIGNATURENET-3626 | Incorrect signing image documents with .wmf format | Bug |
| SIGNATURENET-3624 | Incorrect signing image documents with .svg format | Bug |
| SIGNATURENET-3622 | Unable to search Digital signature in Cells with extended options using latest release | Bug |
| SIGNATURENET-3621 | SizeMeasureType property is not working for CellsStampSignOptions in latest release | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 18.11. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  **Introduced ability to locate Signatures for Cells documents with pixel coordinates for all signature types. **Cells signature options for all types support both properties to specify horizontal coordinate **ColumnNumber** and **Left**. These properties are mutually exclusive. This means when **ColumnNumber** is set to value the **Left** property will be reset to 0. When **Left** property is set the **ColumnNumber** property will be reset to zero value. Same behavior implemented for **RowNumber** and **Top** properties.
    
    **Properties**
    
    ```java
    /**
     * <p>
     * Gets or sets the position of the top edge of the Signature area in pixels.
     * This property is mutually exclusive with Row property. If Top property is set RowNumber will be reset to 0.
     * </p>
     */
    public int getTop() {}
    /**
     * <p>
     * Gets or sets the position of the top edge of the Signature area in pixels.
     * This property is mutually exclusive with Row property. If Top property is set RowNumber will be reset to 0.
     * </p>
     */
    public void setTop(int value) {}
     
     
    private int _left;
    /**
     * <p>
     * Gets or sets the position of the left edge of the Signature area in pixels.
     * This property is mutually exclusive with Column property. If Left property is set ColumnNumber will be reset to 0.
     * </p>
     */
    public int getLeft() {}
    /**
     * <p>
     * Gets or sets the position of the left edge of the Signature area in pixels.
     * This property is mutually exclusive with Column property. If Left property is set ColumnNumber will be reset to 0.
     * </p>
     */
    public void setLeft(int value) {}
    ```
    
    Following example demonstrates using **Top**  and **Left**  properties to set a Barcode signature position in pixels on a Cells worksheet.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // Specify Signature Options 
         CellsBarcodeSignOptions options = new CellsBarcodeSignOptions("1234567");
         signOptions.setWidth(300);
         signOptions.setHeight(100);
         signOptions.setTop(15);
         signOptions.setLeft(22);
         // set save options
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_Documents_BarCode");
     
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ",  signedPath));
    }
    ```
    
    Following example demonstrates using **Top**  and **Left**  properties to set a QR-code signature position in pixels on a Cells worksheet.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // Specify Signature Options 
         CellsQRCodeSignOptions options = new CellsQRCodeSignOptions ("1234567");
         signOptions.setWidth(300);
         signOptions.setHeight(100);
         signOptions.setTop(15);
         signOptions.setLeft(22);
         // set save options
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_Documents_QRCode");
      
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ",  signedPath));
    }
    ```
    
    Following example demonstrates using **Top**  and **Left**  properties to set a Digital signature position in pixels on a Cells worksheet.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         signConfig.setImagesPath("c:\\Aspose\\Test\\Images");
         signConfig.setCertificatesPath("c:\\Aspose\\Test\\Certificates");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // Specify Signature Options 
         CellsSignDigitalOptions options = new CellsSignDigitalOptions ("SherlockHolmes.pfx", "200.png");
         signOptions.setPassword("1234567890");
         signOptions.setWidth(200);
         signOptions.setHeight(200);
         signOptions.setTop(15);
         signOptions.setLeft(22);
         // set save options
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_Documents_Digital");
      
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ",  signedPath));
    }
    ```
    
    Following example demonstrates using **Top**  and **Left**  properties to set an Image signature position in pixels on a Cells worksheet.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setImagesPath("c:\\Aspose\\Test\\Images");
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // Specify Signature Options 
         CellsSignImageOptions options = new CellsSignImageOptions("200.png");
         signOptions.setWidth(200);
         signOptions.setHeight(200);
         signOptions.setTop(15);
         signOptions.setLeft(22);
         // set save options
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_Documents_Images");
      
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ",  signedPath));
    }
    ```
    
    Following example demonstrates using **Top**  and **Left**  properties to set a Text signature position in pixels on a Cells worksheet.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // Specify Signature Options 
         CellsSignTextOptions options = new CellsSignTextOptions ("John Smith");
         signOptions.setWidth(100);
         signOptions.setHeight(100);
         signOptions.setTop(15);
         signOptions.setLeft(22);
         // set save options
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_Documents_Text");
      
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ",  signedPath));
    }
    ```
    
    Following example demonstrates using **Top**  and **Left**  properties to set a Stamp signature position in pixels on a Cells worksheet.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // setup options with text of signature
         CellsStampSignOptions signOptions = new CellsStampSignOptions();
         signOptions.setHeight(120);
         signOptions.setWidth(300);
         signOptions.setTop(15);
         signOptions.setLeft(22);
     
         //Inner square lines
         StampLine line0 = new StampLine();
         line0.setText("John");
         line0.setTextBottomIntent(0);
         line0.setTextColor(java.awt.Color.RED);
         line0.getOuterBorder().setColor(java.awt.Color.BLUE);
         line0.getInnerBorder().setColor(java.awt.Color.BLUE);
         line0.getInnerBorder().setStyle(ExtendedDashStyle.Dash);
         line0.getFont().setFontSize(20);
         line0.getFont().setBold(true);
         line0.setHeight(40);
         signOptions.getInnerLines().add(line0);
     
         StampLine line1 = new StampLine();
         line1.setText("Smith");
         line1.setTextBottomIntent(0);
         line1.setTextColor(Color.toJava(java.awt.Color.RED);
         line1.getInnerBorder().setColor(java.awt.Color.BLUE);
         line1.getFont().setFontSize(20);
         line1.getFont().setBold(true);
         line1.setHeight(40);
         signOptions.getInnerLines().add(line1);
         // set save options
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_Documents_Stamp");
     
          // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ",  signedPath));
    }
    ```
    
2.  **Implemented ability to align Text inside Text Signature area for all supported Document types.**  
    New enumeration types **TextHorizontalAlignment** and **TextVerticalAlignment** were added to provide ability to specify Text alignment.  
      
    Public enum **TextHorizontalAlignment** was implemented to define horizontal text alignment for Text Signatures.
    
    **TextHorizontalAlignment**
    
    ```java
    /**
     * <p>
     * Specifies text horizontal alignment inside a Signature.
     * </p>
     */
    public final class TextHorizontalAlignment extends Enum
    {
       private TextHorizontalAlignment(){}    
        /**
         * <p>
         * Specifies that the text is left aligned to the horizontal alignment base.
         * </p>
         */
        public static final int Left = 1;
     
        /**
         * <p>
         * Specifies that the text is centered to the horizontal alignment base.
         * </p>
         */
        public static final int Center = 2;
     
        /**
         * <p>
         * Specifies that the text is right aligned to the horizontal alignment base.
         * </p>
         */
        public static final int Right = 3;
    }
    ```
    
    Public enum **TextVerticalAlignment** was implemented to define vertical text alignment for Text Signatures.
    
    **TextVerticalAlignment**
    
    ```java
    /**
     * <p>
     * Specifies text vertical alignment inside a Signature.
     * </p>
     */
    public final class TextVerticalAlignment extends Enum
    {
       private TextVerticalAlignment(){}  
        /**
         * <p>
         * Specifies that the text is top aligned to the vertical alignment base.
         * </p>
         */
        public static final int Top = 1;
     
        /**
         * <p>
         * Specifies that the text is centered to the vertical alignment base.
         * </p>
         */
        public static final int Center = 2;
     
        /**
         * <p>
         * Specifies that the text is bottom aligned to the vertical alignment base.
         * </p>
         */
        public static final int Bottom = 3;
    ```
    
    Public interface **ITextAlignment** was implemented to define text alignment on Text Signatures.
    
    **ITextAlignment**
    
    ```java
    /**
     * <p>
     * Interface defines Alignment properties for text on Text Signatures.
     * </p>
     */
    public interface ITextAlignment
    {
        /**
         * <p>
         * Horizontal alignment of text inside a signature.
         * </p>
         */
        public int getTextHorizontalAlignment();
        /**
         * <p>
         * Horizontal alignment of text inside a signature.
         * </p>
         */
        public void setTextHorizontalAlignment(int value);
     
        /**
         * <p>
         * Vertical alignment of text inside a signature.
         * </p>
         */
        public int getTextVerticalAlignment();
        /**
         * <p>
         * Vertical alignment of text inside a signature.
         * </p>
         */
        public void setTextVerticalAlignment(int value);
    }
    ```
    
    Document Text Signature Options (**PdfTextSignOptions**, **CellsSignTextOptions**, **SlidesSignTextOptions**, **WordsSignTextOptions**) implement this interface with these properties **TextHorizontalAlignment** and **TextVerticalAlignment**.
    
    Following example demonstrates using interface **ITextAlignment** to set text alignment in text signature for Cells document.
    
    **Setting text alignment in text signature**
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
     
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     
         // setup options with text of signature
         CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
     
         // text rectangle size
        signOptions.setHeight(100);
         signOptions.setWidth(100);
     
         // set text alignment inside signature (This feature is supported starting from version 18.11)
         signOptions.setTextHorizontalAlignment(TextHorizontalAlignment.Center);
         signOptions.setTextVerticalAlignment(TextVerticalAlignment.Center);
     
         // set save options
         SaveOptions saveOptions = new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_Documents_Simple");
     
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ", signedPath));
    }
    ```
    
    Following example demonstrates using **TextHorizontalAlignment**  and **TextVerticalAlignment**  to set text alignment in text signature for Pdf document.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // setup text signature options
         PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
         // text rectangle size
         signOptions.setHeight(100);
         signOptions.setWidth(100);
         //type of implementation
         signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Image);
         // set text alignment inside signature (This feature is supported starting from version 18.11)
         signOptions.setTextHorizontalAlignment(TextHorizontalAlignment.Center);
         signOptions.setTextVerticalAlignment(TextVerticalAlignment.Center);
         SaveOptions saveOptions = new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Pdf_TextSignatureAsImage");
     
         // sign document
         String signedPath = handler.<String>sign("test.pdf", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ",  signedPath));
    }
    ```
    
    Following example demonstrates using **TextHorizontalAlignment**  and **TextVerticalAlignment**  to set text alignment in text signature for Slides document.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // setup text signature options
         SlidesSignTextOptions signOptions = new SlidesSignTextOptions("John Smith");
         signOptions.setWidth(100);
         signOptions.setHeight(100);
         // set text alignment inside signature (This feature is supported starting from version 18.11)
         signOptions.setTextHorizontalAlignment(TextHorizontalAlignment.Center);
         signOptions.setTextVerticalAlignment(TextVerticalAlignment.Center);
         SaveOptions saveOptions =  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Slides_Documents_Simple");
     
         // sign document
         String signedPath = handler.<String>sign("test.pptx", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ", signedPath));
    }
    ```
    
    Following example demonstrates using **TextHorizontalAlignment**  and **TextVerticalAlignment**  to set text alignment in text signature for Words document.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // setup text signature options
         WordsSignTextOptions signOptions = new WordsSignTextOptions("John Smith");
         signOptions.setWidth(100);
         signOptions.setHeight(100);
         // type of implementation
         signOptions.setSignatureImplementation(WordsTextSignatureImplementation.TextAsImage);
         // set text alignment inside signature (This feature is supported starting from version 18.11)
         signOptions.setTextHorizontalAlignment(TextHorizontalAlignment.Center);
         signOptions.setTextVerticalAlignment(TextVerticalAlignment.Center);
         // sign document
         SaveOptions saveOptions =new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Words_TextSignatureAsImage");
     
         // sign document
         String signedPath = handler.<String>sign("test.docx", signOptions, saveOptions);
         System.out.print("Signed file path is: " + signedPath);
    }
    ```
    
    Following example demonstrates using **TextHorizontalAlignment**  and **TextVerticalAlignment**  to set text alignment in text signature for Images document.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setImagesPath("c:\\Aspose\\Test\\Images");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         // setup text signature options
         ImagesSignTextOptions signOptions = new ImagesSignTextOptions("John Smith");
         signOptions.setLeft(10);
         signOptions.setTop(10);
         signOptions.setWidth(100);
         signOptions.setHeight(100);
     
         // type of implementation
         signOptions.setSignatureImplementation(ImagesTextSignatureImplementation.TextAsImage);
         // set text alignment inside signature (This feature is supported starting from version 18.06)
         signOptions.setTextHorizontalAlignment(TextHorizontalAlignment.Center);
         signOptions.setTextVerticalAlignment(TextVerticalAlignment.Center);
         // set save options
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Images_Alignment");
         // sign document
         String signedPath = handler.<String>sign("test.png", signOptions, saveOptions);
         System.out.print(StringExtensions.concat("Signed file path is: ",  signedPath));
    }
    ```
    
3.  QR-Code Verification process was improved to use QR-Code encode type as optional not required property. Setting up **QRCodeVerifyOptions** will no longer require **EncodeType** property to be setup.
    
    **VerifyQRCodeOptions EncodeType**
    
    ```java
    /**
     * <p>
     * Get or set QR-code Type verification. This property is optional.
     * </p>
     */
    public final QRCodeType getEncodeType(){}
     
    /**
     * <p>
     * Get or set QR-code Type verification. This property is optional.
     * </p>
     */
    public final void setEncodeType(QRCodeType value){}
    ```
    
    Following example demonstrates using of verification options without **EncodeType** property was set.
    
    **Verification of PDF Document without EncodeType**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
    signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // setup verification options
    PDFVerifyQRCodeOptions verifyOptions = new PDFVerifyQRCodeOptions("12345678");
    // specify as true to verify all pages of a document
    verifyOptions.setVerifyAllPages(true);      
    // verify document
    VerificationResult result = handler.verify("SignedQRCodeTextEncrypted.pdf", verifyOptions);
    System.out.print("Verification result: " + result.isValid());
    ```
    
    Public class **VerifyQRCodeOptions **was extended with new property **public IDataEncryption DataEncryption { get; set; }**. This property allows users to specify custom or standard encryption algorithm for QR-Code Signatures to verify encrypted QR-Code Text.
    
    **DataEncryption**
    
    ```java
    /**
     * <p>
     * Gets or sets implementation of {@link IDataEncryption} interface to encode and decode QR-Code Signature Text properties.
     * </p>
     */
    public final IDataEncryption getDataEncryption(){}
    /**
     * <p>
     * Gets or sets implementation of {@link IDataEncryption} interface to encode and decode QR-Code Signature Text properties.
     * </p>
     */
    public final void setDataEncryption(IDataEncryption value){}
    ```
    
      
    Following example demonstrates verification of previously signed document with encrypted QR-Code Signature.
    
    **Verification encrypted QR-Code Signature**
    
    ```java
    // setup key and pasphrase
    string key = "1234567890";
    string salt = "1234567890";
    // create data encryption
    IDataEncryption encrypter = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
    signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // setup verification options
    PDFVerifyQRCodeOptions verifyOptions = new PDFVerifyQRCodeOptions("This is private text to be secured.");
    // specify as true to verify all pages of a document
    verifyOptions.setVerifyAllPages(true);
    // setup encrypter to retrieve original text
    verifyOptions.setDataEncryption(encrypter);
    // verify document
    VerificationResult result = handler.verify("SignedQRCodeTextEncrypted.pdf", verifyOptions);
    System.out.print("Verification result: " + result.isValid());
    ```
    
4.  Signature library was updated to generate **GroupDocsSignatureException**. This solution allows to catch selected exceptions from library. Following example demonstrates this.
    
    **Using GroupDocs Signature Exception**
    
    ```java
    try
    {
           // setup Signature configuration
        SignatureConfig signConfig =new SignatureConfig();
        signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
        signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
        // instantiating the signature handler
        SignatureHandler handler = new SignatureHandler(signConfig);
        // setup verification options
        PDFVerifyQRCodeOptions verifyOptions = new PDFVerifyQRCodeOptions("12345678");
        // specify as true to verify all pages of a document
        verifyOptions.setVerifyAllPages(true);      
        // verify document
        VerificationResult result = handler.verify("SignedQRCodeTextEncrypted.pdf", verifyOptions);
        System.out.print("Verification result: " + result.isValid());
    }
    catch(GroupDocsSignatureException ex)
    {
        System.out.print("GroupDocs Signature Exception: " + ex.Message);
    }
    catch(Exception ex)
    {
        System.out.print("System Exception: " + ex.Message);
    }
    ```
    
5.  Search Options of **Digital Signatures** were extended with few properties for **Cells and Words** documents.
    
    Public class **WordsSearchDigitalOptions** and ****CellsSearchDigitalOptions ****was extended with new properties to specify additional search criteria. These properties specify Digital Signature comments, date range criteria and some Words and Cells Digital Signature fields.
    
    **WordsSearchDigitalOptions and CellsSearchDigitalOptions properties**
    
    ```java
    /**
     * <p>
     * Comments of Digital Signature to search.
     * </p>
     */
    public final String getComments(){}
     
    /**
     * <p>
     * Comments of Digital Signature to search.
     * </p>
     */
    public final void setComments(String value){}
    private String auto_Comments;
     
    /**
     * <p>
     * Date and time range of Digital Signature to search. Nullable value will be ignored.
     * </p>
     */
    public final Date getSignDateTimeFrom(){}
    /**
     * <p>
     * Date and time range of Digital Signature to search. Nullable value will be ignored.
     * </p>
     */
    public final void setSignDateTimeFrom(Date value){}
     
    /**
     * <p>
     * Date and time range of Digital Signature to search. Nullable value will be ignored.
     * </p>
     */
    public final Date getSignDateTimeTo(){}
    /**
     * <p>
     * Date and time range of Digital Signature to search. Nullable value will be ignored.
     * </p>
     */
    public final void setSignDateTimeTo(Date value){} 
    ```
    
    Following example demonstrates using extended properties for **Words** documents.
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig
    {
        StoragePath = @"c:\Aspose\Test\Storage"
    };
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // setup options with text of signature
    WordsSearchDigitalOptions searchOptions = new WordsSearchDigitalOptions();
    // setup additional search criteria
    searchOptions.setComments("test comments");
    searchOptions.setSignDateTimeFrom(new Date(new Date().getYear(), 1, 1));
    searchOptions.setIssuerName("John");
    // Search Document for Signatures
    String guid = "test_digitalsigned.docx";
    SearchResult searchResult = handler.search(guid, searchOptions);
    System.out.print("Source file "+guid+" contains "+searchResult.getSignatures().size()+" digital signature(s)");
    for(BaseSignature signature : searchResult.getSignatures())
    {
     WordsDigitalSignature WordsSign = (WordsDigitalSignature)signature ;
        if (WordsSign != null)
        {
            System.out.print("\t >> Digital signature from "+ WordsSign.getSignTime()+". Comments: "+WordsSign.getComments()+". Valid "+WordsSign.isValid() );
        }
    }
    ```
    
    Following example demonstrates using extended properties for **Cells **documents.
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // setup options with text of signature
    CellsSearchDigitalOptions searchOptions = new CellsSearchDigitalOptions();
    // setup additional options
    searchOptions.setComments("test comment");            
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    Date dateFrom = sdf.parse("26/1/2017 14:55:07");        
    searchOptions.setSignDateTimeFrom(dateFrom);
    // Search Document for Signatures
    String guid = "test_digitalsigned.xls";
    SearchResult searchResult = handler.search(guid, searchOptions);
    System.out.print("Source file "+ guid+" contains "+searchResult.getSignatures().size()+" digital signature(s)" );
    for(BaseSignature signature : searchResult.getSignatures())
    {
        CellsDigitalSignature cellsSign = (CellsDigitalSignature)signature ;
        if (cellsSign != null)
        {
            System.out.print("\t >> Digital signature from "+cellsSign.getSignTime()+". Comments: "+cellsSign.getComments()+". Valid " + cellsSign.isValid() );
        }
    }   
    ```
    
      
    
6.  ****Process Events arguments were updated with properties to set and check cancellation of progression.** **  
      
    Public class **ProcessProgressEventArgs **was updated with Boolean property **Cancel **and now **supports cancellation of different processes like signing, verification and searching**. Public class **ProcessCompleteEventArgs **was updated with read only Boolean property **Canceled **that **indicates if process (signing, verification and searching) was canceled**.
    
    **ProcessProgressEventArgs proeprties**
    
    ```java
    /**
     * <p>
     * Gets or sets a value indicating whether the process should be canceled.
     * </p>
     */
    public final boolean getCancel(){}
    /**
     * <p>
     * Gets or sets a value indicating whether the process should be canceled.
     * </p>
     */
    public final void setCancel(boolean value){}
    ```
    
    This property should be set to true value in corresponding event for singing, verification or searching in case when process requires cancellation.
    
    **ProcessCompleteEventArgs properties**
    
    ```java
    /**
     * <p>
     * Represents flag if process was canceled.
     * </p>
     */
    public final boolean getCanceled(){}
    /**
     * <p>
     * Represents flag if process was canceled.
     * </p>
     */
    private void setCanceled(boolean value){}
    ```
    
    The property **Canceled** will be set to true value in case when user discarded/ canceled process over Progress event with **Cancel **property.
    
    Following example demonstrates using new property to make cancellation of singing process.
    
    
    
    ```java
    public static void Main(){
    	// setup Signature configuration
    	SignatureConfig signConfig =new SignatureConfig();
    	signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
    	signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
    	// instantiating the signature handler
    	SignatureHandler handler = new SignatureHandler(signConfig);
    	// setup signature option
    	PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith",10,10,100,100);
    	signOptions.setSignAllPages(true);
    	SaveOptions saveOptions = new SaveOptions();
    	saveOptions.setOutputType(OutputType.String);
    	saveOptions.setOutputFileName("Cancellation_Events");
    	handler.SignatureStarted.add(new ProcessStartEventHandler() {
    	public void invoke(Object sender, ProcessStartEventArgs args) {
    			System.out.println("Processing of "+args.getTotalSignatures()+" signatures for "+args.getGuid()+" started at " + args.getStarted().toString());
    		}
    	});
    	handler.SignatureProgress.add(new ProcessProgressEventHandler(){
    		public void invoke(Object sender, ProcessProgressEventArgs args) {
    			System.out.println("Singing of "+args.getGuid()+" progress: "+args.getProgress()+" %. Processed "+args.getProcessedSignatures()+" signatures. Since start process spent "+args.getTicks()+" mlsec");
    			if(args.getProgress() > 10)
    			{
    				args.setCancel(true);
    				System.out.println("Cancellation of process");
    			}
    		}
    	});
    	handler.SignatureCompleted.add(new ProcessCompleteEventHandler() {
    		public void invoke(Object sender, ProcessCompleteEventArgs args) {
    			if (args.getCanceled())
    			{
    				System.out.println("Singing process was canceled");
    			}
    			else
    			{
    				System.out.println("Singing of "+args.getGuid()+" completed at "+args.getCompleted().toString()+". Processing of "+args.getTotalSignatures()+" signatures took "+args.getTicks()+" mlsec");
    			}
    		}
    	});
    	// sign document
    	String signedPath = (String)handler.<String>sign("pages12Images.pdf", signOptions, saveOptions);
    }
    ```
    
7.  ********Signature Cells Documents Options**** were updated with supporting different measure types.** **  
    ****
    
    Public classe**s CellsTextSignOptions, CellsImageSignOptions, CellsDigitalSignOptions, BarcodeCodeSignOptions**, **CellsQRCodeSignOptions** were updated and now **support different Measure Types values to setup position and size** **of signature area**.
    
    The properties **LocationMeasureType**, **SizeMeasureType** and **MarginMeasureType **allow to adjust measure units with one of predefined enumeration like millimeters, percents or pixels of location, size and margin fields for QR-code signature areas. Percents measure type value assumes calculation signature size and position according to a Cells worksheet filled area. The filled area is determined by a cell which contains data or style and has the biggest row and column numbers.
    
    **Measure Type**
    
    ```java
    /**
     * <p>
     * Measure type (pixels, percents or millimeters) for Left and Top properties.
     * If measure type is percents signature location is calculated according to worksheet 
     * area where cells with data or style are located.
     * </p>
     */
    public int getLocationMeasureType(){}
      
    /**
     * <p>
     * Measure type (pixels, percents or millimeters) for Left and Top properties.
     * If measure type is percents signature location is calculated according to worksheet 
     * area where cells with data or style are located.
     * </p>
     */
    public  void setLocationMeasureType(int value){}
      
      
    /**
     * <p>
     * Measure type (pixels, percents or millimeters) for Width and Height properties.
     * If measure type is percents signature size is calculated according to worksheet 
     * area where cells with data or style are located.
     * </p>
     */
    public int getSizeMeasureType(){}
    /**
     * <p>
     * Measure type (pixels, percents or millimeters) for Width and Height properties.
     * If measure type is percents signature size is calculated according to worksheet 
     * area where cells with data or style are located.
     * </p>
     */
    public void setSizeMeasureType(int value){}
      
      
    /**
     * <p>
     * Gets or sets the measure type (pixels, percents or millimeters) for Margin.
     * If measure type is percents signature margin is calculated according to worksheet 
     * area where cells with data or style are located.
     * </p>
     */
    public int getMarginMeasureType(){}
    /**
     * <p>
     * Gets or sets the measure type (pixels, percents or millimeters) for Margin.
     * If measure type is percents signature margin is calculated according to worksheet 
     * area where cells with data or style are located.
     * </p>
     */
    public  void setMarginMeasureType(int value){ } 
    ```
    
    Following example demonstrates using **Measure Type** properties to set a QR-code signature position in the center by horizontal and in 25% by vertical of worksheet filled area. Height and width are 10% of worksheet filled area.
    
    **Measure Type properties to set a QR-code signature position**
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
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
      
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_QrCode_Measure_ReleaseExample");
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
    }
    ```
    
    Following example demonstrates using **Measure Type** properties to set a Barcode signature position in the center by horizontal and in 25% by vertical of worksheet filled area. Height and width are 10% of worksheet filled area.
    
    **Measure Type properties to set a Barcode signature position**
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
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
     
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_Documents_BarCode");
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
    }
    ```
    
    Following example demonstrates using **Measure Type** properties to set a digital signature position in the center by horizontal and in 25% by vertical of worksheet filled area. Height and width are 10% of worksheet filled area.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig = new SignatureConfig
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setImagesPath("c:\\Aspose\\Test\\Images");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         signConfig.setCertificatesPath("c:\\Aspose\\Test\\Certificates");
          
         // instantiating the signature handler
         SignatureHandler handler = new SignatureHandler(signConfig);
         CellsSignDigitalOptions signOptions = new CellsSignDigitalOptions("DrWatson.pfx");
         signOptions.setImageGuid("200.png");
         signOptions.setPassword("1234567890");
     
         // size
         signOptions.setSizeMeasureType(MeasureType.Percents);
         signOptions.setWidth(10);
         signOptions.setHeight(10);
     
         // position
         // alignment
         signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
         signOptions.setVerticalAlignment(VerticalAlignment.Top);
         // margin
         signOptions.setMarginMeasureType(MeasureType.Percents);
         signOptions.getMargin().setTop(25);
     
     
         SaveOptions exSaveOptions = new SaveOptions();
         exSaveOptions.setOutputType(OutputType.String);
         exSaveOptions.setOutputFileName("Cells_Digital_Measure_ReleaseExample");
     
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, exSaveOptions );
    }
    ```
    
    Following example demonstrates using **Measure Type** properties to set a image signature position in the center by horizontal and in 25% by vertical of worksheet filled area. Height and width are 10% of worksheet filled area.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setImagesPath("c:\\Aspose\\Test\\Images");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
          
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         CellsSignImageOptions  signOptionsPercents = new CellsSignImageOptions ("signature.jpg");
         // specify Size
         signOptionsPercents.setSizeMeasureType(MeasureType.Percents);
         signOptionsPercents.setHeight(25);
         signOptionsPercents.setWidth(25);
         // specify size in percents of page size
         signOptionsPercents.setMarginMeasureType(MeasureType.Percents);
         signOptions.getMargin().setTop(25);
         // specify Intents
         signOptionsPercents.setTop(15);
         signOptionsPercents.setLeft(20);
         // specify intents in percents of page size
         signOptionsPercents.setLocationMeasureType(MeasureType.Percents);
     
         SaveOptions exSaveOptions = new SaveOptions();
         exSaveOptions.setOutputType(OutputType.String);
         exSaveOptions.setOutputFileName("Cells_Image_Measure_ReleaseExample");
         // sign document
         string signedPath = handler.<String>sign("test.xlsx", signOptions, exSaveOptions);
    }
    ```
    
    Following example demonstrates using **Measure Type** properties to set a text signature position in the center by horizontal and in 25% by vertical of worksheet filled area. Height and width are 10% of worksheet filled area.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig = new SignatureConfig
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setImagesPath("c:\\Aspose\\Test\\Images");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
     
         // size
         signOptions.setSizeMeasureType(MeasureType.Percents);
         signOptions.setWidth(10);
         signOptions.setHeight(10);
     
         // position
         // alignment
         signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
         signOptions.setVerticalAlignment(VerticalAlignment.Top);
     
         // margin
         signOptions.setMarginMeasureType(MeasureType.Percents);
         signOptions.getMargin().setTop(25);
         SaveOptions saveOptions=  new SaveOptions();
         saveOptions.setOutputType(OutputType.String);
         saveOptions.setOutputFileName("Cells_Documents_BarCode");
     
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, saveOptions);
         System.out.print("Signed file path is: " +  signedPath);
    }
    ```
    
    Following example demonstrates using **Measure Type** properties to set a stamp signature position in the center by horizontal and in 25% by vertical of worksheet filled area. Height and width are 10% of worksheet filled area.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig = new SignatureConfig
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");           
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
         CellsStampSignOptions signOptions = new CellsStampSignOptions();
         signOptions.setWidth = 150;
         signOptions.setHeight = 150;
         signOptions.setHorizontalAlignment(HorizontalAlignment.Left);
         signOptions.setVerticalAlignment(VerticalAlignment.Top);
         signOptions.setBackgroundColor(java.awt.Color.BLUE);
         signOptions.setBackgroundColorCropType(StampBackgroundCropType.None);
         StampLine line1 = new StampLine();
         line1.setText("Stamp_Size_Pixels");
         line1.setsBackgroundColor(java.awt.Color.BLUE);
         line1.setTextColor(java.awt.Color.CYAN);
         signOptions.getOuterLines.add(line1);
         // size
         signOptions.setSizeMeasureType(MeasureType.Percents);
         signOptions.setWidth(10);
         signOptions.setHeight(10);
     
         // position
         // alignment
         signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
         signOptions.setVerticalAlignment(VerticalAlignment.Top);
     
         // margin
         signOptions.setMarginMeasureType(MeasureType.Percents);
         signOptions.getMargin.setTop(25);
     
         SaveOptions exSaveOptions = new SaveOptions();
         exSaveOptions.setOutputType(OutputType.String);
         exSaveOptions.setOutputFileName("Cells_Stamp_Measure_ReleaseExample");
         // sign document
         String signedPath = handler.<String>sign("test.xlsx", signOptions, exSaveOptions);
    }
    ```
    
8.  Public interface **ITextAlignment** was implemented to define signature position by specifying worksheet row or column number.
    
    **ICellsPosition**
    
    ```java
    /**
     * <p>
     * Interface defines signature position for Cells documents.
     * </p>
     */
    public interface ICellsPosition
    {
        /**
         * <p>
         * Gets or sets the top row number of signature (min value is 0).
         * </p>
         */
        public int getRowNumber() ;
        /**
         * <p>
         * Gets or sets the top row number of signature (min value is 0).
         * </p>
         */
        public void setRowNumber(int value);
     
        /**
         * <p>
         * Gets or sets the left column number of signature (min value is 0).
         * </p>
         */
        public int getColumnNumber();
        /**
         * <p>
         * Gets or sets the left column number of signature (min value is 0).
         * </p>
         */
        public void setColumnNumber(int value);
    }
    ```
    
    Following example demonstrates using interface **ICellsPosition** to set signature position by specifying worksheet row or column number for Cells document.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
     
         // instantiating the signature handler
         SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     
         // setup options with text of signature
         CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
         // text position
     
         signOptions.setRowNumber(10);
         signOptions.setColumnNumber(10);
     
         // text rectangle size
         signOptions.setHeight(100);
         signOptions.setWidth(100);
     
          SaveOptions tmp0 = new  SaveOptions();
         tmp0.setOutputType(OutputType.String);
         tmp0.setOutputFileName("Cells_Positioning");
     
         // sign document
         String signedPath = (String)handler.<String>sign("test.xlsx", collection,tmp0);
         System.out.print("Signed file path is: " + signedPath);
    }
    ```
    
9.  Public enum **ImagesSaveFileFormat **was extended with **Pdf** value that makes possible to save an image document as a PDF document.
    
    **PDF value**
    
    ```java
    /**
      * <p>Saves the document to the Pdf format.</p>
      */
    public static final int Pdf = 9;
    ```
    
    Following example demonstrates using **Pdf** value of **ImagesSaveFileFormat** enum for saving signed image document as a PDF document.
    
    **Saving signed image as PDF**
    
    ```java
    public static void Main(){
    	// setup Signature configuration
    	SignatureConfig signConfig =new SignatureConfig();
    	signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
    	signConfig.setImagesPath("c:\\Aspose\\Test\\Images");
    	signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
    	// instantiating the signature handler
    	SignatureHandler<String> handler = new SignatureHandler(signConfig);
    	// setup text signature options
    	SignOptions signOptions = new ImagesSignTextOptions("John Smith");
    	// instantiate Pdf save options
    	ImagesSaveOptions optionsPdf = new ImagesSaveOptions();
    	optionsPdf.setOutputType(OutputType.String);
    	optionsPdf.setFileFormat(ImagesSaveFileFormat.Pdf);
    	optionsPdf.setOutputFileName("Images_WithDifferentOutputFileType_Pdf");
    	//sign a document
    	signedPath = handler.<String>sign("test.png", signOptions, optionsPdf);
    }
    ```
    
10.  Public class **SignatureConfig **was updated with static property DefaultCulture that **specifies the default data format provider for data conversion operations**.
    
    **DefaultCulture property**
    
    ```java
    /**
     * <p>
     * Specifies default Culture Info property that is being used for different culture related data conversion.
     * </p>
     */
    public static java.util.Locale getDefaultCulture() {} 
    /**
     * <p>
     * Specifies default Culture Info property that is being used for different culture related data conversion.
     * </p>
     */
    public static void setDefaultCulture(java.util.Locale value) { }
    ```
    
    This property will be set to default "en-US" English (United States) culture info.
    
11.  Public interface **IDataEncryption **specifies common methods for data encryption to provide string based encoding and decoding. This interface uses with purposes to encrypt text into QR-Code Signature provided by custom data or simple strings.
    
    **IDataEncryption**
    
    ```java
    /**
     * <p>
     * Encryption interface to provide object encoding and decoding methods.
     * </p>
     */
    public interface IDataEncryption
    {
        /**
         * <p>
         * Encode method to encrypt string.
         * </p>
         * @return Returns encrypted string
         * @param source Source string to encode.
         */
        public String encode(String source);
     
        /**
         * <p>
         * Decode method to obtain decrypted string.
         * </p>
         * @return Returns decrypted string
         * @param source Source string to decode.
         */
        public String decode(String source);
    }
    ```
    
    Following example demonstrates using interface **IDataEncryption ** to provide custom implementation of data encryption. As an example class provides simple XOR algorithm based on integer Key value.
    
    **IDataEncryption implementation**
    
    ```java
    public class CustomXOREncryption : IDataEncryption
     {
         /**
         * <p>
         * Gets or sets non empty key for encryption (at least one character)
         * </p>
         */
         public final int getKey(){ return auto_Key; }
         /**
         * <p>
         * Gets or sets non empty key for encryption (at least one character)
         * </p>
         */
         public final void setKey(int value){ auto_Key = value; }
         private int auto_Key;
     
         /**
         * <p>
         * Encode method to encrypt string.
         * </p>
         * @return Returns enccrypted string
         * @param source Source string to encode.
         */
         public final String encode(String source)
         {
         return process(source);
         }
     
         /**
         * <p>
         * Decode method to obtain decrypted string.
         * </p>
         * @return Returns decrypted string
         * @param source Source string to decode.
         */
         public final String decode(String source)
         {
             return process(source);
         }
     
         /**
          * <p>
         * Using XOR operation get encoded / decoded string
         * </p>
         * @return 
         * @param source 
         */
         private String process(String source)
         {
          msStringBuilder src = new msStringBuilder(source);
          msStringBuilder dst = new msStringBuilder(src.getLength());
          char chTmp;
          for (int index = 0; index < src.getLength(); ++index)
             {
                 chTmp = src.get_Char(index);
                 chTmp = (char)(chTmp ^ this.getKey());
                 dst.append(chTmp);
          }
          return dst.toString();
         }
     }
     //
     public static void Main()
     {
         CustomXOREncryption encryption = new CustomXOREncryption();
         encryption.setKey(111);
     
         String source = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
     
         String encoded = encryption.encode(source);
     
         String decoded = encryption.decode(encoded);
         System.out.print(source);
         System.out.print(decoded);
    }
    ```
    
    This interface is used to specify over **QRCodeSignature** property DataEncryption the way to secure data in QR-Code on documents.
    
    ```java
    /**
     * <p>
     * Internal property to keep original implementation of {@link IDataEncryption} interface from options
     * </p>
     */
    final IDataEncryption getDataEncryption(){}
    /**
     * <p>
     * Internal property to keep original implementation of {@link IDataEncryption} interface from options
     * </p>
     */
    final void setDataEncryption(IDataEncryption value){}
    private IDataEncryption auto_DataEncryption;
    ```
    
12.  New enumeration **SymmetricAlgorithmType** was added to specify standard symmetric algorithm type. Enumeration values are named correspondingly to algorithm type.
    
    **DES **\- specifies Data Encryption Standard (DES) implementation 
    
    **TripleDES** - Triple Data Encryption Standard algorithms
    
    **RC2 **\- implementations of the RC2 algorithm
    
    **Rijndael **\- implementations of the Rijndael symmetric encryption algorithm
    
    **Symmetric algorithm type enumeration**
    
    ```java
    /**
     * <p>
     * Represents symmetric encryption algorithm type.
     * </p>
     */
    public final class SymmetricAlgorithmType extends Enum
    {
       private SymmetricAlgorithmType(){} 
        /**
         * <p>Represents DES Data Encryption Standard algorithm.</p>
         */
        public static final int DES = 0;
     
        /**
         * <p>Represents TripleDES symmetric encryption algorithm..</p>
         */
        public static final int TripleDES = 1;
     
        /**
         * <p>Represents RC2 algorithm.</p>
         */
        public static final int RC2 = 2;
     
        /**
         * <p>Represents Rijndael symmetric encryption algorithm.</p>
         */
        public static final int Rijndael = 3;
    }
    ```
    
13.  Public class **SymmetricEncryption** was added to namespace to provide implementation of standard symmetric encryption algorithms. This class implements interface **IDataEncryption** and provides properties to specify encryption **Key** and passphrase **Salt** - string based values to adjust encryption method and property **AlgorithmType** to setup type of symmetric algorithm. See enumeration **SymmetricAlgorithmType**. Methods Encode and Decode implement encoding and decoding according to set algorithm type of strings.
    
    **SymmetricEncryption class definition**
    
    ```java
    /**
     * <p>
     * Implements standard symmetric algorithms for data encryption with single key and passphrase (salt).
     * </p>
     */
    public final class SymmetricEncryption implements IDataEncryption
    {
        /**
         * <p>
         * Gets or sets type of symmetric algorithm.
         * </p>
         */
        public final int getAlgorithmType(){ return auto_AlgorithmType; }
        /**
         * <p>
         * Gets or sets type of symmetric algorithm.
         * </p>
         */
        public final void setAlgorithmType(int value){ auto_AlgorithmType = value; }
        private int auto_AlgorithmType;
     
        /**
         * <p>
         * Gets or sets key of encryption algorithm.
         * </p>
         */
        public final String getKey(){ return auto_Key; }
        /**
         * <p>
         * Gets or sets key of encryption algorithm.
         * </p>
         */
        public final void setKey(String value){ auto_Key = value; }
        private String auto_Key;
     
        /**
         * <p>
         * Gets or sets passphrase of encryption algorithm.
         * </p>
         */
        public final String getSalt(){ return auto_Salt; }
        /**
         * <p>
         * Gets or sets passphrase of encryption algorithm.
         * </p>
         */
        public final void setSalt(String value){ auto_Salt = value; }
        private String auto_Salt;
     
        /**
         * <p>
         * Creates symmetric encryption algorithm with parameters.
         * </p>
         * @param algorithmType Specify symmetric algorithm type
         * @param key Encryption key
         * @param salt Passphrase for encryption
         */
        public SymmetricEncryption(int algorithmType, String key, String salt){}
     
        /**
         * <p>
         * Creates symmetric encryption algorithm with default passphrase
         * </p>
         * @param algorithmType Specify symmetric algorithm type
         * @param key Encryption key
         */
        public SymmetricEncryption(int algorithmType, String key){}
     
        /**
         * <p>
         * Encrypts string based on provided algorithm type, key and salt parameters
         * </p>
         * @return Returns encrypted string.
         * @param source Source string to encode.
         */
        public final String encode(String source){}
     
        /**
         * <p>
         * Decrypts string based on provided algorithm type, key and salt parameters
         * </p>
         * @return Returns decrypted string.
         * @param source 
         */
        public final String decode(String source){}
         
    }
    ```
    
    Following example demonstrates using class **SymmetricEncryption, **to add QR-Code Signature with encrypted Text.
    
    
    
    ```java
    // setup key and pasphrase
    String key = "1234567890";
    String salt = "1234567890";
    // create data encryption
    IDataEncryption encrypter = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
     
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
    signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // setup options with text of signature
    PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions("This is private text to be secured.");
    // QR-code type
    signOptions.EncodeType = QRCodeTypes.QR;
    // specify text encryption
    signOptions.DataEncryption = encrypter;
     
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("SignedQRCodeDataEncryptedCustom.pdf");
     
    // sign document
    String signedPath = handler.<String>sign("test.pdf", signOptions, tmp0);
    System.out.print("Signed file path is: " + signedPath);
    ```
    
14.  Public attribute **SymmetricEncryptionAttribute **was added to namespace to provide class attribute that specifies standard symmetric encryption algorithms and settings to be used with serialization of instances of this class. Class implements interface **IDataEncryption** and inherits **Attribute** class that allows to setup this attribute at class definition. Implementation of this class repeats implementation of**   SymmetricEncryption** class. Definition of attribute requires encryption **Key**, passphrase **Salt** and **AlgorithmType** enumeration of **SymmetricAlgorithmType**.
    
    **SymmetricEncryptionAttribute definition**
    
    ```java
    /**
     * <p>
     * Instructs instances serialization to encrypt / decrypt object serialization string.
     * </p>
     */
    public @interface SymmetricEncryptionAttribute
    {
        @Public
        public int algorithmType();
     
        @Public
        public String key();
     
        @Public
        public String salt() default "70a7c497d77d4253b8012ba124f907c9";
    }
    ```
    
    Following example demonstrates retrieving **DocumentSignature **object from signed Pdf file with **DocumentSignature **QR-Code Signature (see examples how to sign Document with custom data objects).
    
    **Search for custom objects**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // setup search options
    PdfSearchQRCodeOptions searchOptions = new PdfSearchQRCodeOptions();
    // specify as true to search all pages of a document
    searchOptions.setSearchAllPages(false);
     
    // search document
    SearchResult result = handler.search("SignedQRCodeDataEncrypted.pdf", searchOptions);
    // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        PdfQRCodeSignature qrCodeSignature = (PdfQRCodeSignature)signature;
        if (qrCodeSignature != null)
        {
            DocumentSignature docSignature = qrCodeSignature.getData(DocumentSignature.class);
            if (docSignature != null)
            {
                System.out.println("Found DocumentSignature: #{0} by {1} from {2} DataFactor = {3}", docSignature.getID(), docSignature.getAuthor(), docSignature.getSigned(), docSignature.getDataFactor().toString());
            }
        }
    }
    ```
    
    Class **DocumentSignature **written by user.
    
    **Example of custom class**
    
    ```java
    public static class DocumentSignature
       {
           
           public final String getID(){ return auto_ID; }        
           public final void setID(String value){ auto_ID = value; }
           @FormatAttribute(propertyName = "SignID")
           private String auto_ID;
     
            
           public final String getAuthor(){ return auto_Author; }        
           public final void setAuthor(String value){ auto_Author = value; }
           @FormatAttribute(propertyName = "SAuth")
           private String auto_Author;
     
            
           public final java.util.Date getSigned() {  return auto_Signed; }
           public final void setSigned(java.util.Date value) { auto_Signed = value; }
           @FormatAttribute (propertyName = "SDate",propertyFormat = "yyyy-MM-dd")
           public java.util.Date auto_Signed = new java.util.Date();
     
     
           public final java.math.BigDecimal getDataFactor() { return auto_DataFactor; }
           public final void setDataFactor(java.math.BigDecimal value) { auto_DataFactor = value; }
           @FormatAttribute (propertyName = "SDFact",propertyFormat = "N2")
           private java.math.BigDecimal auto_DataFactor = new java.math.BigDecimal(0.01);
       }
    ```
    
    How document was signed with custom object **DocumentSignature**.
    
    **Sign Document with custom object in QR-Code Signature**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
     signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
     // setup custom object instance with required data
     DocumentSignature docSignature = new DocumentSignature()
     {
         signature.setID(java.util.UUID.randomUUID().toString());
         signature.setAuthor(Author = "Mr.Sherlock"),
         signature.setSigned(new java.util.Date());
         signature.setDataFactor(new java.math.BigDecimal("0.67"));
     };
     // instantiating the signature handler
     SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     // setup options
     PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions();
     // QR-code type
     signOptions.setEncodeType(QRCodeTypes.QR);
      
     // setup Data property with custom object
     signOptions.setData(signature);
     // save Options
     SaveOptions tmp0 = new  SaveOptions();
     tmp0.setOutputType(OutputType.String);
     tmp0.setOutputFileName("SignedQRCodeDataEncryptedCustom.pdf");
     
     // sign document
     String signedPath = handler.<String>sign("test.pdf", signOptions, tmp0);
     System.out.print("Signed file path is: " + signedPath);
    ```
    
15.  Public interface **IDataSerializer **specifies common methods for data serialization. This interface uses with purposes to serialize and de-serialize custom objects into QR-Code Signature text and back.
    
    **IDataSerializer implementation**
    
    ```java
    /**
     * <p>
     * Serialization interface to provide object serialization and deserialization methods.
     * </p>
     */
    public interface IDataSerializer
    {
        /**
         * <p>
         * Serialize method to format object to string representing.
         * </p>
         * @return 
         * @param data Source object to serialize
         */
        public String serialize(Object data);
     
        /**
         * <p>
         * Deserialize method to obtain required object from string.
         * </p>
         * @return 
         * @param source Source serialized string that contains object
         * <p>{@code T}: Type of return object</p>
         */
        public  <T> T deserialize(String source, Class<T> type);
    }
    ```
    
16.  **New Metadata type of Signature is the abstract class MetadataSignature**  
    
    New public abstract class **MetadataSignature **was added to implement Metadata signature features for Documents. The metadata signature is the additional document property that contains special attributes/tags to keep non visual information inside the Document. Most Documents support standard information metadata tags same as user defined custom metadata properties.
    
    This type of Signature allows users to keep inside the Document unlimited scope of hidden metadata information that related with document. It could be Document properties, statistic, author properties, document relation properties etc.
    
    **Metadata Signature class properties**
    
    ```java
    /**
     * <p>
     * Contains Metadata Signature properties.
     * </p>
     */
    public abstract class MetadataSignature extends BaseSignature implements ICloneable
    {
        
     /**
     * <p>
     * Specifies unique metadata name.
     * </p>
     */
     public final String getName(){ return auto_Name; }
        
     /**
     * <p>
     * Specifies unique metadata name.
     * </p>
     */
     public final void setName(String value){ auto_Name = value; }
        private String auto_Name;
     
        /**
     * <p>
     * Specifies metadata object.
     * </p>
     */
     public final Object getValue() {}
        /**
     * <p>
     * Specifies metadata object.
     * </p>
     */
     public final void setValue(Object value) {}
     
        /**
     * <p>
     * Converts to boolean.
     * </p>
     * @return Returns the Metadata signature value as boolean.
     * <p><hr>Throws an exception if the Metadata value could not be converted.</hr></p>
     */
     public final boolean toBoolean(){}
     
        /**
     * <p>
     * Converts to integer.
     * </p>
     * @return Returns the Metadata Signature value as integer.
     * <p><hr>Throws an exception if the Metadata value could not be converted.</hr></p>
     */
     public final int toInteger(){}
     
        /**
     * <p>
     * Converts to Double.
     * </p>
     * @return Returns the Metadata Signature value as Double.
     * <p><hr>Throws an exception if the Metadata value could not be converted. 
     * If original value is string based the default culture property info will be used from static SignatureConfig {@code SignatureConfig.DefaultCulture}
     * </hr></p>
     */
     public final double toDouble(){} 
     
        /**
     * <p>
     * Converts to Double.
     * </p>
     * @return Returns the Metadata Signature value as Double.
     * @param provider Format data provider to use with data convertion operations.
     * <p><hr>Throws an exception if the Metadata value could not be converted</hr></p>
     */
     public final double toDouble(IFormatProvider provider){}
     
      
     /**
     * <p>
     * Converts to Date.
     * </p>
     * @return Returns the Metadata Signature value as Date.
     * <p><hr>Throws an exception if the Metadata value could not be converted. 
     * If original value is string based the default culture property info will be used from static SignatureConfig {@code SignatureConfig.DefaultCulture}
     * </hr></p>
     */
     public final java.util.Date toDateTime(){}
     
        
     /**
     * <p>
     * Converts to Date.
     * </p>
     * @return Returns the Metadata Signature value as Date.
     * @param provider Format data provider to use with data convertion operations.
     * <p><hr>Throws an exception if the Metadata value could not be converted</hr></p>
     */
     public final java.util.Date toDateTime(IFormatProvider provider){}
         
    /**
     * <p>
     * Converts to String with override ToString() method
     * </p>
     * @return Returns the Metadata Signature value as String.
     * <p><hr>Converts a boolean property into "True" or "False". For another data type the default data format provider will be used.</hr></p>
     */
     public /*override*/ String toString(){}
         
    /**
     * <p>
     * Converts to String with specified format
     * </p>
     * @return Returns the Metadata Signature value as String.
     * @param format Data format string.
     * <p><hr>Converts a boolean property into "True" or "False".
     * Default culture property info will be used from static SignatureConfig {@code SignatureConfig.DefaultCulture}
     * </hr></p>
     */
     public final String toString(String format){}
        
     /**
     * <p>
     * Converts to String with specified format
     * </p>
     * @return Returns the Metadata Signature value as String.
     * @param format Data format string.
     * @param locale Format data provider to use with data convertion operations.
     * <p><hr>Converts a boolean property into "True" or "False".</hr></p>
     */
     public final String toString(String format, java.util.Locale locale){}
        
     /**
     * <p>
     * Creates Metadata Signature with predefined name and empty value
     * </p>
     * @param name Metadata name
     */
     public MetadataSignature(String name){}
        
     /**
     * <p>
     * Creates Metadata Signature with predefined values
     * </p>
     * @param name Name of Metadata signature object
     * @param value Value of Metadata signature
     */
     public MetadataSignature(String name, Object value){}
    ```
    
    **Metadata Signature properties**
    
    | Name | Type | Description |
    | --- | --- | --- |
    | Name | string | Specifies name of Metadata Signature. This name should be unique within Document metadata collection scope. |
    | Value | object | Specifies value of Metadata Signature. This property could be different type. At this moment Boolean, Integer, Double, Date and Strings types are supported. |
    
    **  
    Metadata Signature methods**
    
    | Method name | Return type | Description / Remarks |
    | --- | --- | --- |
    | toBoolean() | boolean | Returns the Metadata signature value as Boolean. Throws an exception if the Metadata value could not be converted. If value is integer type all non zero values will be interpreted as True.  |
    | toInteger() | integer | Returns the Metadata Signature value as integer. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. Double value will be truncated. String value will be tries to parse into integer. |
    | toDouble() | double | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as double. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. String value will be tries to parse into double based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | toDateTime() | Date | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as Date. Throws an exception if the Metadata value could not be converted. String value will be tries to parse into Date based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | toString() | string | Overload method with ability to specify IDataFormatProvider to data type convertions. Returns the Metadata Signature value as string representation based on passed format and IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    
17.  **New class Metadata Signature Collection**  
    New public class **MetadataSignatureCollection **was added to implement collection of Metadata signatures for Documents. This class implements IEnumarable generic class of MetadataSignature object collection, implements most Dictionary methods and provides collection of Metadata Signature manipulations with unique name validation.
    
    **Metadata Signature Collection properties**
    
    ```java
    /**
     * <p>
     * Collection of Metadata Signatures objects.
     * </p>
     */
    public class MetadataSignatureCollection implements IGenericEnumerable<MetadataSignature>
    {
        /**
         * <p>
         * Creates Collection of Metadata Signatures.
         * </p>
         */
        public MetadataSignatureCollection(){}
     
        /**
         * <p>
         * Returns a MetadataSignature object by the name of the property.
         * </p>
         * @return Returns a MetadataSignature {@link MetadataSignature} object by the name of the property.
         * @param name The case-insensitive name of the property to retrieve.
         * <p><hr>Returns null if a property with the specified name is not found.</hr></p>
         */
        public final MetadataSignature get_Item(String name) {}
        /**
         * <p>
         * Returns a MetadataSignature object by index.
         * </p>
         * @return Returns a MetadataSignature {@link MetadataSignature} object by the index of collection.
         * @param index Zero-based index of the MetadataSignature to retrieve.
         * <p><hr>Returns null if a property with the specified index does not exist.</hr></p>
         */
        public final MetadataSignature get_Item(int index) {}
     
        /**
         * <p>
         * Gets number of items in the collection.
         * </p>
         */
        public final int getCount() {}
     
     
        /**
         * <p>
         * Removes all items from the collection.
         * </p>
         */
        public final void clear(){}
     
        /**
         * <p>
         * Returns true if a Metadata with the specified name exists in the collection.
         * </p>
         * @return True if the Metadata exists in the collection; false otherwise.
         * @param name The case-insensitive name of the property.
         */
        public final boolean contains(String name){}
     
         
     
        /**
         * <p>
         * Gets the index of a property by name.
         * </p>
         * @return The zero based index. Negative value if not found.
         * @param name The case-insensitive name of the MetadataSignature.
         */
        public final int indexOf(String name){}
     
        /**
         * <p>
         * Removes a Metadata Signature with the specified name from the collection.
         * </p>
         * @return 
         * @param name The case-insensitive name of the Metadata Signature.
         */
        public final boolean remove(String name){}
     
     
        /**
         * <p>
         * Removes a Metadata Signature at the specified index.
         * </p>
         * @param index The zero based index.
         */
        public final boolean removeAt(int index){}
     
        /**
         * <p>
         * Add Metadata Signature object to collection.
         * </p>
         * @param signature Metadata signature to be added to collection.
         * <p><hr>Throws an exception if name value is not unique entire existing collection</hr></p>
         */
        public final void add(MetadataSignature signature){}
        
        /**
         * <p>
         * Clone Metadata Signature Collection class with Metadata Signature Items.
         * </p>
         * @return Returns copied instance with cloned Signature Items
         */
        public final Object deepClone(){}
     
    }
    ```
    
    **Metadata Signature Collection properties**
    
    | Name | Type | Description |
    | --- | --- | --- |
    | 
    get\_Item(string name)
    
     | MetadataSignature | Returns Metadata Signature object from collection based on unique name. |
    | 
    
    get\_Item(int index)
    
     | MetadataSignature | Returns Metadata Signature object from collection based on index of object in collection. |
    | 
    
    getCount()
    
     | integer | Returns count of Signatures in Collection |
    
    **Metadata Signature Collection methods**
    
    | Method name | Return type | Description / Remarks |
    | --- | --- | --- |
    | clear() | void | Clear all Signatures from Collection. |
    | contains(string name) | Boolean | Returns true if collection contains Metadata Signature with given name. |
    | indexOf(string name) | integer | Returns zero based index of Metadata Signature with given name in collection. If signature with this name if not found methods returns -1. |
    | remove(string name) | Boolean | Removes Signature with given name from collection and returns true. Otherwise if signature was not found returns false. |
    | removeAt(int index) | Boolean | Removes Signature with given index from collection and returns true. Otherwise if signature was not found returns false. |
    | add(MetadataSignature signature) | void | Adds signature to collection. |
    
18.  ****New class PdfMetadataSignature **derives abstract**MetadataSignature****  
    New public class **PdfMetadataSignature **was added to implement Metadata signature features for Pdf Documents. This class derives base **MetadataSignature**.
    
    **PdfMetadataSignature**
    
    ```java
    /**
     * <p>
     * Contains Pdf Metadata Signature properties.
     * </p>
     */
    public final class PdfMetadataSignature extends MetadataSignature
    {
        /**
         * <p>
         * The prefix tag of Pdf Metadata Signature name. By default this property is set to "xmp".
         * Possible values are 
         * </p>
         */
        public final String getTagPrefix(){}
     
        /**
         * <p>
         * The prefix tag of Pdf Metadata Signature name. By default this property is set to "xmp".
         * Possible values are 
         * </p>
         */
        public final void setTagPrefix(String value){}
        private String auto_TagPrefix;
     
        /**
         * <p>
         * Creates Pdf Metadata Signature with predefined name and empty value
         * </p>
         * @param name Pdf Metadata Signature name
         */
        public PdfMetadataSignature(String name){}
        /**
         * <p>
         * Creates Pdf Metadata Signature with predefined values
         * </p>
         * @param name Name of Metadata signature object
         * @param value Value of Metadata signature
         */
        public PdfMetadataSignature(String name, Object value){}
    }
    ```
    
    **Pdf Metadata Signature properties**
    
    Pdf metadata Signature derives all base class properties and contains TagPrefix string property to extend metadata name. Pdf document contains metadata properties with unique name in format "TagPrefix:Name".
    
    | Name | Type | Description |
    | --- | --- | --- |
    | TagPrefix | string | Specifies prefix of Pdf metadata signature unique name. By default this prefix is set to "xmp" value. User can specify any prefix. Standard prefixes that are supported by Pdf documentations are "pdf", "xmpMM", "dc". |
    
    **Pdf Metadata Signature methods**
    
    Pdf metadata Signature derives all base class methods
    
    | Method name | Return type | Description / Remarks |
    | --- | --- | --- |
    | toBoolean() | boolean | Returns the Metadata signature value as Boolean. Throws an exception if the Metadata value could not be converted. If value is integer type all non zero values will be interpreted as True.  |
    | toInteger() | integer | Returns the Metadata Signature value as integer. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. Double value will be truncated. String value will be tries to parse into integer. |
    | toDouble() | double | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as double. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. String value will be tries to parse into double based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | toDateTime() | Date | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as Date. Throws an exception if the Metadata value could not be converted. String value will be tries to parse into Date based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | toString() | string | Overload method with ability to specify IDataFormatProvider to data type convertions. Returns the Metadata Signature value as string representation based on passed format and IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    
    Following example demonstrates using **PdfMetadataSignature **to compose Metadata Signature options for Pdf Document - PdfMetadataSignOptions.
    
    **Compose Pdf Metadata Signature Options**
    
    ```java
    PdfMetadataSignOptions signMetadataOptions = new PdfMetadataSignOptions();
    PdfMetadataSignOptions result = new PdfMetadataSignOptions();
    result.getMetadataSignatures().add(new PdfMetadataSignature("Author", "Mr.Sherlock Holmes"));
    result.getMetadataSignatures().add(new PdfMetadataSignature("CreationDate", new Date()));
    result.getMetadataSignatures().add(new PdfMetadataSignature("Creator", "Dr.Whatson"));
    result.getMetadataSignatures().add(new PdfMetadataSignature("ModDate", new Date()));
    result.getMetadataSignatures().add(new PdfMetadataSignature("Producer", "BakerStreet.Inc"));
    result.getMetadataSignatures().add(new PdfMetadataSignature("Subject", "Baskervalley"));
    result.getMetadataSignatures().add(new PdfMetadataSignature("Title", "OfficeDocument"));
    result.getMetadataSignatures().add(new PdfMetadataSignature("Trapped", "Information"));
    result.getMetadataSignatures().add(new PdfMetadataSignature("IsSigned", true));
    result.getMetadataSignatures().add(new PdfMetadataSignature("SignatureId", 112233));
    result.getMetadataSignatures().add(new PdfMetadataSignature("Amount", 123.456));
    return result;
    ```
    
19.  **New static class PdfMetadataSignatures **contains static Pdf Metadata instances with predefined standard metadata names and prefix  
    New public static class **PdfMetadataSignatures **was added to provide list of Pdf Metadata Signatures that support standard Pdf format specifications.
    
    **PdfMetadataSignatures**
    
    ```java
    /**
     * <p>
     * Contains standard Metadata Signatures to be used for Pdf Document Metadata Signature Options.
     * </p>
     */
    public class PdfMetadataSignatures
    {
        /**
         * <p>
         * Pdf Document Author metadata.
         * </p>
         */
        public static PdfMetadataSignature getAuthor(){ return auto_Author; }
        /**
         * <p>
         * Pdf Document Author metadata.
         * </p>
         */
        private void setAuthor(PdfMetadataSignature value){ auto_Author = value; }
        private static PdfMetadataSignature auto_Author = new PdfMetadataSignature("Author", "", "xmp");
     
         
        /**
         * <p>
         * Pdf Document creation date metadata signature.
         * </p>
         */
        public static PdfMetadataSignature getCreateDate(){ return auto_CreateDate; }
        /**
         * <p>
         * Pdf Document creation date metadata signature.
         * </p>
         */
        private void setCreateDate(PdfMetadataSignature value){ auto_CreateDate = value; }
        private static PdfMetadataSignature auto_CreateDate = new PdfMetadataSignature("CreateDate", "", "xmp");
     
     
        /**
         * <p>
         * Pdf Document metadata date information.
         * </p>
         */
        public static PdfMetadataSignature getMetadataDate(){ return auto_MetadataDate; }
        /**
         * <p>
         * Pdf Document metadata date information.
         * </p>
         */
        private void setMetadataDate(PdfMetadataSignature value){ auto_MetadataDate = value; }
        private static PdfMetadataSignature auto_MetadataDate = new PdfMetadataSignature("MetadataDate", "", "xmp");
     
        /**
         * <p>
         * Pdf Document creation tool metadata signature.
         * </p>
         */
        public static PdfMetadataSignature getCreatorTool(){ return auto_CreatorTool; }
        /**
         * <p>
         * Pdf Document creation tool metadata signature.
         * </p>
         */
        private void setCreatorTool(PdfMetadataSignature value){ auto_CreatorTool = value; }
        private static PdfMetadataSignature auto_CreatorTool = new PdfMetadataSignature("CreatorTool", "", "xmp");
     
        /**
         * <p>
         * Pdf Document modified date metadata property.
         * </p>
         */
        public static PdfMetadataSignature getModifyDate(){ return auto_ModifyDate; }
        /**
         * <p>
         * Pdf Document modified date metadata property.
         * </p>
         */
        private void setModifyDate(PdfMetadataSignature value){ auto_ModifyDate = value; }
        private static PdfMetadataSignature auto_ModifyDate = new PdfMetadataSignature("ModifyDate", "", "xmp");
     
        /**
         * <p>
         * Pdf Document Producer metadata property.
         * </p>
         */
        public static PdfMetadataSignature getProducer(){ return auto_Producer; }
        /**
         * <p>
         * Pdf Document Producer metadata property.
         * </p>
         */
        private void setProducer(PdfMetadataSignature value){ auto_Producer = value; }
        private static PdfMetadataSignature auto_Producer = new PdfMetadataSignature("Producer", "", "pdf");
     
        /**
         * <p>
         * Pdf Document Entry metadata property.
         * </p>
         */
        public static PdfMetadataSignature getEntry(){ return auto_Entry; }
        /**
         * <p>
         * Pdf Document Entry metadata property.
         * </p>
         */
        private void setEntry(PdfMetadataSignature value){ auto_Entry = value; }
        private static PdfMetadataSignature auto_Entry = new PdfMetadataSignature("Entry", "", "xmp");
         
        /**
         * <p>
         * Pdf Document creator metadata property
         * </p>
         */
        public static PdfMetadataSignature getKeywords(){ return auto_Keywords; }
        /**
         * <p>
         * Pdf Document creator metadata property
         * </p>
         */
        private void setKeywords(PdfMetadataSignature value){ auto_Keywords = value; }
        private static PdfMetadataSignature auto_Keywords = new PdfMetadataSignature("Keywords", "", "pdf");
     
        /**
         * <p>
         * Pdf Document Title metadata property
         * </p>
         */
        public static PdfMetadataSignature getTitle(){ return auto_Title; }
        /**
         * <p>
         * Pdf Document Title metadata property
         * </p>
         */
        private void setTitle(PdfMetadataSignature value){ auto_Title = value; }
        private static PdfMetadataSignature auto_Title = new PdfMetadataSignature("title", "", "dc");
     
        /**
         * <p>
         * Pdf Document Subject metadata property.
         * </p>
         */
        public static PdfMetadataSignature getSubject(){ return auto_Subject; }
        /**
         * <p>
         * Pdf Document Subject metadata property.
         * </p>
         */
        private void setSubject(PdfMetadataSignature value){ auto_Subject = value; }
        private static PdfMetadataSignature auto_Subject = new PdfMetadataSignature("subject", "", "dc");
     
        /**
         * <p>
         * Pdf Document Description metadata property.
         * </p>
         */
        public static PdfMetadataSignature getDescription(){ return auto_Description; }
        /**
         * <p>
         * Pdf Document Description metadata property.
         * </p>
         */
        private void setDescription(PdfMetadataSignature value){ auto_Description = value; }
        private static PdfMetadataSignature auto_Description = new PdfMetadataSignature("description", "", "dc");
        /**
         * <p>
         * Pdf Document creator metadata property.
         * </p>
         */
        public static PdfMetadataSignature getCreator(){ return auto_Creator; }
        /**
         * <p>
         * Pdf Document creator metadata property.
         * </p>
         */
        private void setCreator(PdfMetadataSignature value){ auto_Creator = value; }
        private static PdfMetadataSignature auto_Creator = new PdfMetadataSignature("creator", "", "dc");
    }
    ```
    
    Following example demonstrate using static Metadata Signatures to compose collection of signatures based method Clone(value) with given value of Signature to make clone of original instance.
    
    **Sign Pdf Document with Standard Metadata Signatures**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
    signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler(signConfig);
    // setup options with text of signature
    PdfMetadataSignOptions signMetadataOptions = new PdfMetadataSignOptions();
    // Using standard Pdf Metadata Signatures with new values
    MetadataSignature[] signatures = new MetadataSignature[]
    {
        PdfMetadataSignatures.getAuthor().deepClone("Mr.Scherlock Holmes"),
        PdfMetadataSignatures.getCreateDate().deepClone(DateTime.getNow().addDays(-1)),
        PdfMetadataSignatures.getMetadataDate().deepClone(DateTime.getNow().addDays(-2)),
        PdfMetadataSignatures.getCreatorTool().deepClone("GD.Signature-Test"),
        PdfMetadataSignatures.getModifyDate().deepClone(DateTime.getNow().addDays(-13)),
        PdfMetadataSignatures.getProducer().deepClone("GroupDocs-Producer"),
        PdfMetadataSignatures.getEntry().deepClone("Signature"),
        PdfMetadataSignatures.getKeywords().deepClone("GroupDocs, Signature, Metadata, Creation Tool"),
        PdfMetadataSignatures.getTitle().deepClone("Metadata Example"),
        PdfMetadataSignatures.getSubject().deepClone("Metadata Test Example"),
        PdfMetadataSignatures.getDescription().deepClone("Metadata Test example description"),
        PdfMetadataSignatures.getCreator().deepClone("GroupDocs.Signature"),
    };
    signMetadataOptions.getMetadataSignatures().addRange(signatures);
    // save option
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("CommonOperations_MultipleSignatureOptions");
    // sign document
    String signedPath = handler.<String>sign("test.pdf", collection, tmp0);
    System.out.print("Signed file path is: " + signedPath);
    ```
    
20.  **New class MetadataSignOptions **derives base SignOptions class and implement base properties and methods to specify Metadata Signature Options. It keeps collection of signatures and methods to manipulate signatures.
21.  **Metadata Sign Options properties**
    
    ```java
    /**
     * <p>
     * Represents abstract class of the Metadata Signature Options.
     * </p>
     */
    public abstract class MetadataSignOptions extends SignOptions
    {
        /**
         * <p>
         * Gets or sets the Metadata of signature.
         * </p>
         */
        public final MetadataSignatureCollection getMetadataSignatures(){ return auto_MetadataSignatures; }
        /**
         * <p>
         * Gets or sets the Metadata of signature.
         * </p>
         */
        public final void setMetadataSignatures(MetadataSignatureCollection value){ auto_MetadataSignatures = value; }
        private MetadataSignatureCollection auto_MetadataSignatures;
     
       
        /**
         * <p>
         * Initializes a new instance of the SignMetadataOptions class with default values.
         * </p>
         */
        protected MetadataSignOptions(){}
     
        /**
         * <p>
         * Initializes a new instance of the SignMetadataOptions class with Metadata.
         * </p>
         * @param signatures Collection of Metadata Signatures {@link MetadataSignature}.
         */
        protected MetadataSignOptions(ArrayList<MetadataSignature> signatures){}
    }
    ```
    
    Following example demonstrates using this options for Pdf Documents
    
    **Sign Pdf Document with Metadata Sign Options**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
    signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // setup options with text of signature
    PdfMetadataSignOptions signMetadataOptions = new PdfMetadataSignOptions();
    // Specify different Metadata Signatures and add them to options sigature collection
    // setup Author property
    PdfMetadataSignature mdSign_Author = new PdfMetadataSignature("Author", "Mr.Scherlock Holmes");
    signMetadataOptions.getMetadataSignatures().add(mdSign_Author);
    // setup data of document id
    PdfMetadataSignature mdSign_DocId = new PdfMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());
    signMetadataOptions.getMetadataSignatures().add(mdSign_DocId);
    // setup data of sign date
    PdfMetadataSignature mdSign_Date = new PdfMetadataSignature("SignDate", new Date(), "pdf");
    signMetadataOptions.getMetadataSignatures().add(mdSign_Date);
    // save options
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("CommonOperations_MultipleSignatureOptions");
    // sign document
    String signedPath = handler.<String>sign("test.pdf", collection, tmp0);
    System.out.print("Signed file path is: " + signedPath);
    ```
    
22.  **New abstract class SearchMetadataOptions **derives base SearchOptions class to specify criteria to search for Metadata Signatures inside the Documents.
    
    New public class **SearchMetadataOptions **was added to provide options to search for Metadata signatures within the Documents. This class derives base **SearchOptions**.
    
    **Metadata Search Options properties**
    
    ```java
    /**
     * <p>
     * Represents abstract search Options for Metadata Signatures.
     * </p>
     */
    public abstract class SearchMetadataOptions extends SearchOptions
    {
        /**
         * <p>
         * Specifies Metadata Signature name if it should be searched and matched.
         * </p>
         */
        public final String getName(){}
        /**
         * <p>
         * Specifies Metadata Signature name if it should be searched and matched.
         * </p>
         */
        public final void setName(String value){}
        private String auto_Name;
     
        /**
         * <p>
         * Get or set Metadata name Match Type search. It is used only when Name property is set.
         * </p>
         */
        public final int getNameMatchType(){}
        /**
         * <p>
         * Get or set Metadata name Match Type search. It is used only when Name property is set.
         * </p>
         */
        public final void setNameMatchType(int value){}
        private int auto_NameMatchType;
     
        /**
         * <p>
         * Initializes a new instance of the SearchMetadataOptions class with default values.
         * </p>
         */
        protected SearchMetadataOptions(){}
             
    }
    ```
    
23.  **New class PdfSearchMetadataOptions **derives base SearchMetadataOptions class to specify criteria to search for Metadata Signatures inside the Pdf Documents.  
    New public class **PdfSearchMetadataOptions **was added to provide options to search for Metadata signatures within the Documents. This class derives base **SearchOptions**.
    
    **PdfSearchMetadataOptions**
    
    ```java
    /**
     * <p>
     * Represents the Bar-code Signature Search Options for Pdf Documents.
     * </p>
     */
    public class PdfSearchMetadataOptions extends SearchMetadataOptions
    {
        /**
         * <p>
         * Initializes a new instance of the PdfSearchMetadataOptions class with default values.
         * </p>
         */
        public PdfSearchMetadataOptions(){}
    }
    ```
    
    Following example demonstrates searching for Metadata Signature inside the Pdf Documents
    
    
    
    ```java
    // setup Signature configuration
         SignatureConfig signConfig =new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
    // setup search options
    PdfSearchMetadataOptions searchOptions = new PdfSearchMetadataOptions();
     
    // search document
    SearchResult result = handler.search("SignedMetadata.pdf", searchOptions);
    // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        PdfMetadataSignature metadataSignature = Operators.as(signature, PdfMetadataSignature.class);
        if (metadataSignature != null)
        {
            Console.writeLine("Pdf Metadata: {0}:{1}  = {2}", metadataSignature.getTagPrefix(), metadataSignature.getName(), metadataSignature.toString());
        }
    }
    ```
    
24.  Properties **DocumentPageNumber**, **PagesSetup** and **SearchAllPages** in public class **SearchDigitalOptions **were marked as deprecated because they are not used in digital search workflow.
    
    **MatchType property**
    
    ```java
    /**
     * <p>
     * Get or set Text Match Type verification.
     * </p>
     */
    public final int getMatchType(){}
    /**
     * <p>
     * Get or set Text Match Type verification.
     * </p>
     */
    public final void setMatchType(int value){}
    private int auto_MatchType;
    ```
    
    This property can be set to Exact, StartsWith, EndsWith or Contains.
    
    Following example demonstrates using **MatchType** property to set type of text matching during verification.
    
    
    
    ```java
    public static void Main()
     {
         // setup Signature configuration
         SignatureConfig signConfig = new SignatureConfig();
         signConfig.setStoragePath("c:\\Aspose\\Test\\Storage");
         signConfig.setOutputPath("c:\\Aspose\\Test\\Output");
         // instantiating the signature handler
         SignatureHandler handler = new SignatureHandler(signConfig);
     
         // setup text verification options
         WordsVerifyTextOptions verifyOptions = new WordsVerifyTextOptions("John Smith");
     
         // set match type
         verifyOptions.setMatchType(TextMatchType.Contains);
         verifyOptions.getPagesSetup().setFirstPage(true);
     
         //verify document
         VerificationResult result = handler.verify("test_textsigned.docx", verifyOptions);
         System.out.print("Signed file verification result: " + result.isValid());
    }
    ```
    
25.  Properties **DocumentPageNumber**, **PagesSetup** and **SearchAllPages** in public class **SearchDigitalOptions **were marked as deprecated because they are not used in digital search workflow.
    
    **VerifyDigitalOptions properties**
    
    ```java
    /**
     * <p>
     * Gets or sets Document page number for searching.
     * </p>
     * @deprecated This property is deprecated and not supported for digital search.
     */
    @Deprecated
    public Integer getDocumentPageNumber(){}
     
    /**
     * <p>
     * Gets or sets Document page number for searching.
     * </p>
     * @deprecated This property is deprecated and not supported for digital search.
     */
    @Deprecated
    public  void setDocumentPageNumber(Integer value){}
     
     
    /**
     * <p>
     * Options to specify pages for Signature searching.
     * </p>
     * @deprecated This property is deprecated and not supported for digital search.
     */
    @Deprecated
    public PagesSetup getPagesSetup(){}
    /**
     * <p>
     * Options to specify pages for Signature searching.
     * </p>
     * @deprecated This property is deprecated and not supported for digital search.
     */
    @Deprecated
    public void setPagesSetup(PagesSetup value){}
    ```
    
26.  Public class **SignTextOptions ** was updated - obsolete property for system Brush **BackgroundBrush** was removed.  
    
    Since 18.11 version only alternative property BackgroundBrushStyle is supported to specify different brush styles for background effects.
    
    Use only property **BackgroundBrushStyle **instead.
    
    **Obsolete Brush property**
    
    ```java
    /**
     * <p>
     * Gets or sets the signature background brush. Value by default is null. 
     * If this property has a value it will be used instead BackgroundBrush property.
     * </p>
     */
    public com.groupdocs.signature.domain.extensions.Brush getBackgroundBrushStyle(){}
    /**
     * <p>
     * Gets or sets the signature background brush. Value by default is null. 
     * If this property has a value it will be used instead BackgroundBrush property.
     * </p>
     */
    public void setBackgroundBrushStyle(com.groupdocs.signature.domain.extensions.Brush value){}
    private com.groupdocs.signature.domain.extensions.Brush auto_BackgroundBrushStyle;
    ```
