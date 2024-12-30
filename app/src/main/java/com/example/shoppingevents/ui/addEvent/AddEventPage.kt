package com.example.shoppingevents.ui.addEvent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.enableLiveLiterals
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingevents.customComposables.ShoppingAppBar
import com.example.shoppingevents.ui.common.defaultItemPadding
import com.example.shoppingevents.ui.common.mediumItemPadding
import com.example.shoppingevents.utils.formatDate
import kotlinx.coroutines.launch

@Composable
fun AddEventPage(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddEventViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Add Event",
                canNavigateBack = true,
                navigateUp = navigateUp
            )
        }

    ) { innerPadding ->
        EventForm(
            uiState = viewModel.addEventUiState,
            onEventValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.saveEvent()
                    navigateBack()
                }
            },
            modifier = modifier.padding(innerPadding)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventForm(
    uiState: AddEventUiState,
    onEventValueChange: (AddEventDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var openDatePicker by remember{
        mutableStateOf(false)
    }
    val datePickerState = rememberDatePickerState()
    Column(
        modifier = modifier
            .padding(defaultItemPadding())
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextInputFields(
            addEventDetails = uiState.addEventDetails,
            onEventValueChange = onEventValueChange,
        )

        DatePickerUi(
            shouldOpenDialog = openDatePicker,
            state = datePickerState,
            onDismissRequest = {
                openDatePicker = false
            },
            onClickConfirm = {
                datePickerState.selectedDateMillis?.let{
                    onEventValueChange(uiState.addEventDetails.copy(
                        // user 一定有選日期才會執行這個function，所以可以使用 !!
                        eventDate = formatDate(it) !!
                    ))
                }
                openDatePicker = false
            },
            onClickCancel = {

            }
        )
        DatePickerButton(
            state = datePickerState,
            onSelectDateButtonClicked = {
                openDatePicker = true
            }
        )

        Button(
            onClick = onSaveClick,
            enabled = uiState.isEntryValid,
            modifier = Modifier.fillMaxWidth().padding(mediumItemPadding())
        ){
            Text("SAVE")

        }


    }

}

@Composable
fun TextInputFields(
    addEventDetails: AddEventDetails,
    onEventValueChange: (AddEventDetails) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = addEventDetails.name,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            onValueChange = {
                onEventValueChange(addEventDetails.copy(name = it))
            },
            label = {
                Text(text = "Event Name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(defaultItemPadding())
        )

        OutlinedTextField(
            value = addEventDetails.initialBudget,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            onValueChange = {
                onEventValueChange(addEventDetails.copy(
                    initialBudget = it))
            },
            label = {
                Text(text = "Initial Budget (optional)")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(defaultItemPadding())
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerUi(
    shouldOpenDialog: Boolean,
    state: DatePickerState,
    onDismissRequest: () -> Unit,
    onClickConfirm: () -> Unit,
    onClickCancel: () -> Unit,
    modifier: Modifier = Modifier
){
    if(shouldOpenDialog){
        val confirmEnabled by remember{
            derivedStateOf {
                state.selectedDateMillis != null
            }
        }
        DatePickerDialog(
            modifier = modifier,
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(
                    enabled = confirmEnabled,
                    onClick = onClickConfirm
                ){
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onClickCancel
                ){
                    Text("CANCEL")
                }
            },


        ) {
            DatePicker(
                state = state
            )

        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerButton(
    state: DatePickerState,
    onSelectDateButtonClicked: () -> Unit,
    modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        ElevatedButton(
            onClick = onSelectDateButtonClicked
        ) {
            Text("Select Date")
        }
        Text(text = formatDate(state.selectedDateMillis) ?: "Nothing selected")

    }


}
