package com.shoppinglist.view.products

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.shoppinglist.composables.ListItem
import androidx.compose.foundation.lazy.items
import com.shoppinglist.model.Product
import com.shoppinglist.view.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(
    navController: NavController,
    viewModel: ProductsViewModel = hiltViewModel()
) {
    val products by viewModel.getAllProducts().collectAsStateWithLifecycle(initialValue = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Moja biedronka 🐞") })
        },
        floatingActionButton = {
            AddProductButton(navController)
        },
        content = { padding ->
            Surface(modifier = Modifier.padding(padding)) {
                ProductsList(navController, products)
            }
        }
    )
}

@Composable
fun ProductsList(
    navController: NavController,
    products: List<Product>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(products) { product ->
            ListItem(
                name = product.name ?: "",
                description = product.amount.toString(),
                onItemClick = {
                   navController.navigate(Screens.ProductFormScreen.route.replace("{id}", product.uid.toString()))
                },
                backgroundColor = Color.Transparent
            )
        }
    }
}

@Composable
fun AddProductButton(navController: NavController) {
    FloatingActionButton(onClick = {
        navController.navigate(Screens.ProductFormScreen.route)
    }) {
        Icon(Icons.Filled.Add, null)
    }
}
