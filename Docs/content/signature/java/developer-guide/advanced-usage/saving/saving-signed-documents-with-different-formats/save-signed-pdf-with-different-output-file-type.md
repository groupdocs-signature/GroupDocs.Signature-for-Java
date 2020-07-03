---
id: save-signed-pdf-with-different-output-file-type
url: signature/java/save-signed-pdf-with-different-output-file-type
title: Save signed Pdf with different output file type
weight: 2
description: "This article explains how to save signed PDF document with various file formats by GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class supports saving of Pdf signed documents to different formats. Each of document type has list of compatible saving type. These values are listed in enum [PdfSaveFileFormat](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/PdfSaveFileFormat).

Here are the steps to save signed Pdf document to different output type with [**GroupDocs.Signature**](https://products.groupdocs.com/signature/java):
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature)  class and pass source document path or stream as a constructor parameter.    
*   Instantiate required signature options.    
*   Instantiate the [PdfSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/PdfSaveOptions) object according to your requirements and specify [setFileFormat](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/PdfSaveOptions#setFileFormat(int)) as one of predefined values from [PdfSaveFileFormat](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/PdfSaveFileFormat).      
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass signatureoptions and [PdfSaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/PdfSaveOptions) object to it.
    

```java
Signature signature = new Signature("sample.pdf");
// create QRCode option with predefined QRCode text
QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
signOptions.setEncodeType(QrCodeTypes.QR);
signOptions.setLeft(100);
signOptions.setTop(100);
 
PdfSaveOptions saveOptions = new PdfSaveOptions();
saveOptions.setFileFormat(PdfSaveFileFormat.DocX);
saveOptions.setOverwriteExistingFiles(true);
// sign document to file
signature.sign("SignedPdf.docx", signOptions, saveOptions);
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
