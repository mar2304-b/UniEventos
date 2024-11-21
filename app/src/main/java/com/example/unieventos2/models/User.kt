package com.example.unieventos2.models

data class User(
    var id: String = "",
    val name: String = "",
    val role: Role = Role.CLIENT,
    val email: String = "",
    val password: String = "",
    val address: String = "",
    val telephone: String = "",
    val isActive: Boolean = true

)
