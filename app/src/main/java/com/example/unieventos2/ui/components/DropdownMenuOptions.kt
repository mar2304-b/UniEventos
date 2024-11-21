package com.example.unieventos2.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.unieventos2.ui.navigation.clientNavigation.NavItem

@Composable
fun DropdownMenuOptions(
    navHostController: NavHostController
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
    }

    DropdownMenu(
        expanded = expanded, onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = { Text(text = "Editar Cuenta") },
            onClick = {
                expanded = false
                navHostController.navigate(NavItem.ManageAccount.route)
            }
        )

        DropdownMenuItem(
            text = { Text(text = "Carrito de Compras") },
            onClick = {
                expanded = false
                navHostController.navigate(NavItem.ShoppingCart.route)
            }
        )

        DropdownMenuItem(
            text = { Text(text = "Orden de Compra") },
            onClick = {
                expanded = false
                navHostController.navigate(NavItem.PurchaseOrder.route)
            }
        )

        DropdownMenuItem(
            text = { Text(text = "Historial de Compras") },
            onClick = {
                expanded = false
                navHostController.navigate(NavItem.PurchaseHistory.route)
            }
        )

    }
}
