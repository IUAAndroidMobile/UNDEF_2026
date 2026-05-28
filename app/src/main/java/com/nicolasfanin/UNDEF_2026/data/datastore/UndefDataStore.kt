package com.nicolasfanin.UNDEF_2026.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

const val UNDEF_2026_SETTINGS = "UNDEF_2026_SETTINGS"

val Context.undefDataStore: DataStore<Preferences> by preferencesDataStore(name = UNDEF_2026_SETTINGS)

object PreferencesKeys {
    val NOMBRE_USUARIO = stringPreferencesKey("nombre_usuario")
    val NOTIFICACIONES = booleanPreferencesKey("notificaciones")
    val PUNTUACION = intPreferencesKey("puntuacion")
}