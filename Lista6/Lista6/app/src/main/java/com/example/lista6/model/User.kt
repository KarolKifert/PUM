package com.example.lista6.model

import java.io.Serializable

data class User (
    val id: Int,
    val username: String,
    val avatar: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val gender: String,
    val address: Adress
): Serializable