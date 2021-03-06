package com.groupdocs.signature.examples.basic_usage.document_preview;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.PageInfo;
import com.groupdocs.signature.domain.documentpreview.IDocumentInfo;
import com.groupdocs.signature.examples.Constants;

public class GetDocumentInfo {
    public static void run() throws Exception
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;

        Signature signature = new Signature(filePath);
        // Document description
        IDocumentInfo docInfo = signature.getDocumentInfo();
        System.out.print("\n"+"Document contains " + docInfo.getPageCount() + " pages");
        System.out.print("\n"+"File type is " + docInfo.getFileType().getFileFormat());
        System.out.print("\n"+"Width for Max Height  " + docInfo.getWidthForMaxHeight());
        System.out.print("\n"+"Max Page Height" + docInfo.getMaxPageHeight());
        System.out.print("\n"+"File size in bytes is " + docInfo.getSize());
        System.out.print("\n"+"Width of first page is " + docInfo.getPages().get(0).getWidth());
        for(PageInfo page : docInfo.getPages()){
            System.out.print("\n"+"- page-"+ page.getPageNumber()+ " Height " + page.getHeight() + " Width " + page.getWidth());
        }
    }
}
