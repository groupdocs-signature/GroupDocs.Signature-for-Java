package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_images_advanced;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.internal.c.a.ms.System.IO.Path;
import com.groupdocs.signature.options.sign.ImageSignOptions;
import org.apache.commons.codec.binary.Base64;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class SignWithBase64ImageSample {
    /**
     * <p>
     * Sign document with image signature applying image from base64 string content
     * </p>
     */
    public static void run()  throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithBase64ImageAdvanced : Sign document with base64 image\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Path.getFileName(filePath);
        String imageBase64 = "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";
        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(imageBase64);
        InputStream imageStream = new ByteArrayInputStream(imageBytes);

        String outputFilePath = new File(Constants.OutputPath, "SignWithBase64ImageAdvanced\\" + fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/ {
            ImageSignOptions options = new ImageSignOptions(imageStream);

            // set signature position
            options.setLeft(100);
            options.setTop(100);

            // set signature rectangle
            options.setWidth(200);
            options.setHeight(100);
            // set signature alignment
            // when VerticalAlignment is set the Top coordinate will be ignored.
            // Use Margin properties Top, Bottom to provide vertical offset
            options.setVerticalAlignment(VerticalAlignment.Top);

            // when HorizontalAlignment is set the Left coordinate will be ignored.
            // Use Margin properties Left, Right to provide horizontal offset
            options.setHorizontalAlignment(HorizontalAlignment.Center);

            Padding tmp0 = new Padding();
            tmp0.setTop(120);
            tmp0.setRight(120);
            options.setMargin(tmp0);

            // set rotation
            options.setRotationAngle(45);

            // setup signature border
            Border tmp1 = new Border();
            tmp1.setVisible(true);
            tmp1.setColor(Color.ORANGE);
            tmp1.setDashStyle(DashStyle.DashDotDot);
            tmp1.setWeight(5);
            options.setBorder(tmp1);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, options);

            // dispose Image
            imageStream.close();

            System.out.print("\nSource document signed successfully with " + signResult.getSucceeded().size() + " signature(s).\nFile saved at " + outputFilePath);

            System.out.print("\nList of newly created signatures:");
            int number = 1;
            for (BaseSignature temp : signResult.getSucceeded()) {
                System.out.print("Signature #" + number++ + ": Type: " + temp.getSignatureType() + " Id:" + temp.getSignatureId() + ", Location: " + temp.getLeft() + "x" + temp.getTop() + ". Size: " + temp.getWidth() + "x" + temp.getHeight());
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}
