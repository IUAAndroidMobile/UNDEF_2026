package com.nicolasfanin.UNDEF_2026.ui.productlist.usecase

class ProductListUseCase() {

    suspend fun getProductList(): List<String> {
        return listOf("1","2","3","4","5","6","7","8","9","10")

    }
}
