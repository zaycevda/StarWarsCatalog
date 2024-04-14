package com.example.starwarscatalog.app.ui.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.starwarscatalog.app.ui.kit.CharacterItem
import com.example.starwarscatalog.app.ui.kit.PlanetItem
import com.example.starwarscatalog.app.ui.kit.StarshipItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = koinViewModel()) {
    var query by rememberSaveable {
        mutableStateOf(value = "")
    }
    val characterModels by viewModel.characterModels.collectAsStateWithLifecycle()
    val favoriteCharacterModels by viewModel.favoriteCharacterModels.collectAsStateWithLifecycle()
    val planetModels by viewModel.planetModels.collectAsStateWithLifecycle()
    val favoritePlanetModels by viewModel.favoritePlanetModels.collectAsStateWithLifecycle()
    val starshipModels by viewModel.starshipModels.collectAsStateWithLifecycle()
    val favoriteStarshipModels by viewModel.favoriteStarshipModels.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = query) {
        if (query.length >= 2) {
            viewModel.getCharactersModels(name = query)
            viewModel.getPlanetsModels(name = query)
            viewModel.getStarshipsModels(name = query)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = query,
            onValueChange = { newText ->
                query = newText
            },
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(
            modifier = Modifier.weight(
                weight = 1F
            ),
            contentPadding = PaddingValues(
                vertical = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp
            )
        ) {
            items(count = characterModels.count()) { characterIndex ->
                val characterModel = characterModels[characterIndex]
                val isFavorite = favoriteCharacterModels.contains(
                    element = characterModel
                )

                CharacterItem(
                    modifier = Modifier.padding(
                        horizontal = 16.dp
                    ),
                    characterModel = characterModel,
                    isFavorite = isFavorite,
                    onClick = {
                        viewModel.toggleCharacterFavoriteStatus(
                            characterModel = characterModel,
                            isFavorite = isFavorite
                        )
                    }
                )
            }
            items(count = starshipModels.count()) { starshipIndex ->
                val starshipModel = starshipModels[starshipIndex]
                val isFavorite = favoriteStarshipModels.contains(
                    element = starshipModel
                )

                StarshipItem(
                    modifier = Modifier.padding(
                        horizontal = 16.dp
                    ),
                    starshipModel = starshipModel,
                    isFavorite = isFavorite,
                    onClick = {
                        viewModel.toggleStarshipFavoriteStatus(
                            starshipModel = starshipModel,
                            isFavorite = isFavorite
                        )
                    }
                )
            }
            items(count = planetModels.count()) { planetIndex ->
                val planetModel = planetModels[planetIndex]
                val isFavorite = favoritePlanetModels.contains(
                    element = planetModel
                )

                PlanetItem(
                    modifier = Modifier.padding(
                        horizontal = 16.dp
                    ),
                    planetModel = planetModel,
                    isFavorite = isFavorite,
                    onClick = {
                        viewModel.togglePlanetFavoriteStatus(
                            planetModel = planetModel,
                            isFavorite = isFavorite
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}