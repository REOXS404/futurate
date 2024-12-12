package com.example.futurate.RegisterApi.Retrofit

import com.example.futurate.LoginApi.LoginRequest
import com.example.futurate.LoginApi.LoginResponse
import com.example.futurate.RegisterApi.RegisterRequest
import com.example.futurate.RegisterApi.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    fun register(@Body request: RegisterRequest): Call<ResponseRegister>

    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    companion object {
        fun create(): Any {

        }
    }
}