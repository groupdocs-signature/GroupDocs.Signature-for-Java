---
id: migration-notes
url: signature/java/migration-notes
title: Migration Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
### Why To Migrate?

Here are the key reasons to use the new updated API provided by GroupDocs.Signature for Java since version 19.11:

*   **Signature** class introduced as a **single entry point** to sing the document with various signature types with further verification and search with any supported file format.       
*   Document **signature options, verify options and search options were unified** for all document types. Instead of using document related options now options are related to signature type only.
*   The overall document related classes were unified to common. 
*   Product architecture was redesigned from scratch in order to simplify passing options and classes to manipulate signature.
*   Document information and preview generation procedures were simplified.  
    

### How To Migrate?

Here is a brief comparison of how to sign document with text signature using old and new API.  

**Old coding style**

```java
// setup Signature configuration
SignatureConfig signConfig =new SignatureConfig();
signConfig.setStoragePath("C:\\Storage");
signConfig.setOutputPath("C:\\Output");
// instantiating the conversion handler
SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
// setup text signature options
PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
// setup colors settings
signOptions.setBackgroundColor(Color.BLUE);
// setup text color
signOptions.setForeColor(Color.RED);
// setup Font options
signOptions.getFont().setBold(true);
signOptions.getFont().setItalic(true);
signOptions.getFont().setUnderline(true);
signOptions.getFont().setStrikeout(true);
signOptions.getFont().setFontFamily("Arial");
signOptions.getFont().setFontSize(15);
// sign document

SaveOptions saveOptions = new SaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setOutputFileName("Pdf_TextSignatureFontBackgroundAndColorOptions");
String signedPath = handler.<String>sign("test.pdf", signOptions, saveOptions);
```

**New coding style**

```java
Signature signature = new Signature("sample.pdf");
TextSignOptions options = new TextSignOptions("John Smith");

// set signature position
options.setLeft(100);
options.setTop(100);

// set signature rectangle
options.setWidth(100);
options.setHeight(30);
// set text color and Font
options.setForeColor(Color.RED);
SignatureFont signatureFont = new SignatureFont();
signatureFont.setSize(12);
signatureFont.setFamilyName("Comic Sans MS");
options.setFont(signatureFont);
 
// sign document to file
signature.sign("signed.pdf", options);
```

For more code examples and specific use cases please refer to our [Developer Guide]({{< ref "signature/java/developer-guide/_index.md" >}}) documentation or [GitHub](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java/) samples and showcases.
