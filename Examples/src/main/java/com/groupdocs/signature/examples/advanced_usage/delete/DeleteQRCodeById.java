package com.groupdocs.signature.examples.advanced_usage.delete;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.DeleteResult;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.examples.Constants;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteQRCodeById {

    /**
     * Delete QR-code signature in the document by known SignatureId.
     * SignatureId could be obtained by Search or Sign method.
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # DeleteQRCodeById : Delete QR-code signature in the document by known SignatureId\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DOCX_BARCODE_SIGNED;
        String fileName = Paths.get(filePath).getFileName().toString();
        String outputFilePath = new File(Constants.OutputPath, "DeleteQRCodeById\\"+ fileName).getPath();
        Constants.checkDir(outputFilePath);
        IOUtils.copy(new FileInputStream(filePath), new FileOutputStream(outputFilePath, true));
            // initialize Signature instance
            Signature signature = new Signature(outputFilePath);

            // read from some data source signature Id value
            String[] signatureIdList = new String[]
                {
                        "1a5fbc08-4b96-43d9-b650-578b16fbb877",
                        "b0123987-b0d4-4004-86ec-30ab5c41ac7e"
                };
            // create list of QR-code Signature by known SignatureId
            List<BaseSignature> signatures = new ArrayList<BaseSignature>();
            for (String item : signatureIdList)
            {
                signatures.add(new QrCodeSignature(item));
            }

            // delete required signatures
            DeleteResult deleteResult = signature.delete(outputFilePath,signatures);
            if (deleteResult.getSucceeded().size() == signatures.size())
            {
                System.out.print("All signatures were successfully deleted!");
            }
            else
            {
                System.out.print("Successfully deleted signatures : " + deleteResult.getSucceeded().size());
                System.out.print("Not deleted signatures : " + deleteResult.getFailed().size());
            }
            System.out.print("List of deleted signatures:");
            for(BaseSignature temp : deleteResult.getSucceeded())
            {
                System.out.print("Signature# Id:"+temp.getSignatureId()+", Location: "+temp.getLeft()+"x"+temp.getTop()+". Size: "+temp.getWidth()+"x"+temp.getHeight());
            }
        }
}