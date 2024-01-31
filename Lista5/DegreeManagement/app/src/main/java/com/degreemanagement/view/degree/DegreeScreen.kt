package com.degreemanagement.view.degree

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.degreemanagement.composables.ListItem
import com.degreemanagement.model.degree.Degree

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DegreeScreen(
    navController: NavController,
    viewModel: DegreeViewModel = hiltViewModel()
) {
    val degrees by viewModel.getDegreeState().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Moje wspaniałe oceny") })
        },
        floatingActionButton = {
            AddDegreeButton(navController = navController)
        },
        content = { padding ->
            Surface(modifier = Modifier.padding(padding)) {
                DegreeList(navController = navController, degrees = degrees)
            }
        }
    )
}

@Composable
fun DegreeList(
    navController: NavController,
    degrees: List<Degree>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(degrees) { degree ->
            ListItem(
                name = degree.value.toString(),
                description = degree.subject,
                onItemClick = {
                    navController.navigate("edit_degree_screen/${degree.subject}")//Naprawdę próbowałem z id
                },
                backgroundColor = Color.Transparent
            )
        }
    }
}

@Composable
fun AddDegreeButton(navController: NavController) {
    FloatingActionButton(onClick = {
        navController.navigate("add_degree_screen")
    }) {
        Icon(Icons.Filled.Add, "Add Degree")
    }
}
