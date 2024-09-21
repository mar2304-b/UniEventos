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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.unieventos2.ui.components.Event
import com.example.unieventos2.ui.components.Localities
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCreation(
    onNavigateToConfirm: ()-> Unit,
    onNavigateToCreation: ()-> Unit,
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    var typeEvent by rememberSaveable { mutableStateOf("") }
    val events = listOf("Deporte", "Concierto", "Festival", "Teatro")
    val cities = listOf("Armenia", "Pereira", "Bogotá", "Medellín", "Cali")
    var city by rememberSaveable { mutableStateOf("") }
    var date by rememberSaveable { mutableStateOf("") }
    var showDatePicker by rememberSaveable { mutableStateOf(false) }
    var datePickerState = rememberDatePickerState()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                com.example.unieventos2.ui.components.DropdownMenu(
                    value = typeEvent,
                    onValueChange = { typeEvent = it },
                    items = events
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Guns N' Roses",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold
            )

            Event()

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                com.example.unieventos2.ui.components.DropdownMenu(
                    value = city,
                    onValueChange = { city = it },
                    items = cities
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = date,
                    onValueChange = {},
                    readOnly = true,
                    placeholder = { Text(text = "Seleccione una fecha") },
                    trailingIcon = {
                        IconButton(onClick = { showDatePicker = true }) {
                            Icon(
                                imageVector = Icons.Rounded.DateRange,
                                contentDescription = "Icono de calendario"
                            )
                        }
                    }
                )
            }

            Localities()

            Row {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Precio:")
                TextField(
                    value = "1200000",
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(300.dp),
                    textStyle = TextStyle(textAlign = TextAlign.Center)
                )
            }
            Row {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Capacidad permitida:")
                TextField(
                    value = "20 personas",
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(300.dp),
                    textStyle = TextStyle(textAlign = TextAlign.Center)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    enabled = events.isNotEmpty() && cities.isNotEmpty() && date.isNotEmpty(),
                    onClick = {
                        onNavigateToCreation()
                        if (events.isNotEmpty() && cities.isNotEmpty() && date.isNotEmpty()) {
                            Toast.makeText(context, "Evento publicado con éxito", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
                        }
                    }
                ) {
                    Text(text = "Publicar")
                }
            }

            if (showDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showDatePicker = false },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                onNavigateToConfirm()
                                val selectedDate = datePickerState.selectedDateMillis
                                if (selectedDate != null) {
                                    val eventDate = Date(selectedDate)
                                    val formattedDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(eventDate)
                                    date = formattedDate
                                }
                                showDatePicker = false
                            }
                        ) {
                            Text(text = "Confirmar")
                        }
                    }
                ) {
                    DatePicker(state = datePickerState)
                }
            }
        }
    }
}

