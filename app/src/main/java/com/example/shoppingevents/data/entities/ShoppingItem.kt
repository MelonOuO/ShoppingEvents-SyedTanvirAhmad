package com.example.shoppingevents.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "shopping_item")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val itemId: Long = 0,

    @ColumnInfo(name = "event_id")
    val eventId: Long,

    @ColumnInfo(name = "item_name")
    val itemName: String,

    val price: Double = 0.0,

    val quantity: Int = 0,
)