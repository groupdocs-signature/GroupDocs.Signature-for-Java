package com.groupdocs.signature.examples.advanced_usage.saving;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.OoxmlCompliance;
import com.groupdocs.signature.domain.enums.WordProcessingSaveFileFormat;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.saveoptions.WordProcessingSaveOptions;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.io.File;
import java.nio.file.Paths;

public class SaveWordProcessingWithOoxmlCompliance
{
    /**
     * <p>
     * Sign WordProcessing document with explicit OOXML compliance
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SaveWordProcessingWithOoxmlCompliance : Sign WordProcessing document with explicit OOXML compliance\n");

        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "SaveWordProcessingWithOoxmlCompliance\\" + fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // simple text signature
            TextSignOptions signOptions = new TextSignOptions("John Smith");
            signOptions.setLeft(100);
            signOptions.setTop(100);
            signOptions.setWidth(200);
            signOptions.setHeight(60);

            // Force ISO 29500:2008 Strict on save regardless of the source's compliance.
            // Other allowed values: OoxmlCompliance.Ecma, OoxmlCompliance.Transitional.
            WordProcessingSaveOptions saveOptions = new WordProcessingSaveOptions(WordProcessingSaveFileFormat.Docx);
            saveOptions.setOoxmlCompliance(OoxmlCompliance.Strict);

            SignResult result = signature.sign(outputFilePath, signOptions, saveOptions);
            System.out.print("\nSource document signed successfully with " + result.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath + ".");
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
