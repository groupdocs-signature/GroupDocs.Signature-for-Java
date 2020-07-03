---
id: sign-document-with-barcode-signature-advanced
url: signature/java/sign-document-with-barcode-signature-advanced
title: Sign document with Barcode signature - advanced
weight: 3
description: " This article explains how to sign document with Barcode electronic signatures using extended options with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [BarcodeSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/BarcodeSignOptions) class to specify additional options for Barcode signature to specify following signature appearance

*   signature alignment ([setHorizontalAlignment](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setHorizontalAlignment(int)), [setVerticalAlignment](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setVerticalAlignment(int)))
*   margins ([setMargin](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setMargin(com.groupdocs.signature.domain.Padding)))
*   border and background settings ([setBorder,](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setBorder(com.groupdocs.signature.domain.Border)) [setBackground](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setBackground(com.groupdocs.signature.domain.Background)))
*   font and colors ([setFont](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setFont(com.groupdocs.signature.domain.SignatureFont)), [setForeColor](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setForeColor(java.awt.Color)))

Here are the steps to add Barcode signature into document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the  [BarcodeSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/BarcodeSignOptions) object with all required additional options.    
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [BarcodeSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/BarcodeSignOptions) to it. 
*   Analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.

  

This example shows how to add Barcode signature to document. See [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) 

```java
// instantiating the signature object
final Signature signature = new Signature("sample.docx");
try
{
    // setup options with text of signature
    BarcodeSignOptions signOptions = new BarcodeSignOptions("12345678");
    // setup Barcode encoding type
    signOptions.setEncodeType(BarcodeTypes.Code128);
    // set signature position
    signOptions.setLeft(100);
    signOptions.setTop(100);
    // when VerticalAlignment is set the Top coordinate will be ignored.
    // Use Margin properties Top, Bottom to provide vertical offset
    signOptions.setVerticalAlignment(VerticalAlignment.Top);
            // when HorizontalAlignment is set the Left coordinate will be ignored.
            // Use Margin properties Left, Right to provide horizontal offset
    signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
    Padding padding = new Padding();
    padding.setLeft(20);
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
    // specify position of text with barcode line
    signOptions.setCodeTextAlignment(CodeTextAlignment.Above);
            // setup background
    Background background = new Background();
    background.setColor(Color.GREEN);
    background.setTransparency(0.5);
    background.setBrush(new LinearGradientBrush(Color.GREEN, Color.DARK_GRAY,0));
    signOptions.setBackground(background);                    
    
    // sign document   
    ignResult signResult = signature.sign("SampleSigned.docx", signOptions);
    // analyzing result
    System.out.print("List of newly created signatures:");
    int number = 1;
    for(BaseSignature temp : signResult.getSucceeded())
    {
        System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
            ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
    }   
}catch (Exception e){
    throw new GroupDocsSignatureException(e.getMessage());
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
