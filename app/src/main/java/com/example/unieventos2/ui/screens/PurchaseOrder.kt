package com.example.unieventos2.ui.screens

import android.R
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchaseOrder() {
    var transferenciaChecked by remember { mutableStateOf(false) }
    var puntosFalabellaChecked by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Orden de compra",
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(text = "Código de la orden:")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "333",
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Código del cliente: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "111",
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(text = "Código evento: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "444",
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Localidad: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "1",
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(text = "Unidades: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "1",
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Precio individual: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "1200000000",
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Cupón: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "123",
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Total: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "120000",
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Fecha: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "20/12/2024",
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Medio de pago: ")

                Row {
                    Checkbox(
                        checked = transferenciaChecked,
                        onCheckedChange = { transferenciaChecked = it }
                    )
                    Text(text = "Transferencia")
                    Spacer(modifier = Modifier.width(20.dp))
                    Checkbox(
                        checked = puntosFalabellaChecked,
                        onCheckedChange = { puntosFalabellaChecked = it }
                    )
                    Text(text = "Puntos Falabella")
                }

                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text(text = "Generar pago")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text(text = "Editar")
                }
            }
        }
    }
}
