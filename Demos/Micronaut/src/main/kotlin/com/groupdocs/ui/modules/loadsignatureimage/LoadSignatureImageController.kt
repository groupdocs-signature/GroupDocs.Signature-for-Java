package com.groupdocs.ui.modules.loadsignatureimage

import com.groupdocs.ui.model.*
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking


@Singleton
@Controller("/signature")
class LoadSignatureImageController(
    @Inject private val loadSignatureImageBean: LoadSignatureImageBean
) {
    @Post("/loadSignatureImage")
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(request: LoadSignatureImageRequest): HttpResponse<SignaturePageEntity> {
        val response = runBlocking { loadSignatureImageBean.loadImage(request) }

        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}