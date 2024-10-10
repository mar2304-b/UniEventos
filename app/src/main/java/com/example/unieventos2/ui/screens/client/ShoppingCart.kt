package com.example.unieventos2.ui.screens.client

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R
import com.example.unieventos2.viewModel.UsersViewModel
import dev.chrisbanes.haze.HazeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCart(
    //onNavigateToConfirmEditions: ()-> Unit,
    //onNavigateToGoToPurchaseOrder: ()-> Unit,
    userId: Int,
    usersViewModel: UsersViewModel,
    paddingValues: PaddingValues,
    hazeState: HazeState
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.shoppingCart),
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                Text(text = stringResource(id = R.string.orderCode))
                Text(text = stringResource(id = R.string.orderNumber1))
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.eventGeneralInformation),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = stringResource(id = R.string.selectedLocality))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.VIP),
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = stringResource(id = R.string.date))
                Text(text = stringResource(id = R.string.dateDescription))
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = stringResource(id = R.string.address))
                Text(text = stringResource(id = R.string.addressDescription))
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = stringResource(id = R.string.tickets))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.amountTickets),
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = com.example.unieventos2.R.drawable.localidades),
                contentDescription = stringResource(id = R.string.titleEvent),
                modifier = Modifier.size(600.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = stringResource(id = R.string.couponMessage))
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = stringResource(id = R.string.couponNumber),
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }
        }
    }
}


