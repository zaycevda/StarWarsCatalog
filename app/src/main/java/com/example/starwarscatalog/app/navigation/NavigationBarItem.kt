package com.example.starwarscatalog.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val navigationBarItems = listOf(
    NavigationBarItem(
        label = "Home",
        icon = Icons.Default.Home,
        route = Routes.MAIN.name
    ),
    NavigationBarItem(
        label = "Favorite",
        icon = Icons.Default.Favorite,
        route = Routes.FAVORITE.name
    )
)