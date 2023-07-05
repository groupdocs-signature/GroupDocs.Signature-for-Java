package com.groupdocs.ui.common

class NavigationException(message: String = "") : RuntimeException(message)

sealed class Screen {
    object Home : Screen()
    data class Result(val source: String, val target: String) : Screen()
    object Settings : Screen()
}