---
id: subscribing-for-verification-process-events
url: signature/java/subscribing-for-verification-process-events
title: Subscribing for verification process events
weight: 6
description: "This article explains how to subscribe for verification of electronic signatures events like start, progress and completion with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class contains several events that are being called for different verification process stages

*   [VerifyStarted](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#VerifyStarted) to handle process start event. This event is occur once [verify](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#verify(com.groupdocs.signature.options.verify.VerifyOptions)) method is called
*   [VerifyProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#VerifyProgress) to handle progress event. This event occurs each time on verifying each signature was completed.
*   [VerifyCompleted](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#VerifyCompleted) to handle completion event. This event occurs once [verify](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#verify(com.groupdocs.signature.options.verify.VerifyOptions)) process was completed.    

Here are the steps to subscribe for verification process with GroupDocs.Signature:
*   Define required handler delegates to process signing events.    
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Subscribe for required events      
*   Instantiate required [VerifyOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.verify/VerifyOptions) object  
*   Call [verify](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#verify(com.groupdocs.signature.options.verify.VerifyOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass verify options in it .
    

## Implement method for VerifyStarted event

GroupDocs.Signature expects [ProcessStartEventHandler](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.handler.events/ProcessStartEventHandler) delegate to subscribe for [VerifyStarted](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#VerifyStarted) event

```java
private static void onVerifyStarted(Signature sender, ProcessStartEventArgs args)
{
    System.out.print("Verify process started at "+args.getStarted()+" with "+args.getTotalSignatures()+" total signatures to be put in document");
}
```

## Implement method for VerifyProgress event

```java
 private static void onVerifyProgress(Signature sender, ProcessProgressEventArgs args)
{
    System.out.print("Verify progress. Processed "+args.getProcessedSignatures()+" signatures. Time spent "+args.getTicks()+" mlsec");
}
```

## Implement method for VerifyCompleted event

```java
private static void onVerifyCompleted(Signature sender, ProcessCompleteEventArgs args)
{
    System.out.print("Verify process completed at "+args.getCompleted()+" with "+args.getTotalSignatures()+" total signatures. Process took "+args.getTicks()+" mlsec");
}
```

## Subscribing for verification process events

```java
private static void onVerifyStarted(Signature sender, ProcessStartEventArgs args)
{
    System.out.print("Verify process started at "+args.getStarted()+" with "+args.getTotalSignatures()+" total signatures to be put in document");
}
 
private static void onVerifyProgress(Signature sender, ProcessProgressEventArgs args)
{
    System.out.print("Verify progress. Processed "+args.getProcessedSignatures()+" signatures. Time spent "+args.getTicks()+" mlsec");
}
 
private static void onVerifyCompleted(Signature sender, ProcessCompleteEventArgs args)
{
    System.out.print("Verify process completed at "+args.getCompleted()+" with "+args.getTotalSignatures()+" total signatures. Process took "+args.getTicks()+" mlsec");
}
 
 
public static void run()
{   
 
    try {
        Signature signature = new Signature("sample.pdf");
        signature.VerifyStarted.add(new ProcessStartEventHandler() {
            public void invoke(Signature sender, ProcessStartEventArgs args) {
                onVerifyStarted(sender, args);
            }
        });
 
 
        signature.VerifyProgress.add(new ProcessProgressEventHandler() {
            public void invoke(Signature sender, ProcessProgressEventArgs args) {
                onVerifyProgress(sender, args);
            }
 
 
        });
        signature.VerifyCompleted.add(new ProcessCompleteEventHandler() {
            public void invoke(Signature sender, ProcessCompleteEventArgs args) {
                onVerifyCompleted(sender, args);
            }
        });
 
        TextVerifyOptions options = new TextVerifyOptions("John Smith");
        options.setAllPages(true);
 
        // verify document
        VerificationResult result = signature.verify(options);
        if (result.isValid())
        {
            System.out.print("\nDocument was verified successfully!");
    }
        else
        {
            System.out.print("\nDocument failed verification process.");
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
