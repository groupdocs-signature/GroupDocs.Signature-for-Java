package com.groupdocs.ui.result

import java.nio.file.Paths

data class ResultState(
    val isInProgress: Boolean = true,
    val errorMessage: String? = null,
    val infoMessage: String? = null,
    val sourcePath: String = "",
    val targetPath: String = "",
    val resultPath: String = "",
    val pagesCount: Int = 1,
    val pageList: List<String> = emptyList()
) {
    val resultName: String get() = Paths.get(resultPath).fileName.toString()
}

