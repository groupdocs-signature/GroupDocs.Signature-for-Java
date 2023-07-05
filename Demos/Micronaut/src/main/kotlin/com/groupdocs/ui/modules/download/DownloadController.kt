package com.groupdocs.ui.modules.download

import com.groupdocs.ui.model.ConfigResponse
import com.groupdocs.ui.util.InternalServerException
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking
import java.io.BufferedInputStream
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.nio.file.Paths

@Singleton
@Controller("/signature")
class DownloadController(
    @Inject private val downloadBean: DownloadBean
) {
    @Get("/downloadDocument")
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(@QueryValue path: String): HttpResponse<*> {
        val decodedGuid = path ?: throw InternalServerException("Document guid is not provided!")
        val guidAsPath = Paths.get(path)
        val fileName = guidAsPath.fileName.toString()
        val URLEncodedFileName: String = URLEncoder.encode(fileName, "UTF-8")
        val resultFileName = URLEncodedFileName.replace('+', ' ')
        val inputStream = runBlocking { downloadBean.download(fileName = decodedGuid) }

        return HttpResponse.ok<ConfigResponse>()
            .header("Content-disposition", "attachment; filename=${resultFileName}")
            .header("Content-Description", "File Transfer")
            .header("Content-Transfer-Encoding", "binary")
            .header("Cache-Control", "must-revalidate")
            .header("Pragma", "public")
            .body(BufferedInputStream(inputStream))
    }
}