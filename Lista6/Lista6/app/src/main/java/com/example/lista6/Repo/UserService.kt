package com.example.lista6.Repo

import com.example.lista6.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users/random_user?size=20")
    suspend fun getRandomUsers(): Response<List<User>>

    @GET("user/{userId}")
    suspend fun getUserById(@Path("userId") userId: Int): Response<User>

}
