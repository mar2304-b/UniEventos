package com.example.unieventos2.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R
import com.example.unieventos2.ui.components.PersonalInformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecoverPassword() {
    var email by rememberSaveable { mutableStateOf("") }
    var verificationCode by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    Scaffold { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.recoverPassword),
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.width(50.dp))
            Image(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = stringResource(id = R.string.accountIcon),
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = stringResource(id = R.string.email)) }
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = verificationCode,
                onValueChange = { verificationCode = it },
                label = { Text(text = stringResource(id = R.string.verificationCode)) }
            )

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {

                    Toast.makeText(context, "Recuperación exitosa, revise el código que llegó a su correo", Toast.LENGTH_LONG).show()
                }
            ) {
                Text(text = stringResource(id = R.string.recoverPassword))
            }
        }
    }
}
