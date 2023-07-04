package com.groupdocs.ui.modules.loadsignatureimage

import com.groupdocs.ui.model.LoadSignatureImageRequest
import org.koin.java.KoinJavaComponent.inject
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking



fun Javalin.loadSignatureImageModule() {
    val controller: LoadSignatureImageController by inject(LoadSignatureImageController::class.java)

    post("/signature/loadSignatureImage") { ctx ->
        val request = ctx.bodyAsClass(LoadSignatureImageRequest::class.java)
        runBlocking {
            val response = controller.loadImage(request)
            ctx.header("Access-Control-Allow-Credentials", true.toString())
            ctx.json(response)
        }
    }
}
