---
id: subscribing-for-signing-process-events
url: signature/java/subscribing-for-signing-process-events
title: Subscribing for signing process events
weight: 5
description: "This article explains how to subscribe for signing electronic signatures events like start, progress and completion with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class contains several events that are being called for different process stages

*   [SignStarted](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SignStarted) to handle process start event. This event is occur once [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method is called
*   [SignProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SignProgress) to handle progress event. This event occurs each time on signing each signature was completed.
*   [SignCompleted](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SignCompleted) to handle completion event. This event occurs once [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) process was completed.    

Here are the steps to subscribe for signing process with GroupDocs.Signature:

*   Define required handler delegates to process signing events.    
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Subscribe for required events      
*   Instantiate required [SignOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.sign/SignOptions) object  
*   Call [sign](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass signature options in it
    

## Implement method for SignStarted event

GroupDocs.Signature expects [ProcessStartEventHandler](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.handler.events/ProcessStartEventHandler) delegate to subscribe for [SignStarted](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SignStarted) event

```java
private static void onSignStarted(Signature sender, ProcessStartEventArgs args)
{
    System.out.print("Sign process started at "+args.getStarted()+" with "+args.getTotalSignatures()+" total signatures to be put in document");
}
```

## Implement method for SignProgress event

```java
private static void onSignProgress(Signature sender, ProcessProgressEventArgs args)
{
    System.out.print("Sign progress. Processed "+args.getProcessedSignatures()+" signatures. Time spent "+args.getTicks()+" mlsec");
}
```

## Implement method for SignCompleted event

```java
private static void onSignCompleted(Signature sender, ProcessCompleteEventArgs args)
{
    System.out.print("Sign process completed at "+args.getCompleted()+" with "+args.getTotalSignatures()+" total signatures. Process took "+args.getTicks()+" mlsec");
}
```

## Subscribing for signing process events

```java
private static void onSignStarted(Signature sender, ProcessStartEventArgs args)
{
    System.out.print("Sign process started at "+args.getStarted()+" with "+args.getTotalSignatures()+" total signatures to be put in document");
}
 
private static void onSignProgress(Signature sender, ProcessProgressEventArgs args)
{
    System.out.print("Sign progress. Processed "+args.getProcessedSignatures()+" signatures. Time spent "+args.getTicks()+" mlsec");
}
 
private static void onSignCompleted(Signature sender, ProcessCompleteEventArgs args)
{
    System.out.print("Sign process completed at "+args.getCompleted()+" with "+args.getTotalSignatures()+" total signatures. Process took "+args.getTicks()+" mlsec");
}
 
 
/**
 * Sign document with text signature applying specific options
 */
public static void run()
{    
    try {
        Signature signature = new Signature("sample.pdf");
        signature.SignStarted.add(new ProcessStartEventHandler() {
            public void invoke(Signature sender, ProcessStartEventArgs args) {
                onSignStarted(sender, args);
            }
        });
        signature.SignProgress.add(new ProcessProgressEventHandler() {
            public void invoke(Signature sender, ProcessProgressEventArgs args) {
                onSignProgress(sender, args);
            }
        });
        signature.SignCompleted.add(new ProcessCompleteEventHandler() {
            public void invoke(Signature  sender, ProcessCompleteEventArgs args) {
                onSignCompleted(sender, args);
            }
        });
 
        TextSignOptions options = new TextSignOptions("John Smith");
 
        // set signature position 
        options.setLeft(100);
        options.setTop(100);
 
        signature.sign("signed.pdf", options);
        System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
 
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
