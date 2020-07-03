---
id: sign-documents-with-exception-handling
url: signature/java/sign-documents-with-exception-handling
title: Sign documents with exception handling
weight: 2
description: " This article explains how to use exceptions handling when adding electronic signatures to document with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides different error messages due to validation issues, missing required data, files etc. For exception class [GroupDocsSignatureException](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.exception/GroupDocsSignatureException) is being used.

Here are the steps to handle exceptions from GroupDocs.Signature:
*   Compose try-catch block above [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method with catching [GroupDocsSignatureException](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.exception/GroupDocsSignatureException) type error.
    

This example shows how to handle GroupDocs.Signature exceptions.

```java
try
{
    Signature signature = new Signature("sample.xlsx");
     
    DigitalSignOptions options = new DigitalSignOptions();
    options.setCertificateGuid("certificate.pfx");
    options.setImageFilePath("image.png");
    // skip password specification
    //options.setPassword("123456780");
         
    // sign document to file
    signature.sign("signed.xlsx", options);
 
}
catch (GroupDocsSignatureException ex)
{
    System.out.println("GroupDocs Signature Exception: " + ex.getMessage());
}
catch (Exception ex)
{
    System.out.println("System Exception: " + ex.getMessage());
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
