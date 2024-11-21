package com.example.unieventos2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unieventos2.R
import com.example.unieventos2.models.Locality
import com.example.unieventos2.viewModel.EventsViewModel
import kotlinx.serialization.descriptors.PrimitiveKind

@Composable

fun EventForm(
    name: String,
    onNameChange: (String) -> Unit,
    type: String,
    onTypeChange: (String) -> Unit,
    expandedType: Boolean,
    expandedTypeChange: (Boolean) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    city: String,
    onCityChange: (String) -> Unit,
    expandedCity: Boolean,
    expandedCityChange: (Boolean) -> Unit,
    date: String,
    onDateChange: (String) -> Unit,
    datePicked: Boolean,
    onDatePickedChange: (Boolean) -> Unit,
    address: String,
    onAddressChange: (String) -> Unit,
    localities: MutableList<Locality>,
    onLocalitiesChange: (MutableList<Locality>) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {

        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        OptionsMenu(
            value = city,
            onValueSelected = onCityChange,
            expanded = expandedCity,
            expandedChange = { expandedCityChange(it) },
            modifier = Modifier.fillMaxWidth(),
            values = listOf("Armenia", "Pereira", "Bogota", "Medellin"),
            label = stringResource(id = R.string.city)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OptionsMenu(
            value = type,
            onValueSelected = onTypeChange,
            expanded = expandedType,
            expandedChange = { expandedTypeChange(it) },
            modifier = Modifier.fillMaxWidth(),
            values = listOf("Concierto", "Festival", "Futbol", "Obra de teatro"),
            label = stringResource(id = R.string.eventOption)
        )
        Spacer(modifier = Modifier.height(10.dp))
        DateForm(
            date = date,
            onDateChange = onDateChange,
            isDatePicked = datePicked,
            onDatePickedChange = onDatePickedChange
        )


        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = address,
            onValueChange = onAddressChange,
            label = { Text(text = stringResource(id = R.string.address)) })


        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = description,
            onValueChange = onDescriptionChange,
            label = { Text(text = stringResource(id = R.string.descriptionForm)) })

        Spacer(modifier = Modifier.height(10.dp))
        LocalityCard(
            localities = localities,
            onLocalitiesChange = onLocalitiesChange
        )

        Spacer(modifier = Modifier.height(10.dp))

        localities.forEach { locality ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Text(text = "Localidad: ${locality.name}, Capacidad: ${locality.capacity}, Precio: ${locality.price}")
            }
        }
    }
}
