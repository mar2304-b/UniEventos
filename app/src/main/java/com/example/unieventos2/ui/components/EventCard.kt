package com.example.unieventos2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.unieventos2.models.Event
import coil.request.ImageRequest

@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column {
//            val model = ImageRequest.Builder(LocalContext.current)
//                .data(event.imageUrl)
//                .crossfade(true)
//                .build()
//
//            AsyncImage(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(120.dp),
//                model = model,
//                contentDescription = "image",
//                contentScale = ContentScale.Crop
//            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = event.name,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Rounded.CalendarMonth,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = event.date)

                }
                VerticalDivider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(40.dp)
                )

                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Place,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = event.city)
                }
            }

        }
    }
}