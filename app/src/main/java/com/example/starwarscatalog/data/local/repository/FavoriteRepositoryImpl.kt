package com.example.starwarscatalog.data.local.repository

import com.example.starwarscatalog.data.local.database.StarWarsCatalogDatabase
import com.example.starwarscatalog.data.util.characterEntity
import com.example.starwarscatalog.data.util.characterFavoriteData
import com.example.starwarscatalog.data.util.planetEntity
import com.example.starwarscatalog.data.util.planetFavoriteData
import com.example.starwarscatalog.data.util.starshipEntity
import com.example.starwarscatalog.data.util.starshipFavoriteData
import com.example.starwarscatalog.domain.model.CharacterEntity
import com.example.starwarscatalog.domain.model.PlanetEntity
import com.example.starwarscatalog.domain.model.StarshipEntity
import com.example.starwarscatalog.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepositoryImpl(starWarsCatalogDatabase: StarWarsCatalogDatabase) : FavoriteRepository {
    private val favoriteDao = starWarsCatalogDatabase.favoriteDao

    override suspend fun addCharacterToFavorite(characterEntity: CharacterEntity) {
        val characterFavoriteData = characterEntity.characterFavoriteData
        favoriteDao.addCharacterToFavorite(characterFavoriteData = characterFavoriteData)
    }

    override suspend fun addPlanetToFavorite(planetEntity: PlanetEntity) {
        val planetFavoriteData = planetEntity.planetFavoriteData
        favoriteDao.addPlanetToFavorite(planetFavoriteData = planetFavoriteData)
    }

    override suspend fun addStarshipToFavorite(starshipEntity: StarshipEntity) {
        val starshipFavoriteData = starshipEntity.starshipFavoriteData
        favoriteDao.addStarshipToFavorite(starshipFavoriteData = starshipFavoriteData)
    }

    override suspend fun deleteCharacterFromFavorite(characterEntity: CharacterEntity) {
        val characterFavoriteData = characterEntity.characterFavoriteData
        favoriteDao.deleteCharacterFromFavorite(characterFavoriteData = characterFavoriteData)
    }

    override suspend fun deletePlanetFromFavorite(planetEntity: PlanetEntity) {
        val planetFavoriteData = planetEntity.planetFavoriteData
        favoriteDao.deletePlanetFromFavorite(planetFavoriteData = planetFavoriteData)
    }

    override suspend fun deleteStarshipFromFavorite(starshipEntity: StarshipEntity) {
        val starshipFavoriteData = starshipEntity.starshipFavoriteData
        favoriteDao.deleteStarshipFromFavorite(starshipFavoriteData = starshipFavoriteData)
    }

    override fun getCharacterEntitiesFlowFromFavorite(): Flow<List<CharacterEntity>> {
        val flowCharacterFavoriteDataList = favoriteDao.getCharacters()
        return flowCharacterFavoriteDataList.map { characterFavoriteDataList ->
            characterFavoriteDataList.map { characterFavoriteData ->
                characterFavoriteData.characterEntity
            }
        }
    }

    override fun getPlanetEntitiesFlowFromFavorite(): Flow<List<PlanetEntity>> {
        val flowPlanetFavoriteDataList = favoriteDao.getPlanets()
        return flowPlanetFavoriteDataList.map { planetFavoriteDataList ->
            planetFavoriteDataList.map { planetFavoriteData ->
                planetFavoriteData.planetEntity
            }
        }
    }

    override fun getStarshipEntitiesFlowFromFavorite(): Flow<List<StarshipEntity>> {
        val flowStarshipFavoriteDataList = favoriteDao.getStarships()
        return flowStarshipFavoriteDataList.map { starshipFavoriteDataList ->
            starshipFavoriteDataList.map { starshipFavoriteData ->
                starshipFavoriteData.starshipEntity
            }
        }
    }
}