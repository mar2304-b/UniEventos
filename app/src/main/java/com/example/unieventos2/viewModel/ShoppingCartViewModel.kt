package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import com.example.unieventos2.models.CartItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShoppingCartViewModel: ViewModel() {
    private val _events = MutableStateFlow(emptyList<CartItem>())
    val events: StateFlow<List<CartItem>> = _events.asStateFlow()

    fun getCartItems(): List<CartItem> {
        return _events.value
    }
    fun addToCart(event: CartItem) {
        _events.value = _events.value.toMutableList().apply {
            add(event)
        }
    }
    fun updateEvent(event: CartItem) {
        _events.value = _events.value.toMutableList().apply {
            val index = indexOfFirst { it.id == event.id }
            if (index != -1) {
                set(index, event)
            }
        }
    }
    fun removeFromCart(event: CartItem) {
        _events.value = _events.value.toMutableList().apply {
            remove(event)
        }
    }
    fun clearCart() {
        _events.value = emptyList()
    }
    fun getCartSize(): Int{
        return _events.value.size
    }
    fun getTotal(): Double {
        return _events.value.sumOf { it.totalPrice*it.quantity}
    }
}