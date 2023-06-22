package com.groupdocs.ui.result

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.groupdocs.signature.Signature
import com.groupdocs.signature.domain.Border
import com.groupdocs.signature.domain.Padding
import com.groupdocs.signature.domain.enums.DashStyle
import com.groupdocs.signature.domain.enums.HorizontalAlignment
import com.groupdocs.signature.domain.enums.VerticalAlignment
import com.groupdocs.signature.licensing.License
import com.groupdocs.signature.options.PageStreamFactory
import com.groupdocs.signature.options.PreviewFormats
import com.groupdocs.signature.options.PreviewOptions
import com.groupdocs.signature.options.sign.ImageSignOptions
import com.groupdocs.ui.common.NavigationException
import com.groupdocs.ui.common.Screen
import com.groupdocs.ui.common.Settings
import kotlinx.coroutines.*
import org.apache.commons.io.FileUtils
import java.awt.Color
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter
import kotlin.io.path.nameWithoutExtension


class ResultViewModel(private val screen: MutableState<Screen>) {
    private val _state: MutableState<ResultState> = mutableStateOf(ResultState())
    val state: State<ResultState> = _state
    private val tempDir: Path


    init {
        var resultPath = ""
        val sourcePath: String
        val targetPath: String
        val targetName: String
        tempDir = Paths.get(System.getenv("TMP"))
        if (screen.value is Screen.Result) {
            sourcePath = (screen.value as Screen.Result).source
            targetPath = (screen.value as Screen.Result).target
            targetName = Paths.get(sourcePath).fileName.nameWithoutExtension
        } else throw NavigationException()
        //
        val licensePath = Settings.instance.licensePath
        if (licensePath == null || Files.exists(Paths.get(licensePath))) {
            CoroutineScope(Dispatchers.IO).launch {
                licensePath?.let { License().setLicense(it) }
//                println("License is ${if (License.isValidLicense()) "valid" else "invalid"}")
                val resultDirectory = tempDir.resolve(UUID.randomUUID().toString())
                Files.createDirectories(resultDirectory)

                Signature(sourcePath).let { signature ->
                    try {
                        val fileName: String = Paths.get(sourcePath).fileName.toString()
                        val tmp0 = Padding()
                        tmp0.top = 120
                        tmp0.right = 120
                        val tmp1 = Border()
                        tmp1.visible = true
                        tmp1.color = Color.ORANGE
                        tmp1.dashStyle = DashStyle.DashDotDot
                        tmp1.weight = 5.0
                        val options = ImageSignOptions(targetPath)
                        options.left = 100
                        options.top = 100
                        options.width = 200
                        options.height = 100
                        options.verticalAlignment = VerticalAlignment.Top
                        options.horizontalAlignment = HorizontalAlignment.Center
                        options.margin = tmp0
                        options.rotationAngle = 45
                        options.border = tmp1
                        resultPath = tempDir.resolve("Result_$fileName").toString();
                        signature.sign(resultPath, options)
                    } catch (e: Exception) {
                        _state.value = _state.value.copy(
                            errorMessage = "Signing error: ${e.message}",
                            isInProgress = false
                        )
                        return@let
                    }
                }
                _state.value = _state.value.copy(
                    sourcePath = sourcePath,
                    targetPath = targetPath,
                    resultPath = resultPath
                )
                displayResult(resultPath)
            }
        } else {
            _state.value = _state.value.copy(
                errorMessage = "License not found: '$licensePath'",
                isInProgress = false
            )
        }

    }

    private fun displayResult(resultPath: String) {
        println("Signature result pages are saved to ${state.value.resultPath}")
        val pageList = mutableListOf<String>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = Signature(resultPath)
                val previewOptions = PreviewOptions(object :PageStreamFactory{
                    override fun createPageStream(p0: Int): OutputStream {
                        val pagePath = tempDir.resolve("gd_${System.currentTimeMillis()}_page_$p0.png")
                        pageList.add(pagePath.toString())
                        return FileOutputStream(pagePath.toFile())
                    }

                    override fun closePageStream(p0: Int, p1: OutputStream?) {
                        if (p1 != null) {
                            p1.close()
                        }
                    }
                })
                previewOptions.previewFormat = PreviewFormats.PNG


                result.generatePreview(previewOptions)
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    errorMessage = "Preview generating error: ${e.message}",
                    isInProgress = false
                )
                return@launch
            }
            _state.value = _state.value.copy(
                isInProgress = false,
                pageList = pageList
            )
        }
    }

    fun onDownload() {
        val resultName = state.value.resultName
        val extension =
            if (resultName.contains('.'))
                resultName.substring(resultName.lastIndexOf('.') + 1)
            else null
        JFileChooser().apply {
            extension?.let {
                fileFilter = FileNameExtensionFilter("Pdf file", extension)
            }
            selectedFile = File(resultName)
            if (showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                val resultPath = state.value.resultPath
                val downloadPath = selectedFile.path
                CoroutineScope(Dispatchers.IO).launch {
                    FileUtils.copyFile(File(resultPath), File(downloadPath))
                    withContext(Dispatchers.Main) {
                        _state.value = _state.value.copy(
                            infoMessage = "File was saved!"
                        )
                        delay(2500L)
                        _state.value = _state.value.copy(
                            infoMessage = null
                        )
                    }
                }
            }
        }
    }

    fun onDispose() {
        print("Deleting temporary files...")
        CoroutineScope(Dispatchers.IO).launch {
            state.value.pageList.toMutableList().apply {
                add(state.value.resultPath)
                forEach { path ->
                    try {
                        FileUtils.delete(File(path))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        println("Finished")
    }
}

