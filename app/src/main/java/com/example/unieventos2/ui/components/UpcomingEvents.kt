package com.example.unieventos2.ui.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.text.font.FontWeight

@Composable
fun UpcomingEvents() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = "¡Bienvenido a Unieventos!",
            color = Color.Black,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        var searchQuery1 by remember { mutableStateOf("") }
        TextField(
            value = searchQuery1,
            onValueChange = { searchQuery1 = it },
            placeholder = { Text(text = "Buscar evento por nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            }
        )

        var searchQuery2 by remember { mutableStateOf("") }
        TextField(
            value = searchQuery2,
            onValueChange = { searchQuery2 = it },
            placeholder = { Text(text = "Buscar evento por tipo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            }
        )

        var searchQuery3 by remember { mutableStateOf("") }
        TextField(
            value = searchQuery3,
            onValueChange = { searchQuery3 = it },
            placeholder = { Text(text = "Buscar evento por ciudad") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            }
        )

        Spacer(modifier = Modifier.width(50.dp))
        Text(
            text = "Próximos eventos",
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Card(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = com.example.unieventos2.R.drawable.poster), // Reemplaza con tu recurso de imagen
                    contentDescription = null,
                    modifier = Modifier
                        .size(55.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Guns N' Roses", fontSize = 18.sp, color = Color.Black)
                    Text(text = "La banda estadounidense de rock Guns N’Roses estará en Armenia(Q).."
                        , fontSize = 14.sp, color = Color.DarkGray)
                }

            }
        }

    }
}
