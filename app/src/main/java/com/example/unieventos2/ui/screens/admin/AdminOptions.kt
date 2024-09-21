package com.example.unieventos2.ui.screens.admin

import android.app.Notification
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unieventos2.R

@Composable
fun AdminOptions(
    onNavigateToManageEvents: ()-> Unit,
    onNavigateToCouponCreation: ()-> Unit,
    onNavigateToManageAccount: ()-> Unit,
    onNavigateToPQRS: ()-> Unit,
    onNavigateToNotifications: ()-> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {onNavigateToManageEvents()},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA07A))
        ) {
            Text(text = stringResource(id = R.string.manageEvents))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {onNavigateToCouponCreation()},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFADD8E6))
        ) {
            Text(text = stringResource(id = R.string.couponCreation))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {onNavigateToManageAccount()},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA07A))
        ) {
            Text(text = stringResource(id = R.string.manageacount))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {onNavigateToPQRS()},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFADD8E6))
        ) {
            Text(text = stringResource(id = R.string.checkPQRS))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {onNavigateToNotifications()},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA07A))
        ) {
            Text(text = stringResource(id = R.string.notifications))
        }
    }
}
