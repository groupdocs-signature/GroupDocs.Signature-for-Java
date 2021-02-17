package com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.serialization.FormatAttribute;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.examples.advanced_usage.custom_encryption.CustomXOREncryption;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;

import java.util.List;

public class SearchForQRCodeCustomSerializationObject {
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
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_QRCODE_CUSTOM_ENCRYPTION_OBJECT;

        try {
            Signature signature = new Signature(filePath);
            // create data encryption
            IDataEncryption encryption = new CustomXOREncryption();

            QrCodeSearchOptions options = new QrCodeSearchOptions();

            // specify special pages to search on
            options.setAllPages(true);
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
