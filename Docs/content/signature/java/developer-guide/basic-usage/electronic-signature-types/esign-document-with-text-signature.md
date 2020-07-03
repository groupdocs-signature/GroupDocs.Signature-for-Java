---
id: esign-document-with-text-signature
url: signature/java/esign-document-with-text-signature
title: eSign document with Text signature
weight: 7
description: "This article explains how to sign document with Text signature by GroupDocs.Signature API"
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
## What is a Text signature?

A **Text** electronic signature is an arbitrary text that is added to a document in a native way dependent on document type. GroupDocs.Signature provides text signature feature and allows to customize wide range of text settings - from font name, size and color to alignment, borders, shadow effects etc. This is how text signature may look like:  

![](signature/java/images/esign-document-with-text-signature.png)

## How to eSign document with Text signature 

  

o manipulate with text signatures programmatically [GroupDocs.Signature](https://products.groupdocs.com/signature/java) provides [TextSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions) class and the whole workflow as easy as follows:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [TextSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions) object according to your requirements and specify Text signature options.    
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [TextSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions) to it.
    

This example shows how to add Text signature to document.

```java
Signature signature = new Signature("sample.pdf");

TextSignOptions options = new TextSignOptions("John Smith");
// set signature position
options.setLeft(100);
options.setTop(100);

// set signature rectangle
options.setWidth(100);
options.setHeight(30);

// set text color and Font
options.setForeColor(Color.RED);
SignatureFont signatureFont = new SignatureFont();
signatureFont.setSize(12);
signatureFont.setFamilyName("Comic Sans MS");
options.setFont(signatureFont);

// sign document to file
signature.sign("sample_signed.pdf", options);
```

More resources

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
