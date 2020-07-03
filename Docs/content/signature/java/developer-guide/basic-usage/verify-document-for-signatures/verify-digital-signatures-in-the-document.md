---
id: verify-digital-signatures-in-the-document
url: signature/java/verify-digital-signatures-in-the-document
title: Verify Digital signatures in the document
weight: 2
description: "This topic explains how to verify digital electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
**[GroupDocs.Signature](https://products.groupdocs.com/signature/java)** provides [DigitalVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/DigitalVerifyOptions) class to specify different options for digital signatures verification.

Here are the steps to verify Digital signature within the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.
    
*   Instantiate the [DigitalVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/DigitalVerifyOptions) object according to your requirements and specify verification options  
    
*   Call [verify](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#verify(com.groupdocs.signature.options.verify.VerifyOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [DigitalVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/DigitalVerifyOptions) to it.
    

  
  

This example shows how to verify Digital signature in the document.

```java
Signature signature = new Signature("sample.pdf");
DigitalVerifyOptions options = new DigitalVerifyOptions(Constants.CertificatePfx);
options.setComments("Test comment");
options.setPassword("1234567890");

// verify document signatures
VerificationResult result = signature.verify(options);
if (result.isValid())
{
    System.out.print("\nDocument was verified successfully!");
}
else
{
    System.out.print("\nDocument failed verification process.");
}
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
