package com.groupdocs.signature.examples.advanced_usage.common;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.handler.events.ProcessProgressEventArgs;
import com.groupdocs.signature.handler.events.ProcessProgressEventHandler;
import com.groupdocs.signature.options.verify.TextVerifyOptions;

public class CancellationVerifyProcess {
    /**
     * Defines on progress event
     *
     * @param sender
     * @param args
     */
    private static void onVerifyProgress(Signature sender, ProcessProgressEventArgs args) {
        // check if process takes more than 1 second (1000 milliseconds) processing cancellation
        if (args.getTicks() > 1000) {
            args.setCancel(true);
            System.out.print("Verify progress was cancelled. Time spent " + args.getTicks() + " mlsec");
        }
    }

    public static void run() throws Exception {

        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # CancellationVerifyProcess : Defines on progress event.\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;

        try {
            Signature signature = new Signature(filePath);
            signature.VerifyProgress.add(new ProcessProgressEventHandler() {
                public void invoke(Signature sender, ProcessProgressEventArgs args) {
                    onVerifyProgress(sender, args);
                }
            });

            TextVerifyOptions options = new TextVerifyOptions("John Smith")
            {
                // ...
            };

            // sign document to file
            VerificationResult result = signature.verify(options);
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}
