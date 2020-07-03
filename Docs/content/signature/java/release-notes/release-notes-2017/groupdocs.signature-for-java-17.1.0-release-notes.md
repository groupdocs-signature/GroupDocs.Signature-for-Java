---
id: groupdocs-signature-for-java-17-1-0-release-notes
url: signature/java/groupdocs-signature-for-java-17-1-0-release-notes
title: GroupDocs.Signature for Java 17.1.0 Release Notes
weight: 7
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 17.1.0{{< /alert >}}

## Major Features

This is the first version of new generation GroupDocs.Signature for Java. The most notable features are:

*   Code has been rewritten completely from the ground.
*   Simplified and much flexible API that supports all best GroupDocs products API convention.
*   Better organized and simplified product structure.
*   Code optimization.
*   Ability to customize the input and output data sources
*   Updated License API.
*   UI-less.
*   Designed as native Java library which allow usage in all possible project types.
*   Introduced signature area options Text Signature
*   Introduced Font options for Text Signature
*   Introduced Background options for Text Signature
*   Introduced Border setting for Text Signature
*   Introduced Image Alignment for Image Signature
*   Introduced Image signature Margins on Document Page
*   Introduced Save Format options for different Documents types
*   Improved Validation layer
*   Introduced multiple signature for all signature types Text Signature, Image Signature and Digital Signature
*   Introduced text alignment options Text Signature
*   Introduced margins options Text Signature
*   Introduced ability to sign all pages of Pdf document with Digital Signatures
*   Introduced Pdf Digital Signature alignment on pages
*   Introduced Margins for Pdf Digital Signature with Alignment options
*   Improved validation layer
*   Introduced alternative Text Signature implementation for all supported format Types
*   Introduced Digital Signatures Verification for all supported document formats
*   Introduced Text Signature Verification for Pdf Documents
*   Pdf Text Signature was extended with Text Annotation object and Text as rendered Image on document pages
*   Introduced ability to specify name of output file (relative or absolute)
*   Introduced Image Signature Size Adjustment for Pdf, Slides and Words Documents
*   Introduced opacity of Text Signature for Pdf and Cells Documents
*   Improved Digital Signature Options with ability to pass certificate from Stream object
*   Improved validation layer

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-2347 | Implement Visible flag of Pdf Digital Signature | New Feature |
| SIGNATURENET-2314 | Implement Save Format Options for Slides Documents | New Feature |
| SIGNATURENET-2312 | Implement Save Format Options for Cells Documents | New Feature |
| SIGNATURENET-2310 | Implement Save Format Options for Words Documents | New Feature |
| SIGNATURENET-2305 | Implement Save Format Options for PDF Documents | New Feature |
| SIGNATURENET-2222 | Implement Different Words Save Format Options | New Feature |
| SIGNATURENET-2199 | Implement Image Signature Margins for Slides | New Feature |
| SIGNATURENET-2197 | Implement Image Signature Margins for Cells | New Feature |
| SIGNATURENET-2195 | Implement Image Signature Margins for Words | New Feature |
| SIGNATURENET-2193 | Implement Image Signature Margins for PDF | New Feature |
| SIGNATURENET-2181 | Implement Text Signature Color Options for Slides | New Feature |
| SIGNATURENET-2179 | Implement Text Signature Color Options for Words | New Feature |
| SIGNATURENET-2177 | Implement Text Signature Color Options for Cells | New Feature |
| SIGNATURENET-2175 | Implement Text Signature Color Options for PDF | New Feature |
| SIGNATURENET-2162 | Implement Text Signature Font properties for Slides | New Feature |
| SIGNATURENET-2160 | Implement Text Signature Font properties for Cells | New Feature |
| SIGNATURENET-2158 | Implement Text Signature Font properties for Words | New Feature |
| SIGNATURENET-2156 | Implement Text Signature Font properties for PDF | New Feature |
| SIGNATURENET-2119 | Implement text size options in text signature for Slides documents | New Feature |
| SIGNATURENET-2118 | Implement text size options in text signature for Cells documents | New Feature |
| SIGNATURENET-2117 | Implement text size options in text signature for Words documents | New Feature |
| SIGNATURENET-2116 | Implement text size options in text signature for Pdf documents | New Feature |
| SIGNATURENET-2112 | Add ability to specify color options for text signature | New Feature |
| SIGNATURENET-2109 | Add ability to specify options for saving signed Document | New Feature |
| SIGNATURENET-2092 | Implement Image Signature Alignment for Slides | New Feature |
| SIGNATURENET-2091 | Implement Image Signature Alignment for Words | New Feature |
| SIGNATURENET-2090 | Implement Image Signature Alignment for Cells | New Feature |
| SIGNATURENET-2089 | Implement Image Signature Alignment for PDF | New Feature |
| SIGNATURENET-2372 | Implement ability to sign Slides Documents with given list of Signature Options | New Feature |
| SIGNATURENET-2402 | Implement ability to sign Words Documents with given list of Signature Options | New Feature |
| SIGNATURENET-2397 | Implement ability to sign Cells Documents with given list of Signature Options | New Feature |
| SIGNATURENET-2392 | Implement ability to sign Pdf Documents with given list of Signature Options | New Feature |
| SIGNATURENET-2385 | Implement Digital Signature Alignment for Pdf Documents | New Feature |
| SIGNATURENET-2384 | Implement ability to put Digital Signature on all pages for Pdf Documents | New Feature |
| SIGNATURENET-2374 | Implement Text Signature Margins for Slides Documents | New Feature |
| SIGNATURENET-2372 | Implement Text Signature Margins for Words Documents | New Feature |
| SIGNATURENET-2370 | Implement Text Signature Margins for Cells Documents | New Feature |
| SIGNATURENET-2368 | Implement Text Signature Margins for PDF Documents | New Feature |
| SIGNATURENET-2349 | Add ability to sign files with text signature by given pattern in folder | New Feature |
| SIGNATURENET-2307 | Implement Text Signature alignment for Cells Documents | New Feature |
| SIGNATURENET-2133 | Implement Text Signature alignment for PDF Documents | New Feature |
| SIGNATURENET-2131 | Add ability to sign files with digital signature by given pattern in folder | New Feature |
| SIGNATURENET-2129 | Implement ability to setup output file name for Save Options | New Feature |
| SIGNATURENET-2113 | Implement Unique Identifier of Text Signature for Pdf Documents | New Feature |
| SIGNATURENET-2027 | Provide alternative Text Signature implementation as Image for Words Documents | New Feature |
| SIGNATURENET-2026 | Provide alternative Text Signature implementation as Image for Pdf Documents | New Feature | SIGNATURENET-2499 | Implement ability to check, load and verify digitally signed Cells documents | New Feature | SIGNATURENET-2491 | Implement Text Signature Opacity for Cells Documents | New Feature |
| SIGNATURENET-2486 | Implement Image Signature Size Adjustments for Slides | New Feature |
| SIGNATURENET-2477 | Implement Image Signature Size Adjustments for PDF | New Feature |
| SIGNATURENET-2475 | Update Digital Signature Options with ability to pass Certificate from Stream | Improvement |
| SIGNATURENET-2473 | Improve logic for cells text and image signature position. | Improvement |
| SIGNATURENET-2471 | Provide alternative Text and Image Signature implementation for Open Office format files | Improvement |
| SIGNATURENET-2469 | When signing a password-protected Words file with a digital signature, an exception is thrown | Bug |
| SIGNATURENET-2449 | Fix Words Provider to locate Image Signature on Page Number from Option | Bug |
| SIGNATURENET-2447 | Fix wrong alignment for Words Text Signature | Bug |
| SIGNATURENET-2437 | Text signature for Words is not visible. | Bug |
| SIGNATURENET-2380 | Not able to set PDF/Cells test signature opacity | Bug |
| SIGNATURENET-2378 | Wrong exception's text for wrong password | Bug |
| SIGNATURENET-2190 | Detection of a type of an encrypted cells file starts an inappropriate exception | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 17.1.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Updated public classes for Text Signature Options. a. Class GroupDocs.Signature.Options.PdfSignTextOptions was extended with Font, ForeColor, BorderColor and BackgroundColor properties. b. Class GroupDocs.Signature.Options.WordsSignTextOptions was extended with Font, ForeColor, BorderColor, BackgroundColor, BorderTransparency, BorderWeight and BorderDashStyleBackgroundTransparency properties. c. Class GroupDocs.Signature.Options.CellsSignTextOptions was extended with Font, ForeColor, BorderColor, BackgroundColor, BorderTransparency, BorderWeight and BorderDashStyleBackgroundTransparency properties. d. Class GroupDocs.Signature.Options.SlidesSignTextOptions was extended with Font, ForeColor, BorderColor, BorderWeight and BackgroundColor properties.
2.  Updated public classes for Image Signature Options a. Classes GroupDocs.Signature.Options.PdfSignImageOptions, GroupDocs.Signature.Options.CellsSignImageOptions, GroupDocs.Signature.Options.WordsSignImageOptions, GroupDocs.Signature.Options.SlidesSignImageOptions were extended with VerticalAlignment, HorizontalAlignment and Margin properties.
3.  Ability to save output documents with different file format
4.  The ability to adjust Text Signature appearance
5.  The ability to adjust Image Signature appearance
6.  Updated public classes for Text Signature Options (PdfTextSignatuteOptions, CellsTextSignatuteOptions, WordsTextSignatuteOptions and SlidesTextSignatuteOptions) were extended with VerticalAlignment, HorizontalAlignment and Margins properties
7.  Added new class SignatureOptionsCollection to keep collection of Signature Options
8.  Updated Pdf Digital Options - class was extended with Horizontal and Vertical Alignment
9.  Ability to sign document with multiple signature options
10.  Updated public classes for Text Signature Options (PdfTextSignatuteOptions, CellsTextSignatuteOptions, WordsTextSignatuteOptions and SlidesTextSignatuteOptions). Text Signature Options classes were extended with Signature Implementation enumeration types per each Document Types, like PdfTextSignatureImplementation, CellsTextSignatureImplementation, WordsTextSignatureImplementation and SlidesTextSignatureImplementation.
11.  Added new class SignatureAppearance that describes extended settings for specific signature implementation. Added derived classes like PdfTextAnnotationAppearance that describes additional appearance options for PdfTextSignatureImplementation.TextAnnotation enumeration type. 
12.  Added new classes for verification options: VerifyOptions, VerifyTextOptions, VerifyDigitalOptions, PdfVerifyTextOptions, PdfVerifyDigitalOptions, CellsVerifyDigitalOptions, WordsVerifyDigitalOptions, SlidesVerifyDigitalOptions.
13.  Save signed file with different file name
14.  Verification PDF Documents signed with Text Signature
15.  Verification Cells Documents signed with digital certificates
16.  Verification PDF Documents signed with digital certificates
17.  Verification Slides Documents signed with digital certificates (This feature will be provided in next release of the API)
18.  Verification Words Documents signed with digital certificates
