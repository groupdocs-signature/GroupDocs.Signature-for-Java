package com.groupdocs.signature.examples.advanced_usage.common;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.handler.events.*;
import com.groupdocs.signature.options.verify.TextVerifyOptions;

import java.io.File;
import java.nio.file.Paths;

public class SubscribeVerifyEvents {
    /**
     * Defines on start process event handler
     * @param sender
     * @param args
     */
    private static void onVerifyStarted(Signature sender, ProcessStartEventArgs args)
    {
        System.out.print("Verify process started at "+args.getStarted()+" with "+args.getTotalSignatures()+" total signatures to be put in document");
    }

    /**
     * Defines on progress event
     * @param sender
     * @param args
     */
    private static void onVerifyProgress(Signature sender, ProcessProgressEventArgs args)
    {
        System.out.print("Verify progress. Processed "+args.getProcessedSignatures()+" signatures. Time spent "+args.getTicks()+" mlsec");
    }

    /**
     * Defines on completed event
     * @param sender
     * @param args
     */
    private static void onVerifyCompleted(Signature sender, ProcessCompleteEventArgs args)
    {
        System.out.print("Verify process completed at "+args.getCompleted()+" with "+args.getTotalSignatures()+" total signatures. Process took "+args.getTicks()+" mlsec");
    }


    /**
     * Verify document with text signature applying specific options and subscribe for events
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;

        try {
            Signature signature = new Signature(filePath);
            signature.VerifyStarted.add(new ProcessStartEventHandler() {
                public void invoke(Signature sender, ProcessStartEventArgs args) {
                    onVerifyStarted(sender, args);
                }
            });


            signature.VerifyProgress.add(new ProcessProgressEventHandler() {
                public void invoke(Signature sender, ProcessProgressEventArgs args) {
                    onVerifyProgress(sender, args);
                }


            });
            signature.VerifyCompleted.add(new ProcessCompleteEventHandler() {
                public void invoke(Signature sender, ProcessCompleteEventArgs args) {
                    onVerifyCompleted(sender, args);
                }
            });

            TextVerifyOptions options = new TextVerifyOptions("John Smith");
            options.setAllPages(true);

            // verify document
            VerificationResult result = signature.verify(options);
            if (result.isValid())
            {
                System.out.print("\nDocument was verified successfully!");
        }
            else
            {
                System.out.print("\nDocument failed verification process.");
            }

        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}