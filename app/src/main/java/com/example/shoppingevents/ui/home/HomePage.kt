package com.example.shoppingevents.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoppingevents.customComposables.ShoppingAppBar

@Composable
fun HomePage(

    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Shopping Events",
                canNavigateBack = false // home page 不能返回
            )
        }

    ) { innerPadding ->
        Text(
            text = "",
            modifier = modifier.padding(innerPadding)
        )

    }

}