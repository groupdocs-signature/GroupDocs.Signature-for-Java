---
id: generate-signature-preview
url: signature/java/generate-signature-preview
title: Generate signature preview
weight: 7
description: "This topic explains how to get signature preview with the SignOptions by GroupDocs.Signature API."
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides [PreviewSignatureOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options/PreviewSignatureOptions) class to specify different options to manage signatures preview generation process.  
  
Here are the steps to generate signature preview with GroupDocs.Signature:

* Instantiate the required [SignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/SignOptions) object with the settings you want to generate the preview
* Instantiate the [PreviewSignatureOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options/PreviewSignatureOptions) object with:
* delegate for signature stream creation (see interface [PageSignatureStreamFactory](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options/PageSignatureStreamFactory));
* image preview format - PNG / JPG / BMP,
* unique signature identifier.

{{< alert style="info" >}}
Stream that were created by [createSignatureStream](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options/PageSignatureStreamFactory#createSignatureStream(com.groupdocs.signature.options.PreviewSignatureOptions)) delegate will be disposed automatically once after generation of preview image. If you need to implement custom image preview stream disposing you have to pass additional argument [closeSignatureStream](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options/PageSignatureStreamFactory#createSignatureStream(com.groupdocs.signature.options.PreviewSignatureOptions)) to clean up resources.  
{{< /alert >}}
* Call the static method [generateSignaturePreview](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#generateSignaturePreview(com.groupdocs.signature.options.PreviewSignatureOptions)) method of [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) and pass [PreviewSignatureOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options/PreviewSignatureOptions) to it.

## CreateSignatureStream delegate implementation

GroupDocs.Signature expects [createSignatureStream](https://apireference.groupdocs.com/https://apireference-qa.groupdocs.com/signature/java/com.groupdocs.signature.options/PageSignatureStreamFactory#createSignatureStream(com.groupdocs.signature.options.PreviewSignatureOptions)) delegate to obtain each signature stream for image preview generation process

```java
private static OutputStream createSignatureStream(PreviewSignatureOptions previewOptions)
    {
        try {
            Path path = Paths.get("C:\\Output\\GenerateSignaturePreviewAdvanced\\");
            if (!Files.exists(path)) {

                Files.createDirectory(path);
                System.out.println("Directory created");
            } else {

                System.out.println("Directory already exists");
            }
            File imageFilePath = new File(path+"\\signature"+previewOptions.getSignatureId()+"-"+previewOptions.getSignOptions().getSignatureType()+".jpg");
            return new FileOutputStream(imageFilePath);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
```

## ReleaseSignatureStream delegate implementation

```java
 private static void releaseSignatureStream(PreviewSignatureOptions previewOptions, OutputStream signatureStream)
    {
        try {
            signatureStream.close();
            String imageFilePath = new File("C:\\Output\\GenerateSignaturePreviewAdvanced\\\\signature"+previewOptions.getSignatureId()+"-"+previewOptions.getSignOptions().getSignatureType()+".jpg").getPath();
            System.out.print("Image file "+imageFilePath+" is ready for preview");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
```

## Generate signature preview

```java
public static void GetPreview()
{
    // create options
    QrCodeSignOptions signOptions = new QrCodeSignOptions();
        {
            signOptions.setEncodeType(QrCodeTypes.QR);
                // setup Data property with Address object
            Address address = new Address();
            address.setStreet("221B Baker Street");
            address.setCity("London");
            address.setState("NW");
            address.setZIP("NW16XE");
            address.setCountry("England");
            signOptions.setData(address);
                // set right bottom corner
            signOptions.setHorizontalAlignment(HorizontalAlignment.Left);
            signOptions.setVerticalAlignment(VerticalAlignment.Center);
            signOptions.setWidth(100);
            signOptions.setHeight(100);
            signOptions.setMargin(new Padding(10));
        };

        // create signature preview options object
        PreviewSignatureOptions previewOption = new PreviewSignatureOptions(signOptions, new PageSignatureStreamFactory() {
            @Override
            public OutputStream createSignatureStream(PreviewSignatureOptions previewOptions) {
                return generateSignatureStream(previewOptions);
            }

            @Override
            public void closeSignatureStream(PreviewSignatureOptions previewOptions, OutputStream pageStream) {
                releaseSignatureStream(previewOptions, pageStream);
            }
        });
        previewOption.setSignatureId(UUID.randomUUID().toString());
        previewOption.setPreviewFormat(PreviewFormats.JPEG);

        // generate preview
        Signature.generateSignaturePreview(previewOption);
}

    private static OutputStream generateSignatureStream(PreviewSignatureOptions previewOptions)
    {
        try {
            Path path = Paths.get(Constants.OutputPath, "\\GenerateSignaturePreviewAdvanced\\");
            if (!Files.exists(path)) {

                Files.createDirectory(path);
                System.out.println("Directory created");
            } else {

                System.out.println("Directory already exists");
            }
            File imageFilePath = new File(path+"\\signature"+previewOptions.getSignatureId()+"-"+previewOptions.getSignOptions().getSignatureType()+".jpg");
            return new FileOutputStream(imageFilePath);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void releaseSignatureStream(PreviewSignatureOptions previewOptions, OutputStream signatureStream)
    {
        try {
            signatureStream.close();
            String imageFilePath = new File(Constants.OutputPath + "\\GeneratePreviewHideSignatures\\signature"+previewOptions.getSignatureId()+"-"+previewOptions.getSignOptions().getSignatureType()+".jpg").getPath();
            System.out.print("Image file "+imageFilePath+" is ready for preview");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
```

### Advanced Usage Topics

To learn more about document eSign features, please refer to the [advanced usage section]({{< ref "signature/java/developer-guide/advanced-usage/_index.md" >}}).

## More resources

### GitHub Examples

You may easily run the code above and see the feature in action in our GitHub examples:

* [GroupDocs.Signature for .NET examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET)
* [GroupDocs.Signature for Java examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java)
* [Document Signature for .NET MVC UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-MVC)
* [Document Signature for .NET App WebForms UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-WebForms)
* [Document Signature for Java App Dropwizard UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Dropwizard)
* [Document Signature for Java Spring UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Spring)

### Free Online App

Along with full-featured .NET library we provide simple, but powerful free Apps.

You are welcome to eSign PDF, Word, Excel, PowerPoint documents with free to use online **[GroupDocs Signature App](https://products.groupdocs.app/signature)**.
