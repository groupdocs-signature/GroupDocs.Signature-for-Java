package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_metadata_secure_custom;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricAlgorithmType;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricEncryption;
import com.groupdocs.signature.domain.signatures.metadata.WordProcessingMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.MetadataSignOptions;

import java.io.File;

public class SignWithMetadataEncryptedText {
    /**
    * Sign pdf document with metadata signature with customer object and encryption
    */
    public static void run() throws Exception
    {
        String filePath = Constants.SAMPLE_WORDPROCESSING;

        String outputFilePath = new File(Constants.OutputPath, "SignWithMetadataSecureCustom//MetadataEncryptedText.docx").getPath();
        try{
            Signature signature = new Signature(filePath);

            // setup key and passphrase
            String key = "1234567890";
            String salt = "1234567890";
            // create data encryption
            IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);

            // setup options with text of signature
            MetadataSignOptions options = new MetadataSignOptions();

            // set encryption for all metadata signatures for this options
            // if you need separate encryption use own MetadataSignature.DataEncryption property
            options.setDataEncryption(encryption);

            // setup signature metadata
            WordProcessingMetadataSignature mdAuthor = new WordProcessingMetadataSignature("Author", "Mr.Scherlock Holmes");

            // setup data of document id
            WordProcessingMetadataSignature mdDocId = new WordProcessingMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());

            // add signatures to options
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