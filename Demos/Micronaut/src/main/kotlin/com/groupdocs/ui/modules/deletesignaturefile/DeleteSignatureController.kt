package com.groupdocs.ui.signature.ktor.modules.deletesignaturefile

import com.groupdocs.ui.model.ConfigResponse
import com.groupdocs.ui.model.DeleteSignatureFileRequest
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
class DeleteSignatureController(
    @Inject private val deleteSignatureBean: DeleteSignatureBean
) {
    @Post("/deleteSignatureFile")
    @Produces(MediaType.APPLICATION_JSON)
    fun comparer(request: DeleteSignatureFileRequest): HttpResponse<*> {
        val response = runBlocking { deleteSignatureBean.deleteSignatureFile(request) }

        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}