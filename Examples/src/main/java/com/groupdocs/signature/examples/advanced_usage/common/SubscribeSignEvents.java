package com.groupdocs.signature.examples.advanced_usage.common;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.handler.events.*;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SubscribeSignEvents {
    /**
     * Defines on start process event handler
     * @param sender
     * @param args
     */
    private static void onSignStarted(Signature sender, ProcessStartEventArgs args)
    {
        System.out.print("Sign process started at "+args.getStarted()+" with "+args.getTotalSignatures()+" total signatures to be put in document");
    }

    /**
     * Defines on progress event
     * @param sender
     * @param args
     */
    private static void onSignProgress(Signature sender, ProcessProgressEventArgs args)
    {
        System.out.print("Sign progress. Processed "+args.getProcessedSignatures()+" signatures. Time spent "+args.getTicks()+" mlsec");
    }

    /**
     * Defines on completed event
     * @param sender
     * @param args
     */
    private static void onSignCompleted(Signature sender, ProcessCompleteEventArgs args)
    {
        System.out.print("Sign process completed at "+args.getCompleted()+" with "+args.getTotalSignatures()+" total signatures. Process took "+args.getTicks()+" mlsec");
    }


    /**
     * Sign document with text signature applying specific options
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithTextEvents\\"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);
            signature.SignStarted.add(new ProcessStartEventHandler() {
                public void invoke(Signature sender, ProcessStartEventArgs args) {
                    onSignStarted(sender, args);
                }
            });


            signature.SignProgress.add(new ProcessProgressEventHandler() {
                public void invoke(Signature sender, ProcessProgressEventArgs args) {
                    onSignProgress(sender, args);
                }


            });
            signature.SignCompleted.add(new ProcessCompleteEventHandler() {
                public void invoke(Signature  sender, ProcessCompleteEventArgs args) {
                    onSignCompleted(sender, args);
                }
            });

            TextSignOptions options = new TextSignOptions("John Smith");
            // set signature position 
            options.setLeft(100);
            options.setTop(100);

            signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);

        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}