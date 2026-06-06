package com.nicolasfanin.UNDEF_2026.data.database.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColor(color: ColorEntity)

    @Query("SELECT * FROM colors")
    suspend fun getAllColors(): List<ColorEntity>

    @Delete
    suspend fun deleteColor(color: ColorEntity)
}
