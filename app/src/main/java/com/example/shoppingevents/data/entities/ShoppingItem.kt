package com.example.shoppingevents.data.entities

data class ShoppingItem(
    val itemId: Long = 0,
    val eventId: Long,
    val itemName: String,
    val price: Double = 0.0,
    val quantity: Int = 0,
)