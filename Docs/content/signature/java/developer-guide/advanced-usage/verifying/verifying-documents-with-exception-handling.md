---
id: verifying-documents-with-exception-handling
url: signature/java/verifying-documents-with-exception-handling
title: Verifying documents with exception handling
weight: 1
description: " This article explains how to handle exceptions when verifying document electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides different error messages due to validation issues, missing required data, files etc. For handling these exceptions class [GroupDocsSignatureException](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.exception/GroupDocsSignatureException) should be used.

Here are the steps to handle exceptions from GroupDocs.Signature while document verification:

*   Compose try-catch block above [verify](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#verify(com.groupdocs.signature.options.verify.VerifyOptions)) method with catching [GroupDocsSignatureException](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.exception/GroupDocsSignatureException) type error.
    

This example shows how to handle GroupDocs.Signature exceptions.

```java
try {
    Signature signature = new Signature(filePath);
    // create QRCode option with predefined QRCode text
    DigitalVerifyOptions options = new DigitalVerifyOptions();
    options.setCertificateFilePath(Constants.CertificatePfx);
    // skip password specification
    //options.setPassword("1234567890");
 
    // sign document to file
    VerificationResult result = signature.verify(options);
}catch(GroupDocsSignatureException ex){
    System.out.print("GroupDocs Signature Exception: " + ex.getMessage());
}
catch (Exception ex)
{
    System.out.print("System Exception: " + ex.getMessage());
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
