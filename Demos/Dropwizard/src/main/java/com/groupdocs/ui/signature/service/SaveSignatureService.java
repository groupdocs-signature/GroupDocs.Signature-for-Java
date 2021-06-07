package com.groupdocs.ui.signature.service;

import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.signature.entity.request.SaveImageRequest;
import com.groupdocs.ui.signature.entity.request.SaveOpticalCodeRequest;
import com.groupdocs.ui.signature.entity.request.SaveStampRequest;
import com.groupdocs.ui.signature.entity.request.SaveTextRequest;
import com.groupdocs.ui.signature.entity.xml.OpticalXmlEntity;
import com.groupdocs.ui.signature.entity.xml.TextXmlEntity;

public interface SaveSignatureService {
    /**
     * Save stamp signature
     *
     * @param saveStampRequest save signature request data
     * @return signature file description
     */
    FileDescriptionEntity saveStamp(SaveStampRequest saveStampRequest);

    /**
     * Save optical code signature
     *
     * @param saveOpticalCodeRequest save signature request data
     * @return optical code signature
     */
    OpticalXmlEntity saveOpticalCode(SaveOpticalCodeRequest saveOpticalCodeRequest);

    /**
     * Save test signature
     *
     * @param saveTextRequest save signature request data
     * @return text signature
     */
    TextXmlEntity saveText(SaveTextRequest saveTextRequest);

    /**
     * @param saveImageRequest save signature request data
     * @return signature file description
     */
    FileDescriptionEntity saveImage(SaveImageRequest saveImageRequest);
}
