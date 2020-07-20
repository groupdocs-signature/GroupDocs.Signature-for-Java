---
id: sign-pdf-documents-with-special-appearance
url: signature/java/sign-pdf-documents-with-special-appearance
title: Sign Pdf documents with special appearance
weight: 3
description: " This article explains how to use PDF digital electronic signature features on document page."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) contains classes that implements for Pdf document special signature appearances.

Base signature options [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) contains property [SignOptions.setAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions#setAppearance(com.groupdocs.signature.options.appearances.SignatureAppearance)) that expects instance of the following classes

*   [PdfTextAnnotationAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/PdfTextAnnotationAppearance) class implements for Pdf documents signature as annotation area. Note that [TextSignOptions.setSignatureImplementation](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setSignatureImplementation(int)) property must be set to [TextSignatureImplementation.Annotation](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/TextSignatureImplementation)
*   [PdfTextStickerAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/PdfTextStickerAppearance) class implements for Pdf documents signature as small sticker. Note that [TextSignOptions.setSignatureImplementation](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions#setSignatureImplementation(int)) property must be set to [TextSignatureImplementation.Sticker](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/TextSignatureImplementation) 
    

Here are the steps to setup special Pdf  document Text signature appearance with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Compose object of [TextSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions) object with all required additional options.    
*   Set  [TextSignOptions.setAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions#setAppearance(com.groupdocs.signature.options.appearances.SignatureAppearance)) property with [PdfTextAnnotationAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/PdfTextAnnotationAppearance) object and set its properties      
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [TextSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/TextSignOptions) to it. 
*   Analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.

## Sign Pdf document with Text signature Annotation appearance

This example shows how to add Text signature to Pdf document with annotation look. See [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) 

```java
Signature signature = new Signature("sample.pdf");
TextSignOptions options = new TextSignOptions("John Smith");
 
// set signature position
options.setLeft(100);
options.setTop(100);
 
// set signature rectangle
options.setWidth(100);
options.setHeight(30);
// setup proper signature implementation
options.setSignatureImplementation(TextSignatureImplementation.Annotation);
 
PdfTextAnnotationAppearance appearance = new PdfTextAnnotationAppearance();
Border border = new Border();
border.setColor(Color.BLUE);
border.setDashStyle(DashStyle.Dash);
border.setWeight(2);
appearance.setBorder(border);
appearance.setBorderEffect(PdfTextAnnotationBorderEffect.Cloudy);
appearance.setBorderEffectIntensity(2);
appearance.setHCornerRadius(10);
 
// text content of an annotation
appearance.setContents("Sample");
appearance.setSubject("Sample subject");
appearance.setTitle("Sample Title");
 
options.setAppearance(appearance);
// set signature alignment
options.setVerticalAlignment(VerticalAlignment.Bottom);
options.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setBottom(20);
padding.setRight(20);
options.setMargin(padding);
// set text color and Font
options.setForeColor(Color.RED);
SignatureFont signatureFont = new SignatureFont();
signatureFont.setSize(12);
signatureFont.setFamilyName("Comic Sans MS");
options.setFont(signatureFont);
 
// sign document to file
SignResult signResult = signature.sign("signedAnnotation.pdf", options);
// analyzing result
System.out.print("List of newly created signatures:");
int number = 1;
for(BaseSignature temp : signResult.getSucceeded())
{
    System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
            ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
}
```

## Sign Pdf document with Text signature Sticker appearance

This example shows how to add Text signature to Pdf document with sticker look. See [SignResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/SignResult)

```java
Signature signature = new Signature("sample.pdf");
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
Padding padding = new Padding();
padding.setBottom(20);
padding.setRight(20);
options.setMargin(padding);
// set text color and Font
options.setForeColor(Color.RED);
SignatureFont signatureFont = new SignatureFont();
signatureFont.setSize(12);
signatureFont.setFamilyName("Comic Sans MS");
options.setFont(signatureFont);
 
 
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
