package com.example.starwarscatalog.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.starwarscatalog.data.local.dao.FavoriteDao
import com.example.starwarscatalog.data.local.model.CharacterFavoriteData
import com.example.starwarscatalog.data.local.model.StarshipFavoriteData

@Database(
    entities = [
        CharacterFavoriteData::class,
        StarshipFavoriteData::class
    ],
    version = 1,
    exportSchema = false
)
abstract class StarWarsCatalogDatabase : RoomDatabase() {
    abstract val favoriteDao: FavoriteDao
}