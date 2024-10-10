package com.example.unieventos2.ui.screens.admin

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.unieventos2.ui.components.NotificationCard
import com.example.unieventos2.viewModel.NotificationsViewModel
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze

@Composable
fun NotificationsScreen(
    notificationsViewModel: NotificationsViewModel,
    paddingValues: PaddingValues,
    hazeState: HazeState
) {

    val notifications = notificationsViewModel.notifications.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .haze(
                state = hazeState,
                style = HazeDefaults.style(backgroundColor = MaterialTheme.colorScheme.surface)
            ),
        contentPadding = paddingValues
    ) {
        items(notifications) {
            NotificationCard(
                notification = it
            )
        }
    }
}