package com.degreemanagement.view.edit_degree

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.degreemanagement.view.edit_degree.EditDegreeViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun EditDegreeScreen(
    navController: NavController,
    subject: String,
    viewModel: EditDegreeViewModel = hiltViewModel()
) {
    var newSubject by remember { mutableStateOf(subject) }
    var newValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = newSubject,
            onValueChange = { newSubject = it },
            label = { Text("Subject") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = newValue,
            onValueChange = { newValue = it },
            label = { Text("Degree Value") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.updateDegree(subject, newSubject, newValue.toIntOrNull() ?: 0)
                navController.popBackStack()
            }
        ) {
            Text("Save Changes")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.deleteDegree(subject)
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Delete")
        }
    }
}
