package com.example.unieventos2.ui.screens

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R
import com.example.unieventos2.models.Role
import com.example.unieventos2.ui.components.AlertMessage
import com.example.unieventos2.ui.components.AlertType
import com.example.unieventos2.ui.components.TextFieldForm
import com.example.unieventos2.utils.RequestResult
import com.example.unieventos2.utils.SharedPreferencesUtils
import com.example.unieventos2.viewModel.UsersViewModel
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    usersViewModel: UsersViewModel,
    onNavigateToHome: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onNavigateToForgotMyPassword: () -> Unit
) {
    val authResult by usersViewModel.authResult.collectAsState()
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var code by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val scrollState = rememberScrollState()


    Scaffold { padding ->

        Column() {

            Spacer(
                modifier = Modifier
                    .height(30.dp)
                    .verticalScroll(scrollState)
            )
            Text(
                text = stringResource(id = R.string.welcome),
                color = androidx.compose.ui.graphics.Color.Black,
                fontSize = 33.sp,
                textAlign = TextAlign.Center,

                )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxWidth()

            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.description),
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(id = R.string.imageDescription),
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)

                )
            }
        }

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom

        ) {
            Spacer(modifier = Modifier.height(10.dp))
            TextFieldForm(
                value = email,
                onValueChange = {
                    email = it
                },
                supportingText = stringResource(id = R.string.emailValidation),
                label = stringResource(id = R.string.labelEmail),
                onValidate = {
                    !Patterns.EMAIL_ADDRESS.matcher(it).matches()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                )

            Spacer(modifier = Modifier.height(10.dp))
            TextFieldForm(
                value = password,
                onValueChange = {
                    password = it
                },
                supportingText = stringResource(id = R.string.passwordValidation),
                label = stringResource(id = R.string.labelPassword),
                onValidate = {
                    password.length < 7
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isPassword = true
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.code))
            OutlinedTextField(
                value = code,
                singleLine = true,
                onValueChange = {
                    code = it
                }
            )
            val emailText = stringResource(id = R.string.emailText)
            val emailToast = stringResource(id = R.string.emailToast)

            Button(

                enabled = email.isNotEmpty() && password.isNotEmpty(),
                onClick = {
                    usersViewModel.login(email, password)
                }

            ) {
                Text(text = stringResource(id = R.string.loginButton))
            }


            Button(onClick = {
                onNavigateToRegister()

            }
            ) {
                Text(text = stringResource(id = R.string.registerButton))

            }


            Button(onClick = {
                onNavigateToForgotMyPassword()
            }
            ) {
                Text(text = stringResource(id = R.string.forgetMyPasswordButton))

            }

            when (authResult) {
                is RequestResult.Loading -> {
                    LinearProgressIndicator()
                }

                is RequestResult.Succes -> {
                    AlertMessage(type = AlertType.SUCCESS, message = (authResult as RequestResult.Succes).message)
                    LaunchedEffect(Unit) {
                        delay(2000)
                        onNavigateToHome()
                        usersViewModel.resetAuthResult()
                    }
                }
                is RequestResult.Error -> {
                    AlertMessage(type = AlertType.ERROR, message = (authResult as RequestResult.Error).messageError)
                    LaunchedEffect(Unit) {
                        delay(2000)
                        usersViewModel.resetAuthResult()
                    }
                }
                null -> {}
            }
        }

    }

}