package com.groupdocs.signature.examples.basic_usage.common;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.SignatureFont;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.licensing.License;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.awt.Color;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LicenceUsing
{
    /**
     * <p>
     * Using GroupDocs license for various file formats
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # LicenceUsing : Using GroupDocs license for various file formats\n");

        //Signing documents in trial mode
        String trialOutPath = new File(Constants.OutputPath, "LicenceUsing\\Trial").getPath();
        signFiles(trialOutPath);

        //Setting license
        License lic = new License();
        lic.setLicense(Constants.LicensePath);

        //Signing documents in licensed mode
        String licenseOutPath = new File(Constants.OutputPath, "LicenceUsing\\License").getPath();
        signFiles(licenseOutPath);
    }

    private static void signFiles(String outPath) throws Exception
    {
        List<String> files = new ArrayList<String>();
        files.add(Constants.SAMPLE_PDF);
        files.add(Constants.SAMPLE_IMAGE);
        files.add(Constants.SAMPLE_SPREADSHEET);
        files.add(Constants.SAMPLE_PRESENTATION);
        files.add(Constants.SAMPLE_WORDPROCESSING);

        for (String item : files)
        {
            String fileName = Paths.get(item).getFileName().toString();
            String outputFilePath = new File(outPath, fileName).getPath();
            signFile(item, outputFilePath);
        }
    }

    private static void signFile(String filePath, String outputFilePath) throws Exception
    {
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            TextSignOptions options = new TextSignOptions("John Smith");
            options.setSignatureImplementation(TextSignatureImplementation.Image);
            // set signature position
            options.setLeft(100);
            options.setTop(100);
            // set signature rectangle
            options.setWidth(100);
            options.setHeight(30);
            // set Text color and Font
            options.setForeColor(Color.RED);
            SignatureFont font = new SignatureFont();
            font.setSize(12);
            font.setFamilyName("Comic Sans MS");
            options.setFont(font);

            // sign document to file
            SignResult result = signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with " + result.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath + ".");
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
