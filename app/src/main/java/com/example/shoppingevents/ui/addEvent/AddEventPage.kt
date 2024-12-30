package com.example.shoppingevents.ui.addEvent

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoppingevents.customComposables.ShoppingAppBar

@Composable
fun AddEventPage(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Add Event",
                canNavigateBack = true,
                navigateUp = navigateUp
            )
        }

    ) { innerPadding ->
        Text(
            text = "Add Event",
            modifier = modifier.padding(innerPadding)
        )

    }

}