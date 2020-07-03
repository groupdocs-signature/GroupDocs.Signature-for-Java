---
id: sign-document-with-image-signature-advanced
url: signature/java/sign-document-with-image-signature-advanced
title: Sign document with Image signature - advanced
weight: 9
description: " This article explains how to sign document with Image electronic signatures using extended options with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [ImageSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions) class to specify different options for Image signature as follow

*   signature alignment ([setHorizontalAlignment](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setHorizontalAlignment(int)), [setVerticalAlignment](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setVerticalAlignment(int)))
*   margins ([setMargin](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setMargin(com.groupdocs.signature.domain.Padding)))
*   additional extensions and appearances ([setExtensions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions#setExtensions(java.util.List)), [setAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions#setAppearance(com.groupdocs.signature.options.appearances.SignatureAppearance)))

Here are the steps to add Image signature into document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [ImageSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions) object according to your requirements and specify image signature options.    
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [ImageSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions) to it.      
*   Analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.

  

This example shows how to specify different Image signature options. See [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) 

```java
Signature signature = new Signature(sample.xlsx);
 
ImageSignOptions options = new ImageSignOptions("sample.jpg");
 
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
padding.setRight(20);
padding.setTop(20);
options.setMargin(padding);
 
// set rotation
options.setRotationAngle(45);
 
// setup image additional appearance as Brightness and Border
ImageAppearance imageAppearance = new ImageAppearance();
Border border = new Border();
border.setColor(Color.GREEN);
border.setDashStyle(DashStyle.DashLongDashDot);
border.setWeight(2);
border.setTransparency(0.5);
border.setVisible(true);
imageAppearance.setBorder(border);
imageAppearance.setBrightness(0.9f);
options.setAppearance(imageAppearance);
 
// sign document to file
SignResult signResult = signature.sign("sgnedSample.xlsx", options);
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

GitHub Examples 

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
