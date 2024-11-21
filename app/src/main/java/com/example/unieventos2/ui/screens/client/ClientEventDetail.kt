package com.example.unieventos2.ui.screens.client

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.models.Event
import com.example.unieventos2.viewModel.EventsViewModel
@Composable
fun ClientEventDetail(
    eventsViewModel: EventsViewModel,
    eventId: String
) {
    var event by remember {
        mutableStateOf(Event())
    }
    LaunchedEffect(eventId) {
        event = eventsViewModel.getEventById(eventId)!!
    }

    var name by rememberSaveable { mutableStateOf(event.name) }
    var city by rememberSaveable { mutableStateOf(event.city) }
    var expandedCity by rememberSaveable { mutableStateOf(false) }
    var address by rememberSaveable { mutableStateOf(event.address) }
    var description by rememberSaveable { mutableStateOf(event.description) }
    var type by rememberSaveable { mutableStateOf(event.type) }
    var expandedType by rememberSaveable { mutableStateOf(false) }
    var date by rememberSaveable { mutableStateOf(event.date) }
    var datePicked by rememberSaveable { mutableStateOf(false) }
    var localities by rememberSaveable { mutableStateOf(event.localities.toMutableList()) }

    LaunchedEffect(event) {
        event.let {
            name = it.name
            city = it.city
            address = it.address
            description = it.description
            type = it.type
        }
    }

    Scaffold(
        floatingActionButton = {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Detalles del evento",
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 24.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Nombre: ${event.name}",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Fecha: ${event.date}",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Ciudad: ${event.city}",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Dirección: ${event.address}",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Descripción del evento: ${event.description}",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
