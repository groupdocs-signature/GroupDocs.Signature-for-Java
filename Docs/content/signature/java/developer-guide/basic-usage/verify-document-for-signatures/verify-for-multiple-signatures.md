---
id: verify-for-multiple-signatures
url: signature/java/verify-for-multiple-signatures
title: Verify for multiple signatures
weight: 5
description: "This topic explains how to verify electronic signatures of various types with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
**[GroupDocs.Signature](https://products.groupdocs.com/signature/java)** supports verification of documents for different signature types. This approach requires to add all required verification options to list.

Here are the steps to verify document for multiple signatures with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Instantiate required several [VerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/VerifyOptions) objects ([BarcodeVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/BarcodeVerifyOptions), [QrCodeVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/QrCodeVerifyOptions), [DigitalVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/DigitalVerifyOptions), [TextVerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/TextVerifyOptions)) and add instances to List<[VerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/VerifyOptions)\> collection.
*   Call [verify](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#verify(java.util.List)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass filled list of List<[VerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/VerifyOptions)\> to it.   


This example shows how to search for different signature types in the document.

```java
Signature signature = new Signature("sampleSigned.pdf");
TextVerifyOptions textVerifyOptions = new TextVerifyOptions();
textVerifyOptions.setAllPages(true); // this value is set by default
textVerifyOptions.setText("John");
textVerifyOptions.setSignatureImplementation(TextSignatureImplementation.Stamp);
textVerifyOptions.setMatchType(TextMatchType.Contains);
 
BarcodeVerifyOptions barcVerifyOptions = new BarcodeVerifyOptions();
barcVerifyOptions.setAllPages(true); // this value is set by default
barcVerifyOptions.setText("John");
barcVerifyOptions.setMatchType(TextMatchType.Contains);
 
QrCodeVerifyOptions qrcdVerifyOptions = new QrCodeVerifyOptions();
qrcdVerifyOptions.setAllPages(true); // this value is set by default
qrcdVerifyOptions.setText("John");
qrcdVerifyOptions.setMatchType(TextMatchType.Contains);
 
DigitalVerifyOptions digtVerifyOptions = new DigitalVerifyOptions();
digtVerifyOptions.setComments("Test comment"); // this value is set by default
 
// verify document signatures
List<VerifyOptions> listOptions = new ArrayList<VerifyOptions>();
listOptions.add(textVerifyOptions);
listOptions.add(barcVerifyOptions);
listOptions.add(qrcdVerifyOptions);
listOptions.add(digtVerifyOptions);
 
// verify signatures in document
VerificationResult result = signature.verify(listOptions);
if (result.isValid())
{
    System.out.print("\nDocument was verified successfully!");
}
else
{
    System.out.print("\nDocument failed verification process.");
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
