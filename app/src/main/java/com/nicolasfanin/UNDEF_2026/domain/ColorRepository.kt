package com.nicolasfanin.UNDEF_2026.domain

import com.nicolasfanin.UNDEF_2026.data.database.model.ColorDao
import com.nicolasfanin.UNDEF_2026.data.database.model.ColorEntity

class ColorRepository(private val colorDao: ColorDao) {

    suspend fun getAllColors() = colorDao.getAllColors()

    suspend fun insertColor(color: ColorEntity) = colorDao.insertColor(color)

}
