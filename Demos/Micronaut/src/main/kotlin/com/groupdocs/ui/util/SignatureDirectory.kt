package com.groupdocs.ui.util

import com.groupdocs.ui.util.PathConstants.DATA_PREVIEW_FOLDER
import com.groupdocs.ui.util.PathConstants.DATA_XML_FOLDER
import com.groupdocs.ui.util.SignatureType.BAR_CODE
import com.groupdocs.ui.util.SignatureType.DIGITAL
import com.groupdocs.ui.util.SignatureType.HAND
import com.groupdocs.ui.util.SignatureType.IMAGE
import com.groupdocs.ui.util.SignatureType.QR_CODE
import com.groupdocs.ui.util.SignatureType.STAMP
import com.groupdocs.ui.util.SignatureType.TEXT


enum class SignatureDirectory(val path: String) {
    BARCODE_DATA_DIRECTORY("/BarCodes"),
    CERTIFICATE_DATA_DIRECTORY("/Certificates"),
    IMAGE_DATA_DIRECTORY("/Image"),
    IMAGE_UPLOADED_DATA_DIRECTORY("/Image/Uploaded"),
    QRCODE_DATA_DIRECTORY("/ArCodes"),
    STAMP_DATA_DIRECTORY("/Stamps"),
    TEXT_DATA_DIRECTORY("/Text");

    val previewPath: String
        get() = path + DATA_PREVIEW_FOLDER
    val xMLPath: String
        get() = path + DATA_XML_FOLDER

    companion object {
        fun getPathFromSignatureType(signatureType: String?): String? {
            return when (signatureType) {
                DIGITAL -> CERTIFICATE_DATA_DIRECTORY.path
                IMAGE -> IMAGE_UPLOADED_DATA_DIRECTORY.path
                HAND -> IMAGE_DATA_DIRECTORY.path
                STAMP -> STAMP_DATA_DIRECTORY.path
                TEXT -> TEXT_DATA_DIRECTORY.path
                QR_CODE -> QRCODE_DATA_DIRECTORY.path
                BAR_CODE -> BARCODE_DATA_DIRECTORY.path
                else -> null
            }
        }
    }
}