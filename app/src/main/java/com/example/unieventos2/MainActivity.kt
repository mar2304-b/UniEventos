package com.example.unieventos2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unieventos2.ui.navigation.Navigation


import com.example.unieventos2.ui.screens.HomeScreen
import com.example.unieventos2.ui.screens.ManageAccount


import com.example.unieventos2.ui.screens.RecoverPassword
import com.example.unieventos2.ui.screens.admin.CouponCreation


import com.example.unieventos2.ui.theme.Unieventos2Theme
import com.example.unieventos2.viewModel.CouponsViewModel
import com.example.unieventos2.viewModel.EventsViewModel
import com.example.unieventos2.viewModel.NotificationsViewModel
import com.example.unieventos2.viewModel.PQRSViewModel
import com.example.unieventos2.viewModel.UsersViewModel

class MainActivity : ComponentActivity() {

    private val usersViewModel: UsersViewModel by viewModels()
    private val eventsViewModel: EventsViewModel by viewModels()
    private val couponsViewModel: CouponsViewModel by viewModels()
    private val pqrsViewModel: PQRSViewModel by viewModels()
    private val notificationsViewModel: NotificationsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unieventos2Theme {
                Navigation(
                    usersViewModel = usersViewModel,
                    eventsViewModel = eventsViewModel,
                    pqrsViewModel = pqrsViewModel,
                    notificationsViewModel = notificationsViewModel,
                    couponsViewModel = couponsViewModel
                )

            }
        }
    }
}

