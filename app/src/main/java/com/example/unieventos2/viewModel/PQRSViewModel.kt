package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unieventos2.models.Coupon
import com.example.unieventos2.models.Notification
import com.example.unieventos2.models.PQRS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class PQRSViewModel: ViewModel() {
    val db = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()
    private val _pqrs = MutableStateFlow(emptyList<PQRS>())
    val pqrs: StateFlow<List<PQRS>> = _pqrs.asStateFlow()

    init {
        loadPQRS()
    }
    private fun loadPQRS(){
        viewModelScope.launch {
            _pqrs.value = getPQRSList()
        }
    }

    fun getPQRS(): List<PQRS> {
        return _pqrs.value
    }

    suspend fun getPQRSById(id: String): PQRS? {
        val snapshot = db.collection("pqrs").document(id).get().await()
        val pqrs = snapshot.toObject(PQRS::class.java)
        pqrs?.id = snapshot.id
        return pqrs
    }

    fun createPQRS(pqrs: PQRS) {
        viewModelScope.launch {
            db.collection("pqrs").add(pqrs).await()
            loadPQRS()
        }
    }

    suspend fun getPQRSList(): List<PQRS> {
        val snapshot = db.collection("pqrs").get().await()
        return snapshot.documents.mapNotNull {
            val pqrs = it.toObject(PQRS::class.java)
            requireNotNull(pqrs)
            pqrs.id = it.id
            pqrs
        }
    }

}