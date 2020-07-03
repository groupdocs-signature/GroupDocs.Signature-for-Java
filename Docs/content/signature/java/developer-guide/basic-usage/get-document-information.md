---
id: get-document-information
url: signature/java/get-document-information
title: Get document information
weight: 2
description: "This article explains how to detect document file type, obtain document details,  retrieve list of existing form fields and added signatures, calculate pages count when processing document file with GroupDocs.Signature."
keywords: document properties, document information, document details, get document information
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) allows to get document information which includes:

*   [getFileType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/DocumentInfo#getFileType())
*   [getSize](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/DocumentInfo#getSize())
*   [getPageCount](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/DocumentInfo#getPageCount())
*   Pages dimensions - [getHeight](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/PageInfo#getHeight()) and [getWidth](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain/PageInfo#getWidth()) for each page in a document [Pages](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.documentpreview/DocumentInfo#getPages()) collection.

## Get document information from file on local disk

The following code snippet demonstrates how to obtain information about document stored on local disk.

```java
Signature signature = new Signature("sample.pdf");
// Document description
IDocumentInfo docInfo = signature.getDocumentInfo();
System.out.print("Document contains " + docInfo.getPageCount() + " pages");
System.out.print("File type is " + docInfo.getFileType().getFileFormat());
System.out.print("Width for Max Height  " + docInfo.getWidthForMaxHeight());
System.out.print("Max Page Height" + docInfo.getMaxPageHeight());
System.out.print("File size in bytes is " + docInfo.getSize());
System.out.print("Width of first page is " + docInfo.getPages().get(0).getWidth());
for(PageInfo page : docInfo.getPages()){
    System.out.print("- page-"+ page.getPageNumber()+ " Height " + page.getHeight() + " Width " + page.getWidth());
}
```

## Get document information from a stream

The following code snippet demonstrates how to obtain information about document provided as a stream. 

```java
FileInputStream stream = new FileInputStream("sample.pdf")
Signature signature = new Signature(stream );
// Document description
IDocumentInfo docInfo = signature.getDocumentInfo();
System.out.print("Document contains " + docInfo.getPageCount() + " pages");
System.out.print("File type is " + docInfo.getFileType().getFileFormat());
System.out.print("Width for Max Height  " + docInfo.getWidthForMaxHeight());
System.out.print("Max Page Height" + docInfo.getMaxPageHeight());
System.out.print("File size in bytes is " + docInfo.getSize());
System.out.print("Width of first page is " + docInfo.getPages().get(0).getWidth());
for(PageInfo page : docInfo.getPages()){
    System.out.print("- page-"+ page.getPageNumber()+ " Height " + page.getHeight() + " Width " + page.getWidth());
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
