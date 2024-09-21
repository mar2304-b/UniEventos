package com.example.unieventos2.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.ui.components.Event
import com.example.unieventos2.ui.components.Localities

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedEvent() {
    val scrollState = rememberScrollState()

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Concierto")
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Guns N'Roses",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold)


            Event()

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "ciudad")

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "fecha")

            Localities()
            
            Row() {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Precio: ")
                Spacer(modifier = Modifier.width(200.dp))
                Text(text = "1200000")

            }
            Row() {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Capacidad permitida: ")
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "20 personas")



            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Ir al carrito de compras")
            }

        }

    }
}