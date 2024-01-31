package com.degreemanagement.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.degreemanagement.view.add_degree.AddDegreeScreen
import com.degreemanagement.view.degree.DegreeScreen
import com.degreemanagement.view.edit_degree.EditDegreeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "degree_screen") {
        composable("degree_screen") { DegreeScreen(navController) }
        composable("add_degree_screen") { AddDegreeScreen(navController) }
        composable("edit_degree_screen/{degreeSubject}") { backStackEntry ->
            val degreeSubject = backStackEntry.arguments?.getString("degreeSubject") ?: return@composable
            EditDegreeScreen(navController, degreeSubject)
        }
    }
}