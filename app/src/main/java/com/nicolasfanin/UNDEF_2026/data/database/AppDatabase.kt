package com.nicolasfanin.UNDEF_2026.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.nicolasfanin.UNDEF_2026.data.database.model.ColorDao
import com.nicolasfanin.UNDEF_2026.data.database.model.ColorEntity

@Database(entities = [ColorEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun colorDao(): ColorDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}