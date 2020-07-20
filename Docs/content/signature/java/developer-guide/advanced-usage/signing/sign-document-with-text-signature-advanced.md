---
id: sign-document-with-text-signature-advanced
url: signature/java/sign-document-with-text-signature-advanced
title: Sign document with Text signature - advanced
weight: 14
description: " This article explains how to sign document with Text electronic signatures using advanced options with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [TextSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions) class to specify additional options for text signature to specify following signature appearance

*   signature alignment ([setHorizontalAlignment](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setHorizontalAlignment(int)), [setVerticalAlignment](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setVerticalAlignment(int)))
*   margins ([setMargin](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setMargin(com.groupdocs.signature.domain.Padding)))
*   border and background settings ([setBorder,](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setBorder(com.groupdocs.signature.domain.Border))[setBackground](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setBackground(com.groupdocs.signature.domain.Background)))
*   font and colors ([setFont](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setFont(com.groupdocs.signature.domain.SignatureFont)), [setForeColor](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setForeColor(java.awt.Color)))
*   text signature implementation ([stamp, text as image, watermark, annotation, shaped](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setSignatureImplementation(int)) etc)

Here are the steps to add Text signature into document with GroupDocs.Signature:

*   *   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.        
    *   Instantiate the [TextSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions) object with all required additional options.        
    *   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [TextSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions) to it. 
    *   Analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.

This example shows how to add Text signature to document with advanced setup and analyzing result of method. See [SignResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/SignResult)

```java
Signature signature = new Signature("sample.pdf");
 
TextSignOptions options = new TextSignOptions("John Smith");
 
// set signature position
options.setLeft(100);
options.setTop(100);
 
// set signature rectangle
options.setWidth(100);
options.setHeight(30);
 
// set signature alignment
 
// when VerticalAlignment is set the Top coordinate will be ignored.
// Use Margin properties Top, Bottom to provide vertical offset
options.setVerticalAlignment(VerticalAlignment.Top);
 
// when HorizontalAlignment is set the Left coordinate will be ignored.
// Use Margin properties Left, Right to provide horizontal offset
options.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setBottom(20);
padding.setRight(20);
options.setMargin(padding);
 
// adjust signature appearance
 
// setup signature border
Border border = new Border();
border.setColor(Color.GREEN);
border.setDashStyle(DashStyle.DashLongDashDot);
border.setTransparency(0.5);
border.setVisible(true);
border.setWeight(2);
options.setBorder(border);
 
// set text color and Font
options.setForeColor(Color.RED);
SignatureFont signatureFont = new SignatureFont();
signatureFont.setSize(12);
signatureFont.setFamilyName("Comic Sans MS");
options.setFont(signatureFont);
 
// setup background
Background background = new Background();
background.setColor(Color.LIGHT_GRAY);
background.setTransparency(0.5);
background.setBrush(new LinearGradientBrush(Color.GREEN, Color.DARK_GRAY, 0));
options.setBackground(background);
 
// set rotation
options.setRotationAngle(45);
 
// set alternative signature implementation on document page
options.setSignatureImplementation(TextSignatureImplementation.Image);
 
 
 
// set up shadow options for text
TextShadow shadow = new TextShadow();
shadow.setColor(Color.ORANGE);
shadow.setAngle(135);
shadow.setBlur(5);
shadow.setDistance(4);
shadow.setTransparency(0.2);
 
//add text shadow to signature extensions
options.getExtensions().add(shadow);
 
// sign document to file
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
