package com.nicolasfanin.UNDEF_2026.ui.productlist.usecase

import com.nicolasfanin.UNDEF_2026.data.api.RetrofitClient
import com.nicolasfanin.UNDEF_2026.data.model.ColorListDto
import com.nicolasfanin.UNDEF_2026.ui.productlist.repository.ColorListRepository

class ColorUseCase(val colorListRepository: ColorListRepository = ColorListRepository(RetrofitClient.apiService)) {

    suspend fun invoke(): ColorListDto {
        return colorListRepository.getAllColors()
    }
}
