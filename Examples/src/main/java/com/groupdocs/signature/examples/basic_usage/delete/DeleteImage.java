package com.groupdocs.signature.examples.basic_usage.delete;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.ImageSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.search.ImageSearchOptions;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

public class DeleteImage {
    /**
     * <p>
     * Delete Image signature from the document.
     * </p>
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        String fileName = Paths.get(filePath).getFileName().toString();
        // copy source file since Delete method works with same Document
        String outputFilePath = new File(Constants.OutputPath, "DeleteImage\\" + fileName).getPath();
        Constants.checkDir(outputFilePath);

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            ImageSearchOptions options = new ImageSearchOptions();

            // search for image signatures in document
            List<ImageSignature> signatures = signature.search(ImageSignature.class, options);
            if (signatures.size() > 0)
            {
                ImageSignature imageSignature = signatures.get(0);
                boolean result = signature.delete(outputFilePath,imageSignature);
                if (result)
                {
                    System.out.print("\nImage signature at location "+imageSignature.getLeft() + "x"+imageSignature.getTop()+" and Size "+imageSignature.getSize()+" was deleted from document ["+fileName+"].");
                }
                else
                {
                    System.out.print("\nSignature was not deleted from the document! Signature at location "+imageSignature.getLeft()+"x"+imageSignature.getTop()+" and Size "+imageSignature.getSize()+" was not found!");
                }
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}