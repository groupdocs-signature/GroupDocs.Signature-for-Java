package com.groupdocs.signature.examples.basic_usage.update;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.TextSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.search.TextSearchOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class UpdateText {
    /**
     * <p>
     * Update Text signature in the document.
     * </p>
     */
    public static void run() throws Exception {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        // copy source file since Update method works with same Document
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "UpdateText\\" + fileName).getPath();
        Constants.checkDir(outputFilePath);
        //
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/ {
            TextSearchOptions options = new TextSearchOptions();
            // search for text signatures in document
            List<TextSignature> signatures = signature.search(TextSignature.class, options);
            if (signatures.size() > 0) {
                TextSignature textSignature = signatures.get(0);
                // change Text property
                textSignature.setText("John Walkman");
                // change position
                textSignature.setLeft(textSignature.getLeft() + 50);
                textSignature.setTop(textSignature.getTop() + 50);
                // change size. Please note not all documents support changing signature size
                textSignature.setWidth(200);
                textSignature.setHeight(100);

                boolean result = signature.update(outputFilePath,textSignature);
                if (result) {
                    System.out.print("\nSignature with Text '" + textSignature.getText() + "' was updated in the document ['" + fileName + "'].");
                } else {
                    System.out.print("\nSignature was not updated in  the document! Signature with Text '" + textSignature.getText() + "' was not found!");
                }
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}