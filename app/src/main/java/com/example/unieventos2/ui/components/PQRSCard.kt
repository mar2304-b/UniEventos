package com.example.unieventos2.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.unieventos2.models.PQRS


@Composable
fun PQRSCard(
    pqrs: PQRS,
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = pqrs.description,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )
        }
    }
}