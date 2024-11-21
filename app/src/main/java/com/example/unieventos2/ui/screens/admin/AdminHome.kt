package com.example.unieventos2.ui.screens.admin

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Logout
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.unieventos2.ui.navigation.adminNavigation.BottomBarHomeAdmin
import com.example.unieventos2.ui.navigation.adminNavigation.NavHostAdmin
import com.example.unieventos2.viewModel.CouponsViewModel
import com.example.unieventos2.viewModel.EventsViewModel
import com.example.unieventos2.viewModel.NotificationsViewModel
import com.example.unieventos2.viewModel.PQRSViewModel
import com.example.unieventos2.viewModel.UsersViewModel
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHome(
    eventsViewModel: EventsViewModel,
    couponsViewModel: CouponsViewModel,
    PQRSViewModel: PQRSViewModel,
    notificationsViewModel: NotificationsViewModel,
    usersViewModel: UsersViewModel,
    onNavigateToCreateEvent: () -> Unit,
    onNavigateToEventDetail: (String) -> Unit,
    onNavigateToCreateCoupon: () -> Unit,
    onNavigateToCouponDetail: (String) -> Unit,
    onLogout: () -> Unit,
    userId: String
) {
    val hazeState = remember { HazeState() }
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    when (selectedTab) {
                        0 -> "Eventos"
                        1 -> "Cupones"
                        2 -> "PQRS"
                        3 -> "Notificaciones"
                        4 -> "Editar perfil"
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(Color.Transparent),
                modifier = Modifier
                    .hazeChild(hazeState),
                actions = {
                    IconButton(
                        onClick = { onLogout() }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.Logout,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            if (selectedTab == 0 || selectedTab == 1) {
                FloatingActionButton(
                    onClick = {
                        when (selectedTab) {
                            0 -> onNavigateToCreateEvent()
                            1 -> onNavigateToCreateCoupon()
                        }
                    },
                    containerColor = Color(0xFFF1E6F9)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        },
        bottomBar = {
            BottomBarHomeAdmin(
                navHostController = navController,
                onTabSelected = { selectedTab = it }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { paddingValues ->
        NavHostAdmin(
            navController = navController,
            paddingValues = paddingValues,
            eventsViewModel = eventsViewModel,
            couponsViewModel = couponsViewModel,
            PQRSViewModel = PQRSViewModel,
            notificationsViewModel = notificationsViewModel,
            usersViewModel = usersViewModel,
            onNavigateToEventDetail = onNavigateToEventDetail,
            onNavigateToCouponDetail = onNavigateToCouponDetail,
            hazeState = hazeState,
            userId = userId
        )
    }
}