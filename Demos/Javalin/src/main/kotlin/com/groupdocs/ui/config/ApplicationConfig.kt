package com.groupdocs.ui.config

import com.groupdocs.ui.Defaults
import java.nio.file.Path
import java.nio.file.Paths

@kotlinx.serialization.Serializable
data class ApplicationConfig(
    val server: Server = Server(),
    val common: Common = Common(),
    val signature: Signature = Signature(),
    val local: Local = Local(),
    private val licensePath: String = ""
) {
    val licensePathOrDefault: String
        get() = licensePath.ifBlank { Defaults.DEFAULT_LICENSE_PATH }
}

@kotlinx.serialization.Serializable
data class Server(
    val host: String = "0.0.0.0",
    val port: Int = 9090
)

@kotlinx.serialization.Serializable
data class Common(
    val pageSelector: Boolean = false,
    val download: Boolean = false,
    val upload: Boolean = false,
    val print: Boolean = false,
    val browse: Boolean = false,
    val rewrite: Boolean = false,
    val enableRightClick: Boolean = false
)

@kotlinx.serialization.Serializable
data class Signature(
    private val filesProviderType: String = "",
    val preloadResultPageCount: Int = 0,
    private val previewPageWidth: Int = 0,
    private val previewPageRatio: Float = 0f,
    private val tempDirectory: String = "",
) {
    val filesProviderTypeOrDefault: Defaults.Signature.FilesProviderType
        get() =
            when (filesProviderType.uppercase()) {
                in Defaults.Signature.FilesProviderType.values()
                    .map { it.name.uppercase() } -> Defaults.Signature.FilesProviderType.valueOf(filesProviderType.uppercase())
                else -> Defaults.Signature.DEFAULT_FILES_PROVIDER_TYPE
            }
    val tempDirectoryOrDefault: String
        get() = tempDirectory.ifBlank { Defaults.Signature.DEFAULT_TEMP_DIRECTORY }
            ?: throw IllegalStateException("Can't get temp directory!")
    val previewPageWidthOrDefault: Int
        get() = if (previewPageWidth == 0) Defaults.Signature.DEFAULT_PREVIEW_PAGE_WIDTH else previewPageWidth
    val previewPageRatioOrDefault: Float
        get() = if (previewPageRatio == 0f) Defaults.Signature.DEFAULT_PREVIEW_PAGE_RATIO else previewPageRatio
}

@kotlinx.serialization.Serializable
data class Local(
    private val filesDirectory: String = "",
    private val dataDirectory: String = "",
    private val resultDirectory: String = "",
) {

    val filesDirectoryOrDefault: Path
        get() = Paths.get(filesDirectory.ifBlank { Defaults.Local.DEFAULT_FILES_DIRECTORY })

    val resultDirectoryOrDefault: Path
        get() = Paths.get(resultDirectory.ifBlank { Defaults.Local.DEFAULT_RESULT_DIRECTORY })

    val dataDirectoryOrDefault: Path
        get() = Paths.get(dataDirectory.ifBlank { Defaults.Local.DEFAULT_DATA_DIRECTORY })
}