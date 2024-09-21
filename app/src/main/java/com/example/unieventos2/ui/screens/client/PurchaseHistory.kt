package com.example.unieventos2.ui.screens.client

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchaseHistory() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Historial de compras",
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
                Text(text = "Total: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "1200000000",
                    singleLine = true,
                    onValueChange = {},
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(text = "Código de la orden:")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "222",
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Total: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "1200000000",
                    singleLine = true,
                    onValueChange = {},
                )
            }

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
                Text(text = "Total: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "1200000000",
                    singleLine = true,
                    onValueChange = {},
                )
            }
        }
    }
}
