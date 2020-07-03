---
id: esign-document-with-image-signature
url: signature/java/esign-document-with-image-signature
title: eSign document with Image signature
weight: 4
description: "This article demonstrates how to add Image signature on document page with GroupDocs.Signature."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
## What is a Image Signature?

An **image** as signature is alternative way to put any presenting data in a visual form. This electronic signature type allows to create custom image with company logo, sender' initials, names or make a company stamp icon in it,  
![](signature/java/images/esign-document-with-image-signature.png)

[GroupDocs.Signature](https://products.groupdocs.com/signature/java) provides [ImageSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions) class to specify different settings for Image signature such as image content by file or stream, location, colors and advanced effects.

Here are the steps to create Image signature on document page:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;    
*   Instantiate the [ImageSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions) object according to your requirements and specify Image signature options;    
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature)  class instance and pass [ImageSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions) to it.
    

## How to eSign document with Image signature

This example shows how to sign PDF with Image signature.

```java
Signature signature = new Signature("sample.docx");

ImageSignOptions options = new ImageSignOptions("signature.jpg") ;
// set signature position
options.setLeft(100);
options.setTop(100);
//
options.setPageNumber(1);

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
