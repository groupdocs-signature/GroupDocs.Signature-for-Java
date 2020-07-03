---
id: sign-documents-with-encrypted-metadata-text
url: signature/java/sign-documents-with-encrypted-metadata-text
title: Sign documents with encrypted metadata text
weight: 3
description: "This article explains how to create encrypted Metadata electronic signature with GroupDocs.Signature API"
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides ability to secure Metadata signatures with standard or custom encryption. Standard encryption is implemented over class [SymmetricEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption) class. Creation of this object expects 3 arguments like encryption algorithm enumeration [SymmetricAlgorithmType](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricAlgorithmType) with one of following values ([DES, TripleDES, RC2, Rijndael](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricAlgorithmType)), string value key and string value salt.

Here are the steps to secure Metadata string values with standard encryption with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Compose object of [SymmetricEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption) class with required algorithm and secure pair key/salt  
*   Create objects of [MetadataSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/MetadataSignOptions) class and setup property [MetadataSignOptions.setDataEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/MetadataSignOptions#setDataEncryption(com.groupdocs.signature.domain.extensions.encryption.IDataEncryption)) with object of [SymmetricEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption). In this case all added Metadata signatures to options collection will be encrypted.  
*   Alternative way to encrypt only selected Metadata signatures is to setup property MetadataSignature[.setDataEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature#setDataEncryption(com.groupdocs.signature.domain.extensions.encryption.IDataEncryption)) to each signature that requires to be secured.
*   Create required collection of [MetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature) object with proper class for document type (like [PdfMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/PdfMetadataSignature), [ImageMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/ImageMetadataSignature),  [PresentationMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/PresentationMetadataSignature), [SpreadsheetMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/SpreadsheetMetadataSignature), [WordProcessingMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/WordProcessingMetadataSignature))  
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of  [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature)  class instance and pass [MetadataSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/MetadataSignOptions) to it.
    

## Implementation of encrypted Metadata signature

This example shows how to sign document with encrypted Metadata signatures over .

```java
Signature signature = new Signature("sample.docx");
 
// setup key and passphrase
String key = "1234567890";
String salt = "1234567890";
// create data encryption
IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
 
// setup options with text of signature
MetadataSignOptions options = new MetadataSignOptions();       
 
// setup signature metadata
WordProcessingMetadataSignature mdAuthor = new WordProcessingMetadataSignature("Author", "Mr.Scherlock Holmes");
 
// setup data of document id
WordProcessingMetadataSignature mdDocId = new WordProcessingMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());
 
// add signatures to options
options.getSignatures().add(mdAuthor);
options.getSignatures().add(mdDocId);
 
// sign document to file
SignResult signResult = signature.sign("MetadataEncryptedText.docx", options);
// analyzing result
System.out.print("List of newly created signatures:");
int number = 1;
for(BaseSignature temp : signResult.getSucceeded())
{
    System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
            ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
}
```

## Implementation of encrypted Metadata signature over MetadataSignOptions encryption

This example shows how to sign document with encrypted Metadata signatures over .

```java
Signature signature = new Signature("sample.docx");
 
// setup key and passphrase
String key = "1234567890";
String salt = "1234567890";
// create data encryption
IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
 
// setup options with text of signature
MetadataSignOptions options = new MetadataSignOptions();
 
// set encryption for all metadata signatures for this options
// if you need separate encryption use own MetadataSignature.DataEncryption property
options.setDataEncryption(encryption);            
 
// setup signature metadata
WordProcessingMetadataSignature mdAuthor = new WordProcessingMetadataSignature("Author", "Mr.Scherlock Holmes");
 
// setup data of document id
WordProcessingMetadataSignature mdDocId = new WordProcessingMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());
 
// add signatures to options
options.getSignatures().add(mdAuthor);
options.getSignatures().add(mdDocId);
 
// sign document to file
SignResult signResult = signature.sign("MetadataEncryptedText.docx", options);
// analyzing result
System.out.print("List of newly created signatures:");
int number = 1;
for(BaseSignature temp : signResult.getSucceeded())
{
    System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
            ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
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
