package com.example.starwarscatalog.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.starwarscatalog.data.local.model.CharacterFavoriteData
import com.example.starwarscatalog.data.local.model.PlanetFavoriteData
import com.example.starwarscatalog.data.local.model.StarshipFavoriteData
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(
        entity = CharacterFavoriteData::class,
        onConflict = OnConflictStrategy.IGNORE
    )
    suspend fun addCharacterToFavorite(characterFavoriteData: CharacterFavoriteData)

    @Insert(
        entity = PlanetFavoriteData::class,
        onConflict = OnConflictStrategy.IGNORE
    )
    suspend fun addPlanetToFavorite(planetFavoriteData: PlanetFavoriteData)

    @Insert(
        entity = StarshipFavoriteData::class,
        onConflict = OnConflictStrategy.IGNORE
    )
    suspend fun addStarshipToFavorite(starshipFavoriteData: StarshipFavoriteData)

    @Delete(entity = CharacterFavoriteData::class)
    suspend fun deleteCharacterFromFavorite(characterFavoriteData: CharacterFavoriteData)

    @Delete(entity = PlanetFavoriteData::class)
    suspend fun deletePlanetFromFavorite(planetFavoriteData: PlanetFavoriteData)

    @Delete(entity = StarshipFavoriteData::class)
    suspend fun deleteStarshipFromFavorite(starshipFavoriteData: StarshipFavoriteData)

    @Query(value = "SELECT * FROM character")
    fun getCharacters(): Flow<List<CharacterFavoriteData>>

    @Query(value = "SELECT * FROM planet")
    fun getPlanets(): Flow<List<PlanetFavoriteData>>

    @Query(value = "SELECT * FROM starship")
    fun getStarships(): Flow<List<StarshipFavoriteData>>
}