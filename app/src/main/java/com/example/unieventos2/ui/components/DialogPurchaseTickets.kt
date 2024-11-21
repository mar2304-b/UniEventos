package com.example.unieventos2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unieventos2.R
import com.example.unieventos2.models.Order
import com.example.unieventos2.models.OrderItem
import com.example.unieventos2.utils.RequestResult
import com.example.unieventos2.utils.SharedPreferencesUtils
import com.example.unieventos2.viewModel.OrdersViewModel
import com.example.unieventos2.viewModel.ShoppingCartViewModel
import kotlinx.coroutines.delay
import java.time.LocalDateTime

@Composable
fun DialogPurchaseTickets(
    shoppingCartViewModel: ShoppingCartViewModel,
    ordersViewModel: OrdersViewModel = viewModel(),
    onDismiss: () -> Unit
) {
    val orderResult by ordersViewModel.orderResult.collectAsState()
    val context = LocalContext.current
    val userId = SharedPreferencesUtils.getCurrentUser(context)?.id
    val items = shoppingCartViewModel.getCartItems()
        .map {
            OrderItem(
                eventId = it.eventId,
                quantity = it.quantity,
                price = it.price,
                localityName = it.localityName
            )
        }
    var showDiscount by remember { mutableStateOf(false) }
    var coupon by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    ordersViewModel.createOrder(
                        Order(
                            date = LocalDateTime.now().toString(),
                            total = shoppingCartViewModel.getTotal(),
                            userId = userId!!,
                            items = items
                        )
                    )
                    onDismiss()
                }
            ) {
                Text(text = stringResource(id = R.string.confirm))
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(text = stringResource(id = R.string.cancel))
            }
        },
        title = {
            Text(text = stringResource(id = R.string.purchaseOrder))
        },

        text = {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = coupon ,
                        onValueChange = {coupon = it},
                        label = { Text(text = stringResource(id = R.string.coupon)) },
                        singleLine = true,
                        modifier = Modifier.weight(0.5f),
                        placeholder = {Text(text = stringResource(id = R.string.coupon))}
                    )
                    TextButton(
                        modifier = Modifier.weight(1f),
                        onClick = { showDiscount = !showDiscount }
                    ) {
                        Text(text = stringResource(id = R.string.confirm))
                    }
                }
                if (showDiscount) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Subtotal: ${shoppingCartViewModel.getTotal()}",
                        style = MaterialTheme.typography.bodyLarge,
                        textDecoration = TextDecoration.LineThrough,
                        textAlign = TextAlign.End
                    )
                }else{
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Subtotal: ${shoppingCartViewModel.getTotal()}",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.End
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                when(orderResult){
                    null -> {}
                    is RequestResult.Loading -> {
                        LinearProgressIndicator()
                    }
                    is RequestResult.Succes -> {
                        AlertMessage(
                            type = AlertType.SUCCESS,
                            message = (orderResult as RequestResult.Succes).message
                        )
                        LaunchedEffect(Unit) {
                            delay(7000)
                            onDismiss
                            shoppingCartViewModel.clearCart()
                        }
                    }
                    is RequestResult.Error ->{
                        AlertMessage(
                            type = AlertType.ERROR,
                            message = (orderResult as RequestResult.Error).messageError
                        )
                        LaunchedEffect(Unit) {
                            delay(5000)
                            ordersViewModel.resetOrderResult()
                        }
                    }
                }
            }
        }
    )
}
