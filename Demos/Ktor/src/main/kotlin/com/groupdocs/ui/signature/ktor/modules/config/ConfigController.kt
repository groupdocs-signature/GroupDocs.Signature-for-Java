package com.groupdocs.ui.signature.ktor.modules.config

import com.groupdocs.ui.signature.ktor.model.ConfigResponse
import com.groupdocs.ui.signature.ktor.modules.BaseController
import org.koin.core.component.KoinComponent

class ConfigControllerImpl : BaseController(), ConfigController, KoinComponent {

    override suspend fun config(): ConfigResponse {
        return ConfigResponse(
            browse = appConfig.common.browse,
            download = appConfig.common.download,
            enableRightClick = appConfig.common.enableRightClick,
            pageSelector = appConfig.common.pageSelector,
            preloadResultPageCount = appConfig.signature.preloadResultPageCount,
            print = appConfig.common.print,
            rewrite = appConfig.common.rewrite,
            upload = appConfig.common.upload,
        )
    }

}

interface ConfigController {
    suspend fun config(): ConfigResponse
}