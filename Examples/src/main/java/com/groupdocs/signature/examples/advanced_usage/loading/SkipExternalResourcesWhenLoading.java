package com.groupdocs.signature.examples.advanced_usage.loading;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PageStreamFactory;
import com.groupdocs.signature.options.loadoptions.LoadOptions;
import com.groupdocs.signature.options.preview.PreviewFormats;
import com.groupdocs.signature.options.preview.PreviewOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SkipExternalResourcesWhenLoading
{
    /**
     * <p>
     * Load document without the external resources it links to
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SkipExternalResourcesWhenLoading : Load document without the external resources it links to\n");

        // The document links to a picture on GitHub instead of storing it.
        String filePath = Constants.SAMPLE_WORDPROCESSING_EXTERNAL_IMAGE;
        final File previewFile = new File(Constants.OutputPath, "SkipExternalResourcesWhenLoading\\page-1.png");
        previewFile.getParentFile().mkdirs();

        // External resources - linked pictures, INCLUDEPICTURE fields, images and style sheets of SVG images -
        // are skipped by default, so the addresses written in a document are never requested.
        // Setting SkipExternalResources = true explicitly does the same.
        // Set SkipExternalResources = false to load every external resource, for trusted documents only.
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setSkipExternalResources(true);

        final Signature signature = new Signature(filePath, loadOptions);
        try /*JAVA: was using*/
        {
            // Generate the page preview (the sample has one page): the linked picture is not drawn.
            PreviewOptions previewOptions = new PreviewOptions(new PageStreamFactory() {
                @Override
                public OutputStream createPageStream(int pageNumber) {
                    try {
                        return new FileOutputStream(previewFile);
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }

                @Override
                public void closePageStream(int pageNumber, OutputStream pageStream) {
                    try {
                        pageStream.close();
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }
            });
            previewOptions.setPreviewFormat(PreviewFormats.PNG);
            signature.generatePreview(previewOptions);
        }
        finally { if (signature != null) (signature).dispose(); }

        System.out.print("\nPage preview generated without the linked picture.\nFile saved at " + previewFile.getPath());
    }
}
