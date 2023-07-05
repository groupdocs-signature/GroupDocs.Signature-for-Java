package com.groupdocs.ui.signature.ktor.modules.deletesignaturefile

import com.groupdocs.ui.modules.signatureloader.SignatureLoader.Companion.getXmlFilePath
import com.groupdocs.ui.signature.ktor.model.DeleteSignatureFileRequest
import com.groupdocs.ui.signature.ktor.modules.BaseController
import com.groupdocs.ui.util.SignatureType.DIGITAL
import com.groupdocs.ui.util.SignatureType.IMAGE
import org.koin.core.component.KoinComponent
import java.io.File

class DeleteSignatureControllerImpl () : BaseController(),DeleteSignatureController, KoinComponent {
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
interface DeleteSignatureController {
    suspend fun deleteSignatureFile(request: DeleteSignatureFileRequest)
}