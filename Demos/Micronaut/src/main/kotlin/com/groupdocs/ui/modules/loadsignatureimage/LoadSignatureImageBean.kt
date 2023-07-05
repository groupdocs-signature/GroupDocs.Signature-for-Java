package com.groupdocs.ui.modules.loadsignatureimage


import com.groupdocs.ui.model.LoadSignatureImageRequest
import com.groupdocs.ui.model.SignaturePageEntity
import com.groupdocs.ui.modules.tree.TreeBean
import io.micronaut.context.annotation.Bean
import jakarta.inject.Singleton
import java.io.File
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.*

interface LoadSignatureImageBean {
    suspend fun loadImage(request: LoadSignatureImageRequest): SignaturePageEntity
}

@Bean(typed = [LoadSignatureImageBean::class])
@Singleton
class LoadSignatureImageBeanImpl(
) : LoadSignatureImageBean {

    override suspend fun loadImage(request: LoadSignatureImageRequest): SignaturePageEntity {
        return try {
            val loadedPage = SignaturePageEntity()
            // get page image
            val file: File = File(URLDecoder.decode(request.guid, StandardCharsets.UTF_8.toString()))
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
