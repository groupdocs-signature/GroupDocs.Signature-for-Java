package com.groupdocs.signature.examples.advanced_usage.common;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.handler.events.ProcessProgressEventArgs;
import com.groupdocs.signature.handler.events.ProcessProgressEventHandler;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class CancellationSignProcess {
    /**
     * Defines on progress event
     *
     * @param sender
     * @param args
     */
    private static void onSignProgress(Signature sender, ProcessProgressEventArgs args) {
        // check if process takes more than 1 second (1000 milliseconds) processing cancellation
        if (args.getTicks() > 1000) {
            args.setCancel(true);
            System.out.print("Sign progress was cancelled. Time spent " + args.getTicks() + " mlsec");
        }
    }

    /**
     * Sign document with text signature applying specific options
     */
    public static void run() throws Exception {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithTextEvents\\"+ fileName).getPath();
        try {
            Signature signature = new Signature(filePath);
            signature.SignProgress.add(new ProcessProgressEventHandler() {
                public void invoke(Signature sender, ProcessProgressEventArgs args) {
                    onSignProgress(sender, args);
                }
            });

            TextSignOptions options = new TextSignOptions("John Smith") {
                // ...
            };

            // sign document to file
            signature.sign(outputFilePath, options);
                System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);

        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}