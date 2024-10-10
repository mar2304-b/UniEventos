package com.example.unieventos2.ui.screens.client

import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R
import com.example.unieventos2.viewModel.UsersViewModel
import dev.chrisbanes.haze.HazeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchaseOrder(
    usersViewModel: UsersViewModel,
    userId: Int,
    paddingValues: PaddingValues,
    hazeState: HazeState
) {
    var transferenciaChecked by remember { mutableStateOf(false) }
    var puntosFalabellaChecked by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.purchaseOrder),
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(text = stringResource(id = R.string.orderCode))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.orderNumber1),
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = stringResource(id = R.string.clientCode))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.orderNumber3),
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(text = stringResource(id = R.string.eventCode))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.eventNumber),
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = stringResource(id = R.string.locality))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.numberLocality),
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(text = stringResource(id = R.string.units))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.numberLocality),
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = stringResource(id = R.string.individualPrice))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.priceDescription),
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = stringResource(id = R.string.coupon))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.couponNumber),
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = stringResource(id = R.string.total))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.priceDescription),
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = stringResource(id = R.string.date))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.dateDescription),
                    singleLine = true,
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = stringResource(id = R.string.meansOfPayment))

                Row {
                    Checkbox(
                        checked = transferenciaChecked,
                        onCheckedChange = { transferenciaChecked = it }
                    )
                    Text(text = stringResource(id = R.string.meansOfPayment1))
                    Spacer(modifier = Modifier.width(20.dp))
                    Checkbox(
                        checked = puntosFalabellaChecked,
                        onCheckedChange = { puntosFalabellaChecked = it }
                    )
                    Text(text = stringResource(id = R.string.meansOfPayment2))
                }
            }
        }
    }
}
