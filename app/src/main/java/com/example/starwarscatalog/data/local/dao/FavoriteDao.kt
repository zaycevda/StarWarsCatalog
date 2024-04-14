package com.example.starwarscatalog.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.starwarscatalog.data.local.model.CharacterFavoriteData
import com.example.starwarscatalog.data.local.model.StarshipFavoriteData
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(entity = CharacterFavoriteData::class)
    suspend fun addCharacterToFavorite(characterFavoriteData: CharacterFavoriteData)

    @Insert(entity = StarshipFavoriteData::class)
    suspend fun addStarshipToFavorite(starshipFavoriteData: StarshipFavoriteData)

    @Delete(entity = CharacterFavoriteData::class)
    suspend fun deleteCharacterFromFavorite(characterFavoriteData: CharacterFavoriteData)

    @Delete(entity = StarshipFavoriteData::class)
    suspend fun deleteStarshipFromFavorite(starshipFavoriteData: StarshipFavoriteData)

    @Query(value = "SELECT * FROM character")
    fun getCharacters(): Flow<List<CharacterFavoriteData>>

    @Query(value = "SELECT * FROM starship")
    fun getStarships(): Flow<List<StarshipFavoriteData>>
}