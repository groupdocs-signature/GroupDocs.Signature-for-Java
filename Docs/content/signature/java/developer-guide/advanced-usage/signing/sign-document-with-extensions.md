---
id: sign-document-with-extensions
url: signature/java/sign-document-with-extensions
title: Sign document with extensions
weight: 7
description: "This article shows how to create electronic signatures with additional visual extensions"
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides with [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) property Extensions that expects list of different extensions classes. At this moment here are few of them

*   [SpreadsheetPosition](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions/SpreadsheetPosition) that allows to specify for Spreadsheet documents signature position as Row and Column numbers
*   [TextShadow](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.extensions/TextShadow) alternative extension for Text signature property

Here are the steps to add extensions to signature into document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) object with all required additional options.    
*   Create instance of required Extension and call [SignOptions.getExtensions().add](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions#getExtensions()) method with passed object      
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of  [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) to it.
    

## Sign document with Text signature

This example shows how to add Text signature to document.

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
