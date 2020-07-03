---
id: groupdocs-signature-for-java-18-1-release-notes
url: signature/java/groupdocs-signature-for-java-18-1-release-notes
title: GroupDocs.Signature for Java 18.1 Release Notes
weight: 5
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 18.1{{< /alert >}}

## Major Features

There are more about 14 improvements, new features and fixes in this regular release. Most new features were implemented with Text Signatures additional appearances like shadows. Improvements and bug fixes update functionality with URL provided documents and implementation of additional properties on verification processing. The most notable changes are:

*   Introduced new Signature Extensions Options that allows to add special functional features and appearances
*   Implemented text shadow appearance options for Text Signature for all supported Document types
*   Improved Verification event arguments for start, progress and complete handlers
*   Improved Signature event arguments for start, progress and complete handlers
*   Updated Document Info properties with additional properties
*   Improved URL provided Document Information with correct values
*   Updated Stream result of Sign methods with start position after signing document
*   Fixed output file name for URL provided Document or Stream based Documents
*   Updated signing process when Document provided by URL without specific file name
*   Updated classes, methods and properties with detailed comments
*   Marked few properties as obsolete

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-3282 | Output file name has no extension for Stream and URL Document source | Bug |
| SIGNATURENET-3279 | Update result Stream of Sign methods | Bug |
| SIGNATURENET-3251 | Fix error when loading Documents from Google drive | Bug |
| SIGNATURENET-3250 | Fix error when loading Documents from URL without target filename | Bug |
| SIGNATURENET-3288 | Improve Verification events arguments with additional properties | Improvement |
| SIGNATURENET-3285 | Improve information of URL provided Document with corrected value | Improvement |
| SIGNATURENET-3281 | Improve Signature on Complete event arguments with additional properties | Improvement |
| SIGNATURENET-3280 | Improve Verification Result with additional properties | Improvement |
| SIGNATURENET-3286 | Improve result of Signing methods when Document provided by URL | Improvement |
| SIGNATURENET-3325 | Fix TextShadow class implementation and namespace | Improvement |
| SIGNATURENET-3277 | Implement ability to set text shadow effect for text as image signature for all documents types | New Feature |
| SIGNATURENET-3276 | Implement ability to set text shadow in text signatures for Slides documents | New Feature |
| SIGNATURENET-3275 | Implement ability to set text shadow in text signatures for Words documents | New Feature |
| SIGNATURENET-3274 | Implement ability to set text shadow in text signatures for Cells documents | New Feature |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 18.1. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

 Added new namespace **com.g****roupdocs.signature.domain.extensions** that will contain Signature extensions.

1.  New class  **SignatureExtension **was added to specify base class for Signature Extensions options like new functional and appearance features.  
      
    
    ```java
     /**
         * <p>
         * Represents base class for signatures extensions.
         * </p>
         */
    public abstract class SignatureExtension implements ICloneable, Cloneable
    {
        /**
         * <p>
         * Gets a copy of this object.
         * </p>
         */
        public /*virtual*/ Object deepClone()
        {
            return this.memberwiseClone();
        }
    
        //JAVA-added .Net MemberwiseClone emulation
        protected Object memberwiseClone()
        {
            try { return clone(); }
            catch (CloneNotSupportedException e) { throw new IllegalStateException(e); }
        }
    }
    ```
    
    Class **SignOptions** was updated with **Extensions** property
    
    ```java
     /**
        * <p>
        * Signature Extensions
        * </p>
        */
       public java.util.List<SignatureExtension> getExtensions() { return List.toJava(getExtensionsInternal()); }
       //JAVA: property accessor is internalized
    public List<SignatureExtension> getExtensionsInternal(){ return auto_Extensions; }
       /**
        * <p>
        * Signature Extensions
        * </p>
        */
       private void setExtensions(List<SignatureExtension> value){ auto_Extensions = value; }
       private List<SignatureExtension> auto_Extensions;
    ```
    
2.   Added new class **TextShadow**. It's recommended for using with text as image signature for all supported document types, also with simple text signature and text signature as watermark for Cells (.xslx) and Slides (.pptx). Simple text signature for Words (.docx) is recommended too, but has limited functionality.  
      
    
    **TextShadow**
    
    ```java
     /**
         * <p>
         * Represents text shadow properties for text signatures.
         * The result may vary depending on the signature type and document format.
         * TextShadow is recommended for using with TextAsImage signature for all supported document types,
         * also with simple TextSignature and TextSignature as watermark for Cells (.xslx) and Slides (.pptx).
         * Simple TextSignature for Words (.docx) is recommended too, but has limited functionality.
         * </p>
         */
    public class TextShadow extends SignatureExtension
    {
         
     
        /**
         * <p>
         * Gets or sets distance from text to shadow.
         * Default value is 1;
         * </p>
         */
        public double getDistance(){ return auto_Distance; }
        
     
        /**
         * <p>
         * Gets or sets distance from text to shadow.
         * Default value is 1;
         * </p>
         */
        public void setDistance(double value){ auto_Distance = value; }
        private double auto_Distance;
     
        /**
         * <p>
         * Gets or sets angle for placing shadow relative to the text.
         * Default value is 0;
         * </p>
         */
        public double getAngle(){ return auto_Angle; }
        /**
         * <p>
         * Gets or sets angle for placing shadow relative to the text.
         * Default value is 0;
         * </p>
         */
        public void setAngle(double value){ auto_Angle = value; }
        private double auto_Angle;
       
       /**
         * <p>
         * Gets or sets color of the shadow.
         * Default value is Black;
         * </p>
         */
        public java.awt.Color getColor() { return auto_Color; }
       
        
         * <p>
         * Gets or sets color of the shadow.
         * Default value is Black;
         * </p>
         */
        public void setColor(java.awt.Color value) { auto_Color = value;; }
         
        private Color auto_Color = new Color();
     
        /**
         * <p>
         * Gets or sets transparency of the shadow.
         * Default value is 0;
         * </p>
         */
        public double getTransparency(){ return auto_Transparency; }
        /**
         * <p>
         * Gets or sets transparency of the shadow.
         * Default value is 0;
         * </p>
         */
        public void setTransparency(double value){ auto_Transparency = value; }
        private double auto_Transparency;
         
        /**
         * <p>
         * Gets or sets blur of the shadow.
         * Default value is 4;
         * </p>
         */
        public double getBlur(){ return auto_Blur; }
        /**
         * <p>
         * Gets or sets blur of the shadow.
         * Default value is 4;
         * </p>
         */
        public void setBlur(double value){ auto_Blur = value; }
        private double auto_Blur;
     
        /**
         * <p>
         * Creates TextShadow with default options.
         * </p>
         */
        public TextShadow()
        {
            initialization();
        }
    }
    ```
    
    Here's example of using
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
    // set up text signature options
    SlidesSignTextOptions signOptions = new SlidesSignTextOptions("John Smith");
    signOptions.setWidth(300);
    signOptions.setHeight(300);
    signOptions.getFont().setFontSize(48);
     
    // set up shadow options for text
    TextShadow shadow = new TextShadow();
    shadow.setColor(Color.ORANGE);
    shadow.setAngle(135);
    shadow.setBlur(5);
    shadow.setDistance(4);
    shadow.setTransparency(0.2);
     
    //add text shadow to signature extensions
    signOptions.getExtensions().add(shadow);
     
    // specify save options
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("SignatureExtensions_TextShadow");
     
     
    // sign document
    String signedPath = handler.<String>sign("test.pptx", signOptions, saveOptions);
    System.out.println("Signed file path is: " + signedPath);
    ```
    
3.  Process Events Arguments were extended with additional properties to specify Total Signatures count and current processed Signature quantity. Following example demonstrates using of these properties on Signature method. Same arguments can be used for Verification process. New properties TotalSignatures and ProcessedSignature were added to **ProcessCompleteEventArgs**, **ProcessProgressEventArgs **and **ProcessStartEventArgs**  
      
    New int TotalSignatures added to provide ability for representation total quantity of processed signatures.
    
    **ProcessCompleteEventArgs**
    
    ```java
    /**
     * <p>
     * Represents total quantity of processed signatures.
     * </p>
     */
    public int getTotalSignatures(){ return auto_TotalSignatures; }
    /**
     * <p>
     * Represents total quantity of processed signatures.
     * </p>
     */
    public void setTotalSignatures(int value){ auto_TotalSignatures = value; }
    private int auto_TotalSignatures;
    ```
    
    New int ProcessedSignatures was added to provide ability for representation quantity of processed signatures.
    
    **ProcessProgressEventArgs**
    
    ```java
    /**
     * <p>
     * Represents quantity of processed signatures.
     * </p>
     */
    public int getProcessedSignatures(){ return auto_ProcessedSignatures; }
    /**
     * <p>
     * Represents quantity of processed signatures.
     * </p>
     */
    public void setProcessedSignatures(int value){ auto_ProcessedSignatures = value; }
    private int auto_ProcessedSignatures;
    ```
    
    New int TotalSignatures was added to provide ability for representation of total quantity of signatures to be processed.
    
    **ProcessStartEventArgs**
    
    ```java
    /**
     * <p>
     * Represents total quantity of signatures to be processed.
     * </p>
     */
    public int getTotalSignatures(){ return auto_TotalSignatures; }
    /**
     * <p>
     * Represents total quantity of signatures to be processed.
     * </p>
     */
    public void setTotalSignatures(int value){ auto_TotalSignatures = value; }
    private int auto_TotalSignatures;
    ```
    
    ##### Working with Signature process Events
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // setup signature option
    PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
    // text rectangle size
    signOptions.setHeight(100);
    signOptions.setWidth(100);
    signOptions.setSignAllPages(true);
    //
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("Pdf_Events");
    //
    handler.SignatureStarted.add(new ProcessStartEventHandler() {
        public void invoke(Object sender, ProcessStartEventArgs args) {
            System.out.println("Signature process of "+args.getGuid()+" started at "+ args.getStarted().toString());
        }
    }); 
    handler.SignatureProgress.add(new ProcessProgressEventHandler(){
        public void invoke(Object sender, ProcessProgressEventArgs args) {
            System.out.println("Singing of "+args.getGuid()+" progress: "+args.getProgress()+" %. Since start process spent "+args.getTicks()+" mlsec" );
        }
    });
    handler.SignatureCompleted.add(new ProcessCompleteEventHandler() {
        public void invoke(Object sender, ProcessCompleteEventArgs args) {
            System.out.println("Singing of "+args.getGuid()+" completed at "+args.getCompleted().toString()+". Process took "+args.getTicks()+" mlsec" );
        }
    });
    // sign document
    String signedPath = handler.<String>sign("pages12Images.pdf", signOptions, saveOptions);
    ```
    
4.  Methods **GetDocumentDescription** of **SignatureHandler** class was improved when Document provided by URL
    
    ###### Obtaining information about document
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
    // instantiating the conversion handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
    // Document description
    DocumentDescription docInfo = handler.getDocumentDescription("https://www.dropbox.com/s/bzx1xm68zd0c910/PieChart.docx?dl=1", null);
    Console.writeLine("Document " + docInfo.getGuid() + " contains " + docInfo.getPageCount() + " pages");
    Console.writeLine("File format is " + docInfo.getFileFormat());
    Console.writeLine("File extension is  " + docInfo.getExtension());
    Console.writeLine("Date created is " + docInfo.getDateCreated());
    Console.writeLine("Date modified is " + docInfo.getDateModified());
    Console.writeLine("Password to open file is " + docInfo.getPassword());
    Console.writeLine("File size in bytes is " + docInfo.getSize());
    Console.writeLine("Width of first page is " + docInfo.getPages().get(0).getWidth());
    ```
