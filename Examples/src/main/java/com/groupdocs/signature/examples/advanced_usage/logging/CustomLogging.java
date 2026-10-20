package com.groupdocs.signature.examples.advanced_usage.logging;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.SignatureSettings;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.logging.ILogger;
import com.groupdocs.signature.logging.LogLevel;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogging
{
    /**
     * <p>
     * Using Custom Logging: the document is loaded with a wrong password, the error goes to a custom logger
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # CustomLogging : Using Custom Logging\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED_PWD;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "CustomLogging\\" + fileName).getPath();

        LoadOptions loadOptions = new LoadOptions();
        // specify wrong password
        loadOptions.setPassword("12345678901");

        CustomLogger logger = new CustomLogger();
        SignatureSettings settings = new SignatureSettings(logger);
        // setup custom log level
        settings.setLogLevel(LogLevel.Warning | LogLevel.Error);

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
            // skip the Exception - check the custom log
        }
        System.out.print("\nThe custom log above shows why the document was not signed.");
    }

    /**
     * <p>
     * Writes log messages in a custom format. Replace postMessage to send them
     * to a log file, a logging framework or an API endpoint.
     * </p>
     */
    public static class CustomLogger implements ILogger
    {
        private final Object lock = new Object();

        /**
         * Error log messages provide information about unrecoverable events in application flow.
         */
        public void error(String message, Exception exception)
        {
            if (message == null)
                throw new IllegalArgumentException("message");
            if (exception == null)
                throw new IllegalArgumentException("exception");
            postMessage(LogLevel.Error, message + ". Exception: " + exception);
        }

        /**
         * Trace log messages provide generally useful information about application flow.
         */
        public void trace(String message)
        {
            if (message == null)
                throw new IllegalArgumentException("message");
            postMessage(LogLevel.Trace, message);
        }

        /**
         * Warning log messages provide information about the unexpected and recoverable event in application flow.
         */
        public void warning(String message)
        {
            if (message == null)
                throw new IllegalArgumentException("message");
            postMessage(LogLevel.Warning, message);
        }

        private void postMessage(int level, String message)
        {
            String header = "INFO";
            switch (level)
            {
                case LogLevel.Warning: header = "WARNING"; break;
                case LogLevel.Error: header = "ERROR"; break;
            }
            String date = new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(new Date());
            String line = "GroupDocs.Signature " + header + " [" + date + "]. Message: " + message;
            synchronized (lock)
            {
                System.out.print("\n" + line);
            }
        }
    }
}
