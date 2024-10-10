package com.example.unieventos2.ui.screens.admin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unieventos2.R
import com.example.unieventos2.models.Event
import com.example.unieventos2.ui.components.EventForm
import com.example.unieventos2.viewModel.EventsViewModel
@Composable
fun AdminEventDetail(
    eventsViewModel: EventsViewModel,
    eventId: Int
) {
    val event = eventsViewModel.getEventById(eventId)

    if (event == null) {
        return
    }

    var name by rememberSaveable { mutableStateOf(event.name) }
    var city by rememberSaveable { mutableStateOf(event.city) }
    var expandedCity by rememberSaveable { mutableStateOf(false) }
    var address by rememberSaveable { mutableStateOf(event.address) }
    var description by rememberSaveable { mutableStateOf(event.description) }
    var type by rememberSaveable { mutableStateOf(event.description) }
    var expandedType by rememberSaveable { mutableStateOf(false) }
    var date by rememberSaveable { mutableStateOf(event.date) }
    var datePicked by rememberSaveable { mutableStateOf(false) }

    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
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
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.localidades),
                contentDescription = stringResource(id = R.string.locality),
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    val editEvent = Event(
                        eventId,
                        name,
                        city,
                        address,
                        description,
                        date
                    )
                    eventsViewModel.editEvent(editEvent)
                    Toast.makeText(context, "Evento editado exitosamente", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = stringResource(id = R.string.edit))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    eventsViewModel.deleteEvent(event)
                    Toast.makeText(context, "Evento eliminado exitosamente", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = stringResource(id = R.string.delete))
            }
        }
    }
}