package com.groupdocs.signature.examples.advanced_usage.documentpreview;



import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.documentpreview.IDocumentInfo;
import com.groupdocs.signature.domain.signatures.DocumentResultSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.loadoptions.LoadOptions;

import java.nio.file.Paths;


class GetArchiveInfoAdvanced
{
    /**
     * <p>
     * Get digital certificates information 
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # GetArchiveInfoAdvanced : Get Archive file documents information\n");

        // The path to certificate.
        String archivePath = Constants.SAMPLE_ZIP;

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1234567890");

        final Signature signature = new Signature(archivePath, loadOptions);
        try /*JAVA: was using*/
        {
            IDocumentInfo documentInfo = signature.getDocumentInfo();
            System.out.print("Archive properties "+ Paths.get(archivePath).getFileName().toString()+":");
            System.out.print(" - format : "+documentInfo.getFileType().getFileFormat());
            System.out.print(" - extension : "+documentInfo.getFileType().getExtension());
            System.out.print(" - size : "+documentInfo.getSize());
            System.out.print(" - documents count : "+documentInfo.getPageCount());

            // display each document information
            System.out.print("Documents information:");
            for (DocumentResultSignature document : documentInfo.getDocuments())
            {
                System.out.print(" - Document: "+document.getFileName()+" Size: "+document.getSourceDocumentSize()+" archive-size: "+document.getDestinDocumentSize());
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
