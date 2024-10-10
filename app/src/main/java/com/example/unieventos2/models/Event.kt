package com.example.unieventos2.models

import okhttp3.Address

data class Event(
    val id: Int,
    val name: String,
    val city: String,
    val address: String,
    val description: String,
    val date: String
    //val imageUrl: String
)
