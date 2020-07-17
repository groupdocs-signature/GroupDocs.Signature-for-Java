---
id: generate-document-pages-preview
url: signature/java/generate-document-pages-preview
title: Generate document pages preview
weight: 6
description: "This topic explains how to get document pages preview as images with various options by GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [PreviewOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PreviewOptions) class to specify different options to manage document pages preview generation process.  
  
Here are the steps to generate document preview with GroupDocs.Signature:
*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.
*   Instantiate the[ PreviewOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PreviewOptions) object with:     
    *   interface for each page stream creation (see [PageStreamFactory](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PageStreamFactory));         
    *   image preview format - PNG / JPG / BMP,         
    *   page numbers to process;        
    *   custom size of preview images (if needed).         
*   Call [generatePreview](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#generatePreview(com.groupdocs.signature.options.PreviewOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [PreviewOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PreviewOptions) to it.       
{{< alert style="info" >}}
Important note! Stream that were created by [createPageStream](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PageStreamFactory#createPageStream(int)) method will be disposed automatically once after generation of preview image. If you need to implement custom image preview stream disposing you have to pass additional method [closePageStream](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PageStreamFactory#closePageStream(int,%20java.io.OutputStream)) to clean up resources.  
{{< /alert >}}


## Generate document preview from file on local disk

```java
   
	// instantiating the signature object
    final Signature signature = new Signature("sample.pdf");
     
	PreviewOptions previewOption = new PreviewOptions("C:\\GeneratePreviewHideSignatures\\image.jpg", 0);
	previewOptions.setPreviewFormat(PreviewFormats.PNG);
	signature.generatePreview(previewOptions);
    

```

## createPageStream method implementation

GroupDocs.Signature expects [createPageStream](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PageStreamFactory#createPageStream(int)) method to obtain each page stream for image preview generation process

```java
@Override
public OutputStream createPageStream(int pageNumber) {
    try {
        Path path = Paths.get("C:\\GeneratePreviewFolder");

        if (!Files.exists(path)) {
            Files.createDirectory(path);
            System.out.println("Directory created");
        } else {

            System.out.println("Directory already exists");
        }
        File filePath = new File(path+"\\image-"+pageNumber+".jpg");

        return new FileOutputStream(filePath);
    }catch (Exception e){
        throw new GroupDocsSignatureException(e.getMessage());
    }
}
```

## ClosePageStream method implementation

```java
@Override
public void closePageStream(int pageNumber, OutputStream pageStream) {
    try {
        pageStream.close();
        String imageFilePath = new File("GeneratePreviewFolder", "image-" +pageNumber +  ".jpg").getPath();
        System.out.print("Image file "+imageFilePath+" is ready for preview");
    }catch (Exception e){
        throw new GroupDocsSignatureException(e.getMessage());
    }
}
```

## Generate document preview from stream with custom stream creating and closing methods

```java
// instantiating the signature object
	FileInputStream stream = new FileInputStream("sample.pdf")
    final Signature signature = new Signature(stream);
        // Image from specified page
	PreviewOptions previewOption = new PreviewOptions(new PageStreamFactory() {
    @Override
    public OutputStream createPageStream(int pageNumber) {
        try {
            Path path = Paths.get("C:\\GeneratePreviewHideSignatures");

            if (!Files.exists(path)) {

                Files.createDirectory(path);
                System.out.println("Directory created");
            } else {

                System.out.println("Directory already exists");
            }
            File filePath = new File(path+"\\image-"+pageNumber+".jpg");

            return new FileOutputStream(filePath);
        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }

    @Override
    public void closePageStream(int pageNumber, OutputStream pageStream) {
        try {
            pageStream.close();
            String imageFilePath = new File("C:\\GeneratePreviewHideSignatures", "image-" +pageNumber +  ".jpg").getPath();
            System.out.print("Image file "+imageFilePath+" is ready for preview");
        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
});
	previewOptions.setPreviewFormat(PreviewFormats.PNG);
	signature.generatePreview(previewOptions);


```

## More resources 

### Advanced Usage Topics 

To learn more about document eSign features, please refer to the [advanced usage section]({{< ref "signature/java/developer-guide/advanced-usage/_index.md" >}}).

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
