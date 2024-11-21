package com.example.unieventos2.models

data class OrderItem(
    var id: String = "",
    val eventId: String = "",
    val quantity: Int = 0,
    val price:Double = 0.0,
    val localityName: String = "",
)