package com.groupdocs.signature.examples.advanced_usage.search.search_archives;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SearchResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.DocumentResultSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;
import com.groupdocs.signature.options.search.QrCodeSearchOptions;
import com.groupdocs.signature.options.search.SearchOptions;


import java.util.ArrayList;
import java.util.List;

public class SearchWithinTARArchiveDocuments
{
    /**
     * <p>
     * Search within the TAR archive documents with various search options
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchWithinTARArchiveDocuments : Search TAR archive document for various signatures\n");

        // The path to the archive with signed documents
        String filePath = Constants.SAMPLE_SIGNED_TAR;

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // create list of search options
            BarcodeSearchOptions bcOptions = new BarcodeSearchOptions(BarcodeTypes.Code128);
            QrCodeSearchOptions qrOptions = new QrCodeSearchOptions(QrCodeTypes.QR);
            List<SearchOptions> listOptions = new ArrayList<SearchOptions>();
            listOptions.add(bcOptions);
            listOptions.add(qrOptions);

            // search archive for documents
            SearchResult searchResult = signature.search(listOptions);

            // check the result                
            System.out.print("\nList of successfully processed documents:");
            int number = 1;
            for (BaseSignature o : searchResult.getSucceeded())
            {
                DocumentResultSignature document = (DocumentResultSignature)o;
                System.out.print("Document #"+number++ +": "+document.getFileName()+". Processed: "+document.getProcessingTime()+", mls");
                for (BaseSignature temp : document.getSucceeded())
                {
                    System.out.print("\t\t#"+temp.getSignatureId()+": "+temp.getSignatureType());
                }
            }
            if (searchResult.getFailed().size() > 0)
            {
                System.out.print("\nList of failed documents:");
                number = 1;
                for (BaseSignature o : searchResult.getFailed())
                {
                    DocumentResultSignature document = (DocumentResultSignature)o;
                    System.out.print("ERROR in Document #"+number++ +"-"+document.getFileName()+": "+document.getErrorMessage()+", mls");
                }
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
