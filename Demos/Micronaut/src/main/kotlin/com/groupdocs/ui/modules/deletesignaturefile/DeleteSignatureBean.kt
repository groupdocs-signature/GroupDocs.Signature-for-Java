package com.groupdocs.ui.signature.ktor.modules.deletesignaturefile

import com.groupdocs.ui.model.DeleteSignatureFileRequest
import com.groupdocs.ui.modules.signatureloader.SignatureLoader.Companion.getXmlFilePath
import com.groupdocs.ui.modules.tree.TreeBean
import com.groupdocs.ui.util.SignatureType.DIGITAL
import com.groupdocs.ui.util.SignatureType.IMAGE
import io.micronaut.context.annotation.Bean
import jakarta.inject.Singleton
import java.io.File


interface DeleteSignatureBean {
    suspend fun deleteSignatureFile(request: DeleteSignatureFileRequest)
}
@Bean(typed = [DeleteSignatureBean::class])
@Singleton
class DeleteSignatureBeanImpl () : DeleteSignatureBean {
    override suspend fun deleteSignatureFile(request: DeleteSignatureFileRequest) {
        val signatureType: String = request.signatureType
        if (IMAGE.equals(signatureType) ||
            DIGITAL.equals(signatureType)
        ) {
            File(request.guid).delete()
        } else {
            val file: File = File(request.guid)
            file.delete()
            val xmlFilePath: String = getXmlFilePath(file)
            File(xmlFilePath).delete()
        }

    }
}
