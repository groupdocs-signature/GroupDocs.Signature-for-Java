package com.groupdocs.signature.examples;

import java.net.URI;
import java.net.URISyntaxException;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageCredentialsAccountAndKey;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

public class SampleAzureDataHandler {
	public CloudBlobClient _remoteStorage;
	public String _containerName;

	public SampleAzureDataHandler(String endpoint, String accountName, String accountKey, String containerName)
			throws URISyntaxException, StorageException {
		StorageCredentials credentials = new StorageCredentialsAccountAndKey(accountName, accountKey);
		CloudStorageAccount account = new CloudStorageAccount(credentials, new URI(endpoint), null, null, null);
		_remoteStorage = account.createCloudBlobClient();
		_containerName = containerName;
		final Integer defTimeout = _remoteStorage.getDefaultRequestOptions().getTimeoutIntervalInMs();
		_remoteStorage.getDefaultRequestOptions().setTimeoutIntervalInMs(defTimeout);
		CloudBlobContainer container = _remoteStorage.getContainerReference(containerName);
		container.createIfNotExists();
		_remoteStorage.getDefaultRequestOptions().setTimeoutIntervalInMs(defTimeout);
	}
}
