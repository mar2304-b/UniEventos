package com.example.unieventos2.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unieventos2.R
import com.example.unieventos2.models.User
import com.example.unieventos2.ui.components.PersonalInformation
import com.example.unieventos2.viewModel.UsersViewModel
import dev.chrisbanes.haze.HazeState

@Composable
fun ManageAccount(
    usersViewModel: UsersViewModel,
    paddingValues: PaddingValues,
    hazeState: HazeState,
    userId: String
) {
    val scrollState = rememberScrollState()
    var user by remember {
        mutableStateOf(User())
    }
    LaunchedEffect(userId) {
        user = usersViewModel.getUserById(userId)!!
    }

    var email by rememberSaveable { mutableStateOf(user.email) }
    var name by rememberSaveable { mutableStateOf(user.name) }
    var address by rememberSaveable { mutableStateOf(user.address) }
    var telephone by rememberSaveable { mutableStateOf(user.telephone) }
    var password by rememberSaveable { mutableStateOf(user.password) }

    val context = LocalContext.current

    LaunchedEffect(user) {
        email = user.email
        name = user.name
        address = user.address
        telephone = user.telephone
        password = user.password

    }

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = stringResource(id = R.string.manageAccount),
                color = androidx.compose.ui.graphics.Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))
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
                    val updatedUser = User(
                        id = userId,
                        name = name,
                        email = email,
                        telephone = telephone,
                        password = password,
                        address = address,
                        role = user.role
                    )
                    usersViewModel.updateUser(updatedUser)
                    Toast.makeText(context, "Cuenta editada exitosamente", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.edit))
            }

        }

    }
}


