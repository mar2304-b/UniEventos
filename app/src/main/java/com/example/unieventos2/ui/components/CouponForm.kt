package com.example.unieventos2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unieventos2.R

@Composable

fun CouponForm(
    name:String,
    onNameChange: (String) ->Unit,
    percentage: Int,
    onPercentageChange: (String) ->Unit,
    code: String,
    onCodeChange: (String) ->Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {

        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = code,
            onValueChange = onCodeChange,
            label = { Text("Código") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = percentage.toString(),
            onValueChange = onPercentageChange,
            label = { Text("Porcentaje") },
            modifier = Modifier.fillMaxWidth()
        )

    }
}