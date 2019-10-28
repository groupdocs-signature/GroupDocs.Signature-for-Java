package com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata_secure_custom;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricAlgorithmType;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricEncryption;
import com.groupdocs.signature.domain.signatures.metadata.WordProcessingMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.search.MetadataSearchOptions;

import java.util.List;

public class SearchForMetadataEncryptedText {
    /**
     * Search document for metadata signature with applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX_METADATA_ENCRYPTED_TEXT;

        try {
            Signature signature = new Signature(filePath);
            // setup key and passphrase
            String key = "1234567890";
            String salt = "1234567890";
            // create data encryption
            IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);

            MetadataSearchOptions options = new MetadataSearchOptions();
            options.setDataEncryption(encryption);

            // search for signatures in document
            List<WordProcessingMetadataSignature> signatures = signature.search(WordProcessingMetadataSignature.class,options);
            System.out.print("\nSource document contains following signatures.");

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