package com.groupdocs.signature.examples.advanced_usage.signature_preview;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.DocumentType;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PageSignatureStreamFactory;
import com.groupdocs.signature.options.PreviewFormats;
import com.groupdocs.signature.options.PreviewSignatureOptions;
import com.groupdocs.signature.options.appearances.PdfDigitalSignatureAppearance;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class GenerateSignaturePreviewAdvanced
{
    /**
     * Generate signature preview
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # GenerateSignaturePreviewAdvanced : Generate Pdf Digital Signature preview");
        // no need Siganture object since method is static
        // get certificate to check simulation preview with its data
        String certificatePath = Constants.CertificatePfx;
        // create options
        DigitalSignOptions signOptions = new DigitalSignOptions(certificatePath);
        {
            // set the DocumentType property to specify simulating PDF signature appearance
            signOptions.setDocumentType(DocumentType.Pdf);
            // certificate password
            signOptions.setPassword("1234567890");
            // digital certificate details
            signOptions.setReason("Approved");
            signOptions.setContact("John Smith");
            signOptions.setLocation("New York");

            // apply custom PDF signature appearance
            PdfDigitalSignatureAppearance pdfDigSignAppearance = new PdfDigitalSignatureAppearance();
            {
                // do now show contact details
                pdfDigSignAppearance.setContactInfoLabel("Contact");
                // simplify reason label
                pdfDigSignAppearance.setReasonLabel("R:");
                // change location label
                pdfDigSignAppearance.setLocationLabel("@=>");
                pdfDigSignAppearance.setDigitalSignedLabel("By:");
                pdfDigSignAppearance.setDateSignedAtLabel("On:");
                // apply custom appearance color
                pdfDigSignAppearance.setBackground(Color.GRAY);
                // apply custom font settings
                pdfDigSignAppearance.setFontFamilyName("Courier");
                pdfDigSignAppearance.setFontSize(8);
            }
            //
            signOptions.setAllPages(false);
            signOptions.setWidth(200);
            signOptions.setHeight(130);
            signOptions.setVerticalAlignment(VerticalAlignment.Center);
            signOptions.setHorizontalAlignment(HorizontalAlignment.Left);
            Padding padding = new Padding();
            padding.setBottom(10);
            padding.setRight(10);
            signOptions.setMargin(padding);

            // setup signature border
            Border border = new Border();
            border.setVisible(true);
            border.setColor(Color.DARK_GRAY);
            border.setDashStyle(DashStyle.DashDot);
            border.setWeight(2);
            signOptions.setBorder(border);

        };

        // create signature preview options object
        PreviewSignatureOptions previewOption = new PreviewSignatureOptions(signOptions, new PageSignatureStreamFactory() {
            @Override
            public OutputStream createSignatureStream(PreviewSignatureOptions previewOptions) {
                return generateSignatureStream(previewOptions);
            }

            @Override
            public void closeSignatureStream(PreviewSignatureOptions previewOptions, OutputStream pageStream) {
                releaseSignatureStream(previewOptions, pageStream);
            }
        });

        previewOption.setSignatureId(UUID.randomUUID().toString());
        previewOption.setPreviewFormat(PreviewFormats.JPEG);

        // generate preview
        Signature.generateSignaturePreview(previewOption);
    }

    private static OutputStream generateSignatureStream(PreviewSignatureOptions previewOptions)
    {
        try {
            Path path = Paths.get(Constants.OutputPath, "\\GenerateSignaturePreviewAdvanced\\");
            if (!Files.exists(path)) {

                Files.createDirectory(path);
                System.out.println("Directory created");
            } else {

                System.out.println("Directory already exists");
            }
            File imageFilePath = new File(path+"\\signature"+previewOptions.getSignatureId()+"-"+previewOptions.getSignOptions().getSignatureType()+".jpg");
            return new FileOutputStream(imageFilePath);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    private static void releaseSignatureStream(PreviewSignatureOptions previewOptions, OutputStream signatureStream)
    {
        try {
            signatureStream.close();
            String imageFilePath = new File(Constants.OutputPath + "\\GeneratePreviewHideSignatures\\signature"+previewOptions.getSignatureId()+"-"+previewOptions.getSignOptions().getSignatureType()+".jpg").getPath();
            System.out.print("Image file "+imageFilePath+" is ready for preview");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
