---
id: sign-document-with-qr-code-signature-advanced
url: signature/java/sign-document-with-qr-code-signature-advanced
title: Sign document with QR-code signature - advanced
weight: 11
description: " This article explains how to sign document with QR-code electronic signatures using extended options with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions) class to specify additional options for QR-code signature with following signature appearance

*   signature alignment
*   margins
*   border and background settings
*   font and colors

Here are the steps to add QR-code signature into document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.
*   Instantiate the [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions) object with all required additional options.
*   Call [sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20java.util.List)) method of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class instance and pass [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions) to it.
*   Analyze [SignResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.
    

This example shows how to add QR-Code signature to document.

```java
 Signature signature = new Signature("sample.xlsx");
// create QRCode option with predefined QRCode text
QrCodeSignOptions signOptions = new QrCodeSignOptions("12345678");
 
// setup QRCode encoding type
signOptions.setEncodeType(QrCodeTypes.QR);
// set signature position
signOptions.setLeft(100);
signOptions.setTop(100);
 
// set signature alignment
 
// when VerticalAlignment is set the Top coordinate will be ignored.
// Use Margin properties Top, Bottom to provide vertical offset
signOptions.setVerticalAlignment(VerticalAlignment.Top);
 
// when HorizontalAlignment is set the Left coordinate will be ignored.
// Use Margin properties Left, Right to provide horizontal offset
signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setRight(20);
padding.setTop(20);
signOptions.setMargin(padding);
 
// adjust signature appearance
 
// setup signature border
Border border = new Border();
border.setColor(Color.GREEN);
border.setDashStyle(DashStyle.DashLongDashDot);
border.setWeight(2);
border.setTransparency(0.5);
border.setVisible(true);
signOptions.setBorder(border);
 
// set text color and Font
signOptions.setForeColor(Color.RED);
SignatureFont font = new SignatureFont();
font.setSize(12);
font.setFamilyName("Comic Sans MS");
signOptions.setFont(font);
 
// setup background
Background background = new Background();
background.setColor(Color.GREEN);
background.setTransparency(0.5);
background.setBrush(new LinearGradientBrush(Color.GREEN, Color.DARK_GRAY, 0));
signOptions.setBackground(background);
 
// sign document to file
SignResult signResult = signature.sign("sampleSigned.xlsx", signOptions);
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
You are welcome to eSign PDF, Word, Excel, PowerPoint documents with free to use online **[GroupDocs Signature App](https://products.groupdocs.app/signature)**. E
