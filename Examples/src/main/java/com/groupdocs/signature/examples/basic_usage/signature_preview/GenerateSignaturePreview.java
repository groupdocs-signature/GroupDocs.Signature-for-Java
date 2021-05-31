package com.groupdocs.signature.examples.basic_usage.signature_preview;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.extensions.serialization.Address;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PageSignatureStreamFactory;
import com.groupdocs.signature.options.PreviewFormats;
import com.groupdocs.signature.options.PreviewSignatureOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class GenerateSignaturePreview {
   
    /**
     * Generate signature preview
     */
    public static void run() throws Exception
    {
        System.out.print("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Basic Usage] # GenerateSignaturePreview : Generate signature preview");
        // no need Siganture object since method is static

        // create options
        QrCodeSignOptions signOptions = new QrCodeSignOptions();
        {
            signOptions.setEncodeType(QrCodeTypes.QR);
                // setup Data property with Address object
            Address address = new Address();
            address.setStreet("221B Baker Street");
            address.setCity("London");
            address.setState("NW");
            address.setZIP("NW16XE");
            address.setCountry("England");
            signOptions.setData(address);
                // set right bottom corner
            signOptions.setHorizontalAlignment(HorizontalAlignment.Left);
            signOptions.setVerticalAlignment(VerticalAlignment.Center);
            signOptions.setWidth(100);
            signOptions.setHeight(100);
            signOptions.setMargin(new Padding(10));
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

