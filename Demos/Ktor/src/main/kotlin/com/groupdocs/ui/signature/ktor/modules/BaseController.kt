package com.groupdocs.ui.signature.ktor.modules

import com.groupdocs.ui.signature.ktor.config.SignatureConfig
import org.koin.java.KoinJavaComponent.inject

open class BaseController {

    protected val appConfig by inject<SignatureConfig>(SignatureConfig::class.java)
}