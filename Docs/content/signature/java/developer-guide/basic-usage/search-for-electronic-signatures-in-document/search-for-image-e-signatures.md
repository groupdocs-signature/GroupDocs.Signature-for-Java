---
id: search-for-image-e-signatures
url: signature/java/search-for-image-e-signatures
title: Search for Image e-signatures
weight: 7
description: "This article explains how to search for Image electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[GroupDocs.Signature](https://products.groupdocs.com/signature/java) provides [ImageSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/ImageSearchOptions) class to specify different options to search for Image e-signatures.

 Here are the steps to search for Image signatures within the document with GroupDocs.Signature API:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;    
*   Instantiate the [ImageSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/ImageSearchOptions) object according to your requirements and specify additional search options (if needed);  
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [ImageSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/ImageSearchOptions) to it.
    

The code snippet below demonstrates how to search for Image electronic signature in the document.

```java
Signature signature = new Signature(sample.pdf);
// setup search options
ImageSearchOptions searchOptions = new ImageSearchOptions();   
 
// search document
List<ImageSignature> signatures = signature.search(ImageSignature.class,searchOptions);
System.out.print("\nSource document ['" + fileName + "'] contains following image signature(s).");
// output signatures   
for (ImageSignature imageSignature : signatures)
{
 
   System.out.print("Found Image signature at page "+imageSignature.getPageNumber()+" and size "+imageSignature.getSize()+".");
   System.out.print("Location at "+imageSignature.getLeft()+"-"+imageSignature.getTop()+". Size is "+imageSignature.getWidth()+"x"+imageSignature.getHeight()+".");
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
