package com.example.unieventos2.ui.navigation.clientNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.unieventos2.R
import com.example.unieventos2.ui.navigation.adminNavigation.ItemTabAdmin


sealed class NavItem(
    val route: ItemTabClient,
    val label: Int,
    val icon: ImageVector
) {
    data object Events: NavItem(
        ItemTabClient.EventsTab,
        R.string.eventOption,
        Icons.Default.Collections
    )
    data object Coupons: NavItem(
        ItemTabClient.CouponsTab,
        R.string.couponOption,
        Icons.Default.LocalOffer
    )
    data object PQRS: NavItem(
        ItemTabClient.PQRSTab,
        R.string.checkPQRS,
        Icons.Default.Message
    )
    data object Notifications: NavItem(
        ItemTabClient.NotificationsTab,
        R.string.notificationOption,
        Icons.Default.Notifications
    )
    data object ManageAccount: NavItem(
        ItemTabClient.ManageAccountTab,
        R.string.editAccount,
        Icons.Default.AccountCircle
    )
    data object ShoppingCart: NavItem(
        ItemTabClient.ShoppingCartTab,
        R.string.shoppingCart,
        Icons.Default.ShoppingCart
    )
    data object PurchaseHistory: NavItem(
        ItemTabClient.PurchaseHistoryTab,
        R.string.purchaseHistory,
        Icons.Default.History
    )
    data object PurchaseOrder: NavItem(
        ItemTabClient.PurchaseOrderTab,
        R.string.purchaseOrder,
        Icons.Default.BookmarkBorder
    )
}