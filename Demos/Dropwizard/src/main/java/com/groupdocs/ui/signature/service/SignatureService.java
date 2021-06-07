package com.groupdocs.ui.signature.service;

import com.groupdocs.ui.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.signature.entity.request.DeleteSignatureFileRequest;
import com.groupdocs.ui.signature.entity.request.LoadSignatureImageRequest;
import com.groupdocs.ui.signature.entity.request.SignatureFileTreeRequest;
import com.groupdocs.ui.signature.entity.web.SignatureFileDescriptionEntity;
import com.groupdocs.ui.signature.entity.web.SignaturePageEntity;

import java.util.List;

/**
 * Service for working with signature api
 */
public interface SignatureService {

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

    /**
     * Load image of signature
     *
     * @param loadSignatureImageRequest
     * @return
     */
    SignaturePageEntity loadSignatureImage(LoadSignatureImageRequest loadSignatureImageRequest);

}
