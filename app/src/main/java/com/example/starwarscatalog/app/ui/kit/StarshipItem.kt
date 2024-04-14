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
import com.example.starwarscatalog.app.model.StarshipModel

@Composable
fun StarshipItem(
    modifier: Modifier = Modifier,
    starshipModel: StarshipModel,
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
                id = R.string.starship
            ),
            modifier = textPadding,
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.Blue
            )
        )
        Text(
            text = stringResource(
                id = R.string.name,
                starshipModel.name
            ),
            modifier = textPadding,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
        Text(
            text = stringResource(
                id = R.string.model,
                starshipModel.model
            ),
            modifier = textPadding,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
        Text(
            text = stringResource(
                id = R.string.manufacturer,
                starshipModel.manufacturer
            ),
            modifier = textPadding,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
        Text(
            text = stringResource(
                id = R.string.passengers,
                starshipModel.passengers
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
private fun StarshipItemPreview() {
    val starshipModel = StarshipModel(
        name = "Death Star",
        model = "DS-1 Orbital Battle Station",
        manufacturer = "Imperial Department of Military Research, Sienar Fleet Systems",
        passengers = "843342"
    )
    var isFavorite by remember {
        mutableStateOf(value = false)
    }

    StarshipItem(
        starshipModel = starshipModel,
        isFavorite = isFavorite,
        onClick = {
            isFavorite = !isFavorite
        }
    )
}