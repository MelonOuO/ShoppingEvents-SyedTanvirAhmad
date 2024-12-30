package com.example.shoppingevents.ui.eventDetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoppingevents.customComposables.ShoppingAppBar

@Composable
fun EventDetailsPage(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Event Details",
                canNavigateBack = true,
                navigateUp = navigateUp
            )
        }

    ) { innerPadding ->
        Text(
            text = "Event Details",
            modifier = modifier.padding(innerPadding)
        )

    }

}