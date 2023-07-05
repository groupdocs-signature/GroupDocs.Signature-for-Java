package com.groupdocs.ui.signature.ktor.modules.download

import com.groupdocs.ui.signature.ktor.status.InternalServerException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.net.URLEncoder
import java.nio.file.Paths

fun Route.downloadModule() {
    val downloadController by inject<DownloadController>()

    get("/downloadDocument") {
        call.parameters["path"]?.let { guid ->
            val guidAsPath = Paths.get(guid)
            val fileName = guidAsPath.fileName.toString()
            val URLEncodedFileName: String = URLEncoder.encode(fileName, "UTF-8")
            val resultFileName = URLEncodedFileName.replace('+', ' ')
            call.response.headers.apply {
                append("Content-disposition", "attachment; filename=${resultFileName}")
                append("Content-Description", "File Transfer")
                append("Content-Transfer-Encoding", "binary")
                append("Cache-Control", "must-revalidate")
                append("Pragma", "public")
            }

            call.respondOutputStream(
                status = HttpStatusCode.OK,
                contentType = ContentType.Application.OctetStream,
                producer = {
                    downloadController.download(
                        fileName = guid,
                        outputStream = this
                    )
                }
            )
        } ?: throw InternalServerException("Document guid is not provided!")
    }
}