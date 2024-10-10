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
import com.example.unieventos2.models.Coupon



@Composable
fun CouponCard(
    coupon: Coupon,
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
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = coupon.name,
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
            Text(
                text = coupon.code,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )

            Text(
                text = coupon.percentage.toString(),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )

        }
    }
}