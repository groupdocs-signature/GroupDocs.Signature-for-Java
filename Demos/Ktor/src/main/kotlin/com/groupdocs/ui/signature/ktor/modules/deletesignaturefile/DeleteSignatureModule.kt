package com.groupdocs.ui.signature.ktor.modules.deletesignaturefile

import com.groupdocs.ui.signature.ktor.model.DeleteSignatureFileRequest
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.deleteSignatureModule() {
    val deleteSignatureController by inject<DeleteSignatureController>()

    post("/deleteSignatureFile") {
        val request = call.receive<DeleteSignatureFileRequest>()
        val response = deleteSignatureController.deleteSignatureFile(request)
        call.respond(response)
    }
}