package com.groupdocs.signature.examples.advanced_usage.logging;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.SignatureSettings;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.logging.ConsoleLogger;
import com.groupdocs.signature.logging.LogLevel;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class ConsoleLogging
{
    /**
     * <p>
     * Using Console Logging: the document is loaded with a wrong password, the error is written to the console
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # ConsoleLogging : Using Console Logging\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED_PWD;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "ConsoleLogging\\" + fileName).getPath();

        LoadOptions loadOptions = new LoadOptions();
        // specify wrong password
        loadOptions.setPassword("12345678901");

        ConsoleLogger logger = new ConsoleLogger();
        SignatureSettings settings = new SignatureSettings(logger);
        // setup custom log level
        settings.setLogLevel(LogLevel.Trace | LogLevel.Warning | LogLevel.Error); // same as LogLevel.All

        try
        {
            final Signature signature = new Signature(filePath, loadOptions, settings);
            try /*JAVA: was using*/
            {
                QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
                options.setEncodeType(QrCodeTypes.QR);
                options.setLeft(100);
                options.setTop(100);

                // sign document to file
                signature.sign(outputFilePath, options);
            }
            finally { if (signature != null) (signature).dispose(); }
        }
        catch (Exception e)
        {
            // skip the Exception - check the log
        }
        System.out.print("\nThe log above shows why the document was not signed.");
    }
}
