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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LocalityCard() {
    val textFieldTextStyle =
        androidx.compose.ui.text.TextStyle(fontSize = 12.sp)

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Localidad", fontSize = 12.sp) },
                textStyle = textFieldTextStyle,
                modifier = Modifier.width(100.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Capacidad permitida", fontSize = 12.sp) },
                textStyle = textFieldTextStyle,
                modifier = Modifier.width(150.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Precio", fontSize = 12.sp) },
                textStyle = textFieldTextStyle,
                modifier = Modifier.width(100.dp)
            )
        }

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Rounded.AddCircleOutline,
                contentDescription = "add"
            )
        }
    }
}
