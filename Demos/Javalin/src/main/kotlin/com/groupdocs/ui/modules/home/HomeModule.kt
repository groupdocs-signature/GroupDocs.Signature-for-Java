package com.groupdocs.ui.modules.home

import io.javalin.Javalin

fun Javalin.homeModule() {
    get("/signature") { ctx ->
        ClassLoader.getSystemResourceAsStream("view/index.html")?.let {
            ctx.contentType("text/html")
            ctx.result(it)
        }
    }

    get("/signature/app-name") { ctx ->
        ctx.result("signature-javalin")
    }
}