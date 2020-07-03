---
id: update-text-signatures-in-document
url: signature/java/update-text-signatures-in-document
title: Update Text signatures in document
weight: 4
description: "This article explains how to update Text electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [TextSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/TextSignature) class to manipulate text signatures location, size and textual content. 

Please be aware that [update](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/Signature#update(java.lang.String,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method modifies the same document that was passed to constructor of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class.

Here are the steps to update Text signature in the document with GroupDocs.Signature:
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;    
*   Instantiate [TextSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/TextSearchOptions) object with desired properties;    
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method to obtain list of [TextSignatures](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/TextSignature);      
*   Select from list [TextSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/TextSignature) object(s) that should be updated;
*   Call [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) object [update](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/Signature#update(java.lang.String,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method and pass one or several signatures to it.
    
This example shows how to update Text signature that was found using  [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method.

```java
Signature signature = new Signature("sampleSigned.pdf");
try {
    TextSearchOptions options = new TextSearchOptions();
    // search for text signatures in document
    List<TextSignature> signatures = signature.search(TextSignature.class, options);
    if (signatures.size() > 0) {
        TextSignature textSignature = signatures.get(0);
        // change Text property
        textSignature.setText("John Walkman");
        // change position
        textSignature.setLeft(textSignature.getLeft() + 50);
        textSignature.setTop(textSignature.getTop() + 50);
        // change size. Please note not all documents support changing signature size
        textSignature.setWidth(200);
        textSignature.setHeight(100);
 
        boolean result = signature.update("sampleSigned.pdf",textSignature);
        if (result) {
            System.out.print("Signature with Text '" + textSignature.getText() + "' was updated in the document ['sampleSigned.pdf'].");
        } else {
            System.out.print("Signature was not updated in  the document! Signature with Text '" + textSignature.getText() + "' was not found!");
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
