---
id: locating-signature-on-page-with-different-measure-units
url: signature/java/locating-signature-on-page-with-different-measure-units
title: Locating signature on page with different measure units
weight: 1
description: " This article explains using measure units to locate signature and its size on document page with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) supports locating signature on document page with different measure units. Enumeration [MeasureType](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/MeasureType) handles following types 

*   [MeasureType.Pixels](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/MeasureType#Pixels) allows to locate signature position and size with pixels (default value)
*   [MeasureType.Millimeters](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/MeasureType#Millimeters) allows to locate signature on page and setup size by setting millimeters
*   [MeasureType.Percents](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.enums/MeasureType#Percents) allows to locate signature position, size with percentage of page size  
      

Here are the steps to locate and size signature area with different measure unit types:

*   Set property [setLocationMeasureType](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setLocationMeasureType(int)) with of one values above to specify how to implement values in properties [setLeft](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.interfaces/IRectangle#setLeft(int)), [setTop](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.interfaces/IRectangle#setTop(int))    
*   Set property [setSizeMeasureType](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setSizeMeasureType(int)) with of one values above to specify how to implement size of signature values in properties [setWidth](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.interfaces/IRectangle#setWidth(int)), [setHeight](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.interfaces/IRectangle#setHeight(int))    
*   Set property [setMarginMeasureType](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setMarginMeasureType(int)) with of one values above to specify how to implement values in property [setMargin](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/ImageSignOptions#setMargin(com.groupdocs.signature.domain.Padding))

## Set signature positioning in millimeters

This example shows how to specify positioning in millimeters.

```java
 // instantiating the signature object
final Signature signature = new Signature("sample.docx");
try
{
    // setup options with text of signature
    BarcodeSignOptions signOptions = new BarcodeSignOptions("12345678");
    // setup Barcode encoding type
    signOptions.setEncodeType(BarcodeTypes.Code128);
    // set signature position in absolute position
    signOptions.setLocationMeasureType(MeasureType.Millimeters);
    signOptions.setLeft(40);
    signOptions.setTop(50);
    // set signature area in millimeters
    signOptions.setSizeMeasureType(MeasureType.Millimeters);
    signOptions.setWidth(20);
    signOptions.setHeight(10);
    // set margin in millimeters
    signOptions.setMarginMeasureType(MeasureType.Millimeters);
    Padding padding = new Padding();
    padding.setTop(5);
    padding.setLeft(5);
    padding.setRight(5);
    signOptions.setMargin(padding);
 
    // sign document    
    SignResult signResult = signature.sign("signedSample.docx", options);
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

## Set signature positioning in percents

This example shows how to set different positioning properties in percentage.

```java
 // instantiating the signature object
final Signature signature = new Signature("sample.pdf");
try
{
   // setup options with text of signature
   BarcodeSignOptions signOptions = new BarcodeSignOptions("12345678");
   // setup Barcode encoding type
   signOptions.setEncodeType(BarcodeTypes.Code128);
   // set signature position in absolute position
   signOptions.setLocationMeasureType(MeasureType.Percents);
   signOptions.setLeft(5);
   signOptions.setTop(5);
   // set signature area in percents
   signOptions.setSizeMeasureType(MeasureType.Percents);
   signOptions.setWidth(10);
   signOptions.setHeight(5);
   // set margin in millimeters
   signOptions.setMarginMeasureType(MeasureType.Percents);
   Padding padding = new Padding();
   padding.setTop(1);
   padding.setLeft(1);
   padding.setRight(1);
   signOptions.setMargin(padding);
 
   // sign document          
   SignResult signResult = signature.sign("signed.docx", options);
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
