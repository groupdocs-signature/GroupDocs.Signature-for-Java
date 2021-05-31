---
id: delete-signatures-of-the-certain-type
url: signature/java/delete-signatures-of-the-certain-type
title: Delete Signatures of the certain type
weight: 6
description: "This article explains how to delete electronic signatures of the certain type with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides overloaded [delete](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#delete(java.lang.String,%20int)) method that accepts one [SignatureType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/SignatureType) or list of them.
Please be aware that this method modifies the same document that was passed to constructor of the [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class.

Here are the steps to delete signature by specific type from the document with GroupDocs.Signature:

* Create new instance of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) class and pass source document path or its stream as a constructor parameter;
* Call [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) object [delete](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#delete(java.lang.String,%20int)) method and pass certain [SignatureType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/SignatureType) enumeration to it.

This example shows how to delete QR-Code signatures from the document.

```java
Signature signature = new Signature("signed.pdf");
{
	// deleting QR-Code signatures from the document
	DeleteResult result = signature.delete("signed_out.pdf", SignatureType.QrCode);
	if (result.getSucceeded().size() > 0)
	{
		System.out.print("Following QR-Code signatures were deleted:");
		int number = 1;
		for (BaseSignature temp : result.getSucceeded())
		{
			System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Text: "+((QrCodeSignature)temp).getText());
		}
	}
	else
	{
		System.out.print("No one QR-Code signature was deleted.");
	}
}
```

### Advanced Usage Topics

To learn more about document eSign features, please refer to the [Advanced usage section]({{< ref "signature/java/developer-guide/advanced-usage/_index.md" >}}).

## More resources

### GitHub Examples

You may easily run the code above and see the feature in action in our GitHub examples:

* [GroupDocs.Signature for .NET examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET)
* [GroupDocs.Signature for Java examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java)
* [Document Signature for .NET MVC UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-MVC)
* [Document Signature for .NET App WebForms UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-WebForms)
* [Document Signature for Java App Dropwizard UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Dropwizard)
* [Document Signature for Java Spring UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Spring)

### Free Online App

Along with full-featured .NET library we provide simple, but powerful free Apps.

You are welcome to eSign PDF, Word, Excel, PowerPoint documents with free to use online **[GroupDocs Signature App](https://products.groupdocs.app/signature)**.
