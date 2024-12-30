package com.example.shoppingevents.ui.eventDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.shoppingevents.data.repos.ShoppingEventRepository
import com.example.shoppingevents.data.repos.ShoppingItemRepository
import com.example.shoppingevents.destinations.EventDetailsRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EventDetailsViewModel @Inject constructor(
    private val saveStateHandle: SavedStateHandle,
    private val shoppingEventRepository: ShoppingEventRepository,
    private val shoppingItemRepository: ShoppingItemRepository
): ViewModel() {
    private val detailsRoute: EventDetailsRoute = saveStateHandle.toRoute<EventDetailsRoute>()

}