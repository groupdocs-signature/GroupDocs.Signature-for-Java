---
id: sign-documents-with-extra-digital-signature-properties
url: signature/java/sign-documents-with-extra-digital-signature-properties
title: Sign documents with extra Digital Signature properties
weight: 2
description: " This article explains how to use extended Digital electronic signatures options and adjustment on document page."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) contains [DigitalSignatureAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/DigitalSignatureAppearance) class that implements extra settings for digital signature of Word Processing and Spreadsheets documents

Base signature options [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) property [SignOptions.setAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions#setAppearance(com.groupdocs.signature.options.appearances.SignatureAppearance)) should be set with instance of [DigitalSignatureAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/DigitalSignatureAppearance) class to provide additional digital signature look

Here are the steps to setup extra image appearance with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.
*   Compose object of[DigitalSignatureAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/DigitalSignatureAppearance) object with all required additional options.    
*   Set  [SignOptions.setAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions#setAppearance(com.groupdocs.signature.options.appearances.SignatureAppearance)) property with [DigitalSignatureAppearance](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.appearances/DigitalSignatureAppearance) object and set its properties  
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) to it.  
*   Analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.


This example shows how to setup extra digital signature appearance. See [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) 

```java
Signature signature = new Signature("sample.docx");
DigitalSignOptions options = new DigitalSignOptions("certificate.pfx");
 
// certifiate password
options.setPassword("1234567890");
// digital certificate details
options.setReason("Sign");
options.setContact("JohnSmith");
options.setLocation("Office1");
 
// image as digital certificate appearance on document pages
options.setImageFilePath("sample.jpg");
//
options.setAllPages(true);
options.setWidth(0);
options.setHeight(60);
options.setVerticalAlignment(VerticalAlignment.Bottom);
options.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setBottom(10);
padding.setRight(10);
options.setMargin(padding);
// Setup signature line appearance.
// This appearance will add Signature Line on the first page.
// Could be useful for .xlsx files.
options.setAppearance(new DigitalSignatureAppearance("John Smith", "Title", "jonny@test.com"));
 
SignResult signResult = signature.sign("signed.docx", options);
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
