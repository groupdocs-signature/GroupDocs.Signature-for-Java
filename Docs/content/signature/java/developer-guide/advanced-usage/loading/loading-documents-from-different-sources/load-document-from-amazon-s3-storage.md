---
id: load-document-from-amazon-s3-storage
url: signature/java/load-document-from-amazon-s3-storage
title: Load document from Amazon S3 Storage
weight: 1
description: "This section explains how to load document from Amazon S3 Storage with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
Following example demonstrates how to process with documents from Amazon S3 Storage.

```java
public static void run()
{
    String key = "sample.docx";
    try {
        InputStream stream = downloadFile(key);
 
        Signature signature = new Signature(stream);
 
        QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
        options.setEncodeType(QrCodeTypes.QR);
        options.setLeft(100);
        options.setTop(100);
 
        // sign document to file
        signature.sign("signedSample.docx", options);
 
        System.out.print("\nSource document signed successfully.\n" );
    }catch(Exception e){
        throw new GroupDocsSignatureException(e.getMessage());
    }
}
public static InputStream downloadFile(String key)
{
    AWSCredentials credentials = new BasicAWSCredentials(
            "<AWS accesskey>",
            "<AWS secretkey>"
    );
    AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                                             .withCredentials(new AWSStaticCredentialsProvider(credentials))
                                             .withRegion(Regions.US_EAST_2)
                                             .build();
    String bucketName = "my-bucket";
 
    S3Object s3object = s3client.getObject(bucketName, key);
    S3ObjectInputStream inputStream = s3object.getObjectContent();
    return inputStream;
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
