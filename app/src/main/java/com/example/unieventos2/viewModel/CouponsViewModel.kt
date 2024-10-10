package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import com.example.unieventos2.models.Coupon
import com.example.unieventos2.models.Notification
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CouponsViewModel : ViewModel() {
    private val _coupons = MutableStateFlow(emptyList<Coupon>())
    val coupons: StateFlow<List<Coupon>> = _coupons.asStateFlow()

    init {
        _coupons.value = getCouponList()
    }

    fun getCouponById(id: Int): Coupon? {
        return _coupons.value.find { it.id == id }
    }

    fun createCoupon(coupon: Coupon) {
        _coupons.value += coupon
    }

    fun editCoupon(coupon: Coupon) {
        val index = _coupons.value.indexOfFirst { it.id == coupon.id }
        if (index != -1) {
            _coupons.value = _coupons.value.toMutableList().apply {
                set(index, coupon)
            }
        }
    }

    fun deleteCoupon(coupon: Coupon) {
        _coupons.value -= coupon
    }

    private fun getCouponList(): List<Coupon> {
        return listOf(
            Coupon(
                1,
                "Registro por primera vez 15%",
                15,
                "12a"
            ),
            Coupon(
                2,
                "Primera commpra 10%",
                10,
                "23b"
            )
        )
    }
}