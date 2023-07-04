package com.groupdocs.ui.modules.sign

import com.groupdocs.ui.model.SignDocumentRequest
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject

fun Javalin.signModule() {
    val controller: SignController by inject(SignController::class.java)

    post("/signature/sign") { ctx ->
        val request = ctx.bodyAsClass(SignDocumentRequest::class.java)
        runBlocking {
            val response = controller.sign(request)
            ctx.json(response)
        }
    }
}