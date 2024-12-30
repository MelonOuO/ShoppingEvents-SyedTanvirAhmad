package com.example.shoppingevents.ui.eventDetails

import com.example.shoppingevents.ui.addEvent.AddEventDetails
import com.example.shoppingevents.ui.addEvent.AddEventUiState

data class ItemDetails(
    val itemId: Long = 0,
    val eventId: Long = 0,
    val itemName: String = "",
    val price: String = "",
    val quantity: String = "",
)

data class ItemUiState(
    val isEdit: Boolean = false,
    val itemDetails: ItemDetails = ItemDetails()
)

data class EventDetailsUiState(
    val eventDetails: AddEventDetails = AddEventDetails(),
    val itemList: List<ItemUiState> = emptyList(),

)