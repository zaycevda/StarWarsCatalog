package com.example.starwarscatalog.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.starwarscatalog.app.ui.kit.navigation_bar.StarWarsCatalogNavigationBar
import com.example.starwarscatalog.app.ui.screen.favorite.FavoriteScreen
import com.example.starwarscatalog.app.ui.screen.main.MainScreen

@Composable
fun StarWarsCatalogNavigation(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            StarWarsCatalogNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Routes.MAIN.name,
            modifier = Modifier.padding(
                paddingValues = paddingValues
            )
        ) {
            composable(route = Routes.MAIN.name) { _ ->
                MainScreen()
            }
            composable(route = Routes.FAVORITE.name) { _ ->
                FavoriteScreen()
            }
        }
    }
}