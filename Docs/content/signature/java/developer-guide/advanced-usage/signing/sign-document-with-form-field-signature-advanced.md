---
id: sign-document-with-form-field-signature-advanced
url: signature/java/sign-document-with-form-field-signature-advanced
title: Sign document with Form Field signature - advanced
weight: 8
description: " This article explains how to sign document with Form field electronic signatures using advanced options with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
GroupDocs.Signature provides [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions) class to specify different options for Form Field signature. The Form Field signature is special document predefined input field control with unique name inside the document content that expects some input from user.

At the moment GroupDocs.Siganture supports creation of Form Field signatures for Pdf documents only.

The [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions) class contains one [FormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions) object to put to the document.

Here are the list of different Form Field signature classes that could be set to [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions)

*   [TextFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/TextFormFieldSignature) - represents text input form field on document page. 
*   [CheckboxFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/CheckboxFormFieldSignature) - represents check box field on the document page.
*   [DigitalFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/DigitalFormFieldSignature) - represents digital signature input form on document page.  
    

Here are the steps to add Form Field signatures into document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.    
*   Instantiate the [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions) object according to your requirements.    
*   Instantiate one of the derived classes from [FormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/FormFieldSignature) object. It could be [TextFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/TextFormFieldSignature), [CheckboxFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/CheckboxFormFieldSignature) or [DigitalFormFieldSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures.formfield/DigitalFormFieldSignature).    
*   Set FormFieldSignOptions.[setSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions#setSignature(com.groupdocs.signature.domain.signatures.formfield.FormFieldSignature)) property with created object.      
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of  [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [FormFieldSignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/FormFieldSignOptions) to it.       
*   Analyze [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult) result to check newly created signatures if needed.

  

## Sign Pdf document with  Form Field signature  

This example shows how to add Form Field signature to document. See [SignResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/SignResult)  

```java
Signature signature = new Signature("sample.pdf");
 
List<SignOptions> listOptions = new ArrayList<SignOptions>();
 
// instantiate text form field signature
FormFieldSignature textSignature = new TextFormFieldSignature("tbData1", "Value-1");
// instantiate options based on text form field signature
FormFieldSignOptions optionsTextFF = new FormFieldSignOptions(textSignature);
optionsTextFF.setHorizontalAlignment(HorizontalAlignment.Left);
optionsTextFF.setVerticalAlignment(VerticalAlignment.Top);
optionsTextFF.setMargin(new Padding(10, 20, 0, 0));
optionsTextFF.setHeight(10);
optionsTextFF.setWidth(100);            
 
// instantiate text form field signature
CheckboxFormFieldSignature chbSignature = new CheckboxFormFieldSignature("chbData1", true);
// instantiate options based on text form field signature
FormFieldSignOptions optionsTextCHB = new FormFieldSignOptions(chbSignature) ;           
optionsTextCHB.setHorizontalAlignment(HorizontalAlignment.Center);
optionsTextCHB.setVerticalAlignment(VerticalAlignment.Top);
optionsTextCHB.setMargin(new Padding(0, 0, 0, 0));
optionsTextCHB.setHeight(10);
optionsTextCHB.setWidth(100);    
 
// instantiate text form field signature
DigitalFormFieldSignature digSignature = new DigitalFormFieldSignature("dgData1");
// instantiate options based on text form field signature
FormFieldSignOptions optionsTextDIG = new FormFieldSignOptions(digSignature);           
optionsTextDIG.setHorizontalAlignment(HorizontalAlignment.Right);
optionsTextDIG.setVerticalAlignment(VerticalAlignment.Top);
optionsTextDIG.setMargin(new Padding(0, 50, 0, 0));
optionsTextDIG.setHeight(10);
optionsTextDIG.setWidth(100);            
 
listOptions.add(optionsTextFF);
listOptions.add(optionsTextCHB);
listOptions.add(optionsTextDIG);
 
// sign document to file
SignResult signResult = signature.sign("signedSample.pdf", listOptions);
// analyzing result
System.out.print("List of newly created signatures:");
int number = 1;
for(BaseSignature temp : signResult.getSucceeded())
{
    System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
            ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
}
```

## More resources

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
