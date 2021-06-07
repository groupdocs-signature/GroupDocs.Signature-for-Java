package com.groupdocs.ui.signature.model.request;

import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.signature.model.web.SignatureDataEntity;

import java.util.List;

public class SignDocumentRequest extends LoadDocumentRequest {
    private String documentType;
    private List<SignatureDataEntity> signaturesData;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public List<SignatureDataEntity> getSignaturesData() {
        return signaturesData;
    }

    public void setSignaturesData(List<SignatureDataEntity> signaturesData) {
        this.signaturesData = signaturesData;
    }
}
