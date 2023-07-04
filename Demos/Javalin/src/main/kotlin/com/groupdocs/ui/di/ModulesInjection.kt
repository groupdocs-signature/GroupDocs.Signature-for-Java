package com.groupdocs.ui.di

import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.manager.PathManagerImpl
import com.groupdocs.ui.modules.sign.SignController
import com.groupdocs.ui.modules.sign.SignControllerImpl
import com.groupdocs.ui.modules.config.ConfigController
import com.groupdocs.ui.modules.config.ConfigControllerImpl
import com.groupdocs.ui.modules.description.DescriptionController
import com.groupdocs.ui.modules.description.DescriptionControllerImpl
import com.groupdocs.ui.modules.download.DownloadController
import com.groupdocs.ui.modules.download.DownloadControllerImpl
import com.groupdocs.ui.modules.loadsignatureimage.LoadSignatureImageController
import com.groupdocs.ui.modules.loadsignatureimage.LoadSignatureImageControllerImpl
import com.groupdocs.ui.modules.tree.TreeController
import com.groupdocs.ui.modules.tree.TreeControllerImpl
import com.groupdocs.ui.modules.upload.UploadController
import com.groupdocs.ui.modules.upload.UploadControllerImpl
import com.groupdocs.ui.usecase.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object ModulesInjection {
    val controllerBeans = module {
        singleOf(::ConfigControllerImpl) { bind<ConfigController>() }
        singleOf(::TreeControllerImpl) { bind<TreeController>() }
        singleOf(::DescriptionControllerImpl) { bind<DescriptionController>() }
        singleOf(::SignControllerImpl) { bind<SignController>() }
        singleOf(::DownloadControllerImpl) { bind<DownloadController>() }
        singleOf(::UploadControllerImpl) { bind<UploadController>() }
        singleOf(::LoadSignatureImageControllerImpl) { bind<LoadSignatureImageController>() }
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