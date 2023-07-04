package com.groupdocs.ui.modules.download

import com.groupdocs.ui.util.InternalServerException
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject
import java.net.URLEncoder
import java.nio.file.Paths

fun Javalin.downloadModule() {
    val controller: DownloadController by inject(DownloadController::class.java)

    get("/signature/downloadDocument") { ctx ->
        val guid = ctx.queryParam("path") ?: throw InternalServerException("Document guid is not provided!")
        val guidAsPath = Paths.get(guid)
        val fileName = guidAsPath.fileName.toString()
        val URLEncodedFileName: String = URLEncoder.encode(fileName, "UTF-8")
        val ResultFileName = URLEncodedFileName.replace('+', ' ')
        ctx.header("Content-disposition", "attachment; filename=${ResultFileName}")
        ctx.header("Content-Description", "File Transfer")
        ctx.header("Content-Transfer-Encoding", "binary")
        ctx.header("Cache-Control", "must-revalidate")
        ctx.header("Pragma", "public")
        runBlocking {
            val inputStream = controller.download(fileName = guid)
            ctx.result(inputStream)
        }
    }
}