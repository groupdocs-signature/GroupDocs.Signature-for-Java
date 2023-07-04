package com.groupdocs.ui.model

data class SignDocumentRequest(
    val documentType: String? = null,
    val signaturesData: List<SignatureDataEntity>? = null,
    val guid: String? = null,
    val password: String? = null
)
