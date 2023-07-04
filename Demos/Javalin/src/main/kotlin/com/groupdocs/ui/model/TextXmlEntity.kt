package com.groupdocs.ui.model

class TextXmlEntity (
    val backgroundColor: String = "rgb(255,255,255)",
    val fontColor: String = "rgb(0,0,0)",
    val font: String? = null,
    val fontSize: Int = 0,
    val bold: Boolean = false,
    val italic: Boolean = false,
    val underline: Boolean = false,
    override val encodedImage: String? = null,
    override var imageGuid: String? = null,
    override val text: String? = null,
    override val width: Int = 0,
    override val height: Int = 0
) : XmlEntityWithImage()