package com.example.unieventos2.ui.navigation.clientNavigation

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
import com.example.unieventos2.ui.screens.admin.NotificationsScreen
import com.example.unieventos2.ui.screens.client.PQRSCreation
import com.example.unieventos2.ui.screens.client.PurchaseHistory
import com.example.unieventos2.ui.screens.client.PurchaseOrder
import com.example.unieventos2.ui.screens.client.ShoppingCart
import com.example.unieventos2.viewModel.CouponsViewModel
import com.example.unieventos2.viewModel.EventsViewModel
import com.example.unieventos2.viewModel.NotificationsViewModel
import com.example.unieventos2.viewModel.PQRSViewModel
import com.example.unieventos2.viewModel.UsersViewModel
import dev.chrisbanes.haze.HazeState


@Composable
fun NavHostClient(
    navController: NavHostController,
    paddingValues: PaddingValues,
    eventsViewModel: EventsViewModel,
    couponsViewModel: CouponsViewModel,
    PQRSViewModel: PQRSViewModel,
    notificationsViewModel: NotificationsViewModel,
    usersViewModel: UsersViewModel,
    onNavigateToEventDetail: (String) -> Unit,
    hazeState: HazeState,
    userId: String
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        startDestination = ItemTabClient.EventsTab,
        navController = navController,
    ) {
        composable<ItemTabClient.EventsTab> {
            AdminUpcomingEvents(
                onNavigateToEventDetail = onNavigateToEventDetail,
                eventsViewModel = eventsViewModel,
                hazeState = hazeState,
                paddingValues = paddingValues
            )
        }
        composable<ItemTabClient.CouponsTab> {
            CouponsScreen(
                couponsViewModel = couponsViewModel,
                paddingValues = paddingValues,
                hazeState = hazeState,
                onNavigateToCouponDetail = {  }
            )
        }

        composable<ItemTabClient.ManageAccountTab> {
            ManageAccount(
                usersViewModel = usersViewModel,
                paddingValues = paddingValues,
                hazeState = hazeState,
                userId = userId
            )
        }

        composable<ItemTabClient.PQRSTab> {
            PQRSCreation(PQRSViewModel = PQRSViewModel)
        }

        composable<ItemTabClient.NotificationsTab> {
            NotificationsScreen(
                notificationsViewModel = notificationsViewModel,
                paddingValues = paddingValues,
                hazeState = hazeState
            )
        }
        composable<ItemTabClient.ShoppingCartTab> {
            ShoppingCart(
                usersViewModel = usersViewModel,
                userId = userId,
                paddingValues = paddingValues,
                hazeState = hazeState
            )
        }
        composable<ItemTabClient.PurchaseOrderTab> {
            PurchaseOrder(
                usersViewModel = usersViewModel,
                userId = userId,
                paddingValues = paddingValues,
                hazeState = hazeState
            )
        }
        composable<ItemTabClient.PurchaseHistoryTab> {
            PurchaseHistory(
                usersViewModel = usersViewModel,
                userId = userId,
                paddingValues = paddingValues,
                hazeState = hazeState
            )
        }

    }

}