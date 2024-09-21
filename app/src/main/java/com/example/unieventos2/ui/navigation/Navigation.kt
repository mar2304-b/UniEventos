package com.example.unieventos2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.unieventos2.ui.screens.HomeScreen
import com.example.unieventos2.ui.screens.ManageAccount
import com.example.unieventos2.ui.screens.RecoverPassword
import com.example.unieventos2.ui.screens.admin.AdminNotifications
import com.example.unieventos2.ui.screens.admin.AdminOptions
import com.example.unieventos2.ui.screens.admin.AdminPQRS
import com.example.unieventos2.ui.screens.admin.AdminUpcomingEvents
import com.example.unieventos2.ui.screens.admin.CouponCreation
import com.example.unieventos2.ui.screens.admin.EventCreation


@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RouteScreen.HomeScreen
    ){
        composable<RouteScreen.HomeScreen> {
            HomeScreen(
                onNavigateToLogin = {
                    navController.navigate(RouteScreen.AdminOptions)},
                onNavigateToRegister = {
                    navController.navigate(RouteScreen.HomeScreen)},
                onNavigateToForgotMyPassword = {
                    navController.navigate(RouteScreen.RecoverPassword)}
            )
        }

        composable<RouteScreen.AdminOptions> {
            AdminOptions(
                onNavigateToManageEvents = {
                navController.navigate(RouteScreen.AdminUpcomingEvents)},
                onNavigateToCouponCreation = {
                    navController.navigate(RouteScreen.CouponCreation)},
                onNavigateToManageAccount = {
                    navController.navigate(RouteScreen.ManageAccount)},
                onNavigateToPQRS = {
                    navController.navigate(RouteScreen.AdminPQRS)},
                onNavigateToNotifications = {
                    navController.navigate(RouteScreen.AdminNotifications)}
                )
        }
        composable<RouteScreen.RecoverPassword> {
            RecoverPassword(
                onNavigateToRecoverPassword = {
                    navController.navigate(RouteScreen.RecoverPassword)}
            )
        }

        composable<RouteScreen.EventCreation> {
            EventCreation(
                onNavigateToCreation = {
                    navController.navigate(RouteScreen.AdminUpcomingEvents)},
                onNavigateToConfirm = {
                    navController.navigate(RouteScreen.EventCreation)}
            )
        }

        composable<RouteScreen.CouponCreation> {
            CouponCreation(
                onNavigateToCreate = {
                    navController.navigate(RouteScreen.AdminOptions)}
            )
        }

        composable<RouteScreen.ManageAccount> {
            ManageAccount(
                onNavigateToEdit = {
                    navController.navigate(RouteScreen.HomeScreen)},
                onNavigateToDelete = {
                    navController.navigate(RouteScreen.HomeScreen)}
            )
        }

        composable<RouteScreen.AdminPQRS> {
            AdminPQRS(
                onNavigateToCreatePQRS = {
                    navController.navigate(RouteScreen.AdminOptions)}
            )
        }

        composable<RouteScreen.AdminNotifications> {
           AdminNotifications(
               onNavigateToCreateNotifications= {
                   navController.navigate(RouteScreen.AdminOptions)
               }
           )

           }


        composable<RouteScreen.AdminUpcomingEvents> {
            AdminUpcomingEvents(
                onNavigateToCreateEvent= {
                    navController.navigate(RouteScreen.EventCreation)},
                onNavigateToEditEvent= {
                    navController.navigate(RouteScreen.EventCreation)},
                onNavigateToDeleteEvent= {
                    navController.navigate(RouteScreen.AdminUpcomingEvents)}
            )
        }

    }

}