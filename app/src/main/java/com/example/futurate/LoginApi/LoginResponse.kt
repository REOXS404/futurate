package com.example.futurate.LoginApi

data class LoginResponse(
    val message: String,
    val user: User
)

data class User(
    val email: String,
    val name: String,
    val uname: String,
    val password: String,
    val createdAt: CreatedAt
)

data class CreatedAt(
    val seconds: Long,
    val nanoseconds: Long
)