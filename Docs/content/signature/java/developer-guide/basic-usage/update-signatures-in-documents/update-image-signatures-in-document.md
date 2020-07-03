---
id: update-image-signatures-in-document
url: signature/java/update-image-signatures-in-document
title: Update Image signatures in document
weight: 2
description: "This article explains how to update Image electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [ImageSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/ImageSignature) class to manipulate barcode signatures location, size and textual content. 

Please be aware that [update](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#update(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method modifies the same document that was passed to constructor of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class.

Here are the steps to update Barcode signature in the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;    
*   Instantiate [ImageSearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/ImageSearchOptions) object with desired properties;    
*   Call [search](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method to obtain list of [ImageSignatures](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/ImageSignature);      
*   Select from list [ImageSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/ImageSignature) object(s) that should be updated;     
*   Call [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) object [update](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#update(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method and pass one or several signatures to it.
    

This example shows how to update Image signature that was found using  [search](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method.

```java
Signature signature = new Signature("sampleSigned.pdf");
try 
{
    ImageSearchOptions options = new ImageSearchOptions();

    // search for image signatures in document
    List<ImageSignature> signatures = signature.search(ImageSignature.class,options);
    if (signatures.size() > 0)
    {
        ImageSignature imageSignature = signatures.get(0);
        imageSignature.setLeft(100);
        imageSignature.setTop(100);
        boolean result = signature.update("sampleSigned-output.pdf",imageSignature);
        if (result)
        {
            System.out.print("Image signature at location " + imageSignature.getLeft() + "x" + imageSignature.getTop() + " and Size " + imageSignature.getSize() + " was updated in the document [" + fileName + ".");
        }
        else
        {
            System.out.print("Signature was not updated in the document! Signature at location " + imageSignature.getLeft() + "x" + imageSignature.getTop() + " and Size " + imageSignature.getSize() + " was not found!");
        }
    }
} catch (Exception e) {
    throw new GroupDocsSignatureException(e.getMessage());
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
