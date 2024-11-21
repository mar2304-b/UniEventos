package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unieventos2.models.Coupon
import com.example.unieventos2.models.Notification
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class CouponsViewModel : ViewModel() {
    val db = Firebase.firestore
    private val _coupons = MutableStateFlow(emptyList<Coupon>())
    val coupons: StateFlow<List<Coupon>> = _coupons.asStateFlow()

    init {
        loadCoupons()
    }

    private fun loadCoupons(){
        viewModelScope.launch {
            _coupons.value = getCouponList()
        }
    }

    suspend fun getCouponList(): List<Coupon> {
        val snapshot = db.collection("coupons").get().await()
        return snapshot.documents.mapNotNull {
            val coupon = it.toObject(Coupon::class.java)
            requireNotNull(coupon)
            coupon.id = it.id
            coupon
        }
    }

    suspend fun getCouponById(id: String): Coupon? {
        val snapshot = db.collection("coupons").document(id).get().await()
        val coupon = snapshot.toObject(Coupon::class.java)
        coupon?.id = snapshot.id
        return coupon
    }

    fun createCoupon(coupon: Coupon) {
        viewModelScope.launch {
            db.collection("coupons").add(coupon).await()
            loadCoupons()
        }
    }

    fun editCoupon(coupon: Coupon){
        viewModelScope.launch {
            db.collection("coupons").document(coupon.id).set(coupon).await()
            loadCoupons()
        }
    }

    fun deleteCoupon(coupon: Coupon){
        viewModelScope.launch {
            db.collection("coupons").document(coupon.id).delete().await()
            loadCoupons()
        }

    }
}