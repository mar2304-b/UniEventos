package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import com.example.unieventos2.models.Notification
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotificationsViewModel: ViewModel() {
    private val _notifications = MutableStateFlow(emptyList<Notification>())
    val notifications: StateFlow<List<Notification>> = _notifications.asStateFlow()

    init {
        _notifications.value = getNotificationList()
    }

    fun getNotificationById(id:Int): Notification?{
        return _notifications.value.find {it.id==id}
    }

    fun createNotification(notification: Notification){
        _notifications.value += notification
    }
    fun editNotification(notification: Notification){
        val index = _notifications.value.indexOfFirst { it.id == notification.id }
        if(index != -1){
            _notifications.value = _notifications.value.toMutableList().apply {
                set(index,notification)
            }
        }
    }

    fun deleteNotification(notification: Notification){
        _notifications.value -= notification
    }

    private fun getNotificationList(): List<Notification>{
        return listOf(
            Notification(
                1,
                "Próximo concierto",
                "A Bogotá proximamente llegará Coldplay"
            ),
            Notification(
                2,
                "Próximo descuento",
                "Proximamente descuento por Navidad"
            )
            )
    }
}