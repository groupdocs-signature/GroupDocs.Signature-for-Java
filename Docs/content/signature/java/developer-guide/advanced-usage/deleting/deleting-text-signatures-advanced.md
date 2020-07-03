---
id: deleting-text-signatures-advanced
url: signature/java/deleting-text-signatures-advanced
title: Deleting Text signatures - advanced
weight: 5
description: "This article shows how to delete Text electronic signatures different ways with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [TextSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/TextSignature) class to manipulate text signatures and delete them from the documents over [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method.  
Please be aware that [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method modifies the same document that was passed to constructor of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class.

Here are the steps to delete Text signature from the document with GroupDocs.Signature:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;
    
*   Instantiate [TextSearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/TextSearchOptions) object with desired properties;
    
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method to obtain list of [TextSignatures](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/TextSignature);  
    
*   Select from list [TextSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/TextSignature) object(s) that should be removed from the document;  
    
*   Call [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) object [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature)) method and pass one or several signatures to it.
    
*   Analyze [DeleteResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/DeleteResult) result to check whether signatures were updated or not.

Here are the alternative steps to delete Text signature from the document with GroupDocs.Signature. This approach is based on saved signatures Id after [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) or [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) methods.

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter;
    
*   Instantiate one or several [TextSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain.signatures/TextSignature) objects with signature Id(s) passed to constructor;  
    
*   Call [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class object [delete](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#delete(java.io.OutputStream,%20com.groupdocs.signature.domain.signatures.BaseSignature))  method and pass one or several signatures to it;
    
*   Analyze [DeleteResult](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.domain/DeleteResult) result to check whether signatures were updated or not. 

## Delete Text signature from the document after Search

This example shows how to delete Text signature that was found using [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method.

```java
// initialize Signature instance
Signature signature = new Signature("signed.pdf");
 
TextSearchOptions options = new TextSearchOptions();
 
List<TextSignature> signatures = signature.search(TextSignature.class,options);
List<BaseSignature> signaturesToDelete = new ArrayList<BaseSignature>();
// collect signatures to delete
for (TextSignature temp : signatures)
{
    if (temp.getText().contains("JS"))
    {
        signaturesToDelete.add(temp);
    }
}
// delete signatures
DeleteResult deleteResult = signature.delete("signed.pdf", signaturesToDelete);
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
```

## Delete Text signature from the document by known signature Identifier

This example shows how to delete Text signature in the document by known signature Id (that was obtained by  [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) or [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method previously).

```java
// initialize Signature instance
using (Signature signature = new Signature("signed.xlsx"))
{
    // read from some data source signature Id value
    string[] signatureIdList = new string[]
    {
        "1dd21cf3-b904-4da9-9413-1ff1dab51974",
        "9e386726-a773-4971-b2fc-eaadfce65ffd"
    };
    // create list of Text Signature by known SignatureId
    List<BaseSignature> signatures = new List<BaseSignature>();
    signatureIdList.ToList().ForEach(p => signatures.Add(new TextSignature(p)));
    // delete required signatures
    DeleteResult deleteResult = signature.Delete(signatures);
    if (deleteResult.Succeeded.Count == signatures.Count)
    {
        Console.WriteLine("All signatures were successfully deleted!");
    }
    else
    {
        Console.WriteLine($"Successfully deleted signatures : {deleteResult.Succeeded.Count}");
        Console.WriteLine($"Not deleted signatures : {deleteResult.Failed.Count}");
    }
    Console.WriteLine("List of deleted signatures:");
    foreach (BaseSignature temp in deleteResult.Succeeded)
    {
        Console.WriteLine($"Signature# Id:{temp.SignatureId}, Location: {temp.Left}x{temp.Top}. Size: {temp.Width}x{temp.Height}");
    }
}
// initialize Signature instance
Signature signature = new Signature("signed.xlsx");        
// read from some data source signature Id value        
String[] signatureIdList = new String[]
        {
                "a6fec431-111e-4572-950c-5cc5f1c85d36",
                "b0123987-b0d4-4004-86ec-30ab5c41ac7e"
        };
// create list of Text Signature by known SignatureId
List<BaseSignature> signatures = new ArrayList<BaseSignature>();
for (String item : signatureIdList)
{
    signatures.add(new TextSignature(item));
}
 
// delete required signatures
DeleteResult deleteResult = signature.delete("signed.xlsx", signatures);
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
