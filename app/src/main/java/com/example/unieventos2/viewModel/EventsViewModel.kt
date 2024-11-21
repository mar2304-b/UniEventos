package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unieventos2.models.Coupon
import com.example.unieventos2.models.Event
import com.example.unieventos2.models.Locality
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class EventsViewModel : ViewModel() {
    val db = Firebase.firestore
    private val _events = MutableStateFlow(emptyList<Event>())
    val events: StateFlow<List<Event>> = _events.asStateFlow()

    init {
        loadEvents()
    }
    private fun loadEvents(){
        viewModelScope.launch {
            _events.value = getEventList()
        }
    }

    suspend fun getEventById(id: String): Event? {
        val snapshot = db.collection("events").document(id).get().await()
        val event = snapshot.toObject(Event::class.java)
        event?.id = snapshot.id
        return event
    }

    fun createEvent(event: Event) {
        viewModelScope.launch {
            db.collection("events").add(event).await()
            loadEvents()
        }
    }

    fun editEvent(event: Event){
        viewModelScope.launch {
            db.collection("events").document(event.id).set(event).await()
            loadEvents()
        }
    }

    fun deleteEvent(event: Event){
        viewModelScope.launch {
            db.collection("events").document(event.id).delete().await()
            loadEvents()
        }
    }

    suspend fun getEventList(): List<Event> {
        val snapshot = db.collection("events").get().await()
        return snapshot.documents.mapNotNull {
            val event = it.toObject(Event::class.java)
            requireNotNull(event)
            event.id = it.id
            event
        }
    }
}