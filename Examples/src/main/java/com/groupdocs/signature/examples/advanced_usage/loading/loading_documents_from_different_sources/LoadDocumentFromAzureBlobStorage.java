package com.groupdocs.signature.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

/**
 * This example demonstrates how to download document from Azure Blob storage and render document.
 */
public class LoadDocumentFromAzureBlobStorage {
    public static void run() throws Exception
    {
        String key = "sample.docx";
        String outputFilePath = new File(Constants.OutputPath, "SignFromStream//signedSample.docx").getPath();
        try {
            ByteArrayOutputStream stream = downloadFile(key);

            Signature signature = new Signature(new ByteArrayInputStream(stream.toByteArray()));

            QrCodeSignOptions options = new QrCodeSignOptions("JohnSmith");
            options.setEncodeType(QrCodeTypes.QR);
            options.setLeft(100);
            options.setTop(100);


            // sign document to file
            signature.sign(outputFilePath, options);

            System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
        }catch(Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }
    }
    public static final String STORAGE_CONNECTION_STRING
            = "DefaultEndpointsProtocol=https;"
            + "AccountName=Ram;" //Your account name.
            + "AccountKey=key"; //your account key.

    public static ByteArrayOutputStream downloadFile(String blobName) throws Exception
    {
        CloudBlobContainer container = getContainer();

        CloudBlob blob = container.getBlockBlobReference(blobName);
        ByteArrayOutputStream memoryStream = new ByteArrayOutputStream();
        blob.download(memoryStream);
        //memoryStream.Position = 0;
        return memoryStream;
    }

    private static CloudBlobContainer getContainer() throws Exception
    {
        String containerName = "***";

        CloudStorageAccount cloudStorageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
        CloudBlobClient cloudBlobClient = cloudStorageAccount.createCloudBlobClient();
        CloudBlobContainer container = cloudBlobClient.getContainerReference(containerName);
        container.createIfNotExists();

        return container;
    }
}