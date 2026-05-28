package com.nicolasfanin.UNDEF_2026.domain

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.nicolasfanin.UNDEF_2026.data.datastore.PreferencesKeys
import com.nicolasfanin.UNDEF_2026.data.datastore.undefDataStore
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(
    private val context: Context
) {
        val nombreUsuarioFlow = context.undefDataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.NOMBRE_USUARIO] ?: ""
            }

        val notificacionesFlow = context.undefDataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.NOTIFICACIONES] ?: false
            }

        val puntuacionFlow = context.undefDataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.PUNTUACION] ?: 0
            }

        suspend fun guardarNombreUsuario(nombre: String) {
            context.undefDataStore.edit { preferences ->
                preferences[PreferencesKeys.NOMBRE_USUARIO] = nombre
            }
        }

        suspend fun guardarNotificaciones(habilitadas: Boolean) {
            context.undefDataStore.edit { preferences ->
                preferences[PreferencesKeys.NOTIFICACIONES] = habilitadas
            }
        }

        suspend fun guardarPuntuacion(puntuacion: Int) {
            context.undefDataStore.edit { preferences ->
                preferences[PreferencesKeys.PUNTUACION] = puntuacion
            }
        }
}
