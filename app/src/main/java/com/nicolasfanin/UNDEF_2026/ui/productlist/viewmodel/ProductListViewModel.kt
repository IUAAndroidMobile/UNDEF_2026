package com.nicolasfanin.UNDEF_2026.ui.productlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicolasfanin.UNDEF_2026.ui.productlist.usecase.ProductListUseCase
import com.nicolasfanin.UNDEF_2026.utils.ScreenData
import com.nicolasfanin.UNDEF_2026.utils.UndefUiStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductListViewModel(
    private val productListUseCase: ProductListUseCase = ProductListUseCase()
) : ViewModel() {

    private val _screenState = MutableStateFlow<UndefUiStates>(UndefUiStates.Loading)
    val screenState : StateFlow<UndefUiStates> = _screenState

    fun getProductListScreenInfo() {
        viewModelScope.launch {
            _screenState.emit(UndefUiStates.Loading)

            // Simulamos una llamada a un servicio
            delay(3000)
            productListUseCase.getProductList()
            if (_screenState.value == UndefUiStates.Loading) {
                _screenState.emit(
                    UndefUiStates.Success(
                        screenData = ScreenData(
                            title = "Hola Mundo!",
                            subtitle = "Bienvenido!!!"
                        )
                    )
                )
            }

            delay(9000)

            _screenState.emit(
                UndefUiStates.Error("Error en el servicio")
            )
        }
    }

}