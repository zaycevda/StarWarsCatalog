package com.example.starwarscatalog.data.remote.repository

import com.example.starwarscatalog.data.remote.model.CharacterData
import com.example.starwarscatalog.data.remote.model.PlanetData
import com.example.starwarscatalog.data.remote.model.StarWarsDataList
import com.example.starwarscatalog.data.remote.model.StarshipData
import com.example.starwarscatalog.data.util.StarWarsRoutes
import com.example.starwarscatalog.data.util.characterEntity
import com.example.starwarscatalog.data.util.planetEntity
import com.example.starwarscatalog.data.util.starshipEntity
import com.example.starwarscatalog.domain.model.CharacterEntity
import com.example.starwarscatalog.domain.model.PlanetEntity
import com.example.starwarscatalog.domain.model.StarshipEntity
import com.example.starwarscatalog.domain.repository.StarWarsRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class StarWarsRepositoryImpl(private val httpClient: HttpClient) : StarWarsRepository {
    override suspend fun getCharacterEntitiesFromApiByName(name: String): List<CharacterEntity> {
        val characterDataStarWarsDataList = try {
            httpClient
                .get(urlString = StarWarsRoutes.PEOPLE + name)
                .body<StarWarsDataList<CharacterData>>()
        } catch (e: Exception) {
            StarWarsDataList.empty()
        }

        return characterDataStarWarsDataList.results.map { characterData ->
            characterData.characterEntity
        }
    }

    override suspend fun getPlanetEntitiesFromApiByName(name: String): List<PlanetEntity> {
        val planetDataStarWarsDataList = try {
            httpClient
                .get(urlString = StarWarsRoutes.PLANET + name)
                .body<StarWarsDataList<PlanetData>>()
        } catch (e: Exception) {
            StarWarsDataList.empty()
        }

        return planetDataStarWarsDataList.results.map { planetData ->
            planetData.planetEntity
        }
    }

    override suspend fun getStarshipEntitiesFromApiByName(name: String): List<StarshipEntity> {
        val starshipDataStarWarsDataList = try {
            httpClient
                .get(urlString = StarWarsRoutes.STARSHIP + name)
                .body<StarWarsDataList<StarshipData>>()
        } catch (e: Exception) {
            StarWarsDataList.empty()
        }
        return starshipDataStarWarsDataList.results.map { starshipData ->
            starshipData.starshipEntity
        }
    }
}