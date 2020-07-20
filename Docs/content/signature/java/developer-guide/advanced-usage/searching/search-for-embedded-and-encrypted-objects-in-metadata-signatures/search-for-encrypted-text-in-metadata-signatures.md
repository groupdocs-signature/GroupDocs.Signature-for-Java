---
id: search-for-encrypted-text-in-metadata-signatures
url: signature/java/search-for-encrypted-text-in-metadata-signatures
title: Search for encrypted text in Metadata signatures
weight: 4
description: " This article explains how to search for encrypted text electronic signatures in the document metadata. This topic contains example of using standard encryption and search for encrypted text in the document metadata with further decryption by GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides ability to search encrypted Metadata signatures with standard or custom encryption. Standard encryption is implemented over class [SymmetricEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption) class. Creation of this object expects 3 arguments like encryption algorithm enumeration [SymmetricAlgorithmType](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricAlgorithmType) with one of following values (DES, TripleDES, RC2, Rijndael), string value key and string value salt.

Here are the steps to search for encrypted Metadata signature with standard encryption with GroupDocs.Signature:
*   *   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.        
    *   Compose object of [SymmetricEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption) class with same parameters as secured QR-code was signed with.          
    *   Create objects of [MetadataSearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/MetadataSearchOptions) class and setup property  [setDataEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature#setDataEncryption(com.groupdocs.signature.domain.extensions.encryption.IDataEncryption)) with object of [SymmetricEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption)
    *   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [MetadataSearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/MetadataSearchOptions)  to it.
    *   Call method [getData](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature#getData(java.lang.Class)) of encrypted [MetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature) object that was found.

## Search for encrypted Metadata signature text

This example shows how to search for secure Metadata signature text.

```java
Signature signature = new Signature("MetadataEncryptedText.docx");
// setup key and passphrase
String key = "1234567890";
String salt = "1234567890";
// create data encryption
IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
 
MetadataSearchOptions options = new MetadataSearchOptions();
options.setDataEncryption(encryption);
 
// search for signatures in document
List<WordProcessingMetadataSignature> signatures = signature.search(WordProcessingMetadataSignature.class,options);
System.out.print("\nSource document contains following signatures.");
 
// get required metadata signatures
WordProcessingMetadataSignature mdAuthor = null;
for (WordProcessingMetadataSignature mdSign : signatures) {
    if (mdSign.getName().equals("Author")) {
        mdAuthor = mdSign;
        break;
    }
}
if (mdAuthor != null)
{
    System.out.print("Metadata signature found. Name : " + mdAuthor.getName() + ". Value: " + mdAuthor.getData(String.class));
}
// get required metadata signatures
WordProcessingMetadataSignature mdDocId = null;
for (WordProcessingMetadataSignature mdSign : signatures) {
    if (mdSign.getName().equals("DocumentId")) {
        mdDocId = mdSign;
        break;
    }
}
if (mdDocId != null)
{
    System.out.print("Metadata signature found. Name : " + mdDocId.getName() + ". Value: " + mdDocId.getData(String.class));
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
