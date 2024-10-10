package com.example.unieventos2.ui.navigation.adminNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.unieventos2.R

sealed class NavItem(
    val route: ItemTabAdmin,
    val label: Int,
    val icon: ImageVector
) {
    data object Events: NavItem(
        ItemTabAdmin.EventsTab,
        R.string.eventOption,
        Icons.Default.Collections
    )
    data object Coupons: NavItem(
        ItemTabAdmin.CouponsTab,
        R.string.couponOption,
        Icons.Default.LocalOffer
    )
    data object PQRS: NavItem(
        ItemTabAdmin.PQRSTab,
        R.string.checkPQRS,
        Icons.Default.Message
    )
    data object Notifications: NavItem(
        ItemTabAdmin.NotificationsTab,
        R.string.notificationOption,
        Icons.Default.Notifications
    )
    data object ManageAccount: NavItem(
        ItemTabAdmin.ManageAccountTab,
        R.string.editAccount,
        Icons.Default.AccountCircle
    )
}