package com.example.lista6.view

sealed class Screens (val route: String){
    data object UsersScreen : Screens("users_screen")
    data object UserScreen : Screens("user_screen/{id}")
}