package com.example.lista6.view.user

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserScreen(
    userId: Int,
    viewModel: UserViewModel = hiltViewModel()
) {
    val userDetails by viewModel.getUserDetails(userId).collectAsStateWithLifecycle(initialValue = null)

    Column(modifier = Modifier.padding(16.dp)) {
        userDetails?.let { user ->
            val image: Painter = rememberImagePainter(data = user.avatar)
            Image(painter = image, contentDescription = "User Avatar")
            Text(text = "Name: ${user.first_name} ${user.last_name}")
            Text(text = "Username: ${user.username}")
            Text(text = "Email: ${user.email}")
            Text(text = "Gender: ${user.gender}")
            Text(text = "Address: ${user.address.street_adress}, ${user.address.city}, ${user.address.state}, ${user.address.zip_code}, ${user.address.country}")
        } ?: Text("Loading user details...")
    }
}
