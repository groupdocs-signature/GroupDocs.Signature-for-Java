package com.groupdocs.ui.model

import com.groupdocs.signature.domain.enums.HorizontalAlignment
import com.groupdocs.signature.domain.enums.VerticalAlignment

class SignatureDataEntity (
    private var reason: String? = null,
    val contact: String? = null,
    val address: String? = null,
    val date: String? = null,
    val signaturePassword: String? = null,
    val signatureComment: String? = null,
    val documentType: String? = null,
    val signatureGuid: String? = null,
    val signatureType: String? = null,
    val pageNumber: Int = 0,
    val left: Int = 0,
    val top: Int = 0,
    val imageWidth: Int = 0,
    val imageHeight: Int = 0,
    val angle: Int = 0,
    val horizontalAlignment: Int = HorizontalAlignment.None,
    val verticalAlignment: Int = VerticalAlignment.None
)