---
id: sign-documents-with-encrypted-qr-code-text
url: signature/java/sign-documents-with-encrypted-qr-code-text
title: Sign documents with encrypted QR-code text
weight: 3
description: "This article explains how to create encrypted QR-code electronic signature with GroupDocs.Signature API"
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
GroupDocs.Signature provides ability to secure QR-code signature text with standard or custom encryption. Standard encryption is implemented over class [SymmetricEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption) class. Creation of this object expects 3 arguments like encryption algorithm enumeration [SymmetricAlgorithmType](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricAlgorithmType) with one of following values ([DES, TripleDES, RC2, Rijndael](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricAlgorithmType)), string value key and string value salt.

Here are the steps to secure QR-code text with standard encryption with GroupDocs.Signature:
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature)  class and pass source document path or stream as a constructor parameter.    
*   Compose object of [SymmetricEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption) class with required algorithm and secure pair key/salt      
*   Create objects of [QrCodeSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/QrCodeSignOptions) class and setup property [setDataEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/QrCodeSignOptions#setDataEncryption(com.groupdocs.signature.domain.extensions.encryption.IDataEncryption)) with object of [SymmetricEncryption](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption)       
*   Call [Sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions) to it.
    

This example shows how to sign document with secure QR-code signature text.

```java
Signature signature = new Signature("sample.pdf");
// setup key and passphrase
String key = "1234567890";
String salt = "1234567890";
// create data encryption
IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
 
// setup QR-Code options
QrCodeSignOptions options = new QrCodeSignOptions();
// set custom object to serialize to QR Code
options.setText("This is private text to be secured.");
// QR-code type
options.setEncodeType(QrCodeTypes.QR);
// specify serialization encryption
options.setDataEncryption(encryption);
// locate and aligh signature
options.setHeight(100);
options.setWidth(100);
options.setVerticalAlignment(VerticalAlignment.Bottom);
options.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding() ;
padding.setRight(10);
padding.setBottom(10);
options.setMargin(padding);
 
// sign document to file
SignResult signResult = signature.sign("QRCodeEncryptedText.pdf", options);
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
