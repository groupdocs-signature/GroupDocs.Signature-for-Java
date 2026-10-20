package com.groupdocs.signature.examples.advanced_usage.logging;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.SignatureSettings;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.logging.ConsoleLogger;
import com.groupdocs.signature.logging.LogLevel;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class ConsoleLoggingWithLogLevels
{
    /**
     * <p>
     * Choose which kinds of messages are written to the log
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # ConsoleLoggingWithLogLevels : Choose which kinds of messages are written to the log\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "ConsoleLoggingWithLogLevels\\" + fileName).getPath();

        // LogLevel decides which kinds of messages reach the logger (it takes effect since version 26.9).
        // Its values are flags: Error, Warning and Trace. LogLevel.All is the default, LogLevel.None logs nothing.
        // Signing with an expired certificate that is explicitly allowed writes a warning.
        System.out.print("\nSigning with LogLevel.None:");
        SignatureSettings noLog = new SignatureSettings(new ConsoleLogger());
        noLog.setLogLevel(LogLevel.None);
        final Signature signature = new Signature(filePath, noLog);
        try /*JAVA: was using*/
        {
            DigitalSignOptions options = new DigitalSignOptions(Constants.CertificateExpiredPfx);
            options.setAllowExpired(true);
            signature.sign(outputFilePath, options);
        }
        finally { if (signature != null) (signature).dispose(); }

        System.out.print("\n\nSigning with LogLevel.Error | LogLevel.Warning:");
        SignatureSettings warnings = new SignatureSettings(new ConsoleLogger());
        // errors and warnings, without the step-by-step traces
        warnings.setLogLevel(LogLevel.Error | LogLevel.Warning);
        final Signature signature2 = new Signature(filePath, warnings);
        try /*JAVA: was using*/
        {
            DigitalSignOptions options = new DigitalSignOptions(Constants.CertificateExpiredPfx);
            options.setAllowExpired(true);
            signature2.sign(outputFilePath, options);
        }
        finally { if (signature2 != null) (signature2).dispose(); }

        System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }
}
