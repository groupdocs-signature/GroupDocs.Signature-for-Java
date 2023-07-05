package com.groupdocs.ui.model

open class SignatureFileDescriptionEntity(
     override val guid: String? = null,
     override val name: String? = null,
     override val docType: String? = null,
     override val directory: Boolean? = null,
     override val size: Long? = null,
     var image: String? = null,
     var text: String? = null,
     var fontColor: String? = null
) : FileDescriptionEntity()