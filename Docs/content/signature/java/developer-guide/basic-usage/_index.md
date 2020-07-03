---
id: basic-usage
url: signature/java/basic-usage
title: Basic usage
weight: 1
description: "Quick Start section about main features of GroupDocs.Signature API, describes how to sign documents with just couple lines of code."
keywords: GroupDocs.Signature Quick Start, GroupDocs.Signature .NET Basic Usage, GroupDocs.Signature Quick Start C#, GroupDocs.Signature Get Started
productName: GroupDocs.Signature for Java
hideChildren: False
---  
[**GroupDocs Signature**](https://products.groupdocs.com/signature/java) library provides ability to manipulate with different electronic signature types such as Text, Image, Digital, Barcode, QR-code, Stamp, Form Field, Metadata. These e-signatures could be added to document, updated, deleted, verified or searched inside already signed documents. Our product also provides information about document type and structure - file type, size, pages count, etc. and generates document pages preview based on provided options.  

Here are main GroupDocs Signature API concepts:

*   [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) is the main class that contains all required methods for manipulating with document e-signatures.    
*   Most part of methods expects different options to eSign document, verify and search electronic signatures inside document.
    

## Referencing required namespaces

The following code shows how to include required namespace for all code examples.  

```java
import com.groupdocs.signature;
import com.groupdocs.signature.domain;
import com.groupdocs.signature.options;
import com.groupdocs.signature.domain.extensions;
```

  

## Signature object definition

The following code shows most used code pattern to define [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) object and call its methods.

```java
// Sign document with text signature.
try
{
   Signature signature = new Signature("sample.docx")
   TextSignOptions textSignOptions = new TextSignOptions("John Smith");
   signature.sign("SampleSigned.docx", textSignOptions);
}catch (Exception e){
    throw  new GroupDocsSignatureException(e.getMessage());
}

```

Please check detailed examples of how to eSign documents, search and verify document signatures in the following guides:
