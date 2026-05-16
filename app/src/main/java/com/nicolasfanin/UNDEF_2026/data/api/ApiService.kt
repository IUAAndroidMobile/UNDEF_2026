package com.nicolasfanin.UNDEF_2026.data.api

import com.nicolasfanin.UNDEF_2026.data.model.ColorDto
import com.nicolasfanin.UNDEF_2026.data.model.ColorListDto
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    //@GET("https://mocki.io/v1/ab090668-5e58-4183-806b-b767f3b6f2c4")
    @GET("v1/ab090668-5e58-4183-806b-b767f3b6f2c4")
    suspend fun getAllColors() : ColorListDto

    //@GET("https://mocki.io/v1/ab090668-5e58-4183-806b-b767f3b6f2c4")
    @POST("v1/ab090668-5e58-4183-806b-b767f3b6f2c4/{colorDto}")
    suspend fun setNewColor(colorDto: ColorDto) : Boolean
}
