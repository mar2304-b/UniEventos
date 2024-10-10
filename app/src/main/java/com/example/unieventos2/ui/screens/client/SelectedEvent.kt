package com.example.unieventos2.ui.screens.client


import android.media.metrics.Event
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.unieventos2.R
import com.example.unieventos2.ui.components.Localities

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedEvent(
    onNavigateToSelectedEvent: ()-> Unit,
) {
    val scrollState = rememberScrollState()

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = stringResource(id = R.string.typeEvent))
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.titleEvent),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold)


            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.city))

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.date))

            Localities()
            
            Row() {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = stringResource(id = R.string.price))
                Spacer(modifier = Modifier.width(200.dp))
                Text(text = stringResource(id = R.string.priceDescription))

            }
            Row() {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = stringResource(id = R.string.capacity))
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = stringResource(id = R.string.capacityDescription))
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {onNavigateToSelectedEvent()},
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.messsageShoppingCart))
            }

        }

    }
}