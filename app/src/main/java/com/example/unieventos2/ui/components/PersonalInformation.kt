package com.example.unieventos2.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.sharp.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R

@Composable
fun PersonalInformation() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            imageVector = Icons.Rounded.AccountCircle,
            contentDescription = "Icono de cuenta",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Correo electronico:")
            OutlinedTextField(
                value = "" ,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Nombre completo:")
            OutlinedTextField(
                value = "" ,
                singleLine = true,
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Dirección:")
            OutlinedTextField(
                value = "",
                singleLine = true,
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Teléfono:")
            OutlinedTextField(
                value = "",
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Contraseña:")
            OutlinedTextField(
                value = "",
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = {}
            )
        }
    }
}

