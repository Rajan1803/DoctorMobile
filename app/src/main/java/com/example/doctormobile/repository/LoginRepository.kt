package com.example.doctormobile.repository

import com.example.doctormobile.model.LoginCredentials
import com.example.doctormobile.model.LoginResponse
import com.example.doctormobile.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {


    fun postLoginData(username: String?, password: String?, responseBody: (LoginResponse?) -> Unit){
        val call = ApiClient.loginApiService.postLogin(LoginCredentials(username = username, password = password))
        call.enqueue(object: Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    responseBody(response.body())
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            }

        })
    }
}