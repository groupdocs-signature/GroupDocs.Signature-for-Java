---
id: load-document-from-azure-blob-storage
url: signature/java/load-document-from-azure-blob-storage
title: Load document from Azure Blob Storage
weight: 2
description: "This section explains how to load document from Azure Blob Storage with GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
Following example demonstrates how to process documents from Azure Blob Storage.

```java
public static void run() throws Exception
{
    String key = "sample.docx";
    String outputFilePath = new File(Constants.OutputPath, "SignFromStream//signedSample.docx").getPath();
    try {
        ByteArrayOutputStream stream = downloadFile(key);
 
        Signature signature = new Signature(new ByteArrayInputStream(stream.toByteArray()));
 
        QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
        options.setEncodeType(QrCodeTypes.QR);
        options.setLeft(100);
        options.setTop(100);
 
 
        // sign document to file
        signature.sign(outputFilePath, options);
 
        System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }catch(Exception e){
        throw new GroupDocsSignatureException(e.getMessage());
    }
}
public static final String STORAGE_CONNECTION_STRING
        = "DefaultEndpointsProtocol=https;"
        + "AccountName=Ram;" //Your account name.
        + "AccountKey=key"; //your account key.
 
public static ByteArrayOutputStream downloadFile(String blobName) throws Exception
{
    CloudBlobContainer container = getContainer();
 
    CloudBlob blob = container.getBlockBlobReference(blobName);
    ByteArrayOutputStream memoryStream = new ByteArrayOutputStream();
    blob.download(memoryStream);
    //memoryStream.Position = 0;
    return memoryStream;
}
 
private static CloudBlobContainer getContainer() throws Exception
{
    String containerName = "***";
 
    CloudStorageAccount cloudStorageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
    CloudBlobClient cloudBlobClient = cloudStorageAccount.createCloudBlobClient();
    CloudBlobContainer container = cloudBlobClient.getContainerReference(containerName);
    container.createIfNotExists();
 
    return container;
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
