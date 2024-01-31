package com.shoppinglist.view.add_products

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen(
    navController: NavController,
    viewModel: ProductFormViewModel = hiltViewModel()
) {
    val isEditing by viewModel.isEditing.collectAsState()
    val name by viewModel.name.collectAsState()
    val amount by viewModel.amount.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Produkt") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },
            )
        },
        ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { viewModel.onNameChanged(it) },
                    label = { Text("Nazwa") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = amount,
                    onValueChange = { viewModel.onAmountChanged(it) },
                    label = { Text("Ilość") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        viewModel.save()
                        navController.popBackStack()
                    }) {
                        Text(text = if (isEditing) "Edytuj" else "Dodaj")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = {
                        viewModel.delete()
                        navController.popBackStack()
                    },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
                    ){
                        Text(text = "Usuń")
                        Icon(Icons.Filled.Delete, null)
                    }

                }
            }
        }
    }
}
