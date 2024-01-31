package com.shoppinglist.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shoppinglist.view.add_products.ProductFormScreen
import com.shoppinglist.view.products.ProductsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.ProductsScreen.route) {
        composable(Screens.ProductsScreen.route) { ProductsScreen(navController) }
        composable(Screens.ProductFormScreen.route) { ProductFormScreen(navController) }
    }
}