package com.groupdocs.ui.signature.model.request;

import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.signature.model.web.SignatureDataEntity;

import java.util.List;

public class SignDocumentRequest extends LoadDocumentRequest {
    private List<SignatureDataEntity> signaturesData;

    public List<SignatureDataEntity> getSignaturesData() {
        return signaturesData;
    }

    public void setSignaturesData(List<SignatureDataEntity> signaturesData) {
        this.signaturesData = signaturesData;
    }
}
