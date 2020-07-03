---
id: deleting-image-signatures-advanced
url: signature/java/deleting-image-signatures-advanced
title: Deleting Image signatures - advanced
weight: 2
description: "This article shows how to delete Image electronic signatures different ways with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [ImageSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/ImageSignature) class to manipulate image signatures and delete them from the documents over [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method.  
Please be aware that [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature))  method modifies the same document that was passed to constructor of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class.

Here are the steps to delete Image signature from the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;
    
*   Instantiate [ImageSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/ImageSearchOptions) object with desired properties;
    
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method to obtain list of [ImageSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/ImageSignature);  
    
*   Select from list [ImageSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/ImageSignature) object(s) that should be removed from the document;  
    
*   Call [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) object [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature))  method and pass one or several signatures to it.
    
*   Analyze [DeleteResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/DeleteResult) result to check whether signatures were updated or not.

Here are the alternative steps to delete Image signature from the document with GroupDocs.Signature. This approach is based on saved signatures Id after [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) or [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) methods.

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;
    
*   Instantiate one or several [ImageSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/ImageSignature) objects with signature Id(s) passed to constructor;  
    
*   Call [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class object [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature))  method and pass one or several signatures to it;
    
*   Analyze [DeleteResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/DeleteResult) result to check whether signatures were updated or not. 

## Delete Image signature from the document after Search

This example shows how to delete Image signature that was found using [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method.

```java
// initialize Signature instance
Signature signature = new Signature("signed.docx");
ImageSearchOptions options = new ImageSearchOptions();
 
List<ImageSignature> signatures = signature.search(ImageSignature.class, options);
List<BaseSignature> signaturesToDelete = new ArrayList<BaseSignature>();
// collect signatures to delete
for (ImageSignature temp : signatures)
{
    if (temp.getSize() > 10000)
    {
        signaturesToDelete.add(temp);
    }
}
// delete signatures
DeleteResult deleteResult = signature.delete("signed.docx",signaturesToDelete);
if (deleteResult.getSucceeded().size() == signaturesToDelete.size())
{
    System.out.print("All signatures were successfully deleted!");
}
else
{
    System.out.print("Successfully deleted signatures : "+deleteResult.getSucceeded().size());
    System.out.print("Not deleted signatures : "+deleteResult.getFailed().size());
}
System.out.print("List of deleted signatures:");
for(BaseSignature temp : deleteResult.getSucceeded())
{
    System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
}
```

## Delete Image signature from the document by known signature Identifier

This example shows how to delete Image signature in the document by known signature Id (that was obtained by  [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) or [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method previously).

```java
// initialize Signature instance
Signature signature = new Signature("signed.docx");
// read from some data source signature Id value
String[] signatureIdList = new String[]
        {
                "1a5fbc08-4b96-43d9-b650-578b16fbb877",
                "1d4cf995-3150-47a0-b17a-44c17ecf7279"
        };
// create list of Image Signature by known SignatureId
List<BaseSignature> signatures = new ArrayList<BaseSignature>();
for (String item : signatureIdList)
{
    signatures.add(new ImageSignature(item));
}
// delete required signatures
DeleteResult deleteResult = signature.delete("signed.docx",signatures);
if (deleteResult.getSucceeded().size() == signatures.size())
{
    System.out.print("All signatures were successfully deleted!");
}
else
{
    System.out.print("Successfully deleted signatures : " + deleteResult.getSucceeded().size());
    System.out.print("Not deleted signatures : " + deleteResult.getFailed().size());
}
System.out.print("List of deleted signatures:");
for(BaseSignature temp : deleteResult.getSucceeded())
{
    System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
}
```

## More resources

GitHub Examples 

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
