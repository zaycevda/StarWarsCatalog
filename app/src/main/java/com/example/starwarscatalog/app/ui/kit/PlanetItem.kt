package com.example.starwarscatalog.app.ui.kit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.starwarscatalog.R
import com.example.starwarscatalog.app.model.PlanetModel

@Composable
fun PlanetItem(
    modifier: Modifier = Modifier,
    planetModel: PlanetModel,
    isFavorite: Boolean,
    onClick: () -> Unit
) {
    val characterItemShape = RoundedCornerShape(
        size = 16.dp
    )
    val favoriteIcon = if (isFavorite) {
        Icons.Default.Favorite
    } else {
        Icons.Default.FavoriteBorder
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val textPadding = Modifier.padding(
        top = 4.dp
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.LightGray,
                shape = characterItemShape
            )
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = characterItemShape
            )
            .padding(all = 8.dp)
    ) {
        Icon(
            imageVector = favoriteIcon,
            contentDescription = null,
            modifier = Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
            tint = Color.Red
        )
        Text(
            text = stringResource(
                id = R.string.planet
            ),
            modifier = textPadding,
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.Blue
            )
        )
        Text(
            text = stringResource(
                id = R.string.name,
                planetModel.name
            ),
            modifier = textPadding,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
        Text(
            text = stringResource(
                id = R.string.diameter,
                planetModel.diameter
            ),
            modifier = textPadding,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
        Text(
            text = stringResource(
                id = R.string.population,
                planetModel.population
            ),
            modifier = textPadding,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PlanetItemPreview() {
    val planetModel = PlanetModel(
        name = "Tatooine",
        diameter = "10465",
        population = "120000"
    )
    var isFavorite by remember {
        mutableStateOf(value = false)
    }

    PlanetItem(
        planetModel = planetModel,
        isFavorite = isFavorite,
        onClick = {
            isFavorite = !isFavorite
        }
    )
}