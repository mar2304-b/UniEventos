package com.example.unieventos2.ui.screens.admin

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unieventos2.R
import com.example.unieventos2.models.Coupon
import com.example.unieventos2.models.Notification
import com.example.unieventos2.ui.components.CouponForm
import com.example.unieventos2.viewModel.CouponsViewModel
import com.example.unieventos2.viewModel.NotificationsViewModel

@Composable
fun CouponDetail(
    couponsViewModel: CouponsViewModel,
    couponId: String
) {

    var coupon by remember { mutableStateOf(Coupon()) }
    LaunchedEffect(couponId) {
        coupon = couponsViewModel.getCouponById(couponId)!!
    }
    var name by rememberSaveable { mutableStateOf(coupon.name) }
    var percentage by rememberSaveable { mutableIntStateOf(coupon.percentage) }
    var code by rememberSaveable { mutableStateOf(coupon.code) }
    val context = LocalContext.current
    LaunchedEffect(coupon) {
        coupon.let {
            name = it.name
            percentage = it.percentage
            code = it.code
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CouponForm(
            name = name,
            onNameChange = { name = it },
            percentage = percentage,
            onPercentageChange = { percentage = it.toInt() },
            code = code,
            onCodeChange = { code = it }
        )

        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    val editCoupon = Coupon(
                        couponId,
                        name,
                        percentage,
                        code
                    )
                    couponsViewModel.editCoupon(editCoupon)


                    Toast.makeText(context, "Cupón editado exitosamente", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = stringResource(id = R.string.edit))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    couponsViewModel.deleteCoupon(coupon)


                    Toast.makeText(context, "Cupón eliminado exitosamente", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = stringResource(id = R.string.delete))
            }
        }
    }
}