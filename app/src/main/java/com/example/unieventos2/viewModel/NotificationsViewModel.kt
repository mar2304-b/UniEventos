package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unieventos2.models.CartItem
import com.example.unieventos2.models.Coupon
import com.example.unieventos2.models.Event
import com.example.unieventos2.models.Notification
import com.example.unieventos2.models.User
import com.example.unieventos2.utils.RequestResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class NotificationsViewModel: ViewModel() {
    val db = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()
    private val _notifications = MutableStateFlow(emptyList<Notification>())
    val notifications: StateFlow<List<Notification>> = _notifications.asStateFlow()

    init {
        loadNotifications()
    }
    private fun loadNotifications(){
        viewModelScope.launch {
            _notifications.value = getNotificationList()
        }
    }

    fun getNotifications(): List<Notification> {
        return _notifications.value
    }

    suspend fun getNotificationById(id: String): Notification? {
        val snapshot = db.collection("notifications").document(id).get().await()
        val notification = snapshot.toObject(Notification::class.java)
        notification?.id = snapshot.id
        return notification
    }

    fun createNotification(notification: Notification) {
        viewModelScope.launch {
            db.collection("notifications").add(notification).await()
            loadNotifications()
        }
    }

    suspend fun getNotificationList(): List<Notification> {
        val snapshot = db.collection("notifications").get().await()
        return snapshot.documents.mapNotNull {
            val notification = it.toObject(Notification::class.java)
            requireNotNull(notification)
            notification.id = it.id
            notification
        }
    }

}