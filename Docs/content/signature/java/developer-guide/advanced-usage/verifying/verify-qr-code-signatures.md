---
id: verify-qr-code-signatures
url: signature/java/verify-qr-code-signatures
title: Verify QR-code signatures
weight: 2
description: " This article explains how to provide advanced verification of QR-code electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides different properties in [QrCodeVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/QrCodeVerifyOptions) class to specify verification of QR-code signatures.

Here are the steps to verify qr-code signature within the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the  [QrCodeVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/QrCodeVerifyOptions)  object according to your requirements and specify verification options      
*   Call [verify](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#verify(com.groupdocs.signature.options.verify.VerifyOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [QrCodeVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/QrCodeVerifyOptions) to it.  
*   Analyze [VerificationResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/VerificationResult) result if needed.

  
This example shows how to verify QR-code signature in the document. See [VerificationResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/VerificationResult)  

```java
Signature signature = new Signature("sample.pdf");
// create QRCode option with predefined QRCode text
QrCodeVerifyOptions options = new QrCodeVerifyOptions();
 
// specify if all pages shoudl be verified
options.setAllPages(false);
PagesSetup pagesSetup = new PagesSetup();
pagesSetup.setFirstPage(false);
pagesSetup.setLastPage(true);
pagesSetup.setOddPages(false);
pagesSetup.setEvenPages(true);
options.setPagesSetup(pagesSetup);
// specify text pattern
options.setText("John");
// specify verification text pattern
options.setMatchType(TextMatchType.Contains);
// specify types of QR code to verify
options.setEncodeType(QrCodeTypes.QR);
 
// sign document to file
VerificationResult result = signature.verify(options);
if (result.isValid()) {
    System.out.print("\nDocument was verified successfully!");
} else {
    System.out.print("\nDocument failed verification process.");
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
