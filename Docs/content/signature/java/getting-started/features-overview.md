---
id: features-overview
url: signature/java/features-overview
title: Features Overview
weight: 1
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
## Sign document

Document signatures could be created and added to the document via collection of different options that specify all possible visualization features – color settings, alignment, font, margins, padding and different styling.   
Following signature types are supported: 

*   Native text signatures as text stamps, text labels with big amount of settings for visualization effects, opacity, colors, fonts, etc.;
*   Text as image signatures with big scope of additional options to specify how text will look, colors, and extra image effects;
*   Image signatures with options to specify extra image effects, rotation etc.;
*   Digital signatures based on certificate files and ability to support digital signature by document type (PDF, Spreadsheet, Word Processing documents);
*   Barcode/qr-code signatures with variety of options;
*   Metadata signatures to keep hidden signatures inside the document;
*   Form-field signatures.

## Search for signatures

Obtain signatures list applied to document:

*   Digital signatures information from PDF, Spreadsheet, Word Processing documents;
*   Barcode/QR-code signatures information from all supported formats;
*   Metadata signatures information from all supported formats;
*   Form-field signatures information from all supported formats.

## Verify signatures

Determine whether document contains signatures that meet the specified criteria.   
Supported signature types are: 

*   Digital signatures;
*   Barcode/QR-code signatures;
*   Metadata signatures;
*   Form-field signatures.

## Document information extraction

GroupDocs.Signature allows to obtain basic information about source document - file type, size, pages count, page height and width etc. This may be quite useful for generating document preview and precise signature placing inside document.

## Preview document pages

Document preview feature allows to generate image representations of document pages. This may be helpful for better understanding about document content and its structure, set proper signature position inside document, apply appropriate signature styling etc. Preview can be generated for all document pages (by default) or for specific page numbers or page range.

Supported image formats for document preview are:
*   PNG;
*   JPG;
*   BMP.
