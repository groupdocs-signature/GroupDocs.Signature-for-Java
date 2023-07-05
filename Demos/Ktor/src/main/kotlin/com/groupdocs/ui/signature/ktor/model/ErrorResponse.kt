package com.groupdocs.ui.signature.ktor.model

data class ErrorResponse(
    val message: String,
    val exception: Exception? = null
)
