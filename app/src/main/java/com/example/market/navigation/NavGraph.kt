// navigation/NavGraph.kt
package com.example.market.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.market.features.account.AccountScreen
import com.example.market.features.catalog.category.AccessoriesScreen
import com.example.market.features.catalog.CatalogScreen
import com.example.market.features.catalog.category.ClothingScreen
import com.example.market.features.catalog.category.ShoesScreen
import com.example.market.features.favorites.FavoritesScreen
import com.example.market.features.main.MainScreen
import com.example.market.features.purchases.PurchasesScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            MainScreen(navController)
        }
        composable("catalog_screen") {
            CatalogScreen(navController)
        }
        composable("favorites_screen") {
            FavoritesScreen(navController)
        }
        composable("purchases_screen") {
            PurchasesScreen(navController)
        }
        composable("account_screen") {
            AccountScreen(navController)
        }
        composable("clothing_screen") {
            ClothingScreen(navController)
        }
        composable("accessories_screen") {
            AccessoriesScreen(navController)
        }
        composable("shoes_screen") {
            ShoesScreen(navController)
        }
    }
}


