---
id: groupdocs-signature-for-java-21-2-release-notes
url: signature/java/groupdocs-signature-for-java-21-2-release-notes
title: GroupDocs.Signature for Java 21.2 Release Notes
weight: 50
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 21.2{{< /alert >}}

## Major Features

This release contains important bug fixes related to processing Digital Signatures with its generated unique identifiers for supported document types. Also this update contains the fix document preview. Below the list of most notable changes in release of GroupDocs.Signature for .NET 21.1:

* Added ability to get history of actions performed with a document.
* Implemented time stamp options for digital signatures in PDF documents.
* Introduced for Pdf documents new type certificate type of electronic digital signatures.
* Improved processing of blank and zero-size documents
* Optimizing document preview for empty documents
* Fixed few bugs with processing Barcode signatures  
* Implement ability to keep deleted signatures information.
* List of processed signatures were added to history log records.
* Introduced ability to keep signatures information in the Image documents.
* Fixed major bugs with processing various data files types
* Imroved verification of passed file type and proper signatures types.
* Fixed few bugs with signature processing and loading documents.
* Implement ability to hide digital signatures on document preview for PDF documents.
* Involved option to adjust digital signature appearance on page.
* Introduced ability to remove digital signatures from PDF documents.

Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-2944 | Implement ability to use timestamp for digital signatures in Pdf Documents | Feature |
| SIGNATURENET-2937 | Implement ability to add digital certificate to Pdf Documents | Feature |
| SIGNATURENET-2936 | Implement ability to track document processing history | Feature |
| SIGNATURENET-2535 | Implement secured Document metadata information | Feature |
| SIGNATURENET-2951 | Return images with default size as preview result for empty Spreadsheets documents | Improvement |
| SIGNATURENET-2950 | Processing null-sized files with specific exception | Improvement |
| SIGNATURENET-2975 | PdfDigitalSignature has no constructors defined | Bug |
| SIGNATURENET-2948 | Empty image is returned for documents without any content | Bug |
| SIGNATURENET-2947 | Can't get document info for empty documents | Bug |
| SIGNATURENET-2946 | Wrong Barcode recognition for images with wide borders | Bug |
| SIGNATURENET-3020 | Implement ability to keep signature information in image documents | Feature |
| SIGNATURENET-2978 | Keep in history process log the list of processed sigantures | Feature |
| SIGNATURENET-2977 | Keep deleted signatures information in metadata for history | Feature |
| SIGNATURENET-3008 | Remove support of .DJVU files | Improvement |
| SIGNATURENET-3004 | Improve file format support verification for each Document type and operations | Improvement |
| SIGNATURENET-3047 | Fixed memory leak issue when working with metadata Signatures | Bug |
| SIGNATURENET-3021 | Exception is thrown when barcodes are being searched in .webp images | Bug |
| SIGNATURENET-2981 | Not protected file requires password | Bug |
| SIGNATURENET-2980 | Can not open .odg file | Bug |
| SIGNATURENET-2979 | Can not load pdf file | Bug |
| SIGNATURENET-2952 | Image loading failed | Bug |
| SIGNATURENET-2948 | Empty image is returned for documents without any content | Bug |
| SIGNATURENET-2791 | SignResult signatures are not populated with minor data for Image documents | Bug |
| SIGNATURENET-3085 | Implement ability to hide digital signatures on PDF Document Preview | Feature |
| SIGNATURENET-3084 | Set additional Digital Signatures properties for PDF documents | Feature |
| SIGNATURENET-3083 | Implement ability to remove digital signatures from PDF documents | Feature |

## Public API and Backward Incompatible Changes

### New public enumeration type [PdfDigitalSignatureType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/PdfDigitalSignatureType ) was added.

New public enumeration type **[PdfDigitalSignatureType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/PdfDigitalSignatureType )** was added. This type describes possible values of PDF digital signature types.

* At this moment enumeration contains two options Signature and Certificate. In first case a PDF document is signed digitally in second one it is digitally certified.

**Enumeration of PDF digital signature types**

```java

/**
 * <p>
 * Describes enumeration of PDF digital signature type.
 * </p>
 */
public final class PdfDigitalSignatureType extends Object
{
	private PdfDigitalSignatureType(){}	
    /**
     * <p>
     * Digital signature.
     * </p>
     */
    public static final int Signature = 0;

    /**
     * <p>
     * Digital certificate. Each document could be certified only once.
     * </p>
     */
    public static final int Certificate = 1;
}
```

### New public struct [TimeStamp](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.structs/TimeStamp ) was added.

New public struct **[TimeStamp](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.structs/TimeStamp )** was added. This struct could be used for getting time stamp from third-party site to PDF digital signature.

*   At this moment enumeration struct contains Url, User and Password properties.

**Struct for getting timestamp**

```java
/**
 * <p>
 * Represents data to get time stamp from third-party site.
 * </p>
 */
public class TimeStamp
{	
	
    /**
     * <p>
     * Url of third-party site.
     * </p>
     */    
    public final String getUrl(){}   
    public final void setUrl(String value){}    

    /**
     * <p>
     * User.
     * </p>
     */    
    public final String getUser(){  }    
    public final void setUser(String value){}    

    /**
     * <p>
     * Password.
     * </p>
     */    
    public final String getPassword(){}
    public final void setPassword(String value){}   

    /**
     * <p>
     * Instantiates new time stamp structure.
     * </p>
     * @param url Url of third-party site.
     * @param user User.
     * @param password Password.
     */   
    public TimeStamp(String url, String user, String password){}    

}
```

### Public class [PdfDigitalSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/PdfDigitalSignature ) was updated with new property.

Public class **[PdfDigitalSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/PdfDigitalSignature )** was updated with new property for PDF document specific signatures. Supported only for digital signatures.

* new property Type of type PdfDigitalSignatureType was added to specify PDF document specific type of digital signatures.
* new property TimeStamp of type TimeStamp was added to add possibility for getting time stamp from third-party site to PDF digital signatures.
* four constructors were added to make process of instantiation more versatile.


**New properties of PdfDigitalSignature**

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
     * Type of Pdf digital signature.
     * </p>
     */
    public final int getType(){}
    public final void setType(int value){}  

    /**
     * <p>
     * Time stamp for Pdf digital signature.
     * Default value is null.
     * </p>
     */    
    public final TimeStamp getTimeStamp(){}
    public final void setTimeStamp(TimeStamp value){}  
}
```

 Following example demonstrates how to certify a PDf document with digital signature and added timestamp.

**Certifying a PDf document with digital signature and adding timestamp**

```java
//Certify pdf document with digital signature
 final Signature signature = new Signature(filePath);
        try 
        {
            PdfDigitalSignature pdfDigitalSignature = new PdfDigitalSignature();
            pdfDigitalSignature.setContactInfo("Contact");
            pdfDigitalSignature.setLocation("Location");
            pdfDigitalSignature.setReason("Reason");
            pdfDigitalSignature.setTimeStamp(new TimeStamp("https://freetsa.org/tsr", "", ""));

            //Create digital signing options
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);
            options.setPassword("1234567890");
            options.setSignature(pdfDigitalSignature);
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);

            SignResult signResult = signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath);

            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature temp : signResult.getSucceeded())
            {
                System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
}
```

### New public enumeration type [ProcessType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/ProcessType ) was added.

New public enumeration type **[ProcessType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/ProcessType )** was added. This type describes document process type of supported operations.

**Enumeration of processing types**

```java
/**
 * <p>
 * Defines supported process with documents like Info, Preview, Sign, Verify, Search, Update, Delete
 * </p>
 */
public final class ProcessType extends Object
{
    /**
     * <p>Indicates an error, unknown process type.</p>
     */
    public static final int Unknown = 0;
    /**
     * <p>Obtain document information process.</p>
     */
    public static final int Info = 1;
    /**
     * <p>Indicates method GeneratePreview().</p>
     */
    public static final int Preview = 2;
    /**
     * <p>Signing process type.</p>
     */
    public static final int Sign = 3;
    /**
     * <p>Document verification process.</p>
     */
    public static final int Verify = 4;
    /**
     * <p>Signatures searching process.</p>
     */
    public static final int Search = 5;
    /**
     * <p>Update document signatures process.</p>
     */
    public static final int Update = 6;
    /**
     * <p>Delete document signatures process</p>
     */
    public static final int Delete = 7;
}
```

### New public class [ProcessLog](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/ProcessLog) was added.

New public class type **[ProcessLog](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/ProcessLog)** was added to keep document process information like date/time, type of the process (**[ProcessType](https://apireference.groupdocs.com/signature/java/groupdocs.signature.domain/processtype)**), message, quantity of succeeded and quantity of failed signatures.

**ProcessLog class properties**

```java
/**
 * <p>
 * Represents document process details.
 * </p>
 */
public final class ProcessLog
{
	/**
	 * <p>
	 * Get the process date and time.
	 * </p>
	 */    
    public final java.util.Date getDate() { return Date; }

    /**
     * <p>
     * Get the process type.
     * </p>
     */    
    public final /*ProcessType*/int getType(){ return auto_Type; }
        
    /**
     * <p>
     * Get the process description.
     * </p>
     */    
    public final String getMessage(){ return auto_Message; }
   
    /**
     * <p>
     * Quantity of successfully processed signatures.
     * </p>
     */    
    public final int getSucceeded(){ return auto_Succeeded; }
   
    /**
     * <p>
     * Quantity of signatures that failed during processing.
     * </p>
     */    
    public final int getFailed(){}
   
	/**
	 * <p>
	 * The list of successfully processed signatures.
	 * </p>
	 */    
    public final java.util.List<BaseSignature> getSignatures() {}
   
}
```

### Public interface [IDocumentInfo](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/IDocumentInfo ) was extended with new property

Public interface **[IDocumentInfo](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/IDocumentInfo )** was extended with new properties. 

* ProcessLogs property as IList of ProcessLog objects to keep the list of document process history log records.

**New property ProcessLogs of IDocumentInfo interface**

```java
/**
 * <p>
 *  Defines document description properties.
 * </p>
 */
public interface IDocumentInfo
{
	/**
	 * <p>
	 * Collection of document history process logs.
	 * </p>
	 */    
	public List<ProcessLog> getProcessLogs();
}
```

### Public class [DocumentInfo](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/DocumentInfo ) was extended with new property.

Public interface **[DocumentInfo](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/DocumentInfo )** was extended with new property **ProcessLogs** to keep the list of document process history log records.

**New property ProcessLogs of DocumentInfo class**

```java 
public class DocumentInfo implements IDocumentInfo
{
	...
	
	/**
	 * <p>
	 * Collection of document history processes like Sign, Update, Delete.
	 * </p>
	 */		
	public final java.util.List<ProcessLog> getProcessLogs(){}
}
```


### New property Deleted of [BaseSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BaseSignature ) was added.

New boolean property Deleted was added to class **[BaseSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BaseSignature )**. This property signals if Signature object was deleted from the Document.

```java 
public abstract class BaseSignature
{
	...
	
	/**
	 * <p>
	 * Get flag to indicate if this signature was deleted from the document.
	 * This property is being used only for document history log records to keep the list of deleted signatures.
	 * </p>
	 */		
	public final boolean getDeleted(){}
}
```

### Obsolete member Stamp was removed from enumeration [TextSignatureImplementation](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation ).

Obsolete member Stamp of enumeration **[TextSignatureImplementation](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation )** was removed and no longer supported. Please use enumeration value Native instead.

**Obsolete member Border was removed from [ImageAppearance](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.appearances/ImageAppearance )**

Obsolete member Stamp of enumeration **[TextSignatureImplementation](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation )** was removed and no longer supported. Please use enumeration value Native instead.

### New constructor with string signature unique identifier for class [DigitalSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/DigitalSignature ) is the list of processed signatures

New constructor class DigitalSignature allows to create instance with predefined signature identifier.

**New constructor DigitalSignature**

```java
public class DigitalSignature extends BaseSignature
{
	/**
     * <p>
     * Initialize Digital signature with known SignatureId.
     * </p>
     */    
    public DigitalSignature(String signatureId){}
}
```

Following example shows how to delete Digital signature by known signature identifier.

```java
// initialize Signature instance
final Signature signature = new Signature("signedSample.pdf");
{
    DigitalSignature dsSignature = new DigitalSignature("a01e1940-997a-444b-89af-9309a2d559a5");
    
    // delete required signatures
	boolean result = signature.delete(new ByteArrayOutputStream(),dsSignature);
	if (result)
	{
		System.out.print("All signatures were successfully deleted!");
	}
	else
	{
		System.out.print("Not digital signatures : "+dsSignature.getSignatureId());
	}
}
```

### New boolean property ShowProperties of class [PdfDigitalSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/PdfDigitalSignature ) was added

New boolean property ShowProperties was added to class **[PdfDigitalSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/PdfDigitalSignature )**. This property allow to adjust appearance of Digital signture on Pdf document page.

```java
public class PdfDigitalSignature extends DigitalSignature
{

	....
	
	/**
     * <p>
     * Force to show/hide signature properties. In case ShowProperties is true signature
     * field has predefined format of appearance 
     *     Digitally signed by {{@code ContactInfo}({@link #getContactInfo}/{@link #setContactInfo(String)})} Date: {Date} Reason: {{@code Reason}({@link #getReason}/{@link #setReason(String)})}
     *     Location: {{@code Location}({@link #getLocation}/{@link #setLocation(String)})}
     * ShowProperties is true by default.
     * </p>
     */    
    public final boolean getShowProperties(){}    
    public final void setShowProperties(boolean value){}
}
```
