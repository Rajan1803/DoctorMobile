package com.example.doctormobile.network

import com.example.doctormobile.model.Hospital
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/v1/d5329133-64bc-434f-b133-51556240f855")
    fun getDoctorData(): Call<Hospital>

}