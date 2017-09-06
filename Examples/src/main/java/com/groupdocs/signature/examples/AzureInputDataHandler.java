package com.groupdocs.signature.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
 
import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.handler.input.IInputDataHandler;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageCredentialsAccountAndKey;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobInputStream;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
//ExStart:SampleAzureInputDataHandler
public abstract class AzureInputDataHandler extends AzureDataHandler implements IInputDataHandler {
	public AzureInputDataHandler(String endpoint, String accountName, String accountKey, String containerName)
			throws URISyntaxException, StorageException {
		super(endpoint, accountName, accountKey, containerName);
	}

	@Override
	public FileDescription getFileDescription(String guid) {
		FileDescription result = new FileDescription(guid);
		return result;
	}

	@Override
	public InputStream getStream(String guid) {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		try {
			CloudBlobContainer container = null;
			container = getContainerReference();
			CloudBlockBlob blob = container.getBlockBlobReference(guid);
			BlobInputStream content = blob.openInputStream();
			org.apache.commons.io.IOUtils.copy(content, result);
			return new ByteArrayInputStream(result.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
 
	public CloudBlobContainer getContainerReference() throws URISyntaxException, StorageException {
		CloudBlobContainer container = _remoteStorage.getContainerReference(_containerName);
		return container;
	}
}
//ExEnd:SampleAzureInputDataHandler
