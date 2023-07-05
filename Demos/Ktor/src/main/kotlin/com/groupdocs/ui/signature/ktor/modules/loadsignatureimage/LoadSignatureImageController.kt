package com.groupdocs.ui.modules.loadsignatureimage



import com.groupdocs.ui.signature.ktor.model.LoadSignatureImageRequest
import com.groupdocs.ui.signature.ktor.model.SignaturePageEntity
import com.groupdocs.ui.signature.ktor.modules.BaseController
import org.koin.core.component.KoinComponent
import java.io.File
import java.nio.file.Files
import java.util.*


class LoadSignatureImageControllerImpl(
) : BaseController(), LoadSignatureImageController, KoinComponent {

    override suspend fun loadImage(request: LoadSignatureImageRequest): SignaturePageEntity {
        return try {
            val loadedPage = SignaturePageEntity()
            // get page image
            val file: File = File(request.guid)
            val bytes = Files.readAllBytes(file.toPath())
            // encode ByteArray into String
            val encodedImage = String(Base64.getEncoder().encode(bytes))
            loadedPage.data = encodedImage
            loadedPage
        } catch (ex: Exception) {
            throw RuntimeException(ex.message, ex)
        }
    }

}
interface LoadSignatureImageController {
    suspend fun loadImage(request: LoadSignatureImageRequest): SignaturePageEntity
}