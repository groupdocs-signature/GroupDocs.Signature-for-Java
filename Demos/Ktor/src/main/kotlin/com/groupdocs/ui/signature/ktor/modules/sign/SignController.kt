package com.groupdocs.ui.signature.ktor.modules.sign

import com.groupdocs.signature.Signature
import com.groupdocs.signature.domain.SignResult
import com.groupdocs.signature.options.loadoptions.LoadOptions
import com.groupdocs.signature.options.saveoptions.SaveOptions
import com.groupdocs.signature.options.sign.ImageSignOptions
import com.groupdocs.signature.options.sign.SignOptions
import com.groupdocs.ui.signature.ktor.manager.PathManager
import com.groupdocs.ui.signature.ktor.model.SignDocumentRequest
import com.groupdocs.ui.signature.ktor.model.SignatureDataEntity
import com.groupdocs.ui.signature.ktor.model.SignedDocumentEntity
import com.groupdocs.ui.signature.ktor.modules.BaseController
import com.groupdocs.ui.signature.ktor.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.signature.ktor.usecase.RetrieveLocalFilePagesStreamUseCase
import com.groupdocs.ui.signature.ktor.usecase.SignatureDocumentsUseCase
import org.koin.core.component.KoinComponent
import java.util.*

class SignControllerImpl(

    private val checkAreFilesSupported: AreFilesSupportedUseCase,
    private val signDocument: SignatureDocumentsUseCase,
    private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesStreamUseCase,
    private val pathManager: PathManager
) : BaseController(), SignController, KoinComponent {

    private val supportedImageFormats: MutableList<String> = Arrays.asList<String>(
        "bmp",
        "jpeg",
        "jpg",
        "tiff",
        "tif",
        "png"
    )

    override suspend fun sign(request: SignDocumentRequest): SignedDocumentEntity {
        val documentGuid: String? = request.guid
        val loadOptions = LoadOptions()
        loadOptions.password = request.password
        val signature = Signature(documentGuid, loadOptions)
        val signsCollection: List<SignOptions> = buildSignOptions(request)

        // set save options
        val saveOptions = SaveOptions()
        saveOptions.password = request.password
        saveOptions.overwriteExistingFiles = true

        // sign document
        try {
            signature.sign(documentGuid, signsCollection, saveOptions)
        } catch (ex: java.lang.Exception) {
            //logger.error(
            //    "Exception occurred while signing document",
            //    ex
            //)
            throw RuntimeException(ex.message, ex)
        }
        val signedDocument = SignedDocumentEntity()
        signedDocument.guid = documentGuid
        return signedDocument
    }

    fun buildSignOptions(request: SignDocumentRequest): List<SignOptions> {
        val signaturesData: List<SignatureDataEntity>? = request.signaturesData
        var sortedSignaturesData: SortedSignaturesData = SortedSignaturesData()
        sortedSignaturesData.sortedSignaturesData(signaturesData)
        sortedSignaturesData = sortedSignaturesData.sort()
        val signsCollection: MutableList<SignOptions> = ArrayList<SignOptions>()
        //if (!sortedSignaturesData.digital.isEmpty()) {
        //    signDigital(signDocumentRequest.getPassword(), sortedSignaturesData.digital, documentType, signsCollection)
        //}
        if (!sortedSignaturesData.images.isEmpty()) {
            signImage(sortedSignaturesData.images, signsCollection)
        }
        //if (!sortedSignaturesData.texts.isEmpty()) {
        //    signText(documentType, sortedSignaturesData.texts, signsCollection)
        //}
        //if (!sortedSignaturesData.stamps.isEmpty()) {
        //    signStamp(documentType, sortedSignaturesData.stamps, signsCollection)
        //}
        //if (!sortedSignaturesData.codes.isEmpty()) {
        //    signOptical(documentType, sortedSignaturesData.codes, signsCollection)
        //}
        return signsCollection
    }

    private fun signImage(images: List<SignatureDataEntity>, signsCollection: MutableList<SignOptions>) : List<SignOptions> {
        try {
            for (i in images.indices) {
                val signatureDataEntity = images[i]
                // setup options
                // setup image signature options
                val signOptions = ImageSignOptions(signatureDataEntity.signatureGuid)
                signOptions.left = signatureDataEntity.left
                signOptions.top = signatureDataEntity.top
                signOptions.width = signatureDataEntity.imageWidth.toInt()
                signOptions.height = signatureDataEntity.imageHeight.toInt()
                signOptions.pageNumber = signatureDataEntity.pageNumber
                signOptions.rotationAngle = signatureDataEntity.angle
                signsCollection.add(signOptions)
            }
            return signsCollection
        } catch (ex: Exception) {
            //logger.error(
           //     "Exception occurred while signing by image signature",
           //     ex
            //)
            throw RuntimeException(ex.message, ex)
        }
    }

    private fun getDocumentType(documentType: String?, fileExtension: String): String? {
        // mimeType should now be something like "image/png" if the document is image
        val isImage: Boolean =
            supportedImageFormats.contains(fileExtension)
        return if (isImage) "image" else documentType
    }
}

interface SignController {
    suspend fun sign(request: SignDocumentRequest): SignedDocumentEntity
}