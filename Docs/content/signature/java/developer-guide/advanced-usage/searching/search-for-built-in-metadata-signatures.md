---
id: search-for-built-in-metadata-signatures
url: signature/java/search-for-built-in-metadata-signatures
title: Search for built-in Metadata signatures
weight: 6
description: " This article explains how to provide advanced search for metadata electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [MetadataSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/MetadataSearchOptions) class to specify different options to search for Metadata signatures.

Most document types such as Word Processing, Spreadsheet and Presentation contains built-in metadata properties. Using property [setIncludeBuiltinProperties](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/MetadataSearchOptions#setIncludeBuiltinProperties(boolean)) of [MetadataSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/MetadataSearchOptions) allows to collect all supported built-in metadata properties of document. These properties are like document author, creation date, document keywords, titles, etc.

Here are the steps to search for metadata signatures within the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [MetadataSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/MetadataSearchOptions) object according to your requirements and specify [setIncludeBuiltinProperties](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/MetadataSearchOptions#setIncludeBuiltinProperties(boolean)) to true 
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [MetadataSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/MetadataSearchOptions) to it.
    

This example shows how to get built in Metadata signatures.

```java
Signature signature = new Signature("sample.xlsx");
MetadataSearchOptions options = new MetadataSearchOptions();
options.setName("Producer");
options.setIncludeBuiltinProperties(true);
options.setNameMatchType(TextMatchType.Contains);
 
// search for signatures in document
List<MetadataSignature> signatures = signature.search(MetadataSignature.class, options);
System.out.print("\nSource document contains following signatures.");
for (MetadataSignature metadataSignature : signatures)
{
    System.out.print("Metadata signature found. Name : "+metadataSignature.getName()+". Value: "+ metadataSignature.getValue());
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
