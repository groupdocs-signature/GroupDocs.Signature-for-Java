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
import java.util.ArrayList;
import java.util.List;

public class LoadWhitelistedExternalResources
{
    /**
     * <p>
     * Load document with external resources from trusted addresses only
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # LoadWhitelistedExternalResources : Load document with external resources from trusted addresses only\n");

        // The document links to a picture on GitHub instead of storing it.
        String filePath = Constants.SAMPLE_WORDPROCESSING_EXTERNAL_IMAGE;
        final File previewFile = new File(Constants.OutputPath, "LoadWhitelistedExternalResources\\page-1.png");
        previewFile.getParentFile().mkdirs();

        // External resources are skipped by default, except the ones whose address contains
        // one of the listed fragments (ignoring case). Prefer long fragments: a short one
        // such as "github" would also match unrelated addresses.
        List<String> whitelistedResources = new ArrayList<String>();
        whitelistedResources.add("https://raw.githubusercontent.com/groupdocs-signature/");
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setWhitelistedResources(whitelistedResources);

        final Signature signature = new Signature(filePath, loadOptions);
        try /*JAVA: was using*/
        {
            // Generate the page preview (the sample has one page): the linked picture is downloaded and drawn.
            // This needs access to raw.githubusercontent.com.
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

        System.out.print("\nPage preview generated with the linked picture from a trusted address.\nFile saved at " + previewFile.getPath());
    }
}
