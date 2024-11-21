package com.example.unieventos2.ui.screens.client

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
fun PurchaseHistory(
    usersViewModel: UsersViewModel,
    userId: String,
    paddingValues: PaddingValues,
    hazeState: HazeState
) {
    val scrollState = rememberScrollState()
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.purchaseHistory),
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
                Text(text = stringResource(id = R.string.total))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.priceDescription),
                    singleLine = true,
                    onValueChange = {},
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(text = stringResource(id = R.string.orderCode))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.orderNumber2),
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = stringResource(id = R.string.total))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.priceDescription),
                    singleLine = true,
                    onValueChange = {},
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(text = stringResource(id = R.string.orderCode))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.orderNumber3),
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = stringResource(id = R.string.total))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.priceDescription),
                    singleLine = true,
                    onValueChange = {},
                )
            }

        }
    }
}
