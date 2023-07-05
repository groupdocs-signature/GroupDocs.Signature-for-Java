package com.groupdocs.ui.signature.ktor.model

data class SignDocumentRequest(
    val documentType: String? = null,
    val signaturesData: List<SignatureDataEntity>? = null,
    val guid: String? = null,
    val password: String? = null
)
