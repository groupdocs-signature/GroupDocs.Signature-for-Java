---
id: search-for-embedded-object-with-custom-serialization-of-qr-code-signatures
url: signature/java/search-for-embedded-object-with-custom-serialization-of-qr-code-signatures
title: Search for embedded object with custom serialization of QR-Code signatures
weight: 2
description: " This article explains how to search for embedded electronic signatures with custom serialization in QR-code electronic signatures. This topic contains example of custom serialization, class definition and search for serialized objects in the QR-codes with GroupDocs.Signature."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
GroupDocs.Signature provides following abilities to search for embedded data objects in QR-code signatures ([QrCodeSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/QrCodeSignature)) that were embedded with custom encryption and serialization 

*   ability to search for embedded custom objects into metadata and decrypt them to original source values
*   ability to search for custom encrypted QR-code signature and decrypt it
*   ability to search for custom serialized QR-code signatures  

Here are the steps to search and decrypt previously encrypted text of QR-Code and decrypt custom object from QR-Code signature with GroupDocs.Signature API:

*   Implement (use) custom data serialization class that implements [IDataEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/IDataEncryption) interface.    
*   Ensure that data class if defined with custom serialization attribute      
*   Instantiate the [QrCodeSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/QrCodeSearchOptions) object and setup [setDataEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/QrCodeSearchOptions#setDataEncryption(com.groupdocs.signature.domain.extensions.encryption.IDataEncryption)) value with custom encryption object implementation      
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [QrCodeSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/QrCodeSearchOptions) to it.
     

## Implementation of custom data serialization

 This example shows how to specify custom serialization class. This class should be implemented as Attribute and [IDataSerializer](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/IDataSerializer) interface.

```java
/**
 * Creates class that implements IDataSerializer interface
 * It cam support common serialization like JSon or custom data format
 */
public class CustomSerializationAttribute implements IDataSerializer{
 
 
    public <T> T deserialize(String source, Class<T> type)
    {
        return new Gson().fromJson(source, type);
    }
    public String serialize(Object data)
    {
        return new Gson().toJson(data);
    }
 
}
```

## Implementation of custom data encryption

This example shows how to specify custom serialization class. This class could be implemented also as Attribute (optional) to specify as class attribute.

```java
// Define class that implements IDataEncryption interface
// Class could inherits Attribute to use it with class definition
 
public class CustomXOREncryption implements IDataEncryption
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
        StringBuilder src = new StringBuilder(source);
        StringBuilder dst = new StringBuilder(src.length());
        char chTmp;
        for (int index = 0; index < src.length(); ++index)
        {
            chTmp = src.charAt(index);
            chTmp = (char)(chTmp ^ this.getKey());
            dst.append(chTmp);
        }
        return dst.toString();
    }
}
```

## Definition of class

This example shows how to define custom class for serialization.

```java
public static class DocumentSignatureData
{
    public String getID(){ return ID; }
    public void setID(String value){ ID = value; }
    @FormatAttribute(propertyName = "SignID")
    public String ID;
 
 
    public final String getAuthor(){ return Author; }
    public final void setAuthor(String value){ Author = value; }
    @FormatAttribute(propertyName = "SAuth")
    public String Author;
    //JAVA-added public wrapper for internalized property accessor
 
    public final java.util.Date getSigned() {  return Signed; }
    public final void setSigned(java.util.Date value) { Signed = value; }
    @FormatAttribute (propertyName = "SDate",propertyFormat = "yyyy-MM-dd")
    public java.util.Date Signed = new java.util.Date();
 
 
    public final java.math.BigDecimal getDataFactor() { return DataFactor; }
    public final void setDataFactor(java.math.BigDecimal value) { DataFactor = value; }
    @FormatAttribute (propertyName = "SDFact",propertyFormat = "N2")
    public java.math.BigDecimal DataFactor = new java.math.BigDecimal(0.01);
}
```

## Search for embedded custom objects in QR-code signatures

This example shows how to decrypt previously embedded encrypted custom objects into [QrCodeSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/QrCodeSignature) contains method [getData](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/QrCodeSignature#getData(java.lang.Class)) to retrieve object

```java
Signature signature = new Signature("QRCodeCustomSerializationObject.pdf");
// create data encryption
IDataEncryption encryption = new CustomXOREncryption();
 
QrCodeSearchOptions options = new QrCodeSearchOptions();
 
// specify special pages to search on
options.setAllPages(true);
options.setDataEncryption(encryption);
 
 
// search for signatures in document
List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class,options);
System.out.print("\nSource document contains following signatures:");
for (QrCodeSignature qrCodeSignature : signatures)
{
    System.out.print("QRCode signature found at page "+qrCodeSignature.getPageNumber()+" with type "+ qrCodeSignature.getEncodeType());
    DocumentSignatureData documentSignatureData = qrCodeSignature.getData(DocumentSignatureData.class);
    if (documentSignatureData != null)
    {
        System.out.print("QRCode signature has DocumentSignatureData object:\n ID = " + documentSignatureData.getID() + ", Author = " + documentSignatureData.getAuthor() + ", Signed = " + documentSignatureData.getSigned() + ", DataFactor "+documentSignatureData.getDataFactor());
    }
}
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
