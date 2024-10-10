package com.example.unieventos2.ui.screens.admin

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.unieventos2.R
import com.example.unieventos2.models.Event
import com.example.unieventos2.ui.components.EventForm
import com.example.unieventos2.ui.components.Localities
import com.example.unieventos2.viewModel.EventsViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCreation(
    onNavigateToConfirm: () -> Unit,
    eventsViewModel: EventsViewModel,
    onNavigateToCreation: () -> Unit
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    var name by rememberSaveable { mutableStateOf("") }
    var city by rememberSaveable { mutableStateOf("") }
    var expandedCity by rememberSaveable { mutableStateOf(false) }
    var address by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var type by rememberSaveable { mutableStateOf("") }
    var expandedType by rememberSaveable { mutableStateOf(false) }
    var date by rememberSaveable { mutableStateOf("") }
    var datePicked by rememberSaveable { mutableStateOf(false) }

    Scaffold { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            EventForm(
                name = name,
                onNameChange = { name = it },
                type = type,
                onTypeChange = { type = it },
                expandedType = expandedType,
                expandedTypeChange = { expandedType = it },
                description = description,
                onDescriptionChange = { description = it },
                city = city,
                onCityChange = { city = it },
                expandedCity = expandedCity,
                expandedCityChange = { expandedCity = it },
                date = date,
                onDateChange = { date = it },
                datePicked = datePicked,
                onDatePickedChange = { datePicked = it },
                address = address,
                onAddressChange = { address = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        val event = Event(0, name, city, address, description, date)
                        eventsViewModel.createEvent(event)


                        Toast.makeText(context, "Evento publicado exitosamente", Toast.LENGTH_LONG).show()
                        name = ""
                        city = ""
                        address = ""
                        description = ""
                        date = ""
                        datePicked = false
                    },
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text(text = stringResource(id = R.string.post))
                }
            }

        }
    }
}