package com.groupdocs.signature.examples;


import com.groupdocs.signature.examples.advanced_usage.common.*;
import com.groupdocs.signature.examples.advanced_usage.crud.ProcessingBarcodeSignatureOverCRUD;
import com.groupdocs.signature.examples.advanced_usage.crud.ProcessingImageSignatureOverCRUD;
import com.groupdocs.signature.examples.advanced_usage.crud.ProcessingQrCodeSignatureOverCRUD;
import com.groupdocs.signature.examples.advanced_usage.crud.ProcessingTextSignatureOverCRUD;
import com.groupdocs.signature.examples.advanced_usage.delete.*;
import com.groupdocs.signature.examples.advanced_usage.documentpreview.GeneratePreviewAdvanced;
import com.groupdocs.signature.examples.advanced_usage.documentpreview.GetDocumentInfoAdvanced;
import com.groupdocs.signature.examples.advanced_usage.documentpreview.GetDocumentProcessHistoryAdvanced;
import com.groupdocs.signature.examples.advanced_usage.handlingexceptions.HandlingIncorrectPasswordException;
import com.groupdocs.signature.examples.advanced_usage.handlingexceptions.HandlingPasswordRequiredException;
import com.groupdocs.signature.examples.advanced_usage.loading.LoadPasswordProtectedDocument;
import com.groupdocs.signature.examples.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromLocalDisk;
import com.groupdocs.signature.examples.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromStream;
import com.groupdocs.signature.examples.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromUrl;
import com.groupdocs.signature.examples.advanced_usage.saving.SaveDocumentWithPassword;
import com.groupdocs.signature.examples.advanced_usage.saving.SaveSignedDocumentsAsImages;
import com.groupdocs.signature.examples.advanced_usage.saving.SaveSignedImageWithVariousOutputTypes;
import com.groupdocs.signature.examples.advanced_usage.saving.save_documents_with_different_output_types.*;
import com.groupdocs.signature.examples.advanced_usage.search.*;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata.*;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom.SearchForMetadataCustomEncryptionObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom.SearchForMetadataCustomSerializationObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom.SearchForMetadataEncryptedObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom.SearchForMetadataEncryptedText;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom.SearchForQRCodeCustomEncryptionObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom.SearchForQRCodeCustomSerializationObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom.SearchForQRCodeEncryptedObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom.SearchForQRCodeEncryptedText;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_standard_objects.*;
import com.groupdocs.signature.examples.advanced_usage.sign.*;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced.SignWithDigitalAdvancedPdfAppearance;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced.SignWithDigitalAdvancedPdfCertificate;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced.SignWithDigitalAdvancedPdfTimestamp;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_form_fields_advanced.SignPdfWithFormFieldAdvanced;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_form_fields_advanced.SignPdfWithFormFieldAdvancedCombobox;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_form_fields_advanced.SignPdfWithFormFieldAdvancedRadio;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_images_advanced.SignWithBase64ImageAdvanced;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_images_advanced.SignWithBase64ImageSample;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_images_advanced.SignWithImageAdvanced;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_advanced.SignImageWithCustomMetadata;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_advanced.SignPdfWithCustomMetadata;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom.SignWithMetadataCustomEncryptionObject;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom.SignWithMetadataCustomSerializationObject;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom.SignWithMetadataEncryptedObject;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom.SignWithMetadataEncryptedText;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_secure_custom.SignWithQRCodeCustomEncryptionObject;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_secure_custom.SignWithQRCodeCustomSerializationObject;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_secure_custom.SignWithQRCodeEncryptedObject;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_secure_custom.SignWithQRCodeEncryptedText;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_standard_objects.*;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_signature_implementation.*;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances.SignWithDigitalAppearance;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances.SignWithImageAppearance;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances.SignWithPdfTextAnnotation;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances.SignWithPdfTextSticker;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_positions.SignWithAlignments;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_positions.SignWithMillimeters;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_positions.SignWithPercents;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_positions.SignWithStretchMode;
import com.groupdocs.signature.examples.advanced_usage.sign.signin_with_brushes.SignWithLinearGradientBrush;
import com.groupdocs.signature.examples.advanced_usage.sign.signin_with_brushes.SignWithRadialGradientBrush;
import com.groupdocs.signature.examples.advanced_usage.sign.signin_with_brushes.SignWithSolidBrush;
import com.groupdocs.signature.examples.advanced_usage.sign.signin_with_brushes.SignWithTextureBrush;
import com.groupdocs.signature.examples.advanced_usage.signature_preview.GenerateSignaturePreviewAdvanced;
import com.groupdocs.signature.examples.advanced_usage.update.*;
import com.groupdocs.signature.examples.advanced_usage.verify.*;
import com.groupdocs.signature.examples.basic_usage.common.GetSupportedFileFormats;
import com.groupdocs.signature.examples.basic_usage.delete.*;
import com.groupdocs.signature.examples.basic_usage.document_preview.GeneratePreview;
import com.groupdocs.signature.examples.basic_usage.document_preview.GetDocumentInfo;
import com.groupdocs.signature.examples.basic_usage.document_preview.GetDocumentProcessHistory;
import com.groupdocs.signature.examples.basic_usage.search.*;
import com.groupdocs.signature.examples.basic_usage.search.metadata.*;
import com.groupdocs.signature.examples.basic_usage.sign.*;
import com.groupdocs.signature.examples.basic_usage.sign.metadata.*;
import com.groupdocs.signature.examples.basic_usage.signature_preview.GenerateSignaturePreview;
import com.groupdocs.signature.examples.basic_usage.update.UpdateBarcode;
import com.groupdocs.signature.examples.basic_usage.update.UpdateImage;
import com.groupdocs.signature.examples.basic_usage.update.UpdateQRCode;
import com.groupdocs.signature.examples.basic_usage.update.UpdateText;
import com.groupdocs.signature.examples.basic_usage.verify.*;
import com.groupdocs.signature.examples.quick_start.HelloWorld;
import com.groupdocs.signature.examples.quick_start.SetLicenseFromFile;

public class MainClass {
	public static void main(String[] args) throws Throwable {
        // TODO: Reference library from Nuget instead of local path.

        System.out.print("Open runExamples.cs. \nIn Main() method uncomment the example that you want to run.");
        System.out.print("=====================================================");

        // Please uncomment the example you want to try out
            //region Quick Start

        //SetLicenseFromFile.run();
        //QuickStart.SetLicenseFromStream.run();
        //QuickStart.SetMeteredLicense.run();

        //HelloWorld.run();
            //endregion // Quick Start

            //region Basic Usage

            //region Common
        //GetSupportedFileFormats.run();
            //endregion

            //region Document Preview

        //GetDocumentInfo.run();
        //GeneratePreview.run();
        //GetDocumentProcessHistory.run();
            //endregion

            //region Signature Preview
        //GenerateSignaturePreview.run();
            //endregion

            //region Sign document with different signature types

        //Sign document with text signature
        //SignWithText.run();

        //Sign document with image signature
        //SignWithImage.run();

        //Sign document with barcode signature
        //SignWithBarcode.run();

        //Sign document with qr-code signature
        //SignWithQRCode.run();

        //Sign document with digital signature
        //SignWithDigital.run();

        //Sign document with Stamp signature
        //SignWithStamp.run();

        //Sign image document with metadata signature
        //SignImageWithMetadata.run();

        //Sign pdf document with metadata signature
        //SignPdfWithMetadata.run();

        //Sign presentation document with metadata signature
        //SignPresentationWithMetadata.run();

        //Sign spreadsheets document with metadata signature
        //SignSpreadsheetWithMetadata.run();

        //Sign word-processing document with metadata signature
        //SignWordProcessingWithMetadata.run();

        //Sign pdf document with form-field signature
        //SignPdfWithFormField.run();

        // Sign document with multiple signature types
        //SignWithMultipleOptions.run();

            //endregion // Sign document with different signature types

            //region Search signed documents for different signature types

        //Search document for Text signature
        //SearchForText.run();

        //Search document for Image signature
        //SearchForImage.run();

        //Search document for Barcode signature
        //SearchForBarcode.run();

        //Search document for QR-Code signature
        //SearchForQRCode.run();

        //Search document for digital signature
        //SearchForDigital.run();

        //Search image document for metadata signatures
        //SearchImageForMetadata.run();

        //Search PDF document for metadata signatures
        //SearchPdfForMetadata.run();

        //Search Presentation document for metadata signatures
        //SearchPresentationForMetadata.run();

        //Search Spreadsheet document for metadata signatures
        //SearchSpreadsheetForMetadata.run();

        //Search WordProcessing document for metadata signatures
        //SearchWordProcessingForMetadata.run();

        //Search document for form-field signature
        //SearchForFormField.run();

        //Search document for multiple signature types
        //SearchForMultiple.run();

            //endregion // Search signed documents for different signature types

            //region Verify documents signed with different signature types

        //Verify document with Text signature
        //VerifyText.run();

        //Verify document with Barcode signature
        //VerifyBarcode.run();

        //Verify document with QR-Code signature
        //VerifyQRCode.run();

        //Verify document with digital signature
        //VerifyDigital.run();

        //Verify document with multiple signatures
        //VerifyWithMultipleOptions.run();

            //endregion // Verify documents signed with different signature types

            //region Update signatures in the document

        //Update Text signature in the document after Search method
        //UpdateText.run();

        //Update Image signature in the document after Search method
        //UpdateImage.run();

        //Update Barcode signature in the document after Search method
        //UpdateBarcode.run();

        //Update QR-code signature in the document after Search method
        //UpdateQRCode.run();

            //endregion

            //region Delete signatures from document

        //Delete found Text signature in the document after Search method
        //DeleteText.run();

        //Delete found Image signature in the document after Search method
        //DeleteImage.run();

        //Delete found Barcode signature in the document after Search method
        //DeleteBarcode.run();

        //Delete found QR-code signature in the document after Search method
        //DeleteQRCode.run();

        //Delete Digital signature from the document after Search method
        //DeleteDigital.run();

        //Delete few found multiple signatures in the document after Search method
        //DeleteMultiple.run();

        //Delete signature from the document by certain type
        //DeleteBySignatureType.run();

        //Delete signature from the document by known signature id
        //DeleteById.run();

            //endregion

            //endregion // Basic Usage

            //region Advanced Usage

            //region Loading

        //LoadDocumentFromLocalDisk.run();
        //LoadDocumentFromStream.run();
        //LoadDocumentFromUrl.run();
        //LoadDocumentFromAmazonS3.run();
        //LoadDocumentFromAzureBlobStorage.run();
        //LoadDocumentFromFtp.run();
        //LoadPasswordProtectedDocument.run();

            //endregion

            //region Saving

        //SaveSignedPdfWithDifferentOutputFileType.run();
        //SaveSignedSpreadsheetWithDifferentOutputFileType.run();
        //SaveSignedWordProcessingWithDifferentOutputFileType.run();
        //SaveSignedPresentationWithDifferentOutputFileType.run();
        //SaveSignedImageWithDifferentOutputFileType.run();
        //SaveSignedImageWithVariousOutputTypes.run();

        //SaveDocumentWithPassword.run();
        //SaveSignedDocumentsAsImages.run();

            //endregion

            //region Document Preview with hiding signatures
        //GeneratePreviewAdvanced.run();
        //GetDocumentInfoAdvanced.run();
        //GetDocumentProcessHistoryAdvanced.run();
            //endregion

            //region Advanced Signature Preview
        //GenerateSignaturePreviewAdvanced.run();
            //endregion

            //region Handling different special exceptions
        //HandlingIncorrectPasswordException.run();
        //HandlingPasswordRequiredException.run();
            //endregion

            //region Sign document with different signature types with additional options
        //Sign document with text signature applying specific options
        //SignWithTextAdvanced.run();

        //Sign document with digital signature applying specific options
        //SignWithDigitalAdvanced.run();

        //Sign Pdf document with digital time stamp
        //SignWithDigitalAdvancedPdfTimestamp.run();

        //Sign Pdf document with digital certificate
        //SignWithDigitalAdvancedPdfCertificate.run();

        //Sign Pdf document with digital certificate and custom appearance settings
        //SignWithDigitalAdvancedPdfAppearance.run();

        //Sign document with image signature applying specific options
        //SignWithImageAdvanced.run();

        //Sign document with image from the base64 string
        //SignWithBase64ImageSample.run();

        //Sign document with image from the base64 string created in SignImageOptions
        //SignWithBase64ImageAdvanced.run();

        //Sign document with Barcode signature applying specific options
        //SignWithBarcodeAdvanced.run();

        //Sign document with QR-Code signature applying specific options
        //SignWithQRCodeAdvanced.run();

        // Sign Pdf document with Form-fields
        //SignPdfWithFormFieldAdvanced.run();
        //SignPdfWithFormFieldAdvancedRadio.run();
        //SignPdfWithFormFieldAdvancedCombobox.run();

        // Sign Pdf document with Stamp signature
        //SignWithStampAdvanced.run();

        // Sign Spreadsheet document with XAdes signature
        //SignWithXAdESTypes.run();
            //endregion

            //region Sign with further result analysis
        //SignWithResultAnalysis.run();
            //endregion

            //region Sign with different signature implementation type
        //SignWithTextStamp.run();
        //SignWithTextAnnotation.run();
        //SignWithTextImage.run();
        //SignWithTextSticker.run();
        //SignWithTextFormField.run();
        //SignWithTextWatermark.run();
        //SignWithTextWatermarkNative.run();
            //endregion

            //region Sign QR-Code Encryption, Custom encryption, custom serialization
        //SignWithQRCodeEncryptedText.run();
        //SignWithQRCodeEncryptedObject.run();
        //SignWithQRCodeCustomEncryptionObject.run();
        //SignWithQRCodeCustomSerializationObject.run();
            //endregion

            //region Sign QR-Code standard objects
        //SignWithQRCodeCryptoCurrencyObject.run();
        //SignWithQRCodeAddressObject.run();
        //SignWithQRCodeEmailObject.run();
        //SignWithQRCodeVCardObject.run();
        //SignWithQRCodeEPCObject.run();
        //SignWithQRCodeEventObject.run();
        //SignWithQRCodeMeCardObject.run();
        //SignWithQRCodeWiFiObject.run();
        //SignWithQRCodeSMSObject.run();
            //endregion

            //region Sign Metadata advanced
        //Sign document with Metadata signature applying specific options
        //SignPdfWithStandardMetadata.run();
        //SignPdfWithCustomMetadata.run();
        //SignImageWithCustomMetadata.run();
        //SignWithMetadataEncryptedText.run();
        //SignWithMetadataEncryptedObject.run();
        //SignWithMetadataCustomEncryptionObject.run();
        //SignWithMetadataCustomSerializationObject.run();
            //endregion

            //region Sign with different annotation
        //SignWithPdfTextAnnotation.run();
        //SignWithPdfTextSticker.run();
        //SignWithImageAppearance.run();
        //SignWithDigitalAppearance.run();
            //endregion

            //region Sign with different measure type

        //SignWithMillimeters.run();
        //SignWithPercents.run();
        //SignWithAlignments.run();

            //endregion

        //SignWithStretchMode.run();

        //SignWithExceptionHandling.run();

            //region Signing with different brush styles
        //SignWithSolidBrush.run();
        //SignWithTextureBrush.run();
        //SignWithLinearGradientBrush.run();
        //SignWithRadialGradientBrush.run();
            //endregion

            //region Search signed documents for different signature types with additional options

        //Search document for Text signature with applying specific options
        //SearchForTextAdvanced.run();

        //Search document for Image signature with applying specific options
        //SearchForImageAdvanced.run();

        //Search document for Barcode signature with applying specific options
        //SearchForBarcodeAdvanced.run();

        //Search document for encrypted QR-Code signature with applying specific options
        //SearchForQRCodeAdvanced.run();

        //Search document for digital signature with applying specific options
        //SearchForDigitalAdvanced.run();

        //Search document for form-field signature with applying specific options
        //SearchForFormFieldAdvanced.run();

        //Advanced search image document for metadata signatures
        //SearchImageForMetadataAdvanced.run();

        //Advanced search PDF document for metadata signatures
        //SearchPdfForMetadataAdvanced.run();

        //Advanced search Presentation document for metadata signatures
        //SearchPresentationForMetadataAdvanced.run();

        //Advanced search Spreadsheet document for metadata signatures
        //SearchSpreadsheetForMetadataAdvanced.run();

        //Advanced search WordProcessing document for metadata signatures
        //SearchWordProcessingForMetadataAdvanced.run();

            //region Search for QR-Code Encryption, Custom encryption, custom serialization
        //SearchForMetadataEncryptedText.run();
        //SearchForMetadataEncryptedObject.run();
        //SearchForMetadataCustomEncryptionObject.run();
        //SearchForMetadataCustomSerializationObject.run();
            //endregion

            //region Search for QR-Code standard objects
        //SearchForQRCodeAddressObject.run();
        //SearchForQRCodeEmailObject.run();
        //SearchForQRCodeVCardObject.run();
        //SearchForQRCodeEPCObject.run();
        //SearchForQRCodeEventObject.run();
        //SearchForQRCodeMeCardObject.run();
        //SearchForQRCodeWiFiObject.run();
        //SearchForQRCodeSMSObject.run();
            //endregion

        //SearchWithExceptionHandling.run();
            //endregion // Search signed documents for different signature types with additional options

            //region Search for QR-Code Encryption, custom encryption, custom serialization
        //SearchForQRCodeEncryptedText.run();
        //SearchForQRCodeEncryptedObject.run();
        //SearchForQRCodeCustomEncryptionObject.run();
        //SearchForQRCodeCustomSerializationObject.run();
            //endregion

        //SearchAndSkipExternalSignatures.run();

            //region Verify signed documents with additional options

        //Verify document with Text signature with applying specific options
        //VerifyTextAdvanced.run();

        //Verify document with Barcode signature with applying specific options
        //VerifyBarcodeAdvanced.run();

        //Verify document with QR-Code signature with applying specific options
        //VerifyQRCodeAdvanced.run();

        //Verify document with digital signature with applying specific options
        //VerifyDigitalAdvanced.run();

            //endregion // Verify signed documents with additional options

            //region Subscribing for signing, verification, searching events
        //SubscribeSignEvents.run();
        //SubscribeVerifyEvents.run();
        //SubscribeSearchEvents.run();
            //endregion

            //region Cancellation of signing, verification, searching process
        //CancellationSignProcess.run();

        //CancellationVerifyProcess.run();
        //CancellationSearchProcess.run();
            //endregion

        //VerifyWithExceptionHandling.run();


            //region Updating document signatures
        //UpdateTextAfterSearch.run();
        //UpdateTextById.run();
        //UpdateImageAfterSearch.run();
        //UpdateImageById.run();
        //UpdateBarcodeAfterSearch.run();
        //UpdateBarcodeById.run();
        //UpdateQRCodeAfterSearch.run();
        //UpdateQRCodeById.run();

        //UpdateMultipleAdvanced.run();
            //endregion

            //region Delete signatures from the document
        //DeleteTextAfterSearch.run();
        //DeleteTextById.run();
        //DeleteImageAfterSearch.run();
        //DeleteImageById.run();
        //DeleteBarcodeAfterSearch.run();
        //DeleteBarcodeById.run();
        //DeleteQRCodeAfterSearch.run();
        //DeleteQRCodeById.run();
        //DeleteDigitalAfterSearch.run();
        //DeleteDigitalById.run();
        //DeleteMultipleAdvanced.run();
        //DeleteBySignatureTypes.run();
        //DeleteByListIds.run();
            //endregion

            //region Processing signatures over all CRUD operation to show full signature process life-cycle
        //ProcessingTextSignatureOverCRUD.run();
        //ProcessingImageSignatureOverCRUD.run();
        //ProcessingBarcodeSignatureOverCRUD.run();
        //ProcessingQrCodeSignatureOverCRUD.run();
            //endregion

        //SignWithOrdering.run();
            //endregion    // Advanced Usage

        //System.out.print("\nAll done.");

	}
}
