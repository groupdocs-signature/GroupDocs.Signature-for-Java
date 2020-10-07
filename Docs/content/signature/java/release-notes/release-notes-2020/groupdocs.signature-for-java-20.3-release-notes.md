---
id: groupdocs-signature-for-java-20-3-release-notes
url: signature/java/groupdocs-signature-for-java-20-3-release-notes
title: GroupDocs.Signature for Java 20.3 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 20.3{{< /alert >}}{{< alert style="danger" >}}In this version we're removed Legacy API from product. com.groupdocs.signature.legacy namespace does not exist anymore.{{< /alert >}}

## Major Features

With this release we are glad to announce updated signature objects life cycle and entire different process methods for **Signature** class. Now **Signature** class supponew public constructorrts classic CRUD (Create-Read-Update-Delete) operations set.

*   **Sign** method **creates** signatures inside document and returns them as result with all properties along with new signature identifier property;
*   **Search** method **reads** a list of existing document signatures;
*   **Update** method **modifies** existing document signature(s) by identifier and stores changes in the same document;
*   **Delete** method removes signature(s) from the document.

Here are few concepts that will help to understand changes in this release more precisely:

*   **Sign** process returns list of newly created signatures (as list of BaseSignature objects); When signing metadata layer is created inside the document to keep all signatures information: total signatures quantity, signature properties like unique identifier, location, size etc.;
*   **BaseSignature** class was extended with **SignatureId **string property that represents unique signature identifier inside the document;
*   **BaseSignature** class boolean property **IsSignature **was added to distinct signatures and native document components like text / images / barcodes / qr-codes etc.  
      
    

All changes described above allows to hide signatures for document preview and exclude non signatures upon search.

The most notable changes:

*   Legacy API was removed from product.
*   Retrieve collection of created signatures after signing document;
*   Added signature identifier to distinct them in document;
*   Implemented an ability to search for signatures only and exclude other document content from search;
*   Introduced an ability to hide signatures from document preview;
*   Implemented an ability to modify existing document signatures;
*   Added a feature to remove signatures from document;
*   Fixed few bugs.
*   Different signature type classes were updated with ability to compare and clone.
*   Fix known limitation with unsupported digital signatures for Spreadsheet documents under .Net Standard 2.0

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-2453 | Implement ability to search only for signatures marked as IsSignature | New Feature |
| SIGNATURENET-2426 | Implement result of Sign method as SignResult class with newly created signatures list | New Feature |
| SIGNATURENET-2394 | Implement ability to hide signatures from Document Preview | New Feature |
| SIGNATURENET-2391 | Implement Delete method to remove existing document signatures | New Feature |
| SIGNATURENET-2326 | Implement Update method to modify existing document signatures | New Feature |
| SIGNATURENET-2473 | Implement support of Digital signatures for Spreadsheet document under .NET Standard 2.0 framework | Improvement |
| SIGNATURENET-2472 | Improve method ToList<T> of SearchResult to return only non null instances | Improvement |
| SIGNATURENET-2434 | Provide ICloneable interface implementation for all signature types | Improvement |
| SIGNATURENET-2431 | Override Equals / GetHashCode methods for all signatures to have compare ability | Improvement |
| SIGNATURENET-2425 | Generate new ProjectGuid and UpgradeCode for MSI package | Improvement |
| SIGNATURENET-2404 | Implement support enumeration type properties of embedded custom objects for QR-Code signatures | Improvement |
| SIGNATURENET-2403 | Improve exceptions usage | Improvement |
| SIGNATURENET-2387 | Allow adding Digital signatures to already signed Spreadsheet documents without removing previous signatures | Improvement |
| SIGNATURENET-1465 | Implement exceptions for required or incorrect password when load document | Improvement |
| SIGNATURENET-2400 | SaveOptions value OverwriteExistingFile with default value as false to prevent saving to the same file | Bug |
| SIGNATURENET-2382 | Compatibility issues under .NET Standard 2.0 | Bug |
| SIGNATURENET-2508 | Sign process inserts wrong empty metadata for signatures information | Bug |

## Public API and Backward Incompatible Changes

### Public class **BarcodeSignature** was updated

*   property**EncodeType** was marked as read-only
*   property **Text** was marked as read-only
*   new public constructor **BarcodeSignature**(**string signatureId**) was added with string argument as unique signature identifier that could obtained by **Search** or **Sign** methods**. **Its value provides unique signature identification. When signing document **Sign** method returns newly created signatures with this property set. So once signature was added to the document it can be identified by assigned **SignatureId** property. The same is true for document Search.
*   class implements **ICloneable** interface that means ability to call **Clone** method to obtain copy of existing instance of object.
*   method **Equals** was overridden to support object equals checking

Since 20.3 version there's ability to manipulate signatures like updating its properties or remove signatures from the document. To provide signature identification unique identifier was added. Newly added constructor allows to create signature with this identifier.

**Updated class BarcodeSignature with EncodeType, Text properties and constructor**

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
     * Specifies the Barcode Encode Type.
     * </p>
     */    
    public final BarcodeType getEncodeType(){}   

    /**
     * <p>
     * Specifies text of Barcode.
     * </p>
     */    
    public final String getText(){}
    

    /**
     * <p>
     * Initialize BarcodeSignature object with signature identifier that was obtained after search process.
     * This unique identifier is used to find additional properties for this signature from document signature information layer.
     * </p>
     * @param signatureId Unique signature identifier obtained by Sign or Search method of Signature class {@link Signature}.
     */    
    public BarcodeSignature(String signatureId){}
```

Example:

 following example demonstrates using **Update** method with **BarcodeSignature** created by known Signature Id value;

**Update Barcode Signature in the document by known signature id**

```java
	// initialize Signature instance
	Signature signature = new Signature("signed.xlsx");           
    // read from some data source signature Id value
    String signatureId = "1dd21cf3-b904-4da9-9413-1ff1dab51974"; 
    BarcodeSignature barcodeSignature = new BarcodeSignature(signatureId);
    barcodeSignature.setWidth(150);
    barcodeSignature.setHeight(150);
    barcodeSignature.setLeft(200);
    barcodeSignature.setTop(200);     
    // update all found signatures
    boolean updateResult = signature.update("signed.xlsx",barcodeSignature);
    if (updateResult)
    {
         System.out.print("Signature with Barcode '"+barcodeSignature.getText()+"' and encode type '"+barcodeSignature.getEncodeType().getTypeName()+"}' was updated.");
    }
    else
    {
        System.out.print("Signature was not updated in the document! It was not found!");
    }
```

### Public class **BaseSignature** was updated to support modifying signature in the document.

*    properties **Top**, **Left**, **Width** and **Height** are marked as editable to adjust signature location and size in the document
*   added new editable property **string SignatureId. **Its value provides unique signature identification. When signing document Sign method returns newly created signatures with this property set. So once signature was added to the document it can be identified by assigned **SignatureId** property. The same is true for document Search.
*   added new editable Boolean property **bool IsSignature. **This property specifies if document component (text/image/barcode/qr-code) is the actual signature or element of document content. By default all found signatures in the document are marked as signature (setSignature(true)). When particular signature object is created (over Sign method, Search or manually) this property could be changed to false, that will indicate that this component is no longer will be treated as signature object and over **Update** method saved to document
*   class implements **ICloneable** interface that means ability to call **Clone** method to obtain copy of existing instance of object.
*   method **Equals** was overridden to support object equals checking

All these properties could be used for signatures modifying.

**class BaseSignature**

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
 	 * Specifies top position of signature.
 	 * </p>
 	 */	
	public final int getTop(){}

	/**
 	 * <p>
 	 * Specifies top position of signature.
 	 * </p>
 	 */	
	public final void setTop(int value){}	

	/**
	 * <p>
 	 * Specifies left position of signature.
 	 * </p>
 	 */	
	public final int getLeft(){}

	/**
	 * <p>
	 * Specifies left position of signature.
	 * </p>
	 */	
	public final void setLeft(int value){}	

	/**
	 * <p>
	 * Specifies width of signature.
	 * </p>
	 */	
	public final int getWidth(){}

	/**
	 * <p>
	 * Specifies width of signature.
	 * </p>
	 */	
	public final void setWidth(int value){}
	
	/**
 	 * <p>
 	 * Specifies height of signature.
 	 * </p>
 	 */	
	public final int getHeight(){}

	/**
 	 * <p>
 	 * Specifies height of signature.
	 * </p>
	 */	
	public final void setHeight(int value){}	

    /**
     * <p>
     * Unique signature identifier to modify signature in the document over Update or Delete methods.
     * This property will be set automatically after Sign or Search method being called.
     * If this property was saved before it can be set manually to manipulate the signature.
     * </p>
     */    
    public final String getSignatureId(){}    

    /**
     * <p>
     * Get or set flag to indicate if this component is Signature or document content.
     * This property is being used with Update method to set element as signature (true) or document element (false).
     * </p>
     */   
    public final boolean isSignature(){}
    /**
     * <p>
     * Get or set flag to indicate if this component is Signature or document content.
     * This property is being used with Update method to set element as signature (true) or document element (false).
     * </p>
     */    
    public final void setSignature(boolean value){}
    
}
```

### Public class **DeleteResult **was added to keep result of **Delete** method of Signature class.

This class implements newly added interface **[IResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/IResult)** that specifies succeeded and failed signatures after process.

**New public class DeleteResult**

```java
/**
 * <p>
 * Result of signature(s) deletion from the document.
 * </p>
 */
public class DeleteResult implements IResult
{   
   /**
    * <p>
    * List of successfully deleted signatures .
    * </p>
    */    
    public final java.util.List<BaseSignature> getSucceeded() {}   
  
   /**
    * <p>
    * List of signatures that were not deleted .
    * </p>
    */    
    public final java.util.List<BaseSignature> getFailed() { }
}
```

*   property **Succeeded** contains list of signatures that were successfully deleted from the document.
*   property **Failed** contains list of signatures that were not removed from the document.

Signature passed to method **Delete** may not be removed from the document for several reasons:

*   signature was passed only with property** SignatureId** identifier that was not found at document signature information layer;
*   signature was passed after Search method with correct properties, but was not found inside document with these coordinates, size or other properties that identifies unique signature.
*   signature was passed with "wrong" properties like not actual **SignatureId**, coordinates **Left**, **Top**, **Width** or **Height**, same as Text for text signatures or **BarcodeType** for barcode signatures

Following example demonstrates using **Delete** method and analyzing **DeleteResult** response

**Delete Text Signatures from the document**

```java
// instantiating the signature object
Signature signature = new Signature("signed.pdf");
try 
{
    TextSearchOptions options = new TextSearchOptions();

    // search for text signatures in document
    List<TextSignature> signatures = signature.search(TextSignature.class,options);
    if(signatures.size() > 0)
    {
        TextSignature textSignature = signatures.get(0);
        boolean result = signature.delete("signed.pdf",textSignature);
        if(result)
        {
            System.out.print("Signature with Text " + textSignature.getText() + " was deleted from document [" + fileName + "].");
        }
        else
        {
            System.out.print("Signature was not deleted from the document! Signature with Text " + textSignature.getText() + " was not found!");
        }
    }
} catch (Exception e) {
    throw new GroupDocsSignatureException(e.getMessage());
}
```

### Public class **DigitalSignature** was updated with changes

*   class implements **ICloneable** interface that means ability to call **Clone** method to obtain copy of existing object instance;
*   method **Equals** was overridden to support object equality checking.

### Public class **ImageSignature** was updated

*   property **int Size** was marked as read-only
*   new public constructor **ImageSignature**(**string signatureId**) was added with string argument as unique signature identifier that could be obtained by **Search** or **Sign** methods**. **Its value provides unique signature identification. When signing document Sign method returns newly created signatures with this property set. So once signature was added to the document it can be identified by assigned **SignatureId** property. The same is true for document Search.
*   class implements **ICloneable** interface that means ability to call **Clone** method to obtain copy of existing object instance.
*   method **Equals** was overridden to support object equality checking

Since 20.3 version there's ability to manipulate signatures like updating its properties or remove signatures from the document. To provide signature identification unique identifier was added. Newly added constructor allows to create signature with this identifier.

**Updated class ImageSignature with Size property and constructor**

```java
/**
 * <p>
 * Contains Image signature properties.
 * </p>
 */
public class ImageSignature extends BaseSignature
{
	/**
	 * <p>
	 * Specifies the size in bytes of signature image.
 	* </p>
	 */
	public final int getSize(){}
	/**
	 * <p>
	 * Specifies the size in bytes of signature image.
	 *
	 * </p>
	 */
	public final void setSize(int value){}

	/**
	 * <p>
 	* Initialize ImageSignature object with signature identifier that was obtained after search process.
 	* This unique identifier is used to find additional properties for this signature from document signature information layer.
 	* </p> 
 	*/
	public ImageSignature(String signatureId){}
}
```

Following example demonstrates using **Update** method with **ImageSignature**

**Update Image Signature in the document**

```java
// initialize Signature instance
Signature signature = new Signature(outputFilePath);
try 
{
    ImageSearchOptions options = new ImageSearchOptions();

    // search for image signatures in document
    List<ImageSignature> signatures = signature.search(ImageSignature.class, options);
    if (signatures.size() > 0)
    {
        ImageSignature imageSignature = signatures.get(0);
        boolean result = signature.update(outputFilePath,imageSignature);
        if (result)
        {
            System.out.print("Image signature at location "+imageSignature.getLeft() + "x"+imageSignature.getTop()+" and Size "+imageSignature.getSize()+" was updated");
        }
        else
        {
            System.out.print("Signature was not updated in the document! It was not found!");
        }
    }
} catch (Exception e) {
    throw new GroupDocsSignatureException(e.getMessage());
}
```

### Public interface** IResult **was added to specify signatures process result common properties.

This interface keeps two lists of signatures, one for successfully processed signatures and another one for failed ones.

**New public interface IResult**

```java
**
 * <p>
 * Common interface for signature process result.
 * </p>
 */
public interface IResult
{   
   /**
    * <p>
    * List of successfully processed signatures .
    * </p>
    */    
    public java.util.List<BaseSignature> getSucceeded();
    
   /**
    * <p>
    * List of signatures that were not processed .
    * </p>
    */    
    public java.util.List<BaseSignature> getFailed();
}
```

*   read-only property **Succeeded** specifies list of signatures that were successfully processed. 
*   for **Sign** process this is a list of newly created signatures (see **[SignResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/SignResult)**),
*   for **Update** method this property keeps a list of successfully updated signatures (see **[UpdateResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/UpdateResult)**),
*   for **Delete** method this property keeps a list of successfully deleted signatures (see **[DeleteResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/DeleteResult)**)
*   property **Failed** specifies list of signatures that were not successfully processed. 
*   for **Sign** process this is a list of newly created signatures (see **[SignResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/SignResult)**),
*   for **Update** method this property keeps a list of successfully updated signatures (see **[UpdateResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/UpdateResult)**),
*   for **Delete** method this property keeps a list of successfully deleted signatures (see **[DeleteResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/DeleteResult)**)

See different examples for various methods

### Public class **MetadataSignature** was updated

*   class implements **ICloneable** interface that means ability to call **Clone** method to obtain copy of existing object instance.
*   method **Equals** was overridden to support object equality checking.

### Public class **QrCodeSignature** was updated

*   property**EncodeType** was marked as read-only
*   property **Text** was marked as read-only
*   new public constructor **QrCodeSignature**(**string signatureId**) was added with string argument as unique signature identifier that could be obtained by **Search** or **Sign** methods**. **Its value provides unique signature identification. When signing document **Sign** method returns newly created signatures with this property set. So once signature was added to the document it can be identified by assigned **SignatureId** property. The same is true for document Search.
*   class implements **ICloneable** interface that means ability to call **Clone** method to obtain copy of existing object instance.
*   method **Equals** was overridden to support object equality checking.

Since 20.3 version there's an ability to manipulate signatures like updating its properties or remove signatures from the document. To provide signature identification unique identifier was added. Newly added constructor allows to create signature with this identifier.

**Updated class QrCodeSignature with EncodeType, Text properties and constructor**

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
     * Specifies the QR-code Encode Type.
     * </p>
     */    
    public final QrCodeType getEncodeType(){}    

    /**
     * <p>
     * Specifies text of QR-code.
     * </p>
     */    
    public final String getText(){}

    /**
     * <p>
     * Initialize QrCodeSignature object with signature identifier that was obtained after search process.
     * This unique identifier is used to find additional properties for this signature from document signature information layer.
     * </p>     
     */    
    public QrCodeSignature(String signatureId){ }  
}
```

Following example demonstrates using **Delete** method with **QrCodeSignature** created by known Signature Id value;

**Update QR-code Signature in the document by known signature id**

```java
// initialize Signature instance
Signature signature = new Signature("signed.pdf");
try
{
    // read from some data source signature Id value
    string signatureId = "47512fb5cf71477dbecc4170ec918860";
    QrCodeSignature qrCodeSignature = new QrCodeSignature(signatureId);
    boolean result = signature.delete(outputFilePath,qrCodeSignature);
    if (result)
    {
        System.out.print("Signature with QR-Code "+qrCodeSignature.getText()+" and encode type "+qrCodeSignature.getEncodeType().getTypeName()+" was deleted.");
    }
    else
    {
        System.out.print("Signature was not deleted from the document! Signature with Barcode "+qrCodeSignature.getText()+" and encode type "+qrCodeSignature.getEncodeType().getTypeName()+" was not found!");
    }
    
} catch (Exception e) {
    throw new GroupDocsSignatureException(e.getMessage());
}
```

### Public class **SignResult **was added

This class implements newly added interface **[IResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/IResult)** that specifies succeeded and failed signatures after process.

**New public class SignResult**

```java
/**
 * <p>
 * Result of signing process for document with newly created signatures.
 * </p>
 */
public class SignResult implements IResult
{   
   /**
    * <p>
    * List of newly created signatures .
    * </p>
    */   
    public final java.util.List<BaseSignature> getSucceeded() {}
     
   /**
    * <p>
    * List of signatures that were failed to create.
    * </p>
    */    
    public final java.util.List<BaseSignature> getFailed() {}
}
```

*   property **Succeeded** contains a list of signatures that were successfully created in the document.
*   property **Failed** contains list of signatures that were failed to create due to internal errors or exception.

Following example demonstrates using **Sign** method and analyzing **SignResult** response

**Sign document and analyze result**

```java
// instantiating the signature object
Signature signature = new Signature("sample.pdf");
try 
{
    // create QRCode option with predefined QRCode text
    QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
    options.setEncodeType(QrCodeTypes.QR);
    options.setHorizontalAlignment(HorizontalAlignment.Right);
    options.setVerticalAlignment(VerticalAlignment.Bottom);

    // sign document to file
    SignResult signResult = signature.sign("signed.pdf", options);
    if (signResult.getFailed().size() == 0)
    {
        System.out.print("\nAll signatures were successfully created!");
    }
    else
    {
        System.out.print("Successfully created signatures : "+signResult.getSucceeded().size());
        System.out.print("Failed signatures : "+signResult.getFailed().size());
    }
    System.out.print("\nList of newly created signatures:");
    int number = 1;
    for (BaseSignature temp : signResult.getSucceeded())
    {
        System.out.print("Signature #"+ +number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
    }
}catch(Exception e){
    throw new GroupDocsSignatureException(e.getMessage());
}


```

### Public class **TextSignature** was updated

*   property **Text** was marked as editable and now it can be changed when modifying signatures
*   property **TextSignatureImplementation SignatureImplementation** was marked as read-only since current signature class does not support changing implementation of Text Signature.
    
*   new public constructor **TextSignature**(**string signatureId**) was added with string argument as unique signature identifier that could be obtained by **Search** or **Sign** methods**. **Its value provides unique signature identification. When signing document **Sign** method returns newly created signatures with this property set. So once signature was added to the document it can be identified by assigned **SignatureId** property. The same is true for document Search.
*   class implements **ICloneable** interface that means ability to call **Clone** method to obtain copy of existing object instance.
*   method **Equals** was overridden to support object equality checking.

Since 19.12 version there's an ability to manipulate signatures like updating its properties or remove signatures from the document. To provide signature identification unique identifier was added. Newly added constructor allows to create signature with this identifier.

**Updated class TextSignature with constructor**

```java
/**
 * <p>
 * Contains Text signature properties.
 * </p>
 */
public class TextSignature extends BaseSignature
{
    /**
     * <p>
     * Specifies text in signature.
     * </p>
     */    
    public final String getText(){ }

    /**
     * <p>
     * Specifies text in signature.
     * </p>
     */   
    public final void setText(String value){}    

    /**
     * <p>
     * Specifies text signature implementation.
     * </p>
     */    
    public int getSignatureImplementation(){}  

    /**
     * <p>
     * Initialize TextSignature object with signature identifier that was obtained after search process.
     * This unique identifier is used to find additional properties for this signature from document signature information layer.
     * </p>    
     */    
    public TextSignature(String signatureId){}
    
}


```

Following example demonstrates using **Update** method with **TextSignature** obtained from Search method

**Update Text Signature in the document after Search**

```java
// initialize Signature instance
Signature signature = new Signature("signed.pdf");
TextSearchOptions options = new TextSearchOptions();

List<TextSignature> signatures = signature.search(TextSignature.class, options);
    
    if(signatures.size()> 0)
    {
        TextSignature textSignature = signatures [0];
        // change Text property
        textSignature.setText("John Walkman");
        // change position
        textSignature.setLeft(textSignature.getLeft() + 100);
		textSignature.setTop(textSignature.getTop() + 100);
        // change size. Please note not all documents support changing signature size
        textSignature.setWidth(200);
        textSignature.setHeight(100);
       
        bool result = signature.update("signed.pdf",textSignature);
        if (result) {
    		System.out.print("Signature with Text '" + textSignature.getText() + "' was updated in the document ['signed.pdf'].");
		} else {
    		System.out.print("Signature was not updated in  the document! Signature with Text '" + textSignature.getText() + "' was not found!");
		}
    }
}
```

### Public class **UpdateResult **was added

This class implements newly added interface **[IResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/IResult)** that specifies succeeded and failed signatures after process.

**New public class DeleteResult**

```java
/**
 * <p>
 * Result of modification of signatures in the document.
 * </p>
 */
public class UpdateResult implements IResult
{   
   /**
    * <p>
    * List of successfully modified signatures.
    * </p>
    */    
    public final java.util.List<BaseSignature> getSucceeded() {}
   
   /**
    * <p>
    * List of signatures that were not updated .
    * </p>
    */   
    public final java.util.List<BaseSignature> getFailed() { }
}
```

*   property **Succeeded** contains list of signatures that were successfully updated in the document.
*   property **Failed** contains list of signatures that were passed as an argument, but not found in the document so was not updated.

Few reasons when passed signature to method **Update** was not processed (updated) in the document

*   signature was passed only with property** SignatureId** identifier (see changes of **[BaseSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BaseSignature)**) that was not found at document signature information layer;
*   signature was passed after Search method with correct properties, but was not found in a document with these coordinates, size or other properties that identifies unique signature.
*   signature was passed with "wrong" properties like not actual **SignatureId**, coordinates **Left**, **Top**, **Width** or **Height**, same as Text for text signatures or **BarcodeType** for barcode signatures

Following example demonstrates using **Update** method and analyzing **UpdateResult** response

**Search document for Text Signatures**

```java
// initialize Signature instance
Signature signature = new Signature("signed.pdf");
// read from some data source signature Id value
String[] signatureIdList = new String[]
        {
                "1dd21cf3-b904-4da9-9413-1ff1dab51974",
                "b0123987-b0d4-4004-86ec-30ab5c41ac7e"
        };
// create list of Barcode Signature by known SignatureId
List<BaseSignature> signatures = new ArrayList<BaseSignature>();
for (String item : signatureIdList)
{
    TextSignature temp = new TextSignature("1dd21cf3-b904-4da9-9413-1ff1dab51974");
    temp.setWidth(150);
    temp.setHeight(150);
    temp.setLeft(200);
    temp.setTop(200);
    signatures.add(temp);
}
// update all found signatures
UpdateResult updateResult = signature.update("signed.pdf",signatures);
if (updateResult.getSucceeded().size() == signatures.size())
{
    System.out.print("\nAll signatures were successfully updated!");
}
else
{
    System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
    System.out.print("Not updated signatures : "+updateResult.getFailed().size());
}
```

### Public class **IncorrectPasswordException** can be used to handle scenario when incorrect password were provided at **LoadOptions** for password protected documents.

This exception will be thrown once Signature class will try to access protected file.

**New public class DeleteResult**

```java
/**
 * <p>
 * The exception that is thrown when specified password is incorrect.
 * </p>
 */
public class IncorrectPasswordException extends GroupDocsSignatureException
{
}
```

*   class inherits common **GroupDocsSignatureException**
*   exception message contains only common information message "Specified password is incorrect."
*   please be aware that when password is not specified for protected documents another exception occurs, see **IncorrectPasswordException**

Following example demonstrates analyzing different errors with incorrect password exception

**Handling Exceptions example**

```java
// initialize LoadOptions with incorrect Password
LoadOptions loadOptions = new LoadOptions();
loadOptions.setPassword("1");
final Signature signature = new Signature(filePath, loadOptions);
try
{
   QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
   options.setEncodeType(QrCodeTypes.QR);
   options.setLeft(100);
   options.setTop(100);
   // try to sign document to file, we expect for PasswordRequiredException
   signature.sign("sample.pdf", options);
   System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
}
catch (IncorrectPasswordException ex)
{
    System.out.print("HandlingIncorrectPasswordException: " + ex.getMessage());
}
catch (GroupDocsSignatureException ex)
{
    System.out.print("Common GroupDocsSignatureException: " + ex.getMessage());
}
catch (java.lang.RuntimeException ex)
{
    System.out.print("Common Exception happens only at user code level: " + ex.getMessage());
}
```

### Added new boolean **HideSignatures** property to **PreviewOptions **class. 

This property indicates whether signatures that were marked as **IsSignature = true** should be hidden from document preview or not**. **For more information see **[BaseSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BaseSignature).**

**class PreviewOptions**

```java
/**
 * <p>
 * Represents document preview options.
 * </p>
 */
public class PreviewOptions
{
/**
 * <p>
 * Gets or sets flag to hide signatures from page preview image.
 * Only signatures are marked as IsSignature will be hidden from generated document page image.
 * </p>
 */
public final boolean getHideSignatures(){}

/**
 * <p>
 * Gets or sets flag to hide signatures from page preview image.
 * Only signatures are marked as IsSignature will be hidden from generated document page image.
 * </p>
 */
public final void setHideSignatures(boolean value){}
}
```

Following example demonstrates usage of **HideSignatures** property for hiding signatures in document preview.

**Using HideSignatures property for hiding signatures for document preview**

```java
public class GeneratePreviewAdvanced
{
    /// <summary>
    /// Generate document pages preview with using HideSignature feature
    /// </summary>
    public static void Run()
    {
        // The path to the documents directory.
        string filePath = Constants.SAMPLE_PDF_SIGNED;
        using (Signature signature = new Signature(filePath))
        {
            // create preview options object
            PreviewOptions previewOption = new PreviewOptions(GeneratePreviewAdvanced.CreatePageStream, GeneratePreviewAdvanced.ReleasePageStream)
            {
                PreviewFormat = PreviewOptions.PreviewFormats.JPEG,
                // set property to hide all known signatures
                HideSignatures = true
            };
            // generate preview
            signature.GeneratePreview(previewOption);
        }
    }
    private static Stream CreatePageStream(int pageNumber)
    {
        string imageFilePath = Path.Combine(Constants.OutputPath, "GeneratePreviewHideSignatures", "image-" + pageNumber.ToString() + ".jpg");
        string folder = Path.GetDirectoryName(imageFilePath);
        if (!Directory.Exists(folder))
        {
            Directory.CreateDirectory(folder);
        }
        return new FileStream(imageFilePath, FileMode.Create);
    }
    private static void ReleasePageStream(int pageNumber, Stream pageStream)
    {
        pageStream.Dispose();
        string imageFilePath = Path.Combine(Constants.OutputPath, "GeneratePreviewHideSignatures", "image-" + pageNumber.ToString() + ".jpg");
        Console.WriteLine("Image file {0} is ready for preview", imageFilePath);
    }
}
 
public class GeneratePreviewAdvanced {
    /**
     * <p>
     * Generate document pages preview with using HideSignature feature
     * </p>
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = "C:\\sample.pdf";

        final Signature signature = new Signature(filePath);
        try
        {
            // create preview options object
            PreviewOptions previewOption = new PreviewOptions(new PageStreamFactory() {
                @Override
                public OutputStream createPageStream(int pageNumber) {
                    return generateStream(pageNumber);
                }

                @Override
                public void closePageStream(int pageNumber, OutputStream pageStream) {
                    releasePageStream(pageNumber, pageStream);
                }
            });
            previewOption.setPreviewFormat(PreviewFormats.JPEG);
            previewOption.setHideSignatures(true);
            // generate preview
            signature.generatePreview(previewOption);

        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }


    private static OutputStream generateStream(int pageNumber)
    {
        try {
            Path path = Paths.get("C:\\GeneratePreviewHideSignatures\\");

            if (!Files.exists(path)) {

                Files.createDirectory(path);
                System.out.println("Directory created");
            } else {

                System.out.println("Directory already exists");
            }
            File filePath = new File(path+"\\image-"+pageNumber+".jpg");

            return new FileOutputStream(filePath);
        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }

    }

    private static void releasePageStream(int pageNumber, OutputStream pageStream)
    {
        try {
            pageStream.close();
            String imageFilePath = new File("C:\\GeneratePreviewHideSignatures", "image-" +pageNumber +  ".jpg").getPath();
            System.out.print("Image file "+imageFilePath+" is ready for preview");
        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}
```

### Added new **boolean** property **SkipExternal** to **SearchOptions** class.

This property indicates if Search result should return external signatures (external signatures are the signatures that were added with an 3rd party software and not with GroupDocs.Signature).

Since 20.3 every time when document is being signed information about document signatures are stored in document's metadata. Which means that all created signatures by GroupDocs.Signature can be distinguished from an actual document content and **BaseSignature.IsSignature** flag will be set as true. **BaseSignature.IsSignature** property specifies if document component (text/image/barcode/qr-code) is the actual signature or element of document content.

In order to convert signatures added by 3rd party software or by previous version of GroupDocs.Signature, just run Search with **SearchOptions.****SkipExternal** property set to false and update **BaseSignature.IsSignature** for each signature returned by the search result.

There are few ways to manipulate with document signature search results:

*   If signature is no longer required it can be removed from the document by **Delete** method;
*   Signature could be marked as document native content by setting up **IsSignature = false** property,in this case **SearchOptions.SkipExternal** field will allow **Search** method to skip this signature;
*   Signatures that were added before 20.3 are treated as non signatures because information about them are not yet stored in the document. Setting **SkipExternal** flag to **true** will exclude these signatures from **Search **result.

**class PreviewOptions**

```java
/**
 * <p>
 * Represents the extract signatures from document options.
 * </p>
 */
public abstract class SearchOptions
{
	/**
 	* <p>
 	* Flag to return only signatures marked as IsSignature. By default value is false that indicates to return all signatures that match specified criteria.
 	* </p>
 	*/
	public final boolean getSkipExternal(){}

	/**
 	* <p>
 	* Flag to return only signatures marked as IsSignature. By default value is false that indicates to return all signatures that match specified criteria.
 	* </p>
 	*/
	public final void setSkipExternal(boolean value){}
}
```

**Example 1. Excluding non signatures from search  
**

 Following example demonstrates usage of **SkipExternal** property for excluding non actual signatures from search result

**Using SearchOptions SkipExternal property to exclude non actual signatures from search**

```java
	Signature signature = new Signature("sample_signed.pdf");
	TextSearchOptions options = new TextSearchOptions();
    options.setSkipExternal(true);
    options.setAllPages(false);
    // search for text signatures in document
    List<TextSignature> signatures = signature.search(TextSignature.class,options);
    System.out.print("\nSource document contains following text signature(s).");
    for (TextSignature sign : signatures)
    {
        if (sign != null)
        {
            System.out.print("Found Text signature at page "+sign.getPageNumber()+" with type ["+sign.getSignatureImplementation()+"] and text '"+sign.getText()+"'.");
            System.out.print("Location at "+sign.getLeft()+"-"+sign.getTop()+". Size is "+sign.getWidth()+"x"+sign.getHeight()+".");
        }
    }
```

**Example 2. Updating signatures from GroupDocs.Signature 19.11 and below  
**

Following examples shows the way to mark signatures in document as actual signatures (**BaseSignature.IsSignature = true)**

**How to mark signatures in document as actual signatures**

```java
// initialize Signature instance
Signature signature = new Signature("sample_signed.pdf");
try 
{
    // define few search options
    BarcodeSearchOptions barcodeOptions = new BarcodeSearchOptions();
    QrCodeSearchOptions qrCodeOptions = new QrCodeSearchOptions();
    // add options to list
    List<SearchOptions> listOptions = new ArrayList<SearchOptions>();
    listOptions.add(barcodeOptions);
    listOptions.add(qrCodeOptions);

    // search for signatures in document
    SearchResult result = signature.search(listOptions);
    if (result.getSignatures().size() > 0)
    {
        System.out.print("\nTrying to update all signatures...");
        // mark all signatures as actual Signatures
        for (BaseSignature baseSignature : result.getSignatures())
        {
            baseSignature.setSignature(true);
        }
        // update all found signatures
        UpdateResult updateResult = signature.update("sample_signed.pdf",result.getSignatures());
        if (updateResult.getSucceeded().size() == result.getSignatures().size())
        {
            System.out.print("\nAll signatures were successfully updated!");
        }
        else
        {
            System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
            System.out.print("Not updated signatures : "+updateResult.getFailed().size());
        }
        System.out.print("\nList of updated signatures:");
        int number = 1;
        for (BaseSignature temp : updateResult.getSucceeded())
        {
            System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
        }
    }
    else
    {
        System.out.print("No one signature was found.");
    }
```

### Public class **PasswordRequiredException **can be used to handle scenario with missing password set up at LoadOptions for password protected documents.

This exception will be thrown once Signature class will try to access protected file.

**New public class DeleteResult**

```java
/**
 * <p>
 * The exception that is thrown when password is required to load the document.
 * </p>
 */
public class PasswordRequiredException extends GroupDocsSignatureException
{
}
```

*   class inherits common **GroupDocsSignatureException**
*   exception message contains only information message "Please specify password to load the document."
*   please be aware that when password is specified but incorrect another exception occurs, see **IncorrectPasswordException**

Following example demonstrates analyzing different exceptions

**Handling Exceptions example**

```java
// skip initialization of LoadOptions with Password
// LoadOptions loadOptions = new LoadOptions(){ Password  = "1234567890" }
Signature signature = new Signature("SamplePasswordProtected.pdf");
try 
{
    try
    {
        QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
        options.setEncodeType(QrCodeTypes.QR);
        options.setLeft(100);
        options.setTop(100);
        // try to sign document to file, we expect for PasswordRequiredException
        signature.sign(outputFilePath, options);
        System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }
    catch(PasswordRequiredException ex)
    {
        System.out.print("PasswordRequiredException: " + ex.getMessage());
    }
    catch(GroupDocsSignatureException ex)
    {
        System.out.print("Common GroupDocsSignatureException: " + ex.getMessage());
    }
    catch (java.lang.RuntimeException ex)
    {
        System.out.print("Common Exception happens only at user code level: " + ex.getMessage());
    }
    finally
    {

    }
}catch (Exception e){
    throw new GroupDocsSignatureException(e.getMessage());
}
```

### Main public class **Signature** was updated with following changes

*   all existing overload methods **Sign** were extended with result as instance of object **SignResult** (see **[SignResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/SignResult)**). This result allows to obtain list of newly created signatures (see changes of base class **[BaseSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/BaseSignature)**) with all properties set (like actual location, size, implementation type, and other corresponding signature fields) and new properties **IsSignature** = true and assigned value to internal property **SignatureId.**
    
    **Updated overload method Sign definition**
    
    ```java
    public SignResult sign(java.io.OutputStream document, SignOptions signOptions)
    
    public SignResult sign(java.io.OutputStream document, SignOptions signOptions, SaveOptions saveOptions);
    
    public SignResult sign(java.io.OutputStream document, java.util.List<SignOptions> signOptionsList);
    
    public SignResult sign(java.io.OutputStream document, java.util.List<SignOptions> signOptionsList, SaveOptions saveOptions);
    
    public SignResult sign(String filePath, SignOptions signOptions);
    
    public SignResult sign(String filePath, SignOptions signOptions, SaveOptions saveOptions);
    
    public SignResult sign(String filePath, java.util.List<SignOptions> signOptionsList);
    
    public SignResult sign(String filePath, java.util.List<SignOptions> signOptionsList, SaveOptions saveOptions);
    ```
    
*   added new overload method **Update **that expects one signature or list of signatures to update in the document. Method with one signature argument returns Boolean value as indicator if process went successfully. Method with list of signatures returns instance of **UpdateResult**. See **[UpdateResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/UpdateResult)**  with lists of updated signatures and signatures that were not found. Each of passed signature should be identified with existing signatures in the document. This identification could be provided in two ways. First way when signature was searched right pass to **Update** method by **Search** method. See first example 2 *How to update signatures after Search*. The second way works over unique signature identifier **SignatureId**. This **SignatureId** could be obtained after **Sign** result as unique signature identifier stored at document metadata layer. The very important thing here that this method applies changes in same document file or stream. See second example  *How to update signatures by known Id*
    
    **New overload method Update definition**
    
    ```java
    public boolean update(OutputStream document, BaseSignature signature);
    
    public UpdateResult update(OutputStream document, java.util.List<BaseSignature> signatures);
     
    public boolean update(String filePath, BaseSignature signature);
     
    public UpdateResult update(String filePath, java.util.List<BaseSignature> signatures);
    ```
    
*   added new overload method **Delete **that that expects one signature or list of signatures to delete from the document. Method with one signature argument returns Boolean value as indicator if process went successfully. Method with list of signatures returns instance of **DeleteResult**. See **[DeleteResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/DeleteResult)**  with lists of removed signatures and signatures that were not found. Same as method **Update** each of passed signature should be identified with existing signatures in the document. This identification could be provided by two ways. First way when signature was searched right pass to **Update** method by **Search** method. See first example *How to update signatures after Search*. The second way works over unique signature identifier **SignatureId**. This **SignatureId** could be obtained after **Sign** result as unique signature identifier stored at document metadata layer. The very important thing here that this method applies changes in same document file or stream.
    
    ```java
    public boolean delete(OutputStream document, BaseSignature signature);
    
    public DeleteResult delete(OutputStream document, java.util.List<BaseSignature> signatures);
     
    public boolean delete(String filePath, BaseSignature signature);
     
    public DeleteResult delete(String filePath, java.util.List<BaseSignature> signatures);
    ```
    

**Examples:**

1.  *How to sign document and analyze result.* Following example shows analysis of **SignResult** response.
    
    **Signing document with further result analysis**
    
    ```java
     
     
    	Signature signature = new Signature("sample.pdf");
    	// create QRCode option with predefined QRCode text
        QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
        options.setEncodeType(QrCodeTypes.QR);
        options.setHorizontalAlignment(HorizontalAlignment.Right);
        options.setVerticalAlignment(VerticalAlignment.Bottom);
    
        // sign document to file
        SignResult signResult = signature.sign("signed.pdf", options);
        if (signResult.getFailed().size() == 0)
        {
            System.out.print("\nAll signatures were successfully created!");
        }
        else
        {
            System.out.print("Successfully created signatures : "+signResult.getSucceeded().size());
            System.out.print("Failed signatures : "+signResult.getFailed().size());
        }
        System.out.print("\nList of newly created signatures:");
        int number = 1;
        for (BaseSignature temp : signResult.getSucceeded())
        {
            System.out.print("Signature #"+ +number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
        }
    ```
    
2.  *How to update signatures after **Search***. Following example demonstrates using of **Search** method to find signatures and then modifying selected signatures with **Update** method.
    
    **Updating signatures after Search**
    
    ```java
    	// initialize Signature instance
    	Signature signature = new Signature("sampleSigned.pdf");
    	// define few search options
        BarcodeSearchOptions barcodeOptions = new BarcodeSearchOptions();
        QrCodeSearchOptions qrCodeOptions = new QrCodeSearchOptions();
        // add options to list
        List<SearchOptions> listOptions = new ArrayList<SearchOptions>();
        listOptions.add(barcodeOptions);
        listOptions.add(qrCodeOptions);
    
        // search for signatures in document
        SearchResult result = signature.search(listOptions);
        if (result.getSignatures().size() > 0)
        {
            System.out.print("\nTrying to update all signatures...");
            // mark all signatures as actual Signatures
            for (BaseSignature baseSignature : result.getSignatures())
            {
                baseSignature.setSignature(true);
            }
            // update all found signatures
            UpdateResult updateResult = signature.update("sampleSigned.pdf", result.getSignatures());
            if (updateResult.getSucceeded().size() == result.getSignatures().size())
            {
                System.out.print("\nAll signatures were successfully updated!");
            }
            else
            {
                System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
                System.out.print("Not updated signatures : "+updateResult.getFailed().size());
            }
            System.out.print("\nList of updated signatures:");
            int number = 1;
            for (BaseSignature temp : updateResult.getSucceeded())
            {
                System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
        else
        {
            System.out.print("No one signature was found.");
        }
    ```
    
3.  *How to update signature using **SignatureId** property*. Following example demonstrates using of **Update** method to modify signatures using known **SignatureId** properties.
    
    ```java
     // initialize Signature instance
    Signature signature = new Signature("signed.pdf");
    // read from some data source signature Id value
    String[] signatureIdList = new String[]
            {
                    "1a5fbc08-4b96-43d9-b650-578b16fbb877"
            };
    // create list of Barcode Signature by known SignatureId
    List<BaseSignature> signatures = new ArrayList<BaseSignature>();
    for (String item : signatureIdList)
    {
        BarcodeSignature temp = new BarcodeSignature(item);
        temp.setWidth(150);
        temp.setHeight(150);
        temp.setLeft(200);
        temp.setTop(200);
        signatures.add(temp);
    }
    // update all found signatures
    UpdateResult updateResult = signature.update("signed.pdf", signatures);
    if (updateResult.getSucceeded().size() == signatures.size())
    {
        System.out.print("\nAll signatures were successfully updated!");
    }
    else
    {
        System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
        System.out.print("Not updated signatures : "+updateResult.getFailed().size());
    }
    ```
    
4.  *How to delete signatures after **Search***. Following example demonstrates using of **Search** method to find signatures and then remove them over** Delete** method.  
      
    
    **Deleting signatures after Search**
    
    ```java
    // initialize Signature instance
    Signature signature = new Signature("signed.pdf");
    BarcodeSearchOptions options = new BarcodeSearchOptions();
    
    List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class, options);
    List<BaseSignature> signaturesToDelete = new ArrayList<BaseSignature>();
    // collect signatures to delete
    for (BarcodeSignature temp : signatures)
    {
        if (temp.getText().contains("John"))
        {
            signaturesToDelete.add(temp);
        }
    }
    // delete signatures
    DeleteResult deleteResult = signature.delete("signed.pdf",signaturesToDelete);
    if (deleteResult.getSucceeded().size() == signaturesToDelete.size())
    {
        System.out.print("All signatures were successfully deleted!");
    }
    else
    {
        System.out.print("Successfully deleted signatures : "+deleteResult.getSucceeded().size());
        System.out.print("Not deleted signatures : "+deleteResult.getFailed().size());
    }
    System.out.print("List of deleted signatures:");
    for(BaseSignature temp : deleteResult.getSucceeded())
    {
        System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
    }
    ```
    
5.  *How to delete signature using **SignatureId** property*. Following example demonstrates using of **Delete** method to remove signatures using known **SignatureId** properties.  
      
    
    ```java
    // initialize Signature instance
    Signature signature = new Signature(outputFilePath);
    // read from some data source signature Id value
    String[] signatureIdList = new String[]
            {
                    "a6fec431-111e-4572-950c-5cc5f1c85d36",
                    "b0123987-b0d4-4004-86ec-30ab5c41ac7e"
            };
    // create list of Text Signature by known SignatureId
    List<BaseSignature> signatures = new ArrayList<BaseSignature>();
    for (String item : signatureIdList)
    {
        signatures.add(new TextSignature(item));
    }
    
    // delete required signatures
    DeleteResult deleteResult = signature.delete(outputFilePath, signatures);
    if (deleteResult.getSucceeded().size() == signatures.size())
    {
        System.out.print("All signatures were successfully deleted!");
    }
    else
    {
        System.out.print("Successfully deleted signatures : " + deleteResult.getSucceeded().size());
        System.out.print("Not deleted signatures : " + deleteResult.getFailed().size());
    }
    ```
    

## Public Developer Guide examples changes

Following topics from Developer Guide were updated:

*   [Basic usage]({{< ref "signature/java/developer-guide/basic-usage/_index.md" >}})
*   [Sign document with Text signature (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/signing/sign-document-with-text-signature-advanced.md" >}})
*   [Sign document with Barcode signature (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/signing/sign-document-with-barcode-signature-advanced.md" >}})
*   [Sign document with QR-code signature (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/signing/sign-document-with-qr-code-signature-advanced.md" >}})
*   [Sign document with Image signature (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/signing/sign-document-with-image-signature-advanced.md" >}})

Following topics from Developer Guide were added:

*   [Update Text signatures in document]({{< ref "signature/java/developer-guide/basic-usage/update-signatures-in-documents/update-text-signatures-in-document.md" >}})
*   [Updating Text signature (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/updating/updating-text-signature-with-advanced-options.md" >}})
*   [Delete Text signatures from documents]({{< ref "signature/java/developer-guide/basic-usage/delete-signatures-from-documents/delete-text-signatures-from-documents.md" >}})
*   [Deleting Text signatures (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/deleting/deleting-text-signatures-advanced.md" >}})
*   [Update Image signatures in document]({{< ref "signature/java/developer-guide/basic-usage/update-signatures-in-documents/update-image-signatures-in-document.md" >}})
*   [Updating Image signatures (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/updating/updating-image-signatures-with-advanced-options.md" >}})
*   [Delete Image signatures from documents]({{< ref "signature/java/developer-guide/basic-usage/delete-signatures-from-documents/delete-image-signatures-from-documents.md" >}})
*   [Deleting Image signatures (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/deleting/deleting-image-signatures-advanced.md" >}})
*   [Update Barcode signatures in document]({{< ref "signature/java/developer-guide/basic-usage/update-signatures-in-documents/update-barcode-signatures-in-document.md" >}})
*   [Updating Barcode signatures (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/updating/updating-barcode-signatures-with-advanced-options.md" >}})
*   [Delete Barcode signatures from documents]({{< ref "signature/java/developer-guide/basic-usage/delete-signatures-from-documents/delete-barcode-signatures-from-documents.md" >}})
*   [Deleting Barcode signatures (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/deleting/deleting-barcode-signatures-advanced.md" >}})
*   [Update QR-code signatures in document]({{< ref "signature/java/developer-guide/basic-usage/update-signatures-in-documents/update-qr-code-signatures-in-document.md" >}})
*   [Updating QR-code signatures (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/updating/updating-qr-code-signatures-with-advanced-options.md" >}})
*   [Delete QR-code signatures from documents]({{< ref "signature/java/developer-guide/basic-usage/delete-signatures-from-documents/delete-qr-code-signatures-from-documents.md" >}})
*   [Deleting QR-code signatures (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/deleting/deleting-qr-code-signatures-advanced.md" >}})
*   [Updating multiple signatures of different types]({{< ref "signature/java/developer-guide/advanced-usage/updating/updating-multiple-signatures-of-different-types.md" >}})
*   [Deleting multiple signatures of different types]({{< ref "signature/java/developer-guide/advanced-usage/deleting/deleting-multiple-signatures-of-different-types.md" >}})
*   [Generating document preview (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/previewing/generating-document-preview-advanced.md" >}})
*   [Searching for document signatures excluding external components]({{< ref "signature/java/developer-guide/advanced-usage/searching/searching-for-document-signatures-excluding-external-components.md" >}})
*   [Handling incorrect document password exception]({{< ref "signature/java/developer-guide/advanced-usage/handling-exceptions/handling-incorrect-document-password-exception.md" >}})
*   [Handling password required exception]({{< ref "signature/java/developer-guide/advanced-usage/handling-exceptions/handling-password-required-exception.md" >}})
