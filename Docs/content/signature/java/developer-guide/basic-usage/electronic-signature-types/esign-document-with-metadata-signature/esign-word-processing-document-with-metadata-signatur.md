---
id: esign-word-processing-document-with-metadata-signatur
url: signature/java/esign-word-processing-document-with-metadata-signatur
title: eSign Word Processing document with Metadata signatur
weight: 5
description: "This article explains how to sign Word Processing document with metadata signatures by GroupDocs.Signature."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[GroupDocs.Signature](https://products.groupdocs.com/signature/java) provides [WordProcessingMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/WordProcessingMetadataSignature) class to specify different Metadata signature objects for [MetadataSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/MetadataSignOptions) instance to sign Word Processing document files.   
Word Processing document metadata is hidden attributes, some of them are visible only over viewing standard document properties like Author, Creation Date, Producer, Entry, Keywords etc.  
Word Processing document metadata contains pair of Name and Value, Name should be unique within the document.  
Word Processing document metadata could keep big amount of data that allows provides ability to keep serialized custom objects with additional encryption in there.

Here are the steps to add metadata signatures into Word Processing document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [MetadataSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/MetadataSignOptions) object according to your requirements.    
*   Instantiate one or several[WordProcessingMetadataSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/WordProcessingMetadataSignature) objects and add them into [MetadataSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/MetadataSignOptions) to metadata signatures collection ([getSignatures](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/MetadataSignOptions#getSignatures())) via [add](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.metadata/MetadataSignatureCollection#add(com.groupdocs.signature.domain.signatures.metadata.MetadataSignature)) or addRange method.    
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [MetadataSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/MetadataSignOptions) to it. 
    

## How to eSign Word Processing document with Metadata signature

This example shows how to sign Word Processing document with Metadata e-signature.

```java
Signature signature = new Signature("sample.docx");
// setup options with text of signature
MetadataSignOptions options = new MetadataSignOptions();

// Create few WordProcessing Metadata signatures
WordProcessingMetadataSignature[] signatures = new WordProcessingMetadataSignature[]
        {
                new WordProcessingMetadataSignature("Author", "Mr.Scherlock Holmes"),
                new WordProcessingMetadataSignature("DateCreated", new Date()),
                new WordProcessingMetadataSignature("DocumentId", 123456),
                new WordProcessingMetadataSignature("SignatureId", 123.456)
        };
options.getSignatures().addRange(signatures);

// sign document to file
signature.sign("SampleSigned.docx", options);
```

## More resources

### Advanced Usage Topics

To learn more about document eSign features, please refer to the [advanced usage section]({{< ref "signature/java/developer-guide/advanced-usage/_index.md" >}}).

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
