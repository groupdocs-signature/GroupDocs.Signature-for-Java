package com.groupdocs.signature.examples.advanced_usage.sign.signature_positions;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignWithAlignments {

    /**
     * Sign document with text signature applying specific options
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithAlignment\\" + fileName).getPath();

        try {
            Signature signature = new Signature(filePath);
            // define qr-code size
            int qrWidth = 100;
            int qrHeight = 100;
            // define list of options
            List<SignOptions> listOptions = new ArrayList<SignOptions>();
            // walk through all alignment values to locate signature at all page alignment areas
            for (int horizontalAlignment : HorizontalAlignment.getValues())
            {
                for (int verticalAlignment : HorizontalAlignment.getValues())
                {
                    if (verticalAlignment != VerticalAlignment.None && horizontalAlignment != HorizontalAlignment.None)
                    {
                        QrCodeSignOptions options = new QrCodeSignOptions("Left-Top");

                        // set signature rectangle
                        options.setWidth(qrWidth);
                        options.setHeight(qrHeight);

                        // set signature alignment
                        options.setHorizontalAlignment(horizontalAlignment);
                        options.setVerticalAlignment(verticalAlignment);

                        options.setMargin(new Padding(5));
                        listOptions.add(options);
                    }
                }
            }
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