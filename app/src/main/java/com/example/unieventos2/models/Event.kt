package com.example.unieventos2.models

import okhttp3.Address

data class Event(
    var id: String = "",
    val name: String = "",
    val city: String = "",
    val address: String = "",
    val description: String = "",
    val date: String = "",
    val localities: List<Locality> = listOf(),
    val type: String = ""
    //val imageUrl: String
)
