package com.groupdocs.ui.modules.sign

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
class SignController(
    @Inject private val signBean: SignBean
) {
    @Post("/sign")
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(request: SignDocumentRequest): HttpResponse<SignedDocumentEntity> {
        val response = runBlocking { signBean.sign(request) }

        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}