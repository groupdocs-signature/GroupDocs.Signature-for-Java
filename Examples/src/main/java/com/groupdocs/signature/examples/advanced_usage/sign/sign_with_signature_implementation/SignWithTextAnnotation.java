package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_signature_implementation;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.*;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.appearances.PdfTextAnnotationAppearance;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;


public class SignWithTextAnnotation {
    /**
     * Sign document with text signature applying Annotation implementation type
     */

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithTextAnnotation : Sign document with text signature applying Annotation implementation type\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithTextAnnotation\\" + fileName).getPath();

        Signature signature = new Signature(filePath);
        {
            TextSignOptions options = new TextSignOptions("John Smith");

                // set alternative signature implementation on document page
                options.setSignatureImplementation(TextSignatureImplementation.Annotation);
                // for Pdf document type there is ability to setup extended appearances
                PdfTextAnnotationAppearance appearance = new PdfTextAnnotationAppearance();
                Border border= new Border();
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
                // set alignment
                options.setVerticalAlignment(VerticalAlignment.Top);
                options.setHorizontalAlignment(HorizontalAlignment.Right);
                // set margin with 20 pixels for all sides
                options.setMargin(new Padding(20));

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, options);
            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath+".");
        }
    }
}
