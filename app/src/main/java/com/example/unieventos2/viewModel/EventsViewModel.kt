package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import com.example.unieventos2.models.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EventsViewModel: ViewModel() {
    private val _events = MutableStateFlow(emptyList<Event>())
    val events: StateFlow<List<Event>> = _events.asStateFlow()

    init {
        _events.value = getEventList()
    }

    fun getEventById(id:Int): Event?{
        return _events.value.find {it.id==id}
    }

    fun createEvent(event: Event){
        _events.value += event
    }
    fun editEvent(event: Event){
        val index = _events.value.indexOfFirst { it.id == event.id }
        if(index != -1){
            _events.value = _events.value.toMutableList().apply {
                set(index,event)
            }
        }
    }

    fun deleteEvent(event: Event){
        _events.value -= event
    }

    private fun getEventList(): List<Event>{
        return listOf(
            Event(
                 1,
                "Guns N' Roses",
                "Armenia",
                "20/12/2024",
                "Concierto de rock",
                "20/12/2024"
            ),
            Event(
                2,
                " XV Festival colombiano",
                "Armenia",
                "20/12/2024",
                "Festival cultural",
                "20/12/2024"
            ),
            Event(
                3,
                "Festival electronico",
                "Armenia",
                "20/12/2024",
                "Musica contemporanea",
                "20/12/2024"
            ),

        )
    }
}