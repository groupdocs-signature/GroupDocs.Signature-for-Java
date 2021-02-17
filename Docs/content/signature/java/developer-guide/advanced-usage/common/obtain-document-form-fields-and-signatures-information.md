---
id: obtain-document-form-fields-and-signatures-information
url: signature/java/obtain-document-form-fields-and-signatures-information
title: Obtain document form fields and signatures information
weight: 1
description: "This article shows how to get information about electronic signatures in the document and its form fields with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) allows to get extended document information which includes:

* list of all existing [Form Field Signatures](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.formfield/FormFieldSignature ) in the document. This list will contain all Form Fields elements in the document no matter if these components were added by GroupDocs Signature or any other third party software. Please be aware only Pdf and Word processing documents support these elements.
* list of [Text Signatures](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/TextSignature ) previously added to document over [Sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.lang.String,%20com.groupdocs.signature.options.sign.SignOptions) ) method or updated by [Update](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#update(java.lang.String,%20com.groupdocs.signature.domain.signatures.BaseSignature) ) method;
* list of [Image Signatures](https://apireference.groupdocs.com/java/signature/groupdocs.signature.domain.signatures/ImageSignature ) previously added to document over [Sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.lang.String,%20com.groupdocs.signature.options.sign.SignOptions) ) method or updated by [Update](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#update(java.lang.String,%20com.groupdocs.signature.domain.signatures.BaseSignature) ) method;
* list of [DigitalSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/DigitalSignature ) previously added to document over [Sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.lang.String,%20com.groupdocs.signature.options.sign.SignOptions) ) method or updated by [Update](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#update(java.lang.String,%20com.groupdocs.signature.domain.signatures.BaseSignature) ) method;
* list of [BarcodeSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/BarcodeSignature ) previously added to document over [Sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.lang.String,%20com.groupdocs.signature.options.sign.SignOptions) ) method or updated by [Update](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#update(java.lang.String,%20com.groupdocs.signature.domain.signatures.BaseSignature) ) method;
* list of [QrCodeSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/QrCodeSignature ) previously added to document over [Sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.lang.String,%20com.groupdocs.signature.options.sign.SignOptions) ) method or updated by [Update](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#update(java.lang.String,%20com.groupdocs.signature.domain.signatures.BaseSignature) ) method;
* list of [FormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/FormFieldSignature ) previously added to document over [Sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.lang.String,%20com.groupdocs.signature.options.sign.SignOptions) ) method or updated by [Update](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#update(java.lang.String,%20com.groupdocs.signature.domain.signatures.BaseSignature) ) method;

## Analyze document form fields and signatures information

The following code snippet demonstrates how to obtain information about document form fields, signatures and analyze them.

```java

	final Signature signature = new Signature("sampleSigned.pdf");
       
	IDocumentInfo documentInfo = signature.getDocumentInfo();
	System.out.print("Document properties "+ filePath);
	System.out.print(" - format : "+documentInfo.getFileType().getFileFormat());
	System.out.print(" - extension : "+documentInfo.getFileType().getExtension());
	System.out.print(" - size : "+documentInfo.getSize());
	System.out.print(" - page count : "+documentInfo.getPageCount());
	for (PageInfo pageInfo : documentInfo.getPages())
	{
		System.out.print(" - page-"+pageInfo.getPageNumber()+" Width "+pageInfo.getWidth()+", Height "+pageInfo.getHeight());
	}
	// display document Form Field signatures information
	System.out.print("Document Form Fields information: count = "+documentInfo.getFormFields().size());
	for (FormFieldSignature formField : documentInfo.getFormFields())
	{
		System.out.print(" - type #"+formField.getType()+": Name: "+formField.getName()+" Value: "+formField.getValue());
	}
	// display document Text signatures information
	System.out.print("Document Text signatures : "+documentInfo.getTextSignatures().size());
	for (TextSignature textSignature : documentInfo.getTextSignatures())
	{
		System.out.print(" - #"+textSignature.getSignatureId()+": Text: "+textSignature.getText()+" Location: "+textSignature.getLeft()+"x"+textSignature.getTop()+". Size: "+textSignature.getWidth()+"x"+textSignature.getHeight());
	}
	// display document Image signatures information
	System.out.print("Document Image signatures : "+documentInfo.getImageSignatures().size());
	for (ImageSignature imageSignature : documentInfo.getImageSignatures())
	{
		System.out.print(" - #"+imageSignature.getSignatureId()+": Size: "+imageSignature.getSize()+" bytes, Format: "+imageSignature.getFormat());
	}
	// display document Digital signatures information
	System.out.print("Document Digital signatures : "+documentInfo.getDigitalSignatures().size());
	for (DigitalSignature digitalSignature : documentInfo.getDigitalSignatures())
	{
		System.out.print(" - #"+digitalSignature.getSignatureId());
	}
	// display document Barcode signatures information
	System.out.print("Document Barcode signatures : "+documentInfo.getBarcodeSignatures().size());
	for (BarcodeSignature barcodeSignature : documentInfo.getBarcodeSignatures())
	{
		System.out.print(" - #"+barcodeSignature.getSignatureId()+": Type: "+barcodeSignature.getEncodeType().getTypeName()+". Text: "+barcodeSignature.getText());
	}
	// display document QrCode signatures information
	System.out.print("Document QR-Code signatures : "+documentInfo.getQrCodeSignatures().size());
	for (QrCodeSignature qrCodeSignature : documentInfo.getQrCodeSignatures())
	{
		System.out.print(" - #"+qrCodeSignature.getSignatureId()+": Type: "+qrCodeSignature.getEncodeType().getTypeName()+". Text: "+qrCodeSignature.getText());
	}
	// display document Form Fields signatures information
	System.out.print("Document Form Fields signatures : "+documentInfo.getFormFieldSignatures().size());
	for (FormFieldSignature formFieldSignature : documentInfo.getFormFields())
	{
		System.out.print(" - #"+formFieldSignature.getSignatureId()+" Type "+formFieldSignature.getType()+": Name: "+formFieldSignature.getName()+" Value: "+formFieldSignature.getValue());
	}
       

```

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

Along with full-featured .java library we provide simple, but powerful free Apps.

You are welcome to eSign PDF, Word, Excel, PowerPoint documents with free to use online **[GroupDocs Signature App](https://products.groupdocs.app/signature)**.
