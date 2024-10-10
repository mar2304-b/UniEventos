package com.example.unieventos2.ui.navigation

import kotlinx.serialization.Serializable

sealed class RouteScreen {
    @Serializable
    data object HomeScreen : RouteScreen()

    @Serializable
    data object AdminHome : RouteScreen()

    @Serializable
    data object RecoverPassword : RouteScreen()

    @Serializable
    data object EventCreation : RouteScreen()

    @Serializable
    data object CouponCreation : RouteScreen()

    @Serializable
    data class CouponDetail(val couponId: Int) : RouteScreen()

    @Serializable
    data object ManageAccount : RouteScreen()

    @Serializable
    data object AdminPQRS : RouteScreen()

    @Serializable
    data object AdminNotifications : RouteScreen()

    @Serializable
    data object AdminUpcomingEvents : RouteScreen()

    @Serializable
    data class AdminEventDetail(val eventId: Int) : RouteScreen()

    @Serializable
    data object ClientHome : RouteScreen()

    @Serializable
    data class ClientEventDetail(val eventId: Int) : RouteScreen()

    @Serializable
    data object ClientOptions : RouteScreen()

    @Serializable
    data object ClientNotifications : RouteScreen()

    @Serializable
    data object ClientPQRS : RouteScreen()

    @Serializable
    data object ClientUpcomingEvents : RouteScreen()

    @Serializable
    data object PurchaseHistory : RouteScreen()

    @Serializable
    data object PurchaseOrder : RouteScreen()

    @Serializable
    data object SelectedEvent : RouteScreen()

    @Serializable
    data object ShoppingCart : RouteScreen()

    @Serializable
    data object Registration : RouteScreen()


}