---
id: load-document-from-url
url: signature/java/load-document-from-url
title: Load document from URL
weight: 6
description: "This section explains how to load document from URL with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
Following example demonstrates how to work with documents from URL.

```java
String url = "https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET/blob/master/Examples/Resources/SampleFiles/sample.pdf?raw=true";
 
InputStream stream = new URL(url).openStream();
Signature signature = new Signature(stream);
 
TextSignOptions options = new TextSignOptions("John Smith");
 
// set signature position
options.setLeft(100);
options.setTop(100);
 
// sign document to file
signature.sign("SampleSigned.pdf", options);
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
