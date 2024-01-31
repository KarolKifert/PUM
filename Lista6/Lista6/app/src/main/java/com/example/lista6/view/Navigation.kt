package com.example.lista6.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lista6.view.user.UserScreen
import com.example.lista6.view.users.UsersScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.UsersScreen.route) {
        composable(Screens.UsersScreen.route) { UsersScreen(navController) }
        composable("user_screen/{userId}") { backStackEntry ->
            val userIdString = backStackEntry.arguments?.getString("userId")
            val userId = userIdString?.toIntOrNull() ?: return@composable
            UserScreen(userId)
        }
    }
}
