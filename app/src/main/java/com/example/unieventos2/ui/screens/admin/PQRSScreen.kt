package com.example.unieventos2.ui.screens.admin

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.unieventos2.ui.components.CouponCard
import com.example.unieventos2.ui.components.PQRSCard
import com.example.unieventos2.viewModel.PQRSViewModel
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze

@Composable
fun PQRSScreen(
    PQRSViewModel: PQRSViewModel,
    paddingValues: PaddingValues,
    hazeState: HazeState
) {

    val pqrs = PQRSViewModel.pqrs.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .haze(
                state = hazeState,
                style = HazeDefaults.style(backgroundColor = MaterialTheme.colorScheme.surface)
            ),
        contentPadding = paddingValues
    ) {
        items(pqrs) {
            PQRSCard(
                pqrs = it,
            )
        }
    }
}