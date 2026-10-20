package com.groupdocs.signature.examples.advanced_usage.search;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.TextSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.SearchOptions;
import com.groupdocs.signature.options.search.TextSearchOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchSignaturesWithPredicate
{
    /**
     * <p>
     * Search signatures with predicate function
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchSignaturesWithPredicate : Search signatures with predicate function\n");

        // The path to the documents directory.
        // Assume document is already signed with:
        // - TextSignOptions("Signature1") at Top=100, Left=100, PageNumber=1
        // - TextSignOptions("Signature2") at Top=200, Left=200, PageNumber=1
        // - TextSignOptions("Signature3") at Top=300, Left=300, PageNumber=1
        String signedFile = Constants.SAMPLE_PDF_SIGNED_FORMFIELD;

        try
        {
            final Signature signature = new Signature(signedFile);
            try /*JAVA: was using*/
            {
                // Option 1: Search all signatures and filter with predicate
                // Filter text signatures on page 1
                List<BaseSignature> allSignatures = signature.search(sig ->
                        sig.getPageNumber() == 1 && sig.getSignatureType() == SignatureType.Text);
                System.out.print("\nFound " + allSignatures.size() + " text signatures on page 1");

                // Option 2: Search with specific options and filter with predicate
                // Create search options for text signatures
                TextSearchOptions searchOptions = new TextSearchOptions();
                List<SearchOptions> textSearch = new ArrayList<SearchOptions>();
                textSearch.add(searchOptions);

                // Search and filter: only signatures with specific text "Signature1"
                List<BaseSignature> filteredSignatures = new ArrayList<BaseSignature>(signature.search(
                        textSearch,
                        sig -> sig instanceof TextSignature && "Signature1".equals(((TextSignature) sig).getText())
                ).getSignatures());
                System.out.print("\nFound " + filteredSignatures.size() + " signatures with text 'Signature1'");

                // Option 3: Complex predicate - filter by text content and position
                // Find signatures matching specific parameters
                Predicate<BaseSignature> complexPredicate = sig ->
                {
                    // Filter signatures that:
                    // - Are text signatures
                    // - Are on page 1
                    // - Match specific text content (Signature2 or Signature3)
                    if (sig.getSignatureType() != SignatureType.Text)
                        return false;
                    if (sig.getPageNumber() != 1)
                        return false;
                    if (sig instanceof TextSignature)
                    {
                        String text = ((TextSignature) sig).getText();
                        return "Signature2".equals(text) || "Signature3".equals(text);
                    }
                    return false;
                };
                List<BaseSignature> complexFilteredSignatures = signature.search(complexPredicate);
                System.out.print("\nFound " + complexFilteredSignatures.size() + " matching text signatures on page 1");

                // Option 4: Filter by position parameters (Top, Left)
                List<BaseSignature> positionFilteredSignatures = signature.search(sig ->
                {
                    if (sig.getSignatureType() != SignatureType.Text || sig.getPageNumber() != 1)
                        return false;
                    if (sig instanceof TextSignature)
                    {
                        TextSignature textSig = (TextSignature) sig;
                        // Find signature at specific position (Top=100, Left=100)
                        return textSig.getTop() == 100 && textSig.getLeft() == 100 && "Signature1".equals(textSig.getText());
                    }
                    return false;
                });
                System.out.print("\nFound " + positionFilteredSignatures.size() + " signatures at position Top=100, Left=100");

                // Process the filtered results
                for (BaseSignature sig : complexFilteredSignatures)
                {
                    if (sig instanceof TextSignature)
                    {
                        TextSignature textSignature = (TextSignature) sig;
                        System.out.print("\n  Signature: '" + textSignature.getText() + "' on page " + sig.getPageNumber()
                                + ", Position: Top=" + textSignature.getTop() + ", Left=" + textSignature.getLeft()
                                + ", Type: " + sig.getSignatureType());
                    }
                }
            }
            finally { if (signature != null) (signature).dispose(); }
        }
        catch (Exception ex)
        {
            System.out.print("\nAn error occurred: " + ex.getMessage());
        }
    }
}
