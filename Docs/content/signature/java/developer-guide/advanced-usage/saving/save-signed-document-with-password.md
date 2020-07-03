---
id: save-signed-document-with-password
url: signature/java/save-signed-document-with-password
title: Save signed document with password
weight: 1
description: "This article explains how to save document with password protection."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature)  class supports saving signed document with password protection. This ability is supported over [setPassword](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/SaveOptions#setPassword(java.lang.String)) property of [SaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/SaveOptions) class that should be passed to [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method.

Here are the steps to protect signed document with password with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Instantiate required signature options.    
*   Instantiate the [SaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/SaveOptions) object and specify [setPassword](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/SaveOptions#setPassword(java.lang.String)) property with required password string.      
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass signatureoptions and [SaveOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.saveoptions/SaveOptions) object to it.
    
Following example demonstrates how to save signed document with password.

```java
Signature signature = new Signature("sample.pdf");
// create QRCode option with predefined QRCode text
QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
signOptions.setEncodeType(QrCodeTypes.QR);
signOptions.setLeft(100);
signOptions.setTop(100);
 
SaveOptions saveOptions = new SaveOptions();
saveOptions.setPassword("1234567890");
saveOptions.setUseOriginalPassword(false);
 
// sign document to file
signature.sign("SignedProtected.pdf", signOptions, saveOptions);
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
