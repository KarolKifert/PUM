package com.example.lista6.view.users

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.lista6.ListItem
import com.example.lista6.model.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersScreen(
    navController: NavController,
    viewModel: UsersViewModel = hiltViewModel()
) {
    val users by viewModel.users.collectAsStateWithLifecycle(initialValue = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Lista użytkowników") })
        },
        content = { padding ->
            Surface(modifier = Modifier.padding(padding)) {
                UserListItem(navController, users)
            }
        }
    )
}

@Composable
fun UserListItem(
    navController: NavController,
    users: List<User>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(users) { user ->
            ListItem(
                user = user,
                onItemClick = {
                    navController.navigate("user_screen/${user.id}")
                }
            )
        }
    }
}
