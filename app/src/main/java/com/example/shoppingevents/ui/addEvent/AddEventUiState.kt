package com.example.shoppingevents.ui.addEvent

import com.example.shoppingevents.data.entities.ShoppingEvent
import com.example.shoppingevents.data.repos.ShoppingEventRepository

data class AddEventDetails(
    val id: Long = 0,
    val name: String = "",
    val initialBudget: String = "0.0",
    val totalCost: Double = 0.0,
    val eventDate: String = "",
    val completed: Boolean = false

)
data class AddEventUiState(
    val addEventDetails: AddEventDetails = AddEventDetails(),
    val isEntryValid: Boolean = false
)

fun AddEventDetails.toShoppingEvent(): ShoppingEvent = ShoppingEvent(
    id = id,
    name = name,
    initialBudget = initialBudget.toDoubleOrNull() ?: 0.0,
    totalCost = totalCost,
    eventDate = eventDate,
    completed = completed

)
