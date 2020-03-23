package com.groupdocs.signature.examples.advanced_usage.documentpreview;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.PageStreamFactory;
import com.groupdocs.signature.options.PreviewFormats;
import com.groupdocs.signature.options.PreviewOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeneratePreviewAdvanced {
    /**
     * <p>
     * Generate document pages preview with using HideSignature feature
     * </p>
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // create preview options object
            PreviewOptions previewOption = new PreviewOptions(new PageStreamFactory() {
                @Override
                public OutputStream createPageStream(int pageNumber) {
                    return createPageStreamTest(pageNumber);
                }

                @Override
                public void closePageStream(int pageNumber, OutputStream pageStream) {
                    releasePageStream(pageNumber, pageStream);
                }
            });
            previewOption.setPreviewFormat(PreviewFormats.JPEG);
            previewOption.setHideSignatures(true);
            // generate preview
            signature.generatePreview(previewOption);

        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }


    private static OutputStream createPageStreamTest(int pageNumber)
    {
        try {
            Path path = Paths.get(Constants.OutputPath +"\\GeneratePreviewHideSignatures\\");

            if (!Files.exists(path)) {

                Files.createDirectory(path);
                System.out.println("Directory created");
            } else {

                System.out.println("Directory already exists");
            }
            File filePath = new File(path+"\\image-"+pageNumber+".jpg");

            return new FileOutputStream(filePath);
        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }

    }

    private static void releasePageStream(int pageNumber, OutputStream pageStream)
    {
        try {
            pageStream.close();
            String imageFilePath = new File(Constants.OutputPath + "\\GeneratePreviewHideSignatures", "image-" +pageNumber +  ".jpg").getPath();
            System.out.print("Image file "+imageFilePath+" is ready for preview");
        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}