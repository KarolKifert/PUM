package com.example.lista6.model

import java.io.Serializable

data class Adress(
    val city: String,
    val street_name: String,
    val street_adress: String,
    val zip_code: String,
    val state: String,
    val country: String,
): Serializable