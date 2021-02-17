package com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.serialization.FormatAttribute;
import com.groupdocs.signature.domain.signatures.metadata.WordProcessingMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.examples.advanced_usage.custom_encryption.CustomXOREncryption;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.search.MetadataSearchOptions;

import java.util.List;

public class SearchForMetadataCustomSerializationObject {
    // Define custom data signature class
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
     * Search document for metadata signature with applying specific options
     */
    public static void run() throws Exception
    {
    // The path to the documents directory.
    String filePath = Constants.SAMPLE_DOCX_METADATA_CUSTOM_SERIALIZATION_OBJECT;
    try {
        Signature signature = new Signature(filePath);

        // create data encryption
        IDataEncryption encryption = new CustomXOREncryption();

        MetadataSearchOptions options = new MetadataSearchOptions();
        options.setDataEncryption(encryption);

        // search for signatures in document
        List<WordProcessingMetadataSignature> signatures = signature.search(WordProcessingMetadataSignature.class,options);
        System.out.print("\nSource document contains following signatures.");
        // get required metadata signatures
        WordProcessingMetadataSignature wordSignature = null;
        for (WordProcessingMetadataSignature mdSign : signatures) {
            if (mdSign.getName().equals("Signature")) {
                wordSignature = mdSign;
                break;
            }
        }
        if (wordSignature != null)
        {
            DocumentSignatureData documentSignatureData = wordSignature.getData(DocumentSignatureData.class);
            if (documentSignatureData != null)
            {
                System.out.print("Signature has DocumentSignatureData object:\n ID = " + documentSignatureData.getID() + ", Author = " + documentSignatureData.getAuthor() + ", Signed = " + documentSignatureData.getSigned() + ", DataFactor " + documentSignatureData.getDataFactor());
            }
        }
        // get required metadata signatures
        WordProcessingMetadataSignature mdAuthor = null;
        for (WordProcessingMetadataSignature mdSign : signatures) {
            if (mdSign.getName().equals("Author")) {
                mdAuthor = mdSign;
                break;
            }
        }
        if (mdAuthor != null)
        {
            System.out.print("Metadata signature found. Name : " + mdAuthor.getName() + ". Value: " + mdAuthor.getData(String.class));
        }
        // get required metadata signatures
        WordProcessingMetadataSignature mdDocId = null;
        for (WordProcessingMetadataSignature mdSign : signatures) {
            if (mdSign.getName().equals("DocumentId")) {
                mdDocId = mdSign;
                break;
            }
        }
        if (mdDocId != null)
        {
            System.out.print("Metadata signature found. Name : " + mdDocId.getName() + ". Value: " + mdDocId.getData(String.class));
        }
    }catch(Exception e){
        throw new GroupDocsSignatureException(e.getMessage());
    }
    }
}