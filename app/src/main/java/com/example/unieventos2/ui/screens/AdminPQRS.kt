package com.example.unieventos2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminPQRS() {
    Scaffold { paddingValues ->

        val textState1 = remember { mutableStateOf("Gracias") }
        val textState2 = remember { mutableStateOf("Muy pronto") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()

        ) {

            Spacer(modifier = Modifier.width(70.dp))
            Text(
                text = "PQRS",
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.width(90.dp))
            Image(
                painter = painterResource(id = R.drawable.pqrs),
                contentDescription = "PQRS",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Manejan muy buenos precios")
            BasicTextField(
                value = textState1.value,
                onValueChange = { textState1.value = it },
                modifier = Modifier
                    .width(300.dp)
                    .background(Color.Transparent), // Fondo transparente
                textStyle = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "¿Cuando habrá concierto de Coldplay en Bogotá?:")
            BasicTextField(
                value = textState2.value,
                onValueChange = { textState2.value = it },
                modifier = Modifier
                    .width(300.dp)
                    .background(Color.Transparent), // Fondo transparente
                textStyle = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Publicar respuestas")
            }
        }
    }
}
