package com.example.unieventos2.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.unieventos2.models.Role
import com.example.unieventos2.ui.screens.HomeScreen
import com.example.unieventos2.ui.screens.ManageAccount
import com.example.unieventos2.ui.screens.RecoverPassword
import com.example.unieventos2.ui.screens.admin.AdminHome
import com.example.unieventos2.ui.screens.admin.AdminPQRS
import com.example.unieventos2.ui.screens.admin.CouponDetail
import com.example.unieventos2.ui.screens.admin.EventCreation
import com.example.unieventos2.ui.screens.admin.AdminEventDetail
import com.example.unieventos2.ui.screens.admin.CouponCreation
import com.example.unieventos2.ui.screens.client.ClientEventDetail
import com.example.unieventos2.ui.screens.client.ClientHome
import com.example.unieventos2.ui.screens.client.Registration
import com.example.unieventos2.utils.SharedPreferencesUtils
import com.example.unieventos2.viewModel.CouponsViewModel
import com.example.unieventos2.viewModel.EventsViewModel
import com.example.unieventos2.viewModel.NotificationsViewModel
import com.example.unieventos2.viewModel.PQRSViewModel
import com.example.unieventos2.viewModel.UsersViewModel
import dev.chrisbanes.haze.HazeState

@Composable
fun Navigation(
    usersViewModel: UsersViewModel,
    eventsViewModel: EventsViewModel,
    pqrsViewModel: PQRSViewModel,
    notificationsViewModel: NotificationsViewModel,
    couponsViewModel: CouponsViewModel,
) {

    val context = LocalContext.current
    val currentUser by usersViewModel.currentUser.collectAsState()
    val navController = rememberNavController()

    var startDestination: RouteScreen = RouteScreen.HomeScreen
    val session = SharedPreferencesUtils.getCurrentUser(context)

    if (session != null) {
        startDestination = when (session.role) {
            Role.ADMIN -> RouteScreen.AdminHome
            Role.CLIENT -> RouteScreen.ClientHome
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<RouteScreen.HomeScreen> {
            HomeScreen(
                usersViewModel = usersViewModel,
                onNavigateToHome = {
                    val user = currentUser
                    if (user != null){
                        val role = user.role
                        SharedPreferencesUtils.savePreferences(context, user.id, role)
                        val home = if (role == Role.ADMIN) {
                            RouteScreen.AdminHome
                        } else {
                            RouteScreen.ClientHome
                        }
                        navController.navigate(home) {
                            popUpTo(0) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                },
                onNavigateToForgotMyPassword = {
                    navController.navigate(RouteScreen.RecoverPassword)
                },
                onNavigateToRegister = {
                    navController.navigate(RouteScreen.Registration)
                }
            )
        }

        composable<RouteScreen.Registration> {
            Registration(usersViewModel = usersViewModel, onNavigateToHome ={navController.navigate(RouteScreen.ClientHome)})
        }

        composable<RouteScreen.AdminHome> {
            AdminHome(
                eventsViewModel = eventsViewModel,
                couponsViewModel = couponsViewModel,
                PQRSViewModel = pqrsViewModel,
                notificationsViewModel = notificationsViewModel,
                usersViewModel = usersViewModel,
                onNavigateToCreateEvent = { navController.navigate(RouteScreen.EventCreation) },
                onNavigateToEventDetail = { eventId ->
                    navController.navigate(RouteScreen.AdminEventDetail(eventId))
                },
                onNavigateToCreateCoupon = { navController.navigate(RouteScreen.CouponCreation) },
                onNavigateToCouponDetail = { couponId ->
                    navController.navigate(RouteScreen.CouponDetail(couponId))
                },
                userId = session?.id ?: "",
                onLogout = {
                    SharedPreferencesUtils.clearPreferences(context)
                    navController.navigate(RouteScreen.HomeScreen) {
                        popUpTo(0) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<RouteScreen.EventCreation> {
            EventCreation(
                onNavigateToCreation = {
                    navController.navigate(RouteScreen.AdminUpcomingEvents)
                },
                onNavigateToConfirm = {
                    navController.navigate(RouteScreen.EventCreation)
                },
                eventsViewModel = eventsViewModel
            )
        }

        composable<RouteScreen.AdminEventDetail> {
            val eventId = it.toRoute<RouteScreen.AdminEventDetail>()
            AdminEventDetail(
                eventsViewModel = eventsViewModel,
                eventId = eventId.eventId
            )
        }

        composable<RouteScreen.RecoverPassword> {
            RecoverPassword(
            )
        }

        composable<RouteScreen.AdminPQRS> {
            AdminPQRS(
                onNavigateToCreatePQRS = {
//                    navController.navigate(RouteScreen.AdminOptions)
                }
            )
        }

        composable<RouteScreen.CouponCreation> {
            CouponCreation (
                couponsViewModel = couponsViewModel
            )
        }

        composable<RouteScreen.CouponDetail> {
            val couponId = it.toRoute<RouteScreen.CouponDetail>()
            CouponDetail(
                couponsViewModel = couponsViewModel,
                couponId = couponId.couponId
            )
        }

        composable<RouteScreen.ClientHome> {
            ClientHome(
                eventsViewModel = eventsViewModel,
                onNavigateToEventDetail = { eventId ->
                    navController.navigate(RouteScreen.ClientEventDetail(eventId))
                },
                couponsViewModel = couponsViewModel,
                PQRSViewModel = pqrsViewModel,
                notificationsViewModel = notificationsViewModel,
                usersViewModel = usersViewModel,
                userId = session?.id ?: "",

                onLogout = {
                    SharedPreferencesUtils.clearPreferences(context)
                    navController.navigate(RouteScreen.HomeScreen) {
                        popUpTo(0) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
            )
        }


        composable<RouteScreen.ClientEventDetail> {
            val eventId = it.toRoute<RouteScreen.ClientEventDetail>()
            ClientEventDetail(
                eventsViewModel = eventsViewModel,
                eventId = eventId.eventId
            )
        }
        

//        composable<RouteScreen.No> {
//            NotificationDetail(
//                onNavigateToCreateNotifications = {
//                    navController.navigate(RouteScreen.AdminOptions)
//                }
//            )
//        }

    }

}