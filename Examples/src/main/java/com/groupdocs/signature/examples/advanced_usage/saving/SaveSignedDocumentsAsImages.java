package com.groupdocs.signature.examples.advanced_usage.saving;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.ImagesSaveFileFormat;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.saveoptions.ExportImageSaveOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class SaveSignedDocumentsAsImages {
    /**
     * Sign document with qr-code signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;

        String outputFilePath = new File(Constants.OutputPath, "SignSaveToImage//ignedAndSavedAsImage").getPath();

        try {
            Signature signature = new Signature(filePath);
            QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
            signOptions.setEncodeType(QrCodeTypes.QR);
            signOptions.setLeft(100);
            signOptions.setTop(100);

            //Export to image options
            ExportImageSaveOptions exportImageSaveOptions = new ExportImageSaveOptions(ImagesSaveFileFormat.Png);

                //set pages border style
            Border border= new Border();
            border.setColor(Color.BLUE);
            border.setWeight(5);
            border.setDashStyle(DashStyle.Solid);
            border.setTransparency(0.5);
            exportImageSaveOptions.setBorder(border);
            // sepcify pages to export
            PagesSetup pagesSetup= new PagesSetup() ;
            pagesSetup.setFirstPage(true);
            pagesSetup.setLastPage(true);
            exportImageSaveOptions.setPagesSetup(pagesSetup);
            // specify output image view - all pages could be located on one column or each by each on several columns
            exportImageSaveOptions.setPageColumns(2);

            // sign document to file
            signature.sign(outputFilePath, signOptions, exportImageSaveOptions);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }catch(Exception e){
        throw new GroupDocsSignatureException(e.getMessage());
    }
}

}