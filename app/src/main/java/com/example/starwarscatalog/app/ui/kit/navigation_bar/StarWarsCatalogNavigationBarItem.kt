package com.example.starwarscatalog.app.ui.kit.navigation_bar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.starwarscatalog.app.navigation.NavigationBarItem
import com.example.starwarscatalog.app.navigation.Routes

@Composable
fun RowScope.StarWarsCatalogNavigationBarItem(
    navController: NavController,
    navigationBarItem: NavigationBarItem
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any { navDestination ->
            navDestination.route == navigationBarItem.route
        } == true,
        onClick = {
            navController.navigate(route = navigationBarItem.route) {
                popUpTo(id = navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        icon = {
            Icon(
                imageVector = navigationBarItem.icon,
                contentDescription = null
            )
        },
        label = {
            Text(text = navigationBarItem.label)
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun StarWarsCatalogNavigationBarItemPreview() {
    val navigationBarItem = NavigationBarItem(
        label = "Home",
        icon = Icons.Default.Home,
        route = Routes.MAIN.name
    )

    Row {
        StarWarsCatalogNavigationBarItem(
            navController = rememberNavController(),
            navigationBarItem = navigationBarItem
        )
    }
}