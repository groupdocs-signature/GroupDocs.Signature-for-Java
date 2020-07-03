---
id: sign-document-with-digital-signature-advanced
url: signature/java/sign-document-with-digital-signature-advanced
title: Sign document with Digital signature - advanced
weight: 5
description: " This article explains how to sign document with Digital electronic signatures using advanced options with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [DigitalSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/DigitalSignOptions) class to specify different amount of settings for Digital signature

*   digital certificate (file on local disk [setCertificateFilePath](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/DigitalSignOptions#setCertificateFilePath(java.lang.String)) or stream [setCertificateStream](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/DigitalSignOptions#setCertificateStream(java.io.InputStream))) (required)
*   password of digital certificate [setPassword](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/DigitalSignOptions#setPassword(java.lang.String)) (required) 
*   digital signature details ([setReason](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/DigitalSignOptions#setReason(java.lang.String)), [setContact](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/DigitalSignOptions#setContact(java.lang.String)), [setLocation](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/DigitalSignOptions#setLocation(java.lang.String)))
*   signature image as digital signature appearance on document page ([setImageFilePath](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setImageFilePath(java.lang.String)) or [setImageStream](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setImageStream(java.io.InputStream)))
*   image signature appearance on document page ([setHorizontalAlignment](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setHorizontalAlignment(int)), [setMargin](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setMargin(com.groupdocs.signature.domain.Padding)) etc.)

Here are the steps to add Digital signature into document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [DigitalSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/DigitalSignOptions) object with required certificate and its password.    
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of  [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [DigitalSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/DigitalSignOptions) to it.    
*   Analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.
    
This example shows how to sign PDF with Digital signature certificate and analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult)

```java
Signature signature = new Signature("sample.pdf"); 
DigitalSignOptions options = new DigitalSignOptions("certificate.pfx");
 
// certifiate password
options.setPassword("1234567890");
// digital certificate details
options.setReason("Sign");
options.setContact("JohnSmith");
options.setLocation("Office1");
 
// image as digital certificate appearance on document pages
options.setImageFilePath("sample.jpg");
//
options.setAllPages(true);
options.setWidth(80);
options.setHeight(60);
options.setVerticalAlignment(VerticalAlignment.Bottom);
options.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setBottom(10);
padding.setRight(10);
options.setMargin(padding);
 
SignResult signResult = signature.sign("signed.pdf", options);
// analyzing result
System.out.print("List of newly created signatures:");
int number = 1;
for(BaseSignature temp : signResult.getSucceeded())
{
    System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
            ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
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
