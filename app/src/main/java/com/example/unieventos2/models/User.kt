package com.example.unieventos2.models

data class User(
    val id: Int,
    val name: String,
    val role: Role,
    val email: String,
    val password: String,
    val address: String,
    val telephone: String

)
