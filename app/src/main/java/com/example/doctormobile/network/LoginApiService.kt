package com.example.doctormobile.network

import com.example.doctormobile.model.LoginCredentials
import com.example.doctormobile.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {

    @POST("/auth/login")
    fun postLogin(@Body loginCredentials: LoginCredentials): Call<LoginResponse>
}