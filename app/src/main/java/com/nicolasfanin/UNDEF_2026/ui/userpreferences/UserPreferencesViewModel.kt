package com.nicolasfanin.UNDEF_2026.ui.userpreferences

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.nicolasfanin.UNDEF_2026.domain.UserPreferencesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserPreferencesViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val userPreferencesRepository = UserPreferencesRepository(
        context = application.applicationContext
    )

    val nombreUsuarioFlow: StateFlow<String> = userPreferencesRepository.nombreUsuarioFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        ""
    )

    val notificacionesFlow: StateFlow<Boolean> = userPreferencesRepository.notificacionesFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        false
    )

    val puntuacionFlow = userPreferencesRepository.puntuacionFlow

    fun saveNombreUsuario(nombre: String) {
        viewModelScope.launch {
            userPreferencesRepository.guardarNombreUsuario(nombre)
        }
    }

    fun saveNotificaciones(habilitadas: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.guardarNotificaciones(habilitadas)
        }
    }

    suspend fun savePuntuacion(puntuacion: Int) {
        userPreferencesRepository.guardarPuntuacion(puntuacion)
    }
}
