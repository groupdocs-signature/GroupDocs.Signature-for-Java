package com.groupdocs.ui.signature.ktor.usecase


import com.groupdocs.signature.Signature
import com.groupdocs.signature.options.PageStreamFactory
import com.groupdocs.signature.options.PreviewOptions
import com.groupdocs.signature.options.loadoptions.LoadOptions
import com.groupdocs.ui.signature.ktor.manager.PathManager
import com.groupdocs.ui.signature.ktor.status.InternalServerException
import org.koin.core.component.KoinComponent
import java.io.*
import java.nio.file.Files
import java.nio.file.Path

class RetrieveLocalFilePagesStreamUseCase(
    private val managerBeans: PathManager
) : KoinComponent {
    operator fun invoke(
        inputStream: InputStream,
        password: String? = null,
        previewWidth: Int,
        previewRatio: Float,
        processStream: (pageNumber: Int, inputStream: InputStream) -> Unit
    ) =
        try {
            Signature(inputStream, LoadOptions().apply {setPassword(password) }).let { document ->
                val pages = mutableMapOf<Int, Path>()

                val previewOptions = PreviewOptions(object : PageStreamFactory {
                    override fun createPageStream(pageNumber: Int): OutputStream {
                        val pathForTempFile = managerBeans.createPathForTempFile()
                        pages[pageNumber] = pathForTempFile
                        return BufferedOutputStream(FileOutputStream(pathForTempFile.toFile()))
                    }

                    override fun closePageStream(pageNumber: Int, p1: OutputStream?) {
                        if (p1 != null) {
                            p1.close()
                        }
                        pages[pageNumber]?.let { pagePath ->
                            BufferedInputStream(FileInputStream(pagePath.toFile())).use { inputStream ->
                                processStream(pageNumber, inputStream)
                            }
                            Files.deleteIfExists(pagePath)
                        }
                    }
                })

                previewOptions.width = previewWidth
                previewOptions.height = (previewWidth * previewRatio).toInt()


                document.generatePreview(previewOptions)
            }
        } catch (e: Exception) {
            throw RetrieveLocalFilePagesStreamException("Can't retrieve local file description", e)

        }
}

class RetrieveLocalFilePagesStreamException(message: String, e: Throwable? = null) : InternalServerException(message, e)