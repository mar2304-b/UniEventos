package com.example.unieventos2.ui.screens.admin

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.unieventos2.ui.components.CouponCard
import com.example.unieventos2.viewModel.CouponsViewModel
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze

@Composable
fun CouponsScreen(
    couponsViewModel: CouponsViewModel,
    paddingValues: PaddingValues,
    onNavigateToCouponDetail: (Int) -> Unit,
    hazeState: HazeState
) {

    val coupons = couponsViewModel.coupons.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .haze(
                state = hazeState,
                style = HazeDefaults.style(backgroundColor = MaterialTheme.colorScheme.surface)
            ),
        contentPadding = paddingValues
    ) {
        items(coupons) {
            CouponCard(
                coupon = it,
                onClick = { onNavigateToCouponDetail(it.id) }
            )
        }
    }
}