package com.groupdocs.ui.modules.loadsignatureimage


import com.groupdocs.ui.signature.ktor.model.LoadSignatureImageRequest
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject




fun Route.loadSignatureImageModule() {
    val controller by inject<LoadSignatureImageController>()

    post("//loadSignatureImage") {
        val request = call.receive<LoadSignatureImageRequest>()
        val response = controller.loadImage(request)
        call.respond(response)
//        call.respondBytes(HttpStatusCode.OK)
    }
}
