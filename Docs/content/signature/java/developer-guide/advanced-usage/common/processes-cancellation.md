---
id: processes-cancellation
url: signature/java/processes-cancellation
title: Processes cancellation
weight: 3
description: "This article explains how to control signature processing (cancellation) for large documents with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class supports cancellation for each of document processing (Sign, Verify, Search). The process cancellation happens over setting property [getCancel](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.handler.events/ProcessProgressEventArgs#getCancel()) of [ProcessProgressEventArgs](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.handler.events/ProcessProgressEventArgs) property in proper event handler.

*   for [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) process this flag should be set to true in handler of [SignProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SignProgress) event. This event occurs each time on signing each signature was completed.
*   for [verify](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#verify(com.groupdocs.signature.options.verify.VerifyOptions)) process this flag should be set to true in handler of [VerifyProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#VerifyProgress) event. This event occurs each time on verifying document page.
*   for [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) process this flag should be set to true in handler of [SearchProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SearchProgress) event. This event occurs each time on searching document page per each options.  

## Cancel signing process

Here are the steps to provide cancellation for signing process with GroupDocs.Signature:

*   Define [SignProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SignProgress) event handler delegates to conditionally cancel the process.
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Subscribe for [SignProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SignProgress) event with proper handler method
*   Instantiate required [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) object 
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass signature options in it
   
    

```java
private static void onSignProgress(Signature sender, ProcessProgressEventArgs args) {
    // check if process takes more than 1 second (1000 milliseconds) processing cancellation
    if (args.getTicks() > 1000) {
        args.setCancel(true);
        System.out.print("Sign progress was cancelled. Time spent " + args.getTicks() + " mlsec");
    }
}
 
public static void run() {   
    try {
        Signature signature = new Signature("Sample.pdf");
        signature.SignProgress.add(new ProcessProgressEventHandler() {
            public void invoke(Signature sender, ProcessProgressEventArgs args) {
                onSignProgress(sender, args);
            }
        });
 
        TextSignOptions options = new TextSignOptions("John Smith") {
            // ...
        };
 
        // sign document to file
        signature.sign("Signed.pdf", options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
 
    } catch (Exception e) {
        throw new GroupDocsSignatureException(e.getMessage());
    }
}
```

## Cancel verification process

Here are the steps to provide cancellation for verification process with GroupDocs.Signature:

*   Define [VerifyProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#VerifyProgress) event handler delegates to conditionally cancel the process.    
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Subscribe for [VerifyProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#VerifyProgress) event with proper handler method      
*   Instantiate required [VerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/VerifyOptions)  object       
*   Call [verify](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#verify(com.groupdocs.signature.options.verify.VerifyOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass verification options in it.
    

```java
private static void onVerifyProgress(Signature sender, ProcessProgressEventArgs args) {
    // check if process takes more than 1 second (1000 milliseconds) processing cancellation
    if (args.getTicks() > 1000) {
        args.setCancel(true);
        System.out.print("Verify progress was cancelled. Time spent " + args.getTicks() + " mlsec");
    }
}
 
public static void run() {   
 
    try {
        Signature signature = new Signature("SampleSigned.pdf");
        signature.VerifyProgress.add(new ProcessProgressEventHandler() {
            public void invoke(Signature sender, ProcessProgressEventArgs args) {
                onVerifyProgress(sender, args);
            }
        });
 
        TextVerifyOptions options = new TextVerifyOptions("John Smith")
        {
            // ...
        };
 
        // sign document to file
        VerificationResult result = signature.verify(options);
    } catch (Exception e) {
        throw new GroupDocsSignatureException(e.getMessage());
    }
}
```

## Cancel search process

Here are the steps to provide cancellation of searching process with GroupDocs.Signature:

*   Define [SearchProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SearchProgress) event handler delegates to conditionally cancel the process.    
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Subscribe for [SearchProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SearchProgress) event with proper handler method      
*   Instantiate required[ SearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/SearchOptions) object       
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass search options in it
    
```java
private static void onSearchProgress(Signature sender, ProcessProgressEventArgs args) {
    // check if process takes more than 1 second (1000 milliseconds) processing cancellation
    if (args.getTicks() > 1000) {
        args.setCancel(true);
        System.out.print("Search progress was cancelled. Time spent " + args.getTicks() + " mlsec");
    }
}
 
public static void run() {   
 
    try {
        Signature signature = new Signature("SampleSigned.pdf");
        signature.SearchProgress.add(new ProcessProgressEventHandler() {
            public void invoke(Signature sender, ProcessProgressEventArgs args) {
                onSearchProgress(sender, args);
            }
        });
 
        QrCodeSearchOptions options = new QrCodeSearchOptions(QrCodeTypes.QR) {
            // ...
        };
 
        // search for signatures in document
        List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, options);
        System.out.print("\nSource document contains following signatures.");
        for(QrCodeSignature qr_signature : signatures)
        {
            System.out.print("QRCode signature found at page "+qr_signature.getPageNumber()+" with type "+ qr_signature.getEncodeType()+" and text " + qr_signature.getText());
        }
    } catch (Exception e) {
        throw new GroupDocsSignatureException(e.getMessage());
    }
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
