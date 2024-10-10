package com.example.unieventos2.ui.screens.admin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.unieventos2.models.Event
import com.example.unieventos2.models.Notification
import com.example.unieventos2.ui.components.EventForm
import com.example.unieventos2.ui.components.NotificationForm
import com.example.unieventos2.viewModel.EventsViewModel
import com.example.unieventos2.viewModel.NotificationsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationCreation(
    onNavigateToCreateNotification: () -> Unit,
    notificationsViewModel: NotificationsViewModel
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    var name by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }

    Scaffold { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            NotificationForm(
                name = name,
                onNameChange = { name = it },
                description = description,
                onDescriptionChange = { description = it }
            )

            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        val notification = Notification(0, name, description)
                        notificationsViewModel.createNotification(notification)

                        Toast.makeText(context, "Notificación publicada exitosamente", Toast.LENGTH_LONG).show()

                        name = ""
                        description = ""
                    },
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text(text = stringResource(id = R.string.post))
                }
            }

        }
    }
}