package com.groupdocs.signature.examples;

import java.io.File;

public class Constants {

	// Storage path
	public static final String SamplesPath = (System.getProperty("user.dir") + "\\Resources\\SampleFiles\\");
	// License path
	public static final String LicensePath = "E:\\Lisbon\\Java_products\\License_Unlimited\\Conholdate.Total.Product.Family.lic";
	// Output path
	public static final String OutputPath = (System.getProperty("user.dir") + "\\Resources\\Output\\");
	//Certificates path
	public static final String CertificatesPath = (System.getProperty("user.dir") + "\\Resources\\SampleFiles\\Certificates\\");
	// Image path
	public static final String ImagesPath = (System.getProperty("user.dir") + "\\Resources\\SampleFiles\\Images\\");

    // Images
    public static String ImageHandwrite = new File(ImagesPath, "signature_handwrite.jpg").getPath();
    public static String ImageStamp = new File(ImagesPath, "stamp.png").getPath();
    //Certificate
    public static String CertificatePfx = new File(CertificatesPath, "MrSmithSignature.pfx").getPath();
    public static String CertificateCer = new File(CertificatesPath, "signtest.cer").getPath();


    private static String getSampleFilePath(String filePath){
        return new File(SamplesPath, filePath).getPath();
    }
    // WordProcessing documents
    public static String SAMPLE_DOCX  = getSampleFilePath("getting started.docx");
    public static String SAMPLE_WORDPROCESSING
            = getSampleFilePath("sample.docx");
    public static String SAMPLE_FORMS_DOCX
            = getSampleFilePath("sample_formfields.docx");
    public static String SAMPLE_SIGNED_MULTI
            = getSampleFilePath("sample_multiple_signatures.docx");
    public static String SAMPLE_HISTORY
            = getSampleFilePath("sample_history.docx");

    // PDF
    public static String SAMPLE_PDF
            = getSampleFilePath("sample.pdf");
    public static String SAMPLE_PDF_SIGNED
            = getSampleFilePath("sample_signed.pdf");
    public static String SAMPLE_PDF_SIGNED_FORMFIELD
            = getSampleFilePath("sample_formfields.pdf");
    public static String SAMPLE_PDF_SIGNED_PWD
             = getSampleFilePath("sample_signed_pwd.pdf");
    public static String SAMPLE_PDF_SIGNED_DIGITAL
            = getSampleFilePath("sample_signed_digital.pdf");

    //Spreadsheets
    public static String SAMPLE_SPREADSHEET
            = getSampleFilePath("sample.xlsx");

    // Presentations
    public static String SAMPLE_PRESENTATION
            = getSampleFilePath("sample.pptx");

    // Images
    public static String SAMPLE_IMAGE
            = getSampleFilePath("sample.png");
    public static String SAMPLE_IMAGE_JPG
            = getSampleFilePath("sample.jpg");

    //Metadata
    public static String SAMPLE_PDF_SIGNED_METADATA = getSampleFilePath("sample_signed_metadata.pdf");
    public static String SAMPLE_PRESENTATION_SIGNED_METADATA = getSampleFilePath("sample_signed_metadata.pptx");
    public static String SAMPLE_SPREADSHEET_SIGNED_METADATA = getSampleFilePath("sample_signed_metadata.xlsx");
    public static String SAMPLE_WORDSPROCESSING_SIGNED_METADATA = getSampleFilePath("sample_signed_metadata.docx");
    public static String SAMPLE_IMAGE_SIGNED_METADATA = getSampleFilePath("sample_signed_metadata.jpg");
    public static String SAMPLE_DOCX_METADATA_ENCRYPTED_TEXT
            = getSampleFilePath("sample_metadata_encrypted_text.docx");
    public static String SAMPLE_DOCX_METADATA_ENCRYPTED_OBJECT
            = getSampleFilePath("sample_metadata_encrypted_object.docx");
    public static String SAMPLE_DOCX_METADATA_CUSTOM_ENCRYPTION_OBJECT
            = getSampleFilePath("sample_metadata_custom_encryption_object.docx");
    public static String SAMPLE_DOCX_METADATA_CUSTOM_SERIALIZATION_OBJECT
            = getSampleFilePath("sample_metadata_custom_serialization_object.docx");
    //QrCode encryption and serialization
    public static String SAMPLE_PDF_QRCODE_ENCRYPTED_TEXT
            = getSampleFilePath("sample_qrcode_encrypted_text.pdf");
    public static String SAMPLE_PDF_QRCODE_ENCRYPTED_OBJECT
            = getSampleFilePath("sample_qrcode_encrypted_object.pdf");
    public static String SAMPLE_PDF_QRCODE_CUSTOM_ENCRYPTION_OBJECT
            = getSampleFilePath("sample_qrcode_custom_encryption_object.pdf");
    public static String SAMPLE_PDF_QRCODE_CUSTOM_SERIALIZATION_OBJECT
            = getSampleFilePath("sample_qrcode_custom_serialization_object.pdf");
    public static String SAMPLE_PDF_QRCODE_VCARD_OBJECT
            = getSampleFilePath("sample_qrcode_vcard_object.pdf");
    public static String SAMPLE_PDF_QRCODE_ADDRESS_OBJECT
            = getSampleFilePath("sample_qrcode_address_object.pdf");
    public static String SAMPLE_PDF_QRCODE_EMAIL_OBJECT
            = getSampleFilePath("sample_qrcode_email_object.pdf");
    public static String SAMPLE_PDF_QRCODE_MECARD_OBJECT
            = getSampleFilePath("sample_qrcode_mecard_object.pdf");
    public static String SAMPLE_PDF_QRCODE_EPC_OBJECT
            = getSampleFilePath("sample_qrcode_epc_object.pdf");
    public static String SAMPLE_PDF_QRCODE_EVENT_OBJECT
            = getSampleFilePath("sample_qrcode_event_object.pdf");

    public static void checkDir(String filePath) throws Exception
    {
        File dir = new File(filePath);

        if (!dir.exists())
        {
            dir.getParentFile().mkdirs();
        }
    }

}
