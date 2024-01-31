package com.example.lista6.view.user

import androidx.lifecycle.ViewModel
import com.example.lista6.Repo.UserService
import com.example.lista6.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {

    fun getUserDetails(userId: Int): Flow<User> = flow {
        try {
            val response : Response<User> = userService.getUserById(userId)
            if (response.isSuccessful) {
                response.body()?.let {
                } ?: throw Exception("Response body is null")
            } else {
                throw Exception("API call unsuccessful, response code: ${response.code()}")
            }

        } catch (e: IOException) {
            throw Exception("Network error: ${e.message}", e)

        } catch (e: HttpException) {
            throw Exception("HTTP error: ${e.message}", e)

        } catch (e: Exception) {
            throw Exception("Error fetching user details: ${e.message}", e)
        }
    }
}
