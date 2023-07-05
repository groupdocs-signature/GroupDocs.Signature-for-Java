package com.groupdocs.ui.signature.ktor.model

open class XmlEntityWithImage (
    open val encodedImage: String? = null,
    override val imageGuid: String? = null,
    override val text: String? = null,
    override val width: Int = 0,
    override val height: Int = 0
) : XmlEntity()