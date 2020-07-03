---
id: esign-document-with-form-field-signature
url: signature/java/esign-document-with-form-field-signature
title: eSign document with Form Field signature
weight: 3
description: "This article explains how to add various types of Form Field signatures on document page with options on component positioning, alignment and other visual options with GroupDocs.Signature"
keywords: form fields
productName: GroupDocs.Signature for Java
hideChildren: False
---
## What is a Form Field?

A **form field** is the interactive element located on document page that allows user data input through various control types like free input text box, multi-line text box, check boxes, drop down lists etc. Different document types support specific list of form field types. These elements are used to collect information from user on template form. Each Form Field element has an unique name, settings and value field. Form Fields should have unique names within the form. Picture below demonstrates possible document page with form fields.

![](signature/java/images/esign-document-with-form-field-signature.png)

## How to eSign document with Form Field signature

[GroupDocs.Signature](https://products.groupdocs.com/signature/java) for Java supports creation of new form fields or update existing ones within the documents. Class [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions) specifies different options for Form Field signature.   
The [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions)  class contains one [FormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/FormFieldSignature) object to put to the document.  
Here are the list of different Form Field signature classes that could be set to [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/FormFieldSignature) 

*   [TextFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/TextFormFieldSignature) - represents text input form field on document page.      
*   [CheckboxFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/CheckboxFormFieldSignature) - represents check box field on the document page.
*   [DigitalFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/DigitalFormFieldSignature) - represents digital signature input form on document page. 

Here are the steps to add Form Field signatures into document with GroupDocs.Signature:
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;
*   Instantiate the [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions) object according to your requirements;    
*   Instantiate one of the objects  - [TextFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/TextFormFieldSignature), [CheckboxFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/CheckboxFormFieldSignature) or [DigitalFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/DigitalFormFieldSignature);    
*   Set [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions) Signature property with created object;      
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions))  method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions) to it.    

*NOTE: At the moment GroupDocs.Signature supports creation of Form Field signatures for PDF documents only.*

This example shows how to sign PDF document with Form Field electronic signature on document page. 

```java
Signature signature = new Signature("sample.pdf");

// instantiate text form field signature
FormFieldSignature textSignature = new TextFormFieldSignature("FieldText", "Value1");
// instantiate options based on text form field signature
FormFieldSignOptions options = new FormFieldSignOptions(textSignature);

options.setHorizontalAlignment(HorizontalAlignment.Left);
options.setVerticalAlignment(VerticalAlignment.Top);
options.setMargin(new Padding(10, 20, 0, 0));
options.setHeight(10);
options.setWidth(100);

// sign document to file
signature.sign("signed.pdf", options);
```

## More resources

### Advanced Usage Topics

To learn more about document eSign features, please refer to the [advanced usage section]({{< ref "signature/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub Examples 

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Signature for .NET examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET)    
*   [GroupDocs.Signature for Java examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java)    
*   [Document Signature for .NET MVC UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-MVC)    
*   [Document Signature for .NET App WebForms UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-WebForms)    
*   [Document Signature for Java App Dropwizard UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Dropwizard)   
*   [Document Signature for Java Spring UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Spring)
    

### Free Online App 

Along with full-featured .NET library we provide simple, but powerful free Apps.  
You are welcome to eSign PDF, Word, Excel, PowerPoint documents with free to use online **[GroupDocs Signature App](https://products.groupdocs.app/signature)**.
