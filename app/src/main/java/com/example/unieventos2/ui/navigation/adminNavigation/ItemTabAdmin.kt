package com.example.unieventos2.ui.navigation.adminNavigation

import kotlinx.serialization.Serializable

sealed class ItemTabAdmin{
    @Serializable
    data object EventsTab: ItemTabAdmin()

    @Serializable
    data object CouponsTab: ItemTabAdmin()

    @Serializable
    data object PQRSTab: ItemTabAdmin()

    @Serializable
    data object NotificationsTab: ItemTabAdmin()

    @Serializable
    data object ManageAccountTab: ItemTabAdmin()
}
