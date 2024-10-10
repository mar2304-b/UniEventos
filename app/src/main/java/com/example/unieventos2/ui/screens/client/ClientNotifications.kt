package com.example.unieventos2.ui.screens.client


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R


@Composable
fun ClientNotifications(){
    Scaffold { paddingValues ->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()

        ) {

            Spacer(modifier = Modifier.width(70.dp))
            Text(
                text = stringResource(id = R.string.notifications),
                color = androidx.compose.ui.graphics.Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.width(90.dp))
            Image(
                painter = painterResource(id = R.drawable.notificacion),
                contentDescription = stringResource(id = R.string.notifications),
                modifier = Modifier.size(150.dp)

            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(text= stringResource(id = R.string.upcomingEvent))
        }
    }
}