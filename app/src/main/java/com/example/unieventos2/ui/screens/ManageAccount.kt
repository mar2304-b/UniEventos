package com.example.unieventos2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.ui.components.PersonalInformation

@Composable
fun ManageAccount(
    onNavigateToDelete: ()-> Unit,
    onNavigateToEdit: ()-> Unit,
) {
    val scrollState = rememberScrollState()

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = "Gestionar mi cuenta",
                color = androidx.compose.ui.graphics.Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))
            PersonalInformation()

            Spacer(modifier = Modifier.height(10.dp))


            Button(
                onClick = {onNavigateToEdit()},
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Editar")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {onNavigateToDelete()},
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Eliminar")
            }
        }

    }
}


