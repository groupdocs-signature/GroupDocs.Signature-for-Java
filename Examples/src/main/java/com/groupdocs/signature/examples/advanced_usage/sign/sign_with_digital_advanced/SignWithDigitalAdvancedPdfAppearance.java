package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_digital_advanced;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.PdfDigitalSignature;
import com.groupdocs.signature.domain.structs.TimeStamp;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.appearances.PdfDigitalSignatureAppearance;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.awt.*;
import java.io.File;

public class SignWithDigitalAdvancedPdfAppearance
{
    /**
     * <p>
     * Sign document with digital signature applying PDF document-specific options
     * Please be aware that this example works only on licensed product due to limitation with Pdf processing
     * </p>
     */
    public static void run() throws Exception {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithDigitalAdvancedPdf : Sign document with digital signature applying PDF document-specific options\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String certificatePath = Constants.CertificatePfx;

        String outputFilePathSigned = new File(Constants.OutputPath, "SignWithDigitalAdvancedPdf\\digitallySignedPdfAppearance.pdf").getPath();
        String outputFilePathCertified = new File(Constants.OutputPath, "SignWithDigitalAdvancedPdf\\digitallyCertified.pdf").getPath();

        //Sign pdf document with digital signature and time stamp
        Signature signature = new Signature(filePath);

        //Create digital signing options
        DigitalSignOptions options = new DigitalSignOptions(certificatePath);
        // certificate password
        options.setPassword("1234567890");
        // digital certificate details
        options.setReason("Approved");
        options.setLocation("New York");

        // apply custom PDF signature appearance
        PdfDigitalSignatureAppearance appearance = new PdfDigitalSignatureAppearance();

        // do now show contact details
        appearance.setContactInfoLabel("");
        // simplify reason label
        appearance.setReasonLabel("R:");
        // change location label
        appearance.setLocationLabel("@=>");
        appearance.setDigitalSignedLabel("By:");
        appearance.setDateSignedAtLabel("On");
        // apply custom appearance color
        appearance.setBackground(Color.red);
        // apply custom font settings
        appearance.setFontFamilyName("Courier");
        appearance.setFontSize(8);

        options.setAppearance(appearance);
        //
        options.setAllPages(true);
        options.setWidth(160);
        options.setHeight(80);
        options.setVerticalAlignment(VerticalAlignment.Center);
        options.setHorizontalAlignment(HorizontalAlignment.Left);
        options.setMargin(new Padding(0, 10,0, 10));

        // setup signature border
        Border border = new Border();
        border.setVisible(true);
        border.setColor(Color.red);
        border.setDashStyle(DashStyle.DashDot);
        border.setWeight(2);
        options.setBorder(border);

        SignResult signResult = signature.sign(outputFilePathSigned, options);
        System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePathSigned);

        System.out.print("\nList of newly created signatures:");
        int number = 1;
        for (BaseSignature temp : signResult.getSucceeded()) {
            System.out.print("Signature # " + number++ + ": Type: " + temp.getSignatureType() + " Id:" + temp.getSignatureId() + ", Location: " + temp.getLeft() + "x" + temp.getTop() + ". Size: " + temp.getWidth() + "x" + temp.getHeight());
        }
    }
}
