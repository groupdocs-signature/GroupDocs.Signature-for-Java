package com.groupdocs.signature.examples.advanced_usage.documentpreview;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PageDataStreamFactory;
import com.groupdocs.signature.options.preview.PreviewFormats;
import com.groupdocs.signature.options.preview.PreviewOptions;
import com.groupdocs.signature.options.preview.PreviewPageData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PreviewArchiveDocuments
{
    /**
     * <p>
     * Generate pages preview of documents stored at archive
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # PreviewArchiveDocuments : Generate pages preview of documents stored at archive\n");
        System.out.print("ZIP and TAR archive formats are supported \n");

        // The path to the archive with signed documents
        String filePath = Constants.SAMPLE_SIGNED_ZIP;

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // instantiate preview options
            PreviewOptions previewOption = new PreviewOptions(new PageDataStreamFactory() {
                @Override
                public OutputStream createPageDataStream(PreviewPageData pageData) {
                    return createPageStream(pageData);
                }

                @Override
                public void closePageDataStream(PreviewPageData pageData, OutputStream pageStream) {
                    releasePageStream(pageData, pageStream);
                }
            });
            previewOption.setPreviewFormat(PreviewFormats.PNG);

            // generate preview
            signature.generatePreview(previewOption);
        }
        finally { if (signature != null) (signature).dispose(); }
    }

    // There is possibility to use extended preview page data
    private static String getImageFilePath(PreviewPageData pageData)
    {
        return new File(Constants.OutputPath, "PreviewArchiveDocuments\\" + pageData.getFileName()
                + "-page-" + pageData.getPageNumber() + "." + getExtension(pageData.getPreviewFormat())).getPath();
    }

    private static String getExtension(int previewFormat)
    {
        switch (previewFormat)
        {
            case PreviewFormats.JPEG: return "jpeg";
            case PreviewFormats.BMP: return "bmp";
            default: return "png";
        }
    }

    private static OutputStream createPageStream(PreviewPageData pageData)
    {
        try {
            File imageFile = new File(getImageFilePath(pageData));
            imageFile.getParentFile().mkdirs();
            return new FileOutputStream(imageFile);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void releasePageStream(PreviewPageData pageData, OutputStream pageStream)
    {
        try {
            pageStream.close();
            System.out.print("\nImage file " + getImageFilePath(pageData) + " is ready for preview");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
