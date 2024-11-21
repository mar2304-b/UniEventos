package com.example.unieventos2.ui.navigation.clientNavigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomBarHomeClient(
    navHostController: NavHostController,
    onTabSelected: (Int) -> Unit,
) {
    val items = listOf(
        NavItem.Events,
        NavItem.Coupons,
        NavItem.PQRS,
        NavItem.Notifications,
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = navBackStackEntry?.destination?.hasRoute(item.route::class) ?: false,
                onClick = {
                    onTabSelected(index)
                    navHostController.navigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(id = item.label))
                },
            )
        }
    }

}