package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.serialization.FormatAttribute;
import com.groupdocs.signature.domain.signatures.metadata.WordProcessingMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.examples.advanced_usage.custom_encryption.CustomXOREncryption;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.MetadataSignOptions;

import java.io.File;

public class SignWithMetadataCustomSerializationObject {
    // Define custom data signature class with custom serialization
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

    /// <summary>
    /// Sign pdf document with metadata signature with customer object and encryption
    /// </summary>
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;

        String outputFilePath = new File(Constants.OutputPath, "SignWithMetadataSecureCustom//MetadataCustomSerializationObject.docx").getPath();

        try{
            Signature signature = new Signature(filePath);
            // create data encryption
            IDataEncryption encryption = new CustomXOREncryption();

            // setup options with text of signature
            MetadataSignOptions options = new MetadataSignOptions();

            // set encryption for all metadata signatures for this options
            // if you need separate encryption use own MetadataSignature.DataEncryption property
            options.setDataEncryption(encryption);

            // create custom object
            DocumentSignatureData documentSignature = new DocumentSignatureData();
            documentSignature.setID(java.util.UUID.randomUUID().toString());
            documentSignature.setAuthor(System.getenv("USERNAME"));
            documentSignature.setSigned(new java.util.Date());
            documentSignature.setDataFactor(new java.math.BigDecimal("11.22"));
            // setup signature metadata
            WordProcessingMetadataSignature mdSignature = new WordProcessingMetadataSignature("Signature", documentSignature);

            // setup signature metadata
            WordProcessingMetadataSignature mdAuthor = new WordProcessingMetadataSignature("Author", "Mr.Scherlock Holmes");

            // setup data of document id
            WordProcessingMetadataSignature mdDocId = new WordProcessingMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());

            // add signatures to options
            options.getSignatures().add(mdSignature);
            options.getSignatures().add(mdAuthor);
            options.getSignatures().add(mdDocId);

            // sign document to file
            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}