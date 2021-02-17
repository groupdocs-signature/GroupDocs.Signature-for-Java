---
id: subscribing-for-search-process-events
url: signature/java/subscribing-for-search-process-events
title: Subscribing for search process events
weight: 4
description: "This article explains how to subscribe for search electronic signatures events like start, progress and completion with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class contains several events that are being called for different search process stages

*   [SearchStarted](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SearchStarted) to handle process start event. This event is occur once [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method is called
*   [SearchProgress](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SearchProgress) to handle progress event. This event occurs each time on searching each document page.
*   [SearchCompleted](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SearchCompleted) to handle completion event. This event occurs once [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions))process was completed.    

Here are the steps to subscribe for searching process with GroupDocs.Signature:

*   Define required handler delegates to process searching events.    
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path or stream as a constructor parameter.    
*   Subscribe for required events      
*   Instantiate required [SearchOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options.search/SearchOptions) object       
*   Call [search](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#search(java.lang.Class,%20com.groupdocs.signature.options.search.SearchOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass search options in it.
    

## Implement method for SearchStarted event

GroupDocs.Signature expects [ProcessStartEventHandler](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.handler.events/ProcessStartEventHandler) delegate to subscribe for [SearchStarted](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#SearchStarted) event

```java
private static void onSearchStarted(Signature sender, ProcessStartEventArgs args)
{
    System.out.print("Search process started at "+args.getStarted()+" with "+args.getTotalSignatures()+" total signatures to be put in document");
}
```

## Implement method for SearchProgress event

```java
 private static void onSearchProgress(Signature sender, ProcessProgressEventArgs args)
{
    System.out.print("Search progress. Processed "+args.getProcessedSignatures()+" signatures. Time spent "+args.getTicks()+" mlsec");
}
```

## Implement method for SearchCompleted event

```java
private static void onSearchCompleted(Signature sender, ProcessCompleteEventArgs args)
{
    System.out.print("Search process completed at "+args.getCompleted()+" with "+args.getTotalSignatures()+" total signatures. Process took "+args.getTicks()+" mlsec");
}
```

## Subscribing for search process events

```java
private static void onSearchStarted(Signature sender, ProcessStartEventArgs args)
{
    System.out.print("Search process started at "+args.getStarted()+" with "+args.getTotalSignatures()+" total signatures to be put in document");
}
 
private static void onSearchProgress(Signature sender, ProcessProgressEventArgs args)
{
    System.out.print("Search progress. Processed "+args.getProcessedSignatures()+" signatures. Time spent "+args.getTicks()+" mlsec");
}
 
private static void onSearchCompleted(Signature sender, ProcessCompleteEventArgs args)
{
    System.out.print("Search process completed at "+args.getCompleted()+" with "+args.getTotalSignatures()+" total signatures. Process took "+args.getTicks()+" mlsec");
}
 
public static void run()
{
    // The path to the documents directory.
    String filePath = Constants.SAMPLE_PDF;
 
    try {
        Signature signature = new Signature(filePath);
        signature.SearchStarted.add(new ProcessStartEventHandler() {
            public void invoke(Signature sender, ProcessStartEventArgs args) {
                onSearchStarted(sender, args);
            }
        });
 
 
        signature.SearchProgress.add(new ProcessProgressEventHandler() {
            public void invoke(Signature sender, ProcessProgressEventArgs args) {
                onSearchProgress(sender, args);
            }
 
 
        });
        signature.SearchCompleted.add(new ProcessCompleteEventHandler() {
            public void invoke(Signature  sender, ProcessCompleteEventArgs args) {
                onSearchCompleted(sender, args);
            }
        });
 
        BarcodeSearchOptions options = new BarcodeSearchOptions();
 
        // specify special pages to search on
        options.setAllPages(false);   
 
        // search for signatures in document
        List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class,options);
        System.out.print("\nSource document contains following signatures.");
        for (BarcodeSignature barcodeSignature : signatures)
        {
            System.out.print("Barcode signature found at page "+barcodeSignature.getPageNumber()+" with type "+barcodeSignature.getEncodeType()+" and text " + barcodeSignature.getText());
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
