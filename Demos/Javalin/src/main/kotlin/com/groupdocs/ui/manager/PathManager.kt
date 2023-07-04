package com.groupdocs.ui.manager

import com.groupdocs.ui.Defaults
import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.logger
import com.groupdocs.ui.util.InternalServerException
import com.groupdocs.ui.util.SignatureDirectory
import org.koin.core.component.KoinComponent
import java.io.File
import java.io.IOException
import java.nio.file.FileAlreadyExistsException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import java.util.regex.Pattern
import kotlin.math.min

/**
 * Manages path to temp, cache, files or result directory according to config
 * Does not create or check is any directory exist
 */
class PathManagerImpl(
    private val appConfig: ApplicationConfig
) : PathManager, KoinComponent {
    private val isLocalProvider: Boolean by lazy {
        appConfig.signature.filesProviderTypeOrDefault == Defaults.Signature.FilesProviderType.LOCAL
    }

    override val tempDirectory: Path by lazy {
        val absoluteOrRelativeTempDirectory = Paths.get(appConfig.signature.tempDirectoryOrDefault)
        if (absoluteOrRelativeTempDirectory.isAbsolute) {
            absoluteOrRelativeTempDirectory
        } else if (isLocalProvider) {
            filesDirectory.resolve(absoluteOrRelativeTempDirectory)
        } else {
            absoluteOrRelativeTempDirectory.toAbsolutePath()
        }.normalize()
    }

    override val resultDirectory: Path by lazy {
        if (!isLocalProvider) {
            throw InternalServerException("Access to result directory is impossible, because local provider is not enabled")
        }
        val absoluteOrRelativeResultDirectory = appConfig.local.resultDirectoryOrDefault
        if (absoluteOrRelativeResultDirectory.isAbsolute) {
            absoluteOrRelativeResultDirectory
        } else {
            filesDirectory.resolve(absoluteOrRelativeResultDirectory).toAbsolutePath()
        }.normalize()
    }

    override val filesDirectory: Path by lazy {
        if (!isLocalProvider) {
            throw InternalServerException("Access to files directory is impossible, because local provider is not enabled")
        }
        val absoluteOrRelativeFilesDirectory = appConfig.local.filesDirectoryOrDefault
        absoluteOrRelativeFilesDirectory.toAbsolutePath().normalize()
    }
    override val dataDirectory: Path by lazy {
        if (!isLocalProvider) {
            throw InternalServerException("Access to files directory is impossible, because local provider is not enabled")
        }
        val absoluteOrRelativeFilesDirectory = appConfig.local.dataDirectoryOrDefault
        absoluteOrRelativeFilesDirectory.toAbsolutePath().normalize()
    }

    override fun getDataDirectory(pathToCheck: String, signatureType: String): Path {
        val absoluteOrRelativeFilesDirectory = appConfig.local.dataDirectoryOrDefault
        val directory = SignatureDirectory.getPathFromSignatureType(signatureType)
        val dataPath = Paths.get(absoluteOrRelativeFilesDirectory.toAbsolutePath().toString() + directory)
        val isDir = Files.isDirectory(dataPath)
        if (!isDir) {
            createDataDirectory(dataPath)
        }
        return dataPath
    }

    override fun createDataDirectory(path: Path) {
        try {
             Files.createDirectories(path)
        } catch (ex: FileAlreadyExistsException) {
            // it is ok
        } catch (e: IOException) {
            logger.error(e.message)
        }
    }

    override fun createPathForTempFile(): Path = tempDirectory.resolve("gd_${UUID.randomUUID()}.tmp")

    override fun createPathForResultFile(sourceName: String, targetName: String, extension: String): Path {
        sourceName.matches(FILENAME_PATTERN) || throw InternalServerException("Source file name contains forbidden characters")
        targetName.matches(FILENAME_PATTERN) || throw InternalServerException("Target file name contains forbidden characters")

        val sourceNameWithoutExtension = File(sourceName).nameWithoutExtension
        val targetNameWithoutExtension = File(targetName).nameWithoutExtension

        val resultFileName = if (sourceNameWithoutExtension.length + targetNameWithoutExtension.length > MAX_FILENAME_LENGTH) {
            val halfOfFileNameLength = MAX_FILENAME_LENGTH / 2
            val trimmedSourceFileName = sourceNameWithoutExtension
                .substring(min(halfOfFileNameLength, sourceNameWithoutExtension.length))
            val trimmedTargetFileName = targetNameWithoutExtension
                .substring(min(halfOfFileNameLength, targetNameWithoutExtension.length))
            "result-${trimmedSourceFileName}-${trimmedTargetFileName}_${System.currentTimeMillis()}.$extension"
        } else "result-${sourceNameWithoutExtension}-${targetNameWithoutExtension}.$extension"

        return resultDirectory.resolve(resultFileName)
    }

    override fun assertPathIsInsideFilesDirectory(pathToCheck: String): Path {
        val checkPath = Paths.get(pathToCheck)
        val path = if (!checkPath.isAbsolute) {
            filesDirectory.resolve(pathToCheck).toAbsolutePath().normalize()
        } else checkPath.normalize()

        if (!path.startsWith(filesDirectory)) {
            // Avoid accessing to any directory outside filesDirectory
            throw AccessDeniedException()
        }
        return path
    }

    private companion object {
        val FILENAME_PATTERN = Pattern.compile("^[^</*?\"\\\\>:|]+\$").toRegex()
        const val MAX_FILENAME_LENGTH = 255 - 55 // 55 for extension, prefix and so on
    }
}

interface PathManager {
    val tempDirectory: Path
    val resultDirectory: Path
    val filesDirectory: Path
    val dataDirectory: Path
    fun createPathForTempFile(): Path
    fun assertPathIsInsideFilesDirectory(pathToCheck: String): Path
    fun createPathForResultFile(sourceName: String, targetName: String, extension: String): Path
    fun getDataDirectory(pathToCheck: String, signatureType : String): Path
    fun createDataDirectory(path: Path)

}

class AccessDeniedException(message: String = "Access denied!") : InternalServerException(message)