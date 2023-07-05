package com.groupdocs.ui.modules.sign

import com.groupdocs.signature.Signature
import com.groupdocs.signature.domain.SignResult
import com.groupdocs.signature.options.loadoptions.LoadOptions
import com.groupdocs.signature.options.saveoptions.SaveOptions
import com.groupdocs.signature.options.sign.ImageSignOptions
import com.groupdocs.signature.options.sign.SignOptions
import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.model.*
import com.groupdocs.ui.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.usecase.RetrieveLocalFilePagesStreamUseCase
import com.groupdocs.ui.usecase.SignatureDocumentsUseCase
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*

interface SignBean {
    suspend fun sign(request: SignDocumentRequest): SignedDocumentEntity
}
@Bean(typed = [SignBean::class])
@Singleton
class SignBeanImpl(
    @Inject private val checkAreFilesSupported: AreFilesSupportedUseCase,
    @Inject private val signDocument: SignatureDocumentsUseCase,
    @Inject private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesStreamUseCase,
    @Inject private val pathManager: PathManager
) :  SignBean {

    private val supportedImageFormats: MutableList<String> = Arrays.asList<String>(
        "bmp",
        "jpeg",
        "jpg",
        "tiff",
        "tif",
        "png"
    )

    override suspend fun sign(request: SignDocumentRequest): SignedDocumentEntity {
        val documentGuid: String? = URLDecoder.decode(request.guid, StandardCharsets.UTF_8.toString())
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
            val result: SignResult = signature.sign(documentGuid, signsCollection, saveOptions)
        } catch (ex: java.lang.Exception) {
            throw RuntimeException(ex.message, ex)
        }
        val signedDocument = SignedDocumentEntity()
        signedDocument.guid = URLEncoder.encode(documentGuid, StandardCharsets.UTF_8.toString())
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
         if (!sortedSignaturesData!!.images.isEmpty()) {
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
                val signOptions = ImageSignOptions(URLDecoder.decode(signatureDataEntity.signatureGuid, StandardCharsets.UTF_8.toString()))
                signOptions.left = signatureDataEntity.left
                signOptions.top = signatureDataEntity.top
                signOptions.width = signatureDataEntity.imageWidth
                signOptions.height = signatureDataEntity.imageHeight
                signOptions.pageNumber = signatureDataEntity.pageNumber
                signOptions.rotationAngle = signatureDataEntity.angle
                signsCollection.add(signOptions)
            }
            return signsCollection
        } catch (ex: Exception) {
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

