package com.example.unieventos2.ui.screens.client

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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.unieventos2.ui.components.DropdownMenuOptions
import com.example.unieventos2.ui.navigation.adminNavigation.BottomBarHomeAdmin
import com.example.unieventos2.ui.navigation.adminNavigation.NavHostAdmin
import com.example.unieventos2.ui.navigation.clientNavigation.BottomBarHomeClient
import com.example.unieventos2.ui.navigation.clientNavigation.NavHostClient
import com.example.unieventos2.viewModel.CouponsViewModel
import com.example.unieventos2.viewModel.EventsViewModel
import com.example.unieventos2.viewModel.NotificationsViewModel
import com.example.unieventos2.viewModel.PQRSViewModel
import com.example.unieventos2.viewModel.UsersViewModel
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientHome(
    eventsViewModel: EventsViewModel,
    couponsViewModel: CouponsViewModel,
    onNavigateToEventDetail: (String) -> Unit,
    PQRSViewModel: PQRSViewModel,
    notificationsViewModel: NotificationsViewModel,
    usersViewModel: UsersViewModel,
    onLogout: () -> Unit,
    userId: String
) {

    val hazeState = remember { HazeState() }
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    var selectedTab by remember { mutableIntStateOf(0) }
    var selectedItem by remember { mutableStateOf("") }


    Scaffold(
        topBar = {

            CenterAlignedTopAppBar(
                title = { },
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
                },
                navigationIcon = {
                    DropdownMenuOptions(
                        navHostController = navController
                    )
                }
            )
        },

        bottomBar = {
            BottomBarHomeClient(
                navHostController = navController,
                onTabSelected = { selectedTab = it }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { paddingValues ->
        NavHostClient(
            navController = navController,
            paddingValues = paddingValues,
            eventsViewModel = eventsViewModel,
            couponsViewModel = couponsViewModel,
            PQRSViewModel = PQRSViewModel,
            notificationsViewModel = notificationsViewModel,
            usersViewModel = usersViewModel,
            onNavigateToEventDetail = onNavigateToEventDetail,
            hazeState = hazeState,
            userId = userId
        )
    }
}