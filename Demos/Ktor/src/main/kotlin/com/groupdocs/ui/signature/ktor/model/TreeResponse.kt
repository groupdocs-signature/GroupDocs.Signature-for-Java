package com.groupdocs.ui.signature.ktor.model

open class FileDescriptionEntity(
    open val guid: String? = null,
    open val name: String? = null,
    open val docType: String? = null,
    open val directory: Boolean? = null,
    open val size: Long? = null,
    var image: String? = null,
    var text: String? = null,
    var fontColor: String? = null
)