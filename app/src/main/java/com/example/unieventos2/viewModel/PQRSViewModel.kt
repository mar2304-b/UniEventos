package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import com.example.unieventos2.models.PQRS
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PQRSViewModel: ViewModel() {
    private val _pqrs = MutableStateFlow(emptyList<PQRS>())
    val pqrs: StateFlow<List<PQRS>> = _pqrs.asStateFlow()

    init {
        _pqrs.value = getPQRSList()
    }

    fun getPQRSById(id:Int): PQRS?{
        return _pqrs.value.find {it.id==id}
    }

    fun createPQRS(pqrs: PQRS){
        _pqrs.value += pqrs
    }
    fun editPQRS(pqrs: PQRS){
        val index = _pqrs.value.indexOfFirst { it.id == pqrs.id }
        if(index != -1){
            _pqrs.value = _pqrs.value.toMutableList().apply {
                set(index,pqrs)
            }
        }
    }

    fun deletePQRS(pqrs: PQRS){
        _pqrs.value -= pqrs
    }

    private fun getPQRSList(): List<PQRS>{
        return listOf(
            PQRS(
                1,
                "Recomiendo la app, tienen buenos precios"
            )
        )
    }
}