---
id: groupdocs-signature-for-java-17-4-0-release-notes
url: signature/java/groupdocs-signature-for-java-17-4-0-release-notes
title: GroupDocs.Signature for Java 17.4.0 Release Notes
weight: 6
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 17.2.0, 17.3.0, 17.4.0{{< /alert >}}

## Major Features

The most notable features are:

*   Introduced alternative Text Signature Sticker implementation for Pdf Document
*   Introduced Text Signature Adjustments for all supported document formats
*   Introduced Rotation options for Text Signature for all supported Document types
*   Improved Alignment algorithms for Text and Image Signature formats
*   Introduced Rotation options for Image Signature for all supported Document types
*   Improved Image Signature Size Adjustment for all Document Types
*   Improved Opacity Implementation for Text Signature for Pdf Documents
*   Involved Dynabic Metered features
*   Improved validation layer
*   Introduced Image Appearance of Digital Signature for Words and Cells Documents
*   Involved Text Signature Verification for Words, Cells and Slides Documents
*   Improved alternative Pdf Text Sticker default appearance
*   Implemented Image Signature Opacity for Words document
*   Involved Image Opacity feature for Digital Signature for Pdf Documents
*   Introduced ability to setup specified (like First, Last, Odd, Even) or arbitrary pages of Document for all Signature Types for all supported Document Types
*   Introduced ability to verify specified (like First, Last, Odd, Even) or arbitrary pages of Document of supported Signature Verification types
*   Improved properties of Image Signature - added ability to specify source of Image from guid or stream
*   Improved validation layer
*   Improved working with Digital Certificates through properties of Digital Signature Options
*   Introduced Image Appearance for Text Signature for Pdf, Slides, Words and Cells Documents
*   Improved rendering Image from Text property for Text Signature for all document types
*   Introduced Image Appearance for Image Signatures for all document types
*   Implemented gray scale filter for Image Appearance and Text as Image Appearance for all supported document types
*   Introduced ability to save signed Documents with password
*   Introduced ability to remove or change password protection of signed Documents
*   Implemented brightness and contrast filters for Image Appearance
*   Involved ability to hide Digital Signature on Pdf Documents
*   Implemented Strike Out Font property for Text Signature
*   Fixed Excel files saving issues with formatting

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-2568 | Integrate Dynabic.Metered features | New Feature |
| SIGNATURENET-2605 | Implement Text Signature Size Adjustments for Slides | New Feature |
| SIGNATURENET-2603 | Implement Text Signature Size Adjustments for Words | New Feature |
| SIGNATURENET-2601 | Implement Text Signature Size Adjustments for Cells | New Feature |
| SIGNATURENET-2598 | Implement Text Signature Size Adjustments for PDF | New Feature |
| SIGNATURENET-2593 | Implement extended properties for Text Stamp Implementation signature of Pdf Documents | New Feature |
| SIGNATURENET-2581 | Implement Text Signature Opacity for Words Documents | New Feature |
| SIGNATURENET-2579 | Implement Text Signature Opacity for Slides Documents | New Feature |
| SIGNATURENET-2569 | Implement verification for Pdf Text Sticker Annotation Signature | New Feature |
| SIGNATURENET-2564 | Implement alternative Text Signature implementation as Sticker (TextAnnotation) for Pdf Documents | New Feature |
| SIGNATURENET-2217 | Implement Image Signature free angle rotation for Slides | New Feature |
| SIGNATURENET-2215 | Implement Image Signature free angle rotation for Words | New Feature |
| SIGNATURENET-2213 | Implement Image Signature free angle rotation for Cells | New Feature |
| SIGNATURENET-2211 | Implement Image Signature free angle rotation for PDF | New Feature |
| SIGNATURENET-2188 | Implement Image Signature Size Adjustments for Cells | New Feature |
| SIGNATURENET-2142 | Implement Image Signature rotation for Slides | New Feature |
| SIGNATURENET-2140 | Implement Image Signature rotation for Cells | New Feature |
| SIGNATURENET-2138 | Implement Image Signature rotation for Words | New Feature |
| SIGNATURENET-2136 | Implement Image Signature rotation for PDF | New Feature |
| SIGNATURENET-2126 | Implement Text Signature rotation for Slides | New Feature |
| SIGNATURENET-2124 | Implement Text Signature rotation for Cells | New Feature |
| SIGNATURENET-2122 | Implement Text Signature rotation for Words | New Feature |
| SIGNATURENET-2120 | Implement Text Signature rotation for Pdf | New Feature |
| SIGNATURENET-2607 | Multiple signature options for Words Documents are intersecting in same Word Node | Bug |
| SIGNATURENET-2589 | When processing Pdf document with Digital Signature in iterative mode document saved incorrectly | Bug |
| SIGNATURENET-2571 | Apply lower case for output file extension | Bug |
| SIGNATURENET-2556 | Fix background appearance of Text Annotation of Pdf Documents Pages | Bug |
| SIGNATURENET-2547 | Pdf Text Verification doesn't get list of Annotations from Pdf Document | Bug |
| SIGNATURENET-2706 | Improve Digital Certificate Helper class to release disposable objects | Improvement |
| SIGNATURENET-2705 | Pdf internal resources do not work properly after using Text Sticker default appearance object | Bug |
| SIGNATURENET-2702 | Implement Text Signature Verification for Slides Documents | New Feature |
| SIGNATURENET-2700 | Implement Text Signature Verification for Word Documents | New Feature |
| SIGNATURENET-2691 | Implement Image appearance of Digital Signatures for Cells Documents | New Feature |
| SIGNATURENET-2688 | Implement Image appearance of Digital Signatures for Words Documents | New Feature |
| SIGNATURENET-2670 | Implement Image Signature Opacity for Words Documents | New Feature |
| SIGNATURENET-2665 | Implement Digital Signature Opacity for PDF Documents | New Feature |
| SIGNATURENET-2662 | Implement ability to put Text Signature on user specified Document Pages (first, last, even, odd and arbitrary pages list) for Cells Documents | New Feature |
| SIGNATURENET-2659 | Implement ability to put Digital Signature on user specified Document Pages (first, last, even, odd and arbitrary pages list) for Pdf Documents | New Feature |
| SIGNATURENET-2656 | Implement ability to put Image Signature on user specified Document Pages (first, last, even, odd and arbitrary pages list) for Pdf Documents | New Feature |
| SIGNATURENET-2650 | Implement ability to put Text Signature on user specified Document Pages (first, last, even, odd and arbitrary pages list) for Pdf Documents | New Feature |
| SIGNATURENET-2629 | Implement Image Signature Opacity for Slides Documents | New Feature |
| SIGNATURENET-2626 | Implement Image Signature Opacity for Cells Documents | New Feature |
| SIGNATURENET-2624 | Implement Image Signature Opacity for PDF Documents | New Feature |
| SIGNATURENET-2488 | Implement Text Signature Verification for Cells Documents | New Feature |
| SIGNATURENET-2764 | Implement alternative Appearance features of Image Signature for Words Documents | New Feature |
| SIGNATURENET-2761 | Implement alternative Appearance features of Image Signature for Slides Documents | New Feature |
| SIGNATURENET-2758 | Implement alternative Appearance features of Image Signature for Cells Documents | New Feature |
| SIGNATURENET-2741 | Implement alternative Appearance features of Image Signature for Pdf Documents | New Feature |
| SIGNATURENET-2357 | Implement password protection for signed Slides Documents | New Feature |
| SIGNATURENET-2355 | Implement password protection for signed Words Documents | New Feature |
| SIGNATURENET-2353 | Implement password protection for signed Cells Documents | New Feature |
| SIGNATURENET-2351 | Implement password protection for signed Pdf Documents | New Feature |
| SIGNATURENET-2350 | Implement ability to protect signed document with password | New Feature |
| SIGNATURENET-2347 | Implement Visible flag of Pdf Digital Signature | New Feature |
| SIGNATURENET-2595 | Implement Font StrikeOut property for all Text Signature Implementation for supported Document Types | Improvement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 17.4.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Added new public interfaces. IRectangle interface describes Signature Area with Left, Top, Width and Height. IAlignment interface describes Alignment and Margins of Signature Area. IRotation interface describes Rotation property of Signature Area. IOpacity interface describes opacity value for Signature appearance Existing Signature Options like SignTextOptions, SignImageOptions and SignDigitalOptions implement these interfaces. 
2.  Added new enumeration type for Pdf Signature Implementation - Sticker. For Pdf Sticker Implementation new class PdfTextStickerAppearance was added to describe additional properties of Sticker area appearance on page. Added new enumeration types PdfTextStickerIcon to describes available values for Pdf Text Sticker Icon Appearance and PdfTextStickerState to describe initial state of Sticker on page.
3.  Updated public classes for Pdf Text Signature Verifications to verify Stamp, Sticker and [TextAnnotation]({{< ref "signature/java/developer-guide/advanced-usage/verifying/verify-text-signatures.md" >}}) implementation separately
4.  Base class for Text Signature SignTextOptions was extended with Location and Size Adjustment features. New properties LocationMeasureType and SizeMeasureType describe ability to specify position of signature area in pixel or in percents per page size
5.  [Sign Pdf Documents with Text Signature As Sticker]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-text-signature.md" >}})
6.  [Add Rotation to Text Signature appearance]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-text-signature.md" >}})
7.  [Add Transparency and Rotation to Text Signature appearance]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-text-signature.md" >}})
8.  [Add Rotation to Image Signature appearance]({{< ref "signature/java/developer-guide/advanced-usage/signing/sign-document-with-image-signature-advanced.md" >}})
9.  Added new public class PagesSetup to specify arbitrary pages of Document for processing signature or verification. This class allows to specify First, Last, Odd, Even pages or arbitrary pages added to List of Page numbers. Here is an example of using this feature [Sign arbitrary pages of document]({{< ref "signature/java/developer-guide/advanced-usage/signing/sign-document-with-image-signature-advanced.md" >}})
10.  Added new Text Signature Verification classes for Cells Documents CellsVerifyTextOptions, Words Documents WordsVerifyTextOptions, Slides Documents SlidesVerifyTextOptions. These classes allow user to pass verification options object for required Document Type to find Text Signature with given Text. 
11.  [Verification documents signed with text signature ]({{< ref "signature/java/developer-guide/advanced-usage/verifying/verify-text-signatures.md" >}})
12.  Extended CellsSignDigitalOptions class with ability to specify Signature Image appearance on Document, added overloaded constructors to specify Certificate source over guid or stream. You can check updated example with newly supported features here [Signing documents with digital certificates]({{< ref "signature/java/developer-guide/basic-usage/electronic-signature-types/esign-document-with-digital-signature.md" >}})
13.  Added Opacity property for Image Signature for all supported types
14.  SignImageOptions class was updated with new properties ImageGuid and ImageStream to replace old properties ImageFileName. ImageFileName property of SignImageOptions is marked as Obsolete Method SetImage also marked as Obsolete due to similar functionality of ImageGuid property
15.  SignDigitalOptions class was extended with new properties CertificateGuid and CertificateStream.  Added few overloaded constructors with combination of source for digital certificate and image appearance
16.  Updated XML comments of public API methods and classes with more detailed information
17.  Added new public class ImageAppearance to specify extended properties for Image Signatures. This class contains properties to specify Gray scale filter, Brightness, Contrast and Gamma filters. When signing Document with Image Signature options assign instance of ImageAppearance to Appearance property of options. Also ImageAppearance can be applied for Text Signature with TextAsImage Implementation selection.
18.  Introduced password protection saving. SaveOptions class was extended with Password string property to specify output password for signed document and UseOriginalPassword Boolean property to specify if original password of document should not be changed.
19.  Following example shows how to manipulate password with SaveOptions [Work with password protected documents]({{< ref "signature/java/developer-guide/advanced-usage/loading/load-password-protected-document.md" >}})
20.  Updated XML comments of public API methods and classes with more detailed information
