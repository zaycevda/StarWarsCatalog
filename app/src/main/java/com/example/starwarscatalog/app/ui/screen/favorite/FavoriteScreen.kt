package com.example.starwarscatalog.app.ui.screen.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.starwarscatalog.app.ui.kit.CharacterItem
import com.example.starwarscatalog.app.ui.kit.PlanetItem
import com.example.starwarscatalog.app.ui.kit.StarshipItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteScreen(viewModel: FavoriteViewModel = koinViewModel()) {
    val favoriteCharacterModels by viewModel.favoriteCharacterModels.collectAsStateWithLifecycle()
    val favoritePlanetModels by viewModel.favoritePlanetModels.collectAsStateWithLifecycle()
    val favoriteStarshipModels by viewModel.favoriteStarshipModels.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            vertical = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(
            space = 8.dp
        )
    ) {
        items(count = favoriteCharacterModels.count()) { characterIndex ->
            val characterModel = favoriteCharacterModels[characterIndex]

            CharacterItem(
                modifier = Modifier.padding(
                    horizontal = 16.dp
                ),
                characterModel = characterModel,
                isFavorite = true,
                onClick = {
                    viewModel.toggleCharacterFavoriteStatus(
                        characterModel = characterModel,
                        isFavorite = true
                    )
                }
            )
        }
        items(count = favoriteStarshipModels.count()) { starshipIndex ->
            val starshipModel = favoriteStarshipModels[starshipIndex]

            StarshipItem(
                modifier = Modifier.padding(
                    horizontal = 16.dp
                ),
                starshipModel = starshipModel,
                isFavorite = true,
                onClick = {
                    viewModel.toggleStarshipFavoriteStatus(
                        starshipModel = starshipModel,
                        isFavorite = true
                    )
                }
            )
        }
        items(count = favoritePlanetModels.count()) { planetIndex ->
            val planetModel = favoritePlanetModels[planetIndex]

            PlanetItem(
                modifier = Modifier.padding(
                    horizontal = 16.dp
                ),
                planetModel = planetModel,
                isFavorite = true,
                onClick = {
                    viewModel.togglePlanetFavoriteStatus(
                        planetModel = planetModel,
                        isFavorite = true
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FavoriteScreenPreview() {
    FavoriteScreen()
}