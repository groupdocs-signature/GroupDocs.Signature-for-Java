package com.groupdocs.signature.examples.advanced_usage.logging;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.SignatureSettings;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.logging.FileLogger;
import com.groupdocs.signature.logging.LogLevel;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class FileLogging
{
    /**
     * <p>
     * Using file Logging: the document is loaded with a wrong password, the error is written to a log file
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # FileLogging : Using file Logging\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED_PWD;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "FileLogging\\" + fileName).getPath();
        String outputLogFile = new File(Constants.OutputPath, "Logging\\signature-log.txt").getPath();
        Constants.checkDir(outputLogFile);

        LoadOptions loadOptions = new LoadOptions();
        // wrong password
        loadOptions.setPassword("12345678901");

        FileLogger logger = new FileLogger(outputLogFile);
        SignatureSettings settings = new SignatureSettings(logger);
        // setup custom log level
        settings.setLogLevel(LogLevel.Trace | LogLevel.Error);

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
            // skip the Exception - check the log file
        }
        System.out.print("\nThe log file shows why the document was not signed.\nLog saved at " + outputLogFile);
    }
}
