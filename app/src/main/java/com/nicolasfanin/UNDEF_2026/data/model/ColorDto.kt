package com.nicolasfanin.UNDEF_2026.data.model

import com.google.gson.annotations.SerializedName

data class ColorListDto(
    val colores: List<ColorDto>
)

data class ColorDto(
    val id: Int,
    @SerializedName("nombre")
    val name: String,
    val hex: String,
    val rgb: RGBDto
)

data class RGBDto(
    val r: Int,
    val g: Int,
    val b: Int
)