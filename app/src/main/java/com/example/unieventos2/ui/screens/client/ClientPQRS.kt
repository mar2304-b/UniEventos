package com.example.unieventos2.ui.screens.client


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPQRS() {
    Scaffold { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "PQRS",
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.pqrs),
                contentDescription = "PQRS",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Manejan muy buenos precios",
                modifier = Modifier.align(Alignment.Start)
            )
            Text(
                text = "Gracias",
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(30.dp))
            TextField(
                value = "¿Cuando habrá concierto de Coldplay en Bogotá?",
                onValueChange = {},
                modifier = Modifier.width(300.dp),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Publicar")
            }
        }
    }
}
