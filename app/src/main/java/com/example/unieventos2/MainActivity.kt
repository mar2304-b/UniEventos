package com.example.unieventos2

import ShoppingCart
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unieventos2.ui.navigation.Navigation
import com.example.unieventos2.ui.screens.AdminNotifications
import com.example.unieventos2.ui.screens.AdminPQRS
import com.example.unieventos2.ui.screens.AdminUpcomingEvents
import com.example.unieventos2.ui.screens.ClientNotifications
import com.example.unieventos2.ui.screens.ClientOptions
import com.example.unieventos2.ui.screens.ClientPQRS
import com.example.unieventos2.ui.screens.ClientUpcomingEvents
import com.example.unieventos2.ui.screens.CouponCreation
import com.example.unieventos2.ui.screens.EventCreation
import com.example.unieventos2.ui.screens.HomeScreen
import com.example.unieventos2.ui.screens.ManageAccount
import com.example.unieventos2.ui.screens.AdminOptions
import com.example.unieventos2.ui.screens.PurchaseHistory
import com.example.unieventos2.ui.screens.PurchaseOrder
import com.example.unieventos2.ui.screens.RecoverPassword
import com.example.unieventos2.ui.screens.Registration
import com.example.unieventos2.ui.screens.SelectedEvent

import com.example.unieventos2.ui.theme.Unieventos2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unieventos2Theme {
                //HomeScreen()
                //Registration()
                //PurchaseHistory()
                //PurchaseOrder()
                //RecoverPassword()
                //CouponCreation()
                //ShoppingCart()
                //ManageAccount()
                //EventCreation()
                //SelectedEvent()
                //ClientOptions()
                //AdminPQRS()
                //ClientPQRS()
                //AdminNotifications()
                //ClientNotifications()
                //ClientUpcomingEvents()
                //AdminUpcomingEvents()
                Navigation()


            }
        }
    }
}

