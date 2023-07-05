package com.groupdocs.ui.modules.tree

import com.groupdocs.signature.domain.documentpreview.FileType
import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.model.FileDescriptionEntity
import com.groupdocs.ui.model.SignatureFileDescriptionEntity
import com.groupdocs.ui.model.TreeRequest
import com.groupdocs.ui.modules.signatureloader.SignatureLoader
import com.groupdocs.ui.usecase.GetLocalFilesUseCase
import com.groupdocs.ui.usecase.LocalStorageEntry
import com.groupdocs.ui.util.SignatureDirectory
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.io.File
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

interface TreeBean {
    suspend fun tree(request: TreeRequest): List<FileDescriptionEntity>
}

@Bean(typed = [TreeBean::class])
@Singleton
class TreeBeanImpl(
    @Inject private val getLocalFiles: GetLocalFilesUseCase,
    @Inject private val pathManager: PathManager,
) : TreeBean {
    override suspend fun tree(request: TreeRequest): List<FileDescriptionEntity> {
        val signatureType = if (request.signatureType == null) "" else request.signatureType
        // get file list from storage path
        val signatureTypePath = SignatureDirectory.getPathFromSignatureType(signatureType)
        if (signatureTypePath != null) {
            val rootDirectory = pathManager.dataDirectory.toString() + signatureTypePath
            // get all the files from a directory
            var relDirPath: String = URLDecoder.decode(request.path, StandardCharsets.UTF_8.toString())
            if (relDirPath.isEmpty()) {
                relDirPath = rootDirectory
            } else {
                relDirPath = String.format("%s%s%s", rootDirectory, File.separator, relDirPath)
            }
            return loadFiles(signatureType, relDirPath)
        } else {
            val path = pathManager.assertPathIsInsideFilesDirectory(URLDecoder.decode(request.path, StandardCharsets.UTF_8.toString()))

            val localFiles = getLocalFiles(path)
            return localFiles.sortedBy {
                it is LocalStorageEntry.File
            }.filter { it.name != "SignatureData" }.map {
                val docType = if (it is LocalStorageEntry.File) FileType.fromExtension(it.name).fileFormat else null
                val isDirectory = it is LocalStorageEntry.Directory
                val size = if (it is LocalStorageEntry.File) it.size else 0

                val filesDirectory = pathManager.filesDirectory
                val fileFullPath = it.fullPath
                val guid = filesDirectory.relativize(fileFullPath).toString()
                FileDescriptionEntity(
                    guid = URLEncoder.encode(fileFullPath.toString(), StandardCharsets.UTF_8.toString()),
                    name = it.name,
                    docType = docType,
                    directory = isDirectory,
                    size = size
                )
            }
        }
    }
    /**
     * Load files
     *
     * @param signatureType
     * @param relDirPath
     * @return list of files descriptions
     */
    private fun loadFiles(signatureType: String, relDirPath: String): List<SignatureFileDescriptionEntity> {
        var fileList: List<SignatureFileDescriptionEntity>
        //fileList = when (signatureType) {
        //DIGITAL -> signatureLoader.loadFiles(relDirPath, signatureConfiguration.getDataDirectory(), signatureType)
        //IMAGE, HAND -> signatureLoader.loadImageSignatures(relDirPath, signatureConfiguration.getDataDirectory())
        //TEXT -> signatureLoader.loadTextSignatures(relDirPath, signatureConfiguration.getDataDirectory())
        //STAMP, QR_CODE, BAR_CODE -> signatureLoader.loadSignatures(
        //    relDirPath,
        //    signatureConfiguration.getDataDirectory(),
        //    signatureType
        //)
        //else -> signatureLoader.loadFiles(relDirPath, signatureConfiguration.getDataDirectory(), signatureType)

        //}
        fileList = SignatureLoader.loadImageSignatures(relDirPath, pathManager.dataDirectory.toString());

        return fileList
    }
}