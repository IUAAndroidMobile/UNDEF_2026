package com.nicolasfanin.UNDEF_2026.utils

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale

fun String.capitalizeWordsUNDEF(): String {
    return this.capitalize(Locale.current)
}

/**
 * Funcion de extension que agrega numeros a un string.
 */
fun String.agregarNumeros(): String {
    return this + " 1234567890 "
}