package com.groupdocs.signature.examples.advanced_usage.common;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.signatures.BarcodeSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.handler.events.*;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.search.BarcodeSearchOptions;

import java.util.List;

public class SubscribeSearchEvents {

    /**
     * Defines on start process event handler
     * @param sender
     * @param args
     */
    private static void onSearchStarted(Signature sender, ProcessStartEventArgs args)
    {
        System.out.print("\nSearch process started at "+args.getStarted()+" with "+args.getTotalSignatures()+" total signatures to be put in document");
    }

    /**
     * Defines on progress event
     * @param sender
     * @param args
     */
    private static void onSearchProgress(Signature sender, ProcessProgressEventArgs args)
    {
        System.out.print("Search progress. Processed "+args.getProcessedSignatures()+" signatures. Time spent "+args.getTicks()+" mlsec");
    }

    /**
     * Defines on completed event
     * @param sender
     * @param args
     */
    private static void onSearchCompleted(Signature sender, ProcessCompleteEventArgs args)
    {
        System.out.print("Search process completed at "+args.getCompleted()+" with "+args.getTotalSignatures()+" total signatures. Process took "+args.getTicks()+" mlsec");
    }


    /**
     * search document for barcode sigantures and subscribe for events
     */
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;

        try {
            Signature signature = new Signature(filePath);
            signature.SearchStarted.add(new ProcessStartEventHandler() {
                public void invoke(Signature sender, ProcessStartEventArgs args) {
                    onSearchStarted(sender, args);
                }
            });


            signature.SearchProgress.add(new ProcessProgressEventHandler() {
                public void invoke(Signature sender, ProcessProgressEventArgs args) {
                    onSearchProgress(sender, args);
                }


            });
            signature.SearchCompleted.add(new ProcessCompleteEventHandler() {
                public void invoke(Signature  sender, ProcessCompleteEventArgs args) {
                    onSearchCompleted(sender, args);
                }
            });

            BarcodeSearchOptions options = new BarcodeSearchOptions();

            // specify special pages to search on
            options.setAllPages(false);
            options.setPageNumber(1);
            PagesSetup pagesSetup = new PagesSetup();
            pagesSetup.setFirstPage(true);
            pagesSetup.setLastPage(true);
            pagesSetup.setOddPages(false);
            pagesSetup.setEvenPages(false);
            options.setPagesSetup(pagesSetup);

            // specify text match type
            options.setMatchType(TextMatchType.Contains);
            // specify text pattern to search
            options.setText("12345");


            // search for signatures in document
            List<BarcodeSignature> signatures = signature.search(BarcodeSignature.class,options);
            System.out.print("\nSource document contains following signatures.");
            for (BarcodeSignature barcodeSignature : signatures)
            {
                System.out.print("Barcode signature found at page "+barcodeSignature.getPageNumber()+" with type "+barcodeSignature.getEncodeType()+" and text " + barcodeSignature.getText());
            }
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}