---
id: sign-documents-with-additional-image-adjustments
url: signature/java/sign-documents-with-additional-image-adjustments
title: Sign documents with additional image adjustments
weight: 1
description: " This article explains how to use different image adjustment with electronic signatures on document page."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) contains [ImageAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/ImageAppearance) class that implements extra image adjustment setting like

*   gray-scale ([setGrayscale](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/ImageAppearance#setGrayscale(boolean)))
*   brightness ([setBrightness](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/ImageAppearance#setBrightness(float)))
*   contrast ([setContrast](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/ImageAppearance#setContrast(float)))
*   gamma correction ([setGammaCorrection](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/ImageAppearance#setGammaCorrection(float)))
*   border ([setBorder](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/ImageAppearance#setBorder(com.groupdocs.signature.domain.Border)))

Base signature class [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) property [setAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions#setAppearance(com.groupdocs.signature.options.appearances.SignatureAppearance)) should be set with instance of [ImageAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/ImageAppearance) class to provide additional image adjustment

Here are the steps to setup extra image appearance with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Compose object of[ImageAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/ImageAppearance) object with all required additional options.    
*   Set  [SignOptions.setAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions#setAppearance(com.groupdocs.signature.options.appearances.SignatureAppearance)) property with [ImageAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/ImageAppearance)  object.      
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) to it.
*   Analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.

## Sign document with image appearance

This example shows how to specify extra image appearances. See [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult)  

```java
Signature signature = new Signature("sample.pdf");
ImageSignOptions options = new ImageSignOptions("sample.jpg");
 
    // set signature position
options.setLeft(100);
options.setTop(100);
 
    // set signature rectangle
options.setWidth(100);
options.setHeight(30);
 
    // set signature alignment
options.setVerticalAlignment(VerticalAlignment.Bottom);
options.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setBottom(20);
padding.setRight(20);
options.setMargin(padding);
 
    // setup image additional appearance as Brightness and Border
ImageAppearance imageAppearance = new ImageAppearance();
 
imageAppearance.setGrayscale(true);
imageAppearance.setContrast(0.2f);
imageAppearance.setGammaCorrection(0.3f);
imageAppearance.setBrightness(0.9f);
Border border = new Border();
 
border.setColor(Color.GREEN);
border.setDashStyle(DashStyle.DashLongDashDot);
border.setTransparency(0.5);
border.setVisible(true);
border.setWeight(2);
 
imageAppearance.setBorder(border);
options.setAppearance(imageAppearance);
 
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

## Sign PDF document with Text signature Sticker appearance

This example shows how to add Text signature to Pdf document with sticker look. See [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult)  

```java
Signature signature = new Signature("sample.docx");
{
    TextSignOptions options = new TextSignOptions("John Smith");

        // set signature position
    options.setLeft(100);
    options.setTop(100);
        // set signature rectangle
    options.setWidth(100);
    options.setHeight(30);
        // setup proper signature implementation
    options.setSignatureImplementation(TextSignatureImplementation.Sticker);
    PdfTextStickerAppearance appearance = new PdfTextStickerAppearance();
    // select sticker icon
    appearance.setIcon(PdfTextStickerIcon.Star);
    // setup if popup annotation will be opened by default
    appearance.setOpened(false);
    // text content of an annotation
    appearance.setContents("Sample");
    appearance.setSubject("Sample subject");
    appearance.setTitle("Sample Title");

    options.setAppearance(appearance);

        // set signature alignment
    options.setVerticalAlignment(VerticalAlignment.Bottom);
    options.setHorizontalAlignment(HorizontalAlignment.Right);
    Padding margin = new Padding();
    margin.setBottom(20);
    margin.setRight(20) ;
    options.setMargin(margin) ;
   
        // set text color and Font
    options.setForeColor(Color.RED);
    SignatureFont font =new SignatureFont();
    font.setSize(12); 
    font.setFamilyName("Comic Sans MS");
    options.setFont(font);

    // sign document to file
    signature.sign("signed.docx", options);
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
