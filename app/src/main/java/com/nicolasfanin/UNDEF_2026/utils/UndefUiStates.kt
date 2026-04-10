package com.nicolasfanin.UNDEF_2026.utils

sealed class UndefUiStates {
    object Loading : UndefUiStates()

    data class Success(
        val screenData: ScreenData
    ) : UndefUiStates()

    object Error : UndefUiStates()
}

data class ScreenData(
    val title: String,
    val subtitle: String
)