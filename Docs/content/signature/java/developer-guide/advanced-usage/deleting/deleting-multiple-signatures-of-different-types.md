---
id: deleting-multiple-signatures-of-different-types
url: signature/java/deleting-multiple-signatures-of-different-types
title: Deleting multiple signatures of different types
weight: 3
description: "This article shows how to delete multiple electronic signatures different ways with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides different classes of signatures to manipulate and delete them from the documents over [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature))  method.

Please be aware that [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature))  method modifies the same document that was passed to constructor of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class. This method returns [DeleteResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/DeleteResult) object that contains list of successfully updated signatures and ones that failed. The signature could be failed to delete due to several reasons:

*   if signature object was initialized with constructor by incorrect signature identifier;
*   if signature object was not found;
*   there was an error occurred while deleting signature in the document;
*   the signature type is not supported for deletion for current version (for version 19.12 these signatures are Digital, Form Field or Metadata signature).

Here are the steps to delete multiple signature in the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;
    
*   Instantiate one or several Search options with desired properties;
    
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method and pass created list of Search Options to obtain list of [BaseSignatures](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/BaseSignature);  
    
*   Select from list [BaseSignatures](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/BaseSignature) object(s) that should be deleted;  
    
*   Call [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) object [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method and pass one or several signatures to it.
    
*   Analyze [DeleteResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/DeleteResult) result to check whether signatures were updated or not.

## Delete multiple signatures in the document

This example shows how to delete multiple signatures that was found using  [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method.

```java
// initialize Signature instance
Signature signature = new Signature("signed.docx")
 
// define few search options
BarcodeSearchOptions barcodeOptions = new BarcodeSearchOptions();
QrCodeSearchOptions qrCodeOptions = new QrCodeSearchOptions();
// add options to list
List<SearchOptions> listOptions = new ArrayList<SearchOptions>();
listOptions.add(barcodeOptions);
listOptions.add(qrCodeOptions);
 
// search for signatures in document
SearchResult result = signature.search(listOptions);
if (result.getSignatures().size() > 0)
{
    System.out.print("Trying to delete signatures...");
    List<BaseSignature> signaturesToDelete = new ArrayList<BaseSignature>();
    // collect image signatures to delete
    for (BaseSignature temp : result.getSignatures())
    {
        signaturesToDelete.add(temp);
    }
    // delete signatures
    DeleteResult deleteResult = signature.delete("signed.docx",signaturesToDelete);
    if (deleteResult.getSucceeded().size() == signaturesToDelete.size())
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
}
else
{
    System.out.print("No one signature was found.");
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
