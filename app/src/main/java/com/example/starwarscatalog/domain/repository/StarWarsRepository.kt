package com.example.starwarscatalog.domain.repository

import com.example.starwarscatalog.domain.model.CharacterEntity
import com.example.starwarscatalog.domain.model.StarshipEntity

interface StarWarsRepository {
    suspend fun getCharacterEntitiesFromApiByName(name: String): List<CharacterEntity>

    suspend fun getStarshipEntitiesFromApiByName(name: String): List<StarshipEntity>
}