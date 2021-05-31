---
id: delete-digital-signatures-from-documents
url: signature/java/delete-digital-signatures-from-documents
title: Delete Digital signatures from documents
weight: 5
description: "This article explains how to delete Digital electronic signatures with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [DigitalSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/DigitalSignature) class to manipulate digital electronic signatures and delete them from the documents.
Please be aware that [delete](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#delete(java.lang.String,%20int)) method modifies the same document that was passed to constructor of the [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class.

*Important information*. Please be aware that digitally signed documents with valid certificates (pfx files) are secured and verified. Changing digitally signed document makes them untrusted from the digital verification perspective. At this moment only Pdf documents support deletion of the specific digital signatures in case of many ones were added. Most documents support deletion of all digital signatures at once without separate certificates removal. It's strongly recommened to use deletion of electronic digital signatures by signature type Digital. See example [Delete Signatures of the certain type]

Here are the steps to delete Digital signature from the document with GroupDocs.Signature:

* Create new instance of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class and pass source document path or its stream as a constructor parameter;
* Instantiate [DigitalSearchOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.search/DigitalSearchOptions) object with desired properties;
* Call [search](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method to obtain list of [DigitalSignatures](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/DigitalSignature);
* Select from list [DigitalSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures/DigitalSignature) object(s) that should be removed from the document;
* Call [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) object [delete](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#delete(java.lang.String,%20com.groupdocs.signature.domain.signatures.BaseSignature) method and pass one or several signatures to it.

This example shows how to delete Digital signature that was found using [search](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method.

```java

final Signature signature = new Signature(outputFilePath);
List<DigitalSignature> signatures = signature.search(DigitalSignature.class, SignatureType.Digital);
if (signatures.size() > 0)
{
	// delete signature
	DigitalSignature digitalSignature = signatures[0];
	boolean deleteResult = signature.delete(new ByteArrayOutputStream(), digitalSignature);	
	if (deleteResult)
	{
				System.out.print("Digital signature #"+digitalSignature.getThumbprint()+" from the "+digitalSignature.getSignTime()+" was deleted from document ['"+fileName+"'].");
	}
	else
	{
		System.out.print("Signature was not deleted from the document! Signature# "+digitalSignature.getThumbprint()+" was not found!");
	}
}
```

### Advanced Usage Topics

To learn more about document eSign features, please refer to the [Advanced usage section]({{< ref "signature/java/developer-guide/advanced-usage/_index.md" >}}).

## More resources

### GitHub Examples

You may easily run the code above and see the feature in action in our GitHub examples:

* [GroupDocs.Signature for .Net examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.Net)
* [GroupDocs.Signature for Java examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java)
* [Document Signature for .Net MVC UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.Net-MVC)
* [Document Signature for .Net App WebForms UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.Net-WebForms)
* [Document Signature for Java App Dropwizard UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Dropwizard)
* [Document Signature for Java Spring UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Spring)

### Free Online App

Along with full-featured .java library we provide simple, but powerful free Apps.

You are welcome to eSign PDF, Word, Excel, PowerPoint documents with free to use online **[GroupDocs Signature App](https://products.groupdocs.app/signature)**.
