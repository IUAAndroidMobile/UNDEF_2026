package com.nicolasfanin.UNDEF_2026.presentacion.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicolasfanin.UNDEF_2026.utils.ScreenData
import com.nicolasfanin.UNDEF_2026.utils.UndefUiStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductListViewModel() : ViewModel() {

    private val _screenState = MutableStateFlow<UndefUiStates>(UndefUiStates.Loading)
    val screenState = _screenState

    fun getProductListScreenInfo() {
        viewModelScope.launch {
            delay(3000)
            _screenState.emit(
                UndefUiStates.Success(
                    screenData = ScreenData(
                        title = "Hola Mundo!",
                        subtitle = "Bienvenido!!!"
                    )
                )
            )

            delay(9000)
            _screenState.emit(
                UndefUiStates.Error
            )
        }
    }

}
