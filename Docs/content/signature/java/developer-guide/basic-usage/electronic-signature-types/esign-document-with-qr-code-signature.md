---
id: esign-document-with-qr-code-signature
url: signature/java/esign-document-with-qr-code-signature
title: eSign document with QR-code signature
weight: 6
description: "This article explains how sign documents with electronic signature as QR-code on document page with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
## What is a QR-code?

QR-code (or Quick Response code) is a sort of two-dimensional [barcode]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-barcode-signature.md" >}}) that consists of black squares arranged in a square grid on a white background. QR-code can be read by smartphone camera or specialized devices that are dedicated to QR reading - hand-held scanners, handy terminals, fixed scanners that are used after placing it on a desktop, or embedding it in other devices. Usually QR-codes contain data that points to a website or application, emails, or phone numbers, product identifiers, or trackers. Therefore QR-code application scope extends general marketing and item identification to document management.

![](signature/java/images/esign-document-with-qr-code-signature.png)

## How to eSign document with QR-Code signature 

[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) allows to eSign documents with QR-codes of various types that is listed in a table below. 

|   | Aztec code | DataMatrix code | GS1 DataMatrix  | GS1 QR code  | QR |
| --- | --- | --- | --- | --- | --- |
| **Application** | transport and ticketing;  in airline industry for electronic boarding passes;  in rail for tickets sold online and printed out by customers or displayed on mobile phone screens. Code is scanned by a handheld scanner by on-train staff or at the turnstile to validate the ticket.  medicine - patient identification wristbands and labels for unit-of-use medications etc. | printed media such as labels and letters;  industrial engineering purposes - marking components etc;  food industry - to prevent food products being packaged and dated incorrectly; | Used in Healthcare;  Government;  Industrial. Encodes item additional information, such as: weight; expiration date; batch number; date of manufacture; etc. | Used in marketing to encode additional item information  on the package | Widely used in automotive industry and mobile applications. Useful for encoding  large amount of data characters and specific URLs. |
| **Length** | 3067 alphanumeric,  3832 numeric,  1914 bytes | 2335 alphanumeric, 3116 numeric | 2335 alphanumeric 3116 numeric,  1556 bytes | 7089 alphanumeric 4296 numeric,  2953 bytes | 4296 alphanumeric,  
7089 numeric,  2953 bytes |
| **Example** | ![](signature/java/images/Aztec.png) | ![](signature/java/images/DataMatrix.png) | ![](signature/java/images/GS1.png) | ![](signature/java/images/GS1_QR.png) | ![](signature/java/images/QrCode2.png)


While adding QR-code electronic signature to document [GroupDocs.Signature](https://products.groupdocs.com/signature/java) the main settings are text to be encoded and QR-code [type](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.qrcodes/QrCodeType#getTypeIndex()) which should be specified via [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions) class. 

Here are the steps to eSign document with QR-code signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.
*   Instantiate the [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions) object according to your requirements and specify [EncodeType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions#setEncodeType(com.groupdocs.signature.domain.qrcodes.QrCodeType)) and [Text](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions#setText(java.lang.String)) properties.
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions) to it.
    

The code snippet below demonstrates how to sign PDF document with QR-code signature.

```java
Signature signature = new Signature("sample.pdf");
 
// create QRCode option with predefined QRCode text
QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
 
// setup QRCode encoding type
options.setEncodeType(QrCodeTypes.QR);
 
// set signature position
options.setLeft(100);
options.setTop(100);
 
 
// sign document to file
signature.sign("SampleSigned.pdf", options);
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
