package com.groupdocs.ui.signature.ktor.modules.home

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.homeModule() {
    route("/") {
        get {
            call.respondHtmlTemplate(HomeTemplate()) {
                pageTitle {
                    +"Signature for Java Ktor"
                }
            }
        }
    }

    get("/app-name") {
        call.respondText("signature-ktor")
    }
}