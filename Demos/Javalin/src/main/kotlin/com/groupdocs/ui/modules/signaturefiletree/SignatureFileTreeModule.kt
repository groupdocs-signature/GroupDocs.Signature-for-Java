package com.groupdocs.ui.modules.signaturefiletree

import com.groupdocs.ui.model.DescriptionRequest
import com.groupdocs.ui.modules.description.DescriptionController
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent

fun Javalin.signatureFileTreeModule() {
    val controller: DescriptionController by KoinJavaComponent.inject(DescriptionController::class.java)

    post("/signature/loadDocumentDescription") { ctx ->
        val request = ctx.bodyAsClass(DescriptionRequest::class.java)
        runBlocking {
            val response = controller.description(request)
            ctx.json(response)
        }
    }
}