package com.example.unieventos2.ui.screens.admin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unieventos2.R
import com.example.unieventos2.models.Event
import com.example.unieventos2.ui.components.EventCard
import com.example.unieventos2.ui.components.UpcomingEvents
import com.example.unieventos2.viewModel.EventsViewModel
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze

@Composable
fun AdminUpcomingEvents(
    onNavigateToEventDetail: (Int) -> Unit,
    eventsViewModel: EventsViewModel,
    hazeState: HazeState,
    paddingValues: PaddingValues
) {

    val events = eventsViewModel.events.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .haze(
                state = hazeState,
                style = HazeDefaults.style(backgroundColor = MaterialTheme.colorScheme.surface)
            ),
        contentPadding = paddingValues
    ) {
        items(events) {
            EventCard(
                event = it,
                onClick = { onNavigateToEventDetail(it.id) }
            )
        }
    }
}

