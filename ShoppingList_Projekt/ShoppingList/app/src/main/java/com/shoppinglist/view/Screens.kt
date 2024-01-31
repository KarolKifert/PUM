package com.shoppinglist.view

sealed class Screens(val route: String) {
    data object ProductsScreen : Screens("product_screen")
    data object ProductFormScreen : Screens("product_form_screen/{id}")
}