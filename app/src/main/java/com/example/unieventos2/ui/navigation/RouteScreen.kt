package com.example.unieventos2.ui.navigation

import kotlinx.serialization.Serializable

sealed class RouteScreen {
    @Serializable
    data object HomeScreen: RouteScreen()

    @Serializable
    data object AdminOptions: RouteScreen()

    @Serializable
    data object RecoverPassword: RouteScreen()

    @Serializable
    data object EventCreation: RouteScreen()

    @Serializable
    data object CouponCreation: RouteScreen()

    @Serializable
    data object ManageAccount: RouteScreen()

    @Serializable
    data object AdminPQRS: RouteScreen()

    @Serializable
    data object AdminNotifications: RouteScreen()

}