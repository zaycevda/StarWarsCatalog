package com.example.starwarscatalog.domain.repository

import com.example.starwarscatalog.domain.model.CharacterEntity
import com.example.starwarscatalog.domain.model.StarshipEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun addCharacterToFavorite(characterEntity: CharacterEntity)

    suspend fun addStarshipToFavorite(starshipEntity: StarshipEntity)

    suspend fun deleteCharacterFromFavorite(characterEntity: CharacterEntity)

    suspend fun deleteStarshipFromFavorite(starshipEntity: StarshipEntity)

    fun getCharacterEntitiesFlowFromFavorite(): Flow<List<CharacterEntity>>

    fun getStarshipEntitiesFlowFromFavorite(): Flow<List<StarshipEntity>>
}