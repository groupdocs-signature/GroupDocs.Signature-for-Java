package com.groupdocs.ui.usecase

import com.groupdocs.signature.Signature
import com.groupdocs.signature.options.loadoptions.LoadOptions
import com.groupdocs.signature.options.sign.TextSignOptions
import com.groupdocs.ui.util.InternalServerException
import io.micronaut.context.annotation.Bean
import java.io.OutputStream
import java.nio.file.Path

@Bean
class SignatureDocumentsUseCase {
    operator fun invoke(
        sourcePath: Path,
        targetPath: Path,
        sourcePassword: String? = null,
        targetPassword: String? = null,
        outputStream: OutputStream
    ) {
        try {
            val loadOption = LoadOptions()
            loadOption.password = sourcePassword
            Signature(sourcePath.toAbsolutePath().toString(), loadOption).let { signature ->
                signature.apply {

                    sign(outputStream, TextSignOptions().apply {

                    })
                }
            }

        } catch (e: Exception) {
            throw CompareDocumentsException("Can't compare document ${sourcePath.fileName} with ${targetPath.fileName}", e)
        }
    }
}

class CompareDocumentsException(message: String, e: Throwable? = null) : InternalServerException(message, e)