package com.example.unieventos2.ui.screens.admin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R
import com.example.unieventos2.models.Coupon
import com.example.unieventos2.viewModel.CouponsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CouponCreation(
    couponsViewModel: CouponsViewModel
) {
    val context = LocalContext.current
    var name by rememberSaveable {
        mutableStateOf("")
    }
    var code by rememberSaveable {
        mutableStateOf("")
    }
    var percentage by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.couponCreation),
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.cupones),
                contentDescription = stringResource(id = R.string.imageDescription),
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = stringResource(id = R.string.couponName))
            TextField(
                value = name,
                singleLine = true,
                onValueChange = {name = it},
                modifier = Modifier.width(300.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = stringResource(id = R.string.couponCode))
            TextField(
                value = code,
                singleLine = true,
                onValueChange = {code = it},
                modifier = Modifier.width(190.dp),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = stringResource(id = R.string.discount))
            TextField(
                value = percentage,
                singleLine = true,
                onValueChange = {percentage = it},
                modifier = Modifier.width(190.dp),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    val coupon = Coupon(
                        name = name,
                        code = code,
                        percentage = percentage.toInt(),

                    )
                    couponsViewModel.createCoupon(coupon)
                    Toast.makeText(context, "Cupón publicado exitosamente", Toast.LENGTH_LONG).show()
                }
            ) {
                Text(text = stringResource(id = R.string.post))
            }
        }
    }
}