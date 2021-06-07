package com.groupdocs.ui.signature.service;

import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;

import java.util.ArrayList;
import java.util.List;

import static com.groupdocs.ui.signature.util.SignatureType.*;

/**
 * Class is used for sorting list of signature's data by signature type into different lists
 */
public class SortedSignaturesData {
    List<SignatureDataEntity> signaturesData;
    List<SignatureDataEntity> images = new ArrayList<>();
    List<SignatureDataEntity> texts = new ArrayList<>();
    List<SignatureDataEntity> codes = new ArrayList<>();
    List<SignatureDataEntity> stamps = new ArrayList<>();
    List<SignatureDataEntity> digital = new ArrayList<>();

    public SortedSignaturesData(List<SignatureDataEntity> signaturesData) {
        this.signaturesData = signaturesData;
    }

    public SortedSignaturesData sort() {
        for (int i = 0; i < signaturesData.size(); i++) {
            addToList(signaturesData.get(i));
        }
        return this;
    }

    private void addToList(SignatureDataEntity signatureDataEntity) {
        switch (signatureDataEntity.getSignatureType()) {
            case TEXT:
                texts.add(signatureDataEntity);
                break;
            case DIGITAL:
                digital.add(signatureDataEntity);
                break;
            case IMAGE:
            case HAND:
                images.add(signatureDataEntity);
                break;
            case STAMP:
                stamps.add(signatureDataEntity);
                break;
            case QR_CODE:
            case BAR_CODE:
                codes.add(signatureDataEntity);
                break;
            default:
                throw new IllegalArgumentException("Signature type is wrong");
        }
    }
}
