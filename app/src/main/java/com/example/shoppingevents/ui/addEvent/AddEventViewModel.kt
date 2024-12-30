package com.example.shoppingevents.ui.addEvent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.shoppingevents.data.repos.ShoppingEventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEventViewModel @Inject constructor(

): ViewModel() {
    var addEventUiState by mutableStateOf(AddEventUiState())

    fun updateUiState(
        addEventDetails: AddEventDetails
    ){
        addEventUiState = AddEventUiState(
            addEventDetails = addEventDetails,
            isEntryValid = validateInput(addEventDetails)

        )
    }

    private fun validateInput(
        eventDetails: AddEventDetails = addEventUiState.addEventDetails
    ): Boolean{
        return with(eventDetails){
            name.isNotBlank() && eventDate.isNotBlank()
        }
    }

     fun saveEvent(){
        if(validateInput()){


        }
    }
}