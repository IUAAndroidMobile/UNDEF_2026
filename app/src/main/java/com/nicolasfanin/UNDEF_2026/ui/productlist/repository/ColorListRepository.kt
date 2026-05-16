package com.nicolasfanin.UNDEF_2026.ui.productlist.repository

import com.nicolasfanin.UNDEF_2026.data.api.ApiService
import com.nicolasfanin.UNDEF_2026.data.api.RetrofitClient.apiService
import com.nicolasfanin.UNDEF_2026.data.model.ColorListDto

class ColorListRepository(apiService: ApiService) {

    suspend fun getAllColors(): ColorListDto {
        return apiService.getAllColors()
    }
}
