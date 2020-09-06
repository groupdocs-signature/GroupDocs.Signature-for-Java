package com.groupdocs.signature.examples;



import com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_standard_objects.*;
import com.groupdocs.signature.examples.advanced_usage.sign.*;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_form_fields_advanced.SignPdfWithFormFieldAdvanced;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_form_fields_advanced.SignPdfWithFormFieldAdvancedRadio;
import com.groupdocs.signature.examples.advanced_usage.sign.sign_with_signature_implementation.*;
import com.groupdocs.signature.examples.basic_usage.delete.*;
import com.groupdocs.signature.examples.basic_usage.document_preview.GeneratePreview;
import com.groupdocs.signature.examples.basic_usage.document_preview.GetDocumentInfo;
import com.groupdocs.signature.examples.basic_usage.search.*;
import com.groupdocs.signature.examples.basic_usage.sign.*;
import com.groupdocs.signature.examples.basic_usage.sign.metadata.*;
import com.groupdocs.signature.examples.basic_usage.update.UpdateBarcode;
import com.groupdocs.signature.examples.basic_usage.update.UpdateImage;
import com.groupdocs.signature.examples.basic_usage.update.UpdateQRCode;
import com.groupdocs.signature.examples.basic_usage.verify.VerifyBarcode;
import com.groupdocs.signature.examples.basic_usage.verify.VerifyDigital;
import com.groupdocs.signature.examples.basic_usage.verify.VerifyQRCode;
import com.groupdocs.signature.examples.basic_usage.verify.VerifyText;
import com.groupdocs.signature.examples.quick_start.SetLicenseFromFile;

public class MainClass {
	public static void main(String[] args) throws Throwable {
        // TODO: Reference library from Nuget instead of local path.

        System.out.print("Open RunExamples.cs. \nIn Main() method uncomment the example that you want to run.");
        System.out.print("=====================================================");

        // Please uncomment the example you want to try out

        //region Quick Start

        SetLicenseFromFile.run();
        //SetLicenseFromStream.run();
        //SetMeteredLicense.run();
        //HelloWorld.run();
        //endregion // Quick Start

        //return;

        //GeneratePreviewAdvanced.run();


        //region Basic Usage

        //region Common

        //GetSupportedFileFormats.run();

        //endregion

        //region Document Preview

        //GetDocumentInfo.run();
        //GeneratePreview.run();
        //endregion

        //region Sign document with different signature types

        // Sign Pdf document with Form-fields
        //SignPdfWithFormFieldAdvanced.run();
       // SignPdfWithFormFieldAdvancedRadio.run();

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

        //region Sign with different signature implementation type
        //SignWithTextStamp.run();
        //SignWithTextAnnotation.run();
        //SignWithTextImage.run();
        //SignWithTextSticker.run();
        //SignWithTextFormField.run();
        //SignWithTextWatermark.run();
        //SignWithTextWatermarkNative.run();
        //endregion

        //SignWithXAdESTypes.run();

        //SignWithMultipleOptions.run();

        //endregion // Sign document with different signature types

        //region Search signed documents for different signature types

        //region Search for QR-Code standard objects
        //SearchForQRCodeAddressObject.run();
        //SearchForQRCodeEmailObject.run();
        //SearchForQRCodeVCardObject.run();
        //SearchForQRCodeEPCObject.run();
        //SearchForQRCodeEventObject.run();
        //SearchForQRCodeMeCardObject.run();
        //endregion


        //Search document for Bar-Code signature
        //SearchForBarcode.run();

        //Search document for QR-Code signature
        //SearchForQRCode.run();

        //Search document for digital signature
        //SearchForDigital.run();


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
//>>>>>>>> #region  Update different signatutes in the document


        //Update Image signature in the document
        //UpdateImage.run();

        //Update Barcode signature in the document
        //UpdateBarcode.run();

        //Update QR-Code signature in the document
        //UpdateQRCode.run();


        //<<<<<<<< #endregion

        //>>>>>>>> #region  Delete different signatutes in the document

        ////Delete Text signature from the document
        //DeleteText.run();

        ////Delete Image signature from the document
        //DeleteImage.run();

        ////Delete Barcode signature from the document
        //DeleteBarcode.run();

        ////Delete QR-Code signature from the document
        //DeleteQRCode.run();

        ////Delete multiple signatures from the document
        //DeleteMultiple.run();
        //<<<<<<<< #endregion
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

        //region Handling different special exceptions
        //HandlingIncorrectPasswordException.run();
        //HandlingPasswordRequiredException.run();
        //endregion

        //region Sign document with different signature types with additional options

        //Sign document with text signature applying specific options
        SignWithTextAdvanced.run();

        //Sign document with image signature applying specific options
        SignWithImageAdvanced.run();

        //Sign document with Bar-Code signature applying specific options
        SignWithBarcodeAdvanced.run();

        //Sign document with QR-Code signature applying specific options
        SignWithQRCodeAdvanced.run();

        // Sign Spreadsheet document with XAdes signature
        SignWithXAdESTypes.run();

        // Sign Pdf document with Form-fields
        SignPdfWithFormFieldAdvanced.run();

        SignWithStampAdvanced.run();

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
        //Search document for Text signature with applying specific options
        //SearchForTextAdvanced.run(); //PDF TEXT NULL POINTER

        //Search document for Image signature with applying specific options
        //SearchForImageAdvanced.run();
        //SearchAndSkipExternalSignatures.run();

        //Search document for Bar-Code signature with applying specific options
        //SearchForBarcodeAdvanced.run();

        //Search document for encrypted QR-Code signature with applying specific options
        //SearchForQRCodeAdvanced.run();

        //Search document for digital signature with applying specific options
        //SearchForDigitalAdvanced.run();

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
