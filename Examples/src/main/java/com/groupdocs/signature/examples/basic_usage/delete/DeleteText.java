package com.groupdocs.signature.examples.basic_usage.delete;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.TextSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.search.TextSearchOptions;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

public class DeleteText {
    /**
     * <p>
     * Delete Text signature from the document.
     * </p>
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF_SIGNED;
        String fileName = Paths.get(filePath).getFileName().toString();
        // copy source file since Delete method works with same Document
        String outputFilePath = new File(Constants.OutputPath, "DeleteText\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        IOUtils.copy(new FileInputStream(filePath), new FileOutputStream(outputFilePath, true));
        final Signature signature = new Signature(outputFilePath);
        try /*JAVA: was using*/
        {
            TextSearchOptions options = new TextSearchOptions();

            // search for text signatures in document
            List<TextSignature> signatures = signature.search(TextSignature.class,options);
            if(signatures.size() > 0)
            {
                TextSignature textSignature = signatures.get(0);
                boolean result = signature.delete(outputFilePath,textSignature);
                if(result)
                {
                    System.out.print("Signature with Text " + textSignature.getText() + " was deleted from document [" + fileName + "].");
                }
                else
                {
                    System.out.print("Signature was not deleted from the document! Signature with Text " + textSignature.getText() + " was not found!");
                }
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}