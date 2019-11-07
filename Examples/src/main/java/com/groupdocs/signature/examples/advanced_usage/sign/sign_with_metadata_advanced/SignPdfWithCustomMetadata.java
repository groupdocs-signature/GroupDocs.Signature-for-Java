package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_advanced;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricAlgorithmType;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricEncryption;
import com.groupdocs.signature.domain.extensions.serialization.FormatAttribute;
import com.groupdocs.signature.domain.signatures.metadata.PdfMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.MetadataSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SignPdfWithCustomMetadata {
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
     * Sign pdf document with metadata signature with customer object and encryption
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignPdfWithCustomMetadata-" + fileName).getPath();
        try{

            Signature signature = new Signature(filePath);

            // setup key and passphrase
            String key = "1234567890";
            String salt = "1234567890";
            // create data encryption
            IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);

            // setup options with text of signature
            MetadataSignOptions options = new MetadataSignOptions();

            // create custom object
            DocumentSignatureData documentSignature = new DocumentSignatureData();
            documentSignature.setID(java.util.UUID.randomUUID().toString());
            documentSignature.setAuthor(System.getenv("USERNAME"));
            documentSignature.setSigned(new java.util.Date());
            documentSignature.setDataFactor(new java.math.BigDecimal("11.22"));

            // Specify different Metadata Signatures and add them to options signature collection
            // setup Author property
            PdfMetadataSignature mdDocument = new PdfMetadataSignature("DocumentSignature", documentSignature);
            // set encryption
            mdDocument.setDataEncryption(encryption);



            // setup Author property
            PdfMetadataSignature mdAuthor = new PdfMetadataSignature("Author", "Mr.Scherlock Holmes");
            // set encryption
            mdAuthor.setDataEncryption(encryption);

            // setup data of document id
            PdfMetadataSignature mdDocId = new PdfMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());
            // set encryption
            mdDocId.setDataEncryption(encryption);

            // add signatures to options
            options.getSignatures().add(mdDocument);
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
