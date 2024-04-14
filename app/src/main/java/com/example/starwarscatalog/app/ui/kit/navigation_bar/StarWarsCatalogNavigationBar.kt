package com.example.starwarscatalog.app.ui.kit.navigation_bar

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.starwarscatalog.app.navigation.navigationBarItems

@Composable
fun StarWarsCatalogNavigationBar(navController: NavController) {
    NavigationBar {
        navigationBarItems.forEach { navigationBarItem ->
            StarWarsCatalogNavigationBarItem(
                navController = navController,
                navigationBarItem = navigationBarItem
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StarWarsCatalogNavigationBarPreview() {
    StarWarsCatalogNavigationBar(navController = rememberNavController())
}