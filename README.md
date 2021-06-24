# Java API to Manage Document e-Signatures

GroupDocs.Signature for Java is an [Digital Signature API](https://products.groupdocs.com/signature/java) that provides the ability to add stamps, barcodes and QR-codes, text, image, metadata, form field and digital signatures to [documents of 35+ formats](https://docs.groupdocs.com/signature/java/supported-document-formats/). Supported document formats inlcude PDF, Microsoft Word documents, Microsoft Excel spreadsheets, Microsoft PowerPoint presentations, Open Document formats, images, Corel & Photoshop files, and many more.

<p align="center">

  <a title="Download complete GroupDocs.Signature for Java source code" href="https://codeload.github.com/groupdocs-signature/GroupDocs.Signature-for-Java/zip/master">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

Directory | Description
--------- | -----------
[Docs](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Docs)  | Product documentation containing the Developer's Guide, Release Notes and more.
[Demos](https://github.com/groupdocs-conversion/GroupDocs.Signature-for-Java/tree/master/Demos)  | Build document eSign applications using GroupDocs.Signature for Java. 
[Examples](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 

## Electronic Signature Management via Java

### Document Singing

- Native text signatures as text stamps, text labels with settings for visualization effects, opacity, colors, fonts and so on.
- Text as image signatures with scope of additional options to specify how text will look.
- Image signatures with options to specify extra image effects & rotation.
- Digital signatures based on certificate files and ability to support digital signature by document type.
- [Barcode & QR-code signatures with variety of options](https://docs.groupdocs.com/signature/java/esign-document-with-barcode-signature/).
- Metadata signatures to keep signatures hidden.
- [Form-field signatures](https://docs.groupdocs.com/signature/java/esign-document-with-form-field-signature/).

### Search & Verify Digital Signatures

- Digital signature information from PDF, Spreadsheets, Word Processing documents & PowerPoint presentations.
- Barcode & QR-code signature information from all supported formats.
- Metadata signatures information from all supported formats.
- Form-field signatures information from all supported formats.

### Preview Document Pages

Document preview feature allows to generate image representations of document pages. This may be helpful for better understanding about document content and its structure, set proper signature position inside document, apply appropriate signature styling etc. Preview can be generated for all document pages (by default) or for specific page numbers or page range in PNG, JPG & BMP formats.


## Get Started with GroupDocs.Signature for Java

GroupDocs.Signature for Java requires J2SE 7.0 (1.7), J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already. 

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-signature), so simply [configure](https://docs.groupdocs.com/signature/java/installation/) your Maven project to fetch the dependencies automatically.

## Search for Digital Signatures in Excel XLSX
```java
Signature signature = new Signature("spreadsheet.xlsx");
DigitalSearchOptions options = new DigitalSearchOptions();

// search for signatures in document
List<DigitalSignature> signatures = signature.search(DigitalSignature.class, options);
System.out.print("\nSource document contains following signatures.");
for (DigitalSignature digitalSignature : signatures)
{
    System.out.print("Digital signature found from "+digitalSignature.getSignTime()+" with validation flag "+digitalSignature.isValid()+". Certificate SN "+ digitalSignature.getCertificate().getType());
}
```

## Digitally Sign PDF with Certificate
```java
Signature signature = new Signature("sample.pdf"); 
DigitalSignOptions options = new DigitalSignOptions("certificate.pfx");
 
// certifiate password
options.setPassword("1234567890");
// digital certificate details
options.setReason("Sign");
options.setContact("JohnSmith");
options.setLocation("Office1");
 
// image as digital certificate appearance on document pages
options.setImageFilePath("sample.jpg");
//
options.setAllPages(true);
options.setWidth(80);
options.setHeight(60);
options.setVerticalAlignment(VerticalAlignment.Bottom);
options.setHorizontalAlignment(HorizontalAlignment.Right);
Padding padding = new Padding();
padding.setBottom(10);
padding.setRight(10);
options.setMargin(padding);
 
SignResult signResult = signature.sign("signed.pdf", options);
// analyzing result
System.out.print("List of newly created signatures:");
int number = 1;
for(BaseSignature temp : signResult.getSucceeded())
{
    System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
            ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
}
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/signature/java) | [Documentation](https://docs.groupdocs.com/signature/java/) | [Demos](https://products.groupdocs.app/signature/family) | [API Reference](https://apireference.groupdocs.com/signature/java) | [Examples](https://github.com/groupdocs-Signature/GroupDocs.Signature-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/signature/) | [Search](https://search.groupdocs.com/) | [Free Support](https://forum.groupdocs.com/c/signature) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
