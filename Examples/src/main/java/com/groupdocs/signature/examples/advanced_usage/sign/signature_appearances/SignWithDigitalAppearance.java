package com.groupdocs.signature.examples.advanced_usage.sign.signature_appearances;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.appearances.DigitalSignatureAppearance;
import com.groupdocs.signature.options.sign.DigitalSignOptions;

import java.io.File;

public class SignWithDigitalAppearance {

    /**
     * Sign document with digital signature
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_WORDPROCESSING;
        String imagePath = Constants.ImageHandwrite;
        String certificatePath = Constants.CertificatePfx;

        String outputFilePath = new File(Constants.OutputPath, "SignWithAppearances\\DigitalAppearance.docx").getPath();

        try {
            Signature signature = new Signature(filePath);
            DigitalSignOptions options = new DigitalSignOptions(certificatePath);

            // certifiate password
            options.setPassword("1234567890");
            // digital certificate details
            options.setReason("Sign");
            options.setContact("JohnSmith");
            options.setLocation("Office1");

            // image as digital certificate appearance on document pages
            options.setImageFilePath(imagePath);
            //
            options.setAllPages(true);
            options.setWidth(0);
            options.setHeight(60);
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);
            Padding padding = new Padding();
            padding.setBottom(10);
            padding.setRight(10);
            options.setMargin(padding);
            // Setup signature line appearance.
            // This appearance will add Signature Line on the first page.
            // Could be useful for .xlsx files.
            options.setAppearance(new DigitalSignatureAppearance("John Smith", "Title", "jonny@test.com"));

            signature.sign(outputFilePath, options);


            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}