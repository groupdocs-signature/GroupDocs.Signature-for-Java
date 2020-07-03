---
id: advanced-search-for-image-signatures
url: signature/java/advanced-search-for-image-signatures
title: Advanced search for Image signatures
weight: 5
description: " This article explains how to make advanced search for Image electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [ImageSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/ImageSearchOptions)  class to specify different options to search for Image Signatures.

Here are the steps to search for image signatures within the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [ImageSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/ImageSearchOptions)  object according to your requirements and specify search options 
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [ImageSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/ImageSearchOptions) to it.
    

This example shows how to make advanced search for Image signature in the document and further image signatures analyzes with saving image content

```java
Signature signature = new Signature(sample.pdf);
 
PagesSetup pS = new  PagesSetup();
pS.setFirstPage(true);
pS.setLastPage(true);
pS.setOddPages(false);
pS.setEvenPages(false);
// setup search options
ImageSearchOptions searchOptions = new ImageSearchOptions();
searchOptions.setAllPages(false);
searchOptions.setPageNumber(1);
searchOptions.setPagesSetup(pS);
 
// search document
List<ImageSignature> signatures = signature.search(ImageSignature.class,searchOptions);
System.out.print("\nSource document ['" + fileName + "'] contains following image signature(s).");
// output signatures
//foreach to while statements conversion
try
{
    for (ImageSignature sign : signatures)
    {
 
        System.out.print("Found Image signature at page "+sign.getPageNumber()+" and size "+sign.getSize()+".");
        System.out.print("Location at "+sign.getLeft()+"-"+sign.getTop()+". Size is "+sign.getWidth()+"x"+sign.getHeight()+".");
    }
}
catch (Exception ex)
{
    System.out.print("System Exception: " + ex.getMessage());
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
