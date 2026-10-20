package com.groupdocs.signature.examples.advanced_usage.sign;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.SignatureFont;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.SignOptions;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.awt.Color;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignWithTextFontStyles
{
    /**
     * <p>
     * Sign document with text signatures using different font styles
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithTextFontStyles : Sign document with text signatures using different font styles\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithTextFontStyles\\" + fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // Fonts are set with the SignatureFont properties.
            TextSignOptions boldItalic = new TextSignOptions("John Smith");
            boldItalic.setLeft(100);
            boldItalic.setTop(100);
            boldItalic.setForeColor(new Color(0, 0, 139)); // dark blue
            SignatureFont boldItalicFont = new SignatureFont();
            boldItalicFont.setFamilyName("Arial");
            boldItalicFont.setSize(16);
            boldItalicFont.setBold(true);
            boldItalicFont.setItalic(true);
            boldItalic.setFont(boldItalicFont);

            TextSignOptions underline = new TextSignOptions("Approved");
            underline.setLeft(100);
            underline.setTop(150);
            underline.setForeColor(new Color(0, 128, 0)); // green
            SignatureFont underlineFont = new SignatureFont();
            underlineFont.setFamilyName("Arial");
            underlineFont.setSize(14);
            underlineFont.setUnderline(true);
            underline.setFont(underlineFont);

            TextSignOptions strikeout = new TextSignOptions("Draft");
            strikeout.setLeft(100);
            strikeout.setTop(200);
            strikeout.setForeColor(Color.RED);
            SignatureFont strikeoutFont = new SignatureFont();
            strikeoutFont.setFamilyName("Arial");
            strikeoutFont.setSize(14);
            strikeoutFont.setStrikeout(true);
            strikeout.setFont(strikeoutFont);

            List<SignOptions> listOptions = new ArrayList<SignOptions>();
            listOptions.add(boldItalic);
            listOptions.add(underline);
            listOptions.add(strikeout);

            SignResult signResult = signature.sign(outputFilePath, listOptions);
            System.out.print("\nSource document signed successfully with " + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath + ".");
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
