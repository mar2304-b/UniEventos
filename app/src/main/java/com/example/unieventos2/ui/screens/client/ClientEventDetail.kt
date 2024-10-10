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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.viewModel.EventsViewModel
@Composable
fun ClientEventDetail(
    eventsViewModel: EventsViewModel,
    eventId: Int
) {
    val event = eventsViewModel.getEventById(eventId)
    requireNotNull(event)

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
