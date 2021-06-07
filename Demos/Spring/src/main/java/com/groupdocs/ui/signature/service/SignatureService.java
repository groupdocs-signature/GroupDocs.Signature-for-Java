package com.groupdocs.ui.signature.service;

import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.response.LoadDocumentEntity;
import com.groupdocs.ui.model.response.PageDescriptionEntity;
import com.groupdocs.ui.signature.SignatureConfiguration;
import com.groupdocs.ui.signature.model.request.DeleteSignatureFileRequest;
import com.groupdocs.ui.signature.model.request.LoadSignatureImageRequest;
import com.groupdocs.ui.signature.model.request.SignatureFileTreeRequest;
import com.groupdocs.ui.signature.model.web.SignatureFileDescriptionEntity;
import com.groupdocs.ui.signature.model.web.SignaturePageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Service for working with signature api
 */
public interface SignatureService {

    /**
     * Get configuration for Signature module
     *
     * @return SignatureConfiguration
     */
    SignatureConfiguration getSignatureConfiguration();

    /**
     * Get list of files in directory
     *
     * @param fileTreeRequest model with path parameter
     * @return list of files
     */
    List<SignatureFileDescriptionEntity> getFileList(SignatureFileTreeRequest fileTreeRequest);

    /**
     * Load document descriptions
     *
     * @param loadDocumentRequest document request data
     * @return list of document descriptions
     */
    LoadDocumentEntity getDocumentDescription(LoadDocumentRequest loadDocumentRequest);

    /**
     * Load document page
     *
     * @param loadDocumentPageRequest document page request data
     * @return loaded document page
     */
    PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest);

    /**
     * Upload document
     *
     * @param content       document content
     * @param url           document url
     * @param rewrite       flag for rewrite
     * @param signatureType type of signature
     * @return signature file description
     */
    SignatureFileDescriptionEntity uploadDocument(MultipartFile content, String url, Boolean rewrite, String signatureType);

    /**
     * Delete signature file from local storage
     *
     * @param deleteSignatureFileRequest
     */
    void deleteSignatureFile(DeleteSignatureFileRequest deleteSignatureFileRequest);

    /**
     * Get list of fonts names
     *
     * @return list of fonts names
     */
    List<String> getFonts();

    SignaturePageEntity loadSignatureImage(LoadSignatureImageRequest loadSignatureImageRequest);
}