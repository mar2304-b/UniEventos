package com.example.unieventos2.ui.screens.admin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unieventos2.R
import com.example.unieventos2.models.Notification
import com.example.unieventos2.ui.components.NotificationForm
import com.example.unieventos2.viewModel.NotificationsViewModel


@Composable
fun NotificationDetail(
    notificationsViewModel: NotificationsViewModel,
    notificationId: Int) {

    val notification = notificationsViewModel.getNotificationById(notificationId)
    requireNotNull(notification)

    var name by rememberSaveable { mutableStateOf(notification.name) }
    var description by rememberSaveable { mutableStateOf(notification.description) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        NotificationForm(
            name = name,
            onNameChange = { name = it },
            description = description,
            onDescriptionChange = { description = it }
        )

        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {val editNotification = Notification(
                    notificationId,
                    name,
                    description
                )
                    notificationsViewModel.editNotification(editNotification)
                },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = stringResource(id = R.string.edit))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {notificationsViewModel.deleteNotification(notification)},
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = stringResource(id = R.string.delete))
            }

        }

    }
}