package com.degreemanagement.view

sealed class Screens(val route: String) {
    object DegreeScreen : Screens("degree_screen")
    object AddDegreeScreen : Screens("add_degree_screen")
    object EditDegreeScreen : Screens("edit_degree_screen/{degreeId}")
}