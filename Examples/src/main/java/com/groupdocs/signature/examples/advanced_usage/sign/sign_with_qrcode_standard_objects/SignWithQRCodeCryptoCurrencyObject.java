package com.groupdocs.signature.examples.advanced_usage.sign.sign_with_qrcode_standard_objects;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.serialization.CryptoCurrencyTransfer;
import com.groupdocs.signature.domain.extensions.serialization.CryptoCurrencyType;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.signature.options.sign.SignOptions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignWithQRCodeCryptoCurrencyObject {
    /**
     * <p>
     * Sign document with QR-Code containing standard Crypt currency transfer object
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignWithQRCodeCryptoCurrencyObject : Sign document with QR-Code containing crypto currency object\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_PDF;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignWithQRCodeCryptoCurrencyObject\\" + fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            // create crypto currency object
            CryptoCurrencyTransfer transfer = new CryptoCurrencyTransfer();
            transfer.setType(CryptoCurrencyType.Bitcoin);
            transfer.setAddress("1JHG2qjdk5Khiq7X5xQrr1wfigepJEK3t");
            transfer.setAmount(new java.math.BigDecimal(1234.56));
            transfer.setMessage("Consulting services");

            // create alternative crypto currency object
            CryptoCurrencyTransfer customTransfer = new CryptoCurrencyTransfer();
            customTransfer.setType(CryptoCurrencyType.Custom);
            customTransfer.setCustomType("SuperCoin");
            customTransfer.setAddress("15N3yGu3UFHeyUNdzQ5sS3aRFRzu5Ae7EZ");
            customTransfer.setAmount( new java.math.BigDecimal(6543.21));
            customTransfer.setMessage("Accounting services");

            // create QR-code options
            QrCodeSignOptions options1 = new QrCodeSignOptions();
            options1.setData(transfer);
            options1.setLeft(10);
            options1.setTop(10);

            // create alternative QR-code options
            QrCodeSignOptions options2 = new QrCodeSignOptions();
            options2.setData(customTransfer);
            options2.setLeft(10);
            options2.setTop(400);

            List<SignOptions> listOptions = new ArrayList<SignOptions>();
            listOptions.add(options1);
            listOptions.add(options2);

            // sign document to file
            signature.sign(outputFilePath, listOptions);
        } catch (Exception e) {
            throw new GroupDocsSignatureException(e.getMessage());
        }

        System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
    }
}
