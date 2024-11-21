package com.example.unieventos2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.models.Locality


@Composable
fun LocalityCard(
    localities: MutableList<Locality>,
    onLocalitiesChange: (MutableList<Locality>) -> Unit
) {
    var name by rememberSaveable { mutableStateOf("") }
    var capacity by rememberSaveable { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }

    val textFieldTextStyle =
        androidx.compose.ui.text.TextStyle(fontSize = 12.sp)

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Localidad", fontSize = 12.sp) },
                textStyle = textFieldTextStyle,
                modifier = Modifier.width(100.dp)
            )

            OutlinedTextField(
                value = capacity,
                onValueChange = {capacity = it},
                label = { Text(text = "Capacidad permitida", fontSize = 12.sp) },
                textStyle = textFieldTextStyle,
                modifier = Modifier.width(150.dp)
            )

            OutlinedTextField(
                value = price,
                onValueChange = { price = it},
                label = { Text(text = "Precio", fontSize = 12.sp) },
                textStyle = textFieldTextStyle,
                modifier = Modifier.width(100.dp)
            )
        }

        IconButton(onClick = {
            val updatedLocalities = localities.toMutableList().apply {
                add(Locality(localities.size + 1, name, capacity.toInt(), price.toDouble()))
            }
            onLocalitiesChange(updatedLocalities)
        }) {
            Icon(
                imageVector = Icons.Rounded.AddCircleOutline,
                contentDescription = "add"
            )
        }
    }
}
