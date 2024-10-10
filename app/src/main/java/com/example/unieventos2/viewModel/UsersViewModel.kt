package com.example.unieventos2.viewModel

import androidx.lifecycle.ViewModel
import com.example.unieventos2.models.Role
import com.example.unieventos2.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UsersViewModel : ViewModel() {

    private val _users = MutableStateFlow(emptyList<User>())
    val users: StateFlow<List<User>> = _users.asStateFlow()

    init {
        _users.value = getUserList()
    }

    fun getUserById(id: Int): User? {
        return _users.value.find { it.id == id }
    }

    fun createUser(user: User) {
        _users.value += user
    }

    fun updateUser(user: User) {
        val index = _users.value.indexOfFirst { it.id == user.id }
        if (index != -1) {
            _users.value = _users.value.toMutableList().apply {
                set(index, user)
            }
        }
    }

    fun deleteUser(user: User) {
        _users.value -= user
    }

    fun login(email: String, password: String): User? {
        return _users.value.find { it.email == email && it.password == password }
    }

    private fun getUserList(): List<User> {
        return listOf(
            User(
                1,
                "Mariana",
                Role.ADMIN,
                "mariana@gmail.com",
                "mariana123",
                "cra 6",
                "314"
            ),
            User(
                2,
                "Manuela",
                Role.CLIENT,
                "manuela@gmail.com",
                "manuela123",
                "cra 8",
                "312"
            ),
        )
    }
}
