---
id: groupdocs-signature-for-java-17-7-0-release-notes
url: signature/java/groupdocs-signature-for-java-17-7-0-release-notes
title: GroupDocs.Signature for Java 17.7.0 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 17.7.0{{< /alert >}}

## Major Features

There are about 15 improvements, new features and fixes in this regular release. The most notable are:

*   Introduced new Stamp Signature type for all supported Document formats. This version contains implementation of dynamic Stamp Signature generation based on passed lists of Outer and Inner Stamp lines.
*   Implemented all existing standard properties support for Stamp Signature like Alignment, Fonts, positioning, border options etc
*   Introduced new Barcode encode types support - this version contains most used Barcode types - Code 11, Code 128, Code 16K/32, Databar codes, GS1 Codeblock, ISBN, ISMN, ISSN, ITF16, Pdf147 and much more.
*   Introduced new QRCode encode types like Aztec, DataMatrix, GS1 DataMatrix, GS1 QR.
*   Implemented all existing standard properties support for new QRCode Signature like Alignment, Fonts, positioning, border options etc.
*   Introduced verification support of new Barcode and QR-Code types
*   Improved verification process, update messages with detailed information
*   Optimized Barcode and QR-Code Signature verification validation

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-2937 | Implement Stamp Signature features for Slides Documents | New Feature |
| SIGNATURENET-2934 | Implement Stamp Signature features for Words Documents | New Feature |
| SIGNATURENET-2931 | Implement Stamp Signature features for Cells Documents | New Feature |
| SIGNATURENET-2928 | Implement Stamp Signature features for PDF Documents | New Feature |
| SIGNATURENET-2924 | Implement Verification of new Barcode encode types | New Feature |
| SIGNATURENET-2923 | Implement Verification of new QR-Code encode types | New Feature |
| SIGNATURENET-2921 | Implement new QR-Code encode types | New Feature |
| SIGNATURENET-2920 | Implement new Barcode encode types | New Feature |
| SIGNATURENET-2946 | Improve Barcode Verification options | Improvement |
| SIGNATURENET-2945 | Update Document Information method with extended guid properties | Improvement |
| SIGNATURENET-2922 | Improve QR-Code options validation | Improvement |
| SIGNATURENET-2901 | Improve Barcode options validation | Improvement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 17.7.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Added new static variables to BarcodeTypes static class that describe new Barcode types.
2.  Added new class** BorderLine** to describe Border of line - the color, dash style, color, etc
3.  **DocumentDescription** class has new properties - FileFormat - string based file format, Extension, Date created and modified
4.  Added new enumeration type TextMatchType - to distinct different search mechanism for Barcode and QR-Code verification and recognition
5.  Classes VerifyBarcodeOptions and VerifyQRcodeOptions have new property of Match Type (see above) - **MatchType** to distinct how verify recognize text from Barcode or QR Code.
6.  Implemented new class **StampLine** that describe Stamp Ring or Stamp Horizontal Line with text;
7.  Added new options **StampSignOptions** to describe Stamp Signature object, class derives from SignImageOptions with ability to specify Background Image. Here's example to add Stamp Signature

### Adding Stamp Signature to Documents

Stamp Signature options are listed in classes **PdfStampSignOptions**, **CellsStampSignOptions**, **Words****StampSignOptions** and **Slides****StampSignOptions** for corresponding document type

**Java Setup Pdf Signature Text Options**

```java
PdfStampSignOptions signOptions = new PdfStampSignOptions();
  
    //Outer round lines
StampLine line0 = new StampLine();
line0.setText(" * European Union * European Union  * European Union  * European Union  * European Union  * ");
line0.getFont().setFontSize(12);
line0.setHeight(22);
line0.setTextBottomIntent(6);
line0.setTextColor(Color.toJava(Color.getWhiteSmoke()));
line0.setBackgroundColor(Color.toJava(Color.getDarkSlateBlue()));
signOptions.getOuterLines().add(line0);
  
StampLine line1 = new StampLine();
line1.setHeight(2);
line1.setBackgroundColor(Color.toJava(Color.getWhite()));
signOptions.getOuterLines().add(line1);
  
StampLine line2 = new StampLine();
line2.setText("* Entrepreneur * Entrepreneur ** Entrepreneur * Entrepreneur *");
line2.setTextColor(Color.toJava(Color.getDarkSlateBlue()));
line2.getFont().setFontSize(15);
line2.setHeight(30);
line2.setTextBottomIntent(8);
line2.getInnerBorder().setColor(Color.toJava(Color.getDarkSlateBlue()));
line2.getOuterBorder().setColor(Color.toJava(Color.getDarkSlateBlue()));
line2.getInnerBorder().setStyle(ExtendedDashStyle.Dot);
signOptions.getOuterLines().add(line2);
  
    //Inner square lines
StampLine line3 = new StampLine();
line3.setText("John");
line3.setTextColor(Color.toJava(Color.getMediumVioletRed()));
line3.getFont().setFontSize(20);
line3.getFont().setBold(true);
line3.setHeight(40);
signOptions.getInnerLines().add(line3);
  
StampLine line4 = new StampLine();
line4.setText("Smith");
line4.setTextColor(Color.toJava(Color.getMediumVioletRed()));
line4.getFont().setFontSize(20);
line4.getFont().setBold(true);
line4.setHeight(40);
signOptions.getInnerLines().add(line4);
  
StampLine line5 = new StampLine();
line5.setText("SSN 1230242424");
line5.setTextColor(Color.toJava(Color.getMediumVioletRed()));
line5.getFont().setFontSize(12);
line5.getFont().setBold(true);
line5.setHeight(40);
signOptions.getInnerLines().add(line5);
  
    // if you need to sign all sheets set it to true
signOptions.setSignAllPages(true);
  
SaveOptions saveOptions =  new SaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setOutputFileName("Pdf_Documents_Stamp");
  
    // sign document
String signedPath = handler.<String>sign("test.pdf", signOptions, saveOptions);
Console.writeLine(StringExtensions.concat("Signed file path is: ",  signedPath));
```

Added new classes **PdfStampSignOptions**, **CellsStampSignOptions**, **WordsStampSignOptions** and **SlidesStampSignOptions** for corresponding document type. Examples demonstrate how to use them with different options properties

[Signing Documents with Stamp Signature]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-stamp-signature.md" >}})
