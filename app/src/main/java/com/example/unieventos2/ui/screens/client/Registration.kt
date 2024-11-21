package com.example.unieventos2.ui.screens.client

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R
import com.example.unieventos2.models.Role
import com.example.unieventos2.models.User
import com.example.unieventos2.ui.components.PersonalInformation
import com.example.unieventos2.utils.RequestResult
import com.example.unieventos2.viewModel.UsersViewModel


@Composable
fun Registration(
    usersViewModel: UsersViewModel,
    onNavigateToHome: () -> Unit
) {
    val authResult by usersViewModel.authResult.collectAsState()
    val scrollState = rememberScrollState()
    var email by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var telephone by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = stringResource(id = R.string.record),
                color = androidx.compose.ui.graphics.Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            PersonalInformation(
                email = email,
                onEmailChange = { email = it },
                name = name,
                onNameChange = { name = it },
                address = address,
                onAddressChange = { address = it },
                telephone = telephone,
                onTelephoneChange = { telephone = it },
                password = password,
                onPasswordChange = { password = it }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val user = User(
                        name = name,
                        email = email,
                        telephone = telephone,
                        password = password,
                        address = address,
                        role = Role.CLIENT
                    )
                    usersViewModel.createUser(user)
                    Toast.makeText(context, "Registro exitoso, revise el código que llegó a su correo", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.register))
            }
            when(authResult){
                is RequestResult.Loading -> {
                    LinearProgressIndicator()
                }
                is RequestResult.Succes -> {
                    Text(text = (authResult as RequestResult.Succes).message)
                    LaunchedEffect(Unit) {
                        kotlinx.coroutines.delay(2000)
                        onNavigateToHome()
                        usersViewModel.resetAuthResult()

                    }
                }
                is RequestResult.Error -> {
                    Text(text = (authResult as RequestResult.Error).messageError ?: "")
                }
                null -> {}
            }

        }

    }
}