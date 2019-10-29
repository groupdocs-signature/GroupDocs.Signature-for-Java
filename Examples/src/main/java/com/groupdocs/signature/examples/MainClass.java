package com.groupdocs.signature.examples;

import com.groupdocs.signature.examples.advanced_usage.common.*;
import com.groupdocs.signature.examples.advanced_usage.loading.LoadPasswordProtectedDocument;
import com.groupdocs.signature.examples.advanced_usage.loading.loading_documents_from_different_sources.*;
import com.groupdocs.signature.examples.advanced_usage.saving.SaveDocumentWithPassword;
import com.groupdocs.signature.examples.advanced_usage.saving.SaveSignedDocumentsAsImages;
import com.groupdocs.signature.examples.advanced_usage.saving.SaveSignedImageWithVariousOutputTypes;
import com.groupdocs.signature.examples.advanced_usage.saving.save_documents_with_different_output_types.*;
import com.groupdocs.signature.examples.advanced_usage.search.*;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom.SearchForMetadataCustomEncryptionObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom.SearchForMetadataCustomSerializationObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom.SearchForMetadataEncryptedObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom.SearchForMetadataEncryptedText;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom.SearchForQRCodeCustomEncryptionObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom.SearchForQRCodeCustomSerializationObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom.SearchForQRCodeEncryptedObject;
import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom.SearchForQRCodeEncryptedText;
import com.groupdocs.signature.examples.advanced_usage.sign.*;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_advanced.SignImageWithCustomMetadata;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_advanced.SignPdfWithCustomMetadata;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom.SignWithMetadataCustomEncryptionObject;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom.SignWithMetadataCustomSerializationObject;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom.SignWithMetadataEncryptedObject;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom.SignWithMetadataEncryptedText;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances.SignWithDigitalAppearance;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances.SignWithImageAppearance;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances.SignWithPdfTextAnnotation;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances.SignWithPdfTextSticker;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_positions.SignWithAlignments;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_positions.SignWithMillimeters;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_positions.SignWithPercents;
import com.groupdocs.signature.examples.advanced_usage.sign.signature_positions.SignWithStretchMode;
import com.groupdocs.signature.examples.advanced_usage.sign.singin_with_brushes.SignWithLinearGradientBrush;
import com.groupdocs.signature.examples.advanced_usage.sign.singin_with_brushes.SignWithRadialGradientBrush;
import com.groupdocs.signature.examples.advanced_usage.sign.singin_with_brushes.SignWithSolidBrush;
import com.groupdocs.signature.examples.advanced_usage.sign.singin_with_brushes.SignWithTextureBrush;
import com.groupdocs.signature.examples.advanced_usage.verify.*;
import com.groupdocs.signature.examples.basic_usage.common.GetSupportedFileFormats;
import com.groupdocs.signature.examples.basic_usage.document_preview.GeneratePreview;
import com.groupdocs.signature.examples.basic_usage.document_preview.GetDocumentInfo;
import com.groupdocs.signature.examples.basic_usage.search.*;
import com.groupdocs.signature.examples.basic_usage.sign.*;
import com.groupdocs.signature.examples.basic_usage.sign.metadata.*;
import com.groupdocs.signature.examples.basic_usage.verify.VerifyBarcode;
import com.groupdocs.signature.examples.basic_usage.verify.VerifyDigital;
import com.groupdocs.signature.examples.basic_usage.verify.VerifyQRCode;
import com.groupdocs.signature.examples.basic_usage.verify.VerifyText;
import com.groupdocs.signature.examples.quick_start.HelloWorld;
import com.groupdocs.signature.examples.quick_start.SetLicenseFromFile;
import com.groupdocs.signature.examples.quick_start.SetLicenseFromStream;
import com.groupdocs.signature.examples.quick_start.SetMeteredLicense;

public class MainClass {
	public static void main(String[] args) throws Throwable {
        // TODO: Reference library from Nuget instead of local path.

        System.out.print("Open RunExamples.cs. \nIn Main() method uncomment the example that you want to run.");
        System.out.print("=====================================================");

        // Please uncomment the example you want to try out

        //region Quick Start

        //SetLicenseFromFile.run();
        //SetLicenseFromStream.run();
        //SetMeteredLicense.run();
        //HelloWorld.run();
        //endregion // Quick Start

        //return;
        //region Basic Usage

        //region Common

        //GetSupportedFileFormats.run();

        //endregion

        //region Document Preview

        //GetDocumentInfo.run();
        //GeneratePreview.run();
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
       // SignImageWithMetadata.run();

        //Sign pdf document with text signature
        //SignPdfWithMetadata.run();

        //Sign presentation document with text signature
        //SignPresentationWithMetadata.run();

        //Sign spreadsheets document with text signature
        //SignSpreadsheetWithMetadata.run();

        //Sign word-processing document with text signature
        //SignWordProcessingWithMetadata.run();

        //Sign pdf document with form - field signature
        //SignPdfWithFormField.run();

        //SignWithMultipleOptions.run();

        //endregion // Sign document with different signature types

        //region Search signed documents for different signature types

        //Search document for Bar-Code signature
        //SearchForBarcode.run();

        //Search document for QR-Code signature
        //SearchForQRCode.run();

        //Search document for digital signature
        //SearchForDigital.run();

        //Search document for metadata signature
        //SearchForMetadata.run();

        //Search document for form-field signature
        //SearchForFormField.run();

        //Search for signature with multiple options
        //SearchForMultiple.run();

        //endregion // Search signed documents for different signature types

        //region Verify documents signed with different signature types

        //Verify document with Text signature
        //VerifyText.run();

        //Verify document with Bar-Code signature
        //VerifyBarcode.run();

        //Verify document with QR-Code signature
        //VerifyQRCode.run();

        //Verify document with digital signature
        //VerifyDigital.run();

        //endregion // Verify documents signed with different signature types

        //endregion // Basic Usage

        //region Advanced Usage

        //region Loading
        //LoadDocumentFromLocalDisk.run();
        //LoadDocumentFromStream.run();
        //LoadDocumentFromUrl.run();
        //LoadDocumentFromAmazonS3.run();
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

        //region Sign document with different signature types with additional options

        //Sign document with text signature applying specific options
        //SignWithTextAdvanced.run();

        //Sign document with image signature applying specific options
        //SignWithImageAdvanced.run();

        //Sign document with Bar-Code signature applying specific options
        //SignWithBarcodeAdvanced.run();

        //Sign document with QR-Code signature applying specific options
        //SignWithQRCodeAdvanced.run();

        // Sign Pdf document with Form-fields
        //SignPdfWithFormFieldAdvanced.run();

        //SignWithStampAdvanced.run();

        //endregion

        //region Sign QR-Code Encryption, Custom encryption, custom serialization
        //SearchForQRCodeEncryptedText.run();
        //SearchForQRCodeEncryptedObject.run();
        //SearchForQRCodeCustomEncryptionObject.run();
        //SearchForQRCodeCustomSerializationObject.run();
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

        //region Sining with different brush styles
        //SignWithSolidBrush.run();
        //SignWithTextureBrush.run();
        //SignWithLinearGradientBrush.run();
        //SignWithRadialGradientBrush.run();
        //endregion

        //region Search signed documents for different signature types with additional options

        //Search document for Bar-Code signature with applying specific options
       // SearchForBarcodeAdvanced.run();

        //Search document for encrypted QR-Code signature with applying specific options
        //SearchForQRCodeAdvanced.run();

        //Search document for digital signature with applying specific options
       // SearchForDigitalAdvanced.run();

        //Search document for form-field signature with applying specific options
        //SearchForFormFieldAdvanced.run();

        //Search document for metadata signature with applying specific options
        //SearchForMetadataAdvanced.run();

        //SearchForMetadataEncryptedText.run();
        //SearchForMetadataEncryptedObject.run();
        //SearchForMetadataCustomEncryptionObject.run();
        //SearchForMetadataCustomSerializationObject.run();

        //SearchWithExceptionHandling.run();
        //endregion // Search signed documents for different signature types with additional options

        //region Verify signed documents with additional options

        //Verify document with Text signature with applying specific options
        //VerifyTextAdvanced.run();

        //Verify document with Bar-Code signature with applying specific options
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
        //endregion // Advanced Usage

        //System.out.print("\nAll done.");

	}
}
