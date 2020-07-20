---
id: sign-document-with-secure-custom-metadata-signatures
url: signature/java/sign-document-with-secure-custom-metadata-signatures
title: Sign document with secure custom Metadata signatures
weight: 12
description: "This section contains articles with explanation how to create Metadata electronic signatures and embed into metadata custom object with its serialization and encryption. The examples show how to customize object serialization and encryption."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides additional features with [MetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature) class like following

*   ability to embedded custom objects into metadata
*   ability to specify custom objects encryption and serialization
*   ability to collect and populate standard document signatures        

Here are the steps to embed custom object into Metadata signature with GroupDocs.Signature:

*   Implement if needed custom data serialization class that implement [IDataSerializer](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.serialization/IDataSerializer) interface. By default GroupDocs.Signature uses embedded json format serialization but allows user to customize it.  
*   Implement if needed custom data encryption class that implements [IDataEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/IDataEncryption) interface. By default GroupDocs.Signature has several encryption implementation you can use but allows user to customize it.
*   Implement class with properties and specify if needed class attributes (like custom serialization attribute, custom encryption attribute), specify attributes for properties like [FormatAttribute](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.serialization/FormatAttribute) to specify serialization name and display format, same as [SkipSerializationAttribute](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.serialization/SkipSerializationAttribute) to mark property of class as not serialize  
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Create one or several objects of proper [MetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/MetadataSignature) object for document (like [PdfMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/PdfMetadataSignature), [ImageMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/ImageMetadataSignature), [PresentationMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/PresentationMetadataSignature), [SpreadsheetMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/SpreadsheetMetadataSignature), [WordProcessingMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/WordProcessingMetadataSignature)) and setup.  
*   Instantiate the [MetadataSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/MetadataSignOptions) object according to your requirements and pass all metadata signatures to it.
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [MetadataSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/MetadataSignOptions) to it.  
   
Following topics show more details of these features


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
