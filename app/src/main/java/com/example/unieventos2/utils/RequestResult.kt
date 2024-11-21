package com.example.unieventos2.utils

sealed class RequestResult {
    data object Loading : RequestResult()
    data class Succes(val message:String) : RequestResult()
    data class Error(val messageError: String) : RequestResult()

}