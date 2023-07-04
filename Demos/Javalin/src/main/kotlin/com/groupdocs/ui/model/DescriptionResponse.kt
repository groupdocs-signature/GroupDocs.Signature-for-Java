package com.groupdocs.ui.model


data class LoadDocumentEntity (
    /**
     * Document Guid
     */
    val guid: String,

    /**
     * list of pages
     */
    val pages: MutableList<PageDescriptionEntity> = mutableListOf(),

    /**
     * Restriction for printing pdf files in viewer
     */
    val printAllowed: Boolean = true
)

/**
 * PageDescriptionEntity
 *
 * @author Aspose Pty Ltd
 */
open class PageDescriptionEntity (
    open var data: String? = null,
    open val angle: Int = 0,
    open val width: Int = 0,
    open val height: Int = 0,
    open var number: Int = 0,
)


