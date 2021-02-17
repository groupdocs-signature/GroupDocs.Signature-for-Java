package com.groupdocs.signature.examples.advanced_usage.search.search_for_qrcode_secure_custom;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricAlgorithmType;
import com.groupdocs.signature.domain.extensions.encryption.SymmetricEncryption;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;

import java.util.List;

public class SearchForQRCodeEncryptedText {
    /**
     * Search document for QR-Code signature with applying specific options
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_QRCODE_ENCRYPTED_TEXT;

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
            pagesSetup.setFirstPage(true);
            pagesSetup.setLastPage(true);
            pagesSetup.setOddPages(false);
            pagesSetup.setEvenPages(false);
            options.setPagesSetup(pagesSetup);
            // specify types of QR code to verify
            options.setEncodeType(QrCodeTypes.QR);
            options.setDataEncryption(encryption);


            // search for signatures in document
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class,options);
            System.out.print("\nSource document contains following signatures:");
            for (QrCodeSignature qrCodeSignature : signatures)
            {
                System.out.print("QRCode signature found at page "+qrCodeSignature.getPageNumber()+" with type "+qrCodeSignature.getEncodeType().getTypeName()+" and text "+ qrCodeSignature.getText());
            }
        }catch(Exception e){
            System.out.print( e.getClass());
        }
    }
}