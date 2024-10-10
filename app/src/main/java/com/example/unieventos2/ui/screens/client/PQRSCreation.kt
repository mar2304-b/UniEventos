package com.example.unieventos2.ui.screens.client


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R
import com.example.unieventos2.models.Notification
import com.example.unieventos2.models.PQRS
import com.example.unieventos2.ui.components.NotificationForm
import com.example.unieventos2.ui.components.PQRSForm
import com.example.unieventos2.viewModel.NotificationsViewModel
import com.example.unieventos2.viewModel.PQRSViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PQRSCreation(
    PQRSViewModel: PQRSViewModel
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    var description by rememberSaveable { mutableStateOf("") }

    Scaffold { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                PQRSForm(
                    description = description,
                    onDescriptionChange = { description = it }
                )

                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        val pqrs = PQRS(0, description)
                        PQRSViewModel.createPQRS(pqrs)
                        description = ""
                        Toast.makeText(context, "PQRS creada", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = stringResource(id = R.string.post))
                }
            }
        }
    }
}