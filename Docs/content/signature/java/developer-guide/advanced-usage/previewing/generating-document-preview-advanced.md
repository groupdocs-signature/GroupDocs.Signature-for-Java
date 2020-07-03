---
id: generating-document-preview-advanced
url: signature/java/generating-document-preview-advanced
title: Generating document preview - advanced
weight: 1
description: "This article shows how to generate document pages with advanced options."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [PreviewOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PreviewOptions) class to specify different options to manage document pages preview generation process. Since 20.3 version there's ability to hide signatures from documents. Using property [setHideSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PreviewOptions#setHideSignatures(boolean)) of [PreviewOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PreviewOptions) will allow to hide signatures from document preview.  
  
Here are the steps to generate document preview with GroupDocs.Signature with hidden signatures:

*   Create new instance of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class and pass source document path as a constructor parameter.
    
*   Instantiate the [PreviewOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PreviewOptions) object with:
    
    *   delegate for each page stream creation (see [PageStreamFactory](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PageStreamFactory));   
        
    *   property [setHideSignature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PreviewOptions#setHideSignatures(boolean)) set to true  
        
    *   image preview format - PNG / JPG / BMP, 
        
    *   page numbers to process;
        
    *   custom size of preview images (if needed).   
        
        {{< alert style="info" >}} Stream that were created by createPageStream delegate will be disposed automatically once after generation of preview image. If you need to implement custom image preview stream disposing you have to pass additional argument closePageStream to clean up resources.{{< /alert >}}
*   Call [generatePreview](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature#generatePreview(com.groupdocs.signature.options.PreviewOptions)) method of [Signature](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature/Signature) class instance and pass [PreviewOptions](https://apireference.groupdocs.com/java/signature/com.groupdocs.signature.options/PreviewOptions) to it.
    

## Generate document preview without signatures on it

```java
public static void getPreview()
{
    // The path to the documents directory.
    String filePath = "C:\signed.pdf";
 
    Signature signature = new Signature(filePath);
    try
    {
        // create preview options object
        PreviewOptions previewOption = new PreviewOptions(new PageStreamFactory() {
            @Override
            public OutputStream createPageStream(int pageNumber) {
                return generateStream(pageNumber);
            }
 
            @Override
            public void closePageStream(int pageNumber, OutputStream pageStream) {
                releasePageStream(pageNumber, pageStream);
            }
        });
        previewOption.setPreviewFormat(PreviewFormats.JPEG);
        previewOption.setHideSignatures(true);
        // generate preview
        signature.generatePreview(previewOption);
 
    }catch (Exception e){
        throw new GroupDocsSignatureException(e.getMessage());
    }
}
 
 
private static OutputStream generateStream(int pageNumber)
{
    try {
        Path path = Paths.get("C:\\GeneratePreviewHideSignatures\\");
 
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
 
private static void releasePageStream(int pageNumber, OutputStream pageStream)
{
    try {
        pageStream.close();
        String imageFilePath = new File("C:\\GeneratePreviewHideSignatures", "image-" +pageNumber +  ".jpg").getPath();
        System.out.print("Image file "+imageFilePath+" is ready for preview");
    }catch (Exception e){
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
