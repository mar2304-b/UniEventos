package com.example.unieventos2.models

data class Order(
    var id: String = "",
    val date: String = "",
    val total: Double = 0.0,
    val items: List<OrderItem> = emptyList(),
    val userId: String = "",
)