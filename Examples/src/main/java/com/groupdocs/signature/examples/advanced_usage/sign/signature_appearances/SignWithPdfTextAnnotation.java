package com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignatureFont;
import com.groupdocs.signature.domain.enums.*;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.appearances.PdfTextAnnotationAppearance;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.awt.*;
import java.io.File;

public class SignWithPdfTextAnnotation {

    /**
     * Sign document with text signature applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;

        String outputFilePath = new File(Constants.OutputPath, "SignWithAppearances\\PdfAnnotation.pdf").getPath();

        try {
            Signature signature = new Signature(filePath);
            TextSignOptions options = new TextSignOptions("John Smith");

            // set signature position
            options.setLeft(100);
            options.setTop(100);

            // set signature rectangle
            options.setWidth(100);
            options.setHeight(30);
            // setup proper signature implementation
            options.setSignatureImplementation(TextSignatureImplementation.Annotation);

            PdfTextAnnotationAppearance appearance = new PdfTextAnnotationAppearance();
            Border border = new Border();
            border.setColor(Color.BLUE);
            border.setDashStyle(DashStyle.Dash);
            border.setWeight(2);
            appearance.setBorder(border);
            appearance.setBorderEffect(PdfTextAnnotationBorderEffect.Cloudy);
            appearance.setBorderEffectIntensity(2);
            appearance.setHCornerRadius(10);

            // text content of an annotation
            appearance.setContents("Sample");
            appearance.setSubject("Sample subject");
            appearance.setTitle("Sample Title");

            options.setAppearance(appearance);
            // set signature alignment
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);
            Padding padding = new Padding();
            padding.setBottom(20);
            padding.setRight(20);
            options.setMargin(padding);
            // set text color and Font
            options.setForeColor(Color.RED);
            SignatureFont signatureFont = new SignatureFont();
            signatureFont.setSize(12);
            signatureFont.setFamilyName("Comic Sans MS");
            options.setFont(signatureFont);

            // sign document to file
            signature.sign(outputFilePath, options);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}