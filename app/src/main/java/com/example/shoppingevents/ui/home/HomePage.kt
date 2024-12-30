package com.example.shoppingevents.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingevents.customComposables.ShoppingAppBar
import com.example.shoppingevents.data.entities.ShoppingEvent

@Composable
fun HomePage(
    navigateToAddEvent: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.homeUiState.collectAsState()

    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Shopping Events",
                canNavigateBack = false // home page 不能返回
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToAddEvent
            ){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Event"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center

    ) { innerPadding ->
        if (uiState.events.isEmpty()){
            EmptyList(
                message = "No events found\n Add an event to get started",
                modifier = modifier.padding(innerPadding)
            )
            return@Scaffold
        }
        ShoppingList(
            shoppingEvents = uiState.events,
            modifier = modifier.padding(innerPadding)
        )

    }

}

@Composable
fun ShoppingEventView(
    shoppingEvent: ShoppingEvent,
    modifier: Modifier = Modifier
) {
    ListItem(
        headlineContent = {
            Text(text = shoppingEvent.name)
        },
        supportingContent = {
            Text(text = shoppingEvent.eventDate)
        },
        trailingContent = {
            Text(
                text = "\$ ${shoppingEvent.totalCost}",
                style = MaterialTheme.typography.bodyLarge)
        },
        leadingContent = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null
                )
            }
        }
    )


}

@Composable
fun ShoppingList(
    shoppingEvents: List<ShoppingEvent>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(shoppingEvents){ event ->
            ShoppingEventView(shoppingEvent = event)
        }

    }
    
}


@Composable
fun EmptyList(
    message: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize()
    ){
        Text(
            text = message,
            textAlign = TextAlign.Center
        )
    }
    
}