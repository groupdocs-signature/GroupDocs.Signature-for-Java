package com.groupdocs.ui.signature.service;

import com.groupdocs.ui.signature.entity.request.SignDocumentRequest;
import com.groupdocs.ui.signature.entity.web.SignedDocumentEntity;

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
     * Sign document with stream
     *
     * @param signDocumentRequest
     * @return
     */
    InputStream signByStream(SignDocumentRequest signDocumentRequest);
}
