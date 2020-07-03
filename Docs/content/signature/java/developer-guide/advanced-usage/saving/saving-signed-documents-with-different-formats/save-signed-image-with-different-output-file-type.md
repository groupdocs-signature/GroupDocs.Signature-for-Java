---
id: save-signed-image-with-different-output-file-type
url: signature/java/save-signed-image-with-different-output-file-type
title: Save signed Image with different output file type
weight: 1
description: "This article explains how to save signed image with various image formats by GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class supports saving of Image signed documents with different formats. Each of document type has list of compatible saving type. These values are listed in enum [ImageSaveFileFormat](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/ImagesSaveFileFormat).

Here are the steps to save signed Image document to different output type with [**GroupDocs.Signature**](https://products.groupdocs.com/signature/java):

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Instantiate required signature options.
*   Instantiate the [ImageSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/ImagesSaveOptions) object according to your requirements and specify [FileFormat](https://apireference.groupdocs.com/net/signature/groupdocs.signature.options/imagesaveoptions/properties/fileformat) as one of predefined values from [ImageSaveFileFormat](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/ImagesSaveFileFormat).  
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass signatureoptions and object [ImageSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions.imagessaveoptions/ImagesSaveOptions) to it.
    

Following example demonstrates how to save signed Image document with different output type

```java
Signature signature = new Signature("sample.jpg");
// create QRCode option with predefined QRCode text
QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
signOptions.setEncodeType(QrCodeTypes.QR);
signOptions.setLeft(100);
signOptions.setTop(100);
 
ImagesSaveOptions saveOptions = new ImagesSaveOptions();
saveOptions.setFileFormat(ImagesSaveFileFormat.Svg);
saveOptions.setOverwriteExistingFiles(true);
// sign document to file
signature.sign("signed.svg", signOptions, saveOptions);
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
