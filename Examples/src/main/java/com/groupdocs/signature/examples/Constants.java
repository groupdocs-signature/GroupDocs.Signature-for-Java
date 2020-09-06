package com.groupdocs.signature.examples;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;


import com.groupdocs.signature.SignatureSettings;
import com.groupdocs.signature.licensing.License;
import com.groupdocs.signature.metered.Metered;

public class Constants {

	// Storage path
	public static final String SamplesPath = (System.getProperty("user.dir") + "\\Resources\\SampleFiles\\");
	// License path
	public static final String LicensePath = "C:\\License\\GroupDocs.Signature.Java.lic";
	// Output path
	public static final String OutputPath = (System.getProperty("user.dir") + "\\Resources\\Output\\");
	//Certificates path
	public static final String CertificatesPath = (System.getProperty("user.dir") + "\\Resources\\SampleFiles\\Certificates\\");
	// Image path
	public static final String ImagesPath = (System.getProperty("user.dir") + "\\Resources\\SampleFiles\\Images\\");

    // Images
    public static String ImageHandwrite = new File(ImagesPath, "signature-handwrite.jpg").getPath();
    public static String ImageStamp = new File(ImagesPath, "stamp.png").getPath();
    //Certificate
    public static String CertificatePfx = new File(CertificatesPath, "MrSmithSignature.pfx").getPath();
    public static String CertificateCer = new File(CertificatesPath, "signtest.cer").getPath();


    private static String getSampleFilePath(String filePath){
        return new File(SamplesPath, filePath).getPath();
    }
    // WordProcessing documents
    public static String SAMPLE_DOCX  = getSampleFilePath("getting started.docx");
    public static String SAMPLE_DOCX_BARCODE_SIGNED  = getSampleFilePath("AllSignatures.docx");

    public static String SAMPLE_PDF  = getSampleFilePath( "sample.pdf");

    public static String SAMPLE_PPTX  = getSampleFilePath( "butterfly effect.pptx");

    public static String SAMPLE_PDF_SIGNED = getSampleFilePath("sample_signed.pdf");

    public static String SAMPLE_PDF_SIGNED_METADATA = getSampleFilePath("SignedWithMetadata.pdf");
    public static String SAMPLE_PRESENTATION_SIGNED_METADATA = getSampleFilePath("SignedWithMetadata.ppsx");
    public static String SAMPLE_SPREADSHEET_SIGNED_METADATA = getSampleFilePath("SignedWithMetadata.xlsx");
    public static String SAMPLE_WORDSPROCESSING_SIGNED_METADATA = getSampleFilePath("SignedWithMetadata.docx");
    public static String SAMPLE_IMAGE_SIGNED_METADATA = getSampleFilePath("SignedWithMetadata.jpg");

    public static String SAMPLE_PDF_QRCODE_ENCRYPTED_TEXT  = getSampleFilePath("QRCodeEncryptedText.pdf");
    public static String SAMPLE_PDF_QRCODE_ENCRYPTED_OBJECT  = getSampleFilePath("QRCodeEncryptedObject.pdf");
    public static String SAMPLE_PDF_QRCODE_CUSTOM_ENCRYPTION_OBJECT  = getSampleFilePath("QRCodeCustomEncryptionObject.pdf");
    public static String SAMPLE_PDF_QRCODE_CUSTOM_SERIALIZATION_OBJECT  = getSampleFilePath("QRCodeCustomSerializationObject.pdf");

    public static String SAMPLE_PDF_QRCODE_VCARD_OBJECT    = getSampleFilePath("QRCodeVCardObject.pdf");
    public static String SAMPLE_PDF_QRCODE_ADDRESS_OBJECT    = getSampleFilePath("QRCodeAddressObject.pdf");
    public static String SAMPLE_PDF_QRCODE_EMAIL_OBJECT    = getSampleFilePath("QRCodeEmailObject.pdf");
    public static String SAMPLE_PDF_QRCODE_MECARD_OBJECT    = getSampleFilePath("QRCodeMeCardObject.pdf");
    public static String SAMPLE_PDF_QRCODE_EPC_OBJECT    = getSampleFilePath("QRCodeEPCObject.pdf");
    public static String SAMPLE_PDF_QRCODE_EVENT_OBJECT    = getSampleFilePath("QRCodeEventObject.pdf");

    public static String SAMPLE_WORD_SIGNED  = getSampleFilePath("AllSignatures.docx");
    public static String SAMPLE_DOCX_METADATA_ENCRYPTED_TEXT  = getSampleFilePath("MetadataEncryptedText.docx");
    public static String SAMPLE_DOCX_METADATA_ENCRYPTED_OBJECT  = getSampleFilePath("MetadataEncryptedObject.docx");
    public static String SAMPLE_DOCX_METADATA_CUSTOM_ENCRYPTION_OBJECT = getSampleFilePath("MetadataCustomEncryptionObject.docx");
    public static String SAMPLE_DOCX_METADATA_CUSTOM_SERIALIZATION_OBJECT  = getSampleFilePath("MetadataCustomSerializationObject.docx");

    public static String SAMPLE_PDF_SIGNED_FORMFIELD  = getSampleFilePath( "signed_formfield.pdf");

    public static String SAMPLE_SIGNED_PWD_PDF = getSampleFilePath("sample_signed_pwd.pdf");
    // Spreadsheet document files
    public static String SAMPLE_SPREADSHEET = getSampleFilePath( "sample.xlsx");

    public static String SAMPLE_SPREADSHEET_SIGNED = getSampleFilePath( "signed_sample.xlsx");
    public static String SAMPLE_SPREADSHEET_TEXT_SIGNED = getSampleFilePath( "TextStamp.xlsx");

    // Presentation document files
    public static String SAMPLE_PRESENTATION = getSampleFilePath( "sample.ppsx");

    // Image
    public static String SAMPLE_JPG  = getSampleFilePath( "sample.jpg");

    public static void checkDir(String filePath) throws Exception
    {
        File dir = new File(filePath);

        if (!dir.exists())
        {
            dir.getParentFile().mkdirs();
        }
    }

}
