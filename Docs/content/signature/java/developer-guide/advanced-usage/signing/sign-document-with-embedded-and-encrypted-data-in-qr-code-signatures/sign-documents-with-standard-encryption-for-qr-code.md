---
id: sign-documents-with-standard-encryption-for-qr-code
url: signature/java/sign-documents-with-standard-encryption-for-qr-code
title: Sign documents with standard encryption for QR-code
weight: 5
description: "This article explains how to create encrypted QR-code electronic signature"
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java ) provides ability to encrypt QR-code signature with symmetric algorithms. Class [SymmetricEncryption](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.encryption/SymmetricEncryption ) implements one of the following values algorithms ([DES, TripleDES, RC2, Rijndael](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.encryption/SymmetricAlgorithmType )), string value key and string value salt.

Here are the steps to encrypt QR-code text with embedded encryption by GroupDocs.Signature:

* Create one or several objects of [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions ) object with [getData](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions#getData() ) or Text property
* Instantiate the  [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions ) object according to your requirements and custom object to [getData](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions#getData() ) property.
* Call [Sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20java.util.List)) method of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature ) class instance and pass [QrCodeSignOptions](https://apireference.groupdocs.com/https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions ) to it.  

## How to encrypt QR-code signature

 This example shows how to encrypt QR-code signature.

```java
Signature signature = new Signature("sample.pdf"))

// setup key and passphrase
String key = "1234567890";
String salt = "1234567890";
// create data encryption
IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
// setup QR-Code options
QrCodeSignOptions options = new QrCodeSignOptions();
options.setEncodeType(QrCodeTypes.QR);
	// setup Data property to Address instance
options.setData(address);
	// set right bottom corner
options.setHorizontalAlignment(HorizontalAlignment.Right);
options.setVerticalAlignment(VerticalAlignment.Bottom);
options.setMargin(new Padding(10));
options.setWidth(100);
options.setHeight(100);
// sign document to file
signature.sign("QrCodeEncrypted.pdf", options);

```

## More resources

### GitHub Examples

You may easily run the code above and see the feature in action in our GitHub examples:

* [GroupDocs.Signature for .NET examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET)
* [GroupDocs.Signature for Java examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java)
* [Document Signature for .NET MVC UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-MVC)
* [Document Signature for .NET App WebForms UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-WebForms)
* [Document Signature for Java App Dropwizard UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Dropwizard)
* [Document Signature for Java Spring UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Spring)

### Free Online App

Along with full-featured .NET library we provide simple, but powerful free Apps.

You are welcome to eSign PDF, Word, Excel, PowerPoint documents with free to use online **[GroupDocs Signature App](https://products.groupdocs.app/signature)**.
