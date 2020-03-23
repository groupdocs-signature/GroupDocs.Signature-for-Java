package com.groupdocs.signature.examples.advanced_usage.sign.signature_positions;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.StretchMode;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;
import com.groupdocs.signature.options.sign.ImageSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;
import com.groupdocs.signature.options.sign.TextSignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignWithStretchMode {
    /**
     * Sign document with barcode signature
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithStretch\\" + fileName).getPath();

        try {
            Signature signature = new Signature(filePath);
            // define several signature options of different types and settings
            TextSignOptions textOptions = new TextSignOptions("This is test message");
            textOptions.setAllPages(true);
            textOptions.setVerticalAlignment(VerticalAlignment.Top);
            textOptions.setMargin(new Padding(50));
            textOptions.setStretch(StretchMode.PageWidth);

            BarcodeSignOptions barcodeOptions = new BarcodeSignOptions("123456");
            barcodeOptions.setAllPages(true);
            barcodeOptions.setEncodeType(BarcodeTypes.Code128);
            barcodeOptions.setVerticalAlignment(VerticalAlignment.Bottom);
            barcodeOptions.setMargin(new Padding(50));
            barcodeOptions.setStretch(StretchMode.PageWidth);

            ImageSignOptions imageOptions = new ImageSignOptions();
            imageOptions.setAllPages(true);
            imageOptions.setStretch(StretchMode.PageHeight);
            imageOptions.setHorizontalAlignment(HorizontalAlignment.Right);
            imageOptions.setImageFilePath(Constants.ImageHandwrite);

            // define list of signature options
            List<SignOptions> listOptions = new ArrayList<SignOptions>();

            listOptions.add(textOptions);
            listOptions.add(barcodeOptions);
            listOptions.add(imageOptions);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, listOptions);
            // analyzing result
            System.out.print("List of newly created signatures:");
            int number = 1;
            for(BaseSignature temp : signResult.getSucceeded())
            {
                System.out.print("Signature #"+ number++ +": Type: "+temp.getSignatureType()+" Id:"+temp.getSignatureId()+
                        ",Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
}