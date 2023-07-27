package com.example.doctormobile.network

import com.example.doctormobile.model.Hospital
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/v1/8a0fe086-f5c6-40c1-95a3-ea6db9606cf5")
    fun getDoctorData(): Call<Hospital>

}