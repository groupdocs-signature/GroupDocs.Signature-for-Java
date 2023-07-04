package com.groupdocs.ui.modules.upload

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.model.UploadResponse
import com.groupdocs.ui.util.InternalServerException
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject
import java.io.BufferedInputStream

fun Javalin.uploadModule() {
    val controller: UploadController by inject(UploadController::class.java)
    val appConfig: ApplicationConfig by inject(ApplicationConfig::class.java)

    post("/signature/uploadDocument") { ctx ->
        val isUploadEnabled = appConfig.common.upload
        if (!isUploadEnabled) {
            throw InternalServerException("Files uploading is disabled!")
        }
        val urlParam = ctx.formParam("url")
        val signatureType = ctx.formParam("signatureType")

        runBlocking {

            val response: UploadResponse = if (urlParam == null) {
                ctx.uploadedFile("file")?.let { uploadedFile ->
                    BufferedInputStream(uploadedFile.content).use { inputStream ->
                        if(signatureType != null){
                            return@let controller.uploadFile(uploadedFile.filename, inputStream, signatureType)
                        } else {
                            return@let controller.uploadDisk(uploadedFile.filename, inputStream)
                        }
                    }
                } ?: throw InternalServerException("Incorrect request!")
            } else {
                controller.uploadUrl(urlParam)
            }

            ctx.json(response)
        }
    }
}