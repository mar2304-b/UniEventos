package com.example.unieventos2.ui.navigation.clientNavigation

import kotlinx.serialization.Serializable

sealed class ItemTabClient{
    @Serializable
    data object EventsTab: ItemTabClient()

    @Serializable
    data object CouponsTab: ItemTabClient()

    @Serializable
    data object PQRSTab: ItemTabClient()

    @Serializable
    data object NotificationsTab: ItemTabClient()

    @Serializable
    data object ManageAccountTab: ItemTabClient()

    @Serializable
    data object ShoppingCartTab: ItemTabClient()

    @Serializable
    data object PurchaseOrderTab: ItemTabClient()

    @Serializable
    data object PurchaseHistoryTab: ItemTabClient()


}