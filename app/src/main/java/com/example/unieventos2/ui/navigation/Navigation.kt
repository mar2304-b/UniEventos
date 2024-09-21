package com.example.unieventos2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unieventos2.ui.screens.AdminNotifications
import com.example.unieventos2.ui.screens.AdminOptions
import com.example.unieventos2.ui.screens.AdminPQRS
import com.example.unieventos2.ui.screens.CouponCreation
import com.example.unieventos2.ui.screens.EventCreation
import com.example.unieventos2.ui.screens.HomeScreen
import com.example.unieventos2.ui.screens.ManageAccount
import com.example.unieventos2.ui.screens.RecoverPassword


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
            AdminOptions()
        }
        composable<RouteScreen.RecoverPassword> {
            RecoverPassword()
        }

        composable<RouteScreen.EventCreation> {
            EventCreation()
        }

        composable<RouteScreen.CouponCreation> {
            CouponCreation()
        }

        composable<RouteScreen.ManageAccount> {
            ManageAccount()
        }

        composable<RouteScreen.AdminPQRS> {
            AdminPQRS()
        }

        composable<RouteScreen.AdminNotifications> {
            AdminNotifications()
        }

    }

}