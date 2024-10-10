package com.example.unieventos2.ui.navigation.adminNavigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.unieventos2.ui.screens.ManageAccount
import com.example.unieventos2.ui.screens.admin.AdminUpcomingEvents
import com.example.unieventos2.ui.screens.admin.CouponsScreen
import com.example.unieventos2.ui.screens.admin.NotificationCreation
import com.example.unieventos2.ui.screens.admin.NotificationsScreen
import com.example.unieventos2.ui.screens.admin.PQRSScreen
import com.example.unieventos2.viewModel.CouponsViewModel
import com.example.unieventos2.viewModel.EventsViewModel
import com.example.unieventos2.viewModel.NotificationsViewModel
import com.example.unieventos2.viewModel.PQRSViewModel
import com.example.unieventos2.viewModel.UsersViewModel
import dev.chrisbanes.haze.HazeState

@Composable
fun NavHostAdmin(
    navController: NavHostController,
    paddingValues: PaddingValues,
    eventsViewModel: EventsViewModel,
    couponsViewModel: CouponsViewModel,
    PQRSViewModel: PQRSViewModel,
    notificationsViewModel: NotificationsViewModel,
    usersViewModel: UsersViewModel,
    onNavigateToEventDetail: (Int) -> Unit,
    onNavigateToCouponDetail: (Int) -> Unit,
    hazeState: HazeState,
    userId: Int
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        startDestination = ItemTabAdmin.EventsTab,
        navController = navController,
    ) {
        composable<ItemTabAdmin.EventsTab> {
            AdminUpcomingEvents(
                onNavigateToEventDetail = onNavigateToEventDetail,
                eventsViewModel = eventsViewModel,
                hazeState = hazeState,
                paddingValues = paddingValues
            )
        }

        composable<ItemTabAdmin.CouponsTab> {
            CouponsScreen(
                couponsViewModel = couponsViewModel,
                paddingValues = paddingValues,
                onNavigateToCouponDetail = { onNavigateToCouponDetail },
                hazeState = hazeState
            )
        }

        composable<ItemTabAdmin.PQRSTab> {
            PQRSScreen(
                PQRSViewModel = PQRSViewModel,
                paddingValues = paddingValues,
                hazeState = hazeState
            )
        }

        composable<ItemTabAdmin.NotificationsTab> {
            NotificationCreation(
                onNavigateToCreateNotification = { /*TODO*/ },
                notificationsViewModel = notificationsViewModel
            )
        }
        composable<ItemTabAdmin.ManageAccountTab> {
         ManageAccount(
             usersViewModel = usersViewModel,
             paddingValues = paddingValues,
             hazeState = hazeState,
             userId = userId
         )
        }
    }

}