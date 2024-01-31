package com.example.lista6.view.users

import androidx.lifecycle.ViewModel
import com.example.lista6.Repo.UserService
import com.example.lista6.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {

    val users: Flow<List<User>> = flow {
        val response = userService.getRandomUsers()
        emit(response.body() ?: emptyList())
        }
    }