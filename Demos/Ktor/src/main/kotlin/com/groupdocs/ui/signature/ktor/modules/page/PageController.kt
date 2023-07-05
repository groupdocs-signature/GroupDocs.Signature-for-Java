package com.groupdocs.ui.signature.ktor.modules.page

import com.groupdocs.ui.signature.ktor.model.PageResponse
import com.groupdocs.ui.signature.ktor.modules.BaseController
import org.koin.core.component.KoinComponent

class PageControllerImpl : BaseController(), PageController, KoinComponent {
    override suspend fun page(): PageResponse {
        return PageResponse(123)
    }

}

interface PageController {
    suspend fun page(): PageResponse
}