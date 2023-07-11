package com.example.doctormobile.repository

import com.example.doctormobile.model.Hospital
import com.example.doctormobile.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoctorDataRepository {


    fun callApi(completionHandler: (Hospital?) -> Unit) {
        val hospitalApiService = ApiClient.hospitalApiService
        val call = hospitalApiService.getDoctorData()
        call.enqueue(object : Callback<Hospital> {
            override fun onResponse(call: Call<Hospital>, response: Response<Hospital>) {
                if (response.body() != null) {
                    completionHandler(response.body())
                }
            }

            override fun onFailure(call: Call<Hospital>, t: Throwable) {

            }
        })
    }
}