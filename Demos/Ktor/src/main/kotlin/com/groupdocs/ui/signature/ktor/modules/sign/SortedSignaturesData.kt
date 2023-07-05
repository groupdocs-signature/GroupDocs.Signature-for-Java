package com.groupdocs.ui.signature.ktor.modules.sign

import com.groupdocs.ui.signature.ktor.model.SignatureDataEntity
import com.groupdocs.ui.util.SignatureType.BAR_CODE
import com.groupdocs.ui.util.SignatureType.DIGITAL
import com.groupdocs.ui.util.SignatureType.HAND
import com.groupdocs.ui.util.SignatureType.IMAGE
import com.groupdocs.ui.util.SignatureType.QR_CODE
import com.groupdocs.ui.util.SignatureType.STAMP
import com.groupdocs.ui.util.SignatureType.TEXT

class SortedSignaturesData {
    var signaturesData: List<SignatureDataEntity>? = null
    var images: MutableList<SignatureDataEntity> = ArrayList<SignatureDataEntity>()
    var texts: MutableList<SignatureDataEntity> = ArrayList<SignatureDataEntity>()
    var codes: MutableList<SignatureDataEntity> = ArrayList<SignatureDataEntity>()
    var stamps: MutableList<SignatureDataEntity> = ArrayList<SignatureDataEntity>()
    var digital: MutableList<SignatureDataEntity> = ArrayList<SignatureDataEntity>()

    fun sortedSignaturesData(signaturesData: List<SignatureDataEntity>?) {
        this.signaturesData = signaturesData
    }

    fun sort(): SortedSignaturesData {
        for (i in signaturesData!!.indices) {
            addToList(signaturesData!![i])
        }
        return this
    }

    private fun addToList(signatureDataEntity: SignatureDataEntity) {
        when (signatureDataEntity.signatureType) {
            TEXT -> texts.add(signatureDataEntity)
            DIGITAL -> digital.add(signatureDataEntity)
            IMAGE, HAND -> images.add(signatureDataEntity)
            STAMP -> stamps.add(signatureDataEntity)
            QR_CODE, BAR_CODE -> codes.add(signatureDataEntity)
            else -> throw IllegalArgumentException("Signature type is wrong")
        }
    }
}