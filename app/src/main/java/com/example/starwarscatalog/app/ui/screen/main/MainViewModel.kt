package com.example.starwarscatalog.app.ui.screen.main

import androidx.lifecycle.viewModelScope
import com.example.starwarscatalog.app.model.CharacterModel
import com.example.starwarscatalog.app.model.PlanetModel
import com.example.starwarscatalog.app.model.StarshipModel
import com.example.starwarscatalog.app.ui.screen.favorite.FavoriteViewModel
import com.example.starwarscatalog.app.util.characterModel
import com.example.starwarscatalog.app.util.planetModel
import com.example.starwarscatalog.app.util.starshipModel
import com.example.starwarscatalog.domain.repository.FavoriteRepository
import com.example.starwarscatalog.domain.repository.StarWarsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val starWarsRepository: StarWarsRepository,
    favoriteRepository: FavoriteRepository
) : FavoriteViewModel(favoriteRepository = favoriteRepository) {
    private val _characterModels = MutableStateFlow<List<CharacterModel>>(
        value = emptyList()
    )
    val characterModels = _characterModels.asStateFlow()
    private val _planetModels = MutableStateFlow<List<PlanetModel>>(
        value = emptyList()
    )
    val planetModels = _planetModels.asStateFlow()
    private val _starshipModels = MutableStateFlow<List<StarshipModel>>(
        value = emptyList()
    )
    val starshipModels = _starshipModels.asStateFlow()

    fun getCharactersModels(name: String) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val characterEntities = starWarsRepository.getCharacterEntitiesFromApiByName(
                name = name
            )
            val characterModels = characterEntities.map { characterEntity ->
                characterEntity.characterModel
            }
            _characterModels.value = characterModels
        }
    }

    fun getPlanetsModels(name: String) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val planetEntities = starWarsRepository.getPlanetEntitiesFromApiByName(
                name = name
            )
            val planetModels = planetEntities.map { planetEntity ->
                planetEntity.planetModel
            }
            _planetModels.value = planetModels
        }
    }

    fun getStarshipsModels(name: String) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val starshipEntities = starWarsRepository.getStarshipEntitiesFromApiByName(
                name = name
            )
            val starshipModels = starshipEntities.map { starshipEntity ->
                starshipEntity.starshipModel
            }
            _starshipModels.value = starshipModels
        }
    }
}