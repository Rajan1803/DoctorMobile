package com.example.doctormobile.network

import com.example.doctormobile.model.Hospital
import com.example.doctormobile.model.User
import com.example.doctormobile.model.UserResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.PUT

interface ApiService {

    @GET("/v1/d5329133-64bc-434f-b133-51556240f855")
    fun getDoctorData(): Call<Hospital>

    @PUT("api/users/2")
    fun putData(@Body user: User): Call<UserResponse>

    @PATCH("api/users/2")
    fun patchData(@Body user: User): Call<UserResponse>

}