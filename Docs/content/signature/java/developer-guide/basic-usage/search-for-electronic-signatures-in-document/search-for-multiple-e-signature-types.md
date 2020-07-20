---
id: search-for-multiple-e-signature-types
url: signature/java/search-for-multiple-e-signature-types
title: Search for multiple e-signature types
weight: 8
description: "This article explains how to search for multiple electronic signatures across document pages with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
Sometimes you may want to search for electronic signatures of different types simultaneously. [**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) allows searching documents for different signature types in an easy and intuitive way. In common words the idea is to pass collection of desired signature types to Search method.

Here are the steps to search for multiple signatures types within the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.
    
*   Instantiate search options for required signature types and them to collection of List<[SearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/SearchOptions)\>  type.
    The possible options are: 
    
    *   [BarcodeSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/BarcodeSearchOptions) - to search for Barcode signatures;
        
    *   [DigitalSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/DigitalSearchOptions) -  to search for Digital signatures;
        
    *   [FormFieldSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/FormFieldSearchOptions) - to search for Form-field signatures;
    *   [ImageSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/ImageSearchOptions) - to search for Image signatures;
        
    *   [MetadataSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/MetadataSearchOptions) - to search for Metadata signatures;
        
    *   [QrCodeSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/QrCodeSearchOptions) - to search for QR-code signatures;
        
    *   [TextSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/TextSearchOptions) to search for Text signatures.
        
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.util.List)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass collection of [search](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/SearchOptions) options to it.
    

This example shows how to search for multiple electronic signature types in the document.

```java
Signature signature = new Signature("SingedSample.pdf");
BarcodeSearchOptions barcodeOptions = new BarcodeSearchOptions();
barcodeOptions.setAllPages(true);
barcodeOptions.setEncodeType(BarcodeTypes.Code128);
 
QrCodeSearchOptions qrCodeOptions = new QrCodeSearchOptions();
qrCodeOptions.setAllPages(true);
qrCodeOptions.setEncodeType(QrCodeTypes.QR);
qrCodeOptions.setText("John");
qrCodeOptions.setMatchType(TextMatchType.Contains);
 
MetadataSearchOptions metadataOptions = new MetadataSearchOptions();
metadataOptions.setAllPages(true);
metadataOptions.setIncludeBuiltinProperties(true);
 
// add options to list
List<SearchOptions> listOptions = new ArrayList<SearchOptions>();
listOptions.add(barcodeOptions);
listOptions.add(qrCodeOptions);
listOptions.add(metadataOptions);
 
// search for signatures in document
SearchResult result = signature.search(listOptions);
if (result.getSignatures().size() > 0)
{
    System.out.print("\nSource document contains following signatures.");
    for (BaseSignature resSignature : result.getSignatures())
    {
        System.out.print("Signature found at page "+resSignature.getPageNumber()+" with type "+resSignature.getSignatureType());
    }
}
else
{
    System.out.print("No one signature was found.");
}
```

## More resources

### Advanced Usage Topics

To learn more about document eSign features, please refer to the [advanced usage section]({{< ref "signature/java/developer-guide/advanced-usage/_index.md" >}}).

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
