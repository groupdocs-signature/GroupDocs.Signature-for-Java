---
id: groupdocs-signature-for-java-21-5-release-notes
url: signature/java/groupdocs-signature-for-java-21-5-release-notes
title: GroupDocs.Signature for Java 21.5 Release Notes
weight: 46
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 21.5{{< /alert >}}

## Major Features

This release contains important improvements for PDF Digital signatures, for signature image preview generation, changes with the additional signature options properties and bug fixes. Below the list of most notable changes in release of GroupDocs.Signature for Java 21.5:

* Introduced extended customization of PDF Digital signatures appearance.
* Implemented ability to apply signature extensions to Digital Signatures.
* Fixed bug with restoring signatures metadata from signed image documents.
* Implemented additional customization of Pdf Digital Signature appearance.
* Improved saving Open Office documents with the OTT file format.
* Implemented support of Native Text Signature implementation on the Image documents.
* Fixed major issues with reading and signing Word processing documents.
* Fixed issues with the image rendering for the Spreadsheet documents.
* Fixed null-references bugs with accessing not initialized objects across the signing process.
* The issue on Document preview generation with not hidden signatures was fixed.
* Unexpected identifiers in the result for digitally signed PDF Documents were fixed.
* Fixed the wrong signature identifiers in the signing result for all supported file formats.
* Implemented ability to retrieve Signatures preview for the given Signature Options.
* Involved signature deletion by the certain Signature type (Text, Image, Barcode, QRCode, Digital).
* Improved electronic certificates removal from the WordProcesing, Spreadsheet and Presentation documents.
* Fixed page generation preview issues with the Qr-Code signatures.
* Fixed issues with the image rendering for the Spreadsheet documents.
* Implemented ability to support Border properties for PDF Digital signature on document page.
* Improved generation of digital signature image preview for Pdf document.
* Implemented additional properties Siganture Type and Document Type that allow to distinct the options and specify document type for signature preview.
* Fixed the issue with Word Processing document Watermark objects.

Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-3136 | Improve PDF Digital Appearance implementation to support all image related extensions | Feature |
| SIGNATURENET-3104 | Implement CustomAppearance property for PDF Digital Signature | Feature |
| SIGNATURENET-3127 | Improve processing nullable Font properties entire options with default values | Improvement |
| SIGNATURENET-3136-3133 | Exception Specified cast is not valid when processing signed image documents | Bug |
| SIGNATURENET-3131 | Incorrect Page count when obtaining .Odt documents format information | Bug |
| SIGNATURENET-3130 | Null reference exception occurs for applying Text signature options with nullable Font property | Bug |
| SIGNATURENET-3128 | This file type is not supported | Bug |
| SIGNATURENET-2971 | Word-processing blank document preview doesn't contain trial message | Bug |
| SIGNATURENET-3207 | Implement Font customization for Pdf Digital Signature Appearance | Feature |
| SIGNATURENET-3188 | Open office document content is slightly changed after saving for OTT format types | Improvement |
| SIGNATURENET-3139 | Involve support of Text Signature options with Native implementation for Image documents | Improvement |
| SIGNATURENET-3187 | Exception while obtaining watermark type for Word processing documents | Bug |
| SIGNATURENET-3186 | Can not sign second page of Word processing document | Bug |
| SIGNATURENET-3185 | Document Information returns incorrect number of pages for Pdf files | Bug |
| SIGNATURENET-3184 | Can not sign Open Office document for ODT format files | Bug |
| SIGNATURENET-3183 | A generic error occurred in GDI+ for Spreadsheet documents | Bug |
| SIGNATURENET-3160 | NullReference exception occurs when Text property of StampLine is not set for Stamp Signatures | Bug |
| SIGNATURENET-3158 | NullReference exception occurs when Margin property of signature options is null | Bug |
| SIGNATURENET-3280 | Preview with hidden signatures contains QrCode signature image for Word processing documents | Bug |
| SIGNATURENET-3277 | Result of digitally signed documents contains wrong Digital signature identifiers | Bug |
| SIGNATURENET-3234 | Signed result of Pdf document returns unexpected Signature identifier | Bug |
| SIGNATURENET-3358 | Implement ability to retrieve Stamp Signature Image Preview without document | Feature |
| SIGNATURENET-3357 | Implement ability to retrieve Digital Signature Image Preview without document | Feature |
| SIGNATURENET-3356 | Implement ability to retrieve Text Signature image preview without document | Feature |
| SIGNATURENET-3331 | Implement the ability to remove signatures of the certain type | Feature |
| SIGNATURENET-3329 | Implement ability to retrieve QR-code signature image without document | Feature |
| SIGNATURENET-3328 | Implement ability to retrieve Barcode signature image without document | Feature |
| SIGNATURENET-3282 | Implement ability to remove digital signatures from Spreadsheet documents | Feature |
| SIGNATURENET-3281 | Implement ability to remove all digital signatures from Presentation documents | Feature |
| SIGNATURENET-3233 | Implement ability to remove digital signatures from Word Processing documents | Feature |
| SIGNATURENET-3283 | Preview with hidden signatures contains QrCode signature | Bug |
| SIGNATURENET-3258 | Error "startIndex cannot be larger than length of string. Parameter name: startIndex" for Spreadsheet documents | Bug |
| SIGNATURENET-3410 | Implement support of Border properties for the Pdf Digital Appearance  | Improvement |
| SIGNATURENET-3389 | Implement special generation of the Digital Signature image preview for PDF Document type | Improvement |
| SIGNATURENET-3388 | Implement public enum Document Type to distinct document options | Improvement |
| SIGNATURENET-3363 | Implement SignOptions.SignatureType property | Improvement |
| SIGNATURENET-3309 | Unexpected Words Processing document behavior with watermark objects | Bug |

## Public Developer Guide examples changes

Following topics from Developer Guide were added

[Delete Digital signatures from documents]({{< ref "signature/java/developer-guide/basic-usage/delete-signatures-from-documents/delete-digital-signatures-from-documents.md" >}})

[Delete Signatures of the certain type]({{< ref "signature/java/developer-guide/basic-usage/delete-signatures-from-documents/delete-signatures-of-the-certain-type.md" >}})

[Generate Signatures preview]({{< ref "signature/java/developer-guide/basic-usage/generate-signatures-preview.md" >}})

[Advanced Signatures removal of the certain types]({{< ref "signature/java/developer-guide/advanced-usage/deleting/delete-signatures-of-the-certain-types.md" >}})

## Public API and Backward Incompatible Changes

### New class [PdfDigitalSignatureAppearance](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.appearances/PdfDigitalSignatureAppearance) was added with several properties that allow to customize appearance of digital sigantures on the PDF Document pages. 

New class PdfDigitalSignatureAppearance contains follow properties.

**New class PdfDigitalSignatureAppearance**


```java
public final class PdfDigitalSignatureAppearance extends SignatureAppearance
{
    /**
     * <p>
     * Gets or sets contact info label. Default value: "Contact".
     * if this value is empty then no contact label will appear on digital signature area.
     * </p>
     */    
    public final String getContactInfoLabel();
    public final void setContactInfoLabel(String value);

    /**
     * <p>
     * Gets or sets reason label. Default value: "Reason".
     * if this value is empty then no reason label will appear on digital signature area.
     * </p>
     */    
    public final String getReasonLabel();
    public final void setReasonLabel(String value);

    /**
     * <p>
     * Gets or sets location label. Default value: "Location".
     * if this value is empty then no location label will appear on digital signature area.
     * </p>
     */    
    public final String getLocationLabel();
    public final void setLocationLabel(String value);

    /**
     * <p>
     * Gets or sets digital signed label. Default value: "Digitally signed by".
     * </p>
     */    
    public final String getDigitalSignedLabel();
    public final void setDigitalSignedLabel(String value);

    /**
     * <p>
     * Gets or sets date signed label. Default value: "Date".
     * </p>
     */    
    public final String getDateSignedAtLabel();
    public final void setDateSignedAtLabel(String value);
	
	/**
	 * <p>
	 * Get or set background color of signature appearance.
	 * By default the value is SystemColors.Windows
	 * </p>
	 */    
    public final java.awt.Color getBackground();
    public final void setBackground(java.awt.Color value);

    /**
     * <p>
     * Gets or sets the Font family name to display the labels. Default value is "Arial".
     * </p>
     */   
    public final String getFontFamilyName();    
    public final void setFontFamilyName(String value);

    /**
     * <p>
     * Gets or sets the Font size to display the labels. Default value is 10.
     * </p>
     */    
    public final double getFontSize();    
    public final void setFontSize(double value);
    

    /**
     * <p>
     * Creates signature appearance object with default values.
     * </p>
     */    
    public PdfDigitalSignatureAppearance();    
}
```

Following example shows how to sign PDF Document with customization of Digital signature appearance on the page.

```java
// initialize Signature instance
Signature signature = new Signature("signed.pdf");

//Create digital signing options
DigitalSignOptions options = new DigitalSignOptions(certificatePath);
// certificate password
options.setPassword("1234567890");
// digital certificate details
options.setReason("Approved");
options.setLocation("New York");

// apply custom PDF signature appearance
PdfDigitalSignatureAppearance appearance = new PdfDigitalSignatureAppearance();

// do now show contact details
appearance.setContactInfoLabel("");
// simplify reason label
appearance.setReasonLabel("R:");
// change location label
appearance.setLocationLabel("@=>");
appearance.setDigitalSignedLabel("By:");
appearance.setDateSignedAtLabel("On");
// apply custom appearance color
appearance.setBackground(Color.red);
// apply custom font settings
appearance.setFontFamilyName("Courier");
appearance.setFontSize(8);

options.setAppearance(appearance);
//
options.setAllPages(true);
options.setWidth(160);
options.setHeight(80);
options.setVerticalAlignment(VerticalAlignment.Center);
options.setHorizontalAlignment(HorizontalAlignment.Left);
options.setMargin(new Padding(0, 10,0, 10));

// setup signature border
Border border = new Border();
border.setVisible(true);
border.setColor(Color.red);
border.setDashStyle(DashStyle.DashDot);
border.setWeight(2);
options.setBorder(border);

SignResult signResult = signature.sign("signed_out.pdf", options);
       

```

#### Public class [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) was updated with 2 new overload Delete methods

Method [delete](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#delete(java.lang.String,%20int)) expects enumeration [SignatureType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/SignatureType).

Alternative overload method [deleteByTypes](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#deleteByTypes(java.io.OutputStream,%20java.util.List)) expects list of the [SignatureType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/SignatureType) enumeration.

**New overload Delete methods of Signature class**

```java
    public class Signature
    {
       /**
		 * <p>
		 * Deletes signatures of the certain type {@link SignatureType} from the document.
		 * Only signatures that were added by Sign method and marked as Signatures {@code BaseSignature.isSignature()}({@link BaseSignature#isSignature}/{@link BaseSignature#setSignature(boolean)})  will be removed.
		 * Following signature types are supported: Text, Image, Digital, Barcode, QR-Code
		 * </p>
		 */
        public final DeleteResult delete(OutputStream document, int signatureType) throws Exception {};
        public final DeleteResult deleteByTypes(OutputStream document, java.util.List<Integer> signatureTypes) throws Exception {};
		public final DeleteResult delete(String filePath, int signatureType) throws Exception {};
		public final DeleteResult deleteByTypes(String filePath, java.util.List<Integer> signatureTypes) throws Exception{};
   }
```

Following example demonstrates how to remove all digital signatures from the document.

**Deleting all Digital signatures from the document**

```java

	Signature signature = new Signature("signed.pdfx");
	{
		// deleting QR-Code signatures from the document
		DeleteResult result = signature.delete("signed_out.pdfx", SignatureType.Digital);
		if (result.getSucceeded().size() > 0)
		{
			System.out.print("Following Digital signatures were deleted:");
			int number = 1;
			for (BaseSignature temp : result.getSucceeded())
			{
				System.out.print("Signature #"+number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+", Text: "+((DigitalSignature)temp).getText());
			}
		}
		else
		{
			System.out.print("No one Digital signature was deleted.");
		}
	}
```

#### New public class [PreviewSignatureOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options/PreviewSignatureOptions) was added to collect settings for signature preview

This class contains following properties

* unique signature identifier SignatureId.
* instance of the [SignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/SignOptions).
* enumeration of the preview image format

**New static method GenerateSignaturePreview of Signature class**

```java
/**
 * <p>
 * Represents signature preview options.
 * </p>
 */
public class PreviewSignatureOptions
{
    /**
     * <p>
     * Unique value to distinct the signature.
     * Use SignatureId to identify the preview options.
     * </p>
     */    
    public final String getSignatureId(){};
    public final void setSignatureId(String value){};

    /**
     * <p>
     * Signature Options for generate preview.
     * </p>
     */    
    public final SignOptions getSignOptions(){};
    public final void setSignOptions(SignOptions value){};
    

    /**
     * <p>
     * Gets or sets preview images format.
     * Default value is PNG
     * </p>
     */    
    public final int getPreviewFormat(){};
    public final void setPreviewFormat(int value){};


    /**
     * <p>
     * Initializes PreviewSignatureOptions object.
     * </p>
     * @param signOptions The signature options to generate preview for.
     * @param pageStreamFactory Interface which defines method to create output page preview stream.
     */    
    public PreviewSignatureOptions(SignOptions signOptions, PageSignatureStreamFactory pageStreamFactory){};

}

/**
 * <p>
 * Document preview supported formats
 * </p>
 */
public class PreviewFormats extends Object
{
    private PreviewFormats(){}
    /**
     * <p>
     * PNG
     * </p>
     */
    public static final int PNG = 0;
    /**
     * <p>
     * JPEG
     * </p>
     */
    public static final int JPEG = 1;
    /**
     * <p>
     * BMP
     * </p>
     */
    public static final int BMP = 2;
}
```

#### Public class [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature) was updated with static method to generate Signature preview with specified SignOptions

Static method [generateSignaturePreview](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#generateSignaturePreview(com.groupdocs.signature.options.PreviewSignatureOptions)) expects [PreviewSignatureOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options/PreviewSignatureOptions) to generate signature preview and control creation and deletion signature image stream.

**New static method GenerateSignaturePreview of Signature class**

```java
   /**
	 * <p>
	 * Generates Signature preview based on given SignOptions. 
	 * </p>
	 */
   public static void generateSignaturePreview(PreviewSignatureOptions previewOptions) throws Exception{};
   
```

Following example demonstrates how to generate signature.

**Generate signature preview**

```java

	public static void run() throws Exception
    {
		DigitalSignOptions signOptions = new DigitalSignOptions(MrSmithSignature.pfx);
        {
            // set the DocumentType property to specify simulating PDF signature appearance
            signOptions.setDocumentType(DocumentType.Pdf);
            // certificate password
            signOptions.setPassword("1234567890");
            // digital certificate details
            signOptions.setReason("Approved");
            signOptions.setContact("John Smith");
            signOptions.setLocation("New York");

            // apply custom PDF signature appearance
            PdfDigitalSignatureAppearance pdfDigSignAppearance = new PdfDigitalSignatureAppearance();
            {
                // do now show contact details
                pdfDigSignAppearance.setContactInfoLabel("Contact");
                // simplify reason label
                pdfDigSignAppearance.setReasonLabel("R:");
                // change location label
                pdfDigSignAppearance.setLocationLabel("@=>");
                pdfDigSignAppearance.setDigitalSignedLabel("By:");
                pdfDigSignAppearance.setDateSignedAtLabel("On:");
                // apply custom appearance color
                pdfDigSignAppearance.setBackground(Color.GRAY);
                // apply custom font settings
                pdfDigSignAppearance.setFontFamilyName("Courier");
                pdfDigSignAppearance.setFontSize(8);
            }
            //
            signOptions.setAllPages(false);
            signOptions.setWidth(200);
            signOptions.setHeight(130);
            signOptions.setVerticalAlignment(VerticalAlignment.Center);
            signOptions.setHorizontalAlignment(HorizontalAlignment.Left);
            Padding padding = new Padding();
            padding.setBottom(10);
            padding.setRight(10);
            signOptions.setMargin(padding);

            // setup signature border
            Border border = new Border();
            border.setVisible(true);
            border.setColor(Color.DARK_GRAY);
            border.setDashStyle(DashStyle.DashDot);
            border.setWeight(2);
            signOptions.setBorder(border);

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
#### New public enumeration [DocumentType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/DocumentType) was added to distinct supported document types

This enumeration keeps supported Document types.

**New public enumeration**

```java
    public final class DocumentType extends Object
{
    private DocumentType(){}
    /**
     * <p>Indicates an error, unknown document type.</p>
     */
    public static final int Unknown = 0;
    /**
     * <p>PDF Document Type.</p>
     */
    public static final int Pdf = 1;
    /**
     * <p>Word Processing Document Type.</p>
     */
    public static final int WordProcessing = 2;
    /**
     * <p>Presentation Document Type.</p>
     */
    public static final int Presentation = 3;
    /**
     * <p>Spreadsheet Document Type.</p>
     */
    public static final int Spreadsheet = 4;
    /**
     * <p>Image Document Type.</p>
     */
    public static final int Image = 5;
	
}
```

#### Public class [SignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/SignOptions) was updated with 2 new properties that allow to distinct signature type and document type

Public class [SignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/SignOptions) was updated with properties

* readonly property [SignatureType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/SignatureType).
* property [DocumentType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/DocumentType).

**New properties of SignOptions class**

```java
    public abstract class SignOptions
{
    /**
     * <p>
     * Get Signature Type
     * </p>
     */      
    public final int getSignatureType(){};

	 /**
     * <p>
     * Document Type (Spreadsheets, Presentations, Pdf, Words, Image)
     * </p>
     */    
    public final int getDocumentType(){};
    public final void setDocumentType(int value){};
   }
```
