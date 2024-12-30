package com.example.shoppingevents.ui.addEvent

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
