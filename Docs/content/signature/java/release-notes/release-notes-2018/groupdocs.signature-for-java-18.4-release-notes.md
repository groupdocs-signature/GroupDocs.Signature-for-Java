---
id: groupdocs-signature-for-java-18-4-release-notes
url: signature/java/groupdocs-signature-for-java-18-4-release-notes
title: GroupDocs.Signature for Java 18.4 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 18.4{{< /alert >}}

## Major Features

There are about 20 improvements, new features and fixes in this regular release. Most new features are related to Barcode/QR-Code Signatures searching and Brush extensions to support different brush styles. The most notable changes are:

*   Introduced Barcode Signatures search for all supported Document types including Images
*   Implemented events for Search process to notify about start, progress and complete events
*   Updated Dynamic Metered library with latest changes and fixes
*   Introduced QR-Code Signatures search for all supported Document types including Images
*   Implemented new Brush extension for Signature appearance
*   Introduced Solid Brush style, Gradient Brush style, Radial Gradient Brush style
*   Fixed Pages Setup calculations for single page Documents
*   Updated classes, methods and properties with detailed comments
*   Marked few properties as obsolete and removed old obsolete classes and properties

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-3357 | Implement ability to obtain Search Progress | New Feature |
| SIGNATURENET-3356 | Implement rectangle property to set borders of ellipse for BrushRadialGradient | New Feature |
| SIGNATURENET-3352 | Implement ability to obtain QR-Code Signatures from Image Documents | New Feature |
| SIGNATURENET-3349 | Implement ability to obtain QR-Code Signatures from Words Documents | New Feature |
| SIGNATURENET-3346 | Implement ability to obtain QR-Code Signatures from Slides Documents | New Feature |
| SIGNATURENET-3343 | Implement ability to obtain QR-Code Signatures from Cells Documents | New Feature |
| SIGNATURENET-3340 | Implement ability to obtain QR-Code Signatures from Pdf Documents | New Feature |
| SIGNATURENET-3336 | Implement ability to obtain Barcode Signatures from Image Documents | New Feature |
| SIGNATURENET-3333 | Implement ability to obtain Barcode Signatures from Slides Documents | New Feature |
| SIGNATURENET-3330 | Implement ability to obtain Barcode Signatures from Words Documents | New Feature |
| SIGNATURENET-3320 | Implement ability to obtain Barcode Signatures from Cells Documents | New Feature |
| SIGNATURENET-3247 | Implement ability to obtain Barcode Signatures from Pdf Documents | New Feature |
| SIGNATURENET-3361 | Update Dynamic Metered library with latest changes | Improvement |
| SIGNATURENET-3355 | Implement Radial Gradient Brush class as Separate class (alternative of Drawing.Brush) | Improvement |
| SIGNATURENET-3329 | Implement Solid Brush class as Separate class (alternative of Drawing.Brush) | Improvement |
| SIGNATURENET-3328 | Implement Linear Gradient Brush class as Separate class (alternative of Drawing.Brush) | Improvement |
| SIGNATURENET-3327 | Implement Texture Brush class as Separate class (alternative of Drawing.Brush) | Improvement |
| SIGNATURENET-3278 | Mark Brush property as Obsolete | Improvement |
| SIGNATURENET-3367 | Multiple options on Pages Setup give duplicate page numbers | Bug |
| SIGNATURENET-3286 | Improve result of Signing methods when Document provided by URL | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 18.4. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  **Introduced Search of Barcode Signatures** in supported Document types. Added scope of classes to specify search barcode options. Base abstract class **SearchBarcodeOptions** derives base **SearchOptions** and describes properties to specify criteria for Barcode search like encode type, text and text match type. For each Document type few inherited classes were added like **PdfSearchBarcodeOptions**, **CellsSearchBarcodeOptions**, **ImagesSearchBarcodeOptions**, **SlidesSearchBarcodeOptions** and **WordsSearchBarcodeOptions**
    
    New abstract class **SearchBarcodeOptions** was added to provide base properties for Barcode search support from Documents. Class contains optional different search criteria like Barcode encode type, encoded text and different options for text matching.
    
    **SearchBarcodeOptions**
    
    ```java
    public abstract class SearchBarcodeOptions extends SearchOptions
    {
        /**
         * <p>
         * Specifies Encode Type property to search Bar-codes.
         * If this value is not set, search is processed for all supported Bar-code Types
         * </p>
         */   
        public BarcodeType getEncodeType(){ return auto_EncodeType; }   
        /**
         * <p>
         * Specifies Encode Type property to search Bar-codes.
         * If this value is not set, search is processed for all supported Bar-code Types
         * </p>
         */   
        public void setEncodeType(BarcodeType value){ auto_EncodeType = value; }
        private BarcodeType auto_EncodeType;
        /**
         * <p>
         * Specifies Bar-code Signature text if it should be searched and matched.
         * </p>
         */   
        public String getText(){ return auto_Text; }
        /**
         * <p>
         * Specifies Bar-code Signature text if it should be searched and matched.
         * </p>
         */   
        public void setText(String value){ auto_Text = value; }
        private String auto_Text;
        /**
         * <p>
         * Get or set Bar-code text Match Type search. It is used only when Text property is set.
         * </p>
         */   
        public int getMatchType(){ return auto_MatchType; }
        /**
         * <p>
         * Get or set Bar-code text Match Type search. It is used only when Text property is set.
         * </p>
         */   
        public void setMatchType(int value){ auto_MatchType = value; }
        private int auto_MatchType;
     
        /**
         * <p>
         * Initializes a new instance of the SearchBarcodeOptions class with default values.
         * </p>
         */   
        public SearchBarcodeOptions()
        
        /**
         * <p>
         * Initializes a new instance of the SearchBarcodeOptions class with encode type value.
         * </p>
         * @param encodeType Specifies Barcode encode type.
         */
         
        public SearchBarcodeOptions(BarcodeType encodeType)    
     
        /**
         * <p>
         * Initializes a new instance of the SearchBarcodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies Barcode encode type.
         * @param text Set Text of Barcode signature.
         */
        
        public SearchBarcodeOptions(BarcodeType encodeType, String text)   
     
    }
    ```
    
    1\. Property **EncodeType** is optional, if this field is set Search method of Signature Handler will collect only Barcodes with specified Encode type inside the Document.
    
    2\. Property **Text** is optional, if this field is set Search method of Signature Handler will collect only Barcodes with specified encoded text that matches provided. The match type is specified by **MatchType ** property.
    
    3\. Property **MatchType **is optional, this enumeration provides the way to match Barcode text and specified text.
    
    **MatchType**
    
    ```java
    /// <summary>
    /// Specifies Text Match type in string - Exact, StartsWith, EndsWith, Contains
    /// </summary>
    public final class TextMatchType extends Enum
    {
       private TextMatchType(){}  
        /**
         * <p>
         * Text is fully match.
         * </p>
         */
        public static final int Exact = 0;
     
        /**
         * <p>
         * Text starts with value.
         * </p>
         */
        public static final int StartsWith = 1;
     
        /**
         * <p>
         * Text ends with value.
         * </p>
         */
        public static final int EndsWith = 2;
     
        /**
         * <p>
         * Text contains the value.
         * </p>
         */
        public static final int Contains = 3;
     }
    ```
    
    New class **PdfSearchBarcodeOptions** was added to provide Search Barcode properties for Pdf Documents. Class derives base SearchBarcodeOptions and contains different constructors.
    
    **PdfSearchBarcodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the Bar-code Signature Search Options for Pdf Documents.
     * </p>
     */
    public class PdfSearchBarcodeOptions extends SearchBarcodeOptions
    {
        /**
         * <p>
         * Initializes a new instance of the PdfSearchBarcodeOptions class with default values.
         * </p>
         */
        
        public PdfSearchBarcodeOptions()  
     
        /**
         * <p>
         * Initializes a new instance of the PdfSearchBarcodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies Bar-code encode type.
         */
       
        public PdfSearchBarcodeOptions(BarcodeType encodeType)
        
        /**
         * <p>
         * Initializes a new instance of the PdfSearchBarcodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies Bar-code encode type.
         * @param text Set Text of Bar-code signature to search for.
         */
        
        public PdfSearchBarcodeOptions(BarcodeType encodeType, String text)
         
    }
    ```
    
    Following example demonstrates how to search Barcode Signatures in Pdf Documents
    
    **Search Barcode Signatures in Pdf Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
      
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
    searchOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
        // specify barcode text to search
    searchOptions.setText("12345678");
        // specify text math type
    searchOptions.setMatchType(TextMatchType.Contains);
        // search document
    SearchResult result = handler.search("SignedBarCode.pdf", searchOptions);
        // output signatures
    for(BaseSignature signature : result.getSignatures())
    {
        BarcodeSignature bcSignature = Operators.as(signature, BarcodeSignature.class);
        if(bcSignature != null)
        {
            Console.writeLine("Found Barcode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
    New class **CellsSearchBarcodeOptions** was added to provide Search Barcode properties for Cells Documents. Class derives base SearchBarcodeOptions and contains different constructors.
    
    **CellsSearchBarcodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the Bar-code Signature Search Options for Cells Documents.
     * </p>
     */
    public class CellsSearchBarcodeOptions extends SearchBarcodeOptions
    {    
        /**
         * <p>
         * Initializes a new instance of the CellsSearchBarcodeOptions class with default values.
         * </p>
         */
        
        public CellsSearchBarcodeOptions()
          /**
         * <p>
         * Initializes a new instance of the CellsSearchBarcodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies Bar-code encode type.
         */
        
        public CellsSearchBarcodeOptions(BarcodeType encodeType)
         
        /**
         * <p>
         * Initializes a new instance of the CellsSearchBarcodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies Bar-code encode type.
         * @param text Set Text of Barcode signature to search for.
         */
        
        public CellsSearchBarcodeOptions(BarcodeType encodeType, String text)
         
    }
    ```
    
    Following example demonstrates how to search Barcode Signatures in Cells Documents
    
    **Search Barcode Signatures in Cells Documents**
    
    ```java
    // setup Signature configuration            
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
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
    searchOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
        // specify barcode text to search
    searchOptions.setText("12345678");
        // specify text math type
    searchOptions.setMatchType(TextMatchType.Contains);
        // search document
    SearchResult result = handler.search("SignedBarCode.xls", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        BarcodeSignature bcSignature = Operators.as(signature, BarcodeSignature.class);
        if (bcSignature != null)
        {
            Console.writeLine("Found Barcode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
    New class **ImagesSearchBarcodeOptions **was added to provide Search Barcode properties for Images. Class derives base SearchBarcodeOptions and contains different constructors.
    
    **ImagesSearchBarcodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the Bar-code Signature Search Options for Images Documents.
     * </p>
     */
    public class ImagesSearchBarcodeOptions extends SearchBarcodeOptions
    {
        /**
         * <p>
         * Initializes a new instance of the ImagesSearchBarcodeOptions class with default values.
         * </p>
         */
         
        public ImagesSearchBarcodeOptions()
        /**
         * <p>
         * Initializes a new instance of the ImagesSearchBarcodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies Bar-code encode type.
         */
       
        public ImagesSearchBarcodeOptions(BarcodeType encodeType)
       /**
         * <p>
         * Initializes a new instance of the ImagesSearchBarcodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies Barcode encode type.
         * @param text Set Text of Barcode signature to search for.
         */
         
        public ImagesSearchBarcodeOptions(BarcodeType encodeType, String text)
       
    }
    ```
    
    Following example demonstrates how to search Barcode Signatures in Images
    
    **Search Barcode Signatures in Images Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() + "\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
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
    searchOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
        // specify barcode text to search
    searchOptions.setText("12345678");
        // specify text math type
    searchOptions.setMatchType(TextMatchType.Contains);
        // search document
    SearchResult result = handler.search("SignedBarCode.png", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        BarcodeSignature bcSignature = Operators.as(signature, BarcodeSignature.class);
        if (bcSignature != null)
        {
            Console.writeLine("Found Barcode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
    New class **SlidesSearchBarcodeOptions **was added to provide Search Barcode properties for Slides Documents. Class derives base SearchBarcodeOptions and contains different constructors.
    
    **SlidesSearchBarcodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the QR-code Signature Search Options for Slides Documents.
     * </p>
     */
    public class SlidesSearchQRCodeOptions extends SearchQRCodeOptions
    {
        /**
         * <p>
         * Initializes a new instance of the SlidesSearchQRCodeOptions class with default values.
         * </p>
         */
      
        public SlidesSearchQRCodeOptions()
        /**
         * <p>
         * Initializes a new instance of the SlidesSearchQRCodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         */
     
        public SlidesSearchQRCodeOptions(QRCodeType encodeType)
        /**
         * <p>
         * Initializes a new instance of the SlidesSearchQRCodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         * @param text Set Text of QR-code signature to search for.
         */
     
        public SlidesSearchQRCodeOptions(QRCodeType encodeType, String text)
     
    }
    ```
    
    Following example demonstrates how to search Barcode Signatures in Slides Documents
    
    **Search Barcode Signatures in Slides Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
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
    searchOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
        // specify barcode text to search
    searchOptions.setText("12345678");
        // specify text math type
    searchOptions.setMatchType(TextMatchType.Contains);
        // search document
    SearchResult result = handler.search("SignedBarCode.Pptx", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        BarcodeSignature bcSignature = Operators.as(signature, BarcodeSignature.class);
        if (bcSignature != null)
        {
            Console.writeLine("Found Barcode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
    New class **WordsSearchBarcodeOptions **was added to provide Search Barcode properties for Words Documents. Class derives base SearchBarcodeOptions and contains different constructors.
    
    **WordsSearchBarcodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the Bar-code Signature Search Options for Words Documents.
     * </p>
     */
    public class WordsSearchBarcodeOptions extends SearchBarcodeOptions
    {
        /**
         * <p>
         * Initializes a new instance of the WordsSignTextOptions class with default values.
         * </p>
         */
        
        public WordsSearchBarcodeOptions()
        /**
         * <p>
         * Initializes a new instance of the WordsSearchBarcodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies Bar-code encode type.
         */
         
        public WordsSearchBarcodeOptions(BarcodeType encodeType)
       /**
         * <p>
         * Initializes a new instance of the WordsSearchBarcodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies Bar-code encode type.
         * @param text Set Text of Bar-code signature to search for.
         */
      
        public WordsSearchBarcodeOptions(BarcodeType encodeType, String text)
        
    }
    ```
    
    Following example demonstrates how to search Barcode Signatures in Words Documents
    
    **Search Barcode Signatures in Words Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() + "\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
        // setup search options
    WordsSearchBarcodeOptions searchOptions = new WordsSearchBarcodeOptions();
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
    searchOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
        // specify barcode text to search
    searchOptions.setText("12345678");
        // specify text math type
    searchOptions.setMatchType(TextMatchType.Contains);
        // search document
    SearchResult result = handler.search("SignedBarCode.docx", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        BarcodeSignature bcSignature = Operators.as(signature, BarcodeSignature.class);
        if (bcSignature != null)
        {
            Console.writeLine("Found Barcode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
2.  New classes to keep Barcode Signatures were added. Base class **BarcodeSignature** that keeps properties of Barcode Signature like Barcode encode type, coded text. Added derived classes **PdfBarcodeSignature**, **ImagesBarcodeSignature**, **CellsBarcodeSignature**, **SlidesBarcodeSignature** and **WordsBarcodeSignature**
    
    New abstract class **BarcodeSignature** was added to specify base properties of Barcode Signature like Barcode encode type, coded text.
    
    **BarcodeSignature**
    
    ```java
    /**
     * <p>
     * Contains Bar-code Signature properties.
     * </p>
     */
    public abstract class BarcodeSignature extends BaseSignature
    {
        /**
         * <p>
         * Specifies the Bar-code Encode Type.
         * </p>
         */
       
        public BarcodeType getEncodeType(){ return auto_EncodeType; }
     
     
        /**
         * <p>
         * Specifies the Bar-code Encode Type.
         * </p>
         */
         
        public void setEncodeType(BarcodeType value){ auto_EncodeType = value; }
        private BarcodeType auto_EncodeType;
     
        /**
         * <p>
         * Specifies text of Bar-code.
         * </p>
         */
        
        public String getText(){ return auto_Text; }
        /**
         * <p>
         * Specifies text of Bar-code.
         * </p>
         */
         
        public void setText(String value){ auto_Text = value; }
        private String auto_Text;
     
        /**
         * <p>
         * Initialize BarcodeSignature with default parameters.
         * </p>
         */
         
        public BarcodeSignature()
       
     
        /**
         * <p>
         * Initialize BarcodeSignature with specified Encode Type.
         * </p>
         * @param encodeType Encode type of Bar-code.
         * @param text Bar-code text property.
         */
        
        public BarcodeSignature(BarcodeType encodeType, String text)
       
    }
    ```
    
    New class **PdfBarcodeSignature **was added to specify properties of Barcode Signature from Pdf Documents. Class inherits base BarcodeSignature properties and contains few constructors.
    
    **PdfBarcodeSignature**
    
    ```java
    /**
     * <p>
     * Describes Bar-code Signature of Pdf Documents.
     * </p>
     */
    public class PdfBarcodeSignature extends BarcodeSignature
    {
        /**
         * <p>
         * Initialize PDF Bar-code Signature with default values.
         * </p>
         */
     
        public PdfBarcodeSignature()
       /**
         * <p>
         * Initialize PDF Bar-code Signature with specified Encode Type and text.
         * </p>
         * @param encodeType Encode type of Bar-code.
         * @param text Bar-code text property.
         */
     
        public PdfBarcodeSignature(BarcodeType encodeType, String text)
     
    }
    ```
    
    New class **ImagesBarcodeSignature **was added to specify properties of Barcode Signature from Images. Class inherits base BarcodeSignature properties and contains few constructors.
    
    **ImagesBarcodeSignature**
    
    ```java
     /**
      * <p>
      * Describes Bar-code Signature of Images Documents.
      * </p>
      */
    public class ImagesBarcodeSignature extends BarcodeSignature
    {
        /**
         * <p>
         * Initialize Images Bar-code Signature.
         * </p>
         */
       
        public ImagesBarcodeSignature()
        /**
         * <p>
         * Initialize Images Bar-code Signature with specified Encode Type and text.
         * </p>
         * @param encodeType Encode type of Bar-code.
         * @param text Bar-code text property.
         */
      
        public ImagesBarcodeSignature(BarcodeType encodeType, String text)
     
    }
    ```
    
    New class **CellsBarcodeSignature **was added to specify properties of Barcode Signature from Cells Documents. Class inherits base BarcodeSignature properties and contains few constructors.
    
    **CellsBarcodeSignature**
    
    ```java
    /**
     * <p>
     * Describes Bar-code Signature of Cells Documents.
     * </p>
     */
    public class CellsBarcodeSignature extends BarcodeSignature
    {
        /**
         * <p>
         * Initialize Cells Bar-code Signature.
         * </p>
         */
       
        public CellsBarcodeSignature()
       /**
         * <p>
         * Initialize Cells Bar-code Signature with specified Encode Type and text.
         * </p>
         * @param encodeType Encode type of Bar-code.
         * @param text Bar-code text property.
         */
       
        public CellsBarcodeSignature(BarcodeType encodeType, String text)
        
    }
    ```
    
    New class **SlidesBarcodeSignature **was added to specify properties of Barcode Signature from Slides Documents. Class inherits base BarcodeSignature properties and contains few constructors.
    
    **SlidesBarcodeSignature**
    
    ```java
    /**
     * <p>
     * Describes Bar-code Signature of Slides Documents.
     * </p>
     */
    public class SlidesBarcodeSignature extends BarcodeSignature
    {
        /**
         * <p>
         * Initialize Slides Bar-code Signature with default values.
         * </p>
         */
        
        public SlidesBarcodeSignature()
        /**
         * <p>
         * Initialize Slides Bar-code Signature with specified Encode Type and text.
         * </p>
         * @param encodeType Encode type of Bar-code.
         * @param text Bar-code text property.
         */
       
        public SlidesBarcodeSignature(BarcodeType encodeType, String text)
        
    }
    ```
    
    New class **WordsBarcodeSignature **was added to specify properties of Barcode Signature from Words Documents. Class inherits base BarcodeSignature properties and contains few constructors.
    
    **WordsBarcodeSignature**
    
    ```java
    /**
     * <p>
     * Describes Bar-code Signature of Words Documents.
     * </p>
     */
    public class WordsBarcodeSignature extends BarcodeSignature
    {
         /**
         * <p>
         * Initialize Words Bar-code Signature with default values.
         * </p>
         */
       
        public WordsBarcodeSignature()
      /**
         * <p>
         * Initialize Words Bar-code Signature with specified Encode Type and text.
         * </p>
         * @param encodeType Encode type of Bar-code.
         * @param text Bar-code Text property.
         */
       
        public WordsBarcodeSignature(BarcodeType encodeType, String text)
     
    }
    ```
    
3.  **Introduced Search of QR-Code Signatures** in supported Document types. Added scope of classes to specify search QR-Code options. Base abstract class **SearchQRCodeOptions** derives base **SearchOptions** and describes properties to specify criteria for QR-Code search like encode type, text and text match type. For each Document type few inherited classes were added like **PdfSearchQRCodeOptions**, **CellsSearchQRCodeOptions**, **ImagesQRCodeSignature**, **SlidesSearchQRCodeOptions** and **WordsSearchQRCodeOptions**
    
    New abstract class **SearchQRCodeOptions** was added to provide base properties for QR-Code search support from Documents. Class contains optional different search criteria like QR-Code encode type, encoded text and different options for text matching.
    
    **SearchQRCodeOptions**
    
    ```java
    /**
     * <p>
     * Represents abstract search Options for QR-Code Signatures.
     * </p>
     */
    public abstract class SearchQRCodeOptions extends SearchOptions
    {
         /**
         * <p>
         * Specifies Encode Type property to search QR-Codes.
         * If this value is not set, search is processed for all supported QR-Code Types.
         * </p>
         */
        
        public QRCodeType getEncodeType(){ return auto_EncodeType; }
       /**
         * <p>
         * Specifies Encode Type property to search QR-Codes.
         * If this value is not set, search is processed for all supported QR-Code Types.
         * </p>
         */
       
        public void setEncodeType(QRCodeType value){ auto_EncodeType = value; }
        private QRCodeType auto_EncodeType;
     
        /**
         * <p>
         * Specifies QR-Code Signature Text if it should be searched and matched.
         * </p>
         */
      
        public String getText(){ return auto_Text; }
        /**
         * <p>
         * Specifies QR-Code Signature Text if it should be searched and matched.
         * </p>
         */
     
        public void setText(String value){ auto_Text = value; }
        private String auto_Text;
     
        /**
         * <p>
         * Get or set QR-Code Text Match Type search. It is used only when Text property is set.
         * </p>
         */
         
        public int getMatchType(){ return auto_MatchType; }
        /**
         * <p>
         * Get or set QR-Code Text Match Type search. It is used only when Text property is set.
         * </p>
         */
      
        public void setMatchType(int value){ auto_MatchType = value; }
        private int auto_MatchType;
     
     
        /**
         * <p>
         * Initializes a new instance of the SearchQRCodeOptions class with default values.
         * </p>
         */
        
        public SearchQRCodeOptions()
       /**
         * <p>
         * Initializes a new instance of the SearchQRCodeOptions class with encode type value.
         * </p>
         * @param encodeType Specifies QR-Code encode type.
         */
     
        public SearchQRCodeOptions(QRCodeType encodeType)
       /**
         * <p>
         * Initializes a new instance of the SearchQRCodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies QR-Code encode type.
         * @param text Set Text of QR-Code signature.
         */
      
        public SearchQRCodeOptions(QRCodeType encodeType, String text)
     
     
    }
    ```
    
    1\. Property **EncodeType** is optional, if this field is set Search method of Signature Handler will collect only QR-Codes with specified Encode type inside the Document
    
    2\. Property **Text** is optional, if this field is set Search method of Signature Handler will collect only QR-Codes with specified encoded text that matches provided. The match type is specified by **MatchType ** property.
    
    3\. Property **MatchType **is optional, this enumeration provides the way to match QR-Code text and specified text.
    
    New class **PdfSearchQRCodeOptions** was added to provide Search QR-Code properties for Pdf Documents. Class derives base SearchQRCodeOptions and contains different constructors.
    
    **PdfSearchQRCodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the QR-code Signature Search Options for Pdf Documents.
     * </p>
     */
    public class PdfSearchQRCodeOptions extends SearchQRCodeOptions
    {
        /**
         * <p>
         * Initializes a new instance of the PdfSearchQRCodeOptions class with default values.
         * </p>
         */
       
        public PdfSearchQRCodeOptions()
       /**
         * <p>
         * Initializes a new instance of the PdfSearchQRCodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         */
      
        public PdfSearchQRCodeOptions(QRCodeType encodeType)
      /**
         * <p>
         * Initializes a new instance of the PdfSearchQRCodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         * @param text Set Text of QR-code signature to search for.
         */
      
        public PdfSearchQRCodeOptions(QRCodeType encodeType, String text)
     
    }
    ```
    
    Following example demonstrates how to search QR-Code Signatures in Pdf Documents
    
    **Search QR-Code Signatures in Pdf Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
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
    SearchResult result = handler.search("SignedQRCode.pdf", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        QRCodeSignature bcSignature = Operators.as(signature, QRCodeSignature.class);
        if (bcSignature != null)
        {
            Console.writeLine("Found QRCode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
    New class **CellsSearchQRCodeOptions** was added to provide Search QR-Code properties for Cells Documents. Class derives base SearchQRCodeOptions and contains different constructors.
    
    **CellsSearchQRCodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the QR-code Signature Search Options for Cells Documents.
     * </p>
     */
    public class CellsSearchQRCodeOptions extends SearchQRCodeOptions
    {
        /**
         * <p>
         * Initializes a new instance of the CellsSearchQRCodeOptions class with default values.
         * </p>
         */
     
        public CellsSearchQRCodeOptions()
        /**
         * <p>
         * Initializes a new instance of the CellsSearchQRCodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         */
     
        public CellsSearchQRCodeOptions(QRCodeType encodeType)
        /**
         * <p>
         * Initializes a new instance of the CellsSearchQRCodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         * @param text Set Text of QR-code signature to search for.
         */
     
        public CellsSearchQRCodeOptions(QRCodeType encodeType, String text)
     
    }
    ```
    
    Following example demonstrates how to search QR-Code Signatures in Cells Documents
    
    **Search QR-Code Signatures in Cells Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
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
    SearchResult result = handler.search("SignedQRCode.xls", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        QRCodeSignature bcSignature = Operators.as(signature, QRCodeSignature.class);
        if (bcSignature != null)
        {
            Console.writeLine("Found QRCode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
    New class **ImagesSearchQRCodeOptions** was added to provide Search QR-Code properties for Images Documents. Class derives base SearchQRCodeOptions and contains different constructors.
    
    **ImagesSearchQRCodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the QR-code Signature Search Options for Images Documents.
     * </p>
     */
    public class ImagesSearchQRCodeOptions extends SearchQRCodeOptions
    {
        /**
         * <p>
         * Initializes a new instance of the ImagesSearchQRCodeOptions class with default values.
         * </p>
         */
     
        public ImagesSearchQRCodeOptions()
        /**
         * <p>
         * Initializes a new instance of the ImagesSearchQRCodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         */
       
        public ImagesSearchQRCodeOptions(QRCodeType encodeType)
        /**
         * <p>
         * Initializes a new instance of the ImagesSearchQRCodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         * @param text Set Text of QR-code signature to search for.
         */
     
        public ImagesSearchQRCodeOptions(QRCodeType encodeType, String text)
     
    }
    ```
    
    Following example demonstrates how to search QR-Code Signatures in Images Documents
    
    **Search QR-Code Signatures in Images Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
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
    SearchResult result = handler.search("SignedQRCode.png", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        QRCodeSignature bcSignature = Operators.as(signature, QRCodeSignature.class);
        if (bcSignature != null)
        {
            Console.writeLine("Found QRCode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
    New class **SlidesSearchQRCodeOptions** was added to provide Search QR-Code properties for Slides Documents. Class derives base SearchQRCodeOptions and contains different constructors.
    
    **SlidesSearchQRCodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the QR-code Signature Search Options for Slides Documents.
     * </p>
     */
    public class SlidesSearchQRCodeOptions extends SearchQRCodeOptions
    {
        /**
         * <p>
         * Initializes a new instance of the SlidesSearchQRCodeOptions class with default values.
         * </p>
         */
      
        public SlidesSearchQRCodeOptions()
        /**
         * <p>
         * Initializes a new instance of the SlidesSearchQRCodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         */
     
        public SlidesSearchQRCodeOptions(QRCodeType encodeType)
        /**
         * <p>
         * Initializes a new instance of the SlidesSearchQRCodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         * @param text Set Text of QR-code signature to search for.
         */
     
        public SlidesSearchQRCodeOptions(QRCodeType encodeType, String text)
     
    }
    ```
    
    Following example demonstrates how to search QR-Code Signatures in Slides Documents
    
    **Search QR-Code Signatures in Slides Documents**
    
    ```java
     // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
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
    SearchResult result = handler.search("SignedQRCode.pptx", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        QRCodeSignature bcSignature = Operators.as(signature, QRCodeSignature.class);
        if (bcSignature != null)
        {
            Console.writeLine("Found QRCode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
    New class **WordsSearchQRCodeOptions ** was added to provide Search QR-Code properties for Words Documents. Class derives base SearchQRCodeOptions and contains different constructors.
    
    **WordsSearchQRCodeOptions**
    
    ```java
    /**
     * <p>
     * Represents the QR-code Signature Search Options for Words Documents.
     * </p>
     */
    public class WordsSearchQRCodeOptions extends SearchQRCodeOptions
    {
        /**
         * <p>
         * Initializes a new instance of the WordsSearchQRCodeOptions class with default values.
         * </p>
         */
     
        public WordsSearchQRCodeOptions()
       /**
         * <p>
         * Initializes a new instance of the WordsSearchQRCodeOptions class with encode type.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         */
     
        public WordsSearchQRCodeOptions(QRCodeType encodeType)
        /**
         * <p>
         * Initializes a new instance of the WordsSearchQRCodeOptions class with encode type and text values.
         * </p>
         * @param encodeType Specifies QR-code encode type.
         * @param text Set Text of QR-code signature to search for.
         */
       
        public WordsSearchQRCodeOptions(QRCodeType encodeType, String text)
      
    }
    ```
    
    Following example demonstrates how to search QR-Code Signatures in Words Documents
    
    **Search QR-Code Signatures in Words Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
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
    SearchResult result = handler.search("SignedQRCode.docx", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        QRCodeSignature bcSignature = Operators.as(signature, QRCodeSignature.class);
        if (bcSignature != null)
        {
            Console.writeLine("Found QRCode signature: {0} with text {1}", bcSignature.getEncodeType().getTypeName(), bcSignature.getText());
        }
    }
    ```
    
4.  New classes to keep QR-Code Signatures were added. Base class **QRCodeSignature** that keeps properties of QR-Code Signature like QR-Code encode type, coded text. Added derived classes **PdfQRCodeSignature**, **ImagesQRCodeSignature**, **CellsQRCodeSignature**, **SlidesQRCodeSignature** and **WordsQRCodeSignature**  
    New abstract class **QRCodeSignature **was added to specify base properties of QR-code Signature like QR-code encode type, coded text.
    
    **QRCodeSignature**
    
    ```java
    /**
     * <p>
     * Contains QR-code Signature properties.
     * </p>
     */
    public abstract class QRCodeSignature extends BaseSignature
    {
        /**
         * <p>
         * Specifies the QR-code Encode Type.
         * </p>
         */
        
        public QRCodeType getEncodeType(){ return auto_EncodeType; }
       /**
         * <p>
         * Specifies the QR-code Encode Type.
         * </p>
         */
        
        public void setEncodeType(QRCodeType value){ auto_EncodeType = value; }
        private QRCodeType auto_EncodeType;
     
        /**
         * <p>
         * Specifies text of QR-code.
         * </p>
         */
      
        public String getText(){ return auto_Text; }
        /**
         * <p>
         * Specifies text of QR-code.
         * </p>
         */
       
        public void setText(String value){ auto_Text = value; }
        private String auto_Text;
     
        /**
         * <p>
         * Initialize QRCodeSignature with default parameters.
         * </p>
         */
      
        public QRCodeSignature()
        /**
         * <p>
         * Initialize QRCodeSignature with specified Encode Type.
         * </p>
         * @param encodeType Encode type of QR-code.
         * @param text QR-code text property.
         */
      
        public QRCodeSignature(QRCodeType encodeType, String text)
       
    }
    ```
    
    New class **PdfQRCodeSignature **was added to specify properties of QR-Code Signature from Pdf Documents. Class inherits base QRCodeSignature properties and contains few constructors.
    
    **PdfQRCodeSignature**
    
    ```java
    /**
     * <p>
     * Describes QR-Code Signature of Pdf Documents.
     * </p>
     */
    public class PdfQRCodeSignature extends QRCodeSignature
    {
       /**
         * <p>
         * Initialize PDF QR-Code Signature with default values.
         * </p>
         */
     
        public PdfQRCodeSignature()
       /**
         * <p>
         * Initialize PDF QR-Code Signature with specified Encode Type and text.
         * </p>
         * @param encodeType Encode type of QR-Code.
         * @param text QR-Code text property.
         */
     
        public PdfQRCodeSignature(QRCodeType encodeType, String text)
     
    }
    ```
    
    New class **ImagesQRCodeSignature **was added to specify properties of QR-Code Signature from Images Documents. Class inherits base QRCodeSignature properties and contains few constructors.
    
    **ImagesQRCodeSignature**
    
    ```java
    /**
     * <p>
     * Describes QR-Code Signature of Images Documents.
     * </p>
     */
    public class ImagesQRCodeSignature extends QRCodeSignature
    {
       /**
         * <p>
         * Initialize Images QR-Code Signature with default values.
         * </p>
         */
       
        public ImagesQRCodeSignature()
        /**
         * <p>
         * Initialize Images QR-Code Signature with specified Encode Type and text.
         * </p>
         * @param encodeType Encode type of QR-Code.
         * @param text QR-Code text property.
         */
       
        public ImagesQRCodeSignature(QRCodeType encodeType, String text)
      
    }
    ```
    
    New class **CellsQRCodeSignature **was added to specify properties of QR-Code Signature from Cells Documents. Class inherits base QRCodeSignature properties and contains few constructors.
    
    **CellsQRCodeSignature**
    
    ```java
    /**
     * <p>
     * Describes QR-Code Signature of Cells Documents.
     * </p>
     */
    public class CellsQRCodeSignature extends QRCodeSignature
    {
        /**
         * <p>
         * Initialize Cells QR-Code Signature with default values.
         * </p>
         */
       
        public CellsQRCodeSignature()
       /**
         * <p>
         * Initialize Cells QR-Code Signature with specified Encode Type and text.
         * </p>
         * @param encodeType Encode type of QR-Code.
         * @param text QR-Code text property.
         */
        
        public CellsQRCodeSignature(QRCodeType encodeType, String text)
         
    }
    ```
    
    New class **WordsQRCodeSignature **was added to specify properties of QR-code Signature from Words Documents. Class inherits base QRCodeSignature properties and contains few constructors.
    
    **WordsQRCodeSignature**
    
    ```java
    /**
     * <p>
     * Describes QR-Code Signature of Words Documents.
     * </p>
     */
    public class WordsQRCodeSignature extends QRCodeSignature
    {
        /**
         * <p>
         * Initialize Words QR-Code Signature with default values.
         * </p>
         */
        
        public WordsQRCodeSignature()
        /**
         * <p>
         * Initialize Words QR-Code Signature with specified Encode Type and text.
         * </p>
         * @param encodeType Encode type of QR-Code.
         * @param text QR-Code Text property.
         */
        
        public WordsQRCodeSignature(QRCodeType encodeType, String text)
        {
    }
    ```
    
5.  Class **SignatureHandler** was extended with following events
    
    public event ProcessStartEventHandler** SearchStarted** - event occurs on start of search process
    
    public event ProcessProgressEventHandler **SearchProgress**; - event occurs each time on progressing search process
    
    public event ProcessCompleteEventHandler **SearchCompleted** - event occurs when search process completes
    
    **Working with Search process Events**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
        // setup search option
    PdfSearchBarcodeOptions signOptions = new PdfSearchBarcodeOptions();
        // setup search for all pages
    signOptions.setSearchAllPages(true);
        // setup Barcode encode type if required
    signOptions.setEncodeType(BarcodeTypes.CODE_128);
        // setup Barcode Text if required
    signOptions.setText("123");
        // setup Text Match type if required
    signOptions.setMatchType(TextMatchType.StartsWith);
     
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
     
        // sign document
    SearchResult searchResult = handler.search("pages12Images.pdf", signOptions);
        // output signatures
    for (BaseSignature signature : searchResult.getSignatures())
    {
        BarcodeSignature bcSignature = Operators.as(signature, BarcodeSignature.class);
        if (bcSignature != null)
        {
            System.out.println("Found Barcode signature: "+bcSignature.getEncodeType().getTypeName()+" with text " +bcSignature.getText() );
        }
    }
    ```
    
6.  New set of classes in Extensions namespace was added to support different Brush styles. Base class **Brush.** Derived classes **SolidBrush**, **LinearGradientBrush**, **RadialGradientBrush** and **TextureBrush**. These Brush styles could be applied for Text Signature with Text as Image implementation, for Stamp signature to specify different background for Stamp line.  
    **Brush**, a base class for setting background options.
    
    **Brush**
    
    ```java
    /**
     * <p>
     * Represents base class for various brushes.
     * </p>
     */
    public abstract class Brush
    {
        
    }
    ```
    
    **SolidBrush** class for setting solid brush as signature background.
    
    **SolidBrush**
    
    ```java
    /**
     * <p>
     * Represents solid brush.
     * It could be used instead background color property.
     * </p>
     */
    public class SolidBrush extends Brush
    {
       /**
         * <p>
         * Gets or sets color of solid brush.
         * </p>
         */
         
        public java.awt.Color getColor()
     
       
        /**
         * <p>
         * Gets or sets color of solid brush.
         * </p>
         */ @Public
        public void setColor(java.awt.Color value)
     
     
        /**
         * <p>
         * Initializes a new instance of the SolidBrush class with default values.
         * </p>
         */
        
        public SolidBrush()
       /**
         * <p>
         * Initializes a new instance of the SolidBrush class.
         * </p>
         * @param color Color of solid brush.
         */
        
       public SolidBrush(java.awt.Color color) 
    }
    ```
    
    Working with **SolidBrush**:
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
     
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // set up options with text of signature
    // set up options with text of signature
    PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
    signOptions.setWidth(100);
    signOptions.setHeight(100);
     
    // set up brush for signature background
    Brush userBrushStyle = new SolidBrush(Color.ORANGE);
     
    signOptions.setBackgroundBrushStyle(userBrushStyle);
     
    // specify save options
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("Solid_Brush");
     
    // sign document
    String signedPath = (String)handler.<String>sign("test.pdf", signOptions, saveOptions);
    System.out.println("Signed file path is: " + signedPath);
    ```
    
    **LinearGrdiantBrush** class for setting linear gradient brush as signature background.
    
    **LinearGradientBrush**
    
    ```java
    /**
     * <p>
     * Represents linear gradient brush.
     * </p>
     */
    public class LinearGradientBrush extends Brush
    {
        /**
         * <p>
         * Gets or sets start gradient color.
         * </p>
         */
       
        public java.awt.Color getStartColor()
       
        /**
         * <p>
         * Gets or sets start gradient color.
         * </p>
         */
      
        public void setStartColor(java.awt.Color value)
       
        /**
         * <p>
         * Gets or sets finish gradient color.
         * </p>
         */
      
        public java.awt.Color getEndColor()
     
       /**
         * <p>
         * Gets or sets finish gradient color.
         * </p>
         */
       
        public void setEndColor(java.awt.Color value) 
       
        /**
         * <p>
         * Gets or sets gradient angle.
         * </p>
         */
        
        public float getAngle()
        /**
         * <p>
         * Gets or sets gradient angle.
         * </p>
         */
         
        public void setAngle(float value)
     
        /**
         * <p>
         * Initializes a new instance of the LinearGradientBrush class with default values.
         * </p>
         */
       
        public LinearGradientBrush()
       /**
         * <p>
         * Initializes a new instance of the LinearGradientBrush class.
         * </p>
         * @param startColor Start color.
         * @param endColor End color.
         * @param angle Angle. Default value is 0.
         */
       
       public LinearGradientBrush(java.awt.Color startColor,java.awt.Color endColor, float angle )
       
    }
    ```
    
    Working with **LinearGradientBrush**:
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
        // setup options with text of signature
    CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
      
        // text rectangle size
    signOptions.setHeight(100);
    signOptions.setWidth(100);
      
        //brush for signature background
    java.awt.Rectangle rectBrush = new java.awt.Rectangle(0, 0, signOptions.getWidth(), signOptions.getHeight());
      
      
        //This feature is available from version 18.02.
    LinearGradientBrush linearGradientBrush = new LinearGradientBrush();
    linearGradientBrush.setStartColor(Color.BLUE);
    linearGradientBrush.setEndColor(Color.ORANGE);
    linearGradientBrush.setAngle(75);
      
    Brush userBrushStyle = linearGradientBrush;
      
    signOptions.setBackgroundBrushStyle(userBrushStyle);
      
        // specify save options
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("Cells_Gradient_Brush");
      
        // sign document
    String signedPath = (String)handler.<String>sign("test.xlsx", signOptions, saveOptions);
    System.out.println("Signed file path is: " + signedPath);
    ```
    
    **RadialGradientBrush** class for setting radial gradient brush as signature background.  
    
    **RadialGradientBrush**
    
    ```java
     /**
      * <p>
      * Represents radial gradient brush.
      * </p>
      */
    public class RadialGradientBrush extends Brush
    {
       /**
         * <p>
         * Gets or sets inner gradient color.
         * </p>
         */
       public java.awt.Color getInnerColor()
       
       /**
         * <p>
         * Gets or sets inner gradient color.
         * </p>
         */
         
        public void setInnerColor(java.awt.Color value)
      
       /**
         * <p>
         * Gets or sets outer gradient color.
         * </p>
         */
        
        public java.awt.Color getOuterColor()
        
       /**
         * <p>
         * Gets or sets outer gradient color.
         * </p>
         */
     
        public void setOuterColor(java.awt.Color value) 
     
        /**
         * <p>
         * Initializes a new instance of the RadialGradientBrush class with default values.
         * </p>
         */
        
        public RadialGradientBrush()
      /**
         * <p>
         * Initializes a new instance of the RadialGradientBrush class.
         * </p>
         * @param innerColor Inner color.
         * @param outerColor Outer color.
         */
       
       public RadialGradientBrush(java.awt.Color innerColor,java.awt.Color outerColor)
    }
    ```
    
    Working with **RadialGradientBrush**:
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
     
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // set up options with text of signature
    PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
    signOptions.setWidth(100);
    signOptions.setHeight(100);
    signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Image);
     
    // set up brush for signature background
    RadialGradientBrush userBrushStyle = new RadialGradientBrush(Color.ORANGE, Color.RED);
     
    signOptions.setBackgroundBrushStyle(userBrushStyle);
     
    // specify save options
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("RadialGradient_Brush");
     
    // sign document
    String signedPath = (String)handler.<String>sign("test.pdf", signOptions, saveOptions);
    System.out.println("Signed file path is: " + signedPath); 
    ```
    
    **TextureBrush** class for setting image texture brush as signature background.  
    
    **TextureBrush**
    
    ```java
    /**
     * <p>
     * Represents texture brush.
     * </p>
     */
    public class TextureBrush extends Brush
    {
        /**
         * <p>
         * Gets or sets the texture image file Guid.
         * This property is used only if ImageStream is not specified.
         * </p>
         */
       
        public String getImageGuid() 
        /**
         * <p>
         * Gets or sets the texture image file Guid.
         * This property is used only if ImageStream is not specified.
         * </p>
         */
        
        public void setImageGuid(String value) 
      
       /**
         * <p>
         * Gets or sets the texture image stream.
         * If this property is specified it is always used instead ImageGuid.
         * </p>
         */
      
        public InputStream getImageStream()
        
       /**
         * <p>
         * Gets or sets the texture image stream.
         * If this property is specified it is always used instead ImageGuid.
         * </p>
         */
        
        public void setImageStream(InputStream value) 
        /**
         * <p>
         * Initializes a new instance of the TextureBrush class with default values.
         * </p>
         */
       
        public TextureBrush()  
     
        /**
         * <p>
         * Initializes a new instance of the TextureBrush class with image guid option.
         * </p>
         * @param imageGuid Image file Guid.
         */
       
        public TextureBrush(String imageGuid)
        
       /**
         * <p>
         * Initializes a new instance of the TextureBrush class with image stream option.
         * </p>
         * @param imageStream Image stream.
         */
        
       public TextureBrush(InputStream imageStream)  
    }
    ```
    
    Working with **TextureBrush**:
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
    signConfig.setImagePath("\\Image");
     
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // set up options with text of signature
    CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
    signOptions.setWidth(100);
    signOptions.setHeight(100);
     
     
    TextureBrush userBrushStyle = new TextureBrush("200.png");
     
    signOptions.setBackgroundBrushStyle(userBrushStyle);
     
    // specify save options
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("Texture_Brush");
     
    // sign document
    String signedPath = (String)handler.<String>sign("test.xlsx", signOptions, saveOptions);
    System.out.println("Signed file path is: " + signedPath);
    ```
