---
id: sign-document-with-stamp-signature-advanced
url: signature/java/sign-document-with-stamp-signature-advanced
title: Sign document with Stamp signature - advanced
weight: 13
description: " This article explains how to sign document with generated Stamp electronic signatures using advanced options with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [StampSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/StampSignOptions) class with additional properties to specify different options for Stamp Signature. This signature type implements stamps with different implementation, forms, lines etc. Each Stamp option contains inner and outer lines. Inner lines represent vertical lines inside the stamp, when outer lines represent circles (or rectangles based on stamp type) around stamp with own text, border settings, background etc

Here are the steps to add Stamp signature into document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [StampSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/StampSignOptions) object according to your requirements and specify Text Signature options.    
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [StampSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/StampSignOptions) to it.    
*   Analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.
    

This example shows how to add Stamp signature to document.

```java
Signature signature = new Signature("sample.pdf");
// setup options with text of signature
StampSignOptions signOptions = new StampSignOptions();
 
signOptions.setHeight(300);
signOptions.setWidth(300);
 
signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setRight(10);
padding.setBottom(10);
signOptions.setMargin(padding);
Background background = new Background();
background.setColor( Color.ORANGE);
signOptions.setBackground(background);
signOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea);
signOptions.setImageFilePath(Constants.ImageStamp);
signOptions.setBackgroundImageCropType(StampBackgroundCropType.InnerArea);
signOptions.setAllPages(true);
 
 
//add few outer round lines
StampLine outerLine1 = new StampLine();
outerLine1.setText("* European Union *");
outerLine1.setTextRepeatType(StampTextRepeatType.FullTextRepeat);
SignatureFont signatureFont1 = new SignatureFont();
signatureFont1.setSize(12);
signatureFont1.setFamilyName("Arial");
outerLine1.setFont(signatureFont1);
outerLine1.setHeight(30);
outerLine1.setTextBottomIntent(6);
outerLine1.setTextColor(Color.WHITE);
outerLine1.setBackgroundColor(Color.BLUE);
signOptions.getOuterLines().add(outerLine1);
 
StampLine outerLine2 = new StampLine();
outerLine2.setHeight(2);
outerLine2.setBackgroundColor(Color.WHITE);
signOptions.getOuterLines().add(outerLine2);
 
StampLine outerLine3 = new StampLine();
outerLine3.setText("* Entrepreneur *");
outerLine3.setTextColor(Color.BLUE);
outerLine3.setTextRepeatType(StampTextRepeatType.FullTextRepeat);
SignatureFont signatureFont3 = new SignatureFont();
signatureFont3.setSize(15);
outerLine3.setFont(signatureFont3);
outerLine3.setHeight(30);
outerLine3.setTextBottomIntent(8);
Border innerBorder3 = new Border();
innerBorder3.setColor(Color.DARK_GRAY);
innerBorder3.setDashStyle(DashStyle.Dot);
outerLine3.setInnerBorder(innerBorder3);
Border outerBorder3 = new Border();
outerBorder3.setColor(Color.BLUE);
outerLine3.setOuterBorder(outerBorder3);
signOptions.getOuterLines().add(outerLine3);
 
 
//Inner square lines
StampLine innerLine1 = new StampLine();
innerLine1.setText("John");
innerLine1.setTextColor(Color.RED);
SignatureFont signFont1 = new SignatureFont();
signFont1.setSize(20);
signFont1.setBold(true);
innerLine1.setFont(signFont1);
innerLine1.setHeight(40);
signOptions.getInnerLines().add(innerLine1);
 
StampLine innerLine2 = new StampLine();
innerLine2.setText("Smith");
innerLine2.setTextColor(Color.RED);
SignatureFont signFont2 = new SignatureFont();
signFont2.setSize(20);
signFont2.setBold(true);
innerLine2.setFont(signFont2);
innerLine2.setHeight(40);
signOptions.getInnerLines().add(innerLine2);
 
StampLine innerLine3 = new StampLine();
innerLine3.setText("SSN 1230242424");
innerLine3.setTextColor(Color.MAGENTA);
SignatureFont signFont3 = new SignatureFont();
signFont3.setSize(12);
signFont3.setBold(true);
innerLine3.setFont(signFont3);
innerLine3.setHeight(40);
signOptions.getInnerLines().add(innerLine3);
 
// sign document
SignResult signResult = signature.sign("signed.pdf", signOptions);
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
