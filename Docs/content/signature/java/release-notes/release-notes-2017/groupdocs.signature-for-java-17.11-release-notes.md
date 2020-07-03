---
id: groupdocs-signature-for-java-17-11-release-notes
url: signature/java/groupdocs-signature-for-java-17-11-release-notes
title: GroupDocs.Signature for Java 17.11 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 17.11{{< /alert >}}

## Major Features

There are about 20 improvements, new features and fixes in this regular release. The most notable are:

*   Implemented support of Image file formats for methods returning document and pages information
*   Introduced Signature Handler events to retrieve information on Signing progress
*   Introduced additional Signature appearance for Office format Documents - Cells, Words and Slides
*   Added Signature Handler events to retrieve information on Verification progress
*   Involved ability to retrieve Digital signatures from Pdf Documents
*   Introduced ability to retrieve Digital signatures from Office file format Documents Cells and Words
*   Improved Verification processing of all Documents to process without required Page settings
*   Fixed bug with Cells Text Stamp rendering

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-3154 | Implement support of Image File formats in Document and Pages Information method | New Feature |
| SIGNATURENET-3142 | Implement ability to obtain Verification Progress | New Feature |
| SIGNATURENET-3121 | Implement various text shape types for Words | New Feature |
| SIGNATURENET-3118 | Implement various text shape types for Slides | New Feature |
| SIGNATURENET-3115 | Implement various text shape types for Cells | New Feature |
| SIGNATURENET-3110 | Implement ability to obtain Digital Signatures from Cells Documents | New Feature |
| SIGNATURENET-3107 | Implement ability to obtain Digital Signatures from Words Documents | New Feature |
| SIGNATURENET-3104 | Implement ability to obtain Digital Signatures from Pdf Documents | New Feature |
| SIGNATURENET-2479 | Implement ability to obtain Signing progress | New Feature |
| SIGNATURENET-3168 | Improve Cells Documents Verification when Page is not specified | Improvement |
| SIGNATURENET-3167 | Improve Image Documents Verification when Page is not specified | Improvement |
| SIGNATURENET-3166 | Improve Slides Documents Verification when Page is not specified | Improvement |
| SIGNATURENET-3165 | Improve Words Documents Verification when Page is not specified | Improvement |
| SIGNATURENET-3164 | Improve Pdf Documents Verification when Page is not specified | Improvement |
| SIGNATURENET-3134 | Implement ability to set background color for QRcode signatures | Improvement |
| SIGNATURENET-3133 | Implement ability to set background color for Barcode signatures | Improvement |
| SIGNATURENET-3153 | Method for Document Description and Pages raise Exception | Bug |
| SIGNATURENET-3145 | Signature .NET 17.11 Incorrect Cells Text Stamp rendering | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 17.11. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Added new enumeration type **ProcessStatus** with values that specify Signature or Verification process status.  
      
    

**ProcessStatus enumeration**

```java
public final class ProcessStatus extends Enum
{
    /**
    * <p>
    * Process is not started
    * </p>
    */
    public static final int None = 0;
 
    /**
    * <p>
    * Process was started.
    * </p>
    */
    public static final int Started = 0;
 
    /**
    * <p>
    * Process is in progress.
    * </p>
    */
    public static final int InProgress = 1;
 
    /**
     * <p>
     * Process is completed.
     * </p>
     */
    public static final int Completed = 2;
}
```

2. Added new event argument types to describe process events. Base class **ProcessEventArgs**

**class ProcessEventArgs**

```java
public class ProcessEventArgs extends EventArgs
{
    /**
     * <p>
     * Represents unique identifier of a conversion.
     * </p>
     */
     
    public String getGuid(){ return auto_Guid; }
    /**
     * <p>
     * Represents unique identifier of a conversion.
     * </p>
     */
    
    public void setGuid(String value){ auto_Guid = value; }
    private String auto_Guid;
 
    /**
     * <p>
     * Indicates current process state.
     * </p>
     */
     
    public int getStatus(){ return auto_Status; }
    /**
     * <p>
     * Indicates current process state.
     * </p>
     */
     
    public void setStatus(int value){ auto_Status = value; }
    private int auto_Status;
}
```

Class **ProcessStartEventArgs** that describes start of Signing or Verification process that is derived from base **ProcessEventArgs** and contains additional date time property Started -date/time mark of process start.

Class **ProcessProgressEventArgs **describes progress event. Property **Progress **\- keeps percentage of progress in 0-100 value range, **Ticks - **time in milliseconds spent from start of process

```java
public class ProcessProgressEventArgs extends ProcessEventArgs
{
    /**
     * <p>
     * Represents progress in percents. Value range is from 0 to 100.
     * </p>
     */
     
    public int getProgress(){ return auto_Progress; }
    /**
     * <p>
     * Represents progress in percents. Value range is from 0 to 100.
     * </p>
     */
     
    public void setProgress(int value){ auto_Progress = value; }
    private int auto_Progress;
 
    /**
     * <p>
     * Represents time spent in milliseconds since process Start event
     * </p>
     */
     
    public long getTicks(){ return auto_Ticks; }
    /**
     * <p>
     * Represents time spent in milliseconds since process Start event
     * </p>
     */
     
    public void setTicks(long value){ auto_Ticks = value; }
    private long auto_Ticks;
}  
```

Class **ProcessCompleteEventArgs** with properties Date Time **Completed**  - date/time of completed event and long **Ticks **time in milliseconds spent from start of process

Added new abstract class **ProcessStartEventHandler**, **ProcessProgressEventHandler** and **ProcessCompleteEventHandler** to use in corresponding events

3. Class **SignatureHandler** was extended with following events

 public event ProcessStartEventHandler** SignatureStarted** - event occurs on start of signing process

 public event ProcessProgressEventHandler **SignatureProgress**; - event occurs each time on progressing signature process

 public event ProcessCompleteEventHandler **SignatureCompleted** - event occurs when singing process completes

```java
// setup Signature configuration
SignatureConfig signConfig = new SignatureConfig();
signConfig.setStoragePath("Path to folder\\Storage");
signConfig.setOutputPath("Path to folder\\Output");
signConfig.setImagesPath("Path to folder\\Images");
// instantiating the signature handler
SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
// setup signature option
PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
// text rectangle size
signOptions.setHeight(100);
signOptions.setWidth(100);
signOptions.setSignAllPages(true);
//
SaveOptions saveOptions = new SaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setOutputFileName("Process_Events");
//
handler.SignatureStarted.add(new ProcessStartEventHandler() {
    public void invoke(Object sender, ProcessStartEventArgs args) {
        System.out.println("Signature process of "+args.getGuid()+" started at "+ args.getStarted().toString());
    }
});
 
//
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
String signedPath = handler.<String>sign("text.pdf", signOptions, saveOptions );
```

4. Class SignatureHandler was extended with following events

 public event ProcessStartEventHandler VerificationStarted- event occurs on start of verification process

 public event ProcessProgressEventHandler VerificationProgress; - event occurs each time on progressing verification process

 public event ProcessCompleteEventHandler VerificationCompleted - event occurs when verification process completes



```java
// setup Signature configuration
SignatureConfig signConfig = new SignatureConfig();
signConfig.setStoragePath("Path to folder\\Storage");
signConfig.setOutputPath("Path to folder\\Output");
signConfig.setImagesPath("Path to folder\\Images");
// instantiating the signature handler
SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
// setup signature option
PDFVerifyTextOptions verifyOptions = new PDFVerifyTextOptions("John Smith");
// text rectangle size
verifyOptions.setVerifyAllPages(true);
//
handler.VerificationStarted.add(new ProcessStartEventHandler() {
    public void invoke(Object sender, ProcessStartEventArgs args) {
        System.out.println("Verification process of "+args.getGuid()+" started at "+ args.getStarted().toString());
    }
});
 
 
handler.VerificationProgress.add(new ProcessProgressEventHandler(){
    public void invoke(Object sender, ProcessProgressEventArgs args) {
        System.out.println("Verification of "+args.getGuid()+" progress: "+args.getProgress()+" %. Since start process spent "+args.getTicks()+" mlsec");
    }
 
 
});
handler.VerificationCompleted.add(new ProcessCompleteEventHandler() {
    public void invoke(Object sender, ProcessCompleteEventArgs args) {
        System.out.println("Verification of "+args.getGuid()+" completed at "+args.getCompleted().toString()+". Process took "+args.getTicks()+" mlsec");
    }
});
// verify document
VerificationResult result = handler.verify("text.pdf", verifyOptions);
System.out.println("Verification result is: " + result.isValid());
```

5. New ability to search signature in Documents was provided with following new options classes

Base abstract class **SearchOptions** specifies base properties of search signatures options. Derived class **SearchDigitalOptions** specifies properties for base options to search Digital Signatures and derived classes **CellsSearchDigitalOptions**, **PdfSearchDigitalOptions** and **WordsSearchDigitalOption** for corresponding documents. Added new class **SearchOptionsCollection **to specify amount of options to search.

New classes that specify Signature object in appropriate documents - are  **CellsDigitalSiganture**, **PdfDigitalSiganture** and **WordsDigitalSiganture. **These classes are derived from base **DigitalSiganture**. Base class for all Signature object is **BaseSignature** class.

New class **SearchResult** keeps list of Signatures. Instance of **SearchResult** is returned from new SIgantureHandler methods to search for Signatures

**Overload Search Signature methods**

```java
public SearchResult search(String guid, SearchOptions searchOptions)
public SearchResult search(String guid, SearchOptions searchOptions, LoadOptions loadOptions)
public SearchResult search(String guid, SearchOptionsCollection collection, LoadOptions loadOptions)
public SearchResult search(InputStream stream, SearchOptions searchOptions)
public SearchResult search(InputStream stream, SearchOptions searchOptions, LoadOptions loadOptions)
public SearchResult search(InputStream stream, SearchOptionsCollection collection, LoadOptions loadOptions) 
```

**Searching Digital Signatures in Pdf Documents**

```java
// setup Signature configuration
SignatureConfig signConfig =new SignatureConfig();
signConfig.setStoragePath("local_path\\Storage");
signConfig.setOutputPath("local_path\\Output");           
// instantiating the signature handler          
SignatureHandler handler = new SignatureHandler(signConfig);
 
// setup options with text of signature
PdfSearchDigitalOptions searchOptions = new PdfSearchDigitalOptions();
// Search Document for Signatures
String guid = "test_digitalsigned.pdf";
SearchResult searchResult = handler.search(guid, searchOptions);
System.out.println("Source file " +guid+ " contains "+searchResult.getSignatures().size()+" digital signature(s)" );
for(BaseSignature signature : searchResult.getSignatures())
{
    PDFDigitalSignature pdfSign = (PDFDigitalSignature)signature;
    if (pdfSign != null) {
        System.out.println("\t >> Digital signature from "+pdfSign.getSignTime()+". Contact: "+pdfSign.getContactInfo()+". Valid "+pdfSign.isValid());
    }
}
```

**Searching Digital Signatures in Cells Documents**

```java
// setup Signature configuration
SignatureConfig signConfig =new SignatureConfig();
signConfig.setStoragePath("local_path\\Storage");
signConfig.setOutputPath("local_path\\Output");           
// instantiating the signature handler          
SignatureHandler handler = new SignatureHandler(signConfig);
 
// setup options with text of signature
CellsSearchDigitalOptions searchOptions = new CellsSearchDigitalOptions ();
// Search Document for Signatures
String guid = "test_digitalsigned.xlsx";
SearchResult searchResult = handler.search(guid, searchOptions);
System.out.println("Source file " +guid+ " contains "+searchResult.getSignatures().size()+" digital signature(s)" );
for(BaseSignature signature : searchResult.getSignatures())
{
    CellsDigitalSignature cellsSign = (CellsDigitalSignature )signature;
    if (cellsSign != null) {
        System.out.println("\t >> Digital signature from "+cellsSign.getSignTime()+". Comments: "+cellsSign.getComments()+". Valid "+cellsSign.isValid());
    }
}
```

**Searching Digital Signatures in Words Documents**

```java
// setup Signature configuration
SignatureConfig signConfig =new SignatureConfig();
signConfig.setStoragePath("local_path\\Storage");
signConfig.setOutputPath("local_path\\Output");           
// instantiating the signature handler          
SignatureHandler handler = new SignatureHandler(signConfig);
 
// setup options with text of signature
WordsSearchDigitalOptions searchOptions = new WordsSearchDigitalOptions ();
// Search Document for Signatures
String guid = "test_digitalsigned.xlsx";
SearchResult searchResult = handler.search(guid, searchOptions);
System.out.println("Source file " +guid+ " contains "+searchResult.getSignatures().size()+" digital signature(s)" );
for(BaseSignature signature : searchResult.getSignatures())
{
    WordsDigitalSignature WordsSign = (WordsDigitalSignature)signature;
    if (WordsSign != null) {
        System.out.println("\t >> Digital signature from "+WordsSign.getSignTime()+". Comments: "+WordsSign.getComments()+". Valid "+WordsSign.isValid());
    }
}
```

Following example demonstrates how to get digital certificates from system

**Searching Digital Signatures in system**

```java
// setup Signature configuration            
SignatureConfig signConfig = new SignatureConfig();
signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");         
// load Digital Signature registered in system
List<DigitalSignature> signatures = DigitalSignature.loadDigitalSignatures();
for (DigitalSignature signature : signatures)
{
    if (signature.getCertificate() != null)
    {
 
        KeyStore keyStore = signature.getCertificate();
        for (Enumeration l = keyStore.aliases(); l.hasMoreElements();) {
            String al = (String) l.nextElement();
            Certificate cert = keyStore.getCertificate(al);
 
            System.out.println("\nCertificate: " + cert.toString());
 
        }   
    }
}
```

6. Introduced new enumeration types for Office Document Text Signature appearances. New types are **CellsTextShapeType**, **SlidesTextShapeType** and **WordsTextShapeType**.



```java
// setup Signature configuration
SignatureConfig signConfig =new SignatureConfig();
signConfig.setStoragePath("Path to folder\\Storage");
signConfig.setOutputPath("Path to folder\\Output");   
// instantiating the signature handler
SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
// setup options with text of signature
CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
// setup background settings
signOptions.setVerticalAlignment(VerticalAlignment.None);
signOptions.setHorizontalAlignment(HorizontalAlignment.None);
signOptions.setColumnNumber(2);
signOptions.setRowNumber(3);
signOptions.setWidth(300);
signOptions.setHeight(100);
 
// setup background settings
signOptions.setBackgroundColor(Color.YELLOW);
signOptions.setBackgroundTransparency(0.5);
 
//setup border settings
signOptions.setBorderColor(Color.ORANGE);
signOptions.setBorderWeight(1.2);
signOptions.setBorderTransparency(0.5);
signOptions.setBorderDashStyle(DashStyle.DashLongDashDot);
signOptions.setBorderVisiblity(true);
signOptions.setBorderWeight(2);
 
// setup text color
signOptions.setForeColor(Color.BLUE);
// setup Font options
signOptions.getFont().setBold(true);
signOptions.getFont().setItalic(true);
signOptions.getFont().setUnderline(true);
signOptions.getFont().setStrikeout(true);
signOptions.getFont().setFontFamily("Arial");
signOptions.getFont().setFontSize(25);
 
//setup type of signature shape (could appears differently for various document types)
//This feature is supported starting from version 17.11
signOptions.setShapeType(CellsTextShapeType.UpRibbon);
 
// setup save options
SaveOptions saveOptions =new SaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setOutputFileName("Cells_TextSignatureAppearance");
 
// sign document
String signedPath = handler.<String>sign("test.xls", signOptions, saveOptions);
System.out.println("Signed file path is: " + signedPath);
```
