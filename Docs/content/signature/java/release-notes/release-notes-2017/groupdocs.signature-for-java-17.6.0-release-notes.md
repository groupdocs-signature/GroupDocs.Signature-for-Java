---
id: groupdocs-signature-for-java-17-6-0-release-notes
url: signature/java/groupdocs-signature-for-java-17-6-0-release-notes
title: GroupDocs.Signature for Java 17.6.0 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 17.6.0{{< /alert >}}

## Major Features

There are more than 20 improvements, new features and fixes in this regular release. The most notable are:

*   Introduced new Barcode Signature type for all supported Document formats. This version contains implementation of following encoding Barcode types EAN8, EAN13, EAN14, UPCA, UPCE, ITF14, Code39 Standard, Code39 Extended, Code 128.
*   Implemented all existing standard properties support for Barcode Signature like Alignment, Fonts, positioning, border options etc
*   Introduced Barcode verification features for all supported Document formats. Trial version supports only Code39 verification feature. Barcode verification supports only implemented types from Barcode signature. More encode types and verification decode types will be provided in next releases.
*   Introduced new QRCode Signature type for all supported Document formats. This version contains implementation of most used QRCode types like QR, Aztec, Data Matrix
*   Implemented all existing standard properties support for QRCode Signature like Alignment, Fonts, positioning, border options etc.
*   Introduced QRCode verification features for all supported Document formats. Trial version supports only standard QR verification feature.
*   Improved validation messages with detailed information
*   Updated Watermark implementations features and object positioning
*   Optimized Signature processing for Cells Documents

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-2906 | Implement QRCode Signature Verification for Words Documents | New Feature |
| SIGNATURENET-2905 | Implement QRCode Signature Verification for Cells Documents | New Feature |
| SIGNATURENET-2904 | Implement QRCode Signature Verification for Pdf Documents | New Feature |
| SIGNATURENET-2903 | Implement QRCode Signature Verification for Slides Documents | New Feature |
| SIGNATURENET-2896 | Implement Barcode Signature Verification for Words Documents | New Feature |
| SIGNATURENET-2893 | Implement Barcode Signature Verification for Slides Documents | New Feature |
| SIGNATURENET-2890 | Implement Barcode Signature Verification for Cells Documents | New Feature |
| SIGNATURENET-2887 | Implement Barcode Signature Verification for Pdf Documents | New Feature |
| SIGNATURENET-2872 | Implement QR-code Signature features for Slides Documents | New Feature |
| SIGNATURENET-2869 | Implement QR-code Signature features for Words Documents | New Feature |
| SIGNATURENET-2866 | Implement QR-code Signature features for Cells Documents | New Feature |
| SIGNATURENET-2863 | Implement QR-code Signature features for PDF Documents | New Feature |
| SIGNATURENET-2857 | Implement Barcode Signature features for Slides Documents | New Feature |
| SIGNATURENET-2854 | Implement Barcode Signature features for Words Documents | New Feature |
| SIGNATURENET-2851 | Implement Barcode Signature features for Cells Documents | New Feature |
| SIGNATURENET-2848 | Implement Barcode Signature features for PDF Documents | New Feature |
| SIGNATURENET-2267 | Digital Signature for Open Document files format support | New Feature |
| SIGNATURENET-2879 | Improve validation messages with detailed information | Improvement |
| SIGNATURENET-2826 | Implement positioning subsystem for watermarks signatures | Improvement |
| SIGNATURENET-2539 | Error occurred when passing Digital PFX Certificate file rendered by DSA Algorithm | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 17.6.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1. Added new classes that describe Barcode types. Class BarcodeType contains description of Barcode encoding type, name and index in list of supported types. Newly added static class BarcodeTypes contains static objects of each supported Barcode type, same as list of all registered types in AllTypes array property. See common examples here: [Working with Barcode Signature]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-barcode-signature.md" >}})

### Adding Barcode Signature

Barcode Signature options are listed in classes **PdfBarcodeSignOptions**, **CellsBarcodeSignOptions**, **WordsBarcodeSignOptions** and **SlidesBarcodeSignOptions** for corresponding document type

**Java Setup Pdf Signature Text Options**

```java
// setup text signature options
PdfBarcodeSignOptions signOptions = new PdfBarcodeSignOptions();
// barcode type
signOptions.setEncodeType(BarcodeTypes.EAN_14);
// signature text
signOptions.setText("12345678901234");
// text position
signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
```

2\. Base class **BarcodeSignOptions** was added. This class inherits from SignTextOptions and implements all inherited properties and interfaces like Alignment, Opacity, etc. For each supported Document Type appropriate Signature Options were added **CellsBarcodeSignOptions**, **PdfBarcodeSignOptions**, **SlidesBarcodeSignOptions** and **WordsBarcodeSignOptions**.

See examples of using new Signature type per each Document Format on these links 

[eSign document with Barcode signature]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-barcode-signature.md" >}})

3\. Added new classes that describe QR-code types. Class **QRCodeType** contains description of QR-code encoding type, name and index in list of supported types. Newly added static class **QRCodeTypes **contains static objects of each supported QRCode type, same as list of all registered types in **AllTypes** array property. See common examples here [Working with QR-code Signature]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-qr-code-signature.md" >}})

### Adding QR-code to Documents 

Barcode Signature options are listed in classes **PdfQRCodeodeSignOptions**, **CellsQRCodeSignOptions**, **WordsQRCodeSignOptions** and **SlidesQRCodeSignOptions** for corresponding document type

**Java Setup Pdf Signature Text Options**

```java
// setup text signature options
PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions();
//QR-code type
signOptions.setEncodeType(QRCodeTypes.QR);
// signature text
signOptions.setText("12345678901234");
// text position
signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
```

  
4\. Base class **QRCodeSignOptions** was added. This class inherits from SignTextOptions and implements all inherited properties and interfaces like Alignment, Opacity, etc. For each supported Document Type appropriate Signature Options were added **CellsQRCodeSignOptions**, **PdfQRCodeSignOptions**, **SlidesQRCodeSignOptions** and **WordsQRCodeSignOptions**.

See examples of using new Signature type per each Document Format on these links

[eSign document with QR-code signature]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-qr-code-signature.md" >}})

  
5\. For verification purposes of newly added Signature types new classes were added. Base class **VerifyBarcodeOptions**. This class inherits from **VerifyTextOptions** and implements all inherited properties like Text, VerifyPages, PagesSetup etc.

### Verification of  Barcode Signature



```java
String storagePath = "c:/Aspose/Test/Storage";
String outputPath = "c:/Aspose/Test/Output";
// setup Signature configuration
SignatureConfig signConfig = new SignatureConfig();
signConfig.setStoragePath(storagePath);
signConfig.setOutputPath(outputPath);
// instantiating the conversion handler
SignatureHandler handler = new SignatureHandler(signConfig);
// setup verification options
PDFVerifyBarcodeOptions verifyOptions = new PDFVerifyBarcodeOptions();
// verify only page with specified number
verifyOptions.setDocumentPageNumber(1);
// verify all pages of a document if true
verifyOptions.setVerifyAllPages(true);
// barcode type
verifyOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
//If verify option Text is set, it will be searched in Title, Subject and Contents
verifyOptions.setText("12345678");
//verify document
VerificationResult result = handler.verify("SignedBarCode.pdf", verifyOptions);
System.out.println("Verification pdf file with Barcode signature " + result.isValid());
```

For each supported Document Type appropriate Signature Options were added **CellsVerifyBarcodeOptions**, **PdfVerifyBarcodeOptions**, **SlidesVerifyBarcodeOptions** and **WordsVerifyBarcodeOptions**.

See examples of using new Signature type per each Document Format on these links - [Verify Barcode signatures in the document]({{< ref "signature/java/developer-guide/basic-usage/verify-document-for-signatures/verify-barcode-signatures-in-the-document.md" >}})

   
6\. For verification purposes of newly added QR-code Signature types new classes were added. Base class **VerifyQRCodeOptions**. This class inherits from **VerifyTextOptions** and implements all inherited properties like Text, VerifyPages, PagesSetup etc. 

### Verification of QR-code located on Document



```java
String storagePath = "c:/Aspose/Test/Storage";
String outputPath = "c:/Aspose/Test/Output";
// setup Signature configuration
SignatureConfig signConfig = new SignatureConfig();
signConfig.setStoragePath(storagePath);
signConfig.setOutputPath(outputPath);
// instantiating the conversion handler
SignatureHandler handler = new SignatureHandler(signConfig);
// setup verification options
PDFVerifyQRCodeOptions verifyOptions = new PDFVerifyQRCodeOptions();
// verify only page with specified number
verifyOptions.setDocumentPageNumber(1);
// verify all pages of a document if true
verifyOptions.setVerifyAllPages(true);
// barcode type
verifyOptions.setEncodeType(QRCodeTypes.AZTEC);
//If verify option Text is set, it will be searched in Title, Subject and Contents
verifyOptions.setText("12345678");
//verify document
VerificationResult result = handler.verify("SignedQRCode.pdf", verifyOptions);
System.out.println("Verification pdf file with Qrcode signature " + result.isValid());
```

For each supported Document Type appropriate Signature Options were added **CellsVerifyQRCodeOptions**, **PdfVerifyQRCodeOptions**, **SlidesVerifyQRCodeOptions** and **WordsVerifyQRCodeOptions**. See examples of using new Signature type per each Document Format on these links

[Verification documents signed with QR-code Signature]({{< ref "signature/java/developer-guide/advanced-usage/verifying/verify-qr-code-signatures.md" >}})
