---
id: updating-qr-code-signatures-with-advanced-options
url: signature/java/updating-qr-code-signatures-with-advanced-options
title: Updating QR-code signatures with advanced options
weight: 4
description: " This article explains how to provide advanced options when updating QR-code electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [QrCodeSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/QrCodeSignature) class to manipulate qr-code signatures location, size, textual content and encode type over [update](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#update(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class. This method returns [UpdateResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/UpdateResult) object to analyze if signatures were successfully processed.

Please be aware that [update](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#update(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method modifies the same document that was passed to constructor of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class. The [UpdateResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/UpdateResult)contains list of successfully updated signatures and ones that failed. The Barcode signature could be failed to update due to several reasons:

*   if signature object was initialized with constructor by incorrect signature identifier;
*   if signature object was not found;
*   there was an error occurred while updating signature in the document.

Here are the steps to update QR-code signature in the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;    
*   Instantiate [QrCodeSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/QrCodeSearchOptions) object with desired properties;    
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method to obtain list of [QrCodeSignatures](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/QrCodeSignature); 
*   Select from list [QrCodeSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/QrCodeSignature) object(s) that should be updated;     
*   Call [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) object [update](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#update(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method and pass one or several signatures to it.    
*   Analyze [UpdateResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/UpdateResult) result to check whether signatures were updated or not.

Here are the alternative steps to update QR-code signature in the document with GroupDocs.Signature. This approach is based on saved signatures Id after [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) or [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions))  methods.
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;    
*   Instantiate one or several  [QrCodeSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/QrCodeSignature) objects with signature Id(s) passed to constructor; 
*   Call [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class object [update](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#update(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method and pass one or several signatures to it;
*   Analyze [UpdateResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/UpdateResult) result to check whether signatures were updated or not. 

The following table describes changeable properties for QR-code signatures dependent on document type

| Document Type / Signature Property | Left | Top | Width | Height | EncodeType | Text | IsSignature |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Image | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) |
| Spreadsheet | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) | ![(tick)](signature/java/images/check.png) |
| Pdf | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) | ![(tick)](signature/java/images/check.png) |
| Presentation | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) | ![(tick)](signature/java/images/check.png) |
| Word Processing | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(tick)](signature/java/images/check.png) | ![(error)](signature/java/images/error.png) | ![(error)](signature/java/images/error.png) | ![(tick)](signature/java/images/check.png) |

## Update QR-code signature in the document after Search

This example shows how to update QR-code signature that was found using  [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method.

```java
// initialize Signature instance
Signature signature = new Signature("sampleSigned.pdf");
BarcodeSearchOptions options = new BarcodeSearchOptions();
 
List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, options);
List<BaseSignature> bS = new ArrayList<BaseSignature>();
// adjust signature properties
for (QrCodeSignature temp : signatures)
{
    // apply some condition to adjust signature properties
    temp.setLeft(temp.getLeft() + 100);
    temp.setTop(temp.getTop() + 100);
    temp.setSignature(true);
    bS.add(temp);
}
// update all found signatures
UpdateResult updateResult = signature.update("sampleSigned.pdf",bS);
if (updateResult.getSucceeded().size() == signatures.size())
{
    System.out.print("\nAll signatures were successfully updated!");
}
else
{
    System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
    System.out.print("Not updated signatures : "+updateResult.getFailed().size());
}
System.out.print("List of updated signatures:");
for (BaseSignature temp : updateResult.getSucceeded())
{
    System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
}
```

## Update QR-code signature in document by known signature Identifier

This example shows how to update QR-code signature in the document by known signature Id (that was obtained by  [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) or [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method previously).

```java
// initialize Signature instance
Signature signature = new Signature("signed.xlsx");
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
    QrCodeSignature temp = new QrCodeSignature(item);
    temp.setWidth(150);
    temp.setHeight(150);
    temp.setLeft(200);
    temp.setTop(200);
    signatures.add(temp);
}
// update all found signatures
UpdateResult updateResult = signature.update("signed.xlsx",signatures);
if (updateResult.getSucceeded().size() == signatures.size())
{
    System.out.print("\nAll signatures were successfully updated!");
}
else
{
    System.out.print("Successfully updated signatures : "+updateResult.getSucceeded().size());
    System.out.print("Not updated signatures : "+updateResult.getFailed().size());
}
System.out.print("List of updated signatures:");
for (BaseSignature temp : updateResult.getSucceeded())
{
    System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
}
```

## More resources

GitHub Examples 

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
