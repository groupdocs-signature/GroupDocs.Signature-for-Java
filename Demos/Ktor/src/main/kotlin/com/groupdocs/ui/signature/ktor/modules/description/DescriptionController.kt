package com.groupdocs.ui.signature.ktor.modules.description

import com.groupdocs.ui.signature.ktor.manager.PathManager
import com.groupdocs.ui.signature.ktor.model.DescriptionRequest
import com.groupdocs.ui.signature.ktor.model.LoadDocumentEntity
import com.groupdocs.ui.signature.ktor.model.PageDescriptionEntity
import com.groupdocs.ui.signature.ktor.modules.BaseController
import com.groupdocs.ui.signature.ktor.usecase.RetrieveLocalFilePagesStreamUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.util.*

class DescriptionControllerImpl(
    private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesStreamUseCase,
    private val pathManager: PathManager
) : BaseController(), DescriptionController, KoinComponent {
    override suspend fun description(request: DescriptionRequest): LoadDocumentEntity {
        val path = pathManager.assertPathIsInsideFilesDirectory(request.guid)
        val password = request.password
        val previewPageWidth = appConfig.signature.previewPageWidthOrDefault
        val previewPageRatio = appConfig.signature.previewPageRatioOrDefault

        val entity = LoadDocumentEntity(
            guid = path.toString(),
            printAllowed = appConfig.common.print
        )
        return withContext(Dispatchers.IO) {
            BufferedInputStream(FileInputStream(path.toFile())).use { inputStream ->
                retrieveLocalFilePagesStream(
                    inputStream = inputStream,
                    password = password,
                    previewWidth = previewPageWidth,
                    previewRatio = previewPageRatio
                ) { pageNumber, pageInputStream ->
                    val data = Base64.getEncoder().encodeToString(pageInputStream.readAllBytes())
                    entity.pages.add(
                        PageDescriptionEntity(
                            number = pageNumber + 1,
                            width = previewPageWidth,
                            height = (previewPageWidth * previewPageRatio).toInt(),
                            data = data
                        )
                    )
                }
                entity
            }
        }
    }

}

interface DescriptionController {
    suspend fun description(request: DescriptionRequest): LoadDocumentEntity
}