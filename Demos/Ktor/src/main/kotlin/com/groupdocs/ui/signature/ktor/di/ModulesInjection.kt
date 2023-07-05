package com.groupdocs.ui.signature.ktor.di

import com.groupdocs.ui.modules.loadsignatureimage.LoadSignatureImageController
import com.groupdocs.ui.modules.loadsignatureimage.LoadSignatureImageControllerImpl
import com.groupdocs.ui.signature.ktor.manager.PathManager
import com.groupdocs.ui.signature.ktor.manager.PathManagerImpl
import com.groupdocs.ui.signature.ktor.modules.config.ConfigController
import com.groupdocs.ui.signature.ktor.modules.config.ConfigControllerImpl
import com.groupdocs.ui.signature.ktor.modules.deletesignaturefile.DeleteSignatureController
import com.groupdocs.ui.signature.ktor.modules.deletesignaturefile.DeleteSignatureControllerImpl
import com.groupdocs.ui.signature.ktor.modules.description.DescriptionController
import com.groupdocs.ui.signature.ktor.modules.description.DescriptionControllerImpl
import com.groupdocs.ui.signature.ktor.modules.download.DownloadController
import com.groupdocs.ui.signature.ktor.modules.download.DownloadControllerImpl
import com.groupdocs.ui.signature.ktor.modules.page.PageController
import com.groupdocs.ui.signature.ktor.modules.page.PageControllerImpl
import com.groupdocs.ui.signature.ktor.modules.sign.SignController
import com.groupdocs.ui.signature.ktor.modules.sign.SignControllerImpl
import com.groupdocs.ui.signature.ktor.modules.tree.TreeController
import com.groupdocs.ui.signature.ktor.modules.tree.TreeControllerImpl
import com.groupdocs.ui.signature.ktor.modules.upload.UploadController
import com.groupdocs.ui.signature.ktor.modules.upload.UploadControllerImpl
import com.groupdocs.ui.signature.ktor.usecase.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object ModulesInjection {
    val controllerBeans = module {
        singleOf(::ConfigControllerImpl) { bind<ConfigController>() }
        singleOf(::TreeControllerImpl) { bind<TreeController>() }
        singleOf(::DownloadControllerImpl) { bind<DownloadController>() }
        singleOf(::UploadControllerImpl) { bind<UploadController>() }
        singleOf(::SignControllerImpl) { bind<SignController>() }
        singleOf(::PageControllerImpl) { bind<PageController>() }
        singleOf(::DescriptionControllerImpl) { bind<DescriptionController>() }
        singleOf(::LoadSignatureImageControllerImpl) { bind<LoadSignatureImageController>() }
        singleOf(::DeleteSignatureControllerImpl) { bind<DeleteSignatureController>() }
    }
    val usecaseBeans = module {
        singleOf(::GetLocalFilesUseCase)
        singleOf(::RetrieveLocalFilePagesStreamUseCase)
        singleOf(::AreFilesSupportedUseCase)
        singleOf(::SignatureDocumentsUseCase)
        singleOf(::SaveStreamToFilesDirectoryUseCase)
    }
    val managerBeans = module {
        singleOf(::PathManagerImpl) { bind<PathManager>() }
    }
}