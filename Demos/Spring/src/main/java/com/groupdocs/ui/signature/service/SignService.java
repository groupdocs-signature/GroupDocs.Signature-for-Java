package com.groupdocs.ui.signature.service;

import com.groupdocs.ui.signature.model.request.SignDocumentRequest;
import com.groupdocs.ui.signature.model.web.SignedDocumentEntity;

import java.io.InputStream;

public interface SignService {
    /**
     * Sign document
     *
     * @param signDocumentRequest
     * @return
     */
    SignedDocumentEntity sign(SignDocumentRequest signDocumentRequest);

    /**
     * Sign document by stream
     *
     * @param signDocumentRequest
     * @return
     */
    InputStream signByStream(SignDocumentRequest signDocumentRequest);
}
