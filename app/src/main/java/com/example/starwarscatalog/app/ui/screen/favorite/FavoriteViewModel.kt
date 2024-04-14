package com.example.starwarscatalog.app.ui.screen.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarscatalog.app.model.CharacterModel
import com.example.starwarscatalog.app.model.PlanetModel
import com.example.starwarscatalog.app.model.StarshipModel
import com.example.starwarscatalog.app.util.characterEntity
import com.example.starwarscatalog.app.util.characterModel
import com.example.starwarscatalog.app.util.planetEntity
import com.example.starwarscatalog.app.util.planetModel
import com.example.starwarscatalog.app.util.starshipEntity
import com.example.starwarscatalog.app.util.starshipModel
import com.example.starwarscatalog.domain.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

open class FavoriteViewModel(private val favoriteRepository: FavoriteRepository) : ViewModel() {
    private val _favoriteCharacterModels = MutableStateFlow<List<CharacterModel>>(
        value = emptyList()
    )
    val favoriteCharacterModels = _favoriteCharacterModels.asStateFlow()
    private val _favoritePlanetModels = MutableStateFlow<List<PlanetModel>>(
        value = emptyList()
    )
    val favoritePlanetModels = _favoritePlanetModels.asStateFlow()
    private val _favoriteStarshipModels = MutableStateFlow<List<StarshipModel>>(
        value = emptyList()
    )
    val favoriteStarshipModels = _favoriteStarshipModels.asStateFlow()

    init {
        getFavoritesCharactersModels()
        getFavoritesPlanetsModels()
        getFavoritesStarshipsModels()
    }

    private fun addCharacterToFavorite(characterModel: CharacterModel) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val characterEntity = characterModel.characterEntity
            favoriteRepository.addCharacterToFavorite(characterEntity = characterEntity)
        }
    }

    private fun addPlanetToFavorite(planetModel: PlanetModel) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val planetEntity = planetModel.planetEntity
            favoriteRepository.addPlanetToFavorite(planetEntity = planetEntity)
        }
    }

    private fun addStarshipToFavorite(starshipModel: StarshipModel) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val starshipEntity = starshipModel.starshipEntity
            favoriteRepository.addStarshipToFavorite(starshipEntity = starshipEntity)
        }
    }

    private fun deleteCharacterFromFavorite(characterModel: CharacterModel) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val characterEntity = characterModel.characterEntity
            favoriteRepository.deleteCharacterFromFavorite(characterEntity = characterEntity)
        }
    }

    private fun deletePlanetFromFavorite(planetModel: PlanetModel) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val planetEntity = planetModel.planetEntity
            favoriteRepository.deletePlanetFromFavorite(planetEntity = planetEntity)
        }
    }

    private fun deleteStarshipFromFavorite(starshipModel: StarshipModel) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val starshipEntity = starshipModel.starshipEntity
            favoriteRepository.deleteStarshipFromFavorite(starshipEntity = starshipEntity)
        }
    }

    private fun getFavoritesCharactersModels() {
        viewModelScope.launch(context = Dispatchers.IO) {
            favoriteRepository.getCharacterEntitiesFlowFromFavorite().collect { characterEntities ->
                val characterModels = characterEntities.map { characterEntity ->
                    characterEntity.characterModel
                }
                _favoriteCharacterModels.value = characterModels
            }
        }
    }

    private fun getFavoritesPlanetsModels() {
        viewModelScope.launch(context = Dispatchers.IO) {
            favoriteRepository.getPlanetEntitiesFlowFromFavorite().collect { planetEntities ->
                val planetModels = planetEntities.map { planetEntity ->
                    planetEntity.planetModel
                }
                _favoritePlanetModels.value = planetModels
            }
        }
    }

    private fun getFavoritesStarshipsModels() {
        viewModelScope.launch(context = Dispatchers.IO) {
            favoriteRepository.getStarshipEntitiesFlowFromFavorite().collect { starshipEntities ->
                val starshipModels = starshipEntities.map { starshipEntity ->
                    starshipEntity.starshipModel
                }
                _favoriteStarshipModels.value = starshipModels
            }
        }
    }

    fun toggleCharacterFavoriteStatus(
        characterModel: CharacterModel,
        isFavorite: Boolean
    ) {
        if (isFavorite) {
            deleteCharacterFromFavorite(characterModel = characterModel)
        } else {
            addCharacterToFavorite(characterModel = characterModel)
        }
    }

    fun togglePlanetFavoriteStatus(
        planetModel: PlanetModel,
        isFavorite: Boolean
    ) {
        Log.d("bebra", "isFavorite = $isFavorite")
        if (isFavorite) {
            deletePlanetFromFavorite(planetModel = planetModel)
        } else {
            addPlanetToFavorite(planetModel = planetModel)
        }
    }

    fun toggleStarshipFavoriteStatus(
        starshipModel: StarshipModel,
        isFavorite: Boolean
    ) {
        if (isFavorite) {
            deleteStarshipFromFavorite(starshipModel = starshipModel)
        } else {
            addStarshipToFavorite(starshipModel = starshipModel)
        }
    }
}