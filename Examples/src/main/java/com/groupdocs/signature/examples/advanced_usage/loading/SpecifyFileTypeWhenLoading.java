package com.groupdocs.signature.examples.advanced_usage.loading;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.documentpreview.FileType;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SpecifyFileTypeWhenLoading
{
    /**
     * <p>
     * Specify file type when loading a document
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SpecifyFileTypeWhenLoading : Specify file type when loading a document\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SpecifyFileTypeWhenLoading\\" + fileName).getPath();

        // the file type is taken from the load options instead of being detected from the document content
        LoadOptions loadOptions = new LoadOptions(FileType.PDF);

        final Signature signature = new Signature(filePath, loadOptions);
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

        System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }
}
