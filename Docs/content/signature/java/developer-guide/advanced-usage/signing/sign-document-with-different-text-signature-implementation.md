---
id: sign-document-with-different-text-signature-implementation
url: signature/java/sign-document-with-different-text-signature-implementation
title: Sign document with different Text signature implementation
weight: 4
description: " This article explains how to sign document with Text electronic signatures using extended options with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [TextSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions) class with property [SignatureImplementation](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions#getSignatureImplementation()) of enumeration type [TextSignatureImplementation](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation) to specify various implementations of Text Signatures with following values and its meaning

*   [TextSignatureImplementation.Stamp](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation) - text stamp component (label) on the document page.
*   [TextSignatureImplementation.Annotation](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation) - text annotation with different appearances settings. This implementation depends of document type.
*   [TextSignatureImplementation.Image](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation) - text will be transformed to image and put to document page. This implementation makes sense when there's a need to adjust extended appearances effects that is possible with image adjustment only (like opacity, free rotation, fading, shadows etc).
*   [TextSignatureImplementation.Sticker](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation) - text sticker icon with different appearances settings. This implementation depends of document type.
*   [TextSignatureImplementation.FormField](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation)  - this type is used to update existing Form Fields in the document. For this purpose please user property [FormTextFieldTitle](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/FormTextFieldType) to setup Form Field name and property [FormTextFieldType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/FormTextFieldType) to specify type of Form Field.
*   [TextSignatureImplementation.Watermark](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation) - text watermark along the document page under all document components. This implementation depends of document type.

Here are the steps to add Text signature into document with various text signature implementation types with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [TextSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions) object with all required additional options.    
*   set property [SignatureImplementation](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions#setSignatureImplementation(int)) of [TextSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions) object with required value from enumeration type [TextSignatureImplementation](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/TextSignatureImplementation).
*   Call [sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class instance and pass initialized [TextSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/TextSignOptions) instance to it. 
*   Analyze [SignResult](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.

## Sign document with Text signature and Stamp implementation type

This example shows how to add Text signature with Stamp signature implementation to document.

```java
Signature signature = new Signature("sample.pdf");
{
    TextSignOptions options = new TextSignOptions("John Smith");
    
        // set alternative signature implementation on document page
    options.setSignatureImplementation(TextSignatureImplementation.Stamp);
        // set alignment
    options.setVerticalAlignment(VerticalAlignment.Top);
    options.setHorizontalAlignment(HorizontalAlignment.Right);
        // set margin with 20 pixels for all sides
    options.setMargin(new Padding(20));
    
    // sign document to file
    SignResult signResult = signature.sign("signed.pdf", options);
    // analyzing result
    System.out.print("List of newly created signatures:");
    int number = 1;
    for (BaseSignature temp : signResult.getSucceeded())
    {
        System.out.print("Signature #"+number+++": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
                ", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
    }
}
```

## Sign document with Text signature and Annotation implementation type

This example shows how to add Text signature with Annotation signature implementation to document.

```java
Signature signature = new Signature("sample.pdf");
{
    TextSignOptions options = new TextSignOptions("John Smith");

        // set alternative signature implementation on document page
    options.setSignatureImplementation(TextSignatureImplementation.Annotation);
        // for Pdf document type ther's ability to setup exteneded appearences
    PdfTextAnnotationAppearance appearance =  new PdfTextAnnotationAppearance();
    Border border= new Border();
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
        // set alignment
    options.setVerticalAlignment(VerticalAlignment.Top);
    options.setHorizontalAlignment(HorizontalAlignment.Right);
        // set margin with 20 pixels for all sides
    options.setMargin(new Padding(20));

        // sign document to file
    SignResult signResult = signature.sign("signed.pdf", options);
        // analyzing result
    // analyzing result
    System.out.print("List of newly created signatures:");
    int number = 1;
    for (BaseSignature temp : signResult.getSucceeded())
    {
        System.out.print("Signature #"+number+++": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
                ", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
    }
}
```

## Sign document with Text signature and Image implementation type

This example shows how to add Text signature with Image signature implementation to document.

```java
Signature signature = new Signature("sample.pdf");
{
    TextSignOptions options = new TextSignOptions("John Smith");            
        // set alternative signature implementation on document page
    options.setSignatureImplementation(TextSignatureImplementation.Image);
        // set alignment
    options.setVerticalAlignment(VerticalAlignment.Top);
    options.setHorizontalAlignment(HorizontalAlignment.Right);
        // set margin with 20 pixels for all sides
    options.setMargin(new Padding(20));            
        // sign document to file
    SignResult signResult = signature.sign("signed.pdf", options);
        // analyzing result
    System.out.print("List of newly created signatures:");
    int number = 1;
    for (BaseSignature temp : signResult.getSucceeded())
    {
        System.out.print("Signature #"+number+++": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
                ", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
    }
}
```

## Sign document with Text signature and Sticker implementation type

This example shows how to add Text signature with Sticker signature implementation to document.

```java
Signature signature = new Signature("sample.pdf");
{
    TextSignOptions options = new TextSignOptions("John Smith");
    
        // set alternative signature implementation on document page
    options.setSignatureImplementation(TextSignatureImplementation.Sticker);

        // set alignment
    options.setVerticalAlignment(VerticalAlignment.Top);
    options.setHorizontalAlignment(HorizontalAlignment.Right);
        // set margin with 20 pixels for all sides
    options.setMargin(new Padding(20));
    
    // sign document to file
    SignResult signResult = signature.sign("signed.pdf", options);
    // analyzing result
    System.out.print("List of newly created signatures:");
    int number = 1;
    for (BaseSignature temp : signResult.getSucceeded())
    {
        System.out.print("Signature #"+number+++": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
                ", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
    }
}
```

## Sign document with Text signature and Form Field implementation type

This example shows how to add Text signature with FormField signature implementation to document.

```java
Signature signature = new Signature("sample.docx");
{
    TextSignOptions ffOptions1 = new TextSignOptions("John Smith");            
        // set alternative signature implementation on document page
    ffOptions1.setSignatureImplementation(TextSignatureImplementation.FormField);
    ffOptions1.setFormTextFieldType(FormTextFieldType.PlainText);
    ffOptions1.setFormTextFieldTitle("UserSignatureFullName");
    
    TextSignOptions ffOptions2 = new TextSignOptions("Document is approved");            
        // set alternative signature implementation on document page
    ffOptions2.setSignatureImplementation(TextSignatureImplementation.FormField);
    ffOptions2.setFormTextFieldType(FormTextFieldType.RichText);
    ffOptions2.setFormTextFieldTitle("UserSignatureComment");
    
    List<SignOptions> listOptions = new ArrayList<SignOptions>();
    listOptions.add(ffOptions1);
    listOptions.add(ffOptions2);
    // sign document to file
    SignResult signResult = signature.sign("signed.docx", listOptions);
    // analyzing result
    System.out.print("List of newly created signatures:");
    int number = 1;
    for (BaseSignature temp : signResult.getSucceeded())
    {
        System.out.print("Signature #"+number+++": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
                ", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
    }
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
