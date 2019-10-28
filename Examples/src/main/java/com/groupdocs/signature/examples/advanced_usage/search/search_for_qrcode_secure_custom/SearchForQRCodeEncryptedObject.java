package com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricAlgorithmType;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricEncryption;
import com.groupdocs.signature.domain.extensions.serialization.FormatAttribute;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.examples.advanced_usage.custom_encryption.CustomXOREncryption;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;

import java.util.List;

public class SearchForQRCodeEncryptedObject {
    public static class DocumentSignatureData
    {
        public String getID(){ return ID; }
        public void setID(String value){ ID = value; }
        @FormatAttribute(propertyName = "SignID")
        public String ID;


        public final String getAuthor(){ return Author; }
        public final void setAuthor(String value){ Author = value; }
        @FormatAttribute(propertyName = "SAuth")
        public String Author;
        //JAVA-added public wrapper for internalized property accessor

        public final java.util.Date getSigned() {  return Signed; }
        public final void setSigned(java.util.Date value) { Signed = value; }
        @FormatAttribute (propertyName = "SDate",propertyFormat = "yyyy-MM-dd")
        public java.util.Date Signed = new java.util.Date();


        public final java.math.BigDecimal getDataFactor() { return DataFactor; }
        public final void setDataFactor(java.math.BigDecimal value) { DataFactor = value; }
        @FormatAttribute (propertyName = "SDFact",propertyFormat = "N2")
        public java.math.BigDecimal DataFactor = new java.math.BigDecimal(0.01);
    }

    /**
     * Search document for QR-Code signature with applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_QRCODE_CUSTOM_ENCRYPTION_OBJECT;

        try {
            Signature signature = new Signature(filePath);
            // setup key and passphrase
            String key = "1234567890";
            String salt = "1234567890";
            // create data encryption
            IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);

            QrCodeSearchOptions options = new QrCodeSearchOptions();
            // specify special pages to search on
            options.setAllPages(true);
            options.setPageNumber(1);
            PagesSetup pagesSetup = new PagesSetup();
            pagesSetup.setFirstPage(false);
            pagesSetup.setLastPage(true);
            pagesSetup.setOddPages(false);
            pagesSetup.setEvenPages(true);
            options.setPagesSetup(pagesSetup);
            // specify types of QR code to verify
            options.setEncodeType(QrCodeTypes.QR);
            options.setDataEncryption(encryption);


            // search for signatures in document
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class,options);
            System.out.print("\nSource document contains following signatures:");
            for (QrCodeSignature qrCodeSignature : signatures)
            {
                System.out.print("QRCode signature found at page "+qrCodeSignature.getPageNumber()+" with type "+ qrCodeSignature.getEncodeType());
                DocumentSignatureData documentSignatureData = qrCodeSignature.getData(DocumentSignatureData.class);
                if (documentSignatureData != null)
                {
                    System.out.print("QRCode signature has DocumentSignatureData object:\n ID = " + documentSignatureData.getID() + ", Author = " + documentSignatureData.getAuthor() + ", Signed = " + documentSignatureData.getSigned() + ", DataFactor "+documentSignatureData.getDataFactor());
                }
            }
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}
