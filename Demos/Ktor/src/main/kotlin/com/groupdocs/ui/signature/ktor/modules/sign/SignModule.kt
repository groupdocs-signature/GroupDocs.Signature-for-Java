package com.groupdocs.ui.signature.ktor.modules.sign

import com.groupdocs.ui.signature.ktor.model.ErrorResponse
import com.groupdocs.ui.signature.ktor.model.SignDocumentRequest
import com.groupdocs.ui.signature.ktor.status.InternalServerException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.compareModule() {
    val controller by inject<SignController>()

    post("/sign") {
        try {
            val request = call.receive<SignDocumentRequest>()
            val response = controller.sign(request)
            call.respond(HttpStatusCode.OK, response)
        } catch (e: InternalServerException) {
            call.respond(
                status = HttpStatusCode.InternalServerError,
                message = ErrorResponse(
                    message = if (e.message == "File's types are different or are not supported") {
                        "Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Comparison itself. Other probable reason of the error - documents types are different."
                    } else {
                        e.message
                    }
                )
            )
        }
    }
}