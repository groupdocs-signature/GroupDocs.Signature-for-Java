package com.groupdocs.signature.examples.advanced_usage.common;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.handler.events.ProcessProgressEventArgs;
import com.groupdocs.signature.handler.events.ProcessProgressEventHandler;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;

import java.util.List;

public class CancellationSearchProcess {

    /**
     * Defines on progress event
     *
     * @param sender
     * @param args
     */
    private static void onSearchProgress(Signature sender, ProcessProgressEventArgs args) {
        // check if process takes more than 1 second (1000 milliseconds) processing cancellation
        if (args.getTicks() > 1000) {
            args.setCancel(true);
            System.out.print("search progress was cancelled. Time spent " + args.getTicks() + " mlsec");
        }
    }

    public static void run() {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;

        try {
            Signature signature = new Signature(filePath);
            signature.SearchProgress.add(new ProcessProgressEventHandler() {
                public void invoke(Signature sender, ProcessProgressEventArgs args) {
                    onSearchProgress(sender, args);
                }
            });

            QrCodeSearchOptions options = new QrCodeSearchOptions(QrCodeTypes.QR) {
                // ...
            };

            // search for signatures in document
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, options);
            System.out.print("\nSource document contains following signatures.");
            for(QrCodeSignature qr_signature : signatures)
            {
                System.out.print("QRCode signature found at page "+qr_signature.getPageNumber()+" with type "+ qr_signature.getEncodeType()+" and text " + qr_signature.getText());
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}