package com.groupdocs.signature.examples.basic_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.signatures.TextSignature;
import com.groupdocs.signature.options.search.TextSearchOptions;

import java.nio.file.Paths;
import java.util.List;

public class SearchForText {
    /**
     * <p>
     * Search document for Text signature
     * </p>
     */
    public static void run() {
        // The path to the documents directory.
        String filePath = "C:\\GroupDocs\\Output\\test_sign1.docx";
        String fileName = Paths.get(filePath).getFileName().toString();
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/ {
            TextSearchOptions options = new TextSearchOptions();
            options.setAllPages(true);

            // search for text signatures in document
            List<TextSignature> signatures = signature.search(TextSignature.class, options);
            System.out.print("\nSource document ['" + fileName + "'] contains following text signature(s).");
            // enumerate all signature for output

            for (TextSignature textSignature : signatures) {
                System.out.print("Found Text signature at page " + textSignature.getPageNumber() + " with type [" + textSignature.getSignatureImplementation() + "] and text '" + textSignature.getText() + "'.");
            }


        } catch (Exception ex) {
            System.out.print("System Exception: " + ex.getMessage());
        }
    }
}