package com.example.unieventos2.models

data class CartItem (
    val id: String = "",
    val eventId: String = "",
    val eventName: String = "",
    val localityName: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0,
    val totalPrice: Double = 0.0

)