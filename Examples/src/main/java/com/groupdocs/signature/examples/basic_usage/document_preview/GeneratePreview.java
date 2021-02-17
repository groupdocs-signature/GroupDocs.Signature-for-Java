package com.groupdocs.signature.examples.basic_usage.document_preview;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PageStreamFactory;
import com.groupdocs.signature.options.PreviewFormats;
import com.groupdocs.signature.options.PreviewOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class GeneratePreview {

    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        // instantiating the signature object
        FileInputStream stream = new FileInputStream(filePath);
        final Signature signature = new Signature(stream);
        // Image from specified page
        PreviewOptions previewOptions = new PreviewOptions(new PageStreamFactory() {
            @Override
            public OutputStream createPageStream(int pageNumber) {
                return createPageStreamTest(pageNumber);
            }

            @Override
            public void closePageStream(int pageNumber, OutputStream pageStream) {
                releasePageStream(pageNumber, pageStream);
            }
        });
        previewOptions.setPreviewFormat(PreviewFormats.PNG);
        signature.generatePreview(previewOptions);
    }

    private static OutputStream createPageStreamTest(int pageNumber)
    {
        try {
            String filePath = Constants.OutputPath +"\\image-"+pageNumber+".png";
            return new FileOutputStream(filePath);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    private static void releasePageStream(int pageNumber, OutputStream pageStream)
    {
        try {
            pageStream.close();
            String imageFilePath = new File("GeneratePreviewFolder", "image-" + pageNumber + ".png").getPath();
            System.out.print("Image file "+imageFilePath+" is ready for preview");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}