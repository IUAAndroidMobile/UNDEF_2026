package com.nicolasfanin.UNDEF_2026.ui.savedcolors

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicolasfanin.UNDEF_2026.data.database.AppDatabase
import com.nicolasfanin.UNDEF_2026.data.database.model.ColorEntity
import com.nicolasfanin.UNDEF_2026.domain.ColorRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class SavedColorsViewModel(
    application: Application,
) : AndroidViewModel(application) {

    private val colorRepository = ColorRepository(AppDatabase.getInstance(application).colorDao())

    /**var colors: StateFlow<List<ColorEntity>> = colorRepository.getAllColors().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )**/

    fun getAllColors() {
        viewModelScope.launch {
            colorRepository.getAllColors()
        }
    }

    fun insertColor(color: ColorEntity) {
        viewModelScope.launch {
            colorRepository.insertColor(color)
        }
    }

}