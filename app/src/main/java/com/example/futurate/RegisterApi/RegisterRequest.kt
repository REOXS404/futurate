package com.example.futurate.RegisterApi

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val uname: String
)
