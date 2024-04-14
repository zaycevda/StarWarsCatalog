package com.example.starwarscatalog.app.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarscatalog.app.model.CharacterModel
import com.example.starwarscatalog.app.model.StarshipModel
import com.example.starwarscatalog.app.util.characterEntity
import com.example.starwarscatalog.app.util.characterModel
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
    private val _favoriteStarshipModels = MutableStateFlow<List<StarshipModel>>(
        value = emptyList()
    )
    val favoriteStarshipModels = _favoriteStarshipModels.asStateFlow()

    init {
        getFavoritesCharactersModels()
        getFavoritesStarshipsModels()
    }

    private fun addCharacterToFavorite(characterModel: CharacterModel) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val characterEntity = characterModel.characterEntity
            favoriteRepository.addCharacterToFavorite(characterEntity = characterEntity)
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