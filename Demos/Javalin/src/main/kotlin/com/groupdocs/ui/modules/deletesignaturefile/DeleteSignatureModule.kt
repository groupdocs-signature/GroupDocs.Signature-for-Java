package com.groupdocs.ui.signature.ktor.modules.deletesignaturefile

import com.groupdocs.ui.model.DeleteSignatureFileRequest
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent


fun Javalin.deleteSignatureModule() {
    val controller: DeleteSignatureController by KoinJavaComponent.inject(DeleteSignatureController::class.java)

    post("/signature/deleteSignatureFile") { ctx ->
        val request = ctx.bodyAsClass(DeleteSignatureFileRequest::class.java)
        runBlocking {
            val response = controller.deleteSignatureFile(request)
            ctx.json(response)
        }
    }
}