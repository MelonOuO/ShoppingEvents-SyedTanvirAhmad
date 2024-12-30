package com.example.shoppingevents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppingevents.destinations.AddEventRoute
import com.example.shoppingevents.destinations.EventDetailsRoute
import com.example.shoppingevents.destinations.HomeRoute
import com.example.shoppingevents.ui.addEvent.AddEventPage
import com.example.shoppingevents.ui.eventDetails.EventDetailsPage
import com.example.shoppingevents.ui.home.HomePage
import com.example.shoppingevents.ui.theme.ShoppingEventsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingApp()
        }
    }
}
@Composable
fun ShoppingApp(
    modifier: Modifier = Modifier
) {
    ShoppingEventsTheme {
       val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ){
            composable<HomeRoute>{
                HomePage(
                    navigateToAddEvent = {
                        navController.navigate(route = AddEventRoute)
                    },
                    modifier = modifier
                )
            }
            composable<AddEventRoute>{
                AddEventPage(
                    navigateBack = { navController.popBackStack() },
                    navigateUp = { navController.navigateUp() },
                    modifier = modifier
                )
            }
            composable<EventDetailsRoute>{
                EventDetailsPage(
                    navigateBack = { navController.popBackStack() },
                    navigateUp = { navController.navigateUp() },
                    modifier = modifier
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingEventsTheme {
    }
}